package com.onesignal;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.amazon.device.messaging.ADMMessageHandlerBase;
import com.amazon.device.messaging.ADMMessageReceiver;
import com.onesignal.OneSignal;

public class ADMMessageHandler extends ADMMessageHandlerBase {

    public static class Receiver extends ADMMessageReceiver {
        public Receiver() {
            super(ADMMessageHandler.class);
        }
    }

    public ADMMessageHandler() {
        super("ADMMessageHandler");
    }

    /* access modifiers changed from: protected */
    public void onMessage(Intent intent) {
        Context applicationContext = getApplicationContext();
        Bundle extras = intent.getExtras();
        if (!NotificationBundleProcessor.processBundleFromReceiver(applicationContext, extras).processed()) {
            NotificationGenerationJob notificationGenerationJob = new NotificationGenerationJob(applicationContext);
            notificationGenerationJob.jsonPayload = NotificationBundleProcessor.bundleAsJSONObject(extras);
            NotificationBundleProcessor.ProcessJobForDisplay(notificationGenerationJob);
        }
    }

    /* access modifiers changed from: protected */
    public void onRegistered(String str) {
        OneSignal.LOG_LEVEL log_level = OneSignal.LOG_LEVEL.INFO;
        OneSignal.Log(log_level, "ADM registration ID: " + str);
        PushRegistratorADM.fireCallback(str);
    }

    /* access modifiers changed from: protected */
    public void onRegistrationError(String str) {
        OneSignal.LOG_LEVEL log_level = OneSignal.LOG_LEVEL.ERROR;
        OneSignal.Log(log_level, "ADM:onRegistrationError: " + str);
        if ("INVALID_SENDER".equals(str)) {
            OneSignal.Log(OneSignal.LOG_LEVEL.ERROR, "Please double check that you have a matching package name (NOTE: Case Sensitive), api_key.txt, and the apk was signed with the same Keystore and Alias.");
        }
        PushRegistratorADM.fireCallback(null);
    }

    /* access modifiers changed from: protected */
    public void onUnregistered(String str) {
        OneSignal.LOG_LEVEL log_level = OneSignal.LOG_LEVEL.INFO;
        OneSignal.Log(log_level, "ADM:onUnregistered: " + str);
    }
}
