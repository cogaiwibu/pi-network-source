package com.facebook.react.uimanager;

import android.graphics.Rect;

public interface ReactClippingViewGroup {
    void getClippingRect(Rect rect);

    boolean getRemoveClippedSubviews();

    void setRemoveClippedSubviews(boolean z);

    void updateClippingRect();
}
