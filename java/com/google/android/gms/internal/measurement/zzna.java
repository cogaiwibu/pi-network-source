package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
public final class zzna implements zznb {
    private static final zzdh<Boolean> zza;
    private static final zzdh<Long> zzb;

    @Override // com.google.android.gms.internal.measurement.zznb
    public final boolean zza() {
        return true;
    }

    @Override // com.google.android.gms.internal.measurement.zznb
    public final boolean zzb() {
        return zza.zzc().booleanValue();
    }

    static {
        zzdm zzdm = new zzdm(zzde.zza("com.google.android.gms.measurement"));
        zza = zzdm.zza("measurement.sdk.referrer.delayed_install_referrer_api", false);
        zzb = zzdm.zza("measurement.id.sdk.referrer.delayed_install_referrer_api", 0L);
    }
}
