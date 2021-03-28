package com.facebook.ads.redexgen.X;

import android.os.Build;
import android.util.Log;
import android.webkit.CookieManager;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.facebook.ads.internal.api.BuildConfigApi;
import java.util.Arrays;
import kotlin.jvm.internal.ByteCompanionObject;

public abstract class NK extends WebView {
    public static byte[] A02;
    public static final String A03 = NK.class.getSimpleName();
    public boolean A00;
    public final C0820Wh A01;

    public static String A00(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A02, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] ^ i3) ^ 105);
        }
        return new String(copyOfRange);
    }

    public static void A02() {
        A02 = new byte[]{87, 112, 120, 125, 116, 117, 49, 101, 126, 49, 120, ByteCompanionObject.MAX_VALUE, 120, 101, 120, 112, 125, 120, 107, 116, 49, 82, 126, 126, 122, 120, 116, 92, 112, ByteCompanionObject.MAX_VALUE, 112, 118, 116, 99, 63};
    }

    static {
        A02();
    }

    public NK(C0820Wh wh) {
        super(wh);
        this.A01 = wh;
        A01();
    }

    private void A01() {
        setWebChromeClient(A0A());
        setWebViewClient(A0B());
        NQ.A05(this);
        getSettings().setJavaScriptEnabled(true);
        getSettings().setDomStorageEnabled(true);
        if (Build.VERSION.SDK_INT >= 17) {
            getSettings().setMediaPlaybackRequiresUserGesture(false);
        }
        if (BuildConfigApi.isDebug() && Build.VERSION.SDK_INT >= 19) {
            setWebContentsDebuggingEnabled(true);
        }
        setHorizontalScrollBarEnabled(false);
        setHorizontalScrollbarOverlay(false);
        setVerticalScrollBarEnabled(false);
        setVerticalScrollbarOverlay(false);
        if (Build.VERSION.SDK_INT >= 21) {
            try {
                CookieManager.getInstance().setAcceptThirdPartyCookies(this, true);
            } catch (Exception unused) {
                Log.w(A03, A00(0, 35, 120));
            }
        }
    }

    public final boolean A03() {
        return this.A00;
    }

    public WebChromeClient A0A() {
        return new WebChromeClient();
    }

    public WebViewClient A0B() {
        return new WebViewClient();
    }

    public void destroy() {
        this.A00 = true;
        super.destroy();
    }

    public C0820Wh getAdContextWrapper() {
        return this.A01;
    }
}
