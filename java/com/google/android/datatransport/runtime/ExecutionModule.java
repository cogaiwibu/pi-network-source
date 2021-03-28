package com.google.android.datatransport.runtime;

import dagger.Module;
import dagger.Provides;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import javax.inject.Singleton;

/* access modifiers changed from: package-private */
@Module
/* compiled from: com.google.android.datatransport:transport-runtime@@2.2.0 */
public abstract class ExecutionModule {
    ExecutionModule() {
    }

    @Provides
    @Singleton
    static Executor executor() {
        return Executors.newSingleThreadExecutor();
    }
}
