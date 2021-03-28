package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
final class zzjk implements Runnable {
    private final /* synthetic */ zzei zza;
    private final /* synthetic */ zzjl zzb;

    zzjk(zzjl zzjl, zzei zzei) {
        this.zzb = zzjl;
        this.zza = zzei;
    }

    public final void run() {
        synchronized (this.zzb) {
            this.zzb.zzb = false;
            if (!this.zzb.zza.zzaa()) {
                this.zzb.zza.zzq().zzw().zza("Connected to service");
                this.zzb.zza.zza(this.zza);
            }
        }
    }
}
