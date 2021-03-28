package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
public final class zzne implements zzec<zznh> {
    private static zzne zza = new zzne();
    private final zzec<zznh> zzb;

    public static boolean zzb() {
        return ((zznh) zza.zza()).zza();
    }

    public static boolean zzc() {
        return ((zznh) zza.zza()).zzb();
    }

    private zzne(zzec<zznh> zzec) {
        this.zzb = zzef.zza((zzec) zzec);
    }

    public zzne() {
        this(zzef.zza(new zzng()));
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.google.android.gms.internal.measurement.zzec
    public final /* synthetic */ zznh zza() {
        return this.zzb.zza();
    }
}
