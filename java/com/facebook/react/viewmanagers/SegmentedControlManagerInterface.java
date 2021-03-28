package com.facebook.react.viewmanagers;

import android.view.View;
import com.facebook.react.bridge.ReadableArray;

public interface SegmentedControlManagerInterface<T extends View> {
    void setEnabled(T t, boolean z);

    void setMomentary(T t, boolean z);

    void setSelectedIndex(T t, int i);

    void setTintColor(T t, Integer num);

    void setValues(T t, ReadableArray readableArray);
}
