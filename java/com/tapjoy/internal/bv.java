package com.tapjoy.internal;

import java.io.IOException;

public final class bv extends IOException {
    public bv(Throwable th) {
        super(th.getMessage());
    }
}
