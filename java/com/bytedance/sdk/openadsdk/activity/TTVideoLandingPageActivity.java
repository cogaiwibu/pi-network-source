package com.bytedance.sdk.openadsdk.activity;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
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
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.bytedance.sdk.openadsdk.b.d;
import com.bytedance.sdk.openadsdk.b.i;
import com.bytedance.sdk.openadsdk.core.c.g;
import com.bytedance.sdk.openadsdk.core.r;
import com.bytedance.sdk.openadsdk.core.v;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoAdView;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.c;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.e;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.f;
import com.bytedance.sdk.openadsdk.core.widget.RoundImageView;
import com.bytedance.sdk.openadsdk.g.l;
import com.bytedance.sdk.openadsdk.g.m;
import com.bytedance.sdk.openadsdk.g.o;
import com.bytedance.sdk.openadsdk.g.t;
import com.bytedance.sdk.openadsdk.g.u;
import com.bytedance.sdk.openadsdk.multipro.b.a;
import com.com.bytedance.overseas.sdk.download.b;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public class TTVideoLandingPageActivity extends Activity {
    private TextView A;
    private ViewStub B;
    private Button C;
    private ProgressBar D;
    private b E;
    private final Map<String, b> F = Collections.synchronizedMap(new HashMap());
    private boolean G = false;
    private String H;
    private boolean I = false;
    private boolean J = true;
    private boolean K = false;
    private String L = null;
    private int M;
    private a N;
    private i O;
    private com.bytedance.sdk.openadsdk.core.a.a P = null;
    private final e Q = new e() {
        /* class com.bytedance.sdk.openadsdk.activity.TTVideoLandingPageActivity.AnonymousClass7 */

        @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.e
        public void a(boolean z) {
            TTVideoLandingPageActivity.this.G = z;
            if (TTVideoLandingPageActivity.this.isFinishing()) {
                return;
            }
            if (z) {
                u.a(TTVideoLandingPageActivity.this.a, 8);
                u.a(TTVideoLandingPageActivity.this.k, 8);
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) TTVideoLandingPageActivity.this.l.getLayoutParams();
                TTVideoLandingPageActivity.this.s = marginLayoutParams.leftMargin;
                TTVideoLandingPageActivity.this.r = marginLayoutParams.topMargin;
                TTVideoLandingPageActivity.this.t = marginLayoutParams.width;
                TTVideoLandingPageActivity.this.u = marginLayoutParams.height;
                marginLayoutParams.width = -1;
                marginLayoutParams.height = -1;
                marginLayoutParams.topMargin = 0;
                marginLayoutParams.leftMargin = 0;
                TTVideoLandingPageActivity.this.l.setLayoutParams(marginLayoutParams);
                return;
            }
            u.a(TTVideoLandingPageActivity.this.a, 0);
            u.a(TTVideoLandingPageActivity.this.k, 0);
            ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) TTVideoLandingPageActivity.this.l.getLayoutParams();
            marginLayoutParams2.width = TTVideoLandingPageActivity.this.t;
            marginLayoutParams2.height = TTVideoLandingPageActivity.this.u;
            marginLayoutParams2.leftMargin = TTVideoLandingPageActivity.this.s;
            marginLayoutParams2.topMargin = TTVideoLandingPageActivity.this.r;
            TTVideoLandingPageActivity.this.l.setLayoutParams(marginLayoutParams2);
        }
    };
    private boolean R = false;
    private final BroadcastReceiver S = new BroadcastReceiver() {
        /* class com.bytedance.sdk.openadsdk.activity.TTVideoLandingPageActivity.AnonymousClass8 */

        public void onReceive(Context context, Intent intent) {
            if ("android.net.conn.CONNECTIVITY_CHANGE".equals(intent.getAction())) {
                int c = m.c(TTVideoLandingPageActivity.this.getApplicationContext());
                if (!(TTVideoLandingPageActivity.this.M != 0 || c == 0 || TTVideoLandingPageActivity.this.a == null || TTVideoLandingPageActivity.this.L == null)) {
                    TTVideoLandingPageActivity.this.a.loadUrl(TTVideoLandingPageActivity.this.L);
                }
                if (!(TTVideoLandingPageActivity.this.n == null || TTVideoLandingPageActivity.this.n.getNativeVideoController() == null || TTVideoLandingPageActivity.this.I || TTVideoLandingPageActivity.this.M == c)) {
                    ((f) TTVideoLandingPageActivity.this.n.getNativeVideoController()).a(context);
                }
                TTVideoLandingPageActivity.this.M = c;
            }
        }
    };
    private SSWebView a;
    private ImageView b;
    private ImageView c;
    private TextView d;
    private Context e;
    private int f;
    private String g;
    private String h;
    private r i;
    private int j;
    private RelativeLayout k;
    private FrameLayout l;
    private int m = -1;
    private NativeVideoAdView n;
    private Long o;
    private g p;
    private c q;
    private int r = 0;
    private int s = 0;
    private int t = 0;
    private int u = 0;
    private String v = "ダウンロード";
    private RelativeLayout w;
    private TextView x;
    private RoundImageView y;
    private TextView z;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (com.bytedance.sdk.openadsdk.core.g.b().m()) {
            getWindow().addFlags(2621440);
        }
        try {
            getWindow().addFlags(16777216);
        } catch (Throwable unused) {
        }
        this.M = m.c(getApplicationContext());
        setContentView(o.f(this, "tt_activity_videolandingpage"));
        this.e = this;
        Intent intent = getIntent();
        this.f = intent.getIntExtra("sdk_version", 1);
        this.g = intent.getStringExtra("adid");
        this.h = intent.getStringExtra("log_extra");
        this.j = intent.getIntExtra("source", -1);
        this.L = intent.getStringExtra("url");
        String stringExtra = intent.getStringExtra("web_title");
        this.H = intent.getStringExtra("event_tag");
        this.K = intent.getBooleanExtra("video_is_auto_play", true);
        if (bundle != null && bundle.getLong("video_play_position") > 0) {
            this.o = Long.valueOf(bundle.getLong("video_play_position", 0));
        }
        if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
            String stringExtra2 = intent.getStringExtra(TTAdConstant.MULTI_PROCESS_MATERIALMETA);
            String stringExtra3 = intent.getStringExtra(TTAdConstant.MULTI_PROCESS_DATA);
            if (stringExtra2 != null) {
                try {
                    this.p = com.bytedance.sdk.openadsdk.core.c.b(new JSONObject(stringExtra2));
                } catch (Exception e2) {
                    if (l.c()) {
                        e2.printStackTrace();
                    }
                }
            }
            if (stringExtra3 != null) {
                this.N = a.a(new JSONObject(stringExtra3));
            }
            a aVar = this.N;
            if (aVar != null) {
                this.o = Long.valueOf(aVar.f);
                this.I = this.N.a;
            }
        } else {
            this.p = com.bytedance.sdk.openadsdk.core.o.a().d();
            c b2 = com.bytedance.sdk.openadsdk.core.o.a().b();
            this.q = b2;
            if (b2 != null) {
                this.o = Long.valueOf(b2.g());
                this.I = this.q.p();
            }
            com.bytedance.sdk.openadsdk.core.o.a().h();
        }
        if (bundle != null) {
            String string = bundle.getString("material_meta");
            if (this.p == null) {
                try {
                    this.p = com.bytedance.sdk.openadsdk.core.c.b(new JSONObject(string));
                } catch (Throwable unused2) {
                }
            }
            long j2 = bundle.getLong("video_play_position");
            boolean z2 = bundle.getBoolean("is_complete");
            if (j2 > 0) {
                this.o = Long.valueOf(j2);
            }
            if (z2) {
                this.I = z2;
            }
        }
        g gVar = this.p;
        if (gVar != null) {
            this.m = gVar.v();
            e();
            j();
            k();
            com.bytedance.sdk.openadsdk.core.m.a(this.e).a(Build.VERSION.SDK_INT >= 16).b(false).a(this.a);
            this.O = new i(this, this.p, this.a).a(true);
            this.a.setWebViewClient(new b(this.e, this.i, this.g, this.O) {
                /* class com.bytedance.sdk.openadsdk.activity.TTVideoLandingPageActivity.AnonymousClass1 */

                @Override // com.bytedance.sdk.openadsdk.activity.b
                public void onPageFinished(WebView webView, String str) {
                    super.onPageFinished(webView, str);
                    try {
                        if (TTVideoLandingPageActivity.this.D != null && !TTVideoLandingPageActivity.this.isFinishing()) {
                            TTVideoLandingPageActivity.this.D.setVisibility(8);
                        }
                    } catch (Throwable unused) {
                    }
                }
            });
            this.a.getSettings().setUserAgentString(com.bytedance.sdk.openadsdk.g.i.a(this.a, this.f));
            if (Build.VERSION.SDK_INT >= 21) {
                this.a.getSettings().setMixedContentMode(0);
            }
            this.a.loadUrl(this.L);
            this.a.setWebChromeClient(new a(this.i, this.O) {
                /* class com.bytedance.sdk.openadsdk.activity.TTVideoLandingPageActivity.AnonymousClass2 */

                @Override // com.bytedance.sdk.openadsdk.activity.a
                public void onProgressChanged(WebView webView, int i) {
                    super.onProgressChanged(webView, i);
                    if (TTVideoLandingPageActivity.this.D != null && !TTVideoLandingPageActivity.this.isFinishing()) {
                        if (i != 100 || !TTVideoLandingPageActivity.this.D.isShown()) {
                            TTVideoLandingPageActivity.this.D.setProgress(i);
                        } else {
                            TTVideoLandingPageActivity.this.D.setVisibility(8);
                        }
                    }
                }
            });
            this.a.setDownloadListener(new DownloadListener() {
                /* class com.bytedance.sdk.openadsdk.activity.TTVideoLandingPageActivity.AnonymousClass3 */

                public void onDownloadStart(String str, String str2, String str3, String str4, long j) {
                    if (TTVideoLandingPageActivity.this.E != null) {
                        TTVideoLandingPageActivity.this.E.a();
                    }
                }
            });
            TextView textView = this.d;
            if (textView != null) {
                if (TextUtils.isEmpty(stringExtra)) {
                    stringExtra = o.a(this, "tt_web_title_default");
                }
                textView.setText(stringExtra);
            }
            a();
            f();
            c();
        }
    }

    private void c() {
        g gVar = this.p;
        if (gVar != null && gVar.g() == 4) {
            this.B.setVisibility(0);
            Button button = (Button) findViewById(o.e(this, "tt_browser_download_btn"));
            this.C = button;
            if (button != null) {
                a(d());
                this.C.setOnClickListener(this.P);
                this.C.setOnTouchListener(this.P);
            }
        }
    }

    private String d() {
        g gVar = this.p;
        if (gVar != null && !TextUtils.isEmpty(gVar.q())) {
            this.v = this.p.q();
        }
        return this.v;
    }

    private void a(final String str) {
        Button button;
        if (!TextUtils.isEmpty(str) && (button = this.C) != null) {
            button.post(new Runnable() {
                /* class com.bytedance.sdk.openadsdk.activity.TTVideoLandingPageActivity.AnonymousClass4 */

                public void run() {
                    if (TTVideoLandingPageActivity.this.C != null && !TTVideoLandingPageActivity.this.isFinishing()) {
                        TTVideoLandingPageActivity.this.C.setText(str);
                    }
                }
            });
        }
    }

    private void e() {
        this.D = (ProgressBar) findViewById(o.e(this, "tt_browser_progress"));
        this.B = (ViewStub) findViewById(o.e(this, "tt_browser_download_btn_stub"));
        this.a = (SSWebView) findViewById(o.e(this, "tt_browser_webview"));
        ImageView imageView = (ImageView) findViewById(o.e(this, "tt_titlebar_back"));
        this.b = imageView;
        if (imageView != null) {
            imageView.setOnClickListener(new View.OnClickListener() {
                /* class com.bytedance.sdk.openadsdk.activity.TTVideoLandingPageActivity.AnonymousClass5 */

                public void onClick(View view) {
                    if (TTVideoLandingPageActivity.this.a == null) {
                        return;
                    }
                    if (TTVideoLandingPageActivity.this.a.canGoBack()) {
                        TTVideoLandingPageActivity.this.a.goBack();
                        return;
                    }
                    TTVideoLandingPageActivity tTVideoLandingPageActivity = TTVideoLandingPageActivity.this;
                    d.a(tTVideoLandingPageActivity, tTVideoLandingPageActivity.p, "embeded_ad", "detail_back", TTVideoLandingPageActivity.this.g(), TTVideoLandingPageActivity.this.h());
                    TTVideoLandingPageActivity.this.finish();
                }
            });
        }
        ImageView imageView2 = (ImageView) findViewById(o.e(this, "tt_titlebar_close"));
        this.c = imageView2;
        if (imageView2 != null) {
            imageView2.setOnClickListener(new View.OnClickListener() {
                /* class com.bytedance.sdk.openadsdk.activity.TTVideoLandingPageActivity.AnonymousClass6 */

                public void onClick(View view) {
                    if (TTVideoLandingPageActivity.this.n != null) {
                        TTVideoLandingPageActivity tTVideoLandingPageActivity = TTVideoLandingPageActivity.this;
                        d.a(tTVideoLandingPageActivity, tTVideoLandingPageActivity.p, "embeded_ad", "detail_skip", TTVideoLandingPageActivity.this.g(), TTVideoLandingPageActivity.this.h());
                    }
                    TTVideoLandingPageActivity.this.finish();
                }
            });
        }
        this.d = (TextView) findViewById(o.e(this, "tt_titlebar_title"));
        this.l = (FrameLayout) findViewById(o.e(this, "tt_native_video_container"));
        this.k = (RelativeLayout) findViewById(o.e(this, "tt_native_video_titlebar"));
        this.w = (RelativeLayout) findViewById(o.e(this, "tt_rl_download"));
        this.x = (TextView) findViewById(o.e(this, "tt_video_btn_ad_image_tv"));
        this.z = (TextView) findViewById(o.e(this, "tt_video_ad_name"));
        this.A = (TextView) findViewById(o.e(this, "tt_video_ad_button"));
        this.y = (RoundImageView) findViewById(o.e(this, "tt_video_ad_logo_image"));
        i();
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        c();
    }

    private void f() {
        if (this.m == 5) {
            try {
                NativeVideoAdView nativeVideoAdView = new NativeVideoAdView(this.e, this.p, true);
                this.n = nativeVideoAdView;
                nativeVideoAdView.setIsInDetail(true);
                if (this.n.getNativeVideoController() != null) {
                    this.n.getNativeVideoController().b(false);
                }
                if (this.I) {
                    this.l.setVisibility(0);
                    this.l.removeAllViews();
                    this.l.addView(this.n);
                    this.n.a(true);
                } else {
                    if (!this.K) {
                        this.o = 0L;
                    }
                    if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
                        if (!(this.N == null || this.n.getNativeVideoController() == null)) {
                            this.n.getNativeVideoController().b(this.N.f);
                            this.n.getNativeVideoController().c(this.N.d);
                        }
                    } else if (!(this.q == null || this.n.getNativeVideoController() == null)) {
                        this.n.getNativeVideoController().b(this.q.i());
                        this.n.getNativeVideoController().c(this.q.l());
                    }
                    if (this.n.a(this.o.longValue(), this.J, this.I)) {
                        this.l.setVisibility(0);
                        this.l.removeAllViews();
                        this.l.addView(this.n);
                    }
                    if (this.n.getNativeVideoController() != null) {
                        this.n.getNativeVideoController().b(false);
                        this.n.getNativeVideoController().a(this.Q);
                        this.n.setIsQuiet(false);
                    }
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            if (m.c(this) == 0) {
                Toast.makeText(this, o.b(this, "tt_no_network"), 0).show();
            }
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private long g() {
        NativeVideoAdView nativeVideoAdView = this.n;
        if (nativeVideoAdView == null || nativeVideoAdView.getNativeVideoController() == null) {
            return 0;
        }
        return this.n.getNativeVideoController().i();
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private int h() {
        NativeVideoAdView nativeVideoAdView = this.n;
        if (nativeVideoAdView == null || nativeVideoAdView.getNativeVideoController() == null) {
            return 0;
        }
        return this.n.getNativeVideoController().k();
    }

    private void i() {
        String str;
        g gVar = this.p;
        if (gVar != null && gVar.g() == 4) {
            u.a(this.w, 0);
            if (!TextUtils.isEmpty(this.p.o())) {
                str = this.p.o();
            } else if (!TextUtils.isEmpty(this.p.p())) {
                str = this.p.p();
            } else {
                str = !TextUtils.isEmpty(this.p.f()) ? this.p.f() : "";
            }
            if (this.p.h() != null && this.p.h().a() != null) {
                u.a(this.y, 0);
                u.a(this.x, 4);
                com.bytedance.sdk.openadsdk.e.b.a(this.e).a(this.p.h().a(), this.y);
            } else if (!TextUtils.isEmpty(str)) {
                u.a(this.y, 4);
                u.a(this.x, 0);
                this.x.setText(str.substring(0, 1));
            }
            if (!TextUtils.isEmpty(str)) {
                this.z.setText(str);
            }
            u.a(this.z, 0);
            u.a(this.A, 0);
        }
    }

    private void j() {
        g gVar = this.p;
        if (gVar != null && gVar.g() == 4) {
            this.E = com.com.bytedance.overseas.sdk.download.c.a(this, this.p, this.H);
            com.bytedance.sdk.openadsdk.core.a.a aVar = new com.bytedance.sdk.openadsdk.core.a.a(this, this.p, this.H, this.j);
            this.P = aVar;
            aVar.a(false);
            this.A.setOnClickListener(this.P);
            this.A.setOnTouchListener(this.P);
            this.P.a(this.E);
        }
    }

    private void k() {
        r rVar = new r(this);
        this.i = rVar;
        rVar.a(this.a).a(this.g).b(this.h).b(this.j).a(this.p).a(this.p.b()).c(t.c(this.p));
    }

    public void onBackPressed() {
        NativeVideoAdView nativeVideoAdView;
        if (!this.G || (nativeVideoAdView = this.n) == null || nativeVideoAdView.getNativeVideoController() == null) {
            super.onBackPressed();
            return;
        }
        ((com.bytedance.sdk.openadsdk.core.video.nativevideo.a) this.n.getNativeVideoController()).e(null, null);
        this.G = false;
    }

    /* access modifiers changed from: protected */
    public void onSaveInstanceState(Bundle bundle) {
        if (bundle == null) {
            bundle = new Bundle();
        }
        bundle.putString("material_meta", this.p.C().toString());
        bundle.putLong("video_play_position", this.o.longValue());
        bundle.putBoolean("is_complete", this.I);
        long longValue = this.o.longValue();
        NativeVideoAdView nativeVideoAdView = this.n;
        if (!(nativeVideoAdView == null || nativeVideoAdView.getNativeVideoController() == null)) {
            longValue = this.n.getNativeVideoController().g();
        }
        bundle.putLong("video_play_position", longValue);
        super.onSaveInstanceState(bundle);
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        this.J = false;
        r rVar = this.i;
        if (rVar != null) {
            rVar.a();
        }
        l();
        i iVar = this.O;
        if (iVar != null) {
            iVar.a();
        }
    }

    private void l() {
        NativeVideoAdView nativeVideoAdView = this.n;
        if (nativeVideoAdView != null && nativeVideoAdView.getNativeVideoController() != null) {
            com.bytedance.sdk.openadsdk.core.video.c.d n2 = this.n.getNativeVideoController().n();
            if (n2 != null && n2.i()) {
                this.n.a(this.o.longValue(), this.J, this.I);
            } else if ((n2 == null && this.R) || (n2 != null && n2.j())) {
                this.R = false;
                this.n.a(this.o.longValue(), this.J, this.I);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        NativeVideoAdView nativeVideoAdView;
        NativeVideoAdView nativeVideoAdView2;
        super.onPause();
        r rVar = this.i;
        if (rVar != null) {
            rVar.b();
        }
        m();
        if (this.I || !((nativeVideoAdView2 = this.n) == null || nativeVideoAdView2.getNativeVideoController() == null || !this.n.getNativeVideoController().p())) {
            this.I = true;
            if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
                com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_multi_native_video_data", "key_video_is_update_flag", (Boolean) true);
                com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_multi_native_video_data", "key_native_video_complete", (Boolean) true);
                com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_multi_native_video_data", "key_video_isfromvideodetailpage", (Boolean) true);
            } else {
                c cVar = this.q;
                if (cVar != null) {
                    cVar.d(true);
                    ((f) this.q).f(true);
                }
            }
        }
        if (!this.I && (nativeVideoAdView = this.n) != null && nativeVideoAdView.getNativeVideoController() != null) {
            if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
                a(this.n.getNativeVideoController());
            } else if (this.q != null) {
                this.o = Long.valueOf(this.n.getNativeVideoController().g());
                this.q.b(this.n.getNativeVideoController().i());
                this.q.c(this.n.getNativeVideoController().l());
                this.q.a(this.o.longValue());
                ((f) this.q).f(true);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onStop() {
        super.onStop();
        i iVar = this.O;
        if (iVar != null) {
            iVar.b();
        }
    }

    private void a(c cVar) {
        l.e("mutilproces", "initFeedNaitiveControllerData-isComplete=" + cVar.p() + ",position=" + cVar.g() + ",totalPlayDuration=" + cVar.i() + ",duration=" + cVar.l());
        com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_multi_native_video_data", "key_video_is_update_flag", (Boolean) true);
        com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_multi_native_video_data", "key_video_isfromvideodetailpage", (Boolean) true);
        com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_multi_native_video_data", "key_native_video_complete", Boolean.valueOf(cVar.p()));
        com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_multi_native_video_data", "key_video_current_play_position", Long.valueOf(cVar.g()));
        com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_multi_native_video_data", "key_video_total_play_duration", Long.valueOf(cVar.i()));
        com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_multi_native_video_data", "key_video_duration", Long.valueOf(cVar.l()));
    }

    private void m() {
        NativeVideoAdView nativeVideoAdView = this.n;
        if (nativeVideoAdView != null) {
            com.bytedance.sdk.openadsdk.core.video.c.d n2 = nativeVideoAdView.getNativeVideoController().n();
            if (n2 != null && n2.h()) {
                this.R = true;
                ((f) this.n.getNativeVideoController()).e(this.n.getNativeVideoController().i());
                this.n.getNativeVideoController().a(false);
            } else if (n2 != null && !n2.l()) {
                ((f) this.n.getNativeVideoController()).e(this.n.getNativeVideoController().i());
                this.n.getNativeVideoController().a(false);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        ViewGroup viewGroup;
        super.onDestroy();
        b();
        try {
            if (!(getWindow() == null || (viewGroup = (ViewGroup) getWindow().getDecorView()) == null)) {
                viewGroup.removeAllViews();
            }
        } catch (Throwable unused) {
        }
        v.a(this.e, this.a);
        v.a(this.a);
        this.a = null;
        Map<String, b> map = this.F;
        if (map != null) {
            map.clear();
        }
        r rVar = this.i;
        if (rVar != null) {
            rVar.c();
        }
        NativeVideoAdView nativeVideoAdView = this.n;
        if (!(nativeVideoAdView == null || nativeVideoAdView.getNativeVideoController() == null)) {
            this.n.getNativeVideoController().f();
        }
        this.q = null;
        this.n = null;
        this.p = null;
        i iVar = this.O;
        if (iVar != null) {
            iVar.c();
        }
    }

    /* access modifiers changed from: protected */
    public void a() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        try {
            this.e.registerReceiver(this.S, intentFilter);
        } catch (Exception unused) {
        }
    }

    /* access modifiers changed from: protected */
    public void b() {
        try {
            this.e.unregisterReceiver(this.S);
        } catch (Exception unused) {
        }
    }
}
