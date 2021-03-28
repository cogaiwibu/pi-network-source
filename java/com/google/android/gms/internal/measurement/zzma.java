package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
public final class zzma implements zzec<zzmd> {
    private static zzma zza = new zzma();
    private final zzec<zzmd> zzb;

    public static boolean zzb() {
        return ((zzmd) zza.zza()).zza();
    }

    public static long zzc() {
        return ((zzmd) zza.zza()).zzb();
    }

    private zzma(zzec<zzmd> zzec) {
        this.zzb = zzef.zza((zzec) zzec);
    }

    public zzma() {
        this(zzef.zza(new zzmc()));
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.google.android.gms.internal.measurement.zzec
    public final /* synthetic */ zzmd zza() {
        return this.zzb.zza();
    }
}
