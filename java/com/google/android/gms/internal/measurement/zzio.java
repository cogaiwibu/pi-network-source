package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-base@@18.0.0 */
public class zzio {
    private static final zzhl zza = zzhl.zza();
    private zzgp zzb;
    private volatile zzjj zzc;
    private volatile zzgp zzd;

    public int hashCode() {
        return 1;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzio)) {
            return false;
        }
        zzio zzio = (zzio) obj;
        zzjj zzjj = this.zzc;
        zzjj zzjj2 = zzio.zzc;
        if (zzjj == null && zzjj2 == null) {
            return zzc().equals(zzio.zzc());
        }
        if (zzjj != null && zzjj2 != null) {
            return zzjj.equals(zzjj2);
        }
        if (zzjj != null) {
            return zzjj.equals(zzio.zzb(zzjj.zzbv()));
        }
        return zzb(zzjj2.zzbv()).equals(zzjj2);
    }

    private final zzjj zzb(zzjj zzjj) {
        if (this.zzc == null) {
            synchronized (this) {
                if (this.zzc == null) {
                    try {
                        this.zzc = zzjj;
                        this.zzd = zzgp.zza;
                    } catch (zzij unused) {
                        this.zzc = zzjj;
                        this.zzd = zzgp.zza;
                    }
                }
            }
        }
        return this.zzc;
    }

    public final zzjj zza(zzjj zzjj) {
        zzjj zzjj2 = this.zzc;
        this.zzb = null;
        this.zzd = null;
        this.zzc = zzjj;
        return zzjj2;
    }

    public final int zzb() {
        if (this.zzd != null) {
            return this.zzd.zza();
        }
        if (this.zzc != null) {
            return this.zzc.zzbp();
        }
        return 0;
    }

    public final zzgp zzc() {
        if (this.zzd != null) {
            return this.zzd;
        }
        synchronized (this) {
            if (this.zzd != null) {
                return this.zzd;
            }
            if (this.zzc == null) {
                this.zzd = zzgp.zza;
            } else {
                this.zzd = this.zzc.zzbj();
            }
            return this.zzd;
        }
    }
}
