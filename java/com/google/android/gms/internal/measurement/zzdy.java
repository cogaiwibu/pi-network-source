package com.google.android.gms.internal.measurement;

import java.io.Serializable;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
public abstract class zzdy<T> implements Serializable {
    public static <T> zzdy<T> zzc() {
        return zzdu.zza;
    }

    public abstract boolean zza();

    public abstract T zzb();

    public static <T> zzdy<T> zza(T t) {
        return new zzea(zzeb.zza(t));
    }

    zzdy() {
    }
}
