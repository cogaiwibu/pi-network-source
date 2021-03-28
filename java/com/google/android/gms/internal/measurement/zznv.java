package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
public final class zznv implements zzec<zznu> {
    private static zznv zza = new zznv();
    private final zzec<zznu> zzb;

    public static boolean zzb() {
        return ((zznu) zza.zza()).zza();
    }

    public static boolean zzc() {
        return ((zznu) zza.zza()).zzb();
    }

    private zznv(zzec<zznu> zzec) {
        this.zzb = zzef.zza((zzec) zzec);
    }

    public zznv() {
        this(zzef.zza(new zznx()));
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.google.android.gms.internal.measurement.zzec
    public final /* synthetic */ zznu zza() {
        return this.zzb.zza();
    }
}
