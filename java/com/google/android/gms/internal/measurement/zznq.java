package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
public final class zznq implements zzec<zznt> {
    private static zznq zza = new zznq();
    private final zzec<zznt> zzb;

    public static boolean zzb() {
        return ((zznt) zza.zza()).zza();
    }

    private zznq(zzec<zznt> zzec) {
        this.zzb = zzef.zza((zzec) zzec);
    }

    public zznq() {
        this(zzef.zza(new zzns()));
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.google.android.gms.internal.measurement.zzec
    public final /* synthetic */ zznt zza() {
        return this.zzb.zza();
    }
}
