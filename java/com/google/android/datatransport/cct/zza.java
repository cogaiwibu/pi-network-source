package com.google.android.datatransport.cct;

import com.google.android.datatransport.cct.zzc;
import com.google.android.datatransport.runtime.retries.Function;

/* compiled from: com.google.android.datatransport:transport-backend-cct@@2.2.0 */
final /* synthetic */ class zza implements Function {
    private final zzc zza;

    private zza(zzc zzc) {
        this.zza = zzc;
    }

    public static Function zza(zzc zzc) {
        return new zza(zzc);
    }

    @Override // com.google.android.datatransport.runtime.retries.Function
    public Object apply(Object obj) {
        return this.zza.zza((zzc.zza) obj);
    }
}
