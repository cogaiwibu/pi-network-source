package com.facebook.ads.redexgen.X;

import android.graphics.Bitmap;
import android.os.Handler;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.facebook.ads.AdError;

/* renamed from: com.facebook.ads.redexgen.X.1h  reason: invalid class name and case insensitive filesystem */
public class C00541h extends WebViewClient {
    public boolean A00 = false;
    public final AnonymousClass1S A01;
    public final AbstractC00531g A02;
    public final boolean A03;

    public C00541h(AnonymousClass1S r2, AbstractC00531g r3, boolean z) {
        this.A01 = r2;
        this.A02 = r3;
        this.A03 = z;
    }

    private void A00() {
        AbstractC00531g r0 = this.A02;
        if (r0 != null) {
            r0.AAS();
        }
    }

    /* access modifiers changed from: private */
    public void A01(WebResourceError webResourceError) {
        if (this.A03) {
            this.A02.AAR(AdError.CACHE_ERROR);
        } else {
            A00();
        }
    }

    public final void onPageFinished(WebView webView, String str) {
        this.A00 = true;
        A00();
    }

    public final void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        super.onPageStarted(webView, str, bitmap);
        new Handler().postDelayed(new RX(this), (long) this.A01.A09());
    }

    public final void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
        this.A00 = true;
        A01(webResourceError);
    }
}
