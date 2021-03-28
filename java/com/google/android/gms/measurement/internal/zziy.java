package com.google.android.gms.measurement.internal;

import android.os.RemoteException;

/* access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
public final class zziy implements Runnable {
    private final /* synthetic */ zzij zza;
    private final /* synthetic */ zzir zzb;

    zziy(zzir zzir, zzij zzij) {
        this.zzb = zzir;
        this.zza = zzij;
    }

    public final void run() {
        zzei zzei = this.zzb.zzb;
        if (zzei == null) {
            this.zzb.zzq().zze().zza("Failed to send current screen to service");
            return;
        }
        try {
            if (this.zza == null) {
                zzei.zza(0, (String) null, (String) null, this.zzb.zzm().getPackageName());
            } else {
                zzei.zza(this.zza.zzc, this.zza.zza, this.zza.zzb, this.zzb.zzm().getPackageName());
            }
            this.zzb.zzaj();
        } catch (RemoteException e) {
            this.zzb.zzq().zze().zza("Failed to send current screen to the service", e);
        }
    }
}
