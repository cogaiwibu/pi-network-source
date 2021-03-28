package com.tapjoy.internal;

public enum da {
    PREROLL("preroll"),
    MIDROLL("midroll"),
    POSTROLL("postroll"),
    STANDALONE("standalone");
    
    private final String e;

    private da(String str) {
        this.e = str;
    }

    public final String toString() {
        return this.e;
    }
}
