package com.google.android.gms.measurement.internal;

/* access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
public final class zzhw implements Runnable {
    private final /* synthetic */ zzac zza;
    private final /* synthetic */ int zzb;
    private final /* synthetic */ long zzc;
    private final /* synthetic */ boolean zzd;
    private final /* synthetic */ zzhb zze;

    zzhw(zzhb zzhb, zzac zzac, int i, long j, boolean z) {
        this.zze = zzhb;
        this.zza = zzac;
        this.zzb = i;
        this.zzc = j;
        this.zzd = z;
    }

    public final void run() {
        this.zze.zza(this.zza);
        this.zze.zza((zzhb) this.zza, (zzac) this.zzb, (int) this.zzc, 0L, this.zzd);
    }
}
