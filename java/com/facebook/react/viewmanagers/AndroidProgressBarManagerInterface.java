package com.facebook.react.viewmanagers;

import android.view.View;

public interface AndroidProgressBarManagerInterface<T extends View> {
    void setAnimating(T t, boolean z);

    void setColor(T t, Integer num);

    void setIndeterminate(T t, boolean z);

    void setProgress(T t, double d);

    void setStyleAttr(T t, String str);

    void setTestID(T t, String str);

    void setTypeAttr(T t, String str);
}
