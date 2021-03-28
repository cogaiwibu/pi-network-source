package com.anythink.reactnativejs;

import android.app.Activity;
import com.anythink.reactnativejs.utils.MsgTools;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.modules.core.DeviceEventManagerModule;

public abstract class AnythinkReactContextBaseJavaModule extends ReactContextBaseJavaModule {
    private static final String TAG = AnythinkReactContextBaseJavaModule.class.getSimpleName();
    protected ReactApplicationContext mApplicationContext;

    public AnythinkReactContextBaseJavaModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
        this.mApplicationContext = reactApplicationContext;
    }

    public void sendEvent(String str, Object obj) {
        ReactApplicationContext reactApplicationContext = this.mApplicationContext;
        if (reactApplicationContext == null) {
            MsgTools.pirntMsg("AnythinkReactContextBaseJavaModule - mApplicationContext = null");
        } else {
            ((DeviceEventManagerModule.RCTDeviceEventEmitter) reactApplicationContext.getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)).emit(str, obj);
        }
    }

    public Activity getActivity() {
        ReactApplicationContext reactApplicationContext = this.mApplicationContext;
        if (reactApplicationContext != null) {
            return reactApplicationContext.getCurrentActivity();
        }
        MsgTools.pirntMsg("AnythinkReactContextBaseJavaModule - mApplicationContext = null");
        return null;
    }
}
