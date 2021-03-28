package com.google.android.gms.common.api.internal;

import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;

/* compiled from: com.google.android.gms:play-services-base@@17.1.0 */
final class zaar implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener {
    private final /* synthetic */ zaak zafz;

    private zaar(zaak zaak) {
        this.zafz = zaak;
    }

    @Override // com.google.android.gms.common.api.internal.ConnectionCallbacks
    public final void onConnectionSuspended(int i) {
    }

    @Override // com.google.android.gms.common.api.internal.ConnectionCallbacks
    public final void onConnected(Bundle bundle) {
        if (this.zafz.zafa.isSignInClientDisconnectFixEnabled()) {
            this.zafz.zaer.lock();
            try {
                if (this.zafz.zagf != null) {
                    this.zafz.zagf.zaa(new zaap(this.zafz));
                    this.zafz.zaer.unlock();
                }
            } finally {
                this.zafz.zaer.unlock();
            }
        } else {
            this.zafz.zagf.zaa(new zaap(this.zafz));
        }
    }

    @Override // com.google.android.gms.common.api.internal.OnConnectionFailedListener
    public final void onConnectionFailed(ConnectionResult connectionResult) {
        this.zafz.zaer.lock();
        try {
            if (this.zafz.zad(connectionResult)) {
                this.zafz.zaap();
                this.zafz.zaan();
            } else {
                this.zafz.zae((zaak) connectionResult);
            }
        } finally {
            this.zafz.zaer.unlock();
        }
    }

    /* synthetic */ zaar(zaak zaak, zaaj zaaj) {
        this(zaak);
    }
}
