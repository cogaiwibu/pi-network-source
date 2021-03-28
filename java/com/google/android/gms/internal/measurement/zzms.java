package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
public final class zzms implements zzec<zzmv> {
    private static zzms zza = new zzms();
    private final zzec<zzmv> zzb;

    public static boolean zzb() {
        return ((zzmv) zza.zza()).zza();
    }

    public static boolean zzc() {
        return ((zzmv) zza.zza()).zzb();
    }

    private zzms(zzec<zzmv> zzec) {
        this.zzb = zzef.zza((zzec) zzec);
    }

    public zzms() {
        this(zzef.zza(new zzmu()));
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.google.android.gms.internal.measurement.zzec
    public final /* synthetic */ zzmv zza() {
        return this.zzb.zza();
    }
}
