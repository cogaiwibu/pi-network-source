package com.google.android.gms.measurement.internal;

import android.content.Context;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;

/* access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
public class zzgr implements zzgt {
    protected final zzfu zzy;

    zzgr(zzfu zzfu) {
        Preconditions.checkNotNull(zzfu);
        this.zzy = zzfu;
    }

    @Override // com.google.android.gms.measurement.internal.zzgt
    public zzw zzt() {
        return this.zzy.zzt();
    }

    public zzab zzs() {
        return this.zzy.zza();
    }

    public zzfc zzr() {
        return this.zzy.zzb();
    }

    @Override // com.google.android.gms.measurement.internal.zzgt
    public zzeq zzq() {
        return this.zzy.zzq();
    }

    @Override // com.google.android.gms.measurement.internal.zzgt
    public zzfr zzp() {
        return this.zzy.zzp();
    }

    public zzkv zzo() {
        return this.zzy.zzh();
    }

    public zzeo zzn() {
        return this.zzy.zzi();
    }

    @Override // com.google.android.gms.measurement.internal.zzgt
    public Context zzm() {
        return this.zzy.zzm();
    }

    @Override // com.google.android.gms.measurement.internal.zzgt
    public Clock zzl() {
        return this.zzy.zzl();
    }

    public zzak zzk() {
        return this.zzy.zzw();
    }

    public void zzc() {
        this.zzy.zzp().zzc();
    }

    public void zzb() {
        this.zzy.zzp().zzb();
    }

    public void zza() {
        this.zzy.zzad();
    }
}
