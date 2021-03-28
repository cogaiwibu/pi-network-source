package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
public final class zzpg implements zzec<zzpj> {
    private static zzpg zza = new zzpg();
    private final zzec<zzpj> zzb;

    public static boolean zzb() {
        return ((zzpj) zza.zza()).zza();
    }

    public static boolean zzc() {
        return ((zzpj) zza.zza()).zzb();
    }

    private zzpg(zzec<zzpj> zzec) {
        this.zzb = zzef.zza((zzec) zzec);
    }

    public zzpg() {
        this(zzef.zza(new zzpi()));
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.google.android.gms.internal.measurement.zzec
    public final /* synthetic */ zzpj zza() {
        return this.zzb.zza();
    }
}
