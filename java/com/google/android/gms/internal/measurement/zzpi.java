package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
public final class zzpi implements zzpj {
    private static final zzdh<Boolean> zza = new zzdm(zzde.zza("com.google.android.gms.measurement")).zza("measurement.integration.disable_firebase_instance_id", false);

    @Override // com.google.android.gms.internal.measurement.zzpj
    public final boolean zza() {
        return true;
    }

    @Override // com.google.android.gms.internal.measurement.zzpj
    public final boolean zzb() {
        return zza.zzc().booleanValue();
    }
}
