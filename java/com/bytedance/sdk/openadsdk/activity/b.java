package com.bytedance.sdk.openadsdk.activity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.SslErrorHandler;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.bytedance.sdk.openadsdk.b.i;
import com.bytedance.sdk.openadsdk.core.j;
import com.bytedance.sdk.openadsdk.core.r;
import com.bytedance.sdk.openadsdk.g.k;
import com.bytedance.sdk.openadsdk.g.l;
import com.bytedance.sdk.openadsdk.g.m;

/* compiled from: TTWebViewClient */
public class b extends WebViewClient {
    private static final String a = WebChromeClient.class.getSimpleName();
    private final r b;
    private final Context c;
    private final String d;
    private i e;

    public b(Context context, r rVar, String str, i iVar) {
        this.c = context;
        this.b = rVar;
        this.d = str;
        this.e = iVar;
    }

    @Override // android.webkit.WebViewClient
    public WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
        return super.shouldInterceptRequest(webView, webResourceRequest);
    }

    @Override // android.webkit.WebViewClient
    public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
        return super.shouldInterceptRequest(webView, str);
    }

    public void onLoadResource(WebView webView, String str) {
        super.onLoadResource(webView, str);
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        String str2 = a;
        l.b(str2, "shouldOverrideUrlLoading " + str);
        try {
            Uri parse = Uri.parse(str);
            if ("bytedance".equals(parse.getScheme().toLowerCase())) {
                com.bytedance.sdk.openadsdk.g.i.a(parse, this.b);
                return true;
            }
            if (!m.a(str)) {
                Intent intent = new Intent("android.intent.action.VIEW");
                intent.setData(parse);
                intent.addFlags(268435456);
                try {
                    this.c.startActivity(intent);
                } catch (Throwable unused) {
                }
                return true;
            }
            return super.shouldOverrideUrlLoading(webView, str);
        } catch (Exception e2) {
            String str3 = a;
            Log.w(str3, "shouldOverrideUrlLoading" + e2);
        }
    }

    public void onPageFinished(WebView webView, String str) {
        if (l.a()) {
            String str2 = a;
            l.a(str2, "onPageFinished " + str);
        }
        i iVar = this.e;
        if (iVar != null) {
            iVar.a(webView, str);
        }
        if (webView != null) {
            try {
                String a2 = com.bytedance.sdk.openadsdk.core.m.a(j.e().c(), this.d);
                if (!TextUtils.isEmpty(a2)) {
                    k.a(webView, a2);
                }
            } catch (Throwable unused) {
            }
        }
        super.onPageFinished(webView, str);
    }

    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        super.onPageStarted(webView, str, bitmap);
        i iVar = this.e;
        if (iVar != null) {
            iVar.a(webView, str, bitmap);
        }
        com.bytedance.sdk.openadsdk.core.m.a(this.c).a(Build.VERSION.SDK_INT >= 19).a(webView);
    }

    public void onReceivedError(WebView webView, int i, String str, String str2) {
        super.onReceivedError(webView, i, str, str2);
        i iVar = this.e;
        if (iVar != null) {
            iVar.a(webView, i, str, str2);
        }
    }

    public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
        super.onReceivedError(webView, webResourceRequest, webResourceError);
        i iVar = this.e;
        if (iVar != null && webResourceError != null) {
            iVar.a(webView, webResourceError.getErrorCode(), String.valueOf(webResourceError.getDescription()), null);
        }
    }

    public void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
        super.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
        i iVar = this.e;
        if (iVar != null && webResourceResponse != null) {
            iVar.a(webView, webResourceResponse.getStatusCode(), String.valueOf(webResourceResponse.getReasonPhrase()), null);
        }
    }

    public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
        super.onReceivedSslError(webView, sslErrorHandler, sslError);
        i iVar = this.e;
        if (iVar != null && sslError != null) {
            int primaryError = sslError.getPrimaryError();
            iVar.a(webView, primaryError, "SslError: " + String.valueOf(sslError), null);
        }
    }
}
