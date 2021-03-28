package com.bytedance.sdk.openadsdk.core.video.nativevideo;

import android.app.Activity;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.os.Build;
import android.os.Message;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import com.bytedance.sdk.openadsdk.core.j;
import com.bytedance.sdk.openadsdk.core.video.d.b;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.b;
import com.bytedance.sdk.openadsdk.core.video.renderview.SSRenderSurfaceView;
import com.bytedance.sdk.openadsdk.core.video.renderview.SSRenderTextureView;
import com.bytedance.sdk.openadsdk.core.video.renderview.a;
import com.bytedance.sdk.openadsdk.core.widget.RoundImageView;
import com.bytedance.sdk.openadsdk.core.widget.b;
import com.bytedance.sdk.openadsdk.core.widget.c;
import com.bytedance.sdk.openadsdk.g.l;
import com.bytedance.sdk.openadsdk.g.m;
import com.bytedance.sdk.openadsdk.g.o;
import com.bytedance.sdk.openadsdk.g.t;
import com.bytedance.sdk.openadsdk.g.u;
import com.bytedance.sdk.openadsdk.g.v;
import com.facebook.appevents.AppEventsConstants;
import java.io.File;
import java.lang.ref.WeakReference;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.EnumSet;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: NativeVideoLayout */
public class g implements b, a, b.a, c.b, v.a, com.bytedance.sdk.openadsdk.h.b {
    private ImageView A;
    private View B;
    private ImageView C;
    private final v D;
    private final Context E;
    private int F;
    private int G;
    private int H;
    private int I;
    private boolean J;
    private boolean K;
    private boolean L;
    private int M;
    private int N;
    private int O;
    private int P;
    private int Q;
    private final Rect R;
    private SeekBar S;
    private ProgressBar T;
    private TextView U;
    private TextView V;
    private ColorStateList W;
    private float X;
    private final Rect Y;
    private int Z;
    private final View a;
    private final Rect aA;
    private boolean aB;
    private boolean aC;
    private boolean aa;
    private int ab;
    private int ac;
    private d ad;
    private boolean ae;
    private int af;
    private final EnumSet<b.a> ag;
    private final WeakReference<WindowManager> ah;
    private com.bytedance.sdk.openadsdk.core.widget.b ai;
    private c aj;
    private final com.bytedance.sdk.openadsdk.core.c.g ak;
    private boolean al;
    private com.com.bytedance.overseas.sdk.download.b am;
    private final c an;
    private com.bytedance.sdk.openadsdk.core.a.a ao;
    private final String ap;
    private boolean aq;
    private final View.OnTouchListener ar;
    private float as;
    private ColorStateList at;
    private float au;
    private final Rect av;
    private float aw;
    private ColorStateList ax;
    private float ay;
    private final Rect az;
    private com.bytedance.sdk.openadsdk.core.video.renderview.b b;
    private TextView c;
    private ImageView d;
    private ImageView e;
    private View f;
    private TextView g;
    private TextView h;
    private TextView i;
    private ImageView j;
    private View k;
    private View l;
    private View m;
    private ImageView n;
    private TextView o;
    private View p;
    private ImageView q;
    private View r;
    private RoundImageView s;
    private TextView t;
    private TextView u;
    private TextView v;
    private View w;
    private TextView x;
    private TextView y;
    private RelativeLayout z;

