package com.tapjoy.internal;

import android.os.SystemClock;

public final class fi {
    public static final fi a = new fi(-1);
    public final long b;
    public long c;

    public fi(long j) {
        this.b = j;
        this.c = SystemClock.elapsedRealtime();
    }

    public fi() {
        this.b = 3600000;
        try {
            this.c = SystemClock.elapsedRealtime() - 3600000;
        } catch (NullPointerException unused) {
            this.c = -1;
        }
    }

    public final boolean a() {
        try {
            return SystemClock.elapsedRealtime() - this.c > this.b;
        } catch (NullPointerException unused) {
            return true;
        }
    }

    public final boolean a(long j) {
        try {
            return (SystemClock.elapsedRealtime() - this.c) + j > this.b;
        } catch (NullPointerException unused) {
            return true;
        }
    }
}
