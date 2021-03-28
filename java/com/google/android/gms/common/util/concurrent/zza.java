package com.google.android.gms.common.util.concurrent;

import android.os.Process;

/* compiled from: com.google.android.gms:play-services-basement@@17.1.1 */
final class zza implements Runnable {
    private final int priority;
    private final Runnable zzii;

    public zza(Runnable runnable, int i) {
        this.zzii = runnable;
        this.priority = i;
    }

    public final void run() {
        Process.setThreadPriority(this.priority);
        this.zzii.run();
    }
}
