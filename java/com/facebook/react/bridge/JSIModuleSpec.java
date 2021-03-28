package com.facebook.react.bridge;

import com.facebook.react.bridge.JSIModule;

public interface JSIModuleSpec<T extends JSIModule> {
    JSIModuleProvider<T> getJSIModuleProvider();

    JSIModuleType getJSIModuleType();
}
