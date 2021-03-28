package com.facebook.reactnative.androidsdk;

import android.app.Activity;
import com.facebook.AccessToken;
import com.facebook.login.DefaultAudience;
import com.facebook.login.LoginBehavior;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.module.annotations.ReactModule;
import java.util.Set;

@ReactModule(name = FBLoginManagerModule.NAME)
public class FBLoginManagerModule extends FBSDKCallbackManagerBaseJavaModule {
    public static final String NAME = "FBLoginManager";

    @Override // com.facebook.react.bridge.NativeModule
    public String getName() {
        return NAME;
    }

    private class LoginManagerCallback extends ReactNativeFacebookSDKCallback<LoginResult> {
        public LoginManagerCallback(Promise promise) {
            super(promise);
        }

        public void onSuccess(LoginResult loginResult) {
            if (this.mPromise != null) {
                AccessToken.setCurrentAccessToken(loginResult.getAccessToken());
                WritableMap createMap = Arguments.createMap();
                createMap.putBoolean("isCancelled", false);
                createMap.putArray("grantedPermissions", FBLoginManagerModule.this.setToWritableArray(loginResult.getRecentlyGrantedPermissions()));
                createMap.putArray("declinedPermissions", FBLoginManagerModule.this.setToWritableArray(loginResult.getRecentlyDeniedPermissions()));
                this.mPromise.resolve(createMap);
                this.mPromise = null;
            }
        }
    }

    public FBLoginManagerModule(ReactApplicationContext reactApplicationContext, FBActivityEventListener fBActivityEventListener) {
        super(reactApplicationContext, fBActivityEventListener);
    }

    @ReactMethod
    public void getLoginBehavior(Promise promise) {
        promise.resolve(LoginManager.getInstance().getLoginBehavior().name().toLowerCase());
    }

    @ReactMethod
    public void setLoginBehavior(String str) {
        LoginManager.getInstance().setLoginBehavior(LoginBehavior.valueOf(str.toUpperCase()));
    }

    @ReactMethod
    public void getDefaultAudience(Promise promise) {
        promise.resolve(LoginManager.getInstance().getDefaultAudience().name().toLowerCase());
    }

    @ReactMethod
    public void setDefaultAudience(String str) {
        LoginManager.getInstance().setDefaultAudience(DefaultAudience.valueOf(str.toUpperCase()));
    }

    @ReactMethod
    public void logOut() {
        LoginManager.getInstance().logOut();
    }

    @ReactMethod
    public void logInWithPermissions(ReadableArray readableArray, Promise promise) {
        LoginManager instance = LoginManager.getInstance();
        instance.registerCallback(getCallbackManager(), new LoginManagerCallback(promise));
        Activity currentActivity = getCurrentActivity();
        if (currentActivity != null) {
            instance.logIn(currentActivity, Utility.reactArrayToStringList(readableArray));
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private WritableArray setToWritableArray(Set<String> set) {
        WritableArray createArray = Arguments.createArray();
        for (String str : set) {
            createArray.pushString(str);
        }
        return createArray;
    }
}
