package com.google.android.gms.measurement.internal;

/* access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
public final class zzkk implements Runnable {
    private final /* synthetic */ zzks zza;
    private final /* synthetic */ zzkl zzb;

    zzkk(zzkl zzkl, zzks zzks) {
        this.zzb = zzkl;
        this.zza = zzks;
    }

    public final void run() {
        this.zzb.zza((zzkl) this.zza);
        this.zzb.zza();
    }
}
