package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
public final class zzng implements zznh {
    private static final zzdh<Boolean> zza = new zzdm(zzde.zza("com.google.android.gms.measurement")).zza("measurement.service.use_appinfo_modified", false);

    @Override // com.google.android.gms.internal.measurement.zznh
    public final boolean zza() {
        return true;
    }

    @Override // com.google.android.gms.internal.measurement.zznh
    public final boolean zzb() {
        return zza.zzc().booleanValue();
    }
}
