package com.onesignal;

import com.huawei.hms.push.HmsMessageService;
import com.huawei.hms.push.RemoteMessage;

public class HmsMessageServiceOneSignal extends HmsMessageService {
    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.onesignal.HmsMessageServiceOneSignal */
    /* JADX WARN: Multi-variable type inference failed */
    public void onNewToken(String str) {
        OneSignalHmsEventBridge.onNewToken(this, str);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.onesignal.HmsMessageServiceOneSignal */
    /* JADX WARN: Multi-variable type inference failed */
    public void onMessageReceived(RemoteMessage remoteMessage) {
        OneSignalHmsEventBridge.onMessageReceived(this, remoteMessage);
    }
}
