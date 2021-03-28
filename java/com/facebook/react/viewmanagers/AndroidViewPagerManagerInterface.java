package com.facebook.react.viewmanagers;

import android.view.View;

public interface AndroidViewPagerManagerInterface<T extends View> {
    void setInitialPage(T t, int i);

    void setKeyboardDismissMode(T t, String str);

    void setPage(T t, int i);

    void setPageMargin(T t, int i);

    void setPageWithoutAnimation(T t, int i);

    void setPeekEnabled(T t, boolean z);

    void setScrollEnabled(T t, boolean z);
}
