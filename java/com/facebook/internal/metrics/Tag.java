package com.facebook.internal.metrics;

public enum Tag {
    FACEBOOK_CORE_STARTUP("facebook_core_startup");
    
    private final String suffix;

    private Tag(String str) {
        this.suffix = str;
    }

    public String getSuffix() {
        return this.suffix;
    }
}
