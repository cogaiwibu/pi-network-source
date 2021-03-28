package com.facebook.react.viewmanagers;

import android.view.View;

public interface UnimplementedNativeViewManagerInterface<T extends View> {
    void setName(T t, String str);
}
