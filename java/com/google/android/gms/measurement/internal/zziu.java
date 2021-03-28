package com.google.android.gms.measurement.internal;

import android.os.RemoteException;

/* access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
public final class zziu implements Runnable {
    private final /* synthetic */ zzn zza;
    private final /* synthetic */ zzir zzb;

    zziu(zzir zzir, zzn zzn) {
        this.zzb = zzir;
        this.zza = zzn;
    }

    public final void run() {
        zzei zzei = this.zzb.zzb;
        if (zzei == null) {
            this.zzb.zzq().zze().zza("Failed to reset data on the service: not connected to service");
            return;
        }
        try {
            zzei.zzd(this.zza);
        } catch (RemoteException e) {
            this.zzb.zzq().zze().zza("Failed to reset data on the service: remote exception", e);
        }
        this.zzb.zzaj();
    }
}
