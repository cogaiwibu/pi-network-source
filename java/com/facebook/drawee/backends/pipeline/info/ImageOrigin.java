package com.facebook.drawee.backends.pipeline.info;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
public @interface ImageOrigin {
    public static final int DISK = 3;
    public static final int LOCAL = 6;
    public static final int MEMORY_BITMAP = 5;
    public static final int MEMORY_ENCODED = 4;
    public static final int NETWORK = 2;
    public static final int UNKNOWN = 1;
}
