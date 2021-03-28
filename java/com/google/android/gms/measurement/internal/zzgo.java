package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
final class zzgo implements Runnable {
    private final /* synthetic */ String zza;
    private final /* synthetic */ String zzb;
    private final /* synthetic */ String zzc;
    private final /* synthetic */ long zzd;
    private final /* synthetic */ zzfz zze;

    zzgo(zzfz zzfz, String str, String str2, String str3, long j) {
        this.zze = zzfz;
        this.zza = str;
        this.zzb = str2;
        this.zzc = str3;
        this.zzd = j;
    }

    public final void run() {
        String str = this.zza;
        if (str == null) {
            this.zze.zza.zzu().zzu().zza(this.zzb, (zzij) null);
            return;
        }
        this.zze.zza.zzu().zzu().zza(this.zzb, new zzij(this.zzc, str, this.zzd));
    }
}
