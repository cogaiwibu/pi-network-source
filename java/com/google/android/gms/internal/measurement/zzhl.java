package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzhy;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-measurement-base@@18.0.0 */
public class zzhl {
    private static volatile boolean zza = false;
    private static boolean zzb = true;
    private static volatile zzhl zzc;
    private static volatile zzhl zzd;
    private static final zzhl zze = new zzhl(true);
    private final Map<zza, zzhy.zzf<?, ?>> zzf;

    public static zzhl zza() {
        zzhl zzhl = zzc;
        if (zzhl == null) {
            synchronized (zzhl.class) {
                zzhl = zzc;
                if (zzhl == null) {
                    zzhl = zze;
                    zzc = zzhl;
                }
            }
        }
        return zzhl;
    }

    /* compiled from: com.google.android.gms:play-services-measurement-base@@18.0.0 */
    private static final class zza {
        private final Object zza;
        private final int zzb;

        zza(Object obj, int i) {
            this.zza = obj;
            this.zzb = i;
        }

        public final int hashCode() {
            return (System.identityHashCode(this.zza) * 65535) + this.zzb;
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof zza)) {
                return false;
            }
            zza zza2 = (zza) obj;
            if (this.zza == zza2.zza && this.zzb == zza2.zzb) {
                return true;
            }
            return false;
        }
    }

    public static zzhl zzb() {
        zzhl zzhl = zzd;
        if (zzhl != null) {
            return zzhl;
        }
        synchronized (zzhl.class) {
            zzhl zzhl2 = zzd;
            if (zzhl2 != null) {
                return zzhl2;
            }
            zzhl zza2 = zzhw.zza(zzhl.class);
            zzd = zza2;
            return zza2;
        }
    }

    public final <ContainingType extends zzjj> zzhy.zzf<ContainingType, ?> zza(ContainingType containingtype, int i) {
        return (zzhy.zzf<ContainingType, ?>) this.zzf.get(new zza(containingtype, i));
    }

    zzhl() {
        this.zzf = new HashMap();
    }

    private zzhl(boolean z) {
        this.zzf = Collections.emptyMap();
    }
}
