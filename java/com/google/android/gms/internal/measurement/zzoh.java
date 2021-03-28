package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
public final class zzoh implements zzec<zzog> {
    private static zzoh zza = new zzoh();
    private final zzec<zzog> zzb;

    public static boolean zzb() {
        return ((zzog) zza.zza()).zza();
    }

    public static boolean zzc() {
        return ((zzog) zza.zza()).zzb();
    }

    public static boolean zzd() {
        return ((zzog) zza.zza()).zzc();
    }

    private zzoh(zzec<zzog> zzec) {
        this.zzb = zzef.zza((zzec) zzec);
    }

    public zzoh() {
        this(zzef.zza(new zzoj()));
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.google.android.gms.internal.measurement.zzec
    public final /* synthetic */ zzog zza() {
        return this.zzb.zza();
    }
}
