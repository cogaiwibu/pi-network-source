package com.facebook.ads.redexgen.X;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.util.Log;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import java.lang.ref.WeakReference;
import java.util.Arrays;

public class NJ extends WebViewClient {
    public static byte[] A02;
    public final WeakReference<C0820Wh> A00;
    public final WeakReference<NH> A01;

    static {
        A01();
    }

    public static String A00(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A02, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] - i3) - 97);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A02 = new byte[]{-67, -33, -16, -27, -14, -27, -16, -11, -100, -22, -21, -16, -100, -30, -21, -15, -22, -32, -100, -16, -21, -100, -28, -35, -22, -32, -24, -31, -100, -47, -50, -59, -86, 42, 67, 64, 67, 68, 76, 67, -11, 58, 77, 56, 58, 69, 73, 62, 68, 67, -11, 68, 56, 56, 74, 71, 71, 58, 57, -11, 76, 61, 58, 67, -11, 73, 71, 78, 62, 67, 60, -11, 73, 68, -11, 61, 54, 67, 57, 65, 58, -11, 42, 39, 30, 3, 39, 52, 42, 56, 53, 47, 42, -12, 47, 52, 58, 43, 52, 58, -12, 39, 41, 58, 47, 53, 52, -12, 28, 15, 11, 29, 73, 55, 52, 49, 72, 59, 55, 73};
    }

    public NJ(WeakReference<NH> weakReference, WeakReference<C0820Wh> weakReference2) {
        this.A01 = weakReference;
        this.A00 = weakReference2;
    }

    public final void onPageFinished(WebView webView, String str) {
        super.onPageFinished(webView, str);
        if (this.A01.get() != null) {
            this.A01.get().AAL(str);
        }
    }

    public final void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        super.onPageStarted(webView, str, bitmap);
        if (this.A01.get() != null) {
            this.A01.get().AAN(str);
        }
    }

    @Override // android.webkit.WebViewClient
    public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
        Uri parse = Uri.parse(str);
        if (XS.A09.contains(parse.getScheme()) || this.A00.get() == null) {
            return false;
        }
        try {
            return C0523Kq.A0C(this.A00.get(), new Intent(A00(86, 26, 101), parse));
        } catch (Exception e) {
            if (e instanceof ActivityNotFoundException) {
                Log.w(XS.A08, A00(0, 33, 27), e);
            } else {
                Log.e(XS.A08, A00(33, 53, 116), e);
            }
            C0820Wh wh = this.A00.get();
            if (wh == null) {
                return false;
            }
            wh.A04().A83(A00(112, 8, 113), C02248i.A2C, new C02258j(e));
            return false;
        }
    }
}
