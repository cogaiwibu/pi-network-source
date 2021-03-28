package com.google.android.datatransport.runtime.scheduling.persistence;

import com.google.android.datatransport.runtime.scheduling.persistence.AutoValue_EventStoreConfig;

/* access modifiers changed from: package-private */
/* compiled from: com.google.android.datatransport:transport-runtime@@2.2.0 */
public abstract class EventStoreConfig {
    static final EventStoreConfig DEFAULT = builder().setMaxStorageSizeInBytes(MAX_DB_STORAGE_SIZE_IN_BYTES).setLoadBatchSize(LOAD_BATCH_SIZE).setCriticalSectionEnterTimeoutMs(LOCK_TIME_OUT_MS).setEventCleanUpAge(DURATION_ONE_WEEK_MS).build();
    private static final long DURATION_ONE_WEEK_MS = 604800000;
    private static final int LOAD_BATCH_SIZE = 200;
    private static final int LOCK_TIME_OUT_MS = 10000;
    private static final long MAX_DB_STORAGE_SIZE_IN_BYTES = 10485760;

    /* access modifiers changed from: package-private */
    public abstract int getCriticalSectionEnterTimeoutMs();

    /* access modifiers changed from: package-private */
    public abstract long getEventCleanUpAge();

    /* access modifiers changed from: package-private */
    public abstract int getLoadBatchSize();

    /* access modifiers changed from: package-private */
    public abstract long getMaxStorageSizeInBytes();

    EventStoreConfig() {
    }

    static Builder builder() {
        return new AutoValue_EventStoreConfig.Builder();
    }

    /* access modifiers changed from: package-private */
    public Builder toBuilder() {
        return builder().setMaxStorageSizeInBytes(getMaxStorageSizeInBytes()).setLoadBatchSize(getLoadBatchSize()).setCriticalSectionEnterTimeoutMs(getCriticalSectionEnterTimeoutMs()).setEventCleanUpAge(getEventCleanUpAge());
    }

    /* compiled from: com.google.android.datatransport:transport-runtime@@2.2.0 */
    static abstract class Builder {
        /* access modifiers changed from: package-private */
        public abstract EventStoreConfig build();

        /* access modifiers changed from: package-private */
        public abstract Builder setCriticalSectionEnterTimeoutMs(int i);

        /* access modifiers changed from: package-private */
        public abstract Builder setEventCleanUpAge(long j);

        /* access modifiers changed from: package-private */
        public abstract Builder setLoadBatchSize(int i);

        /* access modifiers changed from: package-private */
        public abstract Builder setMaxStorageSizeInBytes(long j);

        Builder() {
        }
    }
}
