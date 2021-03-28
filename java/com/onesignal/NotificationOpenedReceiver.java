package com.onesignal;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class NotificationOpenedReceiver extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        NotificationOpenedProcessor.processFromContext(context, intent);
    }
}
