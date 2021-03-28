package com.facebook.react.turbomodule.core;

import com.facebook.jni.HybridData;
import com.facebook.react.turbomodule.core.interfaces.CallInvokerHolder;
import com.facebook.soloader.SoLoader;

public class CallInvokerHolderImpl implements CallInvokerHolder {
    private final HybridData mHybridData;

    static {
        SoLoader.loadLibrary("turbomodulejsijni");
    }

    private CallInvokerHolderImpl(HybridData hybridData) {
        this.mHybridData = hybridData;
    }
}
