package com.google.android.gms.internal.measurement;

import java.util.List;

/* access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-base@@18.0.0 */
public abstract class zzit {
    private static final zzit zza = new zziv();
    private static final zzit zzb = new zziu();

    private zzit() {
    }

    /* access modifiers changed from: package-private */
    public abstract <L> List<L> zza(Object obj, long j);

    /* access modifiers changed from: package-private */
    public abstract <L> void zza(Object obj, Object obj2, long j);

    /* access modifiers changed from: package-private */
    public abstract void zzb(Object obj, long j);

    static zzit zza() {
        return zza;
    }

    static zzit zzb() {
        return zzb;
    }
}
