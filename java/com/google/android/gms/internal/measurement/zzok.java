package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
public final class zzok implements zzol {
    private static final zzdh<Long> zza;
    private static final zzdh<Long> zzb;

    @Override // com.google.android.gms.internal.measurement.zzol
    public final long zza() {
        return zzb.zzc().longValue();
    }

    static {
        zzdm zzdm = new zzdm(zzde.zza("com.google.android.gms.measurement"));
        zza = zzdm.zza("measurement.id.max_bundles_per_iteration", 0L);
        zzb = zzdm.zza("measurement.max_bundles_per_iteration", 2L);
    }
}
