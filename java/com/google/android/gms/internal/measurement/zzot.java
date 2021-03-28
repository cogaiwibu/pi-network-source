package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
public final class zzot implements zzec<zzos> {
    private static zzot zza = new zzot();
    private final zzec<zzos> zzb;

    public static boolean zzb() {
        return ((zzos) zza.zza()).zza();
    }

    private zzot(zzec<zzos> zzec) {
        this.zzb = zzef.zza((zzec) zzec);
    }

    public zzot() {
        this(zzef.zza(new zzov()));
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.google.android.gms.internal.measurement.zzec
    public final /* synthetic */ zzos zza() {
        return this.zzb.zza();
    }
}
