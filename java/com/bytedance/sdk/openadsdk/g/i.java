package com.bytedance.sdk.openadsdk.g;

import android.net.Uri;
import android.text.TextUtils;
import android.webkit.WebView;
import com.bytedance.sdk.openadsdk.core.r;

/* compiled from: JsBridgeUtils */
public class i {
    public static void a(Uri uri, r rVar) {
        if (rVar != null && rVar.a(uri)) {
            try {
                rVar.b(uri);
            } catch (Exception e) {
                l.d("WebView", "TTAndroidObj handleUri exception: " + e);
            }
        }
    }

    public static String a(WebView webView, int i) {
        if (webView == null) {
            return "";
        }
        String userAgentString = webView.getSettings().getUserAgentString();
        if (TextUtils.isEmpty(userAgentString)) {
            return "";
        }
        return userAgentString + " open_news" + " open_news_u_s/" + i;
    }
}
