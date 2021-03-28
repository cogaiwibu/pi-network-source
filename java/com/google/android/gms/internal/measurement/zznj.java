package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
public final class zznj implements zzec<zzni> {
    private static zznj zza = new zznj();
    private final zzec<zzni> zzb;

    public static boolean zzb() {
        return ((zzni) zza.zza()).zza();
    }

    public static boolean zzc() {
        return ((zzni) zza.zza()).zzb();
    }

    private zznj(zzec<zzni> zzec) {
        this.zzb = zzef.zza((zzec) zzec);
    }

    public zznj() {
        this(zzef.zza(new zznl()));
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.google.android.gms.internal.measurement.zzec
    public final /* synthetic */ zzni zza() {
        return this.zzb.zza();
    }
}
