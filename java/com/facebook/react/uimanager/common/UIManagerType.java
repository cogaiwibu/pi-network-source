package com.facebook.react.uimanager.common;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
public @interface UIManagerType {
    public static final int DEFAULT = 1;
    public static final int FABRIC = 2;
}
