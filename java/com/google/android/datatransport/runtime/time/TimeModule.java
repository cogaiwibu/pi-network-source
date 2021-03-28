package com.google.android.datatransport.runtime.time;

import dagger.Module;
import dagger.Provides;

@Module
/* compiled from: com.google.android.datatransport:transport-runtime@@2.2.0 */
public abstract class TimeModule {
    @Provides
    static Clock eventClock() {
        return new WallTimeClock();
    }

    @Provides
    static Clock uptimeClock() {
        return new UptimeClock();
    }
}
