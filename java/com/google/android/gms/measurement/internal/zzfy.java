package com.google.android.gms.measurement.internal;

import android.os.Bundle;

/* compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
final /* synthetic */ class zzfy implements Runnable {
    private final zzfz zza;
    private final zzn zzb;
    private final Bundle zzc;

    zzfy(zzfz zzfz, zzn zzn, Bundle bundle) {
        this.zza = zzfz;
        this.zzb = zzn;
        this.zzc = bundle;
    }

    public final void run() {
        this.zza.zza(this.zzb, this.zzc);
    }
}
