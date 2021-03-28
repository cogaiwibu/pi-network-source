package com.google.android.gms.measurement.internal;

/* access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
public final class zzip implements Runnable {
    private final /* synthetic */ zzij zza;
    private final /* synthetic */ long zzb;
    private final /* synthetic */ zzii zzc;

    zzip(zzii zzii, zzij zzij, long j) {
        this.zzc = zzii;
        this.zza = zzij;
        this.zzb = j;
    }

    public final void run() {
        this.zzc.zza((zzii) this.zza, (zzij) false, (boolean) this.zzb);
        this.zzc.zza = null;
        this.zzc.zzg().zza((zzij) null);
    }
}
