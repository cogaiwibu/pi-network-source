package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import com.google.android.gms.internal.measurement.zzml;
import com.google.android.gms.internal.measurement.zzw;

/* access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
public final class zziw implements Runnable {
    private final /* synthetic */ zzn zza;
    private final /* synthetic */ zzw zzb;
    private final /* synthetic */ zzir zzc;

    zziw(zzir zzir, zzn zzn, zzw zzw) {
        this.zzc = zzir;
        this.zza = zzn;
        this.zzb = zzw;
    }

    public final void run() {
        try {
            if (!zzml.zzb() || !this.zzc.zzs().zza(zzas.zzcg) || this.zzc.zzr().zzx().zze()) {
                zzei zzei = this.zzc.zzb;
                if (zzei == null) {
                    this.zzc.zzq().zze().zza("Failed to get app instance id");
                    this.zzc.zzo().zza(this.zzb, (String) null);
                    return;
                }
                String zzc2 = zzei.zzc(this.zza);
                if (zzc2 != null) {
                    this.zzc.zze().zza(zzc2);
                    this.zzc.zzr().zzj.zza(zzc2);
                }
                this.zzc.zzaj();
                this.zzc.zzo().zza(this.zzb, zzc2);
                return;
            }
            this.zzc.zzq().zzj().zza("Analytics storage consent denied; will not get app instance id");
            this.zzc.zze().zza((String) null);
            this.zzc.zzr().zzj.zza(null);
        } catch (RemoteException e) {
            this.zzc.zzq().zze().zza("Failed to get app instance id", e);
        } finally {
            this.zzc.zzo().zza(this.zzb, (String) null);
        }
    }
}
