package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.internal.measurement.zzag;

/* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@18.0.0 */
final class zzbc extends zzag.zzb {
    private final /* synthetic */ Bundle zzc;
    private final /* synthetic */ zzt zzd;
    private final /* synthetic */ zzag zze;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzbc(zzag zzag, Bundle bundle, zzt zzt) {
        super(zzag);
        this.zze = zzag;
        this.zzc = bundle;
        this.zzd = zzt;
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.measurement.zzag.zzb
    public final void zza() throws RemoteException {
        zzag.zzc(this.zze).performAction(this.zzc, this.zzd, this.zza);
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.measurement.zzag.zzb
    public final void zzb() {
        this.zzd.zza((Bundle) null);
    }
}
