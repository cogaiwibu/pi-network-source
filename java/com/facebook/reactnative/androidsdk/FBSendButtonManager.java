package com.facebook.reactnative.androidsdk;

import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.share.model.ShareContent;
import com.facebook.share.widget.SendButton;

public class FBSendButtonManager extends SimpleViewManager<SendButton> {
    public static final String REACT_CLASS = "RCTFBSendButton";

    @Override // com.facebook.react.bridge.NativeModule, com.facebook.react.uimanager.ViewManager
    public String getName() {
        return REACT_CLASS;
    }

    /* access modifiers changed from: protected */
    @Override // com.facebook.react.uimanager.ViewManager
    public SendButton createViewInstance(ThemedReactContext themedReactContext) {
        return new SendButton(themedReactContext);
    }

    @ReactProp(name = "shareContent")
    public void setShareContent(SendButton sendButton, ReadableMap readableMap) {
        ShareContent buildShareContent = Utility.buildShareContent(readableMap);
        if (buildShareContent != null) {
            sendButton.setShareContent(buildShareContent);
        }
    }
}
