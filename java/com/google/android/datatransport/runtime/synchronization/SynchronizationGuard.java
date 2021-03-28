package com.google.android.datatransport.runtime.synchronization;

/* compiled from: com.google.android.datatransport:transport-runtime@@2.2.0 */
public interface SynchronizationGuard {

    /* compiled from: com.google.android.datatransport:transport-runtime@@2.2.0 */
    public interface CriticalSection<T> {
        T execute();
    }

    <T> T runCriticalSection(CriticalSection<T> criticalSection);
}
