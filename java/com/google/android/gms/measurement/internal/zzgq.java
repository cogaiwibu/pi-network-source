package com.google.android.gms.measurement.internal;

/* access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
public abstract class zzgq extends zzgr {
    private boolean zza;

    zzgq(zzfu zzfu) {
        super(zzfu);
        this.zzy.zza(this);
    }

    /* access modifiers changed from: protected */
    public void g_() {
    }

    /* access modifiers changed from: protected */
    public abstract boolean zzd();

    /* access modifiers changed from: package-private */
    public final boolean zzaa() {
        return this.zza;
    }

    /* access modifiers changed from: protected */
    public final void zzab() {
        if (!zzaa()) {
            throw new IllegalStateException("Not initialized");
        }
    }

    public final void zzac() {
        if (this.zza) {
            throw new IllegalStateException("Can't initialize twice");
        } else if (!zzd()) {
            this.zzy.zzae();
            this.zza = true;
        }
    }

    public final void zzad() {
        if (!this.zza) {
            g_();
            this.zzy.zzae();
            this.zza = true;
            return;
        }
        throw new IllegalStateException("Can't initialize twice");
    }
}
