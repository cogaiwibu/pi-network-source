package com.bytedance.sdk.openadsdk.activity;

import android.content.Intent;
import android.graphics.PorterDuff;
import android.graphics.drawable.LayerDrawable;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.webkit.DownloadListener;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.bytedance.sdk.openadsdk.TTRewardVideoAd;
import com.bytedance.sdk.openadsdk.b.i;
import com.bytedance.sdk.openadsdk.core.c;
import com.bytedance.sdk.openadsdk.core.j;
import com.bytedance.sdk.openadsdk.core.k;
import com.bytedance.sdk.openadsdk.core.l;
import com.bytedance.sdk.openadsdk.core.m;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.core.video.b.d;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.c;
import com.bytedance.sdk.openadsdk.g.l;
import com.bytedance.sdk.openadsdk.g.t;
import com.bytedance.sdk.openadsdk.g.u;
import com.bytedance.sdk.openadsdk.multipro.b;
import com.facebook.AccessToken;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import java.io.File;
import java.util.HashMap;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

public class TTRewardVideoActivity extends TTBaseVideoActivity {
    private static TTRewardVideoAd.RewardAdInteractionListener ab;
    private k T;
    private String U;
    private int V;
    private String W;
    private String X;
    private int Y;
    private int Z;
    private TTRewardVideoAd.RewardAdInteractionListener aa;
    private AtomicBoolean ac = new AtomicBoolean(false);

