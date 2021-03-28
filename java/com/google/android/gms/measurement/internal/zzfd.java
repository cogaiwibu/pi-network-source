package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
final class zzfd implements Runnable {
    private final /* synthetic */ boolean zza;
    private final /* synthetic */ zzfa zzb;

    zzfd(zzfa zzfa, boolean z) {
        this.zzb = zzfa;
        this.zza = z;
    }

    public final void run() {
        zzfa.zza(this.zzb).zza(this.zza);
    }
}
