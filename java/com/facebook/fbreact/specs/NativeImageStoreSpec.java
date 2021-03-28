package com.facebook.fbreact.specs;

import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReactModuleWithSpec;
import com.facebook.react.turbomodule.core.interfaces.TurboModule;

public abstract class NativeImageStoreSpec extends ReactContextBaseJavaModule implements ReactModuleWithSpec, TurboModule {
    @ReactMethod
    public abstract void addImageFromBase64(String str, Callback callback, Callback callback2);

    @ReactMethod
    public abstract void getBase64ForTag(String str, Callback callback, Callback callback2);

    @ReactMethod
    public abstract void hasImageForTag(String str, Callback callback);

    @ReactMethod
    public abstract void removeImageForTag(String str);

    public NativeImageStoreSpec(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }
}
