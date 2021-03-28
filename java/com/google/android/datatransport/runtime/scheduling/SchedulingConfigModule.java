package com.google.android.datatransport.runtime.scheduling;

import com.google.android.datatransport.runtime.scheduling.jobscheduling.SchedulerConfig;
import com.google.android.datatransport.runtime.time.Clock;
import dagger.Module;
import dagger.Provides;

@Module
/* compiled from: com.google.android.datatransport:transport-runtime@@2.2.0 */
public abstract class SchedulingConfigModule {
    @Provides
    static SchedulerConfig config(Clock clock) {
        return SchedulerConfig.getDefault(clock);
    }
}
