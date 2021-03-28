package com.google.android.gms.internal.measurement;

import java.util.Iterator;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
final class zzfq<K> extends zzfg<K> {
    private final transient zzfc<K, ?> zza;
    private final transient zzfb<K> zzb;

    zzfq(zzfc<K, ?> zzfc, zzfb<K> zzfb) {
        this.zza = zzfc;
        this.zzb = zzfb;
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.measurement.zzey
    public final boolean zzf() {
        return true;
    }

    @Override // com.google.android.gms.internal.measurement.zzey
    public final zzfx<K> zza() {
        return (zzfx) zze().iterator();
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.measurement.zzey
    public final int zza(Object[] objArr, int i) {
        return zze().zza(objArr, i);
    }

    @Override // com.google.android.gms.internal.measurement.zzey, com.google.android.gms.internal.measurement.zzfg
    public final zzfb<K> zze() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.measurement.zzey
    public final boolean contains(@NullableDecl Object obj) {
        return this.zza.get(obj) != null;
    }

    public final int size() {
        return this.zza.size();
    }

    @Override // com.google.android.gms.internal.measurement.zzey, com.google.android.gms.internal.measurement.zzfg, java.util.AbstractCollection, java.util.Collection, java.util.Set, java.lang.Iterable
    public final /* synthetic */ Iterator iterator() {
        return iterator();
    }
}
