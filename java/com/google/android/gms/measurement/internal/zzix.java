package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import com.google.android.gms.internal.measurement.zzml;
import java.util.concurrent.atomic.AtomicReference;

/* access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
public final class zzix implements Runnable {
    private final /* synthetic */ AtomicReference zza;
    private final /* synthetic */ zzn zzb;
    private final /* synthetic */ zzir zzc;

    zzix(zzir zzir, AtomicReference atomicReference, zzn zzn) {
        this.zzc = zzir;
        this.zza = atomicReference;
        this.zzb = zzn;
    }

    public final void run() {
        synchronized (this.zza) {
            try {
                if (!zzml.zzb() || !this.zzc.zzs().zza(zzas.zzcg) || this.zzc.zzr().zzx().zze()) {
                    zzei zzei = this.zzc.zzb;
                    if (zzei == null) {
                        this.zzc.zzq().zze().zza("Failed to get app instance id");
                        this.zza.notify();
                        return;
                    }
                    this.zza.set(zzei.zzc(this.zzb));
                    String str = (String) this.zza.get();
                    if (str != null) {
                        this.zzc.zze().zza(str);
                        this.zzc.zzr().zzj.zza(str);
                    }
                    this.zzc.zzaj();
                    this.zza.notify();
                    return;
                }
                this.zzc.zzq().zzj().zza("Analytics storage consent denied; will not get app instance id");
                this.zzc.zze().zza((String) null);
                this.zzc.zzr().zzj.zza(null);
                this.zza.set(null);
            } catch (RemoteException e) {
                this.zzc.zzq().zze().zza("Failed to get app instance id", e);
            } finally {
                this.zza.notify();
            }
        }
    }
}
