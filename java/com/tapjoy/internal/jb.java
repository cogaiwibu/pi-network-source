package com.tapjoy.internal;

import java.io.Closeable;
import java.io.Flushable;

public interface jb extends Closeable, Flushable {
    void a(ir irVar, long j);

    @Override // java.io.Closeable, java.lang.AutoCloseable
    void close();

    @Override // java.io.Flushable
    void flush();
}
