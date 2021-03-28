package com.facebook.reactnative.androidsdk;

import com.facebook.AccessToken;
import com.facebook.AccessTokenTracker;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.events.RCTEventEmitter;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import java.util.Set;

public class RCTLoginButton extends LoginButton {
    private AccessTokenTracker mAccessTokenTracker;
    private CallbackManager mCallbackManager;

    public RCTLoginButton(ThemedReactContext themedReactContext, CallbackManager callbackManager) {
        super(themedReactContext);
        setToolTipMode(LoginButton.ToolTipMode.NEVER_DISPLAY);
        this.mCallbackManager = callbackManager;
        init();
    }

    public void init() {
        this.mAccessTokenTracker = new AccessTokenTracker() {
            /* class com.facebook.reactnative.androidsdk.RCTLoginButton.AnonymousClass1 */

            /* access modifiers changed from: protected */
            @Override // com.facebook.AccessTokenTracker
            public void onCurrentAccessTokenChanged(AccessToken accessToken, AccessToken accessToken2) {
                if (accessToken2 == null) {
                    WritableMap createMap = Arguments.createMap();
                    createMap.putString("type", "logoutFinished");
                    ((RCTEventEmitter) ((ReactContext) RCTLoginButton.this.getContext()).getJSModule(RCTEventEmitter.class)).receiveEvent(RCTLoginButton.this.getId(), "topChange", createMap);
                }
            }
        };
        registerCallback(this.mCallbackManager, new FacebookCallback<LoginResult>() {
            /* class com.facebook.reactnative.androidsdk.RCTLoginButton.AnonymousClass2 */

            public void onSuccess(LoginResult loginResult) {
                WritableMap createMap = Arguments.createMap();
                createMap.putString("type", "loginFinished");
                createMap.putString("error", null);
                WritableMap createMap2 = Arguments.createMap();
                createMap2.putBoolean("isCancelled", false);
                createMap2.putArray("grantedPermissions", Arguments.fromJavaArgs(RCTLoginButton.this.setToStringArray(loginResult.getRecentlyGrantedPermissions())));
                createMap2.putArray("declinedPermissions", Arguments.fromJavaArgs(RCTLoginButton.this.setToStringArray(loginResult.getRecentlyDeniedPermissions())));
                createMap.putMap(IronSourceConstants.EVENTS_RESULT, createMap2);
                ((RCTEventEmitter) ((ReactContext) RCTLoginButton.this.getContext()).getJSModule(RCTEventEmitter.class)).receiveEvent(RCTLoginButton.this.getId(), "topChange", createMap);
            }

            @Override // com.facebook.FacebookCallback
            public void onError(FacebookException facebookException) {
                WritableMap createMap = Arguments.createMap();
                createMap.putString("type", "loginFinished");
                createMap.putString("error", facebookException.toString());
                WritableMap createMap2 = Arguments.createMap();
                createMap2.putBoolean("isCancelled", false);
                createMap.putMap(IronSourceConstants.EVENTS_RESULT, createMap2);
                ((RCTEventEmitter) ((ReactContext) RCTLoginButton.this.getContext()).getJSModule(RCTEventEmitter.class)).receiveEvent(RCTLoginButton.this.getId(), "topChange", createMap);
            }

            @Override // com.facebook.FacebookCallback
            public void onCancel() {
                WritableMap createMap = Arguments.createMap();
                createMap.putString("type", "loginFinished");
                createMap.putString("error", null);
                WritableMap createMap2 = Arguments.createMap();
                createMap2.putBoolean("isCancelled", true);
                createMap.putMap(IronSourceConstants.EVENTS_RESULT, createMap2);
                ((RCTEventEmitter) ((ReactContext) RCTLoginButton.this.getContext()).getJSModule(RCTEventEmitter.class)).receiveEvent(RCTLoginButton.this.getId(), "topChange", createMap);
            }
        });
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private String[] setToStringArray(Set<String> set) {
        String[] strArr = new String[set.size()];
        int i = 0;
        for (String str : set) {
            strArr[i] = str;
            i++;
        }
        return strArr;
    }
}
