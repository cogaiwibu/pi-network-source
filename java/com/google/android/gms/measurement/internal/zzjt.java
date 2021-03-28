package com.google.android.gms.measurement.internal;

import android.content.Intent;

/* access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
public final /* synthetic */ class zzjt implements Runnable {
    private final zzjq zza;
    private final int zzb;
    private final zzeq zzc;
    private final Intent zzd;

    zzjt(zzjq zzjq, int i, zzeq zzeq, Intent intent) {
        this.zza = zzjq;
        this.zzb = i;
        this.zzc = zzeq;
        this.zzd = intent;
    }

    public final void run() {
        this.zza.zza(this.zzb, this.zzc, this.zzd);
    }
}
