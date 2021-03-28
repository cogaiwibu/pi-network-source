package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import java.util.concurrent.atomic.AtomicReference;

/* access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
public final class zziv implements Runnable {
    private final /* synthetic */ AtomicReference zza;
    private final /* synthetic */ zzn zzb;
    private final /* synthetic */ boolean zzc;
    private final /* synthetic */ zzir zzd;

    zziv(zzir zzir, AtomicReference atomicReference, zzn zzn, boolean z) {
        this.zzd = zzir;
        this.zza = atomicReference;
        this.zzb = zzn;
        this.zzc = z;
    }

    public final void run() {
        synchronized (this.zza) {
            try {
                zzei zzei = this.zzd.zzb;
                if (zzei == null) {
                    this.zzd.zzq().zze().zza("Failed to get all user properties; not connected to service");
                    return;
                }
                this.zza.set(zzei.zza(this.zzb, this.zzc));
                this.zzd.zzaj();
                this.zza.notify();
            } catch (RemoteException e) {
                this.zzd.zzq().zze().zza("Failed to get all user properties; remote exception", e);
            } finally {
                this.zza.notify();
            }
        }
    }
}
