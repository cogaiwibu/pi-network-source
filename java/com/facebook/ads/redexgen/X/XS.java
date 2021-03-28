package com.facebook.ads.redexgen.X;

import android.annotation.TargetApi;
import android.graphics.Canvas;
import android.webkit.WebBackForwardList;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebViewClient;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@TargetApi(19)
public final class XS extends NK {
    public static byte[] A07;
    public static final String A08 = XS.class.getSimpleName();
    public static final Set<String> A09 = new HashSet(2);
    public long A00 = -1;
    public long A01 = -1;
    public long A02 = -1;
    public long A03 = -1;
    public NE A04;
    public NH A05;
    public final C0820Wh A06;

    public static String A02(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A07, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] ^ i3) ^ 93);
        }
        return new String(copyOfRange);
    }

    public static void A06() {
        A07 = new byte[]{83, 79, 79, 75, 49, 45, 45, 41, 42, 6, 13, 26, 13, 31, 15, 30, 5, 28, 24, 86};
    }

    static {
        A06();
        A09.add(A02(0, 4, 102));
        A09.add(A02(4, 5, 4));
    }

    public XS(C0820Wh wh, NH nh) {
        super(wh);
        this.A05 = nh;
        this.A06 = wh;
        setWebChromeClient(A0A());
        setWebViewClient(A0B());
        A05();
    }

    private void A04() {
        if (this.A00 > -1 && this.A03 > -1 && this.A01 > -1) {
            this.A04.A06(false);
        }
    }

    private void A05() {
        WebSettings settings = getSettings();
        settings.setSupportZoom(true);
        settings.setBuiltInZoomControls(true);
        settings.setDisplayZoomControls(false);
        settings.setLoadWithOverviewMode(true);
        settings.setUseWideViewPort(true);
        settings.setAllowContentAccess(false);
        settings.setAllowFileAccessFromFileURLs(false);
        settings.setAllowUniversalAccessFromFileURLs(false);
        settings.setAllowFileAccess(false);
        this.A04 = new NE(this);
    }

    @Override // com.facebook.ads.redexgen.X.NK
    public final WebChromeClient A0A() {
        return new NI(new WeakReference(this.A05), new WeakReference(this.A04));
    }

    @Override // com.facebook.ads.redexgen.X.NK
    public final WebViewClient A0B() {
        return new NJ(new WeakReference(this.A05), new WeakReference(this.A06));
    }

    public final void A0C(long j) {
        if (this.A00 < 0) {
            this.A00 = j;
        }
        A04();
    }

    public final void A0D(long j) {
        if (this.A01 < 0) {
            this.A01 = j;
        }
        A04();
    }

    public final void A0E(long j) {
        if (this.A02 < 0) {
            this.A02 = j;
        }
    }

    public final void A0F(String str) {
        try {
            evaluateJavascript(str, null);
        } catch (IllegalStateException unused) {
            loadUrl(A02(9, 11, 49) + str);
        }
    }

    @Override // com.facebook.ads.redexgen.X.NK
    public final void destroy() {
        this.A05 = null;
        NQ.A04(this);
        super.destroy();
    }

    public long getDomContentLoadedMs() {
        return this.A00;
    }

    public String getFirstUrl() {
        WebBackForwardList copyBackForwardList = copyBackForwardList();
        if (copyBackForwardList.getSize() > 0) {
            return copyBackForwardList.getItemAtIndex(0).getUrl();
        }
        return getUrl();
    }

    public long getLoadFinishMs() {
        return this.A01;
    }

    public long getResponseEndMs() {
        return this.A02;
    }

    public long getScrollReadyMs() {
        return this.A03;
    }

    public final void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.A03 < 0 && computeVerticalScrollRange() > getHeight()) {
            this.A03 = System.currentTimeMillis();
            A04();
        }
    }
}
