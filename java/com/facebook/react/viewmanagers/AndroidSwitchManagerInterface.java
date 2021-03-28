package com.facebook.react.viewmanagers;

import android.view.View;

public interface AndroidSwitchManagerInterface<T extends View> {
    void setDisabled(T t, boolean z);

    void setEnabled(T t, boolean z);

    void setNativeValue(T t, boolean z);

    void setOn(T t, boolean z);

    void setThumbColor(T t, Integer num);

    void setThumbTintColor(T t, Integer num);

    void setTrackColorForFalse(T t, Integer num);

    void setTrackColorForTrue(T t, Integer num);

    void setTrackTintColor(T t, Integer num);

    void setValue(T t, boolean z);
}
