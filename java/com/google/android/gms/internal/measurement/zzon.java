package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
public final class zzon implements zzec<zzom> {
    private static zzon zza = new zzon();
    private final zzec<zzom> zzb;

    public static boolean zzb() {
        return ((zzom) zza.zza()).zza();
    }

    private zzon(zzec<zzom> zzec) {
        this.zzb = zzef.zza((zzec) zzec);
    }

    public zzon() {
        this(zzef.zza(new zzop()));
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.google.android.gms.internal.measurement.zzec
    public final /* synthetic */ zzom zza() {
        return this.zzb.zza();
    }
}
