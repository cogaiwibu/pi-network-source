package com.facebook.react.bridge.queue;

import com.facebook.jni.HybridData;

public class NativeRunnable implements Runnable {
    private final HybridData mHybridData;

    public native void run();

    private NativeRunnable(HybridData hybridData) {
        this.mHybridData = hybridData;
    }
}
