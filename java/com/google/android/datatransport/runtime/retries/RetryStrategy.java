package com.google.android.datatransport.runtime.retries;

/* compiled from: com.google.android.datatransport:transport-runtime@@2.2.0 */
public interface RetryStrategy<TInput, TResult> {
    TInput shouldRetry(TInput tinput, TResult tresult);
}
