package com.google.android.gms.internal.measurement;

import java.io.Serializable;
import java.util.Collection;
import java.util.Map;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
public class zzfe<K, V> extends zzek<K, V> implements Serializable {
    private final transient zzfc<K, ? extends zzey<V>> zza;
    private final transient int zzb;

    zzfe(zzfc<K, ? extends zzey<V>> zzfc, int i) {
        this.zza = zzfc;
        this.zzb = i;
    }

    @Override // com.google.android.gms.internal.measurement.zzel
    public final boolean zza(@NullableDecl Object obj) {
        return obj != null && super.zza(obj);
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.measurement.zzel
    public final Map<K, Collection<V>> zzb() {
        throw new AssertionError("should never be called");
    }

    @Override // com.google.android.gms.internal.measurement.zzel
    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }

    @Override // com.google.android.gms.internal.measurement.zzel
    public /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    @Override // com.google.android.gms.internal.measurement.zzel
    public /* bridge */ /* synthetic */ boolean equals(@NullableDecl Object obj) {
        return super.equals(obj);
    }

    @Override // com.google.android.gms.internal.measurement.zzel, com.google.android.gms.internal.measurement.zzfk
    public final /* synthetic */ Map zza() {
        return this.zza;
    }
}
