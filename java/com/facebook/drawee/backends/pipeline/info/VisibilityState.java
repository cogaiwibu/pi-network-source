package com.facebook.drawee.backends.pipeline.info;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
public @interface VisibilityState {
    public static final int INVISIBLE = 2;
    public static final int UNKNOWN = -1;
    public static final int VISIBLE = 1;
}
