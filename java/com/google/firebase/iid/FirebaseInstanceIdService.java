package com.google.firebase.iid;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

@Deprecated
/* compiled from: com.google.firebase:firebase-iid@@21.0.0 */
public class FirebaseInstanceIdService extends Service {
    public final IBinder onBind(Intent intent) {
        return null;
    }

    @Deprecated
    public void onTokenRefresh() {
    }
}
