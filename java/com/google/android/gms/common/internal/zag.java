package com.google.android.gms.common.internal;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.internal.OnConnectionFailedListener;
import com.google.android.gms.common.internal.BaseGmsClient;

/* access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-base@@17.1.0 */
public final class zag implements BaseGmsClient.BaseOnConnectionFailedListener {
    private final /* synthetic */ OnConnectionFailedListener zapc;

    zag(OnConnectionFailedListener onConnectionFailedListener) {
        this.zapc = onConnectionFailedListener;
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseOnConnectionFailedListener
    public final void onConnectionFailed(ConnectionResult connectionResult) {
        this.zapc.onConnectionFailed(connectionResult);
    }
}
