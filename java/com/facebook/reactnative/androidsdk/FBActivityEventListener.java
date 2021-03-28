package com.facebook.reactnative.androidsdk;

import android.app.Activity;
import android.content.Intent;
import com.facebook.CallbackManager;
import com.facebook.react.bridge.BaseActivityEventListener;

public class FBActivityEventListener extends BaseActivityEventListener {
    private CallbackManager mCallbackManager = CallbackManager.Factory.create();

    @Override // com.facebook.react.bridge.BaseActivityEventListener, com.facebook.react.bridge.ActivityEventListener
    public void onActivityResult(Activity activity, int i, int i2, Intent intent) {
        this.mCallbackManager.onActivityResult(i, i2, intent);
    }

    public CallbackManager getCallbackManager() {
        return this.mCallbackManager;
    }
}
