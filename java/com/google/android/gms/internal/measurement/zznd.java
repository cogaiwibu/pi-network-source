package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
public final class zznd implements zzec<zznc> {
    private static zznd zza = new zznd();
    private final zzec<zznc> zzb;

    public static boolean zzb() {
        return ((zznc) zza.zza()).zza();
    }

    public static boolean zzc() {
        return ((zznc) zza.zza()).zzb();
    }

    private zznd(zzec<zznc> zzec) {
        this.zzb = zzef.zza((zzec) zzec);
    }

    public zznd() {
        this(zzef.zza(new zznf()));
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.google.android.gms.internal.measurement.zzec
    public final /* synthetic */ zznc zza() {
        return this.zzb.zza();
    }
}
