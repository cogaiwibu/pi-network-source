package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
public final class zzmx implements zzec<zzmw> {
    private static zzmx zza = new zzmx();
    private final zzec<zzmw> zzb;

    public static boolean zzb() {
        return ((zzmw) zza.zza()).zza();
    }

    public static boolean zzc() {
        return ((zzmw) zza.zza()).zzb();
    }

    public static boolean zzd() {
        return ((zzmw) zza.zza()).zzc();
    }

    public static boolean zze() {
        return ((zzmw) zza.zza()).zzd();
    }

    private zzmx(zzec<zzmw> zzec) {
        this.zzb = zzef.zza((zzec) zzec);
    }

    public zzmx() {
        this(zzef.zza(new zzmz()));
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.google.android.gms.internal.measurement.zzec
    public final /* synthetic */ zzmw zza() {
        return this.zzb.zza();
    }
}
