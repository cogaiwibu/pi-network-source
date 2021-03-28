package com.facebook.ads.redexgen.X;

import android.webkit.WebView;
import java.util.concurrent.Callable;

/* renamed from: com.facebook.ads.redexgen.X.9F  reason: invalid class name */
public class AnonymousClass9F implements Callable<String> {
    public final /* synthetic */ AnonymousClass8H A00;

    public AnonymousClass9F(AnonymousClass8H r1) {
        this.A00 = r1;
    }

    /* access modifiers changed from: private */
    /* renamed from: A00 */
    public final String call() {
        String str = (String) AnonymousClass9G.A04.get();
        if (str != null) {
            return str;
        }
        WebView webView = new WebView(this.A00.getApplicationContext());
        String userAgentString = webView.getSettings().getUserAgentString();
        webView.destroy();
        if (userAgentString != null) {
            AnonymousClass9G.A04.set(userAgentString);
        }
        return userAgentString;
    }
}
