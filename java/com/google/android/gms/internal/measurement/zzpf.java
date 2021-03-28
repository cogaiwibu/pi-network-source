package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
public final class zzpf implements zzec<zzpe> {
    private static zzpf zza = new zzpf();
    private final zzec<zzpe> zzb;

    public static boolean zzb() {
        return ((zzpe) zza.zza()).zza();
    }

    private zzpf(zzec<zzpe> zzec) {
        this.zzb = zzef.zza((zzec) zzec);
    }

    public zzpf() {
        this(zzef.zza(new zzph()));
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.google.android.gms.internal.measurement.zzec
    public final /* synthetic */ zzpe zza() {
        return this.zzb.zza();
    }
}
