package com.facebook.react.viewmanagers;

import android.view.View;
import com.facebook.react.bridge.ReadableMap;

public interface SliderManagerInterface<T extends View> {
    void setDisabled(T t, boolean z);

    void setEnabled(T t, boolean z);

    void setMaximumTrackImage(T t, ReadableMap readableMap);

    void setMaximumTrackTintColor(T t, Integer num);

    void setMaximumValue(T t, double d);

    void setMinimumTrackImage(T t, ReadableMap readableMap);

    void setMinimumTrackTintColor(T t, Integer num);

    void setMinimumValue(T t, double d);

    void setStep(T t, double d);

    void setTestID(T t, String str);

    void setThumbImage(T t, ReadableMap readableMap);

    void setThumbTintColor(T t, Integer num);

    void setTrackImage(T t, ReadableMap readableMap);

    void setValue(T t, double d);
}
