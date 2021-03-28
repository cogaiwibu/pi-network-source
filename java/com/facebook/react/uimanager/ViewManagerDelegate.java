package com.facebook.react.uimanager;

import android.view.View;

public interface ViewManagerDelegate<T extends View> {
    void setProperty(T t, String str, Object obj);
}
