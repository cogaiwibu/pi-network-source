package com.facebook.imagepipeline.cache;

public interface ValueDescriptor<V> {
    int getSizeInBytes(V v);
}
