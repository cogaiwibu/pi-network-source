package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
public final class zzpl implements zzec<zzpk> {
    private static zzpl zza = new zzpl();
    private final zzec<zzpk> zzb;

    public static boolean zzb() {
        return ((zzpk) zza.zza()).zza();
    }

    private zzpl(zzec<zzpk> zzec) {
        this.zzb = zzef.zza((zzec) zzec);
    }

    public zzpl() {
        this(zzef.zza(new zzpn()));
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.google.android.gms.internal.measurement.zzec
    public final /* synthetic */ zzpk zza() {
        return this.zzb.zza();
    }
}
