package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
public final class zzmy implements zzec<zznb> {
    private static zzmy zza = new zzmy();
    private final zzec<zznb> zzb;

    public static boolean zzb() {
        return ((zznb) zza.zza()).zza();
    }

    public static boolean zzc() {
        return ((zznb) zza.zza()).zzb();
    }

    private zzmy(zzec<zznb> zzec) {
        this.zzb = zzef.zza((zzec) zzec);
    }

    public zzmy() {
        this(zzef.zza(new zzna()));
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.google.android.gms.internal.measurement.zzec
    public final /* synthetic */ zznb zza() {
        return this.zzb.zza();
    }
}
