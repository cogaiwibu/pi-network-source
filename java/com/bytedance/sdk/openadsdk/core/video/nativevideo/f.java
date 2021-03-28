package com.bytedance.sdk.openadsdk.core.video.nativevideo;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.SurfaceTexture;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Message;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.bytedance.sdk.openadsdk.core.c.g;
import com.bytedance.sdk.openadsdk.core.h;
import com.bytedance.sdk.openadsdk.core.j;
import com.bytedance.sdk.openadsdk.core.video.c.d;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.b;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.c;
import com.bytedance.sdk.openadsdk.core.widget.c;
import com.bytedance.sdk.openadsdk.g.l;
import com.bytedance.sdk.openadsdk.g.m;
import com.bytedance.sdk.openadsdk.g.o;
import com.bytedance.sdk.openadsdk.g.t;
import com.bytedance.sdk.openadsdk.g.u;
import com.bytedance.sdk.openadsdk.g.v;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: NativeVideoController */
public class f implements c, d, v.a {
    private boolean A;
    private WeakReference<c.AbstractC0007c> B;
    private WeakReference<a> C;
    private int D;
    private int E;
    private int F;
    private final Runnable G;
    private final Runnable H;
    private final Runnable I;
    private int J;
    private long K;
    private boolean L;
    private long M;
    private final BroadcastReceiver N;
    private int O;
    private boolean P;
    Runnable a;
    private g b;
    private final WeakReference<ViewGroup> c;
    private final v d = new v(this);
    private long e = 0;
    private long f = 0;
    private d g;
    private c.a h;
    private long i = 0;
    private long j = 0;
    private long k;
    private List<Runnable> l;
    private boolean m;
    private final WeakReference<Context> n;
    private final boolean o;
    private boolean p;
    private boolean q;
    private final g r;
    private boolean s;
    private boolean t;
    private String u;
    private WeakReference<e> v;
    private long w;
    private boolean x;
    private boolean y;
    private boolean z;

