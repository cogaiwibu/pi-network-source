package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
public final class zzoe implements zzof {
    private static final zzdh<Long> zza;
    private static final zzdh<Boolean> zzb;
    private static final zzdh<Boolean> zzc;
    private static final zzdh<Boolean> zzd;
    private static final zzdh<Long> zze;

    @Override // com.google.android.gms.internal.measurement.zzof
    public final boolean zza() {
        return zzb.zzc().booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzof
    public final boolean zzb() {
        return zzd.zzc().booleanValue();
    }

    static {
        zzdm zzdm = new zzdm(zzde.zza("com.google.android.gms.measurement"));
        zza = zzdm.zza("measurement.id.lifecycle.app_in_background_parameter", 0L);
        zzb = zzdm.zza("measurement.lifecycle.app_backgrounded_engagement", false);
        zzc = zzdm.zza("measurement.lifecycle.app_backgrounded_tracking", true);
        zzd = zzdm.zza("measurement.lifecycle.app_in_background_parameter", false);
        zze = zzdm.zza("measurement.id.lifecycle.app_backgrounded_tracking", 0L);
    }
}
