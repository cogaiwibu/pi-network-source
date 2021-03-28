package com.facebook.drawee.backends.pipeline.info;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
public @interface ImageLoadStatus {
    public static final int CANCELED = 4;
    public static final int ERROR = 5;
    public static final int INTERMEDIATE_AVAILABLE = 2;
    public static final int ORIGIN_AVAILABLE = 1;
    public static final int REQUESTED = 0;
    public static final int SUCCESS = 3;
    public static final int UNKNOWN = -1;
}
