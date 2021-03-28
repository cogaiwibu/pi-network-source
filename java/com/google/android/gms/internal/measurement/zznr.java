package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
public final class zznr implements zzno {
    private static final zzdh<Boolean> zza;
    private static final zzdh<Boolean> zzb;
    private static final zzdh<Long> zzc;

    @Override // com.google.android.gms.internal.measurement.zzno
    public final boolean zza() {
        return zza.zzc().booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzno
    public final boolean zzb() {
        return zzb.zzc().booleanValue();
    }

    static {
        zzdm zzdm = new zzdm(zzde.zza("com.google.android.gms.measurement"));
        zza = zzdm.zza("measurement.collection.efficient_engagement_reporting_enabled_2", true);
        zzb = zzdm.zza("measurement.collection.redundant_engagement_removal_enabled", false);
        zzc = zzdm.zza("measurement.id.collection.redundant_engagement_removal_enabled", 0L);
    }
}
