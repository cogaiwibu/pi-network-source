package com.google.android.gms.measurement.internal;

import android.os.Bundle;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
final /* synthetic */ class zzka implements Runnable {
    private final zzkb zza;

    zzka(zzkb zzkb) {
        this.zza = zzkb;
    }

    public final void run() {
        zzkb zzkb = this.zza;
        zzjy zzjy = zzkb.zzc;
        long j = zzkb.zza;
        long j2 = zzkb.zzb;
        zzjy.zza.zzc();
        zzjy.zza.zzq().zzv().zza("Application going to the background");
        boolean z = true;
        if (zzjy.zza.zzs().zza(zzas.zzbu)) {
            zzjy.zza.zzr().zzr.zza(true);
        }
        Bundle bundle = new Bundle();
        if (!zzjy.zza.zzs().zzh().booleanValue()) {
            zzjy.zza.zzb.zzb(j2);
            if (zzjy.zza.zzs().zza(zzas.zzbl)) {
                bundle.putLong("_et", zzjy.zza.zza(j2));
                zzii.zza(zzjy.zza.zzh().zza(true), bundle, true);
            } else {
                z = false;
            }
            zzjy.zza.zza(false, z, j2);
        }
        zzjy.zza.zze().zza("auto", "_ab", j, bundle);
    }
}
