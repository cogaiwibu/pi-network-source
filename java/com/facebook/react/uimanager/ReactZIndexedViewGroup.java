package com.facebook.react.uimanager;

public interface ReactZIndexedViewGroup {
    int getZIndexMappedChildIndex(int i);

    void updateDrawingOrder();
}
