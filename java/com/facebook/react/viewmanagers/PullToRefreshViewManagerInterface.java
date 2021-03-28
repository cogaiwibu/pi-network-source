package com.facebook.react.viewmanagers;

import android.view.View;

public interface PullToRefreshViewManagerInterface<T extends View> {
    void setNativeRefreshing(T t, boolean z);

    void setRefreshing(T t, boolean z);

    void setTintColor(T t, Integer num);

    void setTitle(T t, String str);

    void setTitleColor(T t, Integer num);
}
