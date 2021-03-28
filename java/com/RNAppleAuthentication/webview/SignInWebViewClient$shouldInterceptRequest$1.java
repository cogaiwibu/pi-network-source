package com.RNAppleAuthentication.webview;

import android.webkit.WebView;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "run"}, k = 3, mv = {1, 4, 0})
/* compiled from: SignInWebViewClient.kt */
final class SignInWebViewClient$shouldInterceptRequest$1 implements Runnable {
    final /* synthetic */ WebView $view;
    final /* synthetic */ SignInWebViewClient this$0;

    SignInWebViewClient$shouldInterceptRequest$1(SignInWebViewClient signInWebViewClient, WebView webView) {
        this.this$0 = signInWebViewClient;
        this.$view = webView;
    }

    public final void run() {
        WebView webView = this.$view;
        if (webView != null) {
            webView.stopLoading();
        }
        WebView webView2 = this.$view;
        if (webView2 != null) {
            webView2.loadUrl("javascript:" + SignInWebViewClient.access$getJavascriptToInject$p(this.this$0));
        }
    }
}
