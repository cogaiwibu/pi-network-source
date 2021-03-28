package com.bytedance.sdk.openadsdk.core;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.facebook.appevents.AppEventsConstants;
import java.lang.ref.WeakReference;

/* compiled from: SSWebSettings */
public class m {
    private WeakReference<Context> a;
    private boolean b = true;
    private boolean c = true;
    private boolean d = true;
    private boolean e = true;
    private boolean f = true;
    private boolean g = true;
    private boolean h = true;

    public static m a(Context context) {
        return new m(context);
    }

    private m(Context context) {
        this.a = new WeakReference<>(context);
    }

    public m a(boolean z) {
        this.h = z;
        return this;
    }

    public m b(boolean z) {
        this.c = z;
        return this;
    }

    public void a(WebView webView) {
        WebSettings settings;
        if (webView != null && this.a.get() != null && (settings = webView.getSettings()) != null) {
            try {
                settings.setJavaScriptEnabled(true);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            try {
                if (this.c) {
                    settings.setSupportZoom(true);
                    settings.setBuiltInZoomControls(true);
                } else {
                    settings.setSupportZoom(false);
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
            settings.setLoadWithOverviewMode(true);
            settings.setUseWideViewPort(this.d);
            settings.setDomStorageEnabled(this.e);
            settings.setAllowFileAccess(this.f);
            settings.setBlockNetworkImage(!this.g);
            try {
                if (Build.VERSION.SDK_INT >= 11 && !this.h) {
                    webView.setLayerType(1, null);
                } else if (Build.VERSION.SDK_INT >= 16 && this.h) {
                    webView.setLayerType(2, null);
                }
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
        }
    }

    public static String a(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || AppEventsConstants.EVENT_PARAM_VALUE_NO.equals(str2) || !str.contains("{{ad_id}}")) {
            return null;
        }
        String replace = str.replace("{{ad_id}}", str2);
        return "javascript:(function () {    var JS_ACTLOG_URL = '" + replace + "';    var head = document.getElementsByTagName('head')[0];    var script = document.createElement('script');    script.type = 'text/javascript';    script.src = JS_ACTLOG_URL;    head.appendChild(script);})();";
    }
}
