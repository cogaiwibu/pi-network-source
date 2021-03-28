package com.facebook.react.uimanager;

import android.view.View;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;

public abstract class BaseViewManagerAdapter<T extends View> implements BaseViewManagerInterface<T> {
    @Override // com.facebook.react.uimanager.BaseViewManagerInterface
    public void setAccessibilityActions(T t, ReadableArray readableArray) {
    }

    @Override // com.facebook.react.uimanager.BaseViewManagerInterface
    public void setAccessibilityHint(T t, String str) {
    }

    @Override // com.facebook.react.uimanager.BaseViewManagerInterface
    public void setAccessibilityLabel(T t, String str) {
    }

    @Override // com.facebook.react.uimanager.BaseViewManagerInterface
    public void setAccessibilityLiveRegion(T t, String str) {
    }

    @Override // com.facebook.react.uimanager.BaseViewManagerInterface
    public void setAccessibilityRole(T t, String str) {
    }

    @Override // com.facebook.react.uimanager.BaseViewManagerInterface
    public void setBackgroundColor(T t, int i) {
    }

    @Override // com.facebook.react.uimanager.BaseViewManagerInterface
    public void setBorderBottomLeftRadius(T t, float f) {
    }

    @Override // com.facebook.react.uimanager.BaseViewManagerInterface
    public void setBorderBottomRightRadius(T t, float f) {
    }

    @Override // com.facebook.react.uimanager.BaseViewManagerInterface
    public void setBorderRadius(T t, float f) {
    }

    @Override // com.facebook.react.uimanager.BaseViewManagerInterface
    public void setBorderTopLeftRadius(T t, float f) {
    }

    @Override // com.facebook.react.uimanager.BaseViewManagerInterface
    public void setBorderTopRightRadius(T t, float f) {
    }

    @Override // com.facebook.react.uimanager.BaseViewManagerInterface
    public void setElevation(T t, float f) {
    }

    @Override // com.facebook.react.uimanager.BaseViewManagerInterface
    public void setImportantForAccessibility(T t, String str) {
    }

    @Override // com.facebook.react.uimanager.BaseViewManagerInterface
    public void setNativeId(T t, String str) {
    }

    @Override // com.facebook.react.uimanager.BaseViewManagerInterface
    public void setOpacity(T t, float f) {
    }

    @Override // com.facebook.react.uimanager.BaseViewManagerInterface
    public void setRenderToHardwareTexture(T t, boolean z) {
    }

    @Override // com.facebook.react.uimanager.BaseViewManagerInterface
    public void setRotation(T t, float f) {
    }

    @Override // com.facebook.react.uimanager.BaseViewManagerInterface
    public void setScaleX(T t, float f) {
    }

    @Override // com.facebook.react.uimanager.BaseViewManagerInterface
    public void setScaleY(T t, float f) {
    }

    @Override // com.facebook.react.uimanager.BaseViewManagerInterface
    public void setTestId(T t, String str) {
    }

    @Override // com.facebook.react.uimanager.BaseViewManagerInterface
    public void setTransform(T t, ReadableArray readableArray) {
    }

    @Override // com.facebook.react.uimanager.BaseViewManagerInterface
    public void setTranslateX(T t, float f) {
    }

    @Override // com.facebook.react.uimanager.BaseViewManagerInterface
    public void setTranslateY(T t, float f) {
    }

    @Override // com.facebook.react.uimanager.BaseViewManagerInterface
    public void setViewState(T t, ReadableMap readableMap) {
    }

    @Override // com.facebook.react.uimanager.BaseViewManagerInterface
    public void setZIndex(T t, float f) {
    }
}
