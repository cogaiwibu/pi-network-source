package com.facebook.react.views.text;

import android.view.View;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewManager;

@ReactModule(name = ReactRawTextManager.REACT_CLASS)
public class ReactRawTextManager extends ViewManager<View, ReactRawTextShadowNode> {
    public static final String REACT_CLASS = "RCTRawText";

    @Override // com.facebook.react.bridge.NativeModule, com.facebook.react.uimanager.ViewManager
    public String getName() {
        return REACT_CLASS;
    }

    @Override // com.facebook.react.uimanager.ViewManager
    public void updateExtraData(View view, Object obj) {
    }

    /* Return type fixed from 'com.facebook.react.views.text.ReactTextView' to match base method */
    @Override // com.facebook.react.uimanager.ViewManager
    public View createViewInstance(ThemedReactContext themedReactContext) {
        throw new IllegalStateException("Attempt to create a native view for RCTRawText");
    }

    /* Return type fixed from 'java.lang.Class<com.facebook.react.views.text.ReactRawTextShadowNode>' to match base method */
    @Override // com.facebook.react.uimanager.ViewManager
    public Class<? extends ReactRawTextShadowNode> getShadowNodeClass() {
        return ReactRawTextShadowNode.class;
    }

    @Override // com.facebook.react.uimanager.ViewManager
    public ReactRawTextShadowNode createShadowNodeInstance() {
        return new ReactRawTextShadowNode();
    }
}
