package com.facebook.react.uimanager;

import android.view.View;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;

public interface BaseViewManagerInterface<T extends View> {
    void setAccessibilityActions(T t, ReadableArray readableArray);

    void setAccessibilityHint(T t, String str);

    void setAccessibilityLabel(T t, String str);

    void setAccessibilityLiveRegion(T t, String str);

    void setAccessibilityRole(T t, String str);

    void setBackgroundColor(T t, int i);

    void setBorderBottomLeftRadius(T t, float f);

    void setBorderBottomRightRadius(T t, float f);

    void setBorderRadius(T t, float f);

    void setBorderTopLeftRadius(T t, float f);

    void setBorderTopRightRadius(T t, float f);

    void setElevation(T t, float f);

    void setImportantForAccessibility(T t, String str);

    void setNativeId(T t, String str);

    void setOpacity(T t, float f);

    void setRenderToHardwareTexture(T t, boolean z);

    void setRotation(T t, float f);

    void setScaleX(T t, float f);

    void setScaleY(T t, float f);

    void setTestId(T t, String str);

    void setTransform(T t, ReadableArray readableArray);

    void setTranslateX(T t, float f);

    void setTranslateY(T t, float f);

    void setViewState(T t, ReadableMap readableMap);

    void setZIndex(T t, float f);
}
