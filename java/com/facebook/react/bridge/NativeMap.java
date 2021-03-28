package com.facebook.react.bridge;

import com.facebook.jni.HybridData;

public abstract class NativeMap {
    private HybridData mHybridData;

    public native String toString();

    static {
        ReactBridge.staticInit();
    }

    public NativeMap(HybridData hybridData) {
        this.mHybridData = hybridData;
    }
}
