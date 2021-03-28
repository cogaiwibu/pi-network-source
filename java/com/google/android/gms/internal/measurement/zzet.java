package com.google.android.gms.internal.measurement;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
public abstract class zzet<T> implements Iterator<T> {
    private int zza;
    private int zzb;
    private int zzc;
    private final /* synthetic */ zzem zzd;

    private zzet(zzem zzem) {
        this.zzd = zzem;
        this.zza = this.zzd.zzf;
        this.zzb = this.zzd.zzd();
        this.zzc = -1;
    }

    /* access modifiers changed from: package-private */
    public abstract T zza(int i);

    public boolean hasNext() {
        return this.zzb >= 0;
    }

    @Override // java.util.Iterator
    public T next() {
        zza();
        if (hasNext()) {
            int i = this.zzb;
            this.zzc = i;
            T zza2 = zza(i);
            this.zzb = this.zzd.zza(this.zzb);
            return zza2;
        }
        throw new NoSuchElementException();
    }

    public void remove() {
        zza();
        zzeb.zzb(this.zzc >= 0, "no calls to next() since the last call to remove()");
        this.zza += 32;
        zzem zzem = this.zzd;
        zzem.remove(zzem.zzb[this.zzc]);
        this.zzb = zzem.zzb(this.zzb, this.zzc);
        this.zzc = -1;
    }

    private final void zza() {
        if (this.zzd.zzf != this.zza) {
            throw new ConcurrentModificationException();
        }
    }

    /* synthetic */ zzet(zzem zzem, zzep zzep) {
        this(zzem);
    }
}
