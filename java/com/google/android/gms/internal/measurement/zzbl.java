package com.google.android.gms.internal.measurement;

import android.os.RemoteException;
import com.google.android.gms.internal.measurement.zzag;

/* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@18.0.0 */
final class zzbl extends zzag.zzb {
    private final /* synthetic */ zzag.zzd zzc;
    private final /* synthetic */ zzag zzd;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzbl(zzag zzag, zzag.zzd zzd2) {
        super(zzag);
        this.zzd = zzag;
        this.zzc = zzd2;
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.measurement.zzag.zzb
    public final void zza() throws RemoteException {
        zzag.zzc(this.zzd).registerOnMeasurementEventListener(this.zzc);
    }
}
