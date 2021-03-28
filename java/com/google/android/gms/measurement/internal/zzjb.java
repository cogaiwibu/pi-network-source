package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.os.RemoteException;

/* access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
public final class zzjb implements Runnable {
    private final /* synthetic */ Bundle zza;
    private final /* synthetic */ zzn zzb;
    private final /* synthetic */ zzir zzc;

    zzjb(zzir zzir, Bundle bundle, zzn zzn) {
        this.zzc = zzir;
        this.zza = bundle;
        this.zzb = zzn;
    }

    public final void run() {
        zzei zzei = this.zzc.zzb;
        if (zzei == null) {
            this.zzc.zzq().zze().zza("Failed to send default event parameters to service");
            return;
        }
        try {
            zzei.zza(this.zza, this.zzb);
        } catch (RemoteException e) {
            this.zzc.zzq().zze().zza("Failed to send default event parameters to service", e);
        }
    }
}
