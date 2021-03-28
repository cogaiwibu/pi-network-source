package com.onesignal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.os.IBinder;
import androidx.core.app.NotificationCompat;
import com.onesignal.OneSignal;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class NotificationExtenderService extends JobIntentService {
    static final int EXTENDER_SERVICE_JOB_ID = 2071862121;
    private OverrideSettings currentBaseOverrideSettings = null;
    private JSONObject currentJsonPayload;
    private boolean currentlyRestoring;
    private OSNotificationDisplayedResult osNotificationDisplayedResult;
    private Long restoreTimestamp;

    /* access modifiers changed from: protected */
    public abstract boolean onNotificationProcessing(OSNotificationReceivedResult oSNotificationReceivedResult);

    @Override // com.onesignal.JobIntentService
    public /* bridge */ /* synthetic */ boolean isStopped() {
        return super.isStopped();
    }

    @Override // com.onesignal.JobIntentService
    public /* bridge */ /* synthetic */ IBinder onBind(Intent intent) {
        return super.onBind(intent);
    }

    @Override // com.onesignal.JobIntentService
    public /* bridge */ /* synthetic */ void onCreate() {
        super.onCreate();
    }

    @Override // com.onesignal.JobIntentService
    public /* bridge */ /* synthetic */ void onDestroy() {
        super.onDestroy();
    }

    @Override // com.onesignal.JobIntentService
    public /* bridge */ /* synthetic */ int onStartCommand(Intent intent, int i, int i2) {
        return super.onStartCommand(intent, i, i2);
    }

    @Override // com.onesignal.JobIntentService
    public /* bridge */ /* synthetic */ boolean onStopCurrentWork() {
        return super.onStopCurrentWork();
    }

    @Override // com.onesignal.JobIntentService
    public /* bridge */ /* synthetic */ void setInterruptIfStopped(boolean z) {
        super.setInterruptIfStopped(z);
    }

    public static class OverrideSettings {
        public Integer androidNotificationId;
        public NotificationCompat.Extender extender;

        /* access modifiers changed from: package-private */
        public void override(OverrideSettings overrideSettings) {
            Integer num;
            if (overrideSettings != null && (num = overrideSettings.androidNotificationId) != null) {
                this.androidNotificationId = num;
            }
        }
    }

    /* access modifiers changed from: protected */
    public final OSNotificationDisplayedResult displayNotification(OverrideSettings overrideSettings) {
        if (this.osNotificationDisplayedResult != null || overrideSettings == null) {
            return null;
        }
        overrideSettings.override(this.currentBaseOverrideSettings);
        this.osNotificationDisplayedResult = new OSNotificationDisplayedResult();
        NotificationGenerationJob createNotifJobFromCurrent = createNotifJobFromCurrent();
        createNotifJobFromCurrent.overrideSettings = overrideSettings;
        this.osNotificationDisplayedResult.androidNotificationId = NotificationBundleProcessor.ProcessJobForDisplay(createNotifJobFromCurrent);
        return this.osNotificationDisplayedResult;
    }

    /* access modifiers changed from: protected */
    @Override // com.onesignal.JobIntentService
    public final void onHandleWork(Intent intent) {
        if (intent != null) {
            processIntent(intent);
            GcmBroadcastReceiver.completeWakefulIntent(intent);
        }
    }

    private void processIntent(Intent intent) {
        Bundle extras = intent.getExtras();
        if (extras == null) {
            OneSignal.LOG_LEVEL log_level = OneSignal.LOG_LEVEL.ERROR;
            OneSignal.Log(log_level, "No extras sent to NotificationExtenderService in its Intent!\n" + intent);
            return;
        }
        String string = extras.getString("json_payload");
        if (string == null) {
            OneSignal.LOG_LEVEL log_level2 = OneSignal.LOG_LEVEL.ERROR;
            OneSignal.Log(log_level2, "json_payload key is nonexistent from bundle passed to NotificationExtenderService: " + extras);
            return;
        }
        try {
            this.currentJsonPayload = new JSONObject(string);
            this.currentlyRestoring = extras.getBoolean("restoring", false);
            if (extras.containsKey("android_notif_id")) {
                OverrideSettings overrideSettings = new OverrideSettings();
                this.currentBaseOverrideSettings = overrideSettings;
                overrideSettings.androidNotificationId = Integer.valueOf(extras.getInt("android_notif_id"));
            }
            if (this.currentlyRestoring || !OneSignal.notValidOrDuplicated(this, this.currentJsonPayload)) {
                this.restoreTimestamp = Long.valueOf(extras.getLong("timestamp"));
                processJsonObject(this.currentJsonPayload, this.currentlyRestoring);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    /* access modifiers changed from: package-private */
    public void processJsonObject(JSONObject jSONObject, boolean z) {
        boolean z2;
        OSNotificationReceivedResult oSNotificationReceivedResult = new OSNotificationReceivedResult();
        oSNotificationReceivedResult.payload = NotificationBundleProcessor.OSNotificationPayloadFrom(jSONObject);
        oSNotificationReceivedResult.restoring = z;
        oSNotificationReceivedResult.isAppInFocus = OneSignal.isAppActive();
        this.osNotificationDisplayedResult = null;
        try {
            z2 = onNotificationProcessing(oSNotificationReceivedResult);
        } catch (Throwable th) {
            if (this.osNotificationDisplayedResult == null) {
                OneSignal.Log(OneSignal.LOG_LEVEL.ERROR, "onNotificationProcessing throw an exception. Displaying normal OneSignal notification.", th);
            } else {
                OneSignal.Log(OneSignal.LOG_LEVEL.ERROR, "onNotificationProcessing throw an exception. Extended notification displayed but custom processing did not finish.", th);
            }
            z2 = false;
        }
        if (this.osNotificationDisplayedResult == null) {
            if (!z2 && NotificationBundleProcessor.shouldDisplay(jSONObject.optString("alert"))) {
                NotificationBundleProcessor.ProcessJobForDisplay(createNotifJobFromCurrent());
            } else if (!z) {
                NotificationGenerationJob notificationGenerationJob = new NotificationGenerationJob(this);
                notificationGenerationJob.jsonPayload = jSONObject;
                notificationGenerationJob.overrideSettings = new OverrideSettings();
                notificationGenerationJob.overrideSettings.androidNotificationId = -1;
                NotificationBundleProcessor.processNotification(notificationGenerationJob, true);
                OneSignal.handleNotificationReceived(NotificationBundleProcessor.newJsonArray(jSONObject), false, false);
            } else if (this.currentBaseOverrideSettings != null) {
                NotificationBundleProcessor.markRestoredNotificationAsDismissed(createNotifJobFromCurrent());
            }
            if (z) {
                OSUtils.sleep(100);
            }
        }
    }

    static Intent getIntent(Context context) {
        PackageManager packageManager = context.getPackageManager();
        Intent intent = new Intent().setAction("com.onesignal.NotificationExtender").setPackage(context.getPackageName());
        List<ResolveInfo> queryIntentServices = packageManager.queryIntentServices(intent, 128);
        if (queryIntentServices.size() < 1) {
            return null;
        }
        intent.setComponent(new ComponentName(context, queryIntentServices.get(0).serviceInfo.name));
        return intent;
    }

    private NotificationGenerationJob createNotifJobFromCurrent() {
        NotificationGenerationJob notificationGenerationJob = new NotificationGenerationJob(this);
        notificationGenerationJob.restoring = this.currentlyRestoring;
        notificationGenerationJob.jsonPayload = this.currentJsonPayload;
        notificationGenerationJob.shownTimeStamp = this.restoreTimestamp;
        notificationGenerationJob.overrideSettings = this.currentBaseOverrideSettings;
        return notificationGenerationJob;
    }
}
