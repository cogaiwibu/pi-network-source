package com.google.android.datatransport.cct.a;

import com.google.android.datatransport.cct.a.zzg;
import com.google.firebase.messaging.Constants;

/* compiled from: com.google.android.datatransport:transport-backend-cct@@2.2.0 */
public abstract class zzq {

    /* compiled from: com.google.android.datatransport:transport-backend-cct@@2.2.0 */
    public static abstract class zza {
        public abstract zza zza(zza zza);

        public abstract zza zza(zzb zzb);

        public abstract zzq zza();
    }

    /* JADX INFO: Failed to restore enum class, 'enum' modifier removed */
    /* compiled from: com.google.android.datatransport:transport-backend-cct@@2.2.0 */
    public static final class zzb extends Enum<zzb> {
        public static final zzb zza = new zzb("UNKNOWN", 0, 0);
        public static final zzb zzb = new zzb(Constants.FirelogAnalytics.SDK_PLATFORM_ANDROID, 1, 4);

        private zzb(String str, int i, int i2) {
        }
    }

    public static zza zza() {
        return new zzg.zza();
    }
}
