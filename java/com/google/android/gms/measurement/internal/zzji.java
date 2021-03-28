package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import android.text.TextUtils;
import java.util.Collections;
import java.util.concurrent.atomic.AtomicReference;

/* access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
public final class zzji implements Runnable {
    private final /* synthetic */ AtomicReference zza;
    private final /* synthetic */ String zzb;
    private final /* synthetic */ String zzc;
    private final /* synthetic */ String zzd;
    private final /* synthetic */ boolean zze;
    private final /* synthetic */ zzn zzf;
    private final /* synthetic */ zzir zzg;

    zzji(zzir zzir, AtomicReference atomicReference, String str, String str2, String str3, boolean z, zzn zzn) {
        this.zzg = zzir;
        this.zza = atomicReference;
        this.zzb = str;
        this.zzc = str2;
        this.zzd = str3;
        this.zze = z;
        this.zzf = zzn;
    }

    public final void run() {
        synchronized (this.zza) {
            try {
                zzei zzei = this.zzg.zzb;
                if (zzei == null) {
                    this.zzg.zzq().zze().zza("(legacy) Failed to get user properties; not connected to service", zzeq.zza(this.zzb), this.zzc, this.zzd);
                    this.zza.set(Collections.emptyList());
                    return;
                }
                if (TextUtils.isEmpty(this.zzb)) {
                    this.zza.set(zzei.zza(this.zzc, this.zzd, this.zze, this.zzf));
                } else {
                    this.zza.set(zzei.zza(this.zzb, this.zzc, this.zzd, this.zze));
                }
                this.zzg.zzaj();
                this.zza.notify();
            } catch (RemoteException e) {
                this.zzg.zzq().zze().zza("(legacy) Failed to get user properties; remote exception", zzeq.zza(this.zzb), this.zzc, e);
                this.zza.set(Collections.emptyList());
            } finally {
                this.zza.notify();
            }
        }
    }
}
