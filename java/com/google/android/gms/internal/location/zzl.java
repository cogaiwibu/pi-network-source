package com.google.android.gms.internal.location;

import android.os.DeadObjectException;

/* access modifiers changed from: package-private */
public final class zzl implements zzbj<zzao> {
    private final /* synthetic */ zzk zzcc;

    zzl(zzk zzk) {
        this.zzcc = zzk;
    }

    @Override // com.google.android.gms.internal.location.zzbj
    public final void checkConnected() {
        this.zzcc.checkConnected();
    }

    /* Return type fixed from 'android.os.IInterface' to match base method */
    @Override // com.google.android.gms.internal.location.zzbj
    public final /* synthetic */ zzao getService() throws DeadObjectException {
        return (zzao) this.zzcc.getService();
    }
}
