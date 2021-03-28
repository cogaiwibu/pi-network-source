package com.google.android.gms.measurement.internal;

import android.os.Bundle;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
final /* synthetic */ class zzha implements Runnable {
    private final zzhb zza;
    private final Bundle zzb;

    zzha(zzhb zzhb, Bundle bundle) {
        this.zza = zzhb;
        this.zzb = bundle;
    }

    public final void run() {
        this.zza.zzb(this.zzb);
    }
}
