package com.google.android.gms.internal.measurement;

import java.util.Iterator;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
public abstract class zzfg<E> extends zzey<E> implements Set<E> {
    @NullableDecl
    private transient zzfb<E> zza;

    static int zza(int i) {
        int max = Math.max(i, 2);
        boolean z = true;
        if (max < 751619276) {
            int highestOneBit = Integer.highestOneBit(max - 1) << 1;
            while (true) {
                double d = (double) highestOneBit;
                Double.isNaN(d);
                if (d * 0.7d >= ((double) max)) {
                    return highestOneBit;
                }
                highestOneBit <<= 1;
            }
        } else {
            if (max >= 1073741824) {
                z = false;
            }
            zzeb.zza(z, "collection too large");
            return 1073741824;
        }
    }

    /* access modifiers changed from: package-private */
    public boolean zzg() {
        return false;
    }

    zzfg() {
    }

    public boolean equals(@NullableDecl Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzfg) || !zzg() || !((zzfg) obj).zzg() || hashCode() == obj.hashCode()) {
            return zzfv.zza(this, obj);
        }
        return false;
    }

    public int hashCode() {
        return zzfv.zza(this);
    }

    @Override // com.google.android.gms.internal.measurement.zzey
    public zzfb<E> zze() {
        zzfb<E> zzfb = this.zza;
        if (zzfb != null) {
            return zzfb;
        }
        zzfb<E> zzh = zzh();
        this.zza = zzh;
        return zzh;
    }

    /* access modifiers changed from: package-private */
    public zzfb<E> zzh() {
        return zzfb.zza(toArray());
    }

    @Override // com.google.android.gms.internal.measurement.zzey, java.util.AbstractCollection, java.util.Collection, java.util.Set, java.lang.Iterable
    public /* synthetic */ Iterator iterator() {
        return iterator();
    }
}
