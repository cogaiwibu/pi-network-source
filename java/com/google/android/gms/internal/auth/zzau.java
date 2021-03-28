package com.google.android.gms.internal.auth;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;

final class zzau extends zzaq {
    zzau(zzar zzar, GoogleApiClient googleApiClient) {
        super(googleApiClient);
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.auth.zzaq
    public final void zza(Context context, zzan zzan) throws RemoteException {
        zzan.zza(new zzav(this));
    }
}
