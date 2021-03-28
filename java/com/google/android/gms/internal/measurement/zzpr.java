package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
public final class zzpr implements zzec<zzpq> {
    private static zzpr zza = new zzpr();
    private final zzec<zzpq> zzb;

    public static boolean zzb() {
        return ((zzpq) zza.zza()).zza();
    }

    private zzpr(zzec<zzpq> zzec) {
        this.zzb = zzef.zza((zzec) zzec);
    }

    public zzpr() {
        this(zzef.zza(new zzps()));
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.google.android.gms.internal.measurement.zzec
    public final /* synthetic */ zzpq zza() {
        return this.zzb.zza();
    }
}
