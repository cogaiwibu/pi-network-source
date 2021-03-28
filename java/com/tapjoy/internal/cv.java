package com.tapjoy.internal;

import com.tapjoy.TJAdUnitConstants;

public enum cv {
    HTML(TJAdUnitConstants.String.HTML),
    NATIVE("native");
    
    private final String c;

    private cv(String str) {
        this.c = str;
    }

    public final String toString() {
        return this.c;
    }
}
