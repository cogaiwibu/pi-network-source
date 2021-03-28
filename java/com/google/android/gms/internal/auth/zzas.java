package com.google.android.gms.internal.auth;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.auth.api.proxy.ProxyRequest;
import com.google.android.gms.common.api.GoogleApiClient;

final class zzas extends zzap {
    private final /* synthetic */ ProxyRequest zzce;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzas(zzar zzar, GoogleApiClient googleApiClient, ProxyRequest proxyRequest) {
        super(googleApiClient);
        this.zzce = proxyRequest;
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.auth.zzap
    public final void zza(Context context, zzan zzan) throws RemoteException {
        zzan.zza(new zzat(this), this.zzce);
    }
}
