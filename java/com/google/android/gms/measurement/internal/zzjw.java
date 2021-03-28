package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
final class zzjw implements Runnable {
    private final /* synthetic */ long zza;
    private final /* synthetic */ zzjx zzb;

    zzjw(zzjx zzjx, long j) {
        this.zzb = zzjx;
        this.zza = j;
    }

    public final void run() {
        this.zzb.zzb((zzjx) this.zza);
    }
}
