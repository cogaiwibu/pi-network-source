package com.google.android.gms.common.data;

import android.os.Bundle;
import com.google.android.gms.common.api.Releasable;
import java.io.Closeable;
import java.util.Iterator;

/* compiled from: com.google.android.gms:play-services-base@@17.1.0 */
public interface DataBuffer<T> extends Releasable, Closeable, Iterable<T> {
    @Override // java.io.Closeable, java.lang.AutoCloseable
    void close();

    T get(int i);

    int getCount();

    Bundle getMetadata();

    @Deprecated
    boolean isClosed();

    @Override // java.lang.Iterable
    Iterator<T> iterator();

    @Override // com.google.android.gms.common.api.Releasable
    void release();

    Iterator<T> singleRefIterator();
}
