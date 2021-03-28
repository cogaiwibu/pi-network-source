package com.bytedance.sdk.openadsdk.activity;

import android.animation.Keyframe;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bytedance.sdk.openadsdk.IListenerManager;
import com.bytedance.sdk.openadsdk.b.i;
import com.bytedance.sdk.openadsdk.core.a.d;
import com.bytedance.sdk.openadsdk.core.c.g;
import com.bytedance.sdk.openadsdk.core.j;
import com.bytedance.sdk.openadsdk.core.r;
import com.bytedance.sdk.openadsdk.core.video.b.a;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.c;
import com.bytedance.sdk.openadsdk.g.l;
import com.bytedance.sdk.openadsdk.g.o;
import com.bytedance.sdk.openadsdk.g.t;
import com.bytedance.sdk.openadsdk.g.u;
import com.bytedance.sdk.openadsdk.g.v;
import com.com.bytedance.overseas.sdk.download.b;
import com.facebook.react.uimanager.ViewProps;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class TTBaseVideoActivity extends Activity implements v.a {
    static String a = "skip";
    String A;
    String B;
    int C;
    int D;
    String E;
    boolean F = false;
    int G;
    int H = 4;
    int I = 6870;
    int J = 5;
    int K = 3;
    int L;
    final AtomicBoolean M = new AtomicBoolean(false);
    final AtomicBoolean N = new AtomicBoolean(false);
    final AtomicBoolean O = new AtomicBoolean(false);
    final AtomicBoolean P = new AtomicBoolean(false);
    final AtomicBoolean Q = new AtomicBoolean(false);
    protected IListenerManager R;
    protected String S;
    private d T;
    private boolean U;
    private final String V = Build.MODEL;
    private boolean W = false;
    RelativeLayout b;
    Context c;
    SSWebView d;
    ImageView e;
    TextView f;
    ImageView g;
    ImageView h;
    TextView i;
    TextView j;
    TextView k;
    TextView l;
    FrameLayout m;
    RatingBar n;
    TextView o;
    g p;
    i q;
    TextView r;
    boolean s = true;
    long t;
    String u;
    int v;
    c w;
    b x;
    r y;
    final v z = new v(Looper.getMainLooper(), this);

    /* access modifiers changed from: protected */
    public abstract void a(View view, int i2, int i3, int i4, int i5);

    /* access modifiers changed from: protected */
    public abstract boolean a(long j2, boolean z2);

    public abstract void k();

    public void onBackPressed() {
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        if (bundle != null) {
            this.U = bundle.getBoolean("is_bar_click_first");
        }
        super.onCreate(bundle);
        if (com.bytedance.sdk.openadsdk.core.g.b().m()) {
            getWindow().addFlags(2621440);
        }
        try {
            requestWindowFeature(1);
            getWindow().addFlags(1024);
            getWindow().addFlags(16777216);
        } catch (Throwable unused) {
        }
        a = o.a(this, "tt_txt_skip");
        if (bundle != null && bundle.getLong("video_current") > 0) {
            this.t = bundle.getLong("video_current", 0);
        }
        setContentView(o.f(this, "tt_activity_rewardvideo"));
        this.c = this;
    }

    /* access modifiers changed from: package-private */
    public void a() {
        if (this.J == 15) {
            this.j.setVisibility(0);
            this.o.setVisibility(8);
            this.i.setMaxWidth((int) u.a(this, 120.0f));
        } else {
            this.j.setVisibility(8);
            this.o.setVisibility(0);
        }
        if (this instanceof TTFullScreenVideoActivity) {
            this.b.setVisibility(0);
        }
    }

    /* access modifiers changed from: package-private */
    public void b() {
        int a2 = this.p.a();
        this.K = a2;
        if (a2 == -200) {
            com.bytedance.sdk.openadsdk.core.e.d e2 = j.e();
            this.K = e2.c(this.L + "");
        }
        if (this.K == -1 && this.s) {
            this.b.setVisibility(0);
        }
    }

    /* access modifiers changed from: package-private */
    public void c() {
        int i2;
        this.m = (FrameLayout) findViewById(o.e(this, "tt_video_reward_container"));
        this.d = (SSWebView) findViewById(o.e(this, "tt_reward_browser_webview"));
        this.e = (ImageView) findViewById(o.e(this, "tt_video_ad_close"));
        this.f = (TextView) findViewById(o.e(this, "tt_video_skip_ad_btn"));
        this.g = (ImageView) findViewById(o.e(this, "tt_video_ad_mute"));
        this.k = (TextView) findViewById(o.e(this, "tt_reward_ad_countdown"));
        this.l = (TextView) findViewById(o.e(this, "tt_reward_ad_download"));
        this.b = (RelativeLayout) findViewById(o.e(this, "tt_video_reward_bar"));
        this.h = (ImageView) findViewById(o.e(this, "tt_reward_ad_icon"));
        this.i = (TextView) findViewById(o.e(this, "tt_reward_ad_appname"));
        this.j = (TextView) findViewById(o.e(this, "tt_comment_vertical"));
        this.n = (RatingBar) findViewById(o.e(this, "tt_rb_score"));
        this.o = (TextView) findViewById(o.e(this, "tt_tv_comment_num"));
        this.r = (TextView) findViewById(o.e(this, "tt_ad_logo"));
        if (!this.s) {
            this.b.setVisibility(4);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.g.getLayoutParams();
            layoutParams.gravity = 8388693;
            layoutParams.bottomMargin = (int) u.a(this.c, 24.0f);
            this.g.setLayoutParams(layoutParams);
        }
        if (this.F) {
            i2 = o.d(this, "tt_mute");
        } else {
            i2 = o.d(this, "tt_unmute");
        }
        this.g.setImageResource(i2);
    }

    /* access modifiers changed from: protected */
    public void d() {
        if (this.b != null) {
            Keyframe ofFloat = Keyframe.ofFloat(0.0f, 0.0f);
            Keyframe ofFloat2 = Keyframe.ofFloat(0.65f, 1.0f);
            Keyframe ofFloat3 = Keyframe.ofFloat(0.765f, 0.9f);
            Keyframe ofFloat4 = Keyframe.ofFloat(0.88f, 1.0f);
            Keyframe ofFloat5 = Keyframe.ofFloat(0.95f, 0.95f);
            Keyframe ofFloat6 = Keyframe.ofFloat(1.0f, 1.0f);
            PropertyValuesHolder ofKeyframe = PropertyValuesHolder.ofKeyframe(ViewProps.SCALE_X, ofFloat, ofFloat2, ofFloat3, ofFloat4, ofFloat5, ofFloat6);
            PropertyValuesHolder ofKeyframe2 = PropertyValuesHolder.ofKeyframe(ViewProps.SCALE_Y, ofFloat, ofFloat2, ofFloat3, ofFloat4, ofFloat5, ofFloat6);
            ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this.b, ofKeyframe, ofKeyframe2);
            ofPropertyValuesHolder.setDuration(1000L);
            ofPropertyValuesHolder.start();
        }
    }

    /* access modifiers changed from: package-private */
    public void e() {
        HashMap hashMap = new HashMap();
        if (!TextUtils.isEmpty(this.S)) {
            hashMap.put("rit_scene", this.S);
        }
        r rVar = new r(this.c);
        this.y = rVar;
        rVar.a(this.d).a(this.p).a(this.A).b(this.B).b(this.C).a(this.p.b()).c(t.c(this.p)).a(hashMap);
    }

    /* access modifiers changed from: package-private */
    public void f() {
        this.f.setVisibility(8);
        if (!this.M.getAndSet(true)) {
            j();
            this.d.setAlpha(0.0f);
            this.e.setAlpha(0.0f);
            this.d.setVisibility(0);
            this.e.setVisibility(0);
            this.z.sendEmptyMessageDelayed(500, 20);
            a(this.F, true);
        }
    }

    /* access modifiers changed from: protected */
    public void a(boolean z2, boolean z3) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("endcard_mute", z2);
            jSONObject.put("endcard_show", z3);
            this.y.a("endcard_control_event", jSONObject);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* access modifiers changed from: package-private */
    public boolean g() {
        c cVar = this.w;
        return (cVar == null || cVar.n() == null || !this.w.n().g()) ? false : true;
    }

    private boolean l() {
        c cVar = this.w;
        return (cVar == null || cVar.n() == null || !this.w.n().i()) ? false : true;
    }

    /* access modifiers changed from: package-private */
    public void h() {
        if (this.p != null) {
            boolean z2 = this instanceof TTRewardVideoActivity;
            this.T = new d(this, this.p, z2 ? "rewarded_video" : "fullscreen_interstitial_ad", this.C) {
                /* class com.bytedance.sdk.openadsdk.activity.TTBaseVideoActivity.AnonymousClass1 */

                @Override // com.bytedance.sdk.openadsdk.core.a.d
                public void a(View view, int i, int i2, int i3, int i4) {
                    JSONObject jSONObject;
                    TTBaseVideoActivity.this.a(view, i, i2, i3, i4);
                    int i5 = 0;
                    TTBaseVideoActivity.this.U = view.getId() == o.e(TTBaseVideoActivity.this, "tt_video_reward_bar");
                    TTBaseVideoActivity tTBaseVideoActivity = TTBaseVideoActivity.this;
                    JSONObject jSONObject2 = null;
                    String str = "click_start_play_bar";
                    if (tTBaseVideoActivity instanceof TTRewardVideoActivity) {
                        long j = 0;
                        if (tTBaseVideoActivity.w != null) {
                            j = TTBaseVideoActivity.this.w.j();
                            i5 = TTBaseVideoActivity.this.w.k();
                        }
                        if (!TTBaseVideoActivity.this.U) {
                            str = "click_start_play";
                        }
                        try {
                            jSONObject = new JSONObject();
                            try {
                                jSONObject.put(IronSourceConstants.EVENTS_DURATION, j);
                                jSONObject.put("percent", i5);
                            } catch (JSONException unused) {
                                jSONObject2 = jSONObject;
                            }
                        } catch (JSONException unused2) {
                            jSONObject = jSONObject2;
                            com.bytedance.sdk.openadsdk.b.d.a(this.b, TTBaseVideoActivity.this.p, "rewarded_video", str, jSONObject);
                        }
                        com.bytedance.sdk.openadsdk.b.d.a(this.b, TTBaseVideoActivity.this.p, "rewarded_video", str, jSONObject);
                    } else if (tTBaseVideoActivity instanceof TTFullScreenVideoActivity) {
                        if (!tTBaseVideoActivity.U) {
                            str = "click_start_play";
                        }
                        l.e("TTFullScreenTag", "mIsBarClickFirst:" + TTBaseVideoActivity.this.U);
                        com.bytedance.sdk.openadsdk.b.d.a(this.b, TTBaseVideoActivity.this.p, "fullscreen_interstitial_ad", str, (JSONObject) null);
                    }
                }
            };
            if (!TextUtils.isEmpty(this.S)) {
                HashMap hashMap = new HashMap();
                hashMap.put("rit_scene", this.S);
                this.T.a(hashMap);
            }
            this.T.a(this.b);
            this.T.a(this.x);
            this.l.setOnClickListener(this.T);
            this.l.setOnTouchListener(this.T);
            this.b.setOnClickListener(this.T);
            this.b.setOnTouchListener(this.T);
            FrameLayout frameLayout = this.m;
            if (frameLayout != null && z2) {
                frameLayout.setOnClickListener(new View.OnClickListener() {
                    /* class com.bytedance.sdk.openadsdk.activity.TTBaseVideoActivity.AnonymousClass2 */

                    public void onClick(View view) {
                        try {
                            long j = TTBaseVideoActivity.this.w.j();
                            int k = TTBaseVideoActivity.this.w.k();
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put(IronSourceConstants.EVENTS_DURATION, j);
                            jSONObject.put("percent", k);
                            com.bytedance.sdk.openadsdk.b.d.a(TTBaseVideoActivity.this.c, TTBaseVideoActivity.this.p, "rewarded_video", "click_video", jSONObject);
                        } catch (Throwable unused) {
                        }
                    }
                });
            }
            TextView textView = this.r;
            if (textView != null) {
                textView.setOnClickListener(new View.OnClickListener() {
                    /* class com.bytedance.sdk.openadsdk.activity.TTBaseVideoActivity.AnonymousClass3 */

                    public void onClick(View view) {
                        com.bytedance.sdk.openadsdk.b.d.c(TTBaseVideoActivity.this.c, TTBaseVideoActivity.this.p, TTBaseVideoActivity.this instanceof TTRewardVideoActivity ? "rewarded_video" : "fullscreen_interstitial_ad", "open_policy");
                        try {
                            if (j.e().i() != null) {
                                TTBaseVideoActivity.this.startActivity(new Intent(TTBaseVideoActivity.this, TTWebsiteActivity.class));
                            }
                        } catch (Throwable th) {
                            th.printStackTrace();
                        }
                    }
                });
            }
        }
    }

    /* access modifiers changed from: protected */
    public String i() {
        String a2 = o.a(this, "tt_video_download_apk");
        g gVar = this.p;
        if (gVar == null) {
            return a2;
        }
        if (!TextUtils.isEmpty(gVar.q())) {
            return this.p.q();
        }
        if (this.p.g() != 4) {
            return o.a(this, "tt_video_mobile_go_detail");
        }
        return a2;
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        if (this.J == 15) {
            setRequestedOrientation(1);
        } else {
            setRequestedOrientation(0);
        }
        super.onResume();
        if (!this.M.get()) {
            if (Build.VERSION.SDK_INT >= 26 || "C8817D".equals(this.V)) {
                m();
            } else if (l()) {
                this.w.d();
            }
        }
        r rVar = this.y;
        if (rVar != null) {
            rVar.a();
        }
        i iVar = this.q;
        if (iVar != null) {
            iVar.a();
        }
    }

    /* access modifiers changed from: protected */
    public void onStop() {
        super.onStop();
        i iVar = this.q;
        if (iVar != null) {
            iVar.b();
        }
    }

    private void m() {
        c cVar;
        if (this.N.getAndSet(false) || (cVar = this.w) == null) {
            return;
        }
        if (cVar.n() != null) {
            com.bytedance.sdk.openadsdk.core.video.c.d n2 = this.w.n();
            if (n2.i() || n2.j()) {
                ((a) this.w).q();
                a(this.t, true);
            }
        } else if (this.W) {
            ((a) this.w).q();
            a(this.t, true);
            this.W = false;
        }
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
        if (Build.VERSION.SDK_INT >= 26 || "C8817D".equals(this.V)) {
            n();
        } else {
            try {
                if (g()) {
                    this.w.b();
                }
            } catch (Throwable th) {
                l.e("TTBaseVideoActivity", "onPause throw Exception :" + th.getMessage());
            }
        }
        r rVar = this.y;
        if (rVar != null) {
            rVar.b();
        }
    }

    private void n() {
        c cVar = this.w;
        if (cVar != null && cVar.n() != null) {
            this.t = this.w.g();
            if (this.w.n().h() || !this.w.n().l()) {
                this.w.b();
                this.w.e();
                this.W = true;
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        com.bytedance.sdk.openadsdk.core.v.a(this.c, this.d);
        com.bytedance.sdk.openadsdk.core.v.a(this.d);
        c cVar = this.w;
        if (cVar != null) {
            cVar.e();
            this.w = null;
        }
        this.d = null;
        r rVar = this.y;
        if (rVar != null) {
            rVar.c();
        }
        i iVar = this.q;
        if (iVar != null) {
            iVar.c();
        }
    }

    /* access modifiers changed from: protected */
    public void onSaveInstanceState(Bundle bundle) {
        if (bundle == null) {
            bundle = new Bundle();
        }
        try {
            bundle.putString("material_meta", this.p != null ? this.p.C().toString() : null);
            bundle.putLong("video_current", this.w == null ? this.t : this.w.g());
            bundle.putString("video_cache_url", this.u);
            bundle.putInt("orientation", this.v);
            bundle.putBoolean("is_mute", this.F);
            bundle.putBoolean("is_bar_click_first", this.U);
        } catch (Throwable unused) {
        }
        super.onSaveInstanceState(bundle);
    }

    @Override // com.bytedance.sdk.openadsdk.g.v.a
    public void a(Message message) {
        switch (message.what) {
            case 500:
                SSWebView sSWebView = this.d;
                if (sSWebView != null) {
                    sSWebView.setAlpha(1.0f);
                    this.e.setAlpha(1.0f);
                }
                if ((this instanceof TTFullScreenVideoActivity) && this.w != null && g() && this.Q.get()) {
                    this.w.c();
                    this.w.f();
                    return;
                }
                return;
            case IronSourceError.ERROR_CODE_NO_CONFIGURATION_AVAILABLE /*{ENCODED_INT: 501}*/:
                RelativeLayout relativeLayout = this.b;
                if (relativeLayout != null) {
                    relativeLayout.setVisibility(0);
                    this.O.set(true);
                    d();
                    return;
                }
                return;
            case IronSourceError.ERROR_CODE_USING_CACHED_CONFIGURATION /*{ENCODED_INT: 502}*/:
                int i2 = message.arg1;
                if (j.e().a(String.valueOf(this.L))) {
                    if (!this.P.getAndSet(true)) {
                        this.f.setVisibility(0);
                    }
                    if (i2 <= 5) {
                        b(5 - i2);
                        this.f.setClickable(false);
                        return;
                    }
                    this.f.setText(a);
                    this.f.setClickable(true);
                    return;
                } else if (i2 == 5) {
                    if (!this.P.getAndSet(true)) {
                        this.f.setVisibility(0);
                    }
                    this.f.setText(a);
                    this.f.setClickable(true);
                    return;
                } else {
                    return;
                }
            default:
                return;
        }
    }

    /* access modifiers changed from: protected */
    public void j() {
        TextView textView = this.r;
        if (textView != null) {
            textView.setVisibility(8);
        }
    }

    private void b(int i2) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(i2 + "s | " + a);
        spannableStringBuilder.setSpan(new ForegroundColorSpan(o.i(this.c, "tt_skip_red")), 0, 2, 33);
        this.f.setText(spannableStringBuilder);
    }

    /* access modifiers changed from: protected */
    public IListenerManager a(int i2) {
        if (this.R == null) {
            this.R = com.bytedance.sdk.openadsdk.multipro.aidl.a.a.asInterface(com.bytedance.sdk.openadsdk.multipro.aidl.a.a(j.a()).a(i2));
        }
        return this.R;
    }
}