    /* compiled from: NativeVideoController */
    public interface a {
        void d();
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.a
    public void a(b bVar, SurfaceHolder surfaceHolder, int i2, int i3, int i4) {
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public void a(Map<String, Object> map) {
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.a
    public void f(b bVar, View view) {
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public long h() {
        return 0;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public long j() {
        return 0;
    }

    public void a(int i2, int i3) {
        if (i2 != 0 && i3 != 0) {
            this.D = i2;
            this.E = i3;
            l.b("NativeVideoController", "width=" + i2 + "height=" + i3);
        }
    }

    private boolean w() {
        l.b("NativeVideoController", "retryCount=" + this.F);
        int i2 = this.F;
        if (1 <= i2) {
            g gVar = this.b;
            if (gVar != null) {
                gVar.j();
                this.b.a(this.r, this.n, false);
            }
            return false;
        } else if (this.g == null) {
            return false;
        } else {
            this.F = i2 + 1;
            l.b("NativeVideoController", "isPlaying=" + this.g.g() + ",isPaused=" + this.g.i() + ",isPrepared=" + this.g.k() + ",isStarted=" + this.g.h());
            if (!this.g.g() || !this.g.i() || !this.g.k() || !this.g.h()) {
                return true;
            }
            return false;
        }
    }

    private void b(Context context) {
        EnumSet noneOf = EnumSet.noneOf(b.a.class);
        noneOf.add(b.a.hideCloseBtn);
        noneOf.add(b.a.hideBackBtn);
        g gVar = new g(context, LayoutInflater.from(context.getApplicationContext()).inflate(o.f(context, "tt_video_play_layout_for_live"), (ViewGroup) null, false), true, noneOf, this.r, this, q());
        this.b = gVar;
        gVar.a(this);
    }

    public f(Context context, ViewGroup viewGroup, g gVar, String str, boolean z2) {
        boolean z3 = false;
        this.p = false;
        this.q = false;
        this.s = true;
        this.t = false;
        this.u = "embeded_ad";
        this.w = 0;
        this.x = false;
        this.y = false;
        this.z = false;
        this.A = false;
        this.D = 0;
        this.E = 0;
        this.F = 0;
        this.G = new Runnable() {
            /* class com.bytedance.sdk.openadsdk.core.video.nativevideo.f.AnonymousClass2 */

            public void run() {
                if (f.this.g != null) {
                    f.this.g.e();
                }
            }
        };
        this.H = new Runnable() {
            /* class com.bytedance.sdk.openadsdk.core.video.nativevideo.f.AnonymousClass3 */

            public void run() {
                if (f.this.h != null) {
                    f.this.h.a();
                }
            }
        };
        this.I = new Runnable() {
            /* class com.bytedance.sdk.openadsdk.core.video.nativevideo.f.AnonymousClass4 */

            public void run() {
                if (f.this.g != null) {
                    if (f.this.k <= 0) {
                        f.this.g.e();
                    }
                    f.this.g.f();
                }
                f.this.d.postDelayed(this, 200);
            }
        };
        this.J = 0;
        this.K = 0;
        this.a = new Runnable() {
            /* class com.bytedance.sdk.openadsdk.core.video.nativevideo.f.AnonymousClass5 */

            public void run() {
                if (f.this.b != null) {
                    f.this.b.a(f.this.r, f.this.n, false);
                    f.this.b.j();
                    f.this.d(true);
                    l.e("NativeVideoController", "出错后展示结果页、、、、、、、showAdCard");
                }
            }
        };
        this.L = false;
        this.N = new BroadcastReceiver() {
            /* class com.bytedance.sdk.openadsdk.core.video.nativevideo.f.AnonymousClass6 */

            public void onReceive(Context context, Intent intent) {
                String action = intent.getAction();
                if ("android.intent.action.SCREEN_OFF".equals(action)) {
                    f.this.b();
                } else if ("android.net.conn.CONNECTIVITY_CHANGE".equals(action)) {
                    f.this.c((f) context);
                }
            }
        };
        this.O = m.c(j.a().getApplicationContext());
        this.P = false;
        b(z2);
        this.u = str;
        this.c = new WeakReference<>(viewGroup);
        this.D = viewGroup.getWidth();
        this.E = viewGroup.getHeight();
        this.n = new WeakReference<>(context);
        this.r = gVar;
        b(context);
        this.o = Build.VERSION.SDK_INT >= 17 ? true : z3;
    }

    public f(Context context, ViewGroup viewGroup, g gVar, String str) {
        boolean z2 = false;
        this.p = false;
        this.q = false;
        this.s = true;
        this.t = false;
        this.u = "embeded_ad";
        this.w = 0;
        this.x = false;
        this.y = false;
        this.z = false;
        this.A = false;
        this.D = 0;
        this.E = 0;
        this.F = 0;
        this.G = new Runnable() {
            /* class com.bytedance.sdk.openadsdk.core.video.nativevideo.f.AnonymousClass2 */

            public void run() {
                if (f.this.g != null) {
                    f.this.g.e();
                }
            }
        };
        this.H = new Runnable() {
            /* class com.bytedance.sdk.openadsdk.core.video.nativevideo.f.AnonymousClass3 */

            public void run() {
                if (f.this.h != null) {
                    f.this.h.a();
                }
            }
        };
        this.I = new Runnable() {
            /* class com.bytedance.sdk.openadsdk.core.video.nativevideo.f.AnonymousClass4 */

            public void run() {
                if (f.this.g != null) {
                    if (f.this.k <= 0) {
                        f.this.g.e();
                    }
                    f.this.g.f();
                }
                f.this.d.postDelayed(this, 200);
            }
        };
        this.J = 0;
        this.K = 0;
        this.a = new Runnable() {
            /* class com.bytedance.sdk.openadsdk.core.video.nativevideo.f.AnonymousClass5 */

            public void run() {
                if (f.this.b != null) {
                    f.this.b.a(f.this.r, f.this.n, false);
                    f.this.b.j();
                    f.this.d(true);
                    l.e("NativeVideoController", "出错后展示结果页、、、、、、、showAdCard");
                }
            }
        };
        this.L = false;
        this.N = new BroadcastReceiver() {
            /* class com.bytedance.sdk.openadsdk.core.video.nativevideo.f.AnonymousClass6 */

            public void onReceive(Context context, Intent intent) {
                String action = intent.getAction();
                if ("android.intent.action.SCREEN_OFF".equals(action)) {
                    f.this.b();
                } else if ("android.net.conn.CONNECTIVITY_CHANGE".equals(action)) {
                    f.this.c((f) context);
                }
            }
        };
        this.O = m.c(j.a().getApplicationContext());
        this.P = false;
        this.c = new WeakReference<>(viewGroup);
        this.u = str;
        this.D = viewGroup.getWidth();
        this.E = viewGroup.getHeight();
        this.n = new WeakReference<>(context);
        this.r = gVar;
        b(context);
        this.o = Build.VERSION.SDK_INT >= 17 ? true : z2;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public g o() {
        return this.b;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public void a(c.AbstractC0007c cVar) {
        this.B = new WeakReference<>(cVar);
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public boolean a(String str, String str2, int i2, int i3, List<String> list, String str3, long j2, boolean z2) {
        l.b("NativeVideoController", "video local url " + str);
        if (TextUtils.isEmpty(str)) {
            l.e("NativeVideoController", "No video info");
            return false;
        }
        this.t = z2;
        this.i = j2;
        if (j2 <= 0) {
            this.q = false;
            this.p = false;
        }
        if (j2 > 0) {
            this.i = j2;
            long j3 = this.j;
            if (j3 > j2) {
                j2 = j3;
            }
            this.j = j2;
        }
        g gVar = this.b;
        if (gVar != null) {
            gVar.h();
            if (this.J == 0) {
                this.b.f();
            }
            this.b.c(i2, i3);
            this.b.a(this.c.get());
            this.b.a(i2, i3);
        }
        if (this.g == null) {
            this.g = new d(this.d);
        }
        this.f = 0;
        try {
            b(str);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public d n() {
        return this.g;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public long g() {
        return this.i;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public void a(long j2) {
        this.i = j2;
        long j3 = this.j;
        if (j3 > j2) {
            j2 = j3;
        }
        this.j = j2;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public void b(boolean z2) {
        this.s = z2;
        g gVar = this.b;
        if (gVar != null) {
            gVar.a(z2);
        }
    }

    public boolean q() {
        return this.s;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public boolean m() {
        return this.x;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public void b(long j2) {
        this.w = j2;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public long l() {
        return this.k;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public void c(long j2) {
        this.k = j2;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public long i() {
        d dVar = this.g;
        if (dVar == null) {
            return 0;
        }
        return dVar.p() + this.w;
    }

    public boolean r() {
        return this.t;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public void c(boolean z2) {
        this.t = z2;
        d dVar = this.g;
        if (dVar != null) {
            dVar.a(z2);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public boolean p() {
        return this.z;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public int k() {
        return com.bytedance.sdk.openadsdk.core.video.d.a.a(this.j, this.k);
    }

    private void b(String str) {
        if (this.g != null) {
            com.bytedance.sdk.openadsdk.core.video.a.a aVar = new com.bytedance.sdk.openadsdk.core.video.a.a();
            aVar.a = str;
            g gVar = this.r;
            if (gVar != null) {
                aVar.b = String.valueOf(t.c(gVar.u()));
            }
            aVar.c = 0;
            this.g.a(aVar);
        }
        this.e = System.currentTimeMillis();
        if (!TextUtils.isEmpty(str)) {
            this.b.a(8);
            this.b.a(0);
            a(new Runnable() {
                /* class com.bytedance.sdk.openadsdk.core.video.nativevideo.f.AnonymousClass1 */

                public void run() {
                    f.this.e = System.currentTimeMillis();
                    f.this.b.d(0);
                    if (f.this.g != null && f.this.i == 0) {
                        f.this.g.a(true, 0L, !f.this.t);
                    } else if (f.this.g != null) {
                        f.this.g.a(true, f.this.i, !f.this.t);
                    }
                    if (f.this.d != null) {
                        f.this.d.postDelayed(f.this.G, 100);
                    }
                    f.this.x();
                }
            });
        }
        if (this.s) {
            I();
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void x() {
        y();
        this.d.postDelayed(this.I, 800);
    }

    private void y() {
        this.d.removeCallbacks(this.I);
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public void a(e eVar) {
        this.v = new WeakReference<>(eVar);
    }

    private void b(int i2) {
        g gVar;
        this.J++;
        if (z() && (gVar = this.b) != null) {
            gVar.j();
            c.a aVar = this.h;
            if (aVar != null) {
                aVar.a(this.f, com.bytedance.sdk.openadsdk.core.video.d.a.a(this.i, this.k));
            }
            this.f = System.currentTimeMillis() - this.e;
            if (!t.a(this.r) || this.J >= 2) {
                this.b.a(this.r, this.n, true);
            }
            if (!this.q) {
                com.bytedance.sdk.openadsdk.b.d.a(this.n.get(), this.r, this.u, "feed_over", i(), 100);
                this.q = true;
                long j2 = this.k;
                a(j2, j2);
                long j3 = this.k;
                this.i = j3;
                this.j = j3;
            }
            if (!this.s && this.L) {
                e(this.b, null);
            }
            this.z = true;
            if (t.a(this.r) && this.J < 2) {
                a();
            }
        }
    }

    private boolean z() {
        WeakReference<Context> weakReference = this.n;
        return (weakReference == null || weakReference.get() == null) ? false : true;
    }

    private void a(Runnable runnable) {
        if (runnable != null) {
            if (!this.b.p() || !this.m) {
                b(runnable);
            } else {
                runnable.run();
            }
        }
    }

    private void b(Runnable runnable) {
        if (this.l == null) {
            this.l = Collections.synchronizedList(new ArrayList());
        }
        this.l.add(runnable);
    }

    private void A() {
        List<Runnable> list = this.l;
        if (list != null && !list.isEmpty()) {
            Iterator it = new ArrayList(this.l).iterator();
            while (it.hasNext()) {
                ((Runnable) it.next()).run();
            }
            this.l.clear();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public void a(c.a aVar) {
        this.h = aVar;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public void b() {
        d dVar = this.g;
        if (dVar != null) {
            dVar.b();
        }
        if (!this.q && this.p) {
            if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
                if (com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_multi_single_app_data_class", "IsCanLoadPauseLog", true)) {
                    com.bytedance.sdk.openadsdk.b.d.a(this.n.get(), this.r, this.u, "feed_pause", i(), k());
                }
                com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_multi_single_app_data_class", "IsCanLoadPauseLog", (Boolean) true);
                return;
            }
            if (com.bytedance.sdk.openadsdk.core.o.a().c()) {
                com.bytedance.sdk.openadsdk.b.d.a(this.n.get(), this.r, this.u, "feed_pause", i(), k());
            }
            com.bytedance.sdk.openadsdk.core.o.a().a(true);
        }
    }

    public void s() {
        d dVar = this.g;
        if (dVar != null) {
            dVar.b();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public void c() {
        d dVar = this.g;
        if (dVar != null) {
            dVar.d();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public void d() {
        g gVar = this.b;
        if (gVar != null) {
            gVar.h();
        }
        g gVar2 = this.b;
        if (gVar2 != null) {
            gVar2.i();
        }
        B();
    }

    public void e(boolean z2) {
        g gVar = this.b;
        if (gVar != null) {
            gVar.h();
        }
        g gVar2 = this.b;
        if (gVar2 != null && z2) {
            gVar2.i();
        }
        B();
    }

    private void B() {
        d dVar = this.g;
        if (dVar != null) {
            dVar.a(false, this.i, !this.t);
            x();
        }
        if (this.p) {
            com.bytedance.sdk.openadsdk.b.d.a(this.n.get(), this.r, this.u, "feed_continue", i(), k());
        }
    }

    public void d(long j2) {
        this.i = j2;
        long j3 = this.j;
        if (j3 > j2) {
            j2 = j3;
        }
        this.j = j2;
        g gVar = this.b;
        if (gVar != null) {
            gVar.h();
        }
        d dVar = this.g;
        if (dVar != null) {
            dVar.a(true, this.i, !this.t);
            x();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public void e() {
        a(true);
    }

    public void e(long j2) {
        this.K = j2;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public void a(boolean z2) {
        if (this.s) {
            this.K = i();
        }
        if (!this.q && this.p) {
            if (z2) {
                com.bytedance.sdk.openadsdk.b.d.a(this.n.get(), this.r, this.u, "feed_break", this.K, k());
                this.q = false;
            } else {
                com.bytedance.sdk.openadsdk.b.d.a(this.n.get(), this.r, this.u, "feed_pause", this.K, k());
            }
        }
        f();
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public void f() {
        d dVar = this.g;
        if (dVar != null) {
            dVar.c();
            this.g = null;
        }
        if (!t.a(this.r) || this.J == 2) {
            this.b.a(this.r, this.n, true);
        }
        v vVar = this.d;
        if (vVar != null) {
            vVar.removeCallbacks(this.I);
            this.d.removeCallbacks(this.H);
            this.d.removeCallbacks(this.G);
            this.d.removeCallbacksAndMessages(null);
        }
        y();
        List<Runnable> list = this.l;
        if (list != null) {
            list.clear();
        }
        if (this.s) {
            J();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.g.v.a
    public void a(Message message) {
        WeakReference<Context> weakReference;
        WeakReference<a> weakReference2;
        if (this.b != null && message != null && (weakReference = this.n) != null && weakReference.get() != null) {
            int i2 = message.what;
            if (i2 != 108) {
                if (i2 != 109) {
                    if (i2 == 308) {
                        l.e("NativeVideoController", "播放器状态出错 STAT_ERROR 200 、、、、、、、");
                        C();
                    } else if (i2 != 309) {
                        switch (i2) {
                            case IronSourceConstants.OFFERWALL_AVAILABLE /*{ENCODED_INT: 302}*/:
                                b(message.what);
                                return;
                            case 303:
                                int i3 = message.arg1;
                                int i4 = message.arg2;
                                l.e("NativeVideoController", "CALLBACK_ON_ERROR、、before isVideoPlaying、、、、、");
                                if (!u()) {
                                    l.e("NativeVideoController", "出错后 errorcode,extra、、、、、、、" + i3 + "," + i4);
                                    if (b(i3, i4)) {
                                        l.e("NativeVideoController", "出错后展示结果页、、、、、、、");
                                        this.b.a(this.r, this.n, false);
                                        d(true);
                                        f();
                                    }
                                    g gVar = this.b;
                                    if (gVar != null) {
                                        gVar.j();
                                    }
                                    c.a aVar = this.h;
                                    if (aVar != null) {
                                        aVar.b(this.f, com.bytedance.sdk.openadsdk.core.video.d.a.a(this.i, this.k));
                                    }
                                    WeakReference<c.AbstractC0007c> weakReference3 = this.B;
                                    if (weakReference3 != null && weakReference3.get() != null && !u()) {
                                        this.B.get().a(i3, i4);
                                        return;
                                    }
                                    return;
                                }
                                return;
                            case 304:
                                int i5 = message.arg1;
                                g gVar2 = this.b;
                                if (gVar2 != null) {
                                    if (i5 == 3 || i5 == 702) {
                                        this.b.j();
                                        this.d.removeCallbacks(this.a);
                                    } else if (i5 == 701) {
                                        gVar2.g();
                                        this.d.postDelayed(this.a, 8000);
                                    }
                                }
                                if (this.o && i5 == 3) {
                                    if (!(!this.s || (weakReference2 = this.C) == null || weakReference2.get() == null)) {
                                        this.C.get().d();
                                    }
                                    L();
                                    this.d.removeCallbacks(this.a);
                                }
                                if (this.o && i5 == 3 && !this.p) {
                                    if (this.s) {
                                        com.bytedance.sdk.openadsdk.b.d.b(this.n.get(), this.r, this.u, "feed_auto_play", (Map<String, Object>) null);
                                    } else if (this.i <= 0) {
                                        com.bytedance.sdk.openadsdk.b.d.b(this.n.get(), this.r, this.u, "feed_play", (Map<String, Object>) null);
                                    }
                                    this.p = true;
                                    return;
                                }
                                return;
                            case IronSourceConstants.OFFERWALL_OPENED /*{ENCODED_INT: 305}*/:
                                WeakReference<c.AbstractC0007c> weakReference4 = this.B;
                                if (!(weakReference4 == null || weakReference4.get() == null)) {
                                    this.B.get().a();
                                }
                                v vVar = this.d;
                                if (vVar != null) {
                                    vVar.removeCallbacks(this.H);
                                }
                                if (!this.o && !this.p) {
                                    if (this.s) {
                                        com.bytedance.sdk.openadsdk.b.d.b(this.n.get(), this.r, this.u, "feed_auto_play", (Map<String, Object>) null);
                                    } else {
                                        com.bytedance.sdk.openadsdk.b.d.b(this.n.get(), this.r, this.u, "feed_play", (Map<String, Object>) null);
                                    }
                                    this.p = true;
                                }
                                g gVar3 = this.b;
                                if (gVar3 != null) {
                                    gVar3.j();
                                }
                                this.d.removeCallbacks(this.a);
                                return;
                            case 306:
                                g gVar4 = this.b;
                                if (gVar4 != null) {
                                    gVar4.j();
                                    return;
                                }
                                return;
                            default:
                                switch (i2) {
                                    case 311:
                                        E();
                                        return;
                                    case 312:
                                        if (w()) {
                                            l.e("NativeVideoController", "CALLBACK_ON_RETRY_VIDEO_TIME-....重试....");
                                            f();
                                            this.g = null;
                                            a(this.r.e().g(), this.r.r(), this.D, this.E, null, this.r.u(), 0, r());
                                            return;
                                        }
                                        l.c("NativeVideoController", "不满足条件，无法重试");
                                        return;
                                    case 313:
                                        D();
                                        return;
                                    default:
                                        return;
                                }
                        }
                    } else {
                        l.c("NativeVideoController", "SSMediaPlayerWrapper 释放了。。。。。");
                    }
                } else if (message.obj instanceof Long) {
                    long longValue = ((Long) message.obj).longValue();
                    this.i = longValue;
                    long j2 = this.j;
                    if (j2 > longValue) {
                        longValue = j2;
                    }
                    this.j = longValue;
                    a(this.i, this.k);
                }
            } else if ((message.obj instanceof Long) && ((Long) message.obj).longValue() > 0) {
                this.k = ((Long) message.obj).longValue();
            }
        }
    }

    private void C() {
        if (this.c.get() != null && !com.bytedance.sdk.openadsdk.core.t.a(this.c.get(), 20, 0)) {
            l.e("NativeVideoController", "onStateError 出错后展示结果页、、、、、、、");
            this.b.a(this.r, this.n, false);
            d(true);
            f();
        }
    }

    private void D() {
        l.b("NativeVideoController", "before auseWhenInvisible、、、、、、、");
        if (this.c.get() != null && !com.bytedance.sdk.openadsdk.core.t.a(this.c.get(), 20, 0)) {
            l.b("NativeVideoController", "in pauseWhenInvisible、、、、、、、");
            s();
        }
    }

    private void E() {
        try {
            if (this.n != null && this.n.get() != null && F() != null && this.g != null) {
                if (this.g.a() != null) {
                    boolean z2 = true;
                    if (this.n.get().getResources().getConfiguration().orientation != 1) {
                        z2 = false;
                    }
                    float b2 = (float) u.b(this.n.get());
                    MediaPlayer a2 = this.g.a();
                    float videoWidth = (float) a2.getVideoWidth();
                    float videoHeight = (float) a2.getVideoHeight();
                    l.b("NativeVideoController", "videoHeight=" + videoHeight + ",videoWidth=" + videoWidth);
                    l.b("NativeVideoController", "screenWidth=" + b2 + ",screenHeight=" + ((float) u.c(this.n.get())));
                    if (videoWidth >= videoHeight) {
                        float f2 = 0.0f;
                        RelativeLayout.LayoutParams layoutParams = null;
                        if (z2) {
                            f2 = (videoHeight * b2) / videoWidth;
                        }
                        if (!Float.valueOf(f2).isNaN()) {
                            if (z2) {
                                layoutParams = new RelativeLayout.LayoutParams((int) b2, (int) f2);
                                layoutParams.addRule(13);
                            }
                            if (layoutParams != null) {
                                if (F() instanceof TextureView) {
                                    ((TextureView) F()).setLayoutParams(layoutParams);
                                } else if (F() instanceof SurfaceView) {
                                    ((SurfaceView) F()).setLayoutParams(layoutParams);
                                }
                                l.b("NativeVideoController", "changeSize=end");
                            }
                        }
                    }
                }
            }
        } catch (Throwable th) {
            l.a("NativeVideoController", "changeSize error", th);
        }
    }

    private com.bytedance.sdk.openadsdk.core.video.renderview.b F() {
        g gVar;
        WeakReference<Context> weakReference = this.n;
        if (weakReference == null || weakReference.get() == null || this.n.get().getResources().getConfiguration().orientation != 1 || (gVar = this.b) == null) {
            return null;
        }
        return gVar.a();
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.a
    public void a(b bVar, View view) {
        if (this.g != null && z()) {
            if (this.g.g()) {
                b();
                this.b.a(true, false);
                this.b.d();
            } else if (!this.g.i()) {
                g gVar = this.b;
                if (gVar != null) {
                    gVar.a(this.c.get());
                }
                d(this.i);
                g gVar2 = this.b;
                if (gVar2 != null) {
                    gVar2.a(false, false);
                }
            } else {
                e(false);
                g gVar3 = this.b;
                if (gVar3 != null) {
                    gVar3.a(false, false);
                }
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.a
    public void a(b bVar, int i2) {
        if (this.g != null) {
            x();
            a(this.M, c(i2));
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.a
    public void b(b bVar, int i2) {
        if (this.g != null) {
            y();
        }
        g gVar = this.b;
        if (gVar != null) {
            gVar.d();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.a
    public void a(b bVar, int i2, boolean z2) {
        if (z()) {
            long l2 = (long) ((((float) (((long) i2) * this.k)) * 1.0f) / ((float) o.l(this.n.get(), "tt_video_progress_max")));
            if (this.k > 0) {
                this.M = (long) ((int) l2);
            } else {
                this.M = 0;
            }
            g gVar = this.b;
            if (gVar != null) {
                gVar.a(this.M);
            }
        }
    }

    private void a(long j2, long j3) {
        this.i = j2;
        this.k = j3;
        this.b.a(j2, j3);
        this.b.b(com.bytedance.sdk.openadsdk.core.video.d.a.a(j2, j3));
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.a
    public void b(b bVar, View view) {
        b(bVar, view, false, false);
    }

    public void b(b bVar, View view, boolean z2, boolean z3) {
        if (z()) {
            g(!this.L);
            if (!(this.n.get() instanceof Activity)) {
                l.b("NativeVideoController", "context is not activity, not support this function.");
                return;
            }
            if (this.L) {
                a(z2 ? 8 : 0);
                g gVar = this.b;
                if (gVar != null) {
                    gVar.b(this.c.get());
                    this.b.c(false);
                }
            } else {
                a(1);
                g gVar2 = this.b;
                if (gVar2 != null) {
                    gVar2.c(this.c.get());
                    this.b.c(false);
                }
            }
            WeakReference<e> weakReference = this.v;
            e eVar = weakReference != null ? weakReference.get() : null;
            if (eVar != null) {
                eVar.a(this.L);
            }
        }
    }

    public void a(int i2) {
        if (z()) {
            boolean z2 = i2 == 0 || i2 == 8;
            Context context = this.n.get();
            if (context instanceof Activity) {
                Activity activity = (Activity) context;
                try {
                    activity.setRequestedOrientation(i2);
                } catch (Throwable unused) {
                }
                if (!z2) {
                    activity.getWindow().setFlags(1024, 1024);
                } else {
                    activity.getWindow().clearFlags(1024);
                }
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.a
    public void c(b bVar, View view) {
        g gVar = this.b;
        if (gVar != null) {
            gVar.l();
        }
        a(true);
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.a
    public void a(b bVar, View view, boolean z2, boolean z3) {
        if (this.s) {
            b();
        }
        if (z2 && !this.s && !t()) {
            this.b.a(!u(), false);
            this.b.a(z3, true, false);
        }
        d dVar = this.g;
        if (dVar == null || !dVar.g()) {
            this.b.d();
            return;
        }
        this.b.d();
        this.b.c();
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.a
    public void d(b bVar, View view) {
        if (this.L) {
            g(false);
            g gVar = this.b;
            if (gVar != null) {
                gVar.c(this.c.get());
            }
            a(1);
            return;
        }
        a(true);
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.a
    public void e(b bVar, View view) {
        a(bVar, view, false);
    }

    public void a(b bVar, View view, boolean z2) {
        G();
    }

    private void G() {
        if (z()) {
            g(!this.L);
            if (!(this.n.get() instanceof Activity)) {
                l.b("NativeVideoController", "context is not activity, not support this function.");
                return;
            }
            g gVar = this.b;
            if (gVar != null) {
                gVar.c(this.c.get());
                this.b.c(false);
            }
            a(1);
            WeakReference<e> weakReference = this.v;
            e eVar = weakReference != null ? weakReference.get() : null;
            if (eVar != null) {
                eVar.a(this.L);
            }
        }
    }

    private void g(boolean z2) {
        this.L = z2;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.a
    public void a(b bVar, SurfaceHolder surfaceHolder) {
        this.m = true;
        d dVar = this.g;
        if (dVar != null) {
            dVar.a(surfaceHolder);
            A();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.a
    public void b(b bVar, SurfaceHolder surfaceHolder) {
        this.m = false;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.a
    public void a(b bVar, SurfaceTexture surfaceTexture) {
        this.m = true;
        d dVar = this.g;
        if (dVar != null) {
            dVar.a(surfaceTexture);
            A();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.a
    public void b(b bVar, SurfaceTexture surfaceTexture) {
        this.m = false;
    }

    public boolean t() {
        d dVar = this.g;
        return dVar == null || dVar.l();
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.a
    public void a() {
        if (m.c(j.a()) != 0) {
            f();
            a(this.r.e().g(), this.r.r(), this.D, this.E, null, this.r.u(), 0, r());
            d(false);
        }
    }

    public boolean u() {
        d dVar = this.g;
        return dVar != null && dVar.g();
    }

    private void a(long j2, boolean z2) {
        if (this.g != null) {
            if (z2) {
                H();
            }
            this.g.a(j2);
        }
    }

    private boolean c(int i2) {
        return this.b.c(i2);
    }

    private void H() {
        g gVar = this.b;
        if (gVar != null) {
            gVar.d(0);
            this.b.b(false, false);
            this.b.c(false);
            this.b.c();
            this.b.f();
        }
    }

    /* renamed from: com.bytedance.sdk.openadsdk.core.video.nativevideo.f$8  reason: invalid class name */
    /* compiled from: NativeVideoController */
    static /* synthetic */ class AnonymousClass8 {
        static final /* synthetic */ int[] a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                com.bytedance.sdk.openadsdk.core.widget.c$a[] r0 = com.bytedance.sdk.openadsdk.core.widget.c.a.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                com.bytedance.sdk.openadsdk.core.video.nativevideo.f.AnonymousClass8.a = r0
                com.bytedance.sdk.openadsdk.core.widget.c$a r1 = com.bytedance.sdk.openadsdk.core.widget.c.a.PAUSE_VIDEO     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = com.bytedance.sdk.openadsdk.core.video.nativevideo.f.AnonymousClass8.a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.bytedance.sdk.openadsdk.core.widget.c$a r1 = com.bytedance.sdk.openadsdk.core.widget.c.a.RELEASE_VIDEO     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = com.bytedance.sdk.openadsdk.core.video.nativevideo.f.AnonymousClass8.a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.bytedance.sdk.openadsdk.core.widget.c$a r1 = com.bytedance.sdk.openadsdk.core.widget.c.a.START_VIDEO     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.video.nativevideo.f.AnonymousClass8.<clinit>():void");
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.d
    public void a(c.a aVar, String str) {
        int i2 = AnonymousClass8.a[aVar.ordinal()];
        if (i2 == 1) {
            b();
        } else if (i2 == 2) {
            a(true);
        } else if (i2 == 3) {
            d();
            this.x = false;
            this.y = true;
        }
    }

    private boolean d(int i2) {
        g gVar;
        int c2 = m.c(j.a());
        if (c2 == 0) {
            b();
            this.x = true;
            g gVar2 = this.b;
            if (gVar2 != null) {
                gVar2.a(this.r, this.n, false);
            }
        }
        if (c2 != 4 && c2 != 0) {
            g gVar3 = this.b;
            if (gVar3 != null) {
                gVar3.h();
            }
            b();
            this.x = true;
            this.y = false;
            g gVar4 = this.b;
            if (!(gVar4 == null || (gVar = this.r) == null)) {
                return gVar4.a(i2, gVar.e());
            }
        } else if (c2 == 4) {
            this.x = false;
            g gVar5 = this.b;
            if (gVar5 != null) {
                gVar5.b();
            }
        }
        return true;
    }

    private void a(Context context, int i2) {
        if (z() && context != null && this.O != i2) {
            this.O = i2;
            if (!(i2 == 4 || i2 == 0)) {
                this.y = false;
            }
            if (!this.y && !p()) {
                d(2);
            }
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void c(Context context) {
        int c2 = m.c(context);
        a(context, c2);
        if (c2 == 4) {
            this.x = false;
        }
    }

    public void a(Context context) {
        int c2 = m.c(context);
        a(context, c2);
        if (c2 == 4) {
            this.x = false;
            d();
        }
    }

    private void I() {
        if (!this.P) {
            Context applicationContext = j.a().getApplicationContext();
            this.P = true;
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            try {
                applicationContext.registerReceiver(this.N, intentFilter);
            } catch (Exception unused) {
            }
        }
    }

    private void J() {
        if (this.P) {
            Context applicationContext = j.a().getApplicationContext();
            this.P = false;
            try {
                applicationContext.unregisterReceiver(this.N);
            } catch (Exception unused) {
            }
        }
    }

    public void a(a aVar) {
        this.C = new WeakReference<>(aVar);
    }

    public boolean v() {
        return this.A;
    }

    public void f(boolean z2) {
        this.A = z2;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public void d(boolean z2) {
        this.z = z2;
    }

    private boolean b(int i2, int i3) {
        l.b("TTVideoLandingPageActivity", "OnError - Error code: " + i2 + " Extra code: " + i3);
        boolean z2 = i2 == -1010 || i2 == -1007 || i2 == -1004 || i2 == -110 || i2 == 100 || i2 == 200;
        if (i3 == -1004 || i3 == 1 || i3 == 700 || i3 == 800) {
            return true;
        }
        return z2;
    }

    public void a(String str) {
        v vVar = this.d;
        if (vVar != null) {
            vVar.postDelayed(new Runnable() {
                /* class com.bytedance.sdk.openadsdk.core.video.nativevideo.f.AnonymousClass7 */

                public void run() {
                    l.c("NativeVideoController", "checkCondition():" + f.this.K());
                    if (f.this.K()) {
                        f.this.d.sendEmptyMessage(312);
                    }
                }
            }, 2000);
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private boolean K() {
        d dVar = this.g;
        return dVar != null && !dVar.m() && !this.g.k() && !this.g.g() && !this.g.i() && !this.g.h();
    }

    private void L() {
        if (this.r != null) {
            h.a(j.a());
            j.d().a(com.bytedance.sdk.openadsdk.f.d.a(this.r.n(), true, this.r));
        }
    }
}
