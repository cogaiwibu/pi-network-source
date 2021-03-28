package com.ironsource.sdk.controller;

import android.app.Activity;
import android.content.MutableContextWrapper;

public class ContextProvider {
    MutableContextWrapper mutableActivityContextWrapper;

    public synchronized void updateActivityContext(Activity activity) {
        if (this.mutableActivityContextWrapper == null) {
            this.mutableActivityContextWrapper = new MutableContextWrapper(activity);
        }
        this.mutableActivityContextWrapper.setBaseContext(activity);
    }

    public Activity getCurrentActivityContext() {
        return (Activity) this.mutableActivityContextWrapper.getBaseContext();
    }

    public synchronized void release() {
        this.mutableActivityContextWrapper = null;
    }
}
