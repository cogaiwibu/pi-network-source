package com.facebook.fbreact.specs;

import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReactModuleWithSpec;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.turbomodule.core.interfaces.TurboModule;

public abstract class NativeAnimatedModuleSpec extends ReactContextBaseJavaModule implements ReactModuleWithSpec, TurboModule {
    @ReactMethod
    public abstract void addAnimatedEventToView(double d, String str, ReadableMap readableMap);

    @ReactMethod
    public abstract void addListener(String str);

    @ReactMethod
    public abstract void connectAnimatedNodeToView(double d, double d2);

    @ReactMethod
    public abstract void connectAnimatedNodes(double d, double d2);

    @ReactMethod
    public abstract void createAnimatedNode(double d, ReadableMap readableMap);

    @ReactMethod
    public abstract void disconnectAnimatedNodeFromView(double d, double d2);

    @ReactMethod
    public abstract void disconnectAnimatedNodes(double d, double d2);

    @ReactMethod
    public abstract void dropAnimatedNode(double d);

    @ReactMethod
    public abstract void extractAnimatedNodeOffset(double d);

    @ReactMethod
    public abstract void flattenAnimatedNodeOffset(double d);

    @ReactMethod
    public abstract void removeAnimatedEventFromView(double d, String str, double d2);

    @ReactMethod
    public abstract void removeListeners(double d);

    @ReactMethod
    public abstract void restoreDefaultValues(double d);

    @ReactMethod
    public abstract void setAnimatedNodeOffset(double d, double d2);

    @ReactMethod
    public abstract void setAnimatedNodeValue(double d, double d2);

    @ReactMethod
    public abstract void startAnimatingNode(double d, double d2, ReadableMap readableMap, Callback callback);

    @ReactMethod
    public abstract void startListeningToAnimatedNodeValue(double d);

    @ReactMethod
    public abstract void stopAnimation(double d);

    @ReactMethod
    public abstract void stopListeningToAnimatedNodeValue(double d);

    public NativeAnimatedModuleSpec(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }
}
