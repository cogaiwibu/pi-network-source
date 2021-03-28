package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
final class zzkg extends zzai {
    private final /* synthetic */ zzkl zza;
    private final /* synthetic */ zzkh zzb;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzkg(zzkh zzkh, zzgt zzgt, zzkl zzkl) {
        super(zzgt);
        this.zzb = zzkh;
        this.zza = zzkl;
    }

    @Override // com.google.android.gms.measurement.internal.zzai
    public final void zza() {
        this.zzb.zze();
        this.zzb.zzq().zzw().zza("Starting upload from DelayedRunnable");
        this.zza.zzo();
    }
}
