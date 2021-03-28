package com.bytedance.sdk.openadsdk.b;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import com.bytedance.sdk.openadsdk.core.c.g;
import com.bytedance.sdk.openadsdk.g.k;
import com.bytedance.sdk.openadsdk.g.l;
import com.facebook.internal.NativeProtocol;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: LandingPageLog */
public class i {
    private int a = 1;
    private boolean b = false;
    private boolean c = false;
    private boolean d = false;
    private int e = -1;
    private String f;
    private final Context g;
    private final g h;
    private String i = "landingpage";
    private long j = 0;
    private long k = 0;
    private long l = 0;
    private long m = 0;
    private boolean n = false;
    private AtomicInteger o = new AtomicInteger(0);
    private WebView p;
    private boolean q = false;

    public i(Context context, g gVar, WebView webView) {
        this.g = context;
        this.h = gVar;
        this.p = webView;
        webView.addJavascriptInterface(new a(), "JS_LANDING_PAGE_LOG_OBJ");
    }

    public i a(boolean z) {
        this.q = z;
        return this;
    }

    public void a(WebView webView, int i2) {
        l.b("LandingPageLog", "onWebProgress: " + i2);
        if (this.l == 0 && i2 > 0) {
            this.l = System.currentTimeMillis();
        } else if (this.m == 0 && i2 == 100) {
            this.m = System.currentTimeMillis();
        }
    }

    public void a(WebView webView, String str, Bitmap bitmap) {
        l.b("LandingPageLog", "onWebStarted: " + String.valueOf(str));
        if (!this.b) {
            this.b = true;
            a("load_start", (JSONObject) null);
        }
    }

    public void a(WebView webView, String str) {
        l.b("LandingPageLog", "onWebFinished: " + String.valueOf(str));
        if (webView != null && !this.n) {
            this.n = true;
            k.a(webView, "javascript:\nfunction sendScroll(){\n   var totalH = document.body.scrollHeight || document.documentElement.scrollHeight;\n   var clientH = window.innerHeight || document.documentElement.clientHeight;\n   var scrollH = document.body.scrollTop || document.documentElement.scrollTop;\n   var validH = scrollH + clientH;\n   var result = (validH/totalH*100).toFixed(2);\n   console.log('LandingPageLogscroll status: (' + scrollH + '+' + clientH + ')/' + totalH + '=' + result);\n   window.JS_LANDING_PAGE_LOG_OBJ.readPercent(result);\n}\nsendScroll();\nwindow.addEventListener('scroll', function(e){\n    sendScroll();\n});");
        }
        if (this.a != 3) {
            this.a = 2;
        }
        if (this.a == 2) {
            long j2 = this.m - this.l;
            if (!this.c) {
                this.c = true;
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("load_duration", j2);
                } catch (Exception unused) {
                }
                a("load_finish", jSONObject);
            }
        } else if (!this.d) {
            this.d = true;
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put(NativeProtocol.BRIDGE_ARG_ERROR_CODE, this.e);
                jSONObject2.put("error_msg", this.f);
            } catch (Exception unused2) {
            }
            a("load_fail", jSONObject2);
        }
    }

    public void a(WebView webView, int i2, String str, String str2) {
        l.b("LandingPageLog", "onWebError: " + i2 + ", " + String.valueOf(str) + ", " + String.valueOf(str2));
        this.a = 3;
        this.e = i2;
        this.f = str;
    }

    public void a() {
        l.b("LandingPageLog", "onResume");
        this.j = System.currentTimeMillis();
    }

    public void b() {
        l.b("LandingPageLog", "onStop");
        int i2 = 0;
        boolean z = this.a == 2;
        long currentTimeMillis = System.currentTimeMillis();
        this.k = currentTimeMillis;
        long j2 = currentTimeMillis - this.j;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("load_status", this.a);
            jSONObject.put("stay_page_duration", j2);
            if (z) {
                i2 = this.o.get();
            }
            jSONObject.put("max_scroll_percent", i2);
        } catch (JSONException unused) {
        }
        a("landing_close", jSONObject);
    }

    public void c() {
        l.b("LandingPageLog", "onDestroy");
        this.p = null;
    }

    private void a(String str, JSONObject jSONObject) {
        if (this.q && this.h != null && !TextUtils.isEmpty(str)) {
            JSONObject jSONObject2 = null;
            if (jSONObject != null) {
                try {
                    JSONObject jSONObject3 = new JSONObject();
                    try {
                        jSONObject3.put("ad_extra_data", jSONObject);
                    } catch (JSONException unused) {
                    }
                    jSONObject2 = jSONObject3;
                } catch (JSONException unused2) {
                }
            }
            l.b("LandingPageLog", "sendEvent: " + String.valueOf(this.i) + ", " + String.valueOf(str) + ", ext=" + String.valueOf(jSONObject2));
            d.b(this.g, this.h, this.i, str, jSONObject2);
        }
    }

    /* compiled from: LandingPageLog */
    private class a {
        private a() {
        }

        @JavascriptInterface
        public void readPercent(String str) {
            StringBuilder sb = new StringBuilder();
            sb.append("measure height: ");
            int i = 0;
            sb.append(i.this.p == null ? 0 : i.this.p.getMeasuredHeight());
            l.b("LandingPageLog", sb.toString());
            l.b("LandingPageLog", "read percent: " + String.valueOf(str));
            try {
                int intValue = Float.valueOf(str).intValue();
                if (intValue > 100) {
                    i = 100;
                } else if (intValue >= 0) {
                    i = intValue;
                }
            } catch (Throwable unused) {
            }
            i.this.o.set(i);
        }
    }
}
