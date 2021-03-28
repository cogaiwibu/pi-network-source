package com.facebook.reactnative.androidsdk;

import com.facebook.internal.NativeProtocol;
import com.facebook.login.DefaultAudience;
import com.facebook.login.LoginBehavior;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.annotations.ReactProp;

public class FBLoginButtonManager extends SimpleViewManager<RCTLoginButton> {
    public static final String REACT_CLASS = "RCTFBLoginButton";
    private FBActivityEventListener mActivityEventListener;

    @Override // com.facebook.react.bridge.NativeModule, com.facebook.react.uimanager.ViewManager
    public String getName() {
        return REACT_CLASS;
    }

    public FBLoginButtonManager(ReactApplicationContext reactApplicationContext) {
        FBActivityEventListener fBActivityEventListener = new FBActivityEventListener();
        this.mActivityEventListener = fBActivityEventListener;
        reactApplicationContext.addActivityEventListener(fBActivityEventListener);
    }

    @Override // com.facebook.react.uimanager.ViewManager
    public RCTLoginButton createViewInstance(ThemedReactContext themedReactContext) {
        return new RCTLoginButton(themedReactContext, this.mActivityEventListener.getCallbackManager());
    }

    @ReactProp(name = "loginBehaviorAndroid")
    public void setLoginBehavior(RCTLoginButton rCTLoginButton, String str) {
        rCTLoginButton.setLoginBehavior(LoginBehavior.valueOf(str.toUpperCase()));
    }

    @ReactProp(name = "defaultAudience")
    public void setDefaultAudience(RCTLoginButton rCTLoginButton, String str) {
        rCTLoginButton.setDefaultAudience(DefaultAudience.valueOf(str.toUpperCase()));
    }

    @ReactProp(name = NativeProtocol.RESULT_ARGS_PERMISSIONS)
    public void setPermissions(RCTLoginButton rCTLoginButton, ReadableArray readableArray) {
        rCTLoginButton.setPermissions(Utility.reactArrayToStringList(readableArray));
    }
}
