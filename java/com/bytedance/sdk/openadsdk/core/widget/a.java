package com.bytedance.sdk.openadsdk.core.widget;

import android.app.Dialog;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bytedance.sdk.openadsdk.R;
import com.bytedance.sdk.openadsdk.core.j;
import com.bytedance.sdk.openadsdk.g.o;
import com.bytedance.sdk.openadsdk.g.u;

/* compiled from: PrivacyProtectDialog */
public class a extends Dialog {
    private Context a;
    private String b;
    private String c;
    private c d;
    private b e;
    private RelativeLayout f;

    /* compiled from: PrivacyProtectDialog */
    public interface b {
        void a();
    }

    /* compiled from: PrivacyProtectDialog */
    public interface c {
        void a();
    }

    public a(Context context) {
        super(context, o.g(context, "tt_privacy_dialogTheme"));
        this.a = context;
    }

    public a a(String str, c cVar) {
        this.b = str;
        this.d = cVar;
        return this;
    }

    public a a(String str, b bVar) {
        this.c = str;
        this.e = bVar;
        return this;
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        a();
        b();
    }

    private void a() {
        View inflate = LayoutInflater.from(this.a).inflate(o.f(this.a, "tt_privacy_dialog"), (ViewGroup) null);
        setContentView(inflate);
        final TTCornersWebView tTCornersWebView = (TTCornersWebView) inflate.findViewById(o.e(this.a, "tt_privacy_webview"));
        Button button = (Button) inflate.findViewById(o.e(this.a, "tt_privacy_accept_btn"));
        TextView textView = (TextView) inflate.findViewById(o.e(this.a, "tt_privacy_reject_btn"));
        RelativeLayout relativeLayout = (RelativeLayout) inflate.findViewById(o.e(this.a, "tt_privacy_back_layout"));
        this.f = relativeLayout;
        u.a(relativeLayout, 8);
        textView.getPaint().setFlags(8);
        a(tTCornersWebView);
        if (!TextUtils.isEmpty(this.b) && !TextUtils.isEmpty(this.c)) {
            button.setText(this.b);
            textView.setText(this.c);
        }
        button.setOnClickListener(new View$OnClickListenerC0008a());
        textView.setOnClickListener(new View$OnClickListenerC0008a());
        this.f.setOnClickListener(new View.OnClickListener() {
            /* class com.bytedance.sdk.openadsdk.core.widget.a.AnonymousClass1 */

            public void onClick(View view) {
                TTCornersWebView tTCornersWebView = tTCornersWebView;
                if (tTCornersWebView != null && tTCornersWebView.canGoBack()) {
                    tTCornersWebView.goBack();
                    if (!tTCornersWebView.canGoBack()) {
                        u.a(a.this.f, 8);
                    }
                }
            }
        });
    }

    private void a(final TTCornersWebView tTCornersWebView) {
        String j = j.e().j();
        if (j != null) {
            try {
                tTCornersWebView.getSettings().setJavaScriptEnabled(true);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            tTCornersWebView.loadUrl(j);
            if (Build.VERSION.SDK_INT >= 21) {
                tTCornersWebView.getSettings().setMixedContentMode(0);
            }
            tTCornersWebView.setWebViewClient(new WebViewClient() {
                /* class com.bytedance.sdk.openadsdk.core.widget.a.AnonymousClass2 */

                @Override // android.webkit.WebViewClient
                public boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
                    if (webView == null || webResourceRequest == null) {
                        return false;
                    }
                    if (Build.VERSION.SDK_INT >= 21) {
                        webView.loadUrl(webResourceRequest.getUrl().toString());
                        return true;
                    }
                    webView.loadUrl(webResourceRequest.toString());
                    return true;
                }

                public void onPageFinished(WebView webView, String str) {
                    super.onPageFinished(webView, str);
                    TTCornersWebView tTCornersWebView = tTCornersWebView;
                    if (tTCornersWebView != null && tTCornersWebView.canGoBack()) {
                        u.a(a.this.f, 0);
                    }
                }
            });
        }
    }

    private void b() {
        WindowManager.LayoutParams attributes;
        setCancelable(false);
        Window window = getWindow();
        if (window != null && (attributes = window.getAttributes()) != null) {
            attributes.dimAmount = 0.5f;
            double d2 = (double) this.a.getResources().getDisplayMetrics().widthPixels;
            Double.isNaN(d2);
            attributes.width = (int) (d2 * 0.8d);
            window.setAttributes(attributes);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: com.bytedance.sdk.openadsdk.core.widget.a$a  reason: collision with other inner class name */
    /* compiled from: PrivacyProtectDialog */
    public class View$OnClickListenerC0008a implements View.OnClickListener {
        private View$OnClickListenerC0008a() {
        }

        public void onClick(View view) {
            int id = view.getId();
            if (id == R.id.tt_privacy_accept_btn) {
                if (a.this.d != null) {
                    a.this.d.a();
                }
                a.this.dismiss();
            } else if (id == R.id.tt_privacy_reject_btn) {
                if (a.this.e != null) {
                    a.this.e.a();
                }
                a.this.dismiss();
            }
        }
    }
}
