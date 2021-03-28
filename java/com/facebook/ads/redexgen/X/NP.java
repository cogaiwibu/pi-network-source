package com.facebook.ads.redexgen.X;

import android.graphics.Bitmap;
import android.net.http.SslError;
import android.os.Handler;
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.VisibleForTesting;
import com.facebook.ads.internal.protocol.AdErrorType;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.Date;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import org.json.JSONException;
import org.json.JSONObject;

public class NP extends WebViewClient {
    public static byte[] A0A;
    public Date A00;
    public boolean A01 = false;
    public final C0820Wh A02;
    public final WeakReference<C0838Wz> A03;
    public final WeakReference<NN> A04;
    public final WeakReference<AtomicBoolean> A05;
    public final WeakReference<LX> A06;
    public final WeakReference<C0641Ph> A07;
    public final AtomicInteger A08;
    public final AtomicReference<String> A09;

    static {
        A02();
    }

    public static String A00(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A0A, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] ^ i3) ^ 74);
        }
        return new String(copyOfRange);
    }

    public static void A02() {
        A0A = new byte[]{61, 51, 63, 61, 123, 122, 108, 124, 109, 118, 111, 107, 118, 112, 113, 61, 63, 37, 63, 61, 53, 59, 55, 53, 98, 101, 123, 53, 55, 45, 55, 53, 80, 15, 71, 122, 118, 112, 99, 34, 102, 99, 118, 99, 56, 34, 24, 15, 15, 18, 15, 34, 30, 18, 25, 24, 5, 18, 18, 15, 18, 63, 4, 5, 19, 3, 18, 9, 16, 20, 9, 15, 14, 13, 23, 59, 19, 1, 6, 59, 22, 1, 23, 11, 17, 22, 7, 1, 59, 1, 22, 22, 11, 22, 106, 105, 103, 98, 111, 104, 97, 89, 114, 111, 107, 99, 89, 111, 104, 89, 107, 111, 106, 106, 111, 117, 42, 33, 48, 126, 126, 1, 22, 22, 27, 1, 9, 20, 16, 29, 27, 22, 1, 23, 20, 11, 10, 23, 1, 7, 16, 4, 0, 16, 6, 1, 42, 28, 17, 57, 43, 44, 17, 56, 39, 43, 57, 99, 58, 123, 119, 124, 125, 58, 56, 34, 56, 58};
    }

    public NP(C0820Wh wh, WeakReference<NN> weakReference, WeakReference<C0641Ph> weakReference2, WeakReference<LX> weakReference3, WeakReference<AtomicBoolean> weakReference4, WeakReference<C0838Wz> weakReference5, AtomicInteger atomicInteger, AtomicReference<String> atomicReference) {
        this.A02 = wh;
        this.A04 = weakReference;
        this.A07 = weakReference2;
        this.A06 = weakReference3;
        this.A05 = weakReference4;
        this.A03 = weakReference5;
        this.A08 = atomicInteger;
        this.A09 = atomicReference;
    }

    @VisibleForTesting
    public static String A01(int i, String str, String str2) {
        return A00(157, 11, 82) + i + A00(0, 20, 85) + str + A00(20, 12, 93) + str2 + A00(32, 2, 56);
    }

    private void A03(int i, CharSequence charSequence, long j) {
        JSONObject jSONObject = new JSONObject();
        boolean z = charSequence != null;
        try {
            jSONObject.put(A00(46, 10, 55), i);
            jSONObject.put(A00(56, 17, 42), charSequence);
            jSONObject.put(A00(73, 21, 46), z);
            jSONObject.put(A00(94, 22, 76), j);
            jSONObject.put(A00(139, 10, 63), this.A09.get());
        } catch (JSONException unused) {
        }
        AbstractC02238h A042 = this.A02.A04();
        int i2 = C02248i.A2D;
        String defaultErrorMessage = AdErrorType.WEB_VIEW_FAILED_TO_LOAD.getDefaultErrorMessage();
        A042.A82(A00(149, 8, 4), i2, new C02258j(defaultErrorMessage, A00(34, 12, 72) + jSONObject.toString()));
    }

    /* access modifiers changed from: private */
    public void A04(int i, @Nullable String str) {
        if (A00(116, 23, 14).equals(str)) {
            this.A02.A0A().ADn();
            return;
        }
        this.A02.A0A().ADo(i, str);
        A03(i, str, new Date().getTime() - this.A00.getTime());
        if (this.A04.get() != null) {
            this.A04.get().A9b(i, str);
        }
    }

    public final void onPageFinished(WebView webView, String str) {
        boolean z;
        AnonymousClass0S A0A2 = this.A02.A0A();
        if (this.A03.get() != null) {
            z = true;
        } else {
            z = false;
        }
        A0A2.ADp(z);
        if (!(this.A03.get() == null || this.A05.get() == null || this.A05.get().get())) {
            this.A03.get().A04();
        }
        this.A01 = true;
    }

    public final void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        super.onPageStarted(webView, str, bitmap);
        this.A02.A0A().ADq();
        this.A00 = new Date();
        new Handler().postDelayed(new X0(this), (long) this.A08.get());
    }

    public final void onReceivedError(WebView webView, int i, String str, String str2) {
        this.A01 = true;
        A04(i, str);
    }

    @RequiresApi(api = 23)
    public final void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
        boolean A0m = J8.A0m(this.A02);
        String A002 = A00(0, 0, 49);
        if (A0m) {
            this.A01 = true;
            A04(webResourceError.getErrorCode(), A002 + ((Object) webResourceError.getDescription()));
            return;
        }
        this.A02.A0A().ADr(A01(webResourceError.getErrorCode(), A002 + ((Object) webResourceError.getDescription()), A002 + webResourceRequest.getUrl()));
    }

    public final void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
        this.A02.A0A().ADs();
        sslErrorHandler.cancel();
    }

    @Override // android.webkit.WebViewClient
    public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
        if (this.A04.get() == null) {
            return true;
        }
        this.A04.get().A99(str, new NU().A04(this.A07.get()).A03(this.A06.get()).A06());
        return true;
    }
}
