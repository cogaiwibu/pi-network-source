package com.google.android.gms.internal.measurement;

import java.io.Serializable;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
public final class zzef {
    public static <T> zzec<T> zza(zzec<T> zzec) {
        if ((zzec instanceof zzeh) || (zzec instanceof zzee)) {
            return zzec;
        }
        if (zzec instanceof Serializable) {
            return new zzee(zzec);
        }
        return new zzeh(zzec);
    }

    public static <T> zzec<T> zza(@NullableDecl T t) {
        return new zzeg(t);
    }
}
