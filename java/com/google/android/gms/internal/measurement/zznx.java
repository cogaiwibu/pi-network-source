package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
public final class zznx implements zznu {
    private static final zzdh<Boolean> zza = new zzdm(zzde.zza("com.google.android.gms.measurement")).zza("measurement.ga.ga_app_id", false);

    @Override // com.google.android.gms.internal.measurement.zznu
    public final boolean zza() {
        return true;
    }

    @Override // com.google.android.gms.internal.measurement.zznu
    public final boolean zzb() {
        return zza.zzc().booleanValue();
    }
}
