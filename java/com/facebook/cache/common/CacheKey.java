package com.facebook.cache.common;

import android.net.Uri;

public interface CacheKey {
    boolean containsUri(Uri uri);

    boolean equals(Object obj);

    String getUriString();

    int hashCode();

    String toString();
}
