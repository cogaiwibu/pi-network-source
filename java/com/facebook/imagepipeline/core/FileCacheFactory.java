package com.facebook.imagepipeline.core;

import com.facebook.cache.disk.DiskCacheConfig;
import com.facebook.cache.disk.FileCache;

public interface FileCacheFactory {
    FileCache get(DiskCacheConfig diskCacheConfig);
}
