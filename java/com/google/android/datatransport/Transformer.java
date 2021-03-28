package com.google.android.datatransport;

/* compiled from: com.google.android.datatransport:transport-api@@2.2.0 */
public interface Transformer<T, U> {
    U apply(T t);
}