    @Override // com.bytedance.sdk.openadsdk.core.video.renderview.a
    public void b(SurfaceTexture surfaceTexture) {
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.renderview.a
    public void b(SurfaceTexture surfaceTexture, int i2, int i3) {
    }

    public g(Context context, View view, boolean z2, EnumSet<b.a> enumSet, com.bytedance.sdk.openadsdk.core.c.g gVar, c cVar, boolean z3) {
        this.D = new v(this);
        this.J = false;
        this.K = true;
        this.L = false;
        this.M = 0;
        this.N = 0;
        this.O = 0;
        this.P = 0;
        this.Q = 0;
        this.R = new Rect();
        this.Y = new Rect();
        this.Z = 0;
        this.ab = 0;
        this.ac = 0;
        WeakReference<WindowManager> weakReference = null;
        this.ai = null;
        this.al = true;
        this.ap = Build.MODEL;
        this.aq = false;
        this.ar = new View.OnTouchListener() {
            /* class com.bytedance.sdk.openadsdk.core.video.nativevideo.g.AnonymousClass11 */
            private float b;

            public boolean onTouch(View view, MotionEvent motionEvent) {
                float x = motionEvent.getX();
                int actionMasked = motionEvent.getActionMasked();
                if (actionMasked != 0) {
                    boolean z = true;
                    if (actionMasked == 1) {
                        g gVar = g.this;
                        if (Math.abs(this.b - motionEvent.getX()) >= 10.0f) {
                            z = false;
                        }
                        gVar.aq = z;
                    } else if (actionMasked == 2) {
                        view.getParent().requestDisallowInterceptTouchEvent(true);
                    } else if (actionMasked == 3) {
                        view.getParent().requestDisallowInterceptTouchEvent(false);
                    }
                } else {
                    this.b = x;
                }
                return false;
            }
        };
        this.av = new Rect();
        this.az = new Rect();
        this.aA = new Rect();
        this.ah = context instanceof Activity ? new WeakReference<>(((Activity) context).getWindowManager()) : weakReference;
        this.E = j.a().getApplicationContext();
        a(z3);
        this.a = view;
        this.K = z2;
        com.bytedance.sdk.openadsdk.core.widget.b bVar = new com.bytedance.sdk.openadsdk.core.widget.b(this);
        this.ai = bVar;
        bVar.a(this.K);
        this.ab = u.b(this.E);
        this.ac = u.c(this.E);
        this.ag = enumSet == null ? EnumSet.noneOf(b.a.class) : enumSet;
        this.an = cVar;
        this.ak = gVar;
        d(8);
        a(context, this.a);
        x();
        s();
    }

    public g(Context context, View view, boolean z2, EnumSet<b.a> enumSet, com.bytedance.sdk.openadsdk.core.c.g gVar, c cVar) {
        this(context, view, z2, enumSet, gVar, cVar, true);
    }

    private void s() {
        int i2;
        com.bytedance.sdk.openadsdk.core.a.a aVar;
        String str = this.al ? "embeded_ad" : "embeded_ad_landingpage";
        if (t.a(this.ak)) {
            str = this.al ? "draw_ad" : "draw_ad_landingpage";
            i2 = 6;
        } else {
            if (t.b(this.ak)) {
                str = "rewarded_video";
            }
            i2 = 1;
        }
        if (this.ak.g() == 4) {
            this.am = com.com.bytedance.overseas.sdk.download.c.a(this.E, this.ak, str);
        }
        t();
        com.bytedance.sdk.openadsdk.core.a.a aVar2 = new com.bytedance.sdk.openadsdk.core.a.a(this.E, this.ak, str, i2);
        this.ao = aVar2;
        aVar2.b(true);
        if (this.al) {
            this.ao.a(true);
        } else {
            this.ao.a(false);
        }
        this.ao.a(this.an);
        this.ao.c(true);
        com.com.bytedance.overseas.sdk.download.b bVar = this.am;
        if (bVar != null && (aVar = this.ao) != null) {
            aVar.a(bVar);
        }
    }

    private void t() {
        if (this.E != null && this.a != null) {
            AnonymousClass1 r0 = new View(this.E) {
                /* class com.bytedance.sdk.openadsdk.core.video.nativevideo.g.AnonymousClass1 */
                private final AtomicBoolean b = new AtomicBoolean(true);

                /* access modifiers changed from: protected */
                public void onMeasure(int i, int i2) {
                    super.onMeasure(0, 0);
                }

                public void onWindowFocusChanged(boolean z) {
                    super.onWindowFocusChanged(z);
                }

                /* access modifiers changed from: protected */
                public void onAttachedToWindow() {
                    super.onAttachedToWindow();
                    a();
                }

                public void onFinishTemporaryDetach() {
                    super.onFinishTemporaryDetach();
                    a();
                }

                private void a() {
                    g.this.C();
                }

                private void b() {
                    g.this.D();
                }

                /* access modifiers changed from: protected */
                public void onDetachedFromWindow() {
                    super.onDetachedFromWindow();
                    b();
                }

                public void onStartTemporaryDetach() {
                    super.onStartTemporaryDetach();
                    b();
                }
            };
            View view = this.a;
            if (view instanceof ViewGroup) {
                ((ViewGroup) view).addView(r0, 0, new RelativeLayout.LayoutParams(0, 0));
            }
        }
    }

    public com.bytedance.sdk.openadsdk.core.video.renderview.b a() {
        return this.b;
    }

    private boolean u() {
        return "C8817D".equals(this.ap);
    }

    private void a(Context context, View view) {
        View view2;
        String b2 = t.b(context);
        if (b2 == null) {
            b2 = AppEventsConstants.EVENT_PARAM_VALUE_NO;
        }
        boolean z2 = Build.VERSION.SDK_INT != 20 || Integer.valueOf(b2).intValue() >= 1572864;
        if (u() || !z2 || !com.bytedance.sdk.openadsdk.core.g.b().p() || Build.VERSION.SDK_INT < 14) {
            view2 = new SSRenderSurfaceView(this.E);
            l.b("NewLiveViewLayout", "use SurfaceView......");
        } else {
            view2 = new SSRenderTextureView(this.E);
            l.b("NewLiveViewLayout", "use TextureView......");
        }
        if (view instanceof RelativeLayout) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(13);
            ((RelativeLayout) view).addView(view2, 0, layoutParams);
        }
        u.a(view2, 8);
        this.b = (com.bytedance.sdk.openadsdk.core.video.renderview.b) view2;
        this.c = (TextView) view.findViewById(o.e(context, "tt_video_back"));
        this.d = (ImageView) view.findViewById(o.e(context, "tt_video_close"));
        this.f = view.findViewById(o.e(context, "tt_video_top_layout"));
        this.j = (ImageView) view.findViewById(o.e(context, "tt_video_fullscreen_back"));
        this.g = (TextView) view.findViewById(o.e(context, "tt_video_title"));
        this.h = (TextView) view.findViewById(o.e(context, "tt_video_top_title"));
        this.i = (TextView) view.findViewById(o.e(context, "tt_video_current_time"));
        this.e = (ImageView) view.findViewById(o.e(context, "tt_video_play"));
        this.T = (ProgressBar) view.findViewById(o.e(context, "tt_video_progress"));
        this.k = view.findViewById(o.e(context, "tt_video_loading_retry_layout"));
        this.l = view.findViewById(o.e(context, "tt_video_loading_progress"));
        this.m = view.findViewById(o.e(context, "tt_video_loading_retry"));
        this.n = (ImageView) view.findViewById(o.e(context, "tt_video_retry"));
        this.o = (TextView) view.findViewById(o.e(context, "tt_video_retry_des"));
        this.z = (RelativeLayout) view.findViewById(o.e(context, "tt_video_loading_cover"));
        this.A = (ImageView) view.findViewById(o.e(context, "tt_video_loading_cover_image"));
        this.S = (SeekBar) view.findViewById(o.e(context, "tt_video_seekbar"));
        this.U = (TextView) view.findViewById(o.e(context, "tt_video_time_left_time"));
        this.V = (TextView) view.findViewById(o.e(context, "tt_video_time_play"));
        this.p = view.findViewById(o.e(context, "tt_video_ad_cover"));
        this.q = (ImageView) view.findViewById(o.e(context, "tt_video_ad_finish_cover_image"));
        this.r = view.findViewById(o.e(context, "tt_video_ad_cover_center_layout"));
        this.s = (RoundImageView) view.findViewById(o.e(context, "tt_video_ad_logo_image"));
        this.t = (TextView) view.findViewById(o.e(context, "tt_video_btn_ad_image_tv"));
        this.u = (TextView) view.findViewById(o.e(context, "tt_video_ad_name"));
        this.v = (TextView) view.findViewById(o.e(context, "tt_video_ad_button"));
        this.w = view.findViewById(o.e(context, "tt_video_ad_cover_center_layout_draw"));
        this.x = (TextView) view.findViewById(o.e(context, "tt_video_ad_button_draw"));
        this.y = (TextView) view.findViewById(o.e(context, "tt_video_ad_replay"));
        this.B = view.findViewById(o.e(context, "tt_video_ad_bottom_layout"));
        this.C = (ImageView) view.findViewById(o.e(context, "tt_video_ad_full_screen"));
    }

