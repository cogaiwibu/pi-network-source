package com.google.android.gms.internal.measurement;

import java.util.List;

/* access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
public final class zzfd extends zzfb<E> {
    private final transient int zza;
    private final transient int zzb;
    private final /* synthetic */ zzfb zzc;

    zzfd(zzfb zzfb, int i, int i2) {
        this.zzc = zzfb;
        this.zza = i;
        this.zzb = i2;
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.measurement.zzey
    public final boolean zzf() {
        return true;
    }

    public final int size() {
        return this.zzb;
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.measurement.zzey
    public final Object[] zzb() {
        return this.zzc.zzb();
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.measurement.zzey
    public final int zzc() {
        return this.zzc.zzc() + this.zza;
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.measurement.zzey
    public final int zzd() {
        return this.zzc.zzc() + this.zza + this.zzb;
    }

    @Override // java.util.List
    public final E get(int i) {
        zzeb.zza(i, this.zzb);
        return (E) this.zzc.get(i + this.zza);
    }

    @Override // com.google.android.gms.internal.measurement.zzfb
    public final zzfb<E> zza(int i, int i2) {
        zzeb.zza(i, i2, this.zzb);
        zzfb zzfb = this.zzc;
        int i3 = this.zza;
        return (zzfb) zzfb.subList(i + i3, i2 + i3);
    }

    @Override // java.util.List, com.google.android.gms.internal.measurement.zzfb
    public final /* synthetic */ List subList(int i, int i2) {
        return subList(i, i2);
    }
}
