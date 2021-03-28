package com.google.android.datatransport.runtime.time;

import android.os.SystemClock;

/* compiled from: com.google.android.datatransport:transport-runtime@@2.2.0 */
public class UptimeClock implements Clock {
    @Override // com.google.android.datatransport.runtime.time.Clock
    public long getTime() {
        return SystemClock.elapsedRealtime();
    }
}
