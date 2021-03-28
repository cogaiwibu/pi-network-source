package com.facebook.reactnative.androidsdk;

import com.facebook.AccessToken;
import com.facebook.AccessTokenTracker;
import com.facebook.FacebookException;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.modules.core.DeviceEventManagerModule;

@ReactModule(name = FBAccessTokenModule.NAME)
public class FBAccessTokenModule extends ReactContextBaseJavaModule {
    public static final String CHANGE_EVENT_NAME = "fbsdk.accessTokenDidChange";
    public static final String NAME = "FBAccessToken";
    private AccessTokenTracker accessTokenTracker;
    private final ReactApplicationContext mReactContext;

    @Override // com.facebook.react.bridge.NativeModule
    public String getName() {
        return NAME;
    }

    public FBAccessTokenModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
        this.mReactContext = reactApplicationContext;
    }

    @Override // com.facebook.react.bridge.BaseJavaModule, com.facebook.react.bridge.NativeModule
    public void initialize() {
        super.initialize();
        this.accessTokenTracker = new AccessTokenTracker() {
            /* class com.facebook.reactnative.androidsdk.FBAccessTokenModule.AnonymousClass1 */

            /* access modifiers changed from: protected */
            @Override // com.facebook.AccessTokenTracker
            public void onCurrentAccessTokenChanged(AccessToken accessToken, AccessToken accessToken2) {
                WritableMap writableMap;
                DeviceEventManagerModule.RCTDeviceEventEmitter rCTDeviceEventEmitter = (DeviceEventManagerModule.RCTDeviceEventEmitter) FBAccessTokenModule.this.mReactContext.getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class);
                if (accessToken2 == null) {
                    writableMap = null;
                } else {
                    writableMap = Utility.accessTokenToReactMap(accessToken2);
                }
                rCTDeviceEventEmitter.emit(FBAccessTokenModule.CHANGE_EVENT_NAME, writableMap);
            }
        };
    }

    @Override // com.facebook.react.bridge.BaseJavaModule, com.facebook.react.bridge.NativeModule
    public void onCatalystInstanceDestroy() {
        super.onCatalystInstanceDestroy();
        this.accessTokenTracker.stopTracking();
    }

    @ReactMethod
    public void getCurrentAccessToken(Callback callback) {
        WritableMap writableMap;
        Object[] objArr = new Object[1];
        if (AccessToken.getCurrentAccessToken() == null) {
            writableMap = null;
        } else {
            writableMap = Utility.accessTokenToReactMap(AccessToken.getCurrentAccessToken());
        }
        objArr[0] = writableMap;
        callback.invoke(objArr);
    }

    @ReactMethod
    public void setCurrentAccessToken(ReadableMap readableMap) {
        AccessToken.setCurrentAccessToken(Utility.buildAccessToken(readableMap));
    }

    @ReactMethod
    public void refreshCurrentAccessTokenAsync(final Promise promise) {
        AccessToken.refreshCurrentAccessTokenAsync(new AccessToken.AccessTokenRefreshCallback() {
            /* class com.facebook.reactnative.androidsdk.FBAccessTokenModule.AnonymousClass2 */

            @Override // com.facebook.AccessToken.AccessTokenRefreshCallback
            public void OnTokenRefreshed(AccessToken accessToken) {
                promise.resolve(Utility.accessTokenToReactMap(accessToken));
            }

            @Override // com.facebook.AccessToken.AccessTokenRefreshCallback
            public void OnTokenRefreshFailed(FacebookException facebookException) {
                promise.reject(facebookException);
            }
        });
    }
}
