package com.google.android.gms.internal.measurement;

import java.io.Serializable;
import java.util.AbstractMap;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public final class zzem<K, V> extends AbstractMap<K, V> implements Serializable {
    private static final Object zzd = new Object();
    transient int[] zza;
    transient Object[] zzb;
    transient Object[] zzc;
    private transient Object zze;
    private transient int zzf = zzfz.zza(3, 1, 1073741823);
    private transient int zzg;
    private transient Set<K> zzh;
    private transient Set<Map.Entry<K, V>> zzi;
    private transient Collection<V> zzj;

    zzem() {
        zzeb.zza(true, (Object) "Expected size must be >= 0");
    }

    static int zzb(int i, int i2) {
        return i - 1;
    }

    public final boolean zza() {
        return this.zze == null;
    }

    public final Map<K, V> zzb() {
        Object obj = this.zze;
        if (obj instanceof Map) {
            return (Map) obj;
        }
        return null;
    }

    private final void zzb(int i) {
        this.zzf = zzex.zza(this.zzf, 32 - Integer.numberOfLeadingZeros(i), 31);
    }

    /* access modifiers changed from: public */
    private final int zzi() {
        return (1 << (this.zzf & 31)) - 1;
    }

    public final void zzc() {
        this.zzf += 32;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v4, resolved type: java.util.LinkedHashMap */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractMap, java.util.Map
    public final V put(K k, V v) {
        int min;
        if (zza()) {
            zzeb.zzb(zza(), "Arrays already allocated");
            int i = this.zzf;
            int max = Math.max(i + 1, 2);
            int highestOneBit = Integer.highestOneBit(max);
            double d = (double) highestOneBit;
            Double.isNaN(d);
            int max2 = Math.max(4, (max <= ((int) (d * 1.0d)) || (highestOneBit = highestOneBit << 1) > 0) ? highestOneBit : 1073741824);
            this.zze = zzex.zza(max2);
            zzb(max2 - 1);
            this.zza = new int[i];
            this.zzb = new Object[i];
            this.zzc = new Object[i];
        }
        Map<K, V> zzb2 = zzb();
        if (zzb2 != null) {
            return zzb2.put(k, v);
        }
        int[] iArr = this.zza;
        Object[] objArr = this.zzb;
        Object[] objArr2 = this.zzc;
        int i2 = this.zzg;
        int i3 = i2 + 1;
        int zza2 = zzez.zza(k);
        int zzi2 = zzi();
        int i4 = zza2 & zzi2;
        int zza3 = zzex.zza(this.zze, i4);
        if (zza3 != 0) {
            int i5 = zzi2 ^ -1;
            int i6 = zza2 & i5;
            int i7 = 0;
            while (true) {
                int i8 = zza3 - 1;
                int i9 = iArr[i8];
                if ((i9 & i5) != i6 || !zzdz.zza(k, objArr[i8])) {
                    int i10 = i9 & zzi2;
                    int i11 = i7 + 1;
                    if (i10 != 0) {
                        i7 = i11;
                        zza3 = i10;
                        objArr = objArr;
                    } else if (i11 >= 9) {
                        LinkedHashMap linkedHashMap = new LinkedHashMap(zzi() + 1, 1.0f);
                        int zzd2 = zzd();
                        while (zzd2 >= 0) {
                            linkedHashMap.put(this.zzb[zzd2], this.zzc[zzd2]);
                            zzd2 = zza(zzd2);
                        }
                        this.zze = linkedHashMap;
                        this.zza = null;
                        this.zzb = null;
                        this.zzc = null;
                        zzc();
                        return (V) linkedHashMap.put(k, v);
                    } else if (i3 > zzi2) {
                        zzi2 = zza(zzi2, zzex.zzb(zzi2), zza2, i2);
                    } else {
                        iArr[i8] = zzex.zza(i9, i3, zzi2);
                    }
                } else {
                    V v2 = (V) objArr2[i8];
                    objArr2[i8] = v;
                    return v2;
                }
            }
        } else if (i3 > zzi2) {
            zzi2 = zza(zzi2, zzex.zzb(zzi2), zza2, i2);
        } else {
            zzex.zza(this.zze, i4, i3);
        }
        int length = this.zza.length;
        if (i3 > length && (min = Math.min(1073741823, 1 | (Math.max(1, length >>> 1) + length))) != length) {
            this.zza = Arrays.copyOf(this.zza, min);
            this.zzb = Arrays.copyOf(this.zzb, min);
            this.zzc = Arrays.copyOf(this.zzc, min);
        }
        this.zza[i2] = zzex.zza(zza2, 0, zzi2);
        this.zzb[i2] = k;
        this.zzc[i2] = v;
        this.zzg = i3;
        zzc();
        return null;
    }

    private final int zza(int i, int i2, int i3, int i4) {
        Object zza2 = zzex.zza(i2);
        int i5 = i2 - 1;
        if (i4 != 0) {
            zzex.zza(zza2, i3 & i5, i4 + 1);
        }
        Object obj = this.zze;
        int[] iArr = this.zza;
        for (int i6 = 0; i6 <= i; i6++) {
            int zza3 = zzex.zza(obj, i6);
            while (zza3 != 0) {
                int i7 = zza3 - 1;
                int i8 = iArr[i7];
                int i9 = ((i ^ -1) & i8) | i6;
                int i10 = i9 & i5;
                int zza4 = zzex.zza(zza2, i10);
                zzex.zza(zza2, i10, zza3);
                iArr[i7] = zzex.zza(i9, zza4, i5);
                zza3 = i8 & i;
            }
        }
        this.zze = zza2;
        zzb(i5);
        return i5;
    }

    /* access modifiers changed from: public */
    private final int zza(Object obj) {
        if (zza()) {
            return -1;
        }
        int zza2 = zzez.zza(obj);
        int zzi2 = zzi();
        int zza3 = zzex.zza(this.zze, zza2 & zzi2);
        if (zza3 == 0) {
            return -1;
        }
        int i = zzi2 ^ -1;
        int i2 = zza2 & i;
        do {
            int i3 = zza3 - 1;
            int i4 = this.zza[i3];
            if ((i4 & i) == i2 && zzdz.zza(obj, this.zzb[i3])) {
                return i3;
            }
            zza3 = i4 & zzi2;
        } while (zza3 != 0);
        return -1;
    }

    public final boolean containsKey(Object obj) {
        Map<K, V> zzb2 = zzb();
        if (zzb2 != null) {
            return zzb2.containsKey(obj);
        }
        return zza(obj) != -1;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final V get(Object obj) {
        Map<K, V> zzb2 = zzb();
        if (zzb2 != null) {
            return zzb2.get(obj);
        }
        int zza2 = zza(obj);
        if (zza2 == -1) {
            return null;
        }
        return (V) this.zzc[zza2];
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final V remove(Object obj) {
        Map<K, V> zzb2 = zzb();
        if (zzb2 != null) {
            return zzb2.remove(obj);
        }
        V v = (V) zzb(obj);
        if (v == zzd) {
            return null;
        }
        return v;
    }

    private final Object zzb(Object obj) {
        if (zza()) {
            return zzd;
        }
        int zzi2 = zzi();
        int zza2 = zzex.zza(obj, null, zzi2, this.zze, this.zza, this.zzb, null);
        if (zza2 == -1) {
            return zzd;
        }
        Object obj2 = this.zzc[zza2];
        zza(zza2, zzi2);
        this.zzg--;
        zzc();
        return obj2;
    }

    public final void zza(int i, int i2) {
        int size = size() - 1;
        if (i < size) {
            Object[] objArr = this.zzb;
            Object obj = objArr[size];
            objArr[i] = obj;
            Object[] objArr2 = this.zzc;
            objArr2[i] = objArr2[size];
            objArr[size] = null;
            objArr2[size] = null;
            int[] iArr = this.zza;
            iArr[i] = iArr[size];
            iArr[size] = 0;
            int zza2 = zzez.zza(obj) & i2;
            int zza3 = zzex.zza(this.zze, zza2);
            int i3 = size + 1;
            if (zza3 == i3) {
                zzex.zza(this.zze, zza2, i + 1);
                return;
            }
            while (true) {
                int i4 = zza3 - 1;
                int[] iArr2 = this.zza;
                int i5 = iArr2[i4];
                int i6 = i5 & i2;
                if (i6 == i3) {
                    iArr2[i4] = zzex.zza(i5, i + 1, i2);
                    return;
                }
                zza3 = i6;
            }
        } else {
            this.zzb[i] = null;
            this.zzc[i] = null;
            this.zza[i] = 0;
        }
    }

    public final int zzd() {
        return isEmpty() ? -1 : 0;
    }

    public final int zza(int i) {
        int i2 = i + 1;
        if (i2 < this.zzg) {
            return i2;
        }
        return -1;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Set<K> keySet() {
        Set<K> set = this.zzh;
        if (set != null) {
            return set;
        }
        zzes zzes = new zzes(this);
        this.zzh = zzes;
        return zzes;
    }

    public final Iterator<K> zze() {
        Map<K, V> zzb2 = zzb();
        if (zzb2 != null) {
            return zzb2.keySet().iterator();
        }
        return new zzep(this);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Set<Map.Entry<K, V>> entrySet() {
        Set<Map.Entry<K, V>> set = this.zzi;
        if (set != null) {
            return set;
        }
        zzeq zzeq = new zzeq(this);
        this.zzi = zzeq;
        return zzeq;
    }

    public final Iterator<Map.Entry<K, V>> zzf() {
        Map<K, V> zzb2 = zzb();
        if (zzb2 != null) {
            return zzb2.entrySet().iterator();
        }
        return new zzeo(this);
    }

    public final int size() {
        Map<K, V> zzb2 = zzb();
        return zzb2 != null ? zzb2.size() : this.zzg;
    }

    public final boolean isEmpty() {
        return size() == 0;
    }

    public final boolean containsValue(Object obj) {
        Map<K, V> zzb2 = zzb();
        if (zzb2 != null) {
            return zzb2.containsValue(obj);
        }
        for (int i = 0; i < this.zzg; i++) {
            if (zzdz.zza(obj, this.zzc[i])) {
                return true;
            }
        }
        return false;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Collection<V> values() {
        Collection<V> collection = this.zzj;
        if (collection != null) {
            return collection;
        }
        zzeu zzeu = new zzeu(this);
        this.zzj = zzeu;
        return zzeu;
    }

    public final Iterator<V> zzg() {
        Map<K, V> zzb2 = zzb();
        if (zzb2 != null) {
            return zzb2.values().iterator();
        }
        return new zzer(this);
    }

    public final void clear() {
        if (!zza()) {
            zzc();
            Map<K, V> zzb2 = zzb();
            if (zzb2 != null) {
                this.zzf = zzfz.zza(size(), 3, 1073741823);
                zzb2.clear();
                this.zze = null;
                this.zzg = 0;
                return;
            }
            Arrays.fill(this.zzb, 0, this.zzg, (Object) null);
            Arrays.fill(this.zzc, 0, this.zzg, (Object) null);
            Object obj = this.zze;
            if (obj instanceof byte[]) {
                Arrays.fill((byte[]) obj, (byte) 0);
            } else if (obj instanceof short[]) {
                Arrays.fill((short[]) obj, (short) 0);
            } else {
                Arrays.fill((int[]) obj, 0);
            }
            Arrays.fill(this.zza, 0, this.zzg, 0);
            this.zzg = 0;
        }
    }

    static /* synthetic */ Object zza(zzem zzem, Object obj) {
        return zzem.zzb(obj);
    }

    static /* synthetic */ Object zzh() {
        return zzd;
    }

    static /* synthetic */ int zzd(zzem zzem) {
        int i = zzem.zzg;
        zzem.zzg = i - 1;
        return i;
    }
}