    private void v() {
        if (this.ad != null && this.aj == null) {
            c cVar = new c();
            this.aj = cVar;
            cVar.a(this.E, this.a);
            this.aj.a(this.ad, this);
        }
    }

    public boolean a(int i2, com.bytedance.sdk.openadsdk.core.c.j jVar) {
        c cVar = this.aj;
        return cVar == null || cVar.a(i2, jVar);
    }

    public void b() {
        c cVar = this.aj;
        if (cVar != null) {
            cVar.a(false);
        }
    }

    public void a(a aVar) {
        if (aVar instanceof d) {
            this.ad = (d) aVar;
            v();
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private boolean w() {
        if (this.ad != null) {
            return true;
        }
        l.e("NewLiveViewLayout", "callback is null");
        return false;
    }

    private void x() {
        this.b.a(this);
        this.ai.a(this.a);
        int i2 = 8;
        u.a(this.d, (this.K || this.ag.contains(b.a.hideCloseBtn)) ? 8 : 0);
        this.d.setOnClickListener(new View.OnClickListener() {
            /* class com.bytedance.sdk.openadsdk.core.video.nativevideo.g.AnonymousClass4 */

            public void onClick(View view) {
                if (g.this.w()) {
                    g.this.ad.c(g.this, view);
                }
            }
        });
        TextView textView = this.c;
        if (!this.K || this.ag.contains(b.a.alwayShowBackBtn)) {
            i2 = 0;
        }
        u.a(textView, i2);
        this.c.setOnClickListener(new View.OnClickListener() {
            /* class com.bytedance.sdk.openadsdk.core.video.nativevideo.g.AnonymousClass5 */

            public void onClick(View view) {
                if (g.this.w()) {
                    g.this.ad.d(g.this, view);
                }
            }
        });
        this.j.setOnClickListener(new View.OnClickListener() {
            /* class com.bytedance.sdk.openadsdk.core.video.nativevideo.g.AnonymousClass6 */

            public void onClick(View view) {
                if (g.this.w()) {
                    g.this.ad.e(g.this, view);
                }
            }
        });
        this.e.setOnClickListener(new View.OnClickListener() {
            /* class com.bytedance.sdk.openadsdk.core.video.nativevideo.g.AnonymousClass7 */

            public void onClick(View view) {
                if (!g.this.w()) {
                    return;
                }
                if (g.this.v == null || g.this.v.getVisibility() != 0) {
                    g.this.ad.a(g.this, view);
                }
            }
        });
        this.n.setOnClickListener(new View.OnClickListener() {
            /* class com.bytedance.sdk.openadsdk.core.video.nativevideo.g.AnonymousClass8 */

            public void onClick(View view) {
                g.this.a(false, true);
                g.this.k();
                g.this.f();
                if (g.this.w()) {
                    g.this.ad.f(g.this, view);
                }
            }
        });
        this.C.setOnClickListener(new View.OnClickListener() {
            /* class com.bytedance.sdk.openadsdk.core.video.nativevideo.g.AnonymousClass9 */

            public void onClick(View view) {
                if (g.this.w()) {
                    g.this.ad.b(g.this, view);
                }
            }
        });
        this.S.setThumbOffset(0);
        this.S.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            /* class com.bytedance.sdk.openadsdk.core.video.nativevideo.g.AnonymousClass10 */

            public void onStopTrackingTouch(SeekBar seekBar) {
                if (!g.this.J && g.this.E != null) {
                    seekBar.setThumb(o.c(j.a(), "tt_seek_thumb_normal"));
                }
                if (g.this.w()) {
                    seekBar.setThumbOffset(0);
                    g.this.ad.a(g.this, seekBar.getProgress());
                }
            }

            public void onStartTrackingTouch(SeekBar seekBar) {
                if (!g.this.J && g.this.E != null) {
                    seekBar.setThumb(o.c(j.a(), "tt_seek_thumb_press"));
                }
                if (g.this.w()) {
                    seekBar.setThumbOffset(0);
                    g.this.ad.b(g.this, seekBar.getProgress());
                }
            }

            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                if (g.this.w()) {
                    g.this.ad.a(g.this, i, z);
                }
            }
        });
        this.S.setOnTouchListener(this.ar);
    }

    public void a(int i2) {
        u.a(this.a, 0);
        com.bytedance.sdk.openadsdk.core.video.renderview.b bVar = this.b;
        if (bVar != null) {
            bVar.setVisibility(i2);
        }
    }

    public void a(boolean z2) {
        this.al = z2;
        com.bytedance.sdk.openadsdk.core.a.a aVar = this.ao;
        if (aVar != null) {
            if (z2) {
                aVar.a(true);
            } else {
                aVar.a(false);
            }
        }
    }

    public void c() {
        this.D.removeMessages(1);
        this.D.sendMessageDelayed(this.D.obtainMessage(1), 2000);
    }

    public void d() {
        this.D.removeMessages(1);
    }

    public void b(boolean z2) {
        int i2 = m() ? this.ac : this.F;
        int i3 = m() ? this.ab : this.G;
        if (this.I > 0 && this.H > 0 && i2 > 0) {
            if (!n() && !m() && !this.ag.contains(b.a.fixedSize)) {
                i3 = this.E.getResources().getDimensionPixelSize(o.h(this.E, "tt_video_container_maxheight"));
            }
            int i4 = this.H;
            int i5 = this.I;
            int i6 = (int) (((float) i5) * ((((float) i2) * 1.0f) / ((float) i4)));
            if (i6 > i3) {
                i2 = (int) (((float) i4) * ((((float) i3) * 1.0f) / ((float) i5)));
            } else {
                i3 = i6;
            }
            if (!z2 && !m()) {
                i2 = this.F;
                i3 = this.G;
            }
            this.b.a(i2, i3);
        }
    }

    public void a(int i2, int i3) {
        if (i2 == -1) {
            i2 = u.b(this.E);
        }
        if (i2 > 0) {
            this.F = i2;
            if (n() || m() || this.ag.contains(b.a.fixedSize)) {
                this.G = i3;
            } else {
                this.G = e(i2);
            }
            b(this.F, this.G);
        }
    }

    public void a(boolean z2, boolean z3) {
        this.aa = z2;
        ImageView imageView = this.e;
        if (imageView == null) {
            return;
        }
        if (z2) {
            imageView.setImageResource(o.d(this.E, "tt_play_movebar_textpage"));
        } else {
            imageView.setImageResource(o.d(this.E, "tt_stop_movebar_textpage"));
        }
    }

    public void a(String str) {
        TextView textView = this.g;
        if (textView != null) {
            textView.setText(str);
        }
        TextView textView2 = this.h;
        if (textView2 != null) {
            textView2.setText(str);
        }
    }

    public void b(int i2, int i3) {
        ViewGroup.LayoutParams layoutParams = this.a.getLayoutParams();
        if (i2 == -1 || i2 == -2 || i2 > 0) {
            layoutParams.width = i2;
        }
        if (i3 == -1 || i3 == -2 || i3 > 0) {
            layoutParams.height = i3;
        }
        this.a.setLayoutParams(layoutParams);
    }

    private int e(int i2) {
        if (this.H <= 0 || this.I <= 0) {
            return 0;
        }
        int dimensionPixelSize = this.E.getResources().getDimensionPixelSize(o.h(this.E, "tt_video_container_maxheight"));
        int dimensionPixelSize2 = this.E.getResources().getDimensionPixelSize(o.h(this.E, "tt_video_container_minheight"));
        int i3 = (int) (((float) this.I) * ((((float) i2) * 1.0f) / ((float) this.H)));
        if (i3 > dimensionPixelSize) {
            return dimensionPixelSize;
        }
        return i3 < dimensionPixelSize2 ? dimensionPixelSize2 : i3;
    }

    public void c(int i2, int i3) {
        this.H = i2;
        this.I = i3;
    }

    public void b(int i2) {
        View view = this.B;
        if (view == null || view.getVisibility() != 0) {
            u.a(this.T, 0);
            this.S.setProgress(i2);
            this.T.setProgress(i2);
            return;
        }
        u.a(this.T, 8);
    }

    public void a(long j2, long j3) {
        this.U.setText(com.bytedance.sdk.openadsdk.core.video.d.a.a(j3));
        this.V.setText(com.bytedance.sdk.openadsdk.core.video.d.a.a(j2));
        this.S.setProgress(com.bytedance.sdk.openadsdk.core.video.d.a.a(j2, j3));
    }

    public void a(ViewGroup viewGroup) {
        if (viewGroup != null) {
            if (this.a.getParent() != null) {
                ((ViewGroup) this.a.getParent()).removeView(this.a);
            }
            this.aB = true;
            viewGroup.addView(this.a);
            d(0);
        }
    }

    public View e() {
        return this.a;
    }

    public void f() {
        com.bytedance.sdk.openadsdk.core.c.g gVar;
        u.e(this.k);
        u.e(this.l);
        u.d(this.m);
        if (!(this.z == null || this.A == null || (gVar = this.ak) == null || gVar.e() == null || this.ak.e().f() == null)) {
            u.e(this.z);
            com.bytedance.sdk.openadsdk.e.b.a(this.E).a(this.ak.e().f(), this.A);
        }
        if (this.e.getVisibility() == 0) {
            u.a(this.e, 8);
        }
    }

    public void g() {
        u.e(this.k);
        u.e(this.l);
        u.d(this.m);
        if (this.e.getVisibility() == 0) {
            u.a(this.e, 8);
        }
    }

    public void h() {
        b(false, this.K);
        y();
    }

    public void a(long j2) {
        this.V.setText(com.bytedance.sdk.openadsdk.core.video.d.a.a(j2));
    }

    public void i() {
        u.a(this.a, 0);
        com.bytedance.sdk.openadsdk.core.video.renderview.b bVar = this.b;
        if (bVar != null) {
            View view = bVar.getView();
            if (view instanceof TextureView) {
                ViewParent parent = view.getParent();
                if (parent instanceof ViewGroup) {
                    ViewGroup viewGroup = (ViewGroup) parent;
                    int indexOfChild = viewGroup.indexOfChild(view);
                    viewGroup.removeView(view);
                    viewGroup.addView(view, indexOfChild);
                }
            }
            u.a(view, 8);
            u.a(view, 0);
        }
    }

    private void y() {
        u.a(this.p, 8);
        u.a(this.q, 8);
        u.a(this.r, 8);
        u.a(this.s, 8);
        u.a(this.t, 8);
        u.a(this.u, 8);
        u.a(this.v, 8);
    }

    public void a(com.bytedance.sdk.openadsdk.core.c.g gVar, WeakReference<Context> weakReference, boolean z2) {
        String str;
        String str2;
        if (gVar != null) {
            b(false, this.K);
            u.a(this.p, 0);
            u.a(this.q, 0);
            if (t.a(this.ak)) {
                u.a(this.r, 8);
                u.a(this.q, 0);
                u.a(this.w, 0);
                u.a(this.x, 0);
                u.a(this.y, 0);
                if (m.c(j.a()) == 0) {
                    u.a(this.y, 8);
                }
                this.p.setOnClickListener(new View.OnClickListener() {
                    /* class com.bytedance.sdk.openadsdk.core.video.nativevideo.g.AnonymousClass2 */

                    public void onClick(View view) {
                        if (g.this.an != null) {
                            ((a) g.this.an).a();
                        }
                    }
                });
                com.bytedance.sdk.openadsdk.core.c.g gVar2 = this.ak;
                if (!(gVar2 == null || gVar2.e() == null || this.ak.e().f() == null)) {
                    com.bytedance.sdk.openadsdk.core.video.d.b.a((long) this.ak.e().d(), this.ak.e().g(), new b.AbstractC0006b() {
                        /* class com.bytedance.sdk.openadsdk.core.video.nativevideo.g.AnonymousClass3 */

                        @Override // com.bytedance.sdk.openadsdk.core.video.d.b.AbstractC0006b
                        public void a(Bitmap bitmap) {
                            if (bitmap != null) {
                                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) g.this.q.getLayoutParams();
                                if (bitmap.getWidth() > bitmap.getHeight()) {
                                    layoutParams.width = u.b(j.a());
                                    layoutParams.height = (int) ((float) ((bitmap.getHeight() * u.b(j.a())) / bitmap.getWidth()));
                                    layoutParams.addRule(13);
                                    g.this.q.setLayoutParams(layoutParams);
                                }
                                g.this.q.setImageBitmap(bitmap);
                                return;
                            }
                            com.bytedance.sdk.openadsdk.e.b.a(g.this.E).a(g.this.ak.e().f(), g.this.q);
                        }
                    });
                }
            } else {
                u.a(this.r, 0);
                com.bytedance.sdk.openadsdk.core.c.g gVar3 = this.ak;
                if (!(gVar3 == null || gVar3.e() == null || this.ak.e().f() == null)) {
                    com.bytedance.sdk.openadsdk.e.b.a(this.E).a(this.ak.e().f(), this.q);
                }
            }
            if (!TextUtils.isEmpty(gVar.f())) {
                str = gVar.f();
            } else if (!TextUtils.isEmpty(gVar.o())) {
                str = gVar.o();
            } else {
                str = !TextUtils.isEmpty(gVar.p()) ? gVar.p() : "";
            }
            com.bytedance.sdk.openadsdk.core.c.g gVar4 = this.ak;
            if (gVar4 != null && gVar4.h() != null && this.ak.h().a() != null) {
                u.a(this.s, 0);
                u.a(this.t, 4);
                com.bytedance.sdk.openadsdk.e.b.a(this.E).a(this.ak.h().a(), this.s);
                this.s.setOnClickListener(this.ao);
                this.s.setOnTouchListener(this.ao);
            } else if (!TextUtils.isEmpty(str)) {
                u.a(this.s, 4);
                u.a(this.t, 0);
                this.t.setText(str.substring(0, 1));
                this.t.setOnClickListener(this.ao);
                this.t.setOnTouchListener(this.ao);
            }
            if (!TextUtils.isEmpty(str)) {
                this.u.setText(str);
            }
            u.a(this.u, 0);
            u.a(this.v, 0);
            int g2 = gVar.g();
            if (g2 == 2 || g2 == 3) {
                str2 = o.a(this.E, "tt_video_mobile_go_detail");
            } else if (g2 != 4) {
                str2 = g2 != 5 ? o.a(this.E, "tt_video_mobile_go_detail") : o.a(this.E, "tt_video_dial_phone");
            } else {
                str2 = o.a(this.E, "tt_video_download_apk");
            }
            this.v.setText(str2);
            this.x.setText(str2);
            this.v.setOnClickListener(this.ao);
            this.v.setOnTouchListener(this.ao);
            this.x.setOnClickListener(this.ao);
            this.x.setOnTouchListener(this.ao);
        }
    }

    public void j() {
        u.d(this.k);
        u.d(this.l);
        RelativeLayout relativeLayout = this.z;
        if (relativeLayout != null) {
            u.d(relativeLayout);
        }
    }

    public void k() {
        u.d(this.k);
        u.d(this.m);
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.renderview.a
    public void a(SurfaceHolder surfaceHolder) {
        if (surfaceHolder == this.b.getHolder()) {
            this.ae = true;
            if (w()) {
                this.ad.a(this, surfaceHolder);
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.renderview.a
    public void a(SurfaceHolder surfaceHolder, int i2, int i3, int i4) {
        if (surfaceHolder == this.b.getHolder() && w()) {
            this.ad.a(this, surfaceHolder, i2, i3, i4);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.renderview.a
    public void b(SurfaceHolder surfaceHolder) {
        if (surfaceHolder == this.b.getHolder()) {
            this.ae = false;
            if (w()) {
                this.ad.b(this, surfaceHolder);
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.renderview.a
    public void a(SurfaceTexture surfaceTexture, int i2, int i3) {
        this.ae = true;
        if (w()) {
            this.ad.a(this, surfaceTexture);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.renderview.a
    public boolean a(SurfaceTexture surfaceTexture) {
        this.ae = false;
        if (!w()) {
            return true;
        }
        this.ad.b(this, surfaceTexture);
        return true;
    }

    public void l() {
        this.S.setProgress(0);
        this.S.setSecondaryProgress(0);
        this.T.setProgress(0);
        this.T.setSecondaryProgress(0);
        this.U.setText(o.b(this.E, "tt_00_00"));
        this.V.setText(o.b(this.E, "tt_00_00"));
        d(8);
        if (B()) {
            this.b.setVisibility(8);
        }
        ImageView imageView = this.A;
        if (imageView != null) {
            imageView.setImageDrawable(null);
        }
        d(8);
        u.a(this.B, 8);
        u.a(this.p, 8);
        u.a(this.q, 8);
        u.a(this.r, 8);
        u.a(this.s, 8);
        u.a(this.t, 8);
        u.a(this.u, 8);
        c cVar = this.aj;
        if (cVar != null) {
            cVar.a(true);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.widget.c.b
    public boolean m() {
        return this.J;
    }

    public boolean n() {
        return this.K;
    }

    public void b(ViewGroup viewGroup) {
        if (viewGroup != null && (this.a.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
            this.J = true;
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.a.getLayoutParams();
            this.N = marginLayoutParams.leftMargin;
            this.M = marginLayoutParams.topMargin;
            this.O = marginLayoutParams.width;
            this.P = marginLayoutParams.height;
            marginLayoutParams.width = -1;
            marginLayoutParams.height = -1;
            marginLayoutParams.topMargin = 0;
            marginLayoutParams.leftMargin = 0;
            this.a.setLayoutParams(marginLayoutParams);
            ViewGroup.LayoutParams layoutParams = viewGroup.getLayoutParams();
            if (layoutParams instanceof RelativeLayout.LayoutParams) {
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
                int[] rules = layoutParams2.getRules();
                this.Q = rules.length > 0 ? rules[3] : 0;
                layoutParams2.addRule(3, 0);
                viewGroup.setLayoutParams(layoutParams2);
            }
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) layoutParams;
                this.R.set(marginLayoutParams2.leftMargin, marginLayoutParams2.topMargin, marginLayoutParams2.rightMargin, marginLayoutParams2.bottomMargin);
                u.a(viewGroup, 0, 0, 0, 0);
            }
            b(true);
            this.C.setImageDrawable(o.c(this.E, "tt_shrink_video"));
            this.S.setThumb(o.c(this.E, "tt_seek_thumb_fullscreen_selector"));
            this.S.setThumbOffset(0);
            com.bytedance.sdk.openadsdk.core.video.d.a.a(this.a, false);
            d(this.J);
            u.a(this.f, 8);
            if (!this.K) {
                u.a(this.d, 8);
                u.a(this.c, 8);
            } else if (this.ag.contains(b.a.hideCloseBtn)) {
                u.a(this.d, 8);
            }
        }
    }

    public void c(ViewGroup viewGroup) {
        View view;
        if (viewGroup != null && (view = this.a) != null && (view.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
            this.J = false;
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.a.getLayoutParams();
            marginLayoutParams.width = this.O;
            marginLayoutParams.height = this.P;
            marginLayoutParams.leftMargin = this.N;
            marginLayoutParams.topMargin = this.M;
            this.a.setLayoutParams(marginLayoutParams);
            ViewGroup.LayoutParams layoutParams = viewGroup.getLayoutParams();
            if (layoutParams instanceof RelativeLayout.LayoutParams) {
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
                layoutParams2.addRule(3, this.Q);
                viewGroup.setLayoutParams(layoutParams2);
            }
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                u.a(viewGroup, this.R.left, this.R.top, this.R.right, this.R.bottom);
            }
            b(true);
            this.C.setImageDrawable(o.c(this.E, "tt_enlarge_video"));
            this.S.setThumb(o.c(this.E, "tt_seek_thumb_normal"));
            this.S.setThumbOffset(0);
            com.bytedance.sdk.openadsdk.core.video.d.a.a(this.a, true);
            d(this.J);
            u.a(this.f, 8);
            if (this.ag.contains(b.a.alwayShowBackBtn)) {
                u.a(this.c, 0);
            }
        }
    }

    private void d(boolean z2) {
        if (z2) {
            z();
        } else {
            A();
        }
    }

    private void z() {
        DisplayMetrics displayMetrics = this.E.getResources().getDisplayMetrics();
        TextView textView = this.V;
        if (textView != null) {
            this.as = textView.getTextSize();
            this.V.setTextSize(2, 14.0f);
            ColorStateList textColors = this.V.getTextColors();
            this.at = textColors;
            if (textColors != null) {
                this.V.setTextColor(o.i(this.E, "tt_ssxinzi15"));
            }
            this.au = this.V.getAlpha();
            this.V.setAlpha(0.85f);
            this.V.setShadowLayer(0.0f, u.a(this.E, 0.5f), u.a(this.E, 0.5f), o.i(this.E, "tt_video_shaoow_color_fullscreen"));
            ViewGroup.LayoutParams layoutParams = this.V.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                this.av.set(marginLayoutParams.leftMargin, marginLayoutParams.topMargin, marginLayoutParams.rightMargin, marginLayoutParams.bottomMargin);
                u.a(this.V, (int) TypedValue.applyDimension(1, 16.0f, displayMetrics), this.av.top, (int) TypedValue.applyDimension(1, 14.0f, displayMetrics), this.av.bottom);
            }
        }
        TextView textView2 = this.U;
        if (textView2 != null) {
            this.aw = textView2.getTextSize();
            this.U.setTextSize(2, 14.0f);
            ColorStateList textColors2 = this.U.getTextColors();
            this.ax = textColors2;
            if (textColors2 != null) {
                this.U.setTextColor(o.i(this.E, "tt_ssxinzi15"));
            }
            this.ay = this.U.getAlpha();
            this.U.setAlpha(0.85f);
            this.U.setShadowLayer(0.0f, u.a(this.E, 0.5f), u.a(this.E, 0.5f), o.i(this.E, "tt_video_shaoow_color_fullscreen"));
            ViewGroup.LayoutParams layoutParams2 = this.U.getLayoutParams();
            if (layoutParams2 instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) layoutParams2;
                this.az.set(marginLayoutParams2.leftMargin, marginLayoutParams2.topMargin, marginLayoutParams2.rightMargin, marginLayoutParams2.bottomMargin);
                u.a(this.U, (int) TypedValue.applyDimension(1, 14.0f, displayMetrics), this.az.top, this.az.right, this.az.bottom);
            }
        }
        ImageView imageView = this.C;
        if (imageView != null) {
            ViewGroup.LayoutParams layoutParams3 = imageView.getLayoutParams();
            if (layoutParams3 instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams3 = (ViewGroup.MarginLayoutParams) layoutParams3;
                this.aA.set(marginLayoutParams3.leftMargin, marginLayoutParams3.topMargin, marginLayoutParams3.rightMargin, marginLayoutParams3.bottomMargin);
                u.a(this.C, this.aA.left, this.aA.top, (int) TypedValue.applyDimension(1, 16.0f, displayMetrics), this.aA.bottom);
            }
        }
        ImageView imageView2 = this.C;
        if (imageView2 != null) {
            imageView2.setImageDrawable(o.c(this.E, "tt_shrink_fullscreen"));
        }
        TextView textView3 = this.h;
        if (textView3 != null) {
            ColorStateList textColors3 = textView3.getTextColors();
            this.W = textColors3;
            if (textColors3 != null) {
                this.h.setTextColor(o.i(this.E, "tt_ssxinzi15"));
            }
            this.X = this.h.getAlpha();
            this.h.setAlpha(0.85f);
            ViewGroup.LayoutParams layoutParams4 = this.h.getLayoutParams();
            if (layoutParams4 instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams4 = (ViewGroup.MarginLayoutParams) layoutParams4;
                this.Y.set(marginLayoutParams4.leftMargin, marginLayoutParams4.topMargin, marginLayoutParams4.rightMargin, marginLayoutParams4.bottomMargin);
                u.a(this.h, (int) TypedValue.applyDimension(1, 1.0f, displayMetrics), this.az.top, this.az.right, this.az.bottom);
            }
        }
        View view = this.f;
        if (view != null) {
            ViewGroup.LayoutParams layoutParams5 = view.getLayoutParams();
            this.Z = layoutParams5.height;
            layoutParams5.height = (int) TypedValue.applyDimension(1, 49.0f, displayMetrics);
            this.f.setLayoutParams(layoutParams5);
            this.f.setBackgroundResource(o.d(this.E, "tt_shadow_fullscreen_top"));
        }
        a(this.aa, true);
    }

    private void A() {
        TextView textView = this.V;
        if (textView != null) {
            textView.setTextSize(0, this.as);
            ColorStateList colorStateList = this.at;
            if (colorStateList != null) {
                this.V.setTextColor(colorStateList);
            }
            this.V.setAlpha(this.au);
            this.V.setShadowLayer(u.a(this.E, 1.0f), 0.0f, 0.0f, o.i(this.E, "tt_video_shadow_color"));
            u.a(this.V, this.av.left, this.av.top, this.av.right, this.av.bottom);
        }
        TextView textView2 = this.U;
        if (textView2 != null) {
            textView2.setTextSize(0, this.aw);
            ColorStateList colorStateList2 = this.ax;
            if (colorStateList2 != null) {
                this.U.setTextColor(colorStateList2);
            }
            this.U.setAlpha(this.ay);
            this.U.setShadowLayer(u.a(this.E, 1.0f), 0.0f, 0.0f, o.i(this.E, "tt_video_shadow_color"));
            u.a(this.U, this.az.left, this.az.top, this.az.right, this.az.bottom);
        }
        ImageView imageView = this.C;
        if (imageView != null) {
            u.a(imageView, this.aA.left, this.aA.top, this.aA.right, this.aA.bottom);
        }
        ImageView imageView2 = this.C;
        if (imageView2 != null) {
            imageView2.setImageDrawable(o.c(this.E, "tt_enlarge_video"));
        }
        TextView textView3 = this.h;
        if (textView3 != null) {
            ColorStateList colorStateList3 = this.W;
            if (colorStateList3 != null) {
                textView3.setTextColor(colorStateList3);
            }
            this.h.setAlpha(this.X);
            u.a(this.h, this.az.left, this.az.top, this.az.right, this.az.bottom);
        }
        View view = this.f;
        if (view != null) {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            layoutParams.height = this.Z;
            this.f.setLayoutParams(layoutParams);
            this.f.setBackgroundResource(o.d(this.E, "tt_video_black_desc_gradient"));
        }
        a(this.aa, true);
    }

    @Override // com.bytedance.sdk.openadsdk.g.v.a
    public void a(Message message) {
        if (message.what == 1) {
            o();
        }
    }

    public void a(boolean z2, boolean z3, boolean z4) {
        u.a(this.B, 0);
        u.a(this.T, 0);
        int i2 = 8;
        if (this.J) {
            u.a(this.f, 0);
            u.a(this.h, 0);
        } else if (z4) {
            u.a(this.f, 8);
        }
        u.a(this.e, (!z2 || this.k.getVisibility() == 0) ? 8 : 0);
        if (!this.K && !this.J) {
            if (!this.ag.contains(b.a.hideCloseBtn) && !z4) {
                u.a(this.d, 0);
            }
            TextView textView = this.c;
            if (!z4) {
                i2 = 0;
            }
            u.a(textView, i2);
        }
        u.a(this.U, 0);
        u.a(this.V, 0);
        u.a(this.S, 0);
    }

    public void b(boolean z2, boolean z3) {
        u.a(this.B, 8);
        u.a(this.f, 8);
        u.a(this.T, z2 ? 0 : 8);
        u.a(this.e, 8);
        if (!this.K && !this.J) {
            u.a(this.d, 8);
            if (!this.ag.contains(b.a.alwayShowBackBtn)) {
                u.a(this.c, 8);
            }
        } else if (this.ag.contains(b.a.hideCloseBtn)) {
            u.a(this.d, 8);
        }
        if (z3) {
            u.a(this.d, 8);
            u.a(this.c, 8);
        }
        c(false);
    }

    @Override // com.bytedance.sdk.openadsdk.core.widget.c.b
    public void o() {
        b(true, false);
    }

    public boolean c(int i2) {
        SeekBar seekBar = this.S;
        return seekBar != null && i2 > seekBar.getSecondaryProgress();
    }

    public void c(boolean z2) {
        TextView textView = this.g;
        if (textView != null) {
            int i2 = 8;
            if (this.K) {
                u.a(textView, 8);
                return;
            }
            if (z2) {
                i2 = 0;
            }
            u.a(textView, i2);
        }
    }

    public boolean p() {
        return this.ae;
    }

    public void d(int i2) {
        this.af = i2;
        u.a(this.a, i2);
        if (i2 != 0) {
            this.aC = false;
        } else if (this.aB) {
            this.aC = true;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.widget.b.a
    public void a(View view, boolean z2) {
        if (m()) {
            String format = new SimpleDateFormat("HH:mm", Locale.getDefault()).format(new Date());
            com.bytedance.sdk.openadsdk.core.c.g gVar = this.ak;
            if (gVar != null && !TextUtils.isEmpty(gVar.o())) {
                a(this.ak.o());
            }
            this.i.setText(format);
        } else {
            a("");
            this.i.setText("");
        }
        if (!this.al) {
            boolean z3 = false;
            c(this.K && !this.J);
            if (w()) {
                d dVar = this.ad;
                if (this.k.getVisibility() != 0) {
                    z3 = true;
                }
                dVar.a(this, view, true, z3);
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.widget.b.a
    public void q() {
        o();
        c(false);
    }

    @Override // com.bytedance.sdk.openadsdk.core.widget.b.a
    public boolean r() {
        c cVar = this.aj;
        return cVar != null && cVar.a();
    }

    private boolean B() {
        return !this.ag.contains(b.a.alwayShowMediaView) || this.K;
    }

    @Override // com.bytedance.sdk.openadsdk.h.b
    public void a(File file, String str, int i2) {
        ProgressBar progressBar = this.T;
        if (progressBar != null) {
            progressBar.setSecondaryProgress(i2);
            if (i2 == 100) {
                l.e("onCacheAvailable", "percentsAvailable=" + i2);
                com.bytedance.sdk.openadsdk.core.g.b().a().b(this, str);
            }
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void C() {
        com.bytedance.sdk.openadsdk.core.c.g gVar = this.ak;
        if (gVar != null && gVar.e() != null && j.e().d(String.valueOf(t.c(this.ak.u())))) {
            l.e("onCacheAvailable", "registerVideoCacheListeners=");
            com.bytedance.sdk.openadsdk.core.g.b().a().a(this, this.ak.e().g());
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void D() {
        com.bytedance.sdk.openadsdk.core.c.g gVar = this.ak;
        if (gVar != null && gVar.e() != null && j.e().d(String.valueOf(t.c(this.ak.u())))) {
            l.e("onCacheAvailable", "unregisterVideoCacheListeners=");
            com.bytedance.sdk.openadsdk.core.g.b().a().b(this, this.ak.e().g());
        }
    }
}
