package com.google.android.gms.common.util;

/* compiled from: com.google.android.gms:play-services-basement@@17.1.1 */
public interface Clock {
    long currentThreadTimeMillis();

    long currentTimeMillis();

    long elapsedRealtime();

    long nanoTime();
}
