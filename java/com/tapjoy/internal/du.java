package com.tapjoy.internal;

import android.os.Handler;
import android.webkit.WebView;
import java.util.List;

public final class du extends ds {
    WebView f;
    private List g;
    private final String h;

    public du(List list, String str) {
        this.g = list;
        this.h = str;
    }

    @Override // com.tapjoy.internal.ds
    public final void b() {
        super.b();
        new Handler().postDelayed(new Runnable() {
            /* class com.tapjoy.internal.du.AnonymousClass1 */
            private WebView b = du.this.f;

            public final void run() {
                this.b.destroy();
            }
        }, 2000);
        this.f = null;
    }

    @Override // com.tapjoy.internal.ds
    public final void a() {
        super.a();
        WebView webView = new WebView(df.a().a);
        this.f = webView;
        webView.getSettings().setJavaScriptEnabled(true);
        a(this.f);
        dg.a();
        dg.a(this.f, this.h);
        for (cy cyVar : this.g) {
            String externalForm = cyVar.b.toExternalForm();
            dg.a();
            WebView webView2 = this.f;
            if (externalForm != null) {
                dg.a(webView2, "var script=document.createElement('script');script.setAttribute(\"type\",\"text/javascript\");script.setAttribute(\"src\",\"%SCRIPT_SRC%\");document.body.appendChild(script);".replace("%SCRIPT_SRC%", externalForm));
            }
        }
    }
}
