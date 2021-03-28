package com.google.android.gms.internal.measurement;

import java.util.Iterator;
import java.util.Map;

public final class zzfo<K, V> extends zzfg<Map.Entry<K, V>> {
    private final transient zzfc<K, V> zza;
    private final transient Object[] zzb;
    private final transient int zzc = 0;
    private final transient int zzd;

    zzfo(zzfc<K, V> zzfc, Object[] objArr, int i, int i2) {
        this.zza = zzfc;
        this.zzb = objArr;
        this.zzd = i2;
    }

    @Override // com.google.android.gms.internal.measurement.zzey
    public final boolean zzf() {
        return true;
    }

    @Override // com.google.android.gms.internal.measurement.zzey
    public final zzfx<Map.Entry<K, V>> zza() {
        return (zzfx) zze().iterator();
    }

    @Override // com.google.android.gms.internal.measurement.zzey
    public final int zza(Object[] objArr, int i) {
        return zze().zza(objArr, i);
    }

    @Override // com.google.android.gms.internal.measurement.zzfg
    public final zzfb<Map.Entry<K, V>> zzh() {
        return new zzfr(this);
    }

    @Override // com.google.android.gms.internal.measurement.zzey
    public final boolean contains(Object obj) {
        if (obj instanceof Map.Entry) {
            Map.Entry entry = (Map.Entry) obj;
            Object key = entry.getKey();
            Object value = entry.getValue();
            if (value == null || !value.equals(this.zza.get(key))) {
                return false;
            }
            return true;
        }
        return false;
    }

    public final int size() {
        return this.zzd;
    }

    @Override // com.google.android.gms.internal.measurement.zzey, com.google.android.gms.internal.measurement.zzfg, java.util.AbstractCollection, java.util.Collection, java.util.Set, java.lang.Iterable
    public final /* synthetic */ Iterator iterator() {
        return iterator();
    }
}
