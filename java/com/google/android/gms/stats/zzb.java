package com.google.android.gms.stats;

final class zzb implements Runnable {
    private final /* synthetic */ WakeLock zzp;

    zzb(WakeLock wakeLock) {
        this.zzp = wakeLock;
    }

    public final void run() {
        WakeLock.zza(this.zzp, 0);
    }
}
