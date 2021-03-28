package com.google.android.datatransport.cct;

import com.google.android.datatransport.cct.zzc;
import com.google.android.datatransport.runtime.retries.RetryStrategy;

/* compiled from: com.google.android.datatransport:transport-backend-cct@@2.2.0 */
final /* synthetic */ class zzb implements RetryStrategy {
    private static final zzb zza = new zzb();

    private zzb() {
    }

    public static RetryStrategy zza() {
        return zza;
    }

    @Override // com.google.android.datatransport.runtime.retries.RetryStrategy
    public Object shouldRetry(Object obj, Object obj2) {
        return zzc.zza((zzc.zza) obj, (zzc.zzb) obj2);
    }
}
