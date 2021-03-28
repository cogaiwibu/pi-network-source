package com.facebook.ads.redexgen.X;

import android.os.Build;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class OA extends WebViewClient {
    public final /* synthetic */ C0664Qe A00;

    public OA(C0664Qe qe) {
        this.A00 = qe;
    }

    public /* synthetic */ OA(C0664Qe qe, C0669Qj qj) {
        this(qe);
    }

    public final void onPageFinished(WebView webView, String str) {
        this.A00.A09.A03(JK.A0R, null);
        this.A00.A0O();
        this.A00.A03 = true;
        this.A00.A0F();
    }

    public final void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
        String str;
        super.onReceivedError(webView, webResourceRequest, webResourceError);
        this.A00.A0O();
        this.A00.A09.A03(JK.A0Q, null);
        if (Build.VERSION.SDK_INT >= 23) {
            str = webResourceError.getDescription().toString();
        } else {
            str = "";
        }
        this.A00.A0F.A05(C02248i.A0s, str);
    }
}
