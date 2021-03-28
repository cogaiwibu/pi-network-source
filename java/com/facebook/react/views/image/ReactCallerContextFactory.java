package com.facebook.react.views.image;

import com.facebook.react.uimanager.ThemedReactContext;

public interface ReactCallerContextFactory {
    Object getOrCreateCallerContext(ThemedReactContext themedReactContext);
}
