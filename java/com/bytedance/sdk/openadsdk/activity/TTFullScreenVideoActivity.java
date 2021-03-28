package com.bytedance.sdk.openadsdk.activity;

import android.content.Intent;
import android.graphics.PorterDuff;
import android.graphics.drawable.LayerDrawable;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.webkit.DownloadListener;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.bytedance.sdk.openadsdk.TTFullScreenVideoAd;
import com.bytedance.sdk.openadsdk.b.d;
import com.bytedance.sdk.openadsdk.b.i;
import com.bytedance.sdk.openadsdk.core.c;
import com.bytedance.sdk.openadsdk.core.j;
import com.bytedance.sdk.openadsdk.core.m;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.c;
import com.bytedance.sdk.openadsdk.g.l;
import com.bytedance.sdk.openadsdk.g.t;
import com.bytedance.sdk.openadsdk.g.u;
import com.bytedance.sdk.openadsdk.multipro.b;
import com.ironsource.mediationsdk.logger.IronSourceError;
import java.io.File;
import java.util.HashMap;
import org.json.JSONObject;

public class TTFullScreenVideoActivity extends TTBaseVideoActivity {
    private static TTFullScreenVideoAd.FullScreenVideoAdInteractionListener U;
    private TTFullScreenVideoAd.FullScreenVideoAdInteractionListener T;

