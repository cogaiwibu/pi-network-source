package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
public final class zzpm implements zzec<zzpp> {
    private static zzpm zza = new zzpm();
    private final zzec<zzpp> zzb;

    public static boolean zzb() {
        return ((zzpp) zza.zza()).zza();
    }

    private zzpm(zzec<zzpp> zzec) {
        this.zzb = zzef.zza((zzec) zzec);
    }

    public zzpm() {
        this(zzef.zza(new zzpo()));
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.google.android.gms.internal.measurement.zzec
    public final /* synthetic */ zzpp zza() {
        return this.zzb.zza();
    }
}
