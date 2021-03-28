package com.google.android.datatransport.runtime.time;

/* compiled from: com.google.android.datatransport:transport-runtime@@2.2.0 */
public class WallTimeClock implements Clock {
    @Override // com.google.android.datatransport.runtime.time.Clock
    public long getTime() {
        return System.currentTimeMillis();
    }
}
