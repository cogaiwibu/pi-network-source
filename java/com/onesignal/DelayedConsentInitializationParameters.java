package com.onesignal;

import android.content.Context;
import com.onesignal.OneSignal;

/* access modifiers changed from: package-private */
public class DelayedConsentInitializationParameters {
    public String appId;
    public Context context;
    public String googleProjectNumber;
    public OneSignal.NotificationOpenedHandler openedHandler;
    public OneSignal.NotificationReceivedHandler receivedHandler;

    DelayedConsentInitializationParameters(Context context2, String str, String str2, OneSignal.NotificationOpenedHandler notificationOpenedHandler, OneSignal.NotificationReceivedHandler notificationReceivedHandler) {
        this.context = context2;
        this.googleProjectNumber = str;
        this.appId = str2;
        this.openedHandler = notificationOpenedHandler;
        this.receivedHandler = notificationReceivedHandler;
    }
}
