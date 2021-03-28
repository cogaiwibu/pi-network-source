package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
public final class zzod implements zzoa {
    private static final zzdh<Boolean> zza;
    private static final zzdh<Boolean> zzb;
    private static final zzdh<Boolean> zzc;
    private static final zzdh<Boolean> zzd;
    private static final zzdh<Long> zze;

    @Override // com.google.android.gms.internal.measurement.zzoa
    public final boolean zza() {
        return zza.zzc().booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzoa
    public final boolean zzb() {
        return zzb.zzc().booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzoa
    public final boolean zzc() {
        return zzc.zzc().booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzoa
    public final boolean zzd() {
        return zzd.zzc().booleanValue();
    }

    static {
        zzdm zzdm = new zzdm(zzde.zza("com.google.android.gms.measurement"));
        zza = zzdm.zza("measurement.sdk.collection.enable_extend_user_property_size", true);
        zzb = zzdm.zza("measurement.sdk.collection.last_deep_link_referrer2", true);
        zzc = zzdm.zza("measurement.sdk.collection.last_deep_link_referrer_campaign2", false);
        zzd = zzdm.zza("measurement.sdk.collection.last_gclid_from_referrer2", false);
        zze = zzdm.zza("measurement.id.sdk.collection.last_deep_link_referrer2", 0L);
    }
}
