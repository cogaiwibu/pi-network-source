package com.tapjoy.internal;

import java.util.Iterator;

public abstract class jw implements Iterator {
    protected jw() {
    }

    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
