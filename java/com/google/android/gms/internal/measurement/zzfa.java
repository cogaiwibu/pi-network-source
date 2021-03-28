package com.google.android.gms.internal.measurement;

/* access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
public final class zzfa<E> extends zzej<E> {
    private final zzfb<E> zza;

    zzfa(zzfb<E> zzfb, int i) {
        super(zzfb.size(), i);
        this.zza = zzfb;
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.measurement.zzej
    public final E zza(int i) {
        return this.zza.get(i);
    }
}
