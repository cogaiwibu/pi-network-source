package com.google.android.gms.measurement.internal;

import android.app.job.JobParameters;

/* access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
public final /* synthetic */ class zzjs implements Runnable {
    private final zzjq zza;
    private final zzeq zzb;
    private final JobParameters zzc;

    zzjs(zzjq zzjq, zzeq zzeq, JobParameters jobParameters) {
        this.zza = zzjq;
        this.zzb = zzeq;
        this.zzc = jobParameters;
    }

    public final void run() {
        this.zza.zza(this.zzb, this.zzc);
    }
}
