package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
public final class zzns implements zznt {
    private static final zzdh<Boolean> zza = new zzdm(zzde.zza("com.google.android.gms.measurement")).zza("measurement.collection.firebase_global_collection_flag_enabled", true);

    @Override // com.google.android.gms.internal.measurement.zznt
    public final boolean zza() {
        return zza.zzc().booleanValue();
    }
}
