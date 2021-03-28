package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
public final class zzoo implements zzec<zzor> {
    private static zzoo zza = new zzoo();
    private final zzec<zzor> zzb;

    public static boolean zzb() {
        return ((zzor) zza.zza()).zza();
    }

    public static double zzc() {
        return ((zzor) zza.zza()).zzb();
    }

    public static long zzd() {
        return ((zzor) zza.zza()).zzc();
    }

    public static long zze() {
        return ((zzor) zza.zza()).zzd();
    }

    public static String zzf() {
        return ((zzor) zza.zza()).zze();
    }

    private zzoo(zzec<zzor> zzec) {
        this.zzb = zzef.zza((zzec) zzec);
    }

    public zzoo() {
        this(zzef.zza(new zzoq()));
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.google.android.gms.internal.measurement.zzec
    public final /* synthetic */ zzor zza() {
        return this.zzb.zza();
    }
}
