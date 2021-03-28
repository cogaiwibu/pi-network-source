package com.google.android.gms.internal.measurement;

import java.util.AbstractMap;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
final class zzfr extends zzfb<Map.Entry<K, V>> {
    private final /* synthetic */ zzfo zza;

    zzfr(zzfo zzfo) {
        this.zza = zzfo;
    }

    @Override // com.google.android.gms.internal.measurement.zzey
    public final boolean zzf() {
        return true;
    }

    public final int size() {
        return zzfo.zza(this.zza);
    }

    @Override // java.util.List
    public final /* synthetic */ Object get(int i) {
        zzeb.zza(i, zzfo.zza(this.zza));
        int i2 = i * 2;
        return new AbstractMap.SimpleImmutableEntry(zzfo.zzb(this.zza)[i2], zzfo.zzb(this.zza)[i2 + 1]);
    }
}
