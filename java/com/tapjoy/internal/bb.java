package com.tapjoy.internal;

import java.util.concurrent.Callable;

public interface bb extends Callable {
    @Override // java.util.concurrent.Callable
    Object call();
}
