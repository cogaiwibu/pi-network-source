package com.onesignal;

import android.app.IntentService;
import android.content.Intent;
import androidx.legacy.content.WakefulBroadcastReceiver;

public class NotificationRestoreService extends IntentService {
    public NotificationRestoreService() {
        super("NotificationRestoreService");
    }

    /* access modifiers changed from: protected */
    public void onHandleIntent(Intent intent) {
        if (intent != null) {
            Thread.currentThread().setPriority(10);
            OneSignal.setAppContext(this);
            NotificationRestorer.restore(this);
            WakefulBroadcastReceiver.completeWakefulIntent(intent);
        }
    }
}
