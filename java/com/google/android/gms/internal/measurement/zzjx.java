package com.google.android.gms.internal.measurement;

import com.google.firebase.messaging.Constants;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-base@@18.0.0 */
public final class zzjx {
    private static final zzjx zza = new zzjx();
    private final zzka zzb = new zziw();
    private final ConcurrentMap<Class<?>, zzkb<?>> zzc = new ConcurrentHashMap();

    public static zzjx zza() {
        return zza;
    }

    public final <T> zzkb<T> zza(Class<T> cls) {
        zzia.zza((Object) cls, Constants.FirelogAnalytics.PARAM_MESSAGE_TYPE);
        zzkb<T> zzkb = (zzkb<T>) this.zzc.get(cls);
        if (zzkb != null) {
            return zzkb;
        }
        zzkb<T> zza2 = this.zzb.zza(cls);
        zzia.zza((Object) cls, Constants.FirelogAnalytics.PARAM_MESSAGE_TYPE);
        zzia.zza((Object) zza2, "schema");
        zzkb<T> zzkb2 = (zzkb<T>) this.zzc.putIfAbsent(cls, zza2);
        return zzkb2 != null ? zzkb2 : zza2;
    }

    public final <T> zzkb<T> zza(T t) {
        return zza((Class) t.getClass());
    }

    private zzjx() {
    }
}
