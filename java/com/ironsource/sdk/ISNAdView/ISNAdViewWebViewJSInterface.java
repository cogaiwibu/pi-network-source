package com.ironsource.sdk.ISNAdView;

import android.webkit.JavascriptInterface;

public class ISNAdViewWebViewJSInterface {
    private ISNAdView mIsnAdView;

    ISNAdViewWebViewJSInterface(ISNAdView iSNAdView) {
        this.mIsnAdView = iSNAdView;
    }

    @JavascriptInterface
    public void receiveMessageFromExternal(String str) {
        this.mIsnAdView.receiveMessageFromWebView(str);
    }
}
