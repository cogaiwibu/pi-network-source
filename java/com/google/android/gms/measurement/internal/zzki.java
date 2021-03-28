package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
abstract class zzki extends zzkj {
    private boolean zzb;

    zzki(zzkl zzkl) {
        super(zzkl);
        this.zza.zza(this);
    }

    /* access modifiers changed from: protected */
    public abstract boolean zzd();

    /* access modifiers changed from: package-private */
    public final boolean zzai() {
        return this.zzb;
    }

    /* access modifiers changed from: protected */
    public final void zzaj() {
        if (!zzai()) {
            throw new IllegalStateException("Not initialized");
        }
    }

    public final void zzak() {
        if (!this.zzb) {
            zzd();
            this.zza.zzs();
            this.zzb = true;
            return;
        }
        throw new IllegalStateException("Can't initialize twice");
    }
}
