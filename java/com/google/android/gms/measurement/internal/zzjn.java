package com.google.android.gms.measurement.internal;

import android.content.ComponentName;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
final class zzjn implements Runnable {
    private final /* synthetic */ ComponentName zza;
    private final /* synthetic */ zzjl zzb;

    zzjn(zzjl zzjl, ComponentName componentName) {
        this.zzb = zzjl;
        this.zza = componentName;
    }

    public final void run() {
        this.zzb.zza.zza((zzir) this.zza);
    }
}
