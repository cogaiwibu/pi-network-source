package com.facebook.react.viewmanagers;

import android.view.View;

public interface SwitchManagerInterface<T extends View> {
    void setDisabled(T t, boolean z);

    void setOnTintColor(T t, Integer num);

    void setThumbColor(T t, Integer num);

    void setThumbTintColor(T t, Integer num);

    void setTintColor(T t, Integer num);

    void setTrackColorForFalse(T t, Integer num);

    void setTrackColorForTrue(T t, Integer num);

    void setValue(T t, boolean z);
}
