package com.google.android.gms.measurement.internal;

/* access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
public final class zzhx implements Runnable {
    private final /* synthetic */ zzac zza;
    private final /* synthetic */ long zzb;
    private final /* synthetic */ int zzc;
    private final /* synthetic */ long zzd;
    private final /* synthetic */ boolean zze;
    private final /* synthetic */ zzhb zzf;

    zzhx(zzhb zzhb, zzac zzac, long j, int i, long j2, boolean z) {
        this.zzf = zzhb;
        this.zza = zzac;
        this.zzb = j;
        this.zzc = i;
        this.zzd = j2;
        this.zze = z;
    }

    public final void run() {
        this.zzf.zza(this.zza);
        this.zzf.zza(this.zzb, false);
        this.zzf.zza((zzhb) this.zza, (zzac) this.zzc, (int) this.zzd, 1L, this.zze);
    }
}
