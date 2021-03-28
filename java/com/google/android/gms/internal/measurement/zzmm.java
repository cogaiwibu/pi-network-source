package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
public final class zzmm implements zzec<zzmp> {
    private static zzmm zza = new zzmm();
    private final zzec<zzmp> zzb;

    public static boolean zzb() {
        return ((zzmp) zza.zza()).zza();
    }

    private zzmm(zzec<zzmp> zzec) {
        this.zzb = zzef.zza((zzec) zzec);
    }

    public zzmm() {
        this(zzef.zza(new zzmo()));
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.google.android.gms.internal.measurement.zzec
    public final /* synthetic */ zzmp zza() {
        return this.zzb.zza();
    }
}
