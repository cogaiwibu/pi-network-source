package com.google.android.gms.measurement.internal;

import com.google.android.gms.internal.measurement.zzbv;
import com.google.android.gms.internal.measurement.zzcd;
import com.google.android.gms.internal.measurement.zzmx;

/* access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
public final class zzx extends zzu {
    private zzbv.zze zzg;
    private final /* synthetic */ zzr zzh;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzx(zzr zzr, String str, int i, zzbv.zze zze) {
        super(str, i);
        this.zzh = zzr;
        this.zzg = zze;
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.android.gms.measurement.internal.zzu
    public final boolean zzb() {
        return true;
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.android.gms.measurement.internal.zzu
    public final boolean zzc() {
        return false;
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.android.gms.measurement.internal.zzu
    public final int zza() {
        return this.zzg.zzb();
    }

    /* access modifiers changed from: package-private */
    public final boolean zza(Long l, Long l2, zzcd.zzk zzk, boolean z) {
        boolean z2 = zzmx.zzb() && this.zzh.zzs().zzd(this.zza, zzas.zzaz);
        boolean zze = this.zzg.zze();
        boolean zzf = this.zzg.zzf();
        boolean zzh2 = this.zzg.zzh();
        boolean z3 = zze || zzf || zzh2;
        Boolean bool = null;
        Integer num = null;
        bool = null;
        bool = null;
        bool = null;
        bool = null;
        if (!z || z3) {
            zzbv.zzc zzd = this.zzg.zzd();
            boolean zzf2 = zzd.zzf();
            if (zzk.zzf()) {
                if (!zzd.zzc()) {
                    this.zzh.zzq().zzh().zza("No number filter for long property. property", this.zzh.zzn().zzc(zzk.zzc()));
                } else {
                    bool = zza(zza(zzk.zzg(), zzd.zzd()), zzf2);
                }
            } else if (zzk.zzh()) {
                if (!zzd.zzc()) {
                    this.zzh.zzq().zzh().zza("No number filter for double property. property", this.zzh.zzn().zzc(zzk.zzc()));
                } else {
                    bool = zza(zza(zzk.zzi(), zzd.zzd()), zzf2);
                }
            } else if (!zzk.zzd()) {
                this.zzh.zzq().zzh().zza("User property has no value, property", this.zzh.zzn().zzc(zzk.zzc()));
            } else if (zzd.zza()) {
                bool = zza(zza(zzk.zze(), zzd.zzb(), this.zzh.zzq()), zzf2);
            } else if (!zzd.zzc()) {
                this.zzh.zzq().zzh().zza("No string or number filter defined. property", this.zzh.zzn().zzc(zzk.zzc()));
            } else if (zzkr.zza(zzk.zze())) {
                bool = zza(zza(zzk.zze(), zzd.zzd()), zzf2);
            } else {
                this.zzh.zzq().zzh().zza("Invalid user property value for Numeric number filter. property, value", this.zzh.zzn().zzc(zzk.zzc()), zzk.zze());
            }
            this.zzh.zzq().zzw().zza("Property filter result", bool == null ? "null" : bool);
            if (bool == null) {
                return false;
            }
            this.zzc = true;
            if (zzh2 && !bool.booleanValue()) {
                return true;
            }
            if (!z || this.zzg.zze()) {
                this.zzd = bool;
            }
            if (bool.booleanValue() && z3 && zzk.zza()) {
                long zzb = zzk.zzb();
                if (l != null) {
                    zzb = l.longValue();
                }
                if (z2 && this.zzg.zze() && !this.zzg.zzf() && l2 != null) {
                    zzb = l2.longValue();
                }
                if (this.zzg.zzf()) {
                    this.zzf = Long.valueOf(zzb);
                } else {
                    this.zze = Long.valueOf(zzb);
                }
            }
            return true;
        }
        zzes zzw = this.zzh.zzq().zzw();
        Integer valueOf = Integer.valueOf(this.zzb);
        if (this.zzg.zza()) {
            num = Integer.valueOf(this.zzg.zzb());
        }
        zzw.zza("Property filter already evaluated true and it is not associated with an enhanced audience. audience ID, filter ID", valueOf, num);
        return true;
    }
}
