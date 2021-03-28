package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
public final class zzoi implements zzec<zzol> {
    private static zzoi zza = new zzoi();
    private final zzec<zzol> zzb;

    public static long zzb() {
        return ((zzol) zza.zza()).zza();
    }

    private zzoi(zzec<zzol> zzec) {
        this.zzb = zzef.zza((zzec) zzec);
    }

    public zzoi() {
        this(zzef.zza(new zzok()));
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.google.android.gms.internal.measurement.zzec
    public final /* synthetic */ zzol zza() {
        return this.zzb.zza();
    }
}
