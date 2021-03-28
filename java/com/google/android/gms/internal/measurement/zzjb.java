package com.google.android.gms.internal.measurement;

import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-measurement-base@@18.0.0 */
public final class zzjb<K, V> {
    static <K, V> void zza(zzhi zzhi, zzja<K, V> zzja, K k, V v) throws IOException {
        zzhr.zza(zzhi, zzja.zza, 1, k);
        zzhr.zza(zzhi, zzja.zzc, 2, v);
    }

    static <K, V> int zza(zzja<K, V> zzja, K k, V v) {
        return zzhr.zza(zzja.zza, 1, k) + zzhr.zza(zzja.zzc, 2, v);
    }
}
