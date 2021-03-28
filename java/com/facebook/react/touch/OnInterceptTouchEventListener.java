package com.facebook.react.touch;

import android.view.MotionEvent;
import android.view.ViewGroup;

public interface OnInterceptTouchEventListener {
    boolean onInterceptTouchEvent(ViewGroup viewGroup, MotionEvent motionEvent);
}
