package com.google.android.gms.common.api.internal;

import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.internal.GoogleApiManager;

/* compiled from: com.google.android.gms:play-services-base@@17.1.0 */
final class zabo implements Runnable {
    private final /* synthetic */ ConnectionResult zajc;
    private final /* synthetic */ GoogleApiManager.zab zajk;

    zabo(GoogleApiManager.zab zab, ConnectionResult connectionResult) {
        this.zajk = zab;
        this.zajc = connectionResult;
    }

    public final void run() {
        GoogleApiManager.zaa zaa = (GoogleApiManager.zaa) GoogleApiManager.this.zaim.get(this.zajk.zaft);
        if (zaa != null) {
            if (this.zajc.isSuccess()) {
                this.zajk.zajg = true;
                if (this.zajk.zais.requiresSignIn()) {
                    this.zajk.zabp();
                    return;
                }
                try {
                    this.zajk.zais.getRemoteService(null, this.zajk.zais.getScopesForConnectionlessNonSignIn());
                } catch (SecurityException e) {
                    Log.e("GoogleApiManager", "Failed to get service from broker. ", e);
                    zaa.onConnectionFailed(new ConnectionResult(10));
                }
            } else {
                zaa.onConnectionFailed(this.zajc);
            }
        }
    }
}
