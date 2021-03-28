package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
public final class zzob implements zzec<zzoa> {
    private static zzob zza = new zzob();
    private final zzec<zzoa> zzb;

    public static boolean zzb() {
        return ((zzoa) zza.zza()).zza();
    }

    public static boolean zzc() {
        return ((zzoa) zza.zza()).zzb();
    }

    public static boolean zzd() {
        return ((zzoa) zza.zza()).zzc();
    }

    public static boolean zze() {
        return ((zzoa) zza.zza()).zzd();
    }

    private zzob(zzec<zzoa> zzec) {
        this.zzb = zzef.zza((zzec) zzec);
    }

    public zzob() {
        this(zzef.zza(new zzod()));
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.google.android.gms.internal.measurement.zzec
    public final /* synthetic */ zzoa zza() {
        return this.zzb.zza();
    }
}
