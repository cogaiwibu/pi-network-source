package com.tapjoy.internal;

public enum cw {
    NATIVE("native"),
    JAVASCRIPT("javascript"),
    NONE("none");
    
    private final String d;

    private cw(String str) {
        this.d = str;
    }

    public final String toString() {
        return this.d;
    }
}
