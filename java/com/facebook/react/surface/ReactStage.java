package com.facebook.react.surface;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
public @interface ReactStage {
    public static final int BRIDGE_DID_LOAD = 1;
    public static final int MODULE_DID_LOAD = 2;
    public static final int ON_ATTACH_TO_INSTANCE = 101;
    public static final int SURFACE_DID_INITIALIZE = 0;
    public static final int SURFACE_DID_INITIAL_LAYOUT = 5;
    public static final int SURFACE_DID_INITIAL_MOUNTING = 6;
    public static final int SURFACE_DID_INITIAL_RENDERING = 4;
    public static final int SURFACE_DID_RUN = 3;
    public static final int SURFACE_DID_STOP = 7;
}
