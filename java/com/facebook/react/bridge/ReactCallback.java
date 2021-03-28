package com.facebook.react.bridge;

/* access modifiers changed from: package-private */
public interface ReactCallback {
    void decrementPendingJSCalls();

    void incrementPendingJSCalls();

    void onBatchComplete();
}
