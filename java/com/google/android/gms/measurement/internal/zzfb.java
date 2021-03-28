package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;
import java.net.URL;
import java.util.Map;

/* access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
public final class zzfb implements Runnable {
    private final URL zza;
    private final byte[] zzb;
    private final zzez zzc;
    private final String zzd;
    private final Map<String, String> zze;
    private final /* synthetic */ zzex zzf;

    public zzfb(zzex zzex, String str, URL url, byte[] bArr, Map<String, String> map, zzez zzez) {
        this.zzf = zzex;
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(url);
        Preconditions.checkNotNull(zzez);
        this.zza = url;
        this.zzb = bArr;
        this.zzc = zzez;
        this.zzd = str;
        this.zze = map;
    }

    /* JADX WARNING: Removed duplicated region for block: B:46:0x00d1 A[SYNTHETIC, Splitter:B:46:0x00d1] */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x00eb  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x010c A[SYNTHETIC, Splitter:B:59:0x010c] */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x0126  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void run() {
        /*
        // Method dump skipped, instructions count: 319
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzfb.run():void");
    }
}
