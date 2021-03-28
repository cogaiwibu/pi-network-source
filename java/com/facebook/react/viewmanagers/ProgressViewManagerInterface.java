package com.facebook.react.viewmanagers;

import android.view.View;
import com.facebook.react.bridge.ReadableMap;

public interface ProgressViewManagerInterface<T extends View> {
    void setProgress(T t, float f);

    void setProgressImage(T t, ReadableMap readableMap);

    void setProgressTintColor(T t, Integer num);

    void setProgressViewStyle(T t, String str);

    void setTrackImage(T t, ReadableMap readableMap);

    void setTrackTintColor(T t, Integer num);
}
