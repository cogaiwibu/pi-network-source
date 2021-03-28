package com.facebook.react.common;

import androidx.core.util.Pools;

public class ClearableSynchronizedPool<T> implements Pools.Pool<T> {
    private final Object[] mPool;
    private int mSize = 0;

    public ClearableSynchronizedPool(int i) {
        this.mPool = new Object[i];
    }

    @Override // androidx.core.util.Pools.Pool
    public synchronized T acquire() {
        if (this.mSize == 0) {
            return null;
        }
        int i = this.mSize - 1;
        this.mSize = i;
        T t = (T) this.mPool[i];
        this.mPool[i] = null;
        return t;
    }

    @Override // androidx.core.util.Pools.Pool
    public synchronized boolean release(T t) {
        if (this.mSize == this.mPool.length) {
            return false;
        }
        this.mPool[this.mSize] = t;
        this.mSize++;
        return true;
    }

    public synchronized void clear() {
        for (int i = 0; i < this.mSize; i++) {
            this.mPool[i] = null;
        }
        this.mSize = 0;
    }
}
