package com.google.android.gms.measurement.internal;

import android.content.ComponentName;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
final class zzjp implements Runnable {
    private final /* synthetic */ zzjl zza;

    zzjp(zzjl zzjl) {
        this.zza = zzjl;
    }

    public final void run() {
        this.zza.zza.zza((zzir) new ComponentName(this.zza.zza.zzm(), "com.google.android.gms.measurement.AppMeasurementService"));
    }
}
