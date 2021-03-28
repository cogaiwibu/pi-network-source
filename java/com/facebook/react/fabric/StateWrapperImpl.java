package com.facebook.react.fabric;

import com.facebook.jni.HybridData;
import com.facebook.react.bridge.NativeMap;
import com.facebook.react.bridge.ReadableNativeMap;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.StateWrapper;

public class StateWrapperImpl implements StateWrapper {
    private final HybridData mHybridData = initHybrid();

    private static native HybridData initHybrid();

    @Override // com.facebook.react.uimanager.StateWrapper
    public native ReadableNativeMap getState();

    public native void updateStateImpl(NativeMap nativeMap);

    static {
        FabricSoLoader.staticInit();
    }

    private StateWrapperImpl() {
    }

    @Override // com.facebook.react.uimanager.StateWrapper
    public void updateState(WritableMap writableMap) {
        updateStateImpl((NativeMap) writableMap);
    }
}
