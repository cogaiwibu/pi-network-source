package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
final class zzgi implements Runnable {
    private final /* synthetic */ zzaq zza;
    private final /* synthetic */ zzn zzb;
    private final /* synthetic */ zzfz zzc;

    zzgi(zzfz zzfz, zzaq zzaq, zzn zzn) {
        this.zzc = zzfz;
        this.zza = zzaq;
        this.zzb = zzn;
    }

    public final void run() {
        zzaq zzb2 = this.zzc.zzb(this.zza, this.zzb);
        this.zzc.zza.zzr();
        this.zzc.zza.zza(zzb2, this.zzb);
    }
}
