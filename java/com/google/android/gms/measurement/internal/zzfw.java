package com.google.android.gms.measurement.internal;

/* access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
public final class zzfw implements Runnable {
    private final /* synthetic */ zzgy zza;
    private final /* synthetic */ zzfu zzb;

    zzfw(zzfu zzfu, zzgy zzgy) {
        this.zzb = zzfu;
        this.zza = zzgy;
    }

    public final void run() {
        this.zzb.zza((zzfu) this.zza);
        this.zzb.zza(this.zza.zzg);
    }
}
