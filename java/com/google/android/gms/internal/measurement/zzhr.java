package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzht;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-base@@18.0.0 */
public final class zzhr<T extends zzht<T>> {
    private static final zzhr zzd = new zzhr(true);
    final zzkc<T, Object> zza;
    private boolean zzb;
    private boolean zzc;

    private zzhr() {
        this.zza = zzkc.zza(16);
    }

    private zzhr(boolean z) {
        this(zzkc.zza(0));
        zzb();
    }

    private zzhr(zzkc<T, Object> zzkc) {
        this.zza = zzkc;
        zzb();
    }

    public static <T extends zzht<T>> zzhr<T> zza() {
        return zzd;
    }

    public final void zzb() {
        if (!this.zzb) {
            this.zza.zza();
            this.zzb = true;
        }
    }

    public final boolean zzc() {
        return this.zzb;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzhr)) {
            return false;
        }
        return this.zza.equals(((zzhr) obj).zza);
    }

    public final int hashCode() {
        return this.zza.hashCode();
    }

    public final Iterator<Map.Entry<T, Object>> zzd() {
        if (this.zzc) {
            return new zzip(this.zza.entrySet().iterator());
        }
        return this.zza.entrySet().iterator();
    }

    /* access modifiers changed from: package-private */
    public final Iterator<Map.Entry<T, Object>> zze() {
        if (this.zzc) {
            return new zzip(this.zza.zze().iterator());
        }
        return this.zza.zze().iterator();
    }

    private final Object zza(T t) {
        Object obj = this.zza.get(t);
        if (!(obj instanceof zzik)) {
            return obj;
        }
        zzik zzik = (zzik) obj;
        return zzik.zza();
    }

    private final void zzb(T t, Object obj) {
        if (!t.zzd()) {
            zza(t.zzb(), obj);
        } else if (obj instanceof List) {
            ArrayList arrayList = new ArrayList();
            arrayList.addAll((List) obj);
            ArrayList arrayList2 = arrayList;
            int size = arrayList2.size();
            int i = 0;
            while (i < size) {
                Object obj2 = arrayList2.get(i);
                i++;
                zza(t.zzb(), obj2);
            }
            obj = arrayList;
        } else {
            throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
        }
        if (obj instanceof zzik) {
            this.zzc = true;
        }
        this.zza.put(t, obj);
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0025, code lost:
        if ((r3 instanceof com.google.android.gms.internal.measurement.zzid) == false) goto L_0x0014;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x002e, code lost:
        if ((r3 instanceof byte[]) == false) goto L_0x0014;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x001c, code lost:
        if ((r3 instanceof com.google.android.gms.internal.measurement.zzik) == false) goto L_0x0014;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void zza(com.google.android.gms.internal.measurement.zzlg r2, java.lang.Object r3) {
        /*
        // Method dump skipped, instructions count: 102
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzhr.zza(com.google.android.gms.internal.measurement.zzlg, java.lang.Object):void");
    }

    public final boolean zzf() {
        for (int i = 0; i < this.zza.zzc(); i++) {
            if (!zza((Map.Entry) this.zza.zzb(i))) {
                return false;
            }
        }
        for (Map.Entry<T, Object> entry : this.zza.zzd()) {
            if (!zza((Map.Entry) entry)) {
                return false;
            }
        }
        return true;
    }

    private static <T extends zzht<T>> boolean zza(Map.Entry<T, Object> entry) {
        T key = entry.getKey();
        if (key.zzc() == zzln.MESSAGE) {
            if (key.zzd()) {
                for (zzjj zzjj : (List) entry.getValue()) {
                    if (!zzjj.zzbn()) {
                        return false;
                    }
                }
            } else {
                Object value = entry.getValue();
                if (value instanceof zzjj) {
                    if (!((zzjj) value).zzbn()) {
                        return false;
                    }
                } else if (value instanceof zzik) {
                    return true;
                } else {
                    throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
                }
            }
        }
        return true;
    }

    public final void zza(zzhr<T> zzhr) {
        for (int i = 0; i < zzhr.zza.zzc(); i++) {
            zzb(zzhr.zza.zzb(i));
        }
        for (Map.Entry<T, Object> entry : zzhr.zza.zzd()) {
            zzb(entry);
        }
    }

    private static Object zza(Object obj) {
        if (obj instanceof zzjo) {
            return ((zzjo) obj).zza();
        }
        if (!(obj instanceof byte[])) {
            return obj;
        }
        byte[] bArr = (byte[]) obj;
        byte[] bArr2 = new byte[bArr.length];
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        return bArr2;
    }

    private final void zzb(Map.Entry<T, Object> entry) {
        zzjj zzjj;
        T key = entry.getKey();
        Object value = entry.getValue();
        if (value instanceof zzik) {
            zzik zzik = (zzik) value;
            value = zzik.zza();
        }
        if (key.zzd()) {
            Object zza2 = zza((zzht) key);
            if (zza2 == null) {
                zza2 = new ArrayList();
            }
            for (Object obj : (List) value) {
                ((List) zza2).add(zza(obj));
            }
            this.zza.put(key, zza2);
        } else if (key.zzc() == zzln.MESSAGE) {
            Object zza3 = zza((zzht) key);
            if (zza3 == null) {
                this.zza.put(key, zza(value));
                return;
            }
            if (zza3 instanceof zzjo) {
                zzjj = key.zza((zzjo) zza3, (zzjo) value);
            } else {
                zzjj = key.zza(((zzjj) zza3).zzbt(), (zzjj) value).zzy();
            }
            this.zza.put(key, zzjj);
        } else {
            this.zza.put(key, zza(value));
        }
    }

    static void zza(zzhi zzhi, zzlg zzlg, int i, Object obj) throws IOException {
        if (zzlg == zzlg.GROUP) {
            zzjj zzjj = (zzjj) obj;
            zzia.zza(zzjj);
            zzhi.zza(i, 3);
            zzjj.zza(zzhi);
            zzhi.zza(i, 4);
            return;
        }
        zzhi.zza(i, zzlg.zzb());
        switch (zzhq.zzb[zzlg.ordinal()]) {
            case 1:
                zzhi.zza(((Double) obj).doubleValue());
                return;
            case 2:
                zzhi.zza(((Float) obj).floatValue());
                return;
            case 3:
                zzhi.zza(((Long) obj).longValue());
                return;
            case 4:
                zzhi.zza(((Long) obj).longValue());
                return;
            case 5:
                zzhi.zza(((Integer) obj).intValue());
                return;
            case 6:
                zzhi.zzc(((Long) obj).longValue());
                return;
            case 7:
                zzhi.zzd(((Integer) obj).intValue());
                return;
            case 8:
                zzhi.zza(((Boolean) obj).booleanValue());
                return;
            case 9:
                ((zzjj) obj).zza(zzhi);
                return;
            case 10:
                zzhi.zza((zzjj) obj);
                return;
            case 11:
                if (obj instanceof zzgp) {
                    zzhi.zza((zzgp) obj);
                    return;
                } else {
                    zzhi.zza((String) obj);
                    return;
                }
            case 12:
                if (obj instanceof zzgp) {
                    zzhi.zza((zzgp) obj);
                    return;
                }
                byte[] bArr = (byte[]) obj;
                zzhi.zzb(bArr, 0, bArr.length);
                return;
            case 13:
                zzhi.zzb(((Integer) obj).intValue());
                return;
            case 14:
                zzhi.zzd(((Integer) obj).intValue());
                return;
            case 15:
                zzhi.zzc(((Long) obj).longValue());
                return;
            case 16:
                zzhi.zzc(((Integer) obj).intValue());
                return;
            case 17:
                zzhi.zzb(((Long) obj).longValue());
                return;
            case 18:
                if (obj instanceof zzid) {
                    zzhi.zza(((zzid) obj).zza());
                    return;
                } else {
                    zzhi.zza(((Integer) obj).intValue());
                    return;
                }
            default:
                return;
        }
    }

    public final int zzg() {
        int i = 0;
        for (int i2 = 0; i2 < this.zza.zzc(); i2++) {
            i += zzc(this.zza.zzb(i2));
        }
        for (Map.Entry<T, Object> entry : this.zza.zzd()) {
            i += zzc(entry);
        }
        return i;
    }

    private static int zzc(Map.Entry<T, Object> entry) {
        T key = entry.getKey();
        Object value = entry.getValue();
        if (key.zzc() != zzln.MESSAGE || key.zzd() || key.zze()) {
            return zza((zzht<?>) key, value);
        }
        if (value instanceof zzik) {
            return zzhi.zzb(entry.getKey().zza(), (zzik) value);
        }
        return zzhi.zzb(entry.getKey().zza(), (zzjj) value);
    }

    static int zza(zzlg zzlg, int i, Object obj) {
        int zze = zzhi.zze(i);
        if (zzlg == zzlg.GROUP) {
            zzia.zza((zzjj) obj);
            zze <<= 1;
        }
        return zze + zzb(zzlg, obj);
    }

    private static int zzb(zzlg zzlg, Object obj) {
        switch (zzhq.zzb[zzlg.ordinal()]) {
            case 1:
                return zzhi.zzb(((Double) obj).doubleValue());
            case 2:
                return zzhi.zzb(((Float) obj).floatValue());
            case 3:
                return zzhi.zzd(((Long) obj).longValue());
            case 4:
                return zzhi.zze(((Long) obj).longValue());
            case 5:
                return zzhi.zzf(((Integer) obj).intValue());
            case 6:
                return zzhi.zzg(((Long) obj).longValue());
            case 7:
                return zzhi.zzi(((Integer) obj).intValue());
            case 8:
                return zzhi.zzb(((Boolean) obj).booleanValue());
            case 9:
                return zzhi.zzc((zzjj) obj);
            case 10:
                if (obj instanceof zzik) {
                    return zzhi.zza((zzik) obj);
                }
                return zzhi.zzb((zzjj) obj);
            case 11:
                if (obj instanceof zzgp) {
                    return zzhi.zzb((zzgp) obj);
                }
                return zzhi.zzb((String) obj);
            case 12:
                if (obj instanceof zzgp) {
                    return zzhi.zzb((zzgp) obj);
                }
                return zzhi.zzb((byte[]) obj);
            case 13:
                return zzhi.zzg(((Integer) obj).intValue());
            case 14:
                return zzhi.zzj(((Integer) obj).intValue());
            case 15:
                return zzhi.zzh(((Long) obj).longValue());
            case 16:
                return zzhi.zzh(((Integer) obj).intValue());
            case 17:
                return zzhi.zzf(((Long) obj).longValue());
            case 18:
                if (obj instanceof zzid) {
                    return zzhi.zzk(((zzid) obj).zza());
                }
                return zzhi.zzk(((Integer) obj).intValue());
            default:
                throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
        }
    }

    public static int zza(zzht<?> zzht, Object obj) {
        zzlg zzb2 = zzht.zzb();
        int zza2 = zzht.zza();
        if (!zzht.zzd()) {
            return zza(zzb2, zza2, obj);
        }
        int i = 0;
        if (zzht.zze()) {
            for (Object obj2 : (List) obj) {
                i += zzb(zzb2, obj2);
            }
            return zzhi.zze(zza2) + i + zzhi.zzl(i);
        }
        for (Object obj3 : (List) obj) {
            i += zza(zzb2, zza2, obj3);
        }
        return i;
    }

    public final /* synthetic */ Object clone() throws CloneNotSupportedException {
        zzhr zzhr = new zzhr();
        for (int i = 0; i < this.zza.zzc(); i++) {
            Map.Entry<T, Object> zzb2 = this.zza.zzb(i);
            zzhr.zzb(zzb2.getKey(), zzb2.getValue());
        }
        for (Map.Entry<T, Object> entry : this.zza.zzd()) {
            zzhr.zzb(entry.getKey(), entry.getValue());
        }
        zzhr.zzc = this.zzc;
        return zzhr;
    }
}
