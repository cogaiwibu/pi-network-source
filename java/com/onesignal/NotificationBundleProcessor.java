package com.onesignal;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import com.anythink.reactnativejs.utils.Const;
import com.facebook.appevents.AppEventsConstants;
import com.google.firebase.messaging.Constants;
import com.onesignal.NotificationExtenderService;
import com.onesignal.OSNotificationPayload;
import com.onesignal.OneSignal;
import com.onesignal.OneSignalDbContract;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* access modifiers changed from: package-private */
public class NotificationBundleProcessor {
    static final String DEFAULT_ACTION = "__DEFAULT__";
    private static final String IAM_PREVIEW_KEY = "os_in_app_message_preview_id";
    public static final String PUSH_ADDITIONAL_DATA_KEY = "a";
    public static final String PUSH_MINIFIED_BUTTONS_LIST = "o";
    public static final String PUSH_MINIFIED_BUTTON_ICON = "p";
    public static final String PUSH_MINIFIED_BUTTON_ID = "i";
    public static final String PUSH_MINIFIED_BUTTON_TEXT = "n";

    NotificationBundleProcessor() {
    }

    static void ProcessFromGCMIntentService(Context context, BundleCompat bundleCompat, NotificationExtenderService.OverrideSettings overrideSettings) {
        OneSignal.setAppContext(context);
        try {
            String string = bundleCompat.getString("json_payload");
            if (string == null) {
                OneSignal.LOG_LEVEL log_level = OneSignal.LOG_LEVEL.ERROR;
                OneSignal.Log(log_level, "json_payload key is nonexistent from mBundle passed to ProcessFromGCMIntentService: " + bundleCompat);
                return;
            }
            NotificationGenerationJob notificationGenerationJob = new NotificationGenerationJob(context);
            boolean z = false;
            notificationGenerationJob.restoring = bundleCompat.getBoolean("restoring", false);
            notificationGenerationJob.shownTimeStamp = bundleCompat.getLong("timestamp");
            notificationGenerationJob.jsonPayload = new JSONObject(string);
            if (inAppPreviewPushUUID(notificationGenerationJob.jsonPayload) != null) {
                z = true;
            }
            notificationGenerationJob.isInAppPreviewPush = z;
            if (notificationGenerationJob.restoring || notificationGenerationJob.isInAppPreviewPush || !OneSignal.notValidOrDuplicated(context, notificationGenerationJob.jsonPayload)) {
                if (bundleCompat.containsKey("android_notif_id")) {
                    if (overrideSettings == null) {
                        overrideSettings = new NotificationExtenderService.OverrideSettings();
                    }
                    overrideSettings.androidNotificationId = bundleCompat.getInt("android_notif_id");
                }
                notificationGenerationJob.overrideSettings = overrideSettings;
                ProcessJobForDisplay(notificationGenerationJob);
                if (notificationGenerationJob.restoring) {
                    OSUtils.sleep(100);
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    static int ProcessJobForDisplay(NotificationGenerationJob notificationGenerationJob) {
        notificationGenerationJob.showAsAlert = OneSignal.getInAppAlertNotificationEnabled() && OneSignal.isAppActive();
        processCollapseKey(notificationGenerationJob);
        if (shouldDisplayNotif(notificationGenerationJob)) {
            GenerateNotification.fromJsonPayload(notificationGenerationJob);
        }
        if (!notificationGenerationJob.restoring && !notificationGenerationJob.isInAppPreviewPush) {
            processNotification(notificationGenerationJob, false);
            try {
                JSONObject jSONObject = new JSONObject(notificationGenerationJob.jsonPayload.toString());
                jSONObject.put(GenerateNotification.BUNDLE_KEY_ANDROID_NOTIFICATION_ID, notificationGenerationJob.getAndroidId());
                OneSignal.handleNotificationReceived(newJsonArray(jSONObject), true, notificationGenerationJob.showAsAlert);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return notificationGenerationJob.getAndroidId().intValue();
    }

    private static boolean shouldDisplayNotif(NotificationGenerationJob notificationGenerationJob) {
        if (notificationGenerationJob.isInAppPreviewPush && Build.VERSION.SDK_INT <= 18) {
            return false;
        }
        if (notificationGenerationJob.hasExtender() || shouldDisplay(notificationGenerationJob.jsonPayload.optString("alert"))) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: private */
    public static JSONArray bundleAsJsonArray(Bundle bundle) {
        JSONArray jSONArray = new JSONArray();
        jSONArray.put(bundleAsJSONObject(bundle));
        return jSONArray;
    }

    private static void saveAndProcessNotification(Context context, Bundle bundle, boolean z, int i) {
        NotificationGenerationJob notificationGenerationJob = new NotificationGenerationJob(context);
        notificationGenerationJob.jsonPayload = bundleAsJSONObject(bundle);
        notificationGenerationJob.overrideSettings = new NotificationExtenderService.OverrideSettings();
        notificationGenerationJob.overrideSettings.androidNotificationId = Integer.valueOf(i);
        processNotification(notificationGenerationJob, z);
    }

    static void processNotification(NotificationGenerationJob notificationGenerationJob, boolean z) {
        saveNotification(notificationGenerationJob, z);
        if (notificationGenerationJob.isNotificationToDisplay()) {
            String apiNotificationId = notificationGenerationJob.getApiNotificationId();
            OneSignal.getSessionManager().onNotificationReceived(apiNotificationId);
            OSReceiveReceiptController.getInstance().sendReceiveReceipt(apiNotificationId);
        }
    }

    private static void saveNotification(NotificationGenerationJob notificationGenerationJob, boolean z) {
        Context context = notificationGenerationJob.context;
        JSONObject jSONObject = notificationGenerationJob.jsonPayload;
        try {
            JSONObject customJSONObject = getCustomJSONObject(notificationGenerationJob.jsonPayload);
            OneSignalDbHelper instance = OneSignalDbHelper.getInstance(notificationGenerationJob.context);
            int i = 1;
            if (notificationGenerationJob.isNotificationToDisplay()) {
                ContentValues contentValues = new ContentValues();
                contentValues.put("dismissed", (Integer) 1);
                instance.update(OneSignalDbContract.NotificationTable.TABLE_NAME, contentValues, "android_notification_id = " + notificationGenerationJob.getAndroidIdWithoutCreate(), null);
                BadgeCountUpdater.update(instance, context);
            }
            ContentValues contentValues2 = new ContentValues();
            contentValues2.put("notification_id", customJSONObject.optString("i"));
            if (jSONObject.has("grp")) {
                contentValues2.put("group_id", jSONObject.optString("grp"));
            }
            if (jSONObject.has(Constants.MessagePayloadKeys.COLLAPSE_KEY) && !"do_not_collapse".equals(jSONObject.optString(Constants.MessagePayloadKeys.COLLAPSE_KEY))) {
                contentValues2.put(OneSignalDbContract.NotificationTable.COLUMN_NAME_COLLAPSE_ID, jSONObject.optString(Constants.MessagePayloadKeys.COLLAPSE_KEY));
            }
            if (!z) {
                i = 0;
            }
            contentValues2.put(OneSignalDbContract.NotificationTable.COLUMN_NAME_OPENED, Integer.valueOf(i));
            if (!z) {
                contentValues2.put(OneSignalDbContract.NotificationTable.COLUMN_NAME_ANDROID_NOTIFICATION_ID, Integer.valueOf(notificationGenerationJob.getAndroidIdWithoutCreate()));
            }
            if (notificationGenerationJob.getTitle() != null) {
                contentValues2.put("title", notificationGenerationJob.getTitle().toString());
            }
            if (notificationGenerationJob.getBody() != null) {
                contentValues2.put("message", notificationGenerationJob.getBody().toString());
            }
            contentValues2.put(OneSignalDbContract.NotificationTable.COLUMN_NAME_EXPIRE_TIME, Long.valueOf((jSONObject.optLong(Constants.MessagePayloadKeys.SENT_TIME, SystemClock.currentThreadTimeMillis()) / 1000) + ((long) jSONObject.optInt(Constants.MessagePayloadKeys.TTL, 259200))));
            contentValues2.put(OneSignalDbContract.NotificationTable.COLUMN_NAME_FULL_DATA, jSONObject.toString());
            instance.insertOrThrow(OneSignalDbContract.NotificationTable.TABLE_NAME, null, contentValues2);
            if (!z) {
                BadgeCountUpdater.update(instance, context);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    static void markRestoredNotificationAsDismissed(NotificationGenerationJob notificationGenerationJob) {
        if (notificationGenerationJob.getAndroidIdWithoutCreate() != -1) {
            OneSignalDbHelper instance = OneSignalDbHelper.getInstance(notificationGenerationJob.context);
            ContentValues contentValues = new ContentValues();
            contentValues.put("dismissed", (Integer) 1);
            instance.update(OneSignalDbContract.NotificationTable.TABLE_NAME, contentValues, "android_notification_id = " + notificationGenerationJob.getAndroidIdWithoutCreate(), null);
            BadgeCountUpdater.update(instance, notificationGenerationJob.context);
        }
    }

    static JSONObject bundleAsJSONObject(Bundle bundle) {
        JSONObject jSONObject = new JSONObject();
        for (String str : bundle.keySet()) {
            try {
                jSONObject.put(str, bundle.get(str));
            } catch (JSONException e) {
                OneSignal.LOG_LEVEL log_level = OneSignal.LOG_LEVEL.ERROR;
                OneSignal.Log(log_level, "bundleAsJSONObject error for key: " + str, e);
            }
        }
        return jSONObject;
    }

    private static void unMinifyButtonsFromBundle(Bundle bundle) {
        JSONObject jSONObject;
        String str;
        if (bundle.containsKey(PUSH_MINIFIED_BUTTONS_LIST)) {
            try {
                JSONObject jSONObject2 = new JSONObject(bundle.getString(OSNotificationFormatHelper.PAYLOAD_OS_ROOT_CUSTOM));
                if (jSONObject2.has(PUSH_ADDITIONAL_DATA_KEY)) {
                    jSONObject = jSONObject2.getJSONObject(PUSH_ADDITIONAL_DATA_KEY);
                } else {
                    jSONObject = new JSONObject();
                }
                JSONArray jSONArray = new JSONArray(bundle.getString(PUSH_MINIFIED_BUTTONS_LIST));
                bundle.remove(PUSH_MINIFIED_BUTTONS_LIST);
                for (int i = 0; i < jSONArray.length(); i++) {
                    JSONObject jSONObject3 = jSONArray.getJSONObject(i);
                    String string = jSONObject3.getString("n");
                    jSONObject3.remove("n");
                    if (jSONObject3.has("i")) {
                        str = jSONObject3.getString("i");
                        jSONObject3.remove("i");
                    } else {
                        str = string;
                    }
                    jSONObject3.put("id", str);
                    jSONObject3.put("text", string);
                    if (jSONObject3.has(PUSH_MINIFIED_BUTTON_ICON)) {
                        jSONObject3.put(Const.icon, jSONObject3.getString(PUSH_MINIFIED_BUTTON_ICON));
                        jSONObject3.remove(PUSH_MINIFIED_BUTTON_ICON);
                    }
                }
                jSONObject.put("actionButtons", jSONArray);
                jSONObject.put(GenerateNotification.BUNDLE_KEY_ACTION_ID, DEFAULT_ACTION);
                if (!jSONObject2.has(PUSH_ADDITIONAL_DATA_KEY)) {
                    jSONObject2.put(PUSH_ADDITIONAL_DATA_KEY, jSONObject);
                }
                bundle.putString(OSNotificationFormatHelper.PAYLOAD_OS_ROOT_CUSTOM, jSONObject2.toString());
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    static OSNotificationPayload OSNotificationPayloadFrom(JSONObject jSONObject) {
        OSNotificationPayload oSNotificationPayload = new OSNotificationPayload();
        try {
            JSONObject customJSONObject = getCustomJSONObject(jSONObject);
            oSNotificationPayload.notificationID = customJSONObject.optString("i");
            oSNotificationPayload.templateId = customJSONObject.optString("ti");
            oSNotificationPayload.templateName = customJSONObject.optString("tn");
            oSNotificationPayload.rawPayload = jSONObject.toString();
            oSNotificationPayload.additionalData = customJSONObject.optJSONObject(PUSH_ADDITIONAL_DATA_KEY);
            oSNotificationPayload.launchURL = customJSONObject.optString("u", null);
            oSNotificationPayload.body = jSONObject.optString("alert", null);
            oSNotificationPayload.title = jSONObject.optString("title", null);
            oSNotificationPayload.smallIcon = jSONObject.optString("sicon", null);
            oSNotificationPayload.bigPicture = jSONObject.optString("bicon", null);
            oSNotificationPayload.largeIcon = jSONObject.optString("licon", null);
            oSNotificationPayload.sound = jSONObject.optString("sound", null);
            oSNotificationPayload.groupKey = jSONObject.optString("grp", null);
            oSNotificationPayload.groupMessage = jSONObject.optString("grp_msg", null);
            oSNotificationPayload.smallIconAccentColor = jSONObject.optString("bgac", null);
            oSNotificationPayload.ledColor = jSONObject.optString("ledc", null);
            String optString = jSONObject.optString("vis", null);
            if (optString != null) {
                oSNotificationPayload.lockScreenVisibility = Integer.parseInt(optString);
            }
            oSNotificationPayload.fromProjectNumber = jSONObject.optString(Constants.MessagePayloadKeys.FROM, null);
            oSNotificationPayload.priority = jSONObject.optInt("pri", 0);
            String optString2 = jSONObject.optString(Constants.MessagePayloadKeys.COLLAPSE_KEY, null);
            if (!"do_not_collapse".equals(optString2)) {
                oSNotificationPayload.collapseId = optString2;
            }
            try {
                setActionButtons(oSNotificationPayload);
            } catch (Throwable th) {
                OneSignal.Log(OneSignal.LOG_LEVEL.ERROR, "Error assigning OSNotificationPayload.actionButtons values!", th);
            }
            try {
                setBackgroundImageLayout(oSNotificationPayload, jSONObject);
            } catch (Throwable th2) {
                OneSignal.Log(OneSignal.LOG_LEVEL.ERROR, "Error assigning OSNotificationPayload.backgroundImageLayout values!", th2);
            }
        } catch (JSONException e) {
            OneSignal.Log(OneSignal.LOG_LEVEL.ERROR, "Error assigning OSNotificationPayload values!", e);
        }
        return oSNotificationPayload;
    }

    private static void setActionButtons(OSNotificationPayload oSNotificationPayload) throws Throwable {
        if (oSNotificationPayload.additionalData != null && oSNotificationPayload.additionalData.has("actionButtons")) {
            JSONArray jSONArray = oSNotificationPayload.additionalData.getJSONArray("actionButtons");
            oSNotificationPayload.actionButtons = new ArrayList();
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                OSNotificationPayload.ActionButton actionButton = new OSNotificationPayload.ActionButton();
                actionButton.id = jSONObject.optString("id", null);
                actionButton.text = jSONObject.optString("text", null);
                actionButton.icon = jSONObject.optString(Const.icon, null);
                oSNotificationPayload.actionButtons.add(actionButton);
            }
            oSNotificationPayload.additionalData.remove(GenerateNotification.BUNDLE_KEY_ACTION_ID);
            oSNotificationPayload.additionalData.remove("actionButtons");
        }
    }

    private static void setBackgroundImageLayout(OSNotificationPayload oSNotificationPayload, JSONObject jSONObject) throws Throwable {
        String optString = jSONObject.optString("bg_img", null);
        if (optString != null) {
            JSONObject jSONObject2 = new JSONObject(optString);
            oSNotificationPayload.backgroundImageLayout = new OSNotificationPayload.BackgroundImageLayout();
            oSNotificationPayload.backgroundImageLayout.image = jSONObject2.optString("img");
            oSNotificationPayload.backgroundImageLayout.titleTextColor = jSONObject2.optString("tc");
            oSNotificationPayload.backgroundImageLayout.bodyTextColor = jSONObject2.optString("bc");
        }
    }

    private static void processCollapseKey(NotificationGenerationJob notificationGenerationJob) {
        if (!notificationGenerationJob.restoring && notificationGenerationJob.jsonPayload.has(Constants.MessagePayloadKeys.COLLAPSE_KEY) && !"do_not_collapse".equals(notificationGenerationJob.jsonPayload.optString(Constants.MessagePayloadKeys.COLLAPSE_KEY))) {
            String optString = notificationGenerationJob.jsonPayload.optString(Constants.MessagePayloadKeys.COLLAPSE_KEY);
            Cursor query = OneSignalDbHelper.getInstance(notificationGenerationJob.context).query(OneSignalDbContract.NotificationTable.TABLE_NAME, new String[]{OneSignalDbContract.NotificationTable.COLUMN_NAME_ANDROID_NOTIFICATION_ID}, "collapse_id = ? AND dismissed = 0 AND opened = 0 ", new String[]{optString}, null, null, null);
            if (query.moveToFirst()) {
                notificationGenerationJob.setAndroidIdWithOutOverriding(Integer.valueOf(query.getInt(query.getColumnIndex(OneSignalDbContract.NotificationTable.COLUMN_NAME_ANDROID_NOTIFICATION_ID))));
            }
            query.close();
        }
    }

    static ProcessedBundleResult processBundleFromReceiver(Context context, final Bundle bundle) {
        ProcessedBundleResult processedBundleResult = new ProcessedBundleResult();
        if (!OSNotificationFormatHelper.isOneSignalBundle(bundle)) {
            return processedBundleResult;
        }
        processedBundleResult.isOneSignalPayload = true;
        unMinifyButtonsFromBundle(bundle);
        JSONObject bundleAsJSONObject = bundleAsJSONObject(bundle);
        String inAppPreviewPushUUID = inAppPreviewPushUUID(bundleAsJSONObject);
        if (inAppPreviewPushUUID != null) {
            if (OneSignal.isAppActive()) {
                processedBundleResult.inAppPreviewShown = true;
                OneSignal.getInAppMessageController().displayPreviewMessage(inAppPreviewPushUUID);
            }
            return processedBundleResult;
        } else if (startExtenderService(context, bundle, processedBundleResult)) {
            return processedBundleResult;
        } else {
            processedBundleResult.isDup = OneSignal.notValidOrDuplicated(context, bundleAsJSONObject);
            if (!processedBundleResult.isDup && !shouldDisplay(bundle.getString("alert"))) {
                saveAndProcessNotification(context, bundle, true, -1);
                new Thread(new Runnable() {
                    /* class com.onesignal.NotificationBundleProcessor.AnonymousClass1 */

                    public void run() {
                        OneSignal.handleNotificationReceived(NotificationBundleProcessor.bundleAsJsonArray(bundle), false, false);
                    }
                }, "OS_PROC_BUNDLE").start();
            }
            return processedBundleResult;
        }
    }

    static String inAppPreviewPushUUID(JSONObject jSONObject) {
        try {
            JSONObject customJSONObject = getCustomJSONObject(jSONObject);
            if (!customJSONObject.has(PUSH_ADDITIONAL_DATA_KEY)) {
                return null;
            }
            JSONObject optJSONObject = customJSONObject.optJSONObject(PUSH_ADDITIONAL_DATA_KEY);
            if (optJSONObject.has(IAM_PREVIEW_KEY)) {
                return optJSONObject.optString(IAM_PREVIEW_KEY);
            }
            return null;
        } catch (JSONException unused) {
        }
    }

    private static boolean startExtenderService(Context context, Bundle bundle, ProcessedBundleResult processedBundleResult) {
        Intent intent = NotificationExtenderService.getIntent(context);
        boolean z = false;
        if (intent == null) {
            return false;
        }
        intent.putExtra("json_payload", bundleAsJSONObject(bundle).toString());
        intent.putExtra("timestamp", System.currentTimeMillis() / 1000);
        if (Integer.parseInt(bundle.getString("pri", AppEventsConstants.EVENT_PARAM_VALUE_NO)) > 9) {
            z = true;
        }
        if (Build.VERSION.SDK_INT >= 21) {
            NotificationExtenderService.enqueueWork(context, intent.getComponent(), 2071862121, intent, z);
        } else {
            context.startService(intent);
        }
        processedBundleResult.hasExtenderService = true;
        return true;
    }

    static boolean shouldDisplay(String str) {
        boolean z = str != null && !"".equals(str);
        boolean inAppAlertNotificationEnabled = OneSignal.getInAppAlertNotificationEnabled();
        boolean isAppActive = OneSignal.isAppActive();
        if (!z || (!OneSignal.getNotificationsWhenActiveEnabled() && !inAppAlertNotificationEnabled && isAppActive)) {
            return false;
        }
        return true;
    }

    static JSONArray newJsonArray(JSONObject jSONObject) {
        return new JSONArray().put(jSONObject);
    }

    static JSONObject getCustomJSONObject(JSONObject jSONObject) throws JSONException {
        return new JSONObject(jSONObject.optString(OSNotificationFormatHelper.PAYLOAD_OS_ROOT_CUSTOM));
    }

    static boolean hasRemoteResource(Bundle bundle) {
        return isBuildKeyRemote(bundle, "licon") || isBuildKeyRemote(bundle, "bicon") || bundle.getString("bg_img", null) != null;
    }

    private static boolean isBuildKeyRemote(Bundle bundle, String str) {
        String trim = bundle.getString(str, "").trim();
        return trim.startsWith("http://") || trim.startsWith("https://");
    }

    /* access modifiers changed from: package-private */
    public static class ProcessedBundleResult {
        boolean hasExtenderService;
        boolean inAppPreviewShown;
        boolean isDup;
        boolean isOneSignalPayload;

        ProcessedBundleResult() {
        }

        /* access modifiers changed from: package-private */
        public boolean processed() {
            return !this.isOneSignalPayload || this.hasExtenderService || this.isDup || this.inAppPreviewShown;
        }
    }
}
