package com.facebook.imagepipeline.memory;

import javax.annotation.Nullable;

interface PoolBackend<T> {
    @Nullable
    T get(int i);

    int getSize(T t);

    @Nullable
    T pop();

    void put(T t);
}
