package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import android.text.TextUtils;

/* access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
public final class zzjh implements Runnable {
    private final /* synthetic */ boolean zza = true;
    private final /* synthetic */ boolean zzb;
    private final /* synthetic */ zzz zzc;
    private final /* synthetic */ zzn zzd;
    private final /* synthetic */ zzz zze;
    private final /* synthetic */ zzir zzf;

    zzjh(zzir zzir, boolean z, boolean z2, zzz zzz, zzn zzn, zzz zzz2) {
        this.zzf = zzir;
        this.zzb = z2;
        this.zzc = zzz;
        this.zzd = zzn;
        this.zze = zzz2;
    }

    public final void run() {
        zzei zzei = this.zzf.zzb;
        if (zzei == null) {
            this.zzf.zzq().zze().zza("Discarding data. Failed to send conditional user property to service");
            return;
        }
        if (this.zza) {
            this.zzf.zza(zzei, this.zzb ? null : this.zzc, this.zzd);
        } else {
            try {
                if (TextUtils.isEmpty(this.zze.zza)) {
                    zzei.zza(this.zzc, this.zzd);
                } else {
                    zzei.zza(this.zzc);
                }
            } catch (RemoteException e) {
                this.zzf.zzq().zze().zza("Failed to send conditional user property to the service", e);
            }
        }
        this.zzf.zzaj();
    }
}
