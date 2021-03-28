package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
public final class zzlt implements zzec<zzls> {
    private static zzlt zza = new zzlt();
    private final zzec<zzls> zzb;

    public static boolean zzb() {
        return ((zzls) zza.zza()).zza();
    }

    private zzlt(zzec<zzls> zzec) {
        this.zzb = zzef.zza((zzec) zzec);
    }

    public zzlt() {
        this(zzef.zza(new zzlv()));
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.google.android.gms.internal.measurement.zzec
    public final /* synthetic */ zzls zza() {
        return this.zzb.zza();
    }
}
