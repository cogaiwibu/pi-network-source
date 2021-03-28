package com.facebook.common.time;

public interface Clock {
    public static final long MAX_TIME = Long.MAX_VALUE;

    long now();
}
