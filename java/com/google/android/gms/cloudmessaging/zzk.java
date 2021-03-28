package com.google.android.gms.cloudmessaging;

import android.os.IBinder;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-cloud-messaging@@16.0.0 */
final /* synthetic */ class zzk implements Runnable {
    private final zzf zza;
    private final IBinder zzb;

    zzk(zzf zzf, IBinder iBinder) {
        this.zza = zzf;
        this.zzb = iBinder;
    }

    public final void run() {
        zzf zzf = this.zza;
        IBinder iBinder = this.zzb;
        synchronized (zzf) {
            if (iBinder == null) {
                zzf.zza(0, "Null service connection");
                return;
            }
            try {
                zzf.zzc = new zzo(iBinder);
                zzf.zza = 2;
                zzf.zza();
            } catch (RemoteException e) {
                zzf.zza(0, e.getMessage());
            }
        }
    }
}
