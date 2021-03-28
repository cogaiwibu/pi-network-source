package com.bytedance.sdk.openadsdk.core.video.nativevideo;

import android.content.Context;
import android.os.Build;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.bytedance.sdk.openadsdk.b.d;
import com.bytedance.sdk.openadsdk.core.c.g;
import com.bytedance.sdk.openadsdk.core.j;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.c;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.f;
import com.bytedance.sdk.openadsdk.e.b;
import com.bytedance.sdk.openadsdk.g.l;
import com.bytedance.sdk.openadsdk.g.m;
import com.bytedance.sdk.openadsdk.g.o;
import com.bytedance.sdk.openadsdk.g.t;
import com.bytedance.sdk.openadsdk.g.u;
import com.bytedance.sdk.openadsdk.g.v;
import com.bytedance.sdk.openadsdk.h.p;
import com.bytedance.sdk.openadsdk.multipro.d.a;
import java.lang.ref.WeakReference;
import java.util.concurrent.atomic.AtomicBoolean;

public class NativeVideoAdView extends FrameLayout implements f.a, v.a, p {
    protected final g a;
    protected c b;
    protected FrameLayout c;
    protected boolean d = true;
    protected RelativeLayout e;
    protected ImageView f;
    protected ImageView g;
    protected ImageView h;
    protected String i = "embeded_ad";
    protected int j = 50;
    private final Context k;
    private ViewGroup l;
    private boolean m = true;
    private boolean n = false;
    private boolean o = true;
    private long p;
    private final v q = new v(this);
    private boolean r = false;
    private final String s = Build.MODEL;
    private c.b t;
    private final AtomicBoolean u = new AtomicBoolean(false);
    private boolean v = true;

    public NativeVideoAdView(Context context, g gVar, boolean z) {
        super(context);
        this.k = context;
        this.a = gVar;
        setContentDescription("NativeVideoAdView");
        setIsInDetail(z);
        a();
        e();
    }

    /* access modifiers changed from: protected */
    public void a() {
        g gVar = this.a;
        if (gVar != null) {
            int c2 = t.c(gVar.u());
            int c3 = j.e().c(c2);
            boolean z = true;
            if (c3 == 1) {
                this.m = m.d(this.k);
            } else if (c3 == 2) {
                if (!m.e(this.k) && !m.d(this.k)) {
                    z = false;
                }
                this.m = z;
            } else if (c3 == 3) {
                this.m = false;
            }
            this.d = j.e().a(c2);
        }
    }

    private void e() {
        Context context = this.k;
        inflate(context, o.f(context, "tt_native_video_ad_view"), this);
        this.l = (ViewGroup) findViewById(o.e(this.k, "tt_native_video_layout"));
        this.c = (FrameLayout) findViewById(o.e(this.k, "tt_native_video_frame"));
        this.e = (RelativeLayout) findViewById(o.e(this.k, "tt_native_video_img_cover"));
        this.f = (ImageView) findViewById(o.e(this.k, "tt_native_video_img_id"));
        this.h = (ImageView) findViewById(o.e(this.k, "tt_native_video_play"));
        b.a(this.k).a(this.a.e().f(), this.f);
        f();
    }

