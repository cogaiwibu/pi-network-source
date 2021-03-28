package com.google.android.gms.cloudmessaging;

/* compiled from: com.google.android.gms:play-services-cloud-messaging@@16.0.0 */
final /* synthetic */ class zzm implements Runnable {
    private final zzf zza;

    zzm(zzf zzf) {
        this.zza = zzf;
    }

    public final void run() {
        this.zza.zza(2, "Service disconnected");
    }
}
