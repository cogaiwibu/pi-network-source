package com.facebook.imagepipeline.memory;

public interface PoolStatsTracker {
    public static final String BUCKETS_USED_PREFIX = "buckets_used_";
    public static final String FREE_BYTES = "free_bytes";
    public static final String FREE_COUNT = "free_count";
    public static final String HARD_CAP = "hard_cap";
    public static final String SOFT_CAP = "soft_cap";
    public static final String USED_BYTES = "used_bytes";
    public static final String USED_COUNT = "used_count";

    void onAlloc(int i);

    void onFree(int i);

    void onHardCapReached();

    void onSoftCapReached();

    void onValueRelease(int i);

    void onValueReuse(int i);

    void setBasePool(BasePool basePool);
}