    private void f() {
        f fVar = new f(this.k, this.c, this.a, this.i, !p());
        this.b = fVar;
        fVar.a(this);
        this.l.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            /* class com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoAdView.AnonymousClass1 */

            public void onGlobalLayout() {
                ((f) NativeVideoAdView.this.b).a(NativeVideoAdView.this.l.getWidth(), NativeVideoAdView.this.l.getHeight());
                NativeVideoAdView.this.l.getViewTreeObserver().removeGlobalOnLayoutListener(this);
            }
        });
    }

    public void setVideoAdLoadListener(c.AbstractC0007c cVar) {
        c cVar2 = this.b;
        if (cVar2 != null) {
            cVar2.a(cVar);
        }
    }

    public boolean a(long j2, boolean z, boolean z2) {
        int i2;
        long j3;
        this.l.setVisibility(0);
        if (this.b == null) {
            this.b = new f(this.k, this.c, this.a, this.i);
        }
        this.p = j2;
        if (!p()) {
            return true;
        }
        this.b.b(false);
        boolean a2 = this.b.a(this.a.e().g(), this.a.r(), this.l.getWidth(), this.l.getHeight(), null, this.a.u(), j2, o());
        if ((j2 > 0 && !z && !z2) || (j2 > 0 && z)) {
            c cVar = this.b;
            if (cVar != null) {
                j3 = cVar.i();
                i2 = this.b.k();
            } else {
                j3 = 0;
                i2 = 0;
            }
            d.a(this.k, this.a, this.i, "feed_continue", j3, i2);
        }
        return a2;
    }

    public void setNativeVideoAdListener(c.a aVar) {
        this.b.a(aVar);
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        g();
    }

    public void onFinishTemporaryDetach() {
        super.onFinishTemporaryDetach();
        g();
    }

    private void g() {
        r();
        if (this.b == null) {
            f();
        }
        if (this.b != null && this.u.get()) {
            this.u.set(false);
            a();
            if (c()) {
                u.a(this.e, 8);
                ImageView imageView = this.g;
                if (imageView != null) {
                    u.a(imageView, 8);
                }
                this.b.a(this.a.e().g(), this.a.r(), this.l.getWidth(), this.l.getHeight(), null, this.a.u(), 0, o());
                this.b.d(false);
            } else if (this.b.p()) {
                l.b("NativeVideoAdView", "attachTask-mNativeVideoController.isPlayComplete()=" + this.b.p());
                a(true);
            } else {
                l.c("NativeVideoAdView", "attachTask.......mRlImgCover.....VISIBLE");
                u.a(this.e, 0);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        h();
    }

    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        h();
    }

    private void h() {
        s();
        g gVar = this.a;
        if (!(gVar == null || gVar.e() == null || !j.e().d(String.valueOf(t.c(this.a.u()))))) {
            com.bytedance.sdk.openadsdk.core.g.b().a().a(this.a.e().g());
        }
        q();
        i();
    }

    private void i() {
        if (!this.u.get()) {
            this.u.set(true);
            c cVar = this.b;
            if (cVar != null) {
                cVar.a(true);
            }
        }
    }

    public void setVisibility(int i2) {
        super.setVisibility(i2);
        if (i2 == 4 || i2 == 8) {
            i();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.g.v.a
    public void a(Message message) {
        if (message.what == 1) {
            j();
        }
    }

    private void j() {
        b(u.a(getContext(), this, 50));
        this.q.sendEmptyMessageDelayed(1, 500);
    }

    private boolean k() {
        if (p()) {
            return false;
        }
        if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
            boolean a2 = a.a("sp_multi_native_video_data", "key_video_isfromvideodetailpage", false);
            if (a.a("sp_multi_native_video_data", "key_video_is_from_detail_page", false) || a2) {
                return true;
            }
            return false;
        } else if (this.b == null) {
            return false;
        } else {
            boolean g2 = com.bytedance.sdk.openadsdk.core.o.a().g();
            if (((f) this.b).v() || g2) {
                return true;
            }
            return false;
        }
    }

    private void l() {
        if (!p()) {
            if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
                a.a("sp_multi_native_video_data", "key_video_isfromvideodetailpage", (Boolean) false);
                a.a("sp_multi_native_video_data", "key_video_is_from_detail_page", (Boolean) false);
            } else if (this.b != null) {
                com.bytedance.sdk.openadsdk.core.o.a().b(false);
                ((f) this.b).f(false);
            }
        }
    }

    private void b(boolean z) {
        if (this.a != null && this.b != null) {
            boolean k2 = k();
            l();
            if (k2 && this.b.p()) {
                l.b("NativeVideoAdView", "changeVideoStatus---isFromDetailPage()=" + k2 + "，mNativeVideoController.isPlayComplete()=" + this.b.p());
                a(true);
            } else if (!z || this.b.p() || this.b.m()) {
                if (this.b.n() != null && this.b.n().g()) {
                    this.b.b();
                    c.b bVar = this.t;
                    if (bVar != null) {
                        bVar.b();
                    }
                }
            } else if (this.b.n() != null && this.b.n().i()) {
                if ("ALP-AL00".equals(this.s)) {
                    this.b.d();
                } else {
                    ((f) this.b).e(k2);
                }
                c.b bVar2 = this.t;
                if (bVar2 != null) {
                    bVar2.c();
                }
            }
        }
    }

    public void onWindowFocusChanged(boolean z) {
        c cVar;
        c cVar2;
        c cVar3;
        super.onWindowFocusChanged(z);
        if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
            m();
        }
        if (!k() || (cVar3 = this.b) == null || !cVar3.p()) {
            a();
            if (!p() && c() && (cVar = this.b) != null && !cVar.m() && this.q != null) {
                if (!z || (cVar2 = this.b) == null || cVar2.p()) {
                    this.q.removeMessages(1);
                    b(false);
                    return;
                }
                this.q.obtainMessage(1).sendToTarget();
                return;
            }
            return;
        }
        l();
        u.a(this.e, 8);
        a(true);
    }

    /* access modifiers changed from: protected */
    public void onWindowVisibilityChanged(int i2) {
        c cVar;
        c cVar2;
        c cVar3;
        super.onWindowVisibilityChanged(i2);
        if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
            m();
        }
        if (this.v) {
            this.v = i2 == 0;
        }
        if (!k() || (cVar3 = this.b) == null || !cVar3.p()) {
            a();
            if (!p() && c() && (cVar = this.b) != null && !cVar.m()) {
                if (this.o) {
                    this.b.a(this.a.e().g(), this.a.r(), this.l.getWidth(), this.l.getHeight(), null, this.a.u(), this.p, o());
                    this.o = false;
                    u.a(this.e, 8);
                }
                if (i2 == 0 && this.q != null && (cVar2 = this.b) != null && !cVar2.p()) {
                    this.q.obtainMessage(1).sendToTarget();
                    return;
                }
                return;
            }
            return;
        }
        l();
        u.a(this.e, 8);
        a(true);
    }

    private void m() {
        if (this.b != null && a.a("sp_multi_native_video_data", "key_video_is_update_flag", false)) {
            boolean a2 = a.a("sp_multi_native_video_data", "key_native_video_complete", false);
            long a3 = a.a("sp_multi_native_video_data", "key_video_current_play_position", 0L);
            long a4 = a.a("sp_multi_native_video_data", "key_video_total_play_duration", this.b.i());
            long a5 = a.a("sp_multi_native_video_data", "key_video_duration", this.b.l());
            this.b.d(a2);
            this.b.a(a3);
            this.b.b(a4);
            this.b.c(a5);
            a.a("sp_multi_native_video_data", "key_video_is_update_flag", (Boolean) false);
            l.e("MultiProcess", "onResumeFeedNativeVideoControllerData-isComplete=" + a2 + ",position=" + a3 + ",totalPlayDuration=" + a4 + ",duration=" + a5);
        }
    }

    public void setNativeVideoController(c cVar) {
        this.b = cVar;
    }

    public c getNativeVideoController() {
        return this.b;
    }

    public boolean c() {
        return this.m;
    }

    public void setIsAutoPlay(boolean z) {
        if (!this.r) {
            if (z && (!m.e(this.k) ? !m.d(this.k) : !n())) {
                z = false;
            }
            this.m = z;
            if (!z) {
                u.a(this.e, 0);
                b.a(this.k).a(this.a.e().f(), this.f);
            } else {
                u.a(this.e, 8);
            }
            this.r = true;
        }
    }

    private boolean n() {
        return 2 == j.e().c(t.c(this.a.u()));
    }

    private boolean o() {
        return this.d;
    }

    public void setIsQuiet(boolean z) {
        this.d = z;
        c cVar = this.b;
        if (cVar != null) {
            cVar.c(z);
        }
    }

    private boolean p() {
        return this.n;
    }

    public void setIsInDetail(boolean z) {
        this.n = z;
    }

    public void setVideoAdInteractionListener(c.b bVar) {
        this.t = bVar;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.f.a
    public void d() {
        c.b bVar = this.t;
        if (bVar != null) {
            bVar.a();
        }
    }

    /* access modifiers changed from: protected */
    public void b() {
        if (m.c(j.a()) != 0) {
            if (this.b.n() != null) {
                if (this.b.n().g()) {
                    b(false);
                    v vVar = this.q;
                    if (vVar != null) {
                        vVar.removeMessages(1);
                    }
                    c(true);
                    return;
                } else if (this.b.n().i()) {
                    b(true);
                    v vVar2 = this.q;
                    if (vVar2 != null) {
                        vVar2.sendEmptyMessageDelayed(1, 500);
                    }
                    c(false);
                    return;
                }
            }
            if (!c()) {
                this.m = true;
                t();
                this.b.a(this.a.e().g(), this.a.r(), this.l.getWidth(), this.l.getHeight(), null, this.a.u(), this.p, o());
                v vVar3 = this.q;
                if (vVar3 != null) {
                    vVar3.sendEmptyMessageDelayed(1, 500);
                }
                c(false);
            }
        }
    }

    private void c(boolean z) {
        if (this.g == null) {
            this.g = new ImageView(getContext());
            if (com.bytedance.sdk.openadsdk.core.g.b().q() != null) {
                this.g.setImageBitmap(com.bytedance.sdk.openadsdk.core.g.b().q());
            } else {
                this.g.setImageResource(o.d(j.a(), "tt_new_play_video"));
            }
            this.g.setScaleType(ImageView.ScaleType.FIT_XY);
            int a2 = (int) u.a(getContext(), (float) this.j);
            int a3 = (int) u.a(getContext(), 10.0f);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(a2, a2);
            layoutParams.gravity = 17;
            layoutParams.rightMargin = a3;
            layoutParams.bottomMargin = a3;
            this.l.addView(this.g, layoutParams);
        }
        if (z) {
            this.g.setVisibility(0);
        } else {
            this.g.setVisibility(8);
        }
    }

    public void a(boolean z) {
        c cVar = this.b;
        if (cVar != null) {
            cVar.d(z);
            g o2 = this.b.o();
            if (o2 != null) {
                o2.j();
                View e2 = o2.e();
                if (e2 != null) {
                    if (e2.getParent() != null) {
                        ((ViewGroup) e2.getParent()).removeView(e2);
                    }
                    e2.setVisibility(0);
                    addView(e2);
                    o2.a(this.a, new WeakReference<>(this.k), false);
                }
            }
        }
    }

    private void q() {
        g o2;
        c cVar = this.b;
        if (cVar != null && (o2 = cVar.o()) != null) {
            o2.h();
            View e2 = o2.e();
            if (e2 != null) {
                e2.setVisibility(8);
                if (e2.getParent() != null) {
                    ((ViewGroup) e2.getParent()).removeView(e2);
                }
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.h.p
    public void a(String str) {
        c cVar = this.b;
        if (cVar != null) {
            ((f) cVar).a(str);
        }
    }

    private void r() {
        g gVar = this.a;
        if (gVar != null && gVar.e() != null && j.e().d(String.valueOf(t.c(this.a.u())))) {
            com.bytedance.sdk.openadsdk.core.g.b().a().a(this, this.a.e().g());
        }
    }

    private void s() {
        g gVar = this.a;
        if (gVar != null && gVar.e() != null && j.e().d(String.valueOf(t.c(this.a.u())))) {
            com.bytedance.sdk.openadsdk.core.g.b().a().b(this.a.e().g());
        }
    }

    private void t() {
        u.d(this.g);
        u.d(this.e);
    }
}
