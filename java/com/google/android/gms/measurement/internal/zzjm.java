package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
final class zzjm implements Runnable {
    private final /* synthetic */ zzei zza;
    private final /* synthetic */ zzjl zzb;

    zzjm(zzjl zzjl, zzei zzei) {
        this.zzb = zzjl;
        this.zza = zzei;
    }

    public final void run() {
        synchronized (this.zzb) {
            this.zzb.zzb = false;
            if (!this.zzb.zza.zzaa()) {
                this.zzb.zza.zzq().zzv().zza("Connected to remote service");
                this.zzb.zza.zza(this.zza);
            }
        }
    }
}
