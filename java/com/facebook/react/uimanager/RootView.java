package com.facebook.react.uimanager;

import android.view.MotionEvent;

public interface RootView {
    void handleException(Throwable th);

    void onChildStartedNativeGesture(MotionEvent motionEvent);
}
