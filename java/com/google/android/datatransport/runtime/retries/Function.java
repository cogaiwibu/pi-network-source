package com.google.android.datatransport.runtime.retries;

import java.lang.Throwable;

/* compiled from: com.google.android.datatransport:transport-runtime@@2.2.0 */
public interface Function<TInput, TResult, TException extends Throwable> {
    TResult apply(TInput tinput) throws Throwable;
}