    /* access modifiers changed from: protected */
    @Override // com.bytedance.sdk.openadsdk.activity.TTBaseVideoActivity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        l();
        c();
        a(bundle);
        a();
        h();
    }

    /* access modifiers changed from: protected */
    @Override // com.bytedance.sdk.openadsdk.activity.TTBaseVideoActivity
    public void onSaveInstanceState(Bundle bundle) {
        if (bundle == null) {
            bundle = new Bundle();
        }
        ab = this.aa;
        try {
            bundle.putString("material_meta", this.p != null ? this.p.C().toString() : null);
            bundle.putLong("video_current", this.w == null ? this.t : this.w.g());
            bundle.putString("video_cache_url", this.u);
            bundle.putInt("orientation", this.v);
            bundle.putBoolean("is_mute", this.F);
            bundle.putString("rit_scene", this.S);
        } catch (Throwable unused) {
        }
        super.onSaveInstanceState(bundle);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void a(String str) {
        a(str, false, 0, "");
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void a(final String str, final boolean z, final int i, final String str2) {
        new Thread(new Runnable() {
            /* class com.bytedance.sdk.openadsdk.activity.TTRewardVideoActivity.AnonymousClass1 */

            public void run() {
                try {
                    TTRewardVideoActivity.this.a(0).executeRewardVideoCallback(str, z, i, str2);
                } catch (Throwable th) {
                    l.b("TTRewardVideoActivity", "executeRewardVideoCallback execute throw Exception : ", th);
                }
            }
        }).start();
    }

    private void a(Bundle bundle) {
        String str;
        StringBuilder sb;
        String stringExtra;
        this.T = j.c();
        if (b.b()) {
            Intent intent = getIntent();
            if (!(intent == null || (stringExtra = intent.getStringExtra(TTAdConstant.MULTI_PROCESS_MATERIALMETA)) == null)) {
                try {
                    this.p = c.b(new JSONObject(stringExtra));
                } catch (Exception e) {
                    l.b("TTRewardVideoActivity", "TTRewardVideoActivity MultiGlobalInfo throw ", e);
                }
            }
        } else {
            this.p = o.a().d();
            this.aa = o.a().e();
            o.a().h();
        }
        if (bundle != null) {
            if (this.aa == null) {
                this.aa = ab;
                ab = null;
            }
            try {
                String string = bundle.getString("material_meta");
                this.u = bundle.getString("video_cache_url");
                this.v = bundle.getInt("orientation", 2);
                this.F = bundle.getBoolean("is_mute");
                this.S = bundle.getString("rit_scene");
                this.p = c.b(new JSONObject(string));
            } catch (Throwable unused) {
            }
        }
        if (this.p == null) {
            l.e("TTRewardVideoActivity", "mMaterialMeta is null , no data to display ,the TTRewardVideoActivity finished !!");
            finish();
            return;
        }
        if (this.p.g() == 4) {
            this.x = com.com.bytedance.overseas.sdk.download.c.a(this.c, this.p, "embeded_ad");
        }
        this.L = t.c(this.p.u());
        this.F = j.e().b(this.L);
        b();
        this.J = this.p.v();
        if (this.p.s() != null) {
            this.H = this.p.s().d();
            this.I = this.p.s().e();
        }
        this.A = this.p.r();
        this.B = this.p.u();
        this.G = (int) this.p.e().d();
        this.C = 7;
        e();
        this.E = this.p.e() != null ? this.p.e().h() : null;
        if (this.J == 15 && !TextUtils.isEmpty(this.E)) {
            if (this.E.contains("?")) {
                this.E += "&orientation=portrait";
            } else {
                this.E += "?orientation=portrait";
            }
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
        this.d.setLayerType(1, null);
        this.d.setBackgroundColor(-1);
        this.d.getSettings().setDisplayZoomControls(false);
        this.d.setWebChromeClient(new a(this.y, this.q));
        this.d.setDownloadListener(new DownloadListener() {
            /* class com.bytedance.sdk.openadsdk.activity.TTRewardVideoActivity.AnonymousClass2 */

            public void onDownloadStart(String str, String str2, String str3, String str4, long j) {
                if (TTRewardVideoActivity.this.x != null) {
                    TTRewardVideoActivity.this.x.a();
                }
                TTRewardVideoActivity.this.k();
            }
        });
        this.e.setOnClickListener(new View.OnClickListener() {
            /* class com.bytedance.sdk.openadsdk.activity.TTRewardVideoActivity.AnonymousClass3 */

            public void onClick(View view) {
                if (b.b()) {
                    TTRewardVideoActivity.this.a((TTRewardVideoActivity) "onAdClose");
                } else if (TTRewardVideoActivity.this.aa != null) {
                    TTRewardVideoActivity.this.aa.onAdClose();
                }
                TTRewardVideoActivity.this.o();
                TTRewardVideoActivity.this.finish();
            }
        });
        this.g.setOnClickListener(new View.OnClickListener() {
            /* class com.bytedance.sdk.openadsdk.activity.TTRewardVideoActivity.AnonymousClass4 */

            public void onClick(View view) {
                int i;
                if (TTRewardVideoActivity.this.F) {
                    i = com.bytedance.sdk.openadsdk.g.o.d(TTRewardVideoActivity.this, "tt_unmute");
                } else {
                    i = com.bytedance.sdk.openadsdk.g.o.d(TTRewardVideoActivity.this, "tt_mute");
                }
                TTRewardVideoActivity.this.g.setImageResource(i);
                TTRewardVideoActivity tTRewardVideoActivity = TTRewardVideoActivity.this;
                tTRewardVideoActivity.F = !tTRewardVideoActivity.F;
                TTRewardVideoActivity.this.w.c(TTRewardVideoActivity.this.F);
            }
        });
        boolean a2 = a(this.t, false);
        this.N.set(true);
        if (!a2) {
            f();
        }
    }

    private void l() {
        Intent intent = getIntent();
        if (intent != null) {
            this.U = intent.getStringExtra("reward_name");
            this.V = intent.getIntExtra("reward_amount", 0);
            this.W = intent.getStringExtra("media_extra");
            this.X = intent.getStringExtra(AccessToken.USER_ID_KEY);
            this.s = intent.getBooleanExtra("show_download_bar", true);
            this.u = intent.getStringExtra("video_cache_url");
            this.v = intent.getIntExtra("orientation", 2);
            this.S = intent.getStringExtra("rit_scene");
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.bytedance.sdk.openadsdk.activity.TTBaseVideoActivity
    public boolean a(long j, boolean z) {
        HashMap hashMap;
        if (this.w == null) {
            this.w = new d(this.c, this.m, this.p);
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
            /* class com.bytedance.sdk.openadsdk.activity.TTRewardVideoActivity.AnonymousClass5 */

            @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c.a
            public void a(long j, int i) {
                if (b.b()) {
                    TTRewardVideoActivity.this.a((TTRewardVideoActivity) "onVideoComplete");
                } else if (TTRewardVideoActivity.this.aa != null) {
                    TTRewardVideoActivity.this.aa.onVideoComplete();
                }
                TTRewardVideoActivity.this.f();
                TTRewardVideoActivity.this.Z = (int) (System.currentTimeMillis() / 1000);
                TTRewardVideoActivity.this.m();
            }

            @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c.a
            public void b(long j, int i) {
                if (b.b()) {
                    TTRewardVideoActivity.this.a((TTRewardVideoActivity) "onVideoError");
                } else if (TTRewardVideoActivity.this.aa != null) {
                    TTRewardVideoActivity.this.aa.onVideoError();
                }
                if (!TTRewardVideoActivity.this.g()) {
                    if (TTRewardVideoActivity.this.w != null) {
                        TTRewardVideoActivity.this.w.f();
                    }
                    TTRewardVideoActivity.this.f();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c.a
            public void a() {
                TTRewardVideoActivity.this.f();
                if (TTRewardVideoActivity.this.w != null) {
                    TTRewardVideoActivity.this.w.f();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c.a
            public void a(long j, long j2) {
                int i = j.e().e(String.valueOf(TTRewardVideoActivity.this.L)).g;
                if (j2 > 0 && ((float) (100 * j)) / Float.valueOf((float) j2).floatValue() >= ((float) i)) {
                    TTRewardVideoActivity.this.m();
                }
                TTRewardVideoActivity tTRewardVideoActivity = TTRewardVideoActivity.this;
                double d = tTRewardVideoActivity.p.e().d();
                double d2 = (double) (j / 1000);
                Double.isNaN(d2);
                tTRewardVideoActivity.G = (int) (d - d2);
                if (TTRewardVideoActivity.this.G >= 0) {
                    u.a(TTRewardVideoActivity.this.k, 0);
                    TTRewardVideoActivity.this.k.setText(String.valueOf(TTRewardVideoActivity.this.G));
                }
                if (TTRewardVideoActivity.this.G == 0) {
                    TTRewardVideoActivity.this.f();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c.a
            public void b() {
                l.c("wzj", "onVideoStartPlay......");
                if (TTRewardVideoActivity.this.K != -1 && !TTRewardVideoActivity.this.O.get()) {
                    TTRewardVideoActivity.this.z.sendEmptyMessageDelayed(IronSourceError.ERROR_CODE_NO_CONFIGURATION_AVAILABLE, (long) (TTRewardVideoActivity.this.K * 1000));
                }
            }
        });
        if (this.p.e() != null) {
            str = this.p.e().g();
        }
        l.e("wzj", "mVideoCacheUrl:" + this.u);
        if (this.u != null) {
            File file = new File(this.u);
            if (file.exists() && file.length() > 0) {
                str = this.u;
            }
        }
        l.e("wzj", "videoUrl:" + str);
        boolean a = this.w.a(str, this.p.r(), this.m.getWidth(), this.m.getHeight(), null, this.p.u(), j, this.F);
        if (a && !z) {
            com.bytedance.sdk.openadsdk.b.d.a(this.c, this.p, "rewarded_video", hashMap);
            if (b.b()) {
                a("onAdShow");
            } else {
                TTRewardVideoAd.RewardAdInteractionListener rewardAdInteractionListener = this.aa;
                if (rewardAdInteractionListener != null) {
                    rewardAdInteractionListener.onAdShow();
                }
            }
            this.Y = (int) (System.currentTimeMillis() / 1000);
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
        TTRewardVideoAd.RewardAdInteractionListener rewardAdInteractionListener = this.aa;
        if (rewardAdInteractionListener != null) {
            rewardAdInteractionListener.onAdVideoBarClick();
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void m() {
        if (!this.ac.get()) {
            this.ac.set(true);
            this.T.a(n(), new k.b() {
                /* class com.bytedance.sdk.openadsdk.activity.TTRewardVideoActivity.AnonymousClass6 */

                @Override // com.bytedance.sdk.openadsdk.core.k.b
                public void a(int i, String str) {
                    if (b.b()) {
                        TTRewardVideoActivity.this.a("onRewardVerify", false, 0, "");
                    } else if (TTRewardVideoActivity.this.aa != null) {
                        TTRewardVideoActivity.this.aa.onRewardVerify(false, 0, "");
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.core.k.b
                public void a(l.b bVar) {
                    int a2 = bVar.c.a();
                    String b = bVar.c.b();
                    if (b.b()) {
                        TTRewardVideoActivity.this.a("onRewardVerify", bVar.b, a2, b);
                    } else if (TTRewardVideoActivity.this.aa != null) {
                        TTRewardVideoActivity.this.aa.onRewardVerify(bVar.b, a2, b);
                    }
                }
            });
        }
    }

    private JSONObject n() {
        JSONObject jSONObject = new JSONObject();
        int l = (int) this.w.l();
        try {
            jSONObject.put("oversea_version_type", 1);
            jSONObject.put("reward_name", this.U);
            jSONObject.put("reward_amount", this.V);
            jSONObject.put("network", com.bytedance.sdk.openadsdk.g.m.c(this.c));
            jSONObject.put("sdk_version", "2.1.5.0");
            int b = this.p.b();
            String str = "unKnow";
            if (b == 2) {
                str = t.b();
            } else if (b == 1) {
                str = t.c();
            }
            jSONObject.put("user_agent", str);
            jSONObject.put("extra", new JSONObject(this.B));
            jSONObject.put("media_extra", this.W);
            jSONObject.put("video_duration", this.p.e().d());
            jSONObject.put("play_start_ts", this.Y);
            jSONObject.put("play_end_ts", this.Z);
            jSONObject.put(IronSourceConstants.EVENTS_DURATION, l);
            jSONObject.put(AccessToken.USER_ID_KEY, this.X);
            jSONObject.put("trans_id", UUID.randomUUID().toString().replace("-", ""));
            return jSONObject;
        } catch (Throwable unused) {
            return null;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.activity.TTBaseVideoActivity
    public void k() {
        if (b.b()) {
            a("onAdVideoBarClick");
            return;
        }
        TTRewardVideoAd.RewardAdInteractionListener rewardAdInteractionListener = this.aa;
        if (rewardAdInteractionListener != null) {
            rewardAdInteractionListener.onAdVideoBarClick();
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
        com.bytedance.sdk.openadsdk.b.d.a(this.c, this.p, "rewarded_video", "click_close");
    }
}
