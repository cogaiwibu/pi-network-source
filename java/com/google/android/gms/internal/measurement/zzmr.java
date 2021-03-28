package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
public final class zzmr implements zzec<zzmq> {
    private static zzmr zza = new zzmr();
    private final zzec<zzmq> zzb;

    public static boolean zzb() {
        return ((zzmq) zza.zza()).zza();
    }

    private zzmr(zzec<zzmq> zzec) {
        this.zzb = zzef.zza((zzec) zzec);
    }

    public zzmr() {
        this(zzef.zza(new zzmt()));
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.google.android.gms.internal.measurement.zzec
    public final /* synthetic */ zzmq zza() {
        return this.zzb.zza();
    }
}
