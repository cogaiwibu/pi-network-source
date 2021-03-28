package com.google.android.gms.internal.measurement;

import java.util.NoSuchElementException;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
final class zzfl extends zzfx<T> {
    private boolean zza;
    private final /* synthetic */ Object zzb;

    zzfl(Object obj) {
        this.zzb = obj;
    }

    public final boolean hasNext() {
        return !this.zza;
    }

    @Override // java.util.Iterator
    public final T next() {
        if (!this.zza) {
            this.zza = true;
            return (T) this.zzb;
        }
        throw new NoSuchElementException();
    }
}
