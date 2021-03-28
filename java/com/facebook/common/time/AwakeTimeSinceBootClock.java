package com.facebook.common.time;

import android.os.SystemClock;

public class AwakeTimeSinceBootClock implements MonotonicClock {
    private static final AwakeTimeSinceBootClock INSTANCE = new AwakeTimeSinceBootClock();

    private AwakeTimeSinceBootClock() {
    }

    public static AwakeTimeSinceBootClock get() {
        return INSTANCE;
    }

    @Override // com.facebook.common.time.MonotonicClock
    public long now() {
        return SystemClock.uptimeMillis();
    }
}
