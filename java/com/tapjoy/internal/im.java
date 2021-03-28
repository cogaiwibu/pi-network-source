package com.tapjoy.internal;

import android.os.SystemClock;

public abstract class im implements Runnable {
    private final long a = 300;

    public abstract boolean a();

    public void run() {
        long elapsedRealtime = SystemClock.elapsedRealtime() + this.a;
        while (!a() && elapsedRealtime - SystemClock.elapsedRealtime() > 0) {
            try {
                Thread.sleep(0);
            } catch (InterruptedException unused) {
                return;
            }
        }
    }
}
