package com.facebook.ads.redexgen.X;

import android.annotation.TargetApi;
import android.os.Build;
import android.text.TextUtils;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.facebook.ads.internal.settings.AdInternalSettings;
import java.util.Arrays;
import java.util.Locale;
import kotlin.jvm.internal.ByteCompanionObject;

public final class NQ {
    public static byte[] A00;
    public static String[] A01;

    static {
        A03();
        A02();
    }

    public static String A01(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A00, i, i + i2);
        int i4 = 0;
        while (true) {
            int length = copyOfRange.length;
            String[] strArr = A01;
            if (strArr[2].charAt(11) != strArr[3].charAt(11)) {
                String[] strArr2 = A01;
                strArr2[0] = "y3Jx6HlNhV60F8H6sy5VNq1urpo6ww";
                strArr2[0] = "y3Jx6HlNhV60F8H6sy5VNq1urpo6ww";
                if (i4 >= length) {
                    return new String(copyOfRange);
                }
                copyOfRange[i4] = (byte) ((copyOfRange[i4] - i3) - 46);
                i4++;
            } else {
                throw new RuntimeException();
            }
        }
    }

    public static void A02() {
        A00 = new byte[]{-4, -3, 10, 16, 15, -43, -3, 7, -4, 9, 6, -81, -69, -69, -73, -70, -127, 118, 118, -66, -66, -66, 117, 108, -70, 117, -83, -88, -86, -84, -87, -74, -74, -78, 117, -86, -74, -76, -70, -58, -58, -62, -59, -116, -127, -127, -55, -55, -55, ByteCompanionObject.MIN_VALUE, -72, -77, -75, -73, -76, -63, -63, -67, ByteCompanionObject.MIN_VALUE, -75, -63, -65, -127, -48, -62, -47, -86, -58, -43, -62, -63, -96, -52, -53, -47, -62, -53, -47, -86, -52, -63, -62};
    }

    public static void A03() {
        A01 = new String[]{"y0bG", "5JZfgaaWSogkW6CLjfjWUpC4SZDBnyft", "n2Gy4uoDZ6R42oJOJFciNGvUDpuCFsrY", "5ngtkuzSlt3rkDwwAmiTxWGxDtSc3Osy", "THEbbJWzjj3eFDlXZnSzsYrmSmbq8w3u", "z1FkhoLSx5iYuLnsFM", "3teRnM8c4jgHocWnqrQSqB4Xqv7CtSGf", "kWJrKkGk49E8x2kcQZmrso6J6ECpLyYL"};
    }

    public static String A00() {
        String urlPrefix = AdInternalSettings.getUrlPrefix();
        if (TextUtils.isEmpty(urlPrefix)) {
            return A01(38, 25, 36);
        }
        return String.format(Locale.US, A01(11, 27, 25), urlPrefix);
    }

    public static void A04(WebView webView) {
        webView.loadUrl(A01(0, 11, 109));
        webView.clearCache(true);
    }

    /* JADX INFO: Multiple debug info for r5v1 android.webkit.WebSettings: [D('webSettings' android.webkit.WebSettings), D('method' java.lang.reflect.Method)] */
    @TargetApi(21)
    public static void A05(WebView webView) {
        WebSettings webSettings = webView.getSettings();
        if (Build.VERSION.SDK_INT >= 21) {
            webSettings.setMixedContentMode(0);
            return;
        }
        try {
            WebSettings.class.getMethod(A01(63, 19, 47), new Class[0]).invoke(webSettings, 0);
        } catch (Exception unused) {
        }
    }
}
