package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
final class zzgn implements Runnable {
    private final /* synthetic */ zzku zza;
    private final /* synthetic */ zzn zzb;
    private final /* synthetic */ zzfz zzc;

    zzgn(zzfz zzfz, zzku zzku, zzn zzn) {
        this.zzc = zzfz;
        this.zza = zzku;
        this.zzb = zzn;
    }

    public final void run() {
        this.zzc.zza.zzr();
        if (this.zza.zza() == null) {
            this.zzc.zza.zzb(this.zza, this.zzb);
        } else {
            this.zzc.zza.zza(this.zza, this.zzb);
        }
    }
}
