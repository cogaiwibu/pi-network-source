package com.facebook.react.viewmanagers;

import android.view.View;

public interface AndroidDrawerLayoutManagerInterface<T extends View> {
    void closeDrawer(T t);

    void openDrawer(T t);

    void setDrawerBackgroundColor(T t, Integer num);

    void setDrawerLockMode(T t, String str);

    void setDrawerPosition(T t, String str);

    void setDrawerWidth(T t, Float f);

    void setKeyboardDismissMode(T t, String str);

    void setStatusBarBackgroundColor(T t, Integer num);
}
