package com.facebook.reactnative.androidsdk;

import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.WritableMap;

public abstract class ReactNativeFacebookSDKCallback<RESULT> implements FacebookCallback<RESULT> {
    Promise mPromise;

    public ReactNativeFacebookSDKCallback(Promise promise) {
        this.mPromise = promise;
    }

    @Override // com.facebook.FacebookCallback
    public void onCancel() {
        if (this.mPromise != null) {
            WritableMap createMap = Arguments.createMap();
            createMap.putBoolean("isCancelled", true);
            this.mPromise.resolve(createMap);
            this.mPromise = null;
        }
    }

    @Override // com.facebook.FacebookCallback
    public void onError(FacebookException facebookException) {
        Promise promise = this.mPromise;
        if (promise != null) {
            promise.reject(facebookException);
            this.mPromise = null;
        }
    }
}
