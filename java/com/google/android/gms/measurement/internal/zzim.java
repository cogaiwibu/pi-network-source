package com.google.android.gms.measurement.internal;

/* access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
public final class zzim implements Runnable {
    private final /* synthetic */ long zza;
    private final /* synthetic */ zzii zzb;

    zzim(zzii zzii, long j) {
        this.zzb = zzii;
        this.zza = j;
    }

    public final void run() {
        this.zzb.zzd().zza(this.zza);
        this.zzb.zza = null;
    }
}
