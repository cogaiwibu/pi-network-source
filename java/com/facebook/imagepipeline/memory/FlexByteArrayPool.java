package com.facebook.imagepipeline.memory;

import com.facebook.common.internal.Preconditions;
import com.facebook.common.memory.MemoryTrimmableRegistry;
import com.facebook.common.references.CloseableReference;
import com.facebook.common.references.ResourceReleaser;
import java.util.Map;

public class FlexByteArrayPool {
    final SoftRefByteArrayPool mDelegatePool;
    private final ResourceReleaser<byte[]> mResourceReleaser;

    public FlexByteArrayPool(MemoryTrimmableRegistry memoryTrimmableRegistry, PoolParams poolParams) {
        Preconditions.checkArgument(poolParams.maxNumThreads > 0);
        this.mDelegatePool = new SoftRefByteArrayPool(memoryTrimmableRegistry, poolParams, NoOpPoolStatsTracker.getInstance());
        this.mResourceReleaser = new ResourceReleaser<byte[]>() {
            /* class com.facebook.imagepipeline.memory.FlexByteArrayPool.AnonymousClass1 */

            public void release(byte[] bArr) {
                FlexByteArrayPool.this.release(bArr);
            }
        };
    }

    public CloseableReference<byte[]> get(int i) {
        return CloseableReference.of(this.mDelegatePool.get(i), this.mResourceReleaser);
    }

    public void release(byte[] bArr) {
        this.mDelegatePool.release(bArr);
    }

    public Map<String, Integer> getStats() {
        return this.mDelegatePool.getStats();
    }

    public int getMinBufferSize() {
        return this.mDelegatePool.getMinBufferSize();
    }

    /* access modifiers changed from: package-private */
    public static class SoftRefByteArrayPool extends GenericByteArrayPool {
        public SoftRefByteArrayPool(MemoryTrimmableRegistry memoryTrimmableRegistry, PoolParams poolParams, PoolStatsTracker poolStatsTracker) {
            super(memoryTrimmableRegistry, poolParams, poolStatsTracker);
        }

        /* access modifiers changed from: package-private */
        @Override // com.facebook.imagepipeline.memory.BasePool
        public Bucket<byte[]> newBucket(int i) {
            return new OOMSoftReferenceBucket(getSizeInBytes(i), this.mPoolParams.maxNumThreads, 0);
        }
    }
}
