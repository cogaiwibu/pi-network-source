package com.facebook.imagepipeline.memory;

import com.facebook.common.memory.MemoryTrimmableRegistry;

public class NativeMemoryChunkPool extends MemoryChunkPool {
    public NativeMemoryChunkPool(MemoryTrimmableRegistry memoryTrimmableRegistry, PoolParams poolParams, PoolStatsTracker poolStatsTracker) {
        super(memoryTrimmableRegistry, poolParams, poolStatsTracker);
    }

    /* Return type fixed from 'com.facebook.imagepipeline.memory.NativeMemoryChunk' to match base method */
    /* access modifiers changed from: protected */
    @Override // com.facebook.imagepipeline.memory.BasePool, com.facebook.imagepipeline.memory.MemoryChunkPool, com.facebook.imagepipeline.memory.MemoryChunkPool
    public MemoryChunk alloc(int i) {
        return new NativeMemoryChunk(i);
    }
}
