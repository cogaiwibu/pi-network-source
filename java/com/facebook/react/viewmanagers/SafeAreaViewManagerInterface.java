package com.facebook.react.viewmanagers;

import android.view.View;

public interface SafeAreaViewManagerInterface<T extends View> {
    void setEmulateUnlessSupported(T t, boolean z);
}
