package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;

/* access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
public class zzkj extends zzgr implements zzgt {
    protected final zzkl zza;

    zzkj(zzkl zzkl) {
        super(zzkl.zzu());
        Preconditions.checkNotNull(zzkl);
        this.zza = zzkl;
    }

    public zzfo zzj() {
        return this.zza.zzc();
    }

    public zzaf zzi() {
        return this.zza.zze();
    }

    public zzr zzh() {
        return this.zza.zzf();
    }

    public zzkr f_() {
        return this.zza.zzh();
    }

    public zzjr zzf() {
        return this.zza.zzi();
    }
}
