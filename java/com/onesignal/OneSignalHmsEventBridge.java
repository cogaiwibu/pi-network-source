package com.onesignal;

import android.content.Context;
import com.huawei.hms.push.RemoteMessage;
import com.onesignal.OneSignal;

public class OneSignalHmsEventBridge {
    public static void onNewToken(Context context, String str) {
        OneSignal.LOG_LEVEL log_level = OneSignal.LOG_LEVEL.INFO;
        OneSignal.Log(log_level, "HmsMessageServiceOneSignal.onNewToken - HMS token: " + str);
        PushRegistratorHMS.fireCallback(str);
    }

    public static void onMessageReceived(Context context, RemoteMessage remoteMessage) {
        NotificationPayloadProcessorHMS.processDataMessageReceived(context, remoteMessage.getData());
    }
}
