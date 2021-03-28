package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;

/* compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
final class zzgb implements Runnable {
    private final /* synthetic */ zzn zza;
    private final /* synthetic */ zzfz zzb;

    zzgb(zzfz zzfz, zzn zzn) {
        this.zzb = zzfz;
        this.zza = zzn;
    }

    public final void run() {
        this.zzb.zza.zzr();
        zzkl zzkl = this.zzb.zza;
        zzn zzn = this.zza;
        zzkl.zzp().zzc();
        zzkl.zzn();
        Preconditions.checkNotEmpty(zzn.zza);
        zzkl.zzc(zzn);
    }
}
