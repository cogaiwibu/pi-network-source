package com.google.android.gms.measurement.internal;

import android.os.Bundle;

/* compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
final class zzkq implements Runnable {
    private final /* synthetic */ String zza;
    private final /* synthetic */ Bundle zzb;
    private final /* synthetic */ zzko zzc;

    zzkq(zzko zzko, String str, Bundle bundle) {
        this.zzc = zzko;
        this.zza = str;
        this.zzb = bundle;
    }

    public final void run() {
        this.zzc.zza.zza(this.zzc.zza.zzk().zza(this.zza, "_err", this.zzb, "auto", this.zzc.zza.zzl().currentTimeMillis(), false, false, false), this.zza);
    }
}
