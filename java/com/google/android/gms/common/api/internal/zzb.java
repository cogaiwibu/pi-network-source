package com.google.android.gms.common.api.internal;

/* compiled from: com.google.android.gms:play-services-basement@@17.1.1 */
final class zzb implements Runnable {
    private final /* synthetic */ LifecycleCallback zzbu;
    private final /* synthetic */ String zzbv;
    private final /* synthetic */ zza zzbw;

    zzb(zza zza, LifecycleCallback lifecycleCallback, String str) {
        this.zzbw = zza;
        this.zzbu = lifecycleCallback;
        this.zzbv = str;
    }

    public final void run() {
        if (this.zzbw.zzbs > 0) {
            this.zzbu.onCreate(this.zzbw.zzbt != null ? this.zzbw.zzbt.getBundle(this.zzbv) : null);
        }
        if (this.zzbw.zzbs >= 2) {
            this.zzbu.onStart();
        }
        if (this.zzbw.zzbs >= 3) {
            this.zzbu.onResume();
        }
        if (this.zzbw.zzbs >= 4) {
            this.zzbu.onStop();
        }
        if (this.zzbw.zzbs >= 5) {
            this.zzbu.onDestroy();
        }
    }
}
