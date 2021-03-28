package com.google.android.gms.auth.api.signin.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;

/* compiled from: com.google.android.gms:play-services-auth@@19.0.0 */
final class zzm extends zzc {
    private final /* synthetic */ zzj zzco;

    zzm(zzj zzj) {
        this.zzco = zzj;
    }

    @Override // com.google.android.gms.auth.api.signin.internal.zzr, com.google.android.gms.auth.api.signin.internal.zzc
    public final void zze(Status status) throws RemoteException {
        this.zzco.setResult((Result) status);
    }
}
