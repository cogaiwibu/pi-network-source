package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzhy;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-measurement-base@@18.0.0 */
final class zzjp<T> implements zzkb<T> {
    private final zzjj zza;
    private final zzkt<?, ?> zzb;
    private final boolean zzc;
    private final zzhn<?> zzd;

    private zzjp(zzkt<?, ?> zzkt, zzhn<?> zzhn, zzjj zzjj) {
        this.zzb = zzkt;
        this.zzc = zzhn.zza(zzjj);
        this.zzd = zzhn;
        this.zza = zzjj;
    }

    static <T> zzjp<T> zza(zzkt<?, ?> zzkt, zzhn<?> zzhn, zzjj zzjj) {
        return new zzjp<>(zzkt, zzhn, zzjj);
    }

    @Override // com.google.android.gms.internal.measurement.zzkb
    public final T zza() {
        return (T) this.zza.zzbu().zzx();
    }

    @Override // com.google.android.gms.internal.measurement.zzkb
    public final boolean zza(T t, T t2) {
        if (!this.zzb.zzb(t).equals(this.zzb.zzb(t2))) {
            return false;
        }
        if (this.zzc) {
            return this.zzd.zza((Object) t).equals(this.zzd.zza((Object) t2));
        }
        return true;
    }

    @Override // com.google.android.gms.internal.measurement.zzkb
    public final int zza(T t) {
        int hashCode = this.zzb.zzb(t).hashCode();
        return this.zzc ? (hashCode * 53) + this.zzd.zza((Object) t).hashCode() : hashCode;
    }

    @Override // com.google.android.gms.internal.measurement.zzkb
    public final void zzb(T t, T t2) {
        zzkd.zza(this.zzb, t, t2);
        if (this.zzc) {
            zzkd.zza(this.zzd, t, t2);
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzkb
    public final void zza(T t, zzlm zzlm) throws IOException {
        Iterator<Map.Entry<?, Object>> zzd2 = this.zzd.zza((Object) t).zzd();
        while (zzd2.hasNext()) {
            Map.Entry<?, Object> next = zzd2.next();
            zzht zzht = (zzht) next.getKey();
            if (zzht.zzc() != zzln.MESSAGE || zzht.zzd() || zzht.zze()) {
                throw new IllegalStateException("Found invalid MessageSet item.");
            } else if (next instanceof zzim) {
                zzlm.zza(zzht.zza(), (Object) ((zzim) next).zza().zzc());
            } else {
                zzlm.zza(zzht.zza(), next.getValue());
            }
        }
        zzkt<?, ?> zzkt = this.zzb;
        zzkt.zzb(zzkt.zzb(t), zzlm);
    }

    @Override // com.google.android.gms.internal.measurement.zzkb
    public final void zza(T t, byte[] bArr, int i, int i2, zzgo zzgo) throws IOException {
        T t2 = t;
        zzks zzks = t2.zzb;
        if (zzks == zzks.zza()) {
            zzks = zzks.zzb();
            t2.zzb = zzks;
        }
        t.zza();
        zzhy.zzf zzf = null;
        while (i < i2) {
            int zza2 = zzgl.zza(bArr, i, zzgo);
            int i3 = zzgo.zza;
            if (i3 == 11) {
                int i4 = 0;
                zzgp zzgp = null;
                while (zza2 < i2) {
                    zza2 = zzgl.zza(bArr, zza2, zzgo);
                    int i5 = zzgo.zza;
                    int i6 = i5 >>> 3;
                    int i7 = i5 & 7;
                    if (i6 != 2) {
                        if (i6 == 3) {
                            if (zzf != null) {
                                zzjx.zza();
                                throw new NoSuchMethodError();
                            } else if (i7 == 2) {
                                zza2 = zzgl.zze(bArr, zza2, zzgo);
                                zzgp = (zzgp) zzgo.zzc;
                            }
                        }
                    } else if (i7 == 0) {
                        zza2 = zzgl.zza(bArr, zza2, zzgo);
                        i4 = zzgo.zza;
                        zzf = (zzhy.zzf) this.zzd.zza(zzgo.zzd, this.zza, i4);
                    }
                    if (i5 == 12) {
                        break;
                    }
                    zza2 = zzgl.zza(i5, bArr, zza2, i2, zzgo);
                }
                if (zzgp != null) {
                    zzks.zza((i4 << 3) | 2, zzgp);
                }
                i = zza2;
            } else if ((i3 & 7) == 2) {
                zzf = (zzhy.zzf) this.zzd.zza(zzgo.zzd, this.zza, i3 >>> 3);
                if (zzf == null) {
                    i = zzgl.zza(i3, bArr, zza2, i2, zzks, zzgo);
                } else {
                    zzjx.zza();
                    throw new NoSuchMethodError();
                }
            } else {
                i = zzgl.zza(i3, bArr, zza2, i2, zzgo);
            }
        }
        if (i != i2) {
            throw zzij.zzg();
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzkb
    public final void zza(T t, zzjy zzjy, zzhl zzhl) throws IOException {
        boolean z;
        zzkt<?, ?> zzkt = this.zzb;
        zzhn<?> zzhn = this.zzd;
        Object zzc2 = zzkt.zzc(t);
        zzhr<?> zzb2 = zzhn.zzb(t);
        do {
            try {
                if (zzjy.zza() == Integer.MAX_VALUE) {
                    zzkt.zzb(t, zzc2);
                    return;
                }
                int zzb3 = zzjy.zzb();
                if (zzb3 == 11) {
                    int i = 0;
                    Object obj = null;
                    zzgp zzgp = null;
                    while (zzjy.zza() != Integer.MAX_VALUE) {
                        int zzb4 = zzjy.zzb();
                        if (zzb4 == 16) {
                            i = zzjy.zzo();
                            obj = zzhn.zza(zzhl, this.zza, i);
                        } else if (zzb4 == 26) {
                            if (obj != null) {
                                zzhn.zza(zzjy, obj, zzhl, zzb2);
                            } else {
                                zzgp = zzjy.zzn();
                            }
                        } else if (!zzjy.zzc()) {
                            break;
                        }
                    }
                    if (zzjy.zzb() != 12) {
                        throw zzij.zze();
                    } else if (zzgp != null) {
                        if (obj != null) {
                            zzhn.zza(zzgp, obj, zzhl, zzb2);
                        } else {
                            zzkt.zza(zzc2, i, zzgp);
                        }
                    }
                } else if ((zzb3 & 7) == 2) {
                    Object zza2 = zzhn.zza(zzhl, this.zza, zzb3 >>> 3);
                    if (zza2 != null) {
                        zzhn.zza(zzjy, zza2, zzhl, zzb2);
                    } else {
                        z = zzkt.zza(zzc2, zzjy);
                        continue;
                    }
                } else {
                    z = zzjy.zzc();
                    continue;
                }
                z = true;
                continue;
            } finally {
                zzkt.zzb(t, zzc2);
            }
        } while (z);
    }

    @Override // com.google.android.gms.internal.measurement.zzkb
    public final void zzc(T t) {
        this.zzb.zzd(t);
        this.zzd.zzc(t);
    }

    @Override // com.google.android.gms.internal.measurement.zzkb
    public final boolean zzd(T t) {
        return this.zzd.zza((Object) t).zzf();
    }

    @Override // com.google.android.gms.internal.measurement.zzkb
    public final int zzb(T t) {
        zzkt<?, ?> zzkt = this.zzb;
        int zze = zzkt.zze(zzkt.zzb(t)) + 0;
        return this.zzc ? zze + this.zzd.zza((Object) t).zzg() : zze;
    }
}
