package com.facebook.react.fabric;

import com.facebook.jni.HybridData;

public class ComponentFactoryDelegate {
    private final HybridData mHybridData = initHybrid();

    private static native HybridData initHybrid();

    static {
        FabricSoLoader.staticInit();
    }
}
