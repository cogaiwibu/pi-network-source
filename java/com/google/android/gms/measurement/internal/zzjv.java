package com.google.android.gms.measurement.internal;

/* access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
public final class zzjv implements Runnable {
    private final /* synthetic */ zzkl zza;
    private final /* synthetic */ Runnable zzb;

    zzjv(zzjq zzjq, zzkl zzkl, Runnable runnable) {
        this.zza = zzkl;
        this.zzb = runnable;
    }

    public final void run() {
        this.zza.zzr();
        this.zza.zza(this.zzb);
        this.zza.zzo();
    }
}
