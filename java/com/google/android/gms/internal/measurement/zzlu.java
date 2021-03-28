package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
public final class zzlu implements zzec<zzlx> {
    private static zzlu zza = new zzlu();
    private final zzec<zzlx> zzb;

    public static boolean zzb() {
        return ((zzlx) zza.zza()).zza();
    }

    private zzlu(zzec<zzlx> zzec) {
        this.zzb = zzef.zza((zzec) zzec);
    }

    public zzlu() {
        this(zzef.zza(new zzlw()));
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.google.android.gms.internal.measurement.zzec
    public final /* synthetic */ zzlx zza() {
        return this.zzb.zza();
    }
}
