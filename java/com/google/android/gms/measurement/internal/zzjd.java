package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import com.google.android.gms.internal.measurement.zzw;

/* access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
public final class zzjd implements Runnable {
    private final /* synthetic */ zzaq zza;
    private final /* synthetic */ String zzb;
    private final /* synthetic */ zzw zzc;
    private final /* synthetic */ zzir zzd;

    zzjd(zzir zzir, zzaq zzaq, String str, zzw zzw) {
        this.zzd = zzir;
        this.zza = zzaq;
        this.zzb = str;
        this.zzc = zzw;
    }

    public final void run() {
        try {
            zzei zzei = this.zzd.zzb;
            if (zzei == null) {
                this.zzd.zzq().zze().zza("Discarding data. Failed to send event to service to bundle");
                return;
            }
            byte[] zza2 = zzei.zza(this.zza, this.zzb);
            this.zzd.zzaj();
            this.zzd.zzo().zza(this.zzc, zza2);
        } catch (RemoteException e) {
            this.zzd.zzq().zze().zza("Failed to send event to the service to bundle", e);
        } finally {
            this.zzd.zzo().zza(this.zzc, (byte[]) null);
        }
    }
}
