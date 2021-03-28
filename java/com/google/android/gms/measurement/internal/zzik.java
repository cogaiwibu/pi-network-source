package com.google.android.gms.measurement.internal;

import android.os.Bundle;

/* access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
public final class zzik implements Runnable {
    private final /* synthetic */ zzij zza;
    private final /* synthetic */ zzij zzb;
    private final /* synthetic */ long zzc;
    private final /* synthetic */ boolean zzd;
    private final /* synthetic */ zzii zze;

    zzik(zzii zzii, zzij zzij, zzij zzij2, long j, boolean z) {
        this.zze = zzii;
        this.zza = zzij;
        this.zzb = zzij2;
        this.zzc = j;
        this.zzd = z;
    }

    public final void run() {
        this.zze.zza((zzii) this.zza, this.zzb, (zzij) this.zzc, (long) this.zzd, (boolean) ((Bundle) null));
    }
}
