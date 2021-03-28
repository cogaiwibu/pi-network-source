package com.bytedance.sdk.openadsdk.g;

import android.os.Build;
import android.webkit.WebView;

/* compiled from: LoadUrlUtils */
public class k {
    private static final a a;

    /* access modifiers changed from: private */
    /* compiled from: LoadUrlUtils */
    public static class a {
        private a() {
        }

        public void a(WebView webView, String str) {
            if (webView != null) {
                try {
                    webView.loadUrl(str);
                } catch (Throwable unused) {
                }
            }
        }
    }

    /* compiled from: LoadUrlUtils */
    private static class b extends a {
        private b() {
            super();
        }

        @Override // com.bytedance.sdk.openadsdk.g.k.a
        public void a(WebView webView, String str) {
            if (webView != null) {
                boolean z = false;
                if (str != null && str.startsWith("javascript:")) {
                    try {
                        webView.evaluateJavascript(str, null);
                        z = true;
                    } catch (Throwable th) {
                        boolean z2 = th instanceof IllegalStateException;
                    }
                }
                if (!z) {
                    try {
                        webView.loadUrl(str);
                    } catch (Throwable unused) {
                    }
                }
            }
        }
    }

    static {
        if (Build.VERSION.SDK_INT >= 19) {
            a = new b();
        } else {
            a = new a();
        }
    }

    public static void a(WebView webView, String str) {
        a.a(webView, str);
    }
}
