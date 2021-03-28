package com.RNAppleAuthentication.webview;

import android.os.Handler;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.RNAppleAuthentication.SignInWithAppleService;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.facebook.share.internal.ShareConstants;
import com.ironsource.eventsTracker.NativeEventsConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u001e\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f¨\u0006\u0013"}, d2 = {"Lcom/RNAppleAuthentication/webview/SignInWebViewClient;", "Landroid/webkit/WebViewClient;", "attempt", "Lcom/RNAppleAuthentication/SignInWithAppleService$AuthenticationAttempt;", "javascriptToInject", "", "(Lcom/RNAppleAuthentication/SignInWithAppleService$AuthenticationAttempt;Ljava/lang/String;)V", "mainHandler", "Landroid/os/Handler;", "getMainHandler", "()Landroid/os/Handler;", "setMainHandler", "(Landroid/os/Handler;)V", "shouldInterceptRequest", "Landroid/webkit/WebResourceResponse;", ViewHierarchyConstants.VIEW_KEY, "Landroid/webkit/WebView;", ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID, "Landroid/webkit/WebResourceRequest;", "invertase_react-native-apple-authentication_release"}, k = 1, mv = {1, 4, 0})
/* compiled from: SignInWebViewClient.kt */
public final class SignInWebViewClient extends WebViewClient {
    private final SignInWithAppleService.AuthenticationAttempt attempt;
    private final String javascriptToInject;
    private Handler mainHandler = new Handler();

    public SignInWebViewClient(SignInWithAppleService.AuthenticationAttempt authenticationAttempt, String str) {
        Intrinsics.checkNotNullParameter(authenticationAttempt, "attempt");
        Intrinsics.checkNotNullParameter(str, "javascriptToInject");
        this.attempt = authenticationAttempt;
        this.javascriptToInject = str;
    }

    public final Handler getMainHandler() {
        return this.mainHandler;
    }

    public final void setMainHandler(Handler handler) {
        Intrinsics.checkNotNullParameter(handler, "<set-?>");
        this.mainHandler = handler;
    }

    @Override // android.webkit.WebViewClient
    public WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
        if (Intrinsics.areEqual(webResourceRequest != null ? webResourceRequest.getMethod() : null, NativeEventsConstants.HTTP_METHOD_POST)) {
            String uri = webResourceRequest.getUrl().toString();
            Intrinsics.checkNotNullExpressionValue(uri, "request.url.toString()");
            if (StringsKt.contains$default((CharSequence) uri, (CharSequence) this.attempt.getRedirectUri(), false, 2, (Object) null)) {
                try {
                    Thread.currentThread().interrupt();
                } catch (Exception unused) {
                }
                this.mainHandler.post(new SignInWebViewClient$shouldInterceptRequest$1(this, webView));
            }
        }
        return super.shouldInterceptRequest(webView, webResourceRequest);
    }
}
