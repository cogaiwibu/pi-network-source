package com.google.android.gms.common.api.internal;

/* compiled from: com.google.android.gms:play-services-basement@@17.1.1 */
final class zzc implements Runnable {
    private final /* synthetic */ LifecycleCallback zzbu;
    private final /* synthetic */ String zzbv;
    private final /* synthetic */ zzd zzbx;

    zzc(zzd zzd, LifecycleCallback lifecycleCallback, String str) {
        this.zzbx = zzd;
        this.zzbu = lifecycleCallback;
        this.zzbv = str;
    }

    public final void run() {
        if (this.zzbx.zzbs > 0) {
            this.zzbu.onCreate(this.zzbx.zzbt != null ? this.zzbx.zzbt.getBundle(this.zzbv) : null);
        }
        if (this.zzbx.zzbs >= 2) {
            this.zzbu.onStart();
        }
        if (this.zzbx.zzbs >= 3) {
            this.zzbu.onResume();
        }
        if (this.zzbx.zzbs >= 4) {
            this.zzbu.onStop();
        }
        if (this.zzbx.zzbs >= 5) {
            this.zzbu.onDestroy();
        }
    }
}
