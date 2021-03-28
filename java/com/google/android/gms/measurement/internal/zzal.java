package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
final class zzal implements Runnable {
    private final /* synthetic */ zzgt zza;
    private final /* synthetic */ zzai zzb;

    zzal(zzai zzai, zzgt zzgt) {
        this.zzb = zzai;
        this.zza = zzgt;
    }

    public final void run() {
        this.zza.zzt();
        if (zzw.zza()) {
            this.zza.zzp().zza(this);
            return;
        }
        boolean zzb2 = this.zzb.zzb();
        zzai.zza(this.zzb, 0);
        if (zzb2) {
            this.zzb.zza();
        }
    }
}
