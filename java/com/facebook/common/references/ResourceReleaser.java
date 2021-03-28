package com.facebook.common.references;

public interface ResourceReleaser<T> {
    void release(T t);
}
