package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
public final class zzmg implements zzec<zzmj> {
    private static zzmg zza = new zzmg();
    private final zzec<zzmj> zzb;

    public static boolean zzb() {
        return ((zzmj) zza.zza()).zza();
    }

    public static boolean zzc() {
        return ((zzmj) zza.zza()).zzb();
    }

    public static boolean zzd() {
        return ((zzmj) zza.zza()).zzc();
    }

    private zzmg(zzec<zzmj> zzec) {
        this.zzb = zzef.zza((zzec) zzec);
    }

    public zzmg() {
        this(zzef.zza(new zzmi()));
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.google.android.gms.internal.measurement.zzec
    public final /* synthetic */ zzmj zza() {
        return this.zzb.zza();
    }
}
