package com.facebook.react.turbomodule.core;

import com.facebook.jni.HybridData;
import com.facebook.react.bridge.JSIModule;
import com.facebook.react.bridge.JavaScriptContextHolder;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.turbomodule.core.interfaces.CallInvokerHolder;
import com.facebook.react.turbomodule.core.interfaces.TurboModule;
import com.facebook.react.turbomodule.core.interfaces.TurboModuleRegistry;
import com.facebook.soloader.SoLoader;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class TurboModuleManager implements JSIModule, TurboModuleRegistry {
    private final HybridData mHybridData;
    private final Map<String, TurboModule> mTurboModules = new HashMap();
    private final TurboModuleManagerDelegate mTurbomoduleManagerDelegate;

    private native HybridData initHybrid(long j, CallInvokerHolderImpl callInvokerHolderImpl, CallInvokerHolderImpl callInvokerHolderImpl2, TurboModuleManagerDelegate turboModuleManagerDelegate);

    private native void installJSIBindings();

    @Override // com.facebook.react.bridge.JSIModule
    public void initialize() {
    }

    static {
        SoLoader.loadLibrary("turbomodulejsijni");
    }

    public TurboModuleManager(JavaScriptContextHolder javaScriptContextHolder, TurboModuleManagerDelegate turboModuleManagerDelegate, CallInvokerHolder callInvokerHolder, CallInvokerHolder callInvokerHolder2) {
        this.mHybridData = initHybrid(javaScriptContextHolder.get(), (CallInvokerHolderImpl) callInvokerHolder, (CallInvokerHolderImpl) callInvokerHolder2, turboModuleManagerDelegate);
        this.mTurbomoduleManagerDelegate = turboModuleManagerDelegate;
    }

    @Override // com.facebook.react.turbomodule.core.interfaces.TurboModuleRegistry
    public List<String> getEagerInitModuleNames() {
        return this.mTurbomoduleManagerDelegate.getEagerInitModuleNames();
    }

    /* access modifiers changed from: protected */
    public TurboModule getJavaModule(String str) {
        TurboModule module;
        if (!this.mTurboModules.containsKey(str) && (module = this.mTurbomoduleManagerDelegate.getModule(str)) != null) {
            ((NativeModule) module).initialize();
            this.mTurboModules.put(str, module);
        }
        return this.mTurboModules.get(str);
    }

    @Override // com.facebook.react.turbomodule.core.interfaces.TurboModuleRegistry
    public TurboModule getModule(String str) {
        return getJavaModule(str);
    }

    @Override // com.facebook.react.turbomodule.core.interfaces.TurboModuleRegistry
    public Collection<TurboModule> getModules() {
        return this.mTurboModules.values();
    }

    @Override // com.facebook.react.turbomodule.core.interfaces.TurboModuleRegistry
    public boolean hasModule(String str) {
        return this.mTurboModules.containsKey(str);
    }

    public void installBindings() {
        installJSIBindings();
    }

    @Override // com.facebook.react.bridge.JSIModule
    public void onCatalystInstanceDestroy() {
        Iterator<TurboModule> it = this.mTurboModules.values().iterator();
        while (it.hasNext()) {
            ((NativeModule) it.next()).onCatalystInstanceDestroy();
        }
        this.mTurboModules.clear();
        this.mHybridData.resetNative();
    }
}
