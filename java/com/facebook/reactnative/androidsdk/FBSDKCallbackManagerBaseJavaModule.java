package com.facebook.reactnative.androidsdk;

import com.facebook.CallbackManager;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;

public abstract class FBSDKCallbackManagerBaseJavaModule extends ReactContextBaseJavaModule {
    private final FBActivityEventListener mActivityEventListener;

    /* access modifiers changed from: protected */
    public CallbackManager getCallbackManager() {
        return this.mActivityEventListener.getCallbackManager();
    }

    protected FBSDKCallbackManagerBaseJavaModule(ReactApplicationContext reactApplicationContext, FBActivityEventListener fBActivityEventListener) {
        super(reactApplicationContext);
        this.mActivityEventListener = fBActivityEventListener;
        reactApplicationContext.addActivityEventListener(fBActivityEventListener);
    }
}
