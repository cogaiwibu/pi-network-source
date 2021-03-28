package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
public final class zznp implements zzec<zzno> {
    private static zznp zza = new zznp();
    private final zzec<zzno> zzb;

    public static boolean zzb() {
        return ((zzno) zza.zza()).zza();
    }

    public static boolean zzc() {
        return ((zzno) zza.zza()).zzb();
    }

    private zznp(zzec<zzno> zzec) {
        this.zzb = zzef.zza((zzec) zzec);
    }

    public zznp() {
        this(zzef.zza(new zznr()));
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.google.android.gms.internal.measurement.zzec
    public final /* synthetic */ zzno zza() {
        return this.zzb.zza();
    }
}
