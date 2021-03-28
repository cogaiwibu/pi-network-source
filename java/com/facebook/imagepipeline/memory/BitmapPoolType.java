package com.facebook.imagepipeline.memory;

public @interface BitmapPoolType {
    public static final String DEFAULT = "legacy";
    public static final String DUMMY = "dummy";
    public static final String DUMMY_WITH_TRACKING = "dummy_with_tracking";
    public static final String EXPERIMENTAL = "experimental";
    public static final String LEGACY = "legacy";
    public static final String LEGACY_DEFAULT_PARAMS = "legacy_default_params";
}
