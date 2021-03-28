package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
public final class zzmu implements zzmv {
    private static final zzdh<Boolean> zza = new zzdm(zzde.zza("com.google.android.gms.measurement")).zza("measurement.client.firebase_feature_rollout.v1.enable", true);

    @Override // com.google.android.gms.internal.measurement.zzmv
    public final boolean zza() {
        return true;
    }

    @Override // com.google.android.gms.internal.measurement.zzmv
    public final boolean zzb() {
        return zza.zzc().booleanValue();
    }
}
