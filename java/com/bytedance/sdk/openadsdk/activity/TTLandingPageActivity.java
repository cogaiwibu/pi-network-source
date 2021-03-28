package com.bytedance.sdk.openadsdk.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.webkit.DownloadListener;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.bytedance.sdk.openadsdk.b.i;
import com.bytedance.sdk.openadsdk.core.a.a;
import com.bytedance.sdk.openadsdk.core.c;
import com.bytedance.sdk.openadsdk.core.c.g;
import com.bytedance.sdk.openadsdk.core.m;
import com.bytedance.sdk.openadsdk.core.r;
import com.bytedance.sdk.openadsdk.core.v;
import com.bytedance.sdk.openadsdk.g.l;
import com.bytedance.sdk.openadsdk.g.o;
import com.bytedance.sdk.openadsdk.g.t;
import com.com.bytedance.overseas.sdk.download.b;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public class TTLandingPageActivity extends Activity {
    private static final String b = TTLandingPageActivity.class.getSimpleName();
    i a;
    private SSWebView c;
    private ImageView d;
    private ImageView e;
    private TextView f;
    private Context g;
    private int h;
    private ViewStub i;
    private ViewStub j;
    private ViewStub k;
    private Button l;
    private ProgressBar m;
    private String n;
    private String o;
    private r p;
    private int q;
    private String r;
    private g s;
    private b t;
    private final Map<String, b> u = Collections.synchronizedMap(new HashMap());
    private String v = "ダウンロード";

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (com.bytedance.sdk.openadsdk.core.g.b().m()) {
            getWindow().addFlags(2621440);
        }
        setContentView(o.f(this, "tt_activity_ttlandingpage"));
        c();
        this.g = this;
        m.a(this).a(false).b(false).a(this.c);
        Intent intent = getIntent();
        this.h = intent.getIntExtra("sdk_version", 1);
        this.n = intent.getStringExtra("adid");
        this.o = intent.getStringExtra("log_extra");
        this.q = intent.getIntExtra("source", -1);
        String stringExtra = intent.getStringExtra("url");
        String stringExtra2 = intent.getStringExtra("web_title");
        intent.getStringExtra("icon_url");
        this.r = intent.getStringExtra("event_tag");
        if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
            String stringExtra3 = intent.getStringExtra(TTAdConstant.MULTI_PROCESS_MATERIALMETA);
            if (stringExtra3 != null) {
                try {
                    this.s = c.b(new JSONObject(stringExtra3));
                } catch (Exception e2) {
                    l.b(b, "TTLandingPageActivity - onCreate MultiGlobalInfo : ", e2);
                }
            }
        } else {
            this.s = com.bytedance.sdk.openadsdk.core.o.a().d();
            com.bytedance.sdk.openadsdk.core.o.a().h();
        }
        this.a = new i(this, this.s, this.c).a(true);
        d();
        this.c.setWebViewClient(new b(this.g, this.p, this.n, this.a) {
            /* class com.bytedance.sdk.openadsdk.activity.TTLandingPageActivity.AnonymousClass1 */

            @Override // com.bytedance.sdk.openadsdk.activity.b
            public void onPageFinished(WebView webView, String str) {
                super.onPageFinished(webView, str);
                try {
                    if (TTLandingPageActivity.this.m != null && !TTLandingPageActivity.this.isFinishing()) {
                        TTLandingPageActivity.this.m.setVisibility(8);
                    }
                } catch (Throwable unused) {
                }
            }
        });
        this.c.getSettings().setUserAgentString(com.bytedance.sdk.openadsdk.g.i.a(this.c, this.h));
        if (Build.VERSION.SDK_INT >= 21) {
            this.c.getSettings().setMixedContentMode(0);
        }
        this.c.loadUrl(stringExtra);
        this.c.setWebChromeClient(new a(this.p, this.a) {
            /* class com.bytedance.sdk.openadsdk.activity.TTLandingPageActivity.AnonymousClass2 */

            @Override // com.bytedance.sdk.openadsdk.activity.a
            public void onProgressChanged(WebView webView, int i) {
                super.onProgressChanged(webView, i);
                if (TTLandingPageActivity.this.m != null && !TTLandingPageActivity.this.isFinishing()) {
                    if (i != 100 || !TTLandingPageActivity.this.m.isShown()) {
                        TTLandingPageActivity.this.m.setProgress(i);
                    } else {
                        TTLandingPageActivity.this.m.setVisibility(8);
                    }
                }
            }
        });
        this.c.setDownloadListener(new DownloadListener() {
            /* class com.bytedance.sdk.openadsdk.activity.TTLandingPageActivity.AnonymousClass3 */

            public void onDownloadStart(String str, String str2, String str3, String str4, long j) {
                if (TTLandingPageActivity.this.t != null) {
                    TTLandingPageActivity.this.t.a();
                }
            }
        });
        TextView textView = this.f;
        if (textView != null) {
            if (TextUtils.isEmpty(stringExtra2)) {
                stringExtra2 = o.a(this, "tt_web_title_default");
            }
            textView.setText(stringExtra2);
        }
        a();
    }

    private void a() {
        g gVar = this.s;
        if (gVar != null && gVar.g() == 4) {
            this.k.setVisibility(0);
            Button button = (Button) findViewById(o.e(this, "tt_browser_download_btn"));
            this.l = button;
            if (button != null) {
                a(b());
                if (this.t == null) {
                    this.t = com.com.bytedance.overseas.sdk.download.c.a(this, this.s, TextUtils.isEmpty(this.r) ? t.a(this.q) : this.r);
                }
                a aVar = new a(this, this.s, this.r, this.q);
                aVar.a(false);
                this.l.setOnClickListener(aVar);
                this.l.setOnTouchListener(aVar);
                aVar.a(this.t);
            }
        }
    }

    private String b() {
        g gVar = this.s;
        if (gVar != null && !TextUtils.isEmpty(gVar.q())) {
            this.v = this.s.q();
        }
        return this.v;
    }

    private void a(final String str) {
        Button button;
        if (!TextUtils.isEmpty(str) && (button = this.l) != null) {
            button.post(new Runnable() {
                /* class com.bytedance.sdk.openadsdk.activity.TTLandingPageActivity.AnonymousClass4 */

                public void run() {
                    if (TTLandingPageActivity.this.l != null && !TTLandingPageActivity.this.isFinishing()) {
                        TTLandingPageActivity.this.l.setText(str);
                    }
                }
            });
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        a();
    }

    private void c() {
        this.c = (SSWebView) findViewById(o.e(this, "tt_browser_webview"));
        this.k = (ViewStub) findViewById(o.e(this, "tt_browser_download_btn_stub"));
        this.i = (ViewStub) findViewById(o.e(this, "tt_browser_titlebar_view_stub"));
        this.j = (ViewStub) findViewById(o.e(this, "tt_browser_titlebar_dark_view_stub"));
        int l2 = com.bytedance.sdk.openadsdk.core.g.b().l();
        if (l2 == 0) {
            this.i.setVisibility(0);
        } else if (l2 == 1) {
            this.j.setVisibility(0);
        }
        ImageView imageView = (ImageView) findViewById(o.e(this, "tt_titlebar_back"));
        this.d = imageView;
        if (imageView != null) {
            imageView.setOnClickListener(new View.OnClickListener() {
                /* class com.bytedance.sdk.openadsdk.activity.TTLandingPageActivity.AnonymousClass5 */

                public void onClick(View view) {
                    if (TTLandingPageActivity.this.c == null) {
                        return;
                    }
                    if (TTLandingPageActivity.this.c.canGoBack()) {
                        TTLandingPageActivity.this.c.goBack();
                    } else {
                        TTLandingPageActivity.this.finish();
                    }
                }
            });
        }
        ImageView imageView2 = (ImageView) findViewById(o.e(this, "tt_titlebar_close"));
        this.e = imageView2;
        if (imageView2 != null) {
            imageView2.setOnClickListener(new View.OnClickListener() {
                /* class com.bytedance.sdk.openadsdk.activity.TTLandingPageActivity.AnonymousClass6 */

                public void onClick(View view) {
                    TTLandingPageActivity.this.finish();
                }
            });
        }
        this.f = (TextView) findViewById(o.e(this, "tt_titlebar_title"));
        this.m = (ProgressBar) findViewById(o.e(this, "tt_browser_progress"));
    }

    private void d() {
        r rVar = new r(this);
        this.p = rVar;
        rVar.a(this.c).a(this.n).b(this.o).a(this.s).b(this.q).a(this.s.b()).c(t.c(this.s));
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        r rVar = this.p;
        if (rVar != null) {
            rVar.a();
        }
        i iVar = this.a;
        if (iVar != null) {
            iVar.a();
        }
    }

    /* access modifiers changed from: protected */
    public void onStop() {
        super.onStop();
        i iVar = this.a;
        if (iVar != null) {
            iVar.b();
        }
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
        com.bytedance.sdk.openadsdk.core.o.a().b(true);
        r rVar = this.p;
        if (rVar != null) {
            rVar.b();
        }
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        ViewGroup viewGroup;
        super.onDestroy();
        try {
            if (!(getWindow() == null || (viewGroup = (ViewGroup) getWindow().getDecorView()) == null)) {
                viewGroup.removeAllViews();
            }
        } catch (Throwable unused) {
        }
        v.a(this.g, this.c);
        v.a(this.c);
        this.c = null;
        r rVar = this.p;
        if (rVar != null) {
            rVar.c();
        }
        Map<String, b> map = this.u;
        if (map != null) {
            map.clear();
        }
        i iVar = this.a;
        if (iVar != null) {
            iVar.c();
        }
    }
}