    /* access modifiers changed from: protected */
    @Override // com.bytedance.sdk.openadsdk.activity.TTBaseVideoActivity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        l();
        c();
        a(bundle);
        a();
        h();
        if (this.p != null) {
            this.L = t.c(this.p.u());
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.bytedance.sdk.openadsdk.activity.TTBaseVideoActivity
    public void onSaveInstanceState(Bundle bundle) {
        if (bundle == null) {
            bundle = new Bundle();
        }
        U = this.T;
        try {
            bundle.putString("material_meta", this.p != null ? this.p.C().toString() : null);
            bundle.putLong("video_current", this.w == null ? this.t : this.w.g());
            bundle.putString("video_cache_url", this.u);
            bundle.putInt("orientation", this.v);
            bundle.putBoolean("is_mute", this.F);
            bundle.putBoolean("has_show_skip_btn", this.P.get());
            bundle.putString("rit_scene", this.S);
        } catch (Exception unused) {
        }
        super.onSaveInstanceState(bundle);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void a(final String str) {
        new Thread(new Runnable() {
            /* class com.bytedance.sdk.openadsdk.activity.TTFullScreenVideoActivity.AnonymousClass1 */

            public void run() {
                try {
                    TTFullScreenVideoActivity.this.a(1).executeFullVideoCallback(str);
                } catch (Throwable th) {
                    l.b("TTFullScreenVideoActivity", "executeFullVideoCallback execute throw Exception : ", th);
                }
            }
        }).start();
    }

    private void l() {
        Intent intent = getIntent();
        if (intent != null) {
            this.s = intent.getBooleanExtra("show_download_bar", true);
            this.u = intent.getStringExtra("video_cache_url");
            this.v = intent.getIntExtra("orientation", 2);
            this.S = intent.getStringExtra("rit_scene");
        }
    }

    private void a(Bundle bundle) {
        String str;
        StringBuilder sb;
        String stringExtra;
        if (b.b()) {
            Intent intent = getIntent();
            if (!(intent == null || (stringExtra = intent.getStringExtra(TTAdConstant.MULTI_PROCESS_MATERIALMETA)) == null)) {
                try {
                    this.p = c.b(new JSONObject(stringExtra));
                } catch (Exception e) {
                    l.b("TTFullScreenVideoActivity", "initData MultiGlobalInfo throws ", e);
                }
            }
        } else {
            this.p = o.a().d();
            this.T = o.a().f();
            o.a().h();
        }
        String str2 = null;
        if (bundle != null) {
            if (this.T == null) {
                this.T = U;
                U = null;
            }
            try {
                String string = bundle.getString("material_meta");
                this.u = bundle.getString("video_cache_url");
                this.v = bundle.getInt("orientation", 2);
                this.F = bundle.getBoolean("is_mute");
                this.S = bundle.getString("rit_scene");
                this.p = c.b(new JSONObject(string));
                this.P.set(bundle.getBoolean("has_show_skip_btn"));
                if (this.P.get()) {
                    this.f.setVisibility(0);
                    this.f.setText(a);
                    this.f.setClickable(true);
                }
            } catch (Throwable unused) {
            }
        }
        if (this.p == null) {
            l.e("TTFullScreenVideoActivity", "mMaterialMeta is null , no data to display ,the TTFullScreenVideoActivity finished !!");
            finish();
            return;
        }
        if (this.p.g() == 4) {
            this.x = com.com.bytedance.overseas.sdk.download.c.a(this.c, this.p, "fullscreen_interstitial_ad");
        }
        this.L = t.c(this.p.u());
        this.F = j.e().b(this.L);
        this.J = this.p.v();
        if (this.p.s() != null) {
            this.H = this.p.s().d();
            this.I = this.p.s().e();
        }
        this.A = this.p.r();
        this.B = this.p.u();
        this.G = (int) this.p.e().d();
        this.C = 5;
        e();
        if (this.p.e() != null) {
            str2 = this.p.e().h();
        }
        this.E = str2;
        Log.d("mEndCardUrl", "mEndCardUrl=" + this.E);
        if (this.J == 15) {
            this.E += "&orientation=portrait";
        }
        if (this.p.h() == null || TextUtils.isEmpty(this.p.h().a())) {
            this.h.setImageResource(com.bytedance.sdk.openadsdk.g.o.d(this, "tt_ad_logo_small"));
        } else {
            com.bytedance.sdk.openadsdk.e.b.a(this.c).a(this.p.h().a(), this.h);
        }
        if (this.J != 15 || this.p.s() == null || TextUtils.isEmpty(this.p.s().b())) {
            this.i.setText(this.p.o());
        } else {
            this.i.setText(this.p.s().b());
        }
        this.l.setText(i());
        LayerDrawable layerDrawable = (LayerDrawable) this.n.getProgressDrawable();
        if (layerDrawable.getDrawable(2) != null) {
            layerDrawable.getDrawable(2).setColorFilter(com.bytedance.sdk.openadsdk.g.o.i(this, "tt_rating_star"), PorterDuff.Mode.SRC_ATOP);
        }
        this.n.setRating((float) this.H);
        String a = com.bytedance.sdk.openadsdk.g.o.a(this, "tt_comment_num");
        if (this.I > 10000) {
            sb = new StringBuilder();
            sb.append(this.I / 10000);
            str = "万";
        } else {
            sb = new StringBuilder();
            sb.append(this.I);
            str = "";
        }
        sb.append(str);
        String format = String.format(a, sb.toString());
        this.o.setText(format);
        this.j.setText(format);
        this.D = 2150;
        m.a(this.c).a(false).b(false).a(this.d);
        this.q = new i(this, this.p, this.d);
        this.d.setWebViewClient(new b(this.c, this.y, this.A, this.q));
        this.d.getSettings().setUserAgentString(com.bytedance.sdk.openadsdk.g.i.a(this.d, this.D));
        if (Build.VERSION.SDK_INT >= 21) {
            this.d.getSettings().setMixedContentMode(0);
        }
        this.d.loadUrl(this.E);
        this.d.setWebChromeClient(new a(this.y, this.q));
        this.d.setDownloadListener(new DownloadListener() {
            /* class com.bytedance.sdk.openadsdk.activity.TTFullScreenVideoActivity.AnonymousClass2 */

            public void onDownloadStart(String str, String str2, String str3, String str4, long j) {
                if (TTFullScreenVideoActivity.this.x != null) {
                    TTFullScreenVideoActivity.this.x.a();
                }
                TTFullScreenVideoActivity.this.k();
            }
        });
        this.e.setOnClickListener(new View.OnClickListener() {
            /* class com.bytedance.sdk.openadsdk.activity.TTFullScreenVideoActivity.AnonymousClass3 */

            public void onClick(View view) {
                if (b.b()) {
                    TTFullScreenVideoActivity.this.a((TTFullScreenVideoActivity) "onAdClose");
                } else if (TTFullScreenVideoActivity.this.T != null) {
                    TTFullScreenVideoActivity.this.T.onAdClose();
                }
                TTFullScreenVideoActivity.this.o();
                TTFullScreenVideoActivity.this.finish();
            }
        });
        this.g.setOnClickListener(new View.OnClickListener() {
            /* class com.bytedance.sdk.openadsdk.activity.TTFullScreenVideoActivity.AnonymousClass4 */

            public void onClick(View view) {
                int i;
                if (TTFullScreenVideoActivity.this.F) {
                    i = com.bytedance.sdk.openadsdk.g.o.d(TTFullScreenVideoActivity.this, "tt_unmute");
                } else {
                    i = com.bytedance.sdk.openadsdk.g.o.d(TTFullScreenVideoActivity.this, "tt_mute");
                }
                TTFullScreenVideoActivity.this.g.setImageResource(i);
                TTFullScreenVideoActivity tTFullScreenVideoActivity = TTFullScreenVideoActivity.this;
                tTFullScreenVideoActivity.F = !tTFullScreenVideoActivity.F;
                TTFullScreenVideoActivity.this.w.c(TTFullScreenVideoActivity.this.F);
            }
        });
        this.f.setOnClickListener(new View.OnClickListener() {
            /* class com.bytedance.sdk.openadsdk.activity.TTFullScreenVideoActivity.AnonymousClass5 */

            public void onClick(View view) {
                TTFullScreenVideoActivity.this.p();
                if (b.b()) {
                    TTFullScreenVideoActivity.this.a((TTFullScreenVideoActivity) "onSkippedVideo");
                } else if (TTFullScreenVideoActivity.this.T != null) {
                    TTFullScreenVideoActivity.this.T.onSkippedVideo();
                }
                if (TTFullScreenVideoActivity.this.n()) {
                    TTFullScreenVideoActivity.this.m();
                } else {
                    TTFullScreenVideoActivity.this.finish();
                }
            }
        });
        boolean a2 = a(this.t, false);
        this.N.set(true);
        if (!a2) {
            f();
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void m() {
        this.f.setVisibility(8);
        if (!this.M.getAndSet(true)) {
            if (Build.VERSION.SDK_INT >= 11) {
                this.d.setAlpha(0.0f);
                this.e.setAlpha(0.0f);
            }
            this.Q.set(true);
            this.d.setVisibility(0);
            this.e.setVisibility(0);
            this.z.sendEmptyMessageDelayed(500, 100);
            a(this.F, true);
            j();
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private boolean n() {
        return j.e().b(String.valueOf(this.L)) == 2;
    }

    /* access modifiers changed from: protected */
    @Override // com.bytedance.sdk.openadsdk.activity.TTBaseVideoActivity
    public boolean a(long j, boolean z) {
        HashMap hashMap;
        if (this.w == null) {
            this.w = new com.bytedance.sdk.openadsdk.core.video.b.b(this.c, this.m, this.p);
        }
        String str = null;
        if (!TextUtils.isEmpty(this.S)) {
            hashMap = new HashMap();
            hashMap.put("rit_scene", this.S);
        } else {
            hashMap = null;
        }
        this.w.a(hashMap);
        this.w.a(new c.a() {
            /* class com.bytedance.sdk.openadsdk.activity.TTFullScreenVideoActivity.AnonymousClass6 */

            @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c.a
            public void a(long j, int i) {
                if (b.b()) {
                    TTFullScreenVideoActivity.this.a((TTFullScreenVideoActivity) "onVideoComplete");
                } else if (TTFullScreenVideoActivity.this.T != null) {
                    TTFullScreenVideoActivity.this.T.onVideoComplete();
                }
                l.b("TTFullScreenVideoActivity", "onComplete、、、、、、、、");
                if (TTFullScreenVideoActivity.this.n()) {
                    TTFullScreenVideoActivity.this.f();
                } else {
                    TTFullScreenVideoActivity.this.finish();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c.a
            public void b(long j, int i) {
                if (!TTFullScreenVideoActivity.this.g()) {
                    if (TTFullScreenVideoActivity.this.w != null) {
                        TTFullScreenVideoActivity.this.w.f();
                    }
                    l.e("TTFullScreenVideoActivity", "onError、、、、、、、、");
                    if (TTFullScreenVideoActivity.this.n()) {
                        TTFullScreenVideoActivity.this.f();
                    } else {
                        TTFullScreenVideoActivity.this.finish();
                    }
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c.a
            public void a() {
                l.b("TTFullScreenVideoActivity", "onTimeOut、、、、、、、、");
                if (TTFullScreenVideoActivity.this.n()) {
                    TTFullScreenVideoActivity.this.f();
                } else {
                    TTFullScreenVideoActivity.this.finish();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c.a
            public void a(long j, long j2) {
                TTFullScreenVideoActivity tTFullScreenVideoActivity = TTFullScreenVideoActivity.this;
                double d = tTFullScreenVideoActivity.p.e().d();
                double d2 = (double) (j / 1000);
                Double.isNaN(d2);
                tTFullScreenVideoActivity.G = (int) (d - d2);
                if (TTFullScreenVideoActivity.this.G >= 0) {
                    u.a(TTFullScreenVideoActivity.this.k, 0);
                    TTFullScreenVideoActivity.this.k.setText(String.valueOf(TTFullScreenVideoActivity.this.G));
                }
                if (TTFullScreenVideoActivity.this.G == 0) {
                    l.b("TTFullScreenVideoActivity", "onProgressUpdate、、、、、、、、");
                    if (TTFullScreenVideoActivity.this.n()) {
                        TTFullScreenVideoActivity.this.f();
                    } else {
                        TTFullScreenVideoActivity.this.finish();
                    }
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c.a
            public void b() {
                for (int i = 0; i <= 6; i++) {
                    TTFullScreenVideoActivity.this.z.sendMessageDelayed(TTFullScreenVideoActivity.this.z.obtainMessage(IronSourceError.ERROR_CODE_USING_CACHED_CONFIGURATION, i, 0), (long) (i * 1000));
                }
            }
        });
        if (this.p.e() != null) {
            str = this.p.e().g();
        }
        if (this.u != null) {
            File file = new File(this.u);
            if (file.exists() && file.length() > 0) {
                str = this.u;
            }
        }
        l.e("wzj", "videoUrl:" + str);
        boolean a = this.w.a(str, this.p.r(), this.m.getWidth(), this.m.getHeight(), null, this.p.u(), j, this.F);
        if (a && !z) {
            d.a(this.c, this.p, "fullscreen_interstitial_ad", hashMap);
            if (b.b()) {
                a("onAdShow");
            } else {
                TTFullScreenVideoAd.FullScreenVideoAdInteractionListener fullScreenVideoAdInteractionListener = this.T;
                if (fullScreenVideoAdInteractionListener != null) {
                    fullScreenVideoAdInteractionListener.onAdShow();
                }
            }
        }
        return a;
    }

    /* access modifiers changed from: protected */
    @Override // com.bytedance.sdk.openadsdk.activity.TTBaseVideoActivity
    public void a(View view, int i, int i2, int i3, int i4) {
        if (b.b()) {
            a("onAdVideoBarClick");
            return;
        }
        TTFullScreenVideoAd.FullScreenVideoAdInteractionListener fullScreenVideoAdInteractionListener = this.T;
        if (fullScreenVideoAdInteractionListener != null) {
            fullScreenVideoAdInteractionListener.onAdVideoBarClick();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.activity.TTBaseVideoActivity
    public void k() {
        if (b.b()) {
            a("onAdVideoBarClick");
            return;
        }
        TTFullScreenVideoAd.FullScreenVideoAdInteractionListener fullScreenVideoAdInteractionListener = this.T;
        if (fullScreenVideoAdInteractionListener != null) {
            fullScreenVideoAdInteractionListener.onAdVideoBarClick();
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.bytedance.sdk.openadsdk.activity.TTBaseVideoActivity
    public void onDestroy() {
        super.onDestroy();
        if (b.b()) {
            a("recycleRes");
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void o() {
        d.a(this.c, this.p, "fullscreen_interstitial_ad", "click_close");
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void p() {
        if (this.w != null) {
            d.a(this.c, this.p, "fullscreen_interstitial_ad", "feed_break", this.w.i(), this.w.k(), t.a(this.p, this.w.h(), this.w.n()));
        }
    }
}
