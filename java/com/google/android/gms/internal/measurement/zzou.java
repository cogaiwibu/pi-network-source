package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
public final class zzou implements zzec<zzox> {
    private static zzou zza = new zzou();
    private final zzec<zzox> zzb;

    public static boolean zzb() {
        return ((zzox) zza.zza()).zza();
    }

    private zzou(zzec<zzox> zzec) {
        this.zzb = zzef.zza((zzec) zzec);
    }

    public zzou() {
        this(zzef.zza(new zzow()));
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.google.android.gms.internal.measurement.zzec
    public final /* synthetic */ zzox zza() {
        return this.zzb.zza();
    }
}
