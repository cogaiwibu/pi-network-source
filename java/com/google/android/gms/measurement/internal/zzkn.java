package com.google.android.gms.measurement.internal;

import java.util.List;
import java.util.Map;

/* access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
public final class zzkn implements zzez {
    private final /* synthetic */ String zza;
    private final /* synthetic */ zzkl zzb;

    zzkn(zzkl zzkl, String str) {
        this.zzb = zzkl;
        this.zza = str;
    }

    @Override // com.google.android.gms.measurement.internal.zzez
    public final void zza(String str, int i, Throwable th, byte[] bArr, Map<String, List<String>> map) {
        this.zzb.zza(i, th, bArr, this.zza);
    }
}
