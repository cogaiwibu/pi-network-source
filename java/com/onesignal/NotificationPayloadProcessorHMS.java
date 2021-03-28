package com.onesignal;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* access modifiers changed from: package-private */
public class NotificationPayloadProcessorHMS {
    NotificationPayloadProcessorHMS() {
    }

    static void handleHMSNotificationOpenIntent(Activity activity, Intent intent) {
        JSONObject covertHMSOpenIntentToJson;
        OneSignal.setAppContext(activity);
        if (intent != null && (covertHMSOpenIntentToJson = covertHMSOpenIntentToJson(intent)) != null) {
            handleProcessJsonOpenData(activity, covertHMSOpenIntentToJson);
        }
    }

    private static JSONObject covertHMSOpenIntentToJson(Intent intent) {
        if (!OSNotificationFormatHelper.isOneSignalIntent(intent)) {
            return null;
        }
        JSONObject bundleAsJSONObject = NotificationBundleProcessor.bundleAsJSONObject(intent.getExtras());
        reformatButtonClickAction(bundleAsJSONObject);
        return bundleAsJSONObject;
    }

    private static void reformatButtonClickAction(JSONObject jSONObject) {
        try {
            String str = (String) NotificationBundleProcessor.getCustomJSONObject(jSONObject).remove(GenerateNotification.BUNDLE_KEY_ACTION_ID);
            if (str != null) {
                jSONObject.put(GenerateNotification.BUNDLE_KEY_ACTION_ID, str);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private static void handleProcessJsonOpenData(Activity activity, JSONObject jSONObject) {
        if (!NotificationOpenedProcessor.handleIAMPreviewOpen(activity, jSONObject)) {
            OneSignal.handleNotificationOpen(activity, new JSONArray().put(jSONObject), false, OSNotificationFormatHelper.getOSNotificationIdFromJson(jSONObject));
        }
    }

    public static void processDataMessageReceived(Context context, String str) {
        Bundle jsonStringToBundle;
        OneSignal.setAppContext(context);
        if (str != null && (jsonStringToBundle = OSUtils.jsonStringToBundle(str)) != null && !NotificationBundleProcessor.processBundleFromReceiver(context, jsonStringToBundle).processed()) {
            GcmBroadcastReceiver.startGCMService(context, jsonStringToBundle);
        }
    }
}
