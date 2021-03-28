package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
public final class zzoq implements zzor {
    private static final zzdh<Boolean> zza;
    private static final zzdh<Double> zzb;
    private static final zzdh<Long> zzc;
    private static final zzdh<Long> zzd;
    private static final zzdh<String> zze;

    @Override // com.google.android.gms.internal.measurement.zzor
    public final boolean zza() {
        return zza.zzc().booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzor
    public final double zzb() {
        return zzb.zzc().doubleValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzor
    public final long zzc() {
        return zzc.zzc().longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzor
    public final long zzd() {
        return zzd.zzc().longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzor
    public final String zze() {
        return zze.zzc();
    }

    static {
        zzdm zzdm = new zzdm(zzde.zza("com.google.android.gms.measurement"));
        zza = zzdm.zza("measurement.test.boolean_flag", false);
        zzb = zzdm.zza("measurement.test.double_flag", -3.0d);
        zzc = zzdm.zza("measurement.test.int_flag", -2L);
        zzd = zzdm.zza("measurement.test.long_flag", -1L);
        zze = zzdm.zza("measurement.test.string_flag", "---");
    }
}
