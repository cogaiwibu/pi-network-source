package com.tapjoy.internal;

import android.webkit.WebView;

public final class dt extends ds {
    public dt(WebView webView) {
        if (webView != null && !webView.getSettings().getJavaScriptEnabled()) {
            webView.getSettings().setJavaScriptEnabled(true);
        }
        a(webView);
    }
}
