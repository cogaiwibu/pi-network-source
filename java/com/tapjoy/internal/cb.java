package com.tapjoy.internal;

public final class cb extends RuntimeException {
    public final int a;

    public cb(int i, String str) {
        super(str);
        this.a = i;
    }
}
