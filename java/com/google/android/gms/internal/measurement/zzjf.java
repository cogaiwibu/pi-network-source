package com.google.android.gms.internal.measurement;

import java.util.Iterator;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-measurement-base@@18.0.0 */
final class zzjf implements zzjc {
    zzjf() {
    }

    @Override // com.google.android.gms.internal.measurement.zzjc
    public final Map<?, ?> zza(Object obj) {
        return (zzjd) obj;
    }

    @Override // com.google.android.gms.internal.measurement.zzjc
    public final zzja<?, ?> zzf(Object obj) {
        zzjb zzjb = (zzjb) obj;
        throw new NoSuchMethodError();
    }

    @Override // com.google.android.gms.internal.measurement.zzjc
    public final Map<?, ?> zzb(Object obj) {
        return (zzjd) obj;
    }

    @Override // com.google.android.gms.internal.measurement.zzjc
    public final boolean zzc(Object obj) {
        return !((zzjd) obj).zzd();
    }

    @Override // com.google.android.gms.internal.measurement.zzjc
    public final Object zzd(Object obj) {
        ((zzjd) obj).zzc();
        return obj;
    }

    @Override // com.google.android.gms.internal.measurement.zzjc
    public final Object zze(Object obj) {
        return zzjd.zza().zzb();
    }

    @Override // com.google.android.gms.internal.measurement.zzjc
    public final Object zza(Object obj, Object obj2) {
        zzjd zzjd = (zzjd) obj;
        zzjd zzjd2 = (zzjd) obj2;
        if (!zzjd2.isEmpty()) {
            if (!zzjd.zzd()) {
                zzjd = zzjd.zzb();
            }
            zzjd.zza(zzjd2);
        }
        return zzjd;
    }

    @Override // com.google.android.gms.internal.measurement.zzjc
    public final int zza(int i, Object obj, Object obj2) {
        zzjd zzjd = (zzjd) obj;
        zzjb zzjb = (zzjb) obj2;
        if (zzjd.isEmpty()) {
            return 0;
        }
        Iterator it = zzjd.entrySet().iterator();
        if (!it.hasNext()) {
            return 0;
        }
        Map.Entry entry = (Map.Entry) it.next();
        entry.getKey();
        entry.getValue();
        throw new NoSuchMethodError();
    }
}
