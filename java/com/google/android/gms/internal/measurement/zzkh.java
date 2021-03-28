package com.google.android.gms.internal.measurement;

import java.util.Iterator;
import java.util.Map;

/* access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-base@@18.0.0 */
public final class zzkh extends zzkn {
    private final /* synthetic */ zzkc zza;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    private zzkh(zzkc zzkc) {
        super(zzkc, null);
        this.zza = zzkc;
    }

    @Override // com.google.android.gms.internal.measurement.zzkn, java.util.AbstractCollection, java.util.Collection, java.util.Set, java.lang.Iterable
    public final Iterator<Map.Entry<K, V>> iterator() {
        return new zzke(this.zza, null);
    }

    /* synthetic */ zzkh(zzkc zzkc, zzkf zzkf) {
        this(zzkc);
    }
}
