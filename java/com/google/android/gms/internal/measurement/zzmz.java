package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
public final class zzmz implements zzmw {
    private static final zzdh<Boolean> zza;
    private static final zzdh<Boolean> zzb;
    private static final zzdh<Boolean> zzc;
    private static final zzdh<Boolean> zzd;

    @Override // com.google.android.gms.internal.measurement.zzmw
    public final boolean zza() {
        return true;
    }

    @Override // com.google.android.gms.internal.measurement.zzmw
    public final boolean zzb() {
        return zzb.zzc().booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzmw
    public final boolean zzc() {
        return zzc.zzc().booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzmw
    public final boolean zzd() {
        return zzd.zzc().booleanValue();
    }

    static {
        zzdm zzdm = new zzdm(zzde.zza("com.google.android.gms.measurement"));
        zza = zzdm.zza("measurement.service.audience.fix_skip_audience_with_failed_filters", true);
        zzb = zzdm.zza("measurement.audience.refresh_event_count_filters_timestamp", false);
        zzc = zzdm.zza("measurement.audience.use_bundle_end_timestamp_for_non_sequence_property_filters", false);
        zzd = zzdm.zza("measurement.audience.use_bundle_timestamp_for_event_count_filters", false);
    }
}
