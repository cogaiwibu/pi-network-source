package com.bytedance.sdk.openadsdk.core.video.b;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.SurfaceTexture;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Message;
import android.os.SystemClock;
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
import com.bytedance.sdk.openadsdk.core.video.nativevideo.b;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.c;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.d;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.e;
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
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: BaseVideoController */
public abstract class a implements c, d, v.a {
    private boolean A;
    private WeakReference<e> B;
    private final Runnable C;
    private final Runnable D;
    private final Runnable E;
    private boolean F;
    private long G;
    private final BroadcastReceiver H;
    private int I;
    private boolean J;
    final WeakReference<Context> a;
    final g b;
    long c;
    protected Map<String, Object> d;
    protected long e;
    protected long f;
    long g;
    private com.bytedance.sdk.openadsdk.core.video.nativevideo.g h;
    private final ViewGroup i;
    private final v j = new v(this);
    private long k = 0;
    private long l = 0;
    private com.bytedance.sdk.openadsdk.core.video.c.d m;
    private c.a n;
    private long o = 0;
    private long p = 0;
    private ArrayList<Runnable> q;
    private boolean r;
    private final boolean s;
    private boolean t;
    private boolean u;
    private boolean v;
    private boolean w;
    private long x;
    private boolean y;
    private boolean z;

    /* access modifiers changed from: protected */
    public abstract void a(int i2, int i3);

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.a
    public void a(b bVar, SurfaceHolder surfaceHolder, int i2, int i3, int i4) {
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public void a(c.AbstractC0007c cVar) {
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.a
    public void f(b bVar, View view) {
    }

    /* access modifiers changed from: protected */
    public abstract void v();

    /* access modifiers changed from: protected */
    public abstract void w();

    /* access modifiers changed from: protected */
    public abstract void x();

    /* access modifiers changed from: protected */
    public abstract void y();

    /* access modifiers changed from: protected */
    public abstract void z();

    private void a(Context context) {
        EnumSet noneOf = EnumSet.noneOf(b.a.class);
        noneOf.add(b.a.hideCloseBtn);
        noneOf.add(b.a.hideBackBtn);
        com.bytedance.sdk.openadsdk.core.video.nativevideo.g gVar = new com.bytedance.sdk.openadsdk.core.video.nativevideo.g(context.getApplicationContext(), LayoutInflater.from(context.getApplicationContext()).inflate(o.f(context, "tt_video_play_layout_for_live"), (ViewGroup) null, false), true, noneOf, this.b, this);
        this.h = gVar;
        gVar.a(this);
    }

    a(Context context, ViewGroup viewGroup, g gVar) {
        boolean z2 = false;
        this.t = false;
        this.u = false;
        this.v = true;
        this.w = false;
        this.x = 0;
        this.y = false;
        this.z = false;
        this.A = false;
        this.d = null;
        this.e = 0;
        this.f = 0;
        this.C = new Runnable() {
            /* class com.bytedance.sdk.openadsdk.core.video.b.a.AnonymousClass2 */

            public void run() {
                if (a.this.m != null) {
                    a.this.m.e();
                }
            }
        };
        this.D = new Runnable() {
            /* class com.bytedance.sdk.openadsdk.core.video.b.a.AnonymousClass3 */

            public void run() {
                if (a.this.n != null) {
                    a.this.n.a();
                }
            }
        };
        this.E = new Runnable() {
            /* class com.bytedance.sdk.openadsdk.core.video.b.a.AnonymousClass4 */

            public void run() {
                if (a.this.m != null) {
                    if (a.this.c <= 0) {
                        a.this.m.e();
                    }
                    a.this.m.f();
                }
                a.this.j.postDelayed(this, 200);
            }
        };
        this.F = false;
        this.H = new BroadcastReceiver() {
            /* class com.bytedance.sdk.openadsdk.core.video.b.a.AnonymousClass5 */

            public void onReceive(Context context, Intent intent) {
                String action = intent.getAction();
                if ("android.intent.action.SCREEN_OFF".equals(action)) {
                    a.this.b();
                } else if ("android.net.conn.CONNECTIVITY_CHANGE".equals(action)) {
                    a.this.b((a) context);
                }
            }
        };
        this.I = 1;
        this.J = false;
        this.I = m.c(context);
        this.i = viewGroup;
        this.a = new WeakReference<>(context);
        this.b = gVar;
        a(context);
        this.s = Build.VERSION.SDK_INT >= 17 ? true : z2;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public boolean a(String str, String str2, int i2, int i3, List<String> list, String str3, long j2, boolean z2) {
        l.b("BaseVideoController", "video local url " + str);
        if (TextUtils.isEmpty(str)) {
            l.e("BaseVideoController", "No video info");
            return false;
        }
        this.w = z2;
        if (j2 > 0) {
            this.o = j2;
            long j3 = this.p;
            if (j3 > j2) {
                j2 = j3;
            }
            this.p = j2;
        }
        com.bytedance.sdk.openadsdk.core.video.nativevideo.g gVar = this.h;
        if (gVar != null) {
            gVar.h();
            this.h.f();
            this.h.c(i2, i3);
            this.h.a(this.i);
        }
        if (this.m == null) {
            this.m = new com.bytedance.sdk.openadsdk.core.video.c.d(this.j);
        }
        this.l = 0;
        try {
            a(str);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public com.bytedance.sdk.openadsdk.core.video.c.d n() {
        return this.m;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public com.bytedance.sdk.openadsdk.core.video.nativevideo.g o() {
        return this.h;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public long g() {
        return this.o;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public void a(long j2) {
        this.o = j2;
        long j3 = this.p;
        if (j3 > j2) {
            j2 = j3;
        }
        this.p = j2;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public void b(boolean z2) {
        this.v = z2;
        this.h.a(z2);
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public boolean m() {
        return this.y;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public void b(long j2) {
        this.x = j2;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public long l() {
        return this.c;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public void c(long j2) {
        this.c = j2;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public long h() {
        if (n() == null) {
            return 0;
        }
        return n().o();
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public long i() {
        com.bytedance.sdk.openadsdk.core.video.c.d dVar = this.m;
        if (dVar == null) {
            return 0;
        }
        return dVar.p() + this.x;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public void c(boolean z2) {
        this.w = z2;
        com.bytedance.sdk.openadsdk.core.video.c.d dVar = this.m;
        if (dVar != null) {
            dVar.a(z2);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public long j() {
        com.bytedance.sdk.openadsdk.core.video.c.d dVar = this.m;
        if (dVar == null) {
            return 0;
        }
        return dVar.q() + this.x;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public boolean p() {
        return this.A;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public void d(boolean z2) {
        this.A = z2;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public int k() {
        return com.bytedance.sdk.openadsdk.core.video.d.a.a(this.p, this.c);
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public void a(Map<String, Object> map) {
        this.d = map;
    }

    private void a(String str) throws Exception {
        if (this.m != null) {
            com.bytedance.sdk.openadsdk.core.video.a.a aVar = new com.bytedance.sdk.openadsdk.core.video.a.a();
            aVar.a = str;
            g gVar = this.b;
            if (gVar != null) {
                aVar.b = String.valueOf(t.c(gVar.u()));
            }
            aVar.c = 1;
            this.m.a(aVar);
        }
        this.k = System.currentTimeMillis();
        if (!TextUtils.isEmpty(str)) {
            this.h.a(8);
            this.h.a(0);
            a(new Runnable() {
                /* class com.bytedance.sdk.openadsdk.core.video.b.a.AnonymousClass1 */

                public void run() {
                    a.this.k = System.currentTimeMillis();
                    a.this.h.d(0);
                    if (a.this.m != null && a.this.o == 0) {
                        a.this.m.a(true, 0L, !a.this.w);
                    } else if (a.this.m != null) {
                        a.this.m.a(true, a.this.o, !a.this.w);
                    }
                    if (a.this.j != null) {
                        a.this.j.postDelayed(a.this.C, 100);
                    }
                    a.this.B();
                }
            });
        }
        K();
    }

    private void A() {
        int f2 = j.e().f();
        this.j.removeCallbacks(this.D);
        this.j.postDelayed(this.D, (long) (f2 * 1000));
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void B() {
        C();
        this.j.postDelayed(this.E, 800);
    }

    private void C() {
        this.j.removeCallbacks(this.E);
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public void a(e eVar) {
        this.B = new WeakReference<>(eVar);
    }

    private void b(int i2) {
        if (D() && this.h != null) {
            this.j.removeCallbacks(this.D);
            this.h.j();
            long currentTimeMillis = System.currentTimeMillis() - this.k;
            this.l = currentTimeMillis;
            c.a aVar = this.n;
            if (aVar != null) {
                aVar.a(currentTimeMillis, com.bytedance.sdk.openadsdk.core.video.d.a.a(this.o, this.c));
            }
            if (!this.u) {
                v();
                this.u = true;
                long j2 = this.c;
                a(j2, j2);
                long j3 = this.c;
                this.o = j3;
                this.p = j3;
            }
            this.A = true;
        }
    }

    private boolean D() {
        WeakReference<Context> weakReference = this.a;
        return (weakReference == null || weakReference.get() == null) ? false : true;
    }

    private void a(Runnable runnable) {
        if (runnable != null) {
            if (!this.h.p() || !this.r) {
                b(runnable);
            } else {
                runnable.run();
            }
        }
    }

    private void b(Runnable runnable) {
        if (this.q == null) {
            this.q = new ArrayList<>();
        }
        this.q.add(runnable);
    }

    private void E() {
        ArrayList<Runnable> arrayList = this.q;
        if (arrayList != null && !arrayList.isEmpty()) {
            Iterator it = new ArrayList(this.q).iterator();
            while (it.hasNext()) {
                ((Runnable) it.next()).run();
            }
            this.q.clear();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public void a(c.a aVar) {
        this.n = aVar;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public void b() {
        this.g = i();
        com.bytedance.sdk.openadsdk.core.video.c.d dVar = this.m;
        if (dVar != null) {
            dVar.b();
        }
        if (!this.u && this.t) {
            w();
        }
        L();
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public void d() {
        com.bytedance.sdk.openadsdk.core.video.nativevideo.g gVar = this.h;
        if (gVar != null) {
            gVar.h();
        }
        com.bytedance.sdk.openadsdk.core.video.nativevideo.g gVar2 = this.h;
        if (gVar2 != null) {
            gVar2.i();
        }
        com.bytedance.sdk.openadsdk.core.video.c.d dVar = this.m;
        if (dVar != null) {
            dVar.a(false, this.o, !this.w);
            B();
            K();
        }
        if (!this.u && this.t) {
            x();
        }
    }

    public void q() {
        if (!this.u && this.t) {
            x();
        }
    }

    public void d(long j2) {
        this.o = j2;
        long j3 = this.p;
        if (j3 > j2) {
            j2 = j3;
        }
        this.p = j2;
        com.bytedance.sdk.openadsdk.core.video.nativevideo.g gVar = this.h;
        if (gVar != null) {
            gVar.h();
        }
        com.bytedance.sdk.openadsdk.core.video.c.d dVar = this.m;
        if (dVar != null) {
            dVar.a(true, this.o, !this.w);
            B();
            K();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public void e() {
        com.bytedance.sdk.openadsdk.core.video.c.d dVar = this.m;
        if (dVar != null) {
            dVar.c();
            this.m = null;
        }
        com.bytedance.sdk.openadsdk.core.video.nativevideo.g gVar = this.h;
        if (gVar != null) {
            gVar.l();
        }
        v vVar = this.j;
        if (vVar != null) {
            vVar.removeCallbacks(this.D);
            this.j.removeCallbacks(this.C);
            this.j.removeCallbacksAndMessages(null);
            C();
        }
        L();
        this.n = null;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public void a(boolean z2) {
        e();
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public void f() {
        e();
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.bytedance.sdk.openadsdk.g.v.a
    public void a(Message message) {
        WeakReference<Context> weakReference;
        if (this.h != null && message != null && (weakReference = this.a) != null && weakReference.get() != null) {
            int i2 = message.what;
            if (i2 != 108) {
                if (i2 != 109) {
                    if (i2 != 308) {
                        if (i2 != 311) {
                            if (i2 != 314) {
                                switch (i2) {
                                    case IronSourceConstants.OFFERWALL_AVAILABLE /*{ENCODED_INT: 302}*/:
                                        b(message.what);
                                        return;
                                    case 303:
                                        a(message.arg1, message.arg2);
                                        this.j.removeCallbacks(this.D);
                                        com.bytedance.sdk.openadsdk.core.video.nativevideo.g gVar = this.h;
                                        if (gVar != null) {
                                            gVar.j();
                                        }
                                        c.a aVar = this.n;
                                        if (aVar != null) {
                                            aVar.b(this.l, com.bytedance.sdk.openadsdk.core.video.d.a.a(this.o, this.c));
                                            return;
                                        }
                                        return;
                                    case 304:
                                        int i3 = message.arg1;
                                        com.bytedance.sdk.openadsdk.core.video.nativevideo.g gVar2 = this.h;
                                        if (gVar2 != null) {
                                            if (i3 == 3 || i3 == 702) {
                                                this.h.j();
                                                this.j.removeCallbacks(this.D);
                                            } else if (i3 == 701) {
                                                gVar2.g();
                                                A();
                                            }
                                        }
                                        if (this.s && i3 == 3 && !this.t) {
                                            this.f = SystemClock.elapsedRealtime() - this.e;
                                            c.a aVar2 = this.n;
                                            if (aVar2 != null) {
                                                aVar2.b();
                                            }
                                            y();
                                            F();
                                            this.t = true;
                                            return;
                                        }
                                        return;
                                    case IronSourceConstants.OFFERWALL_OPENED /*{ENCODED_INT: 305}*/:
                                        v vVar = this.j;
                                        if (vVar != null) {
                                            vVar.removeCallbacks(this.D);
                                        }
                                        if (!this.s && !this.t) {
                                            this.f = SystemClock.elapsedRealtime() - this.e;
                                            z();
                                            this.t = true;
                                        }
                                        com.bytedance.sdk.openadsdk.core.video.nativevideo.g gVar3 = this.h;
                                        if (gVar3 != null) {
                                            gVar3.j();
                                            return;
                                        }
                                        return;
                                    case 306:
                                        this.j.removeCallbacks(this.D);
                                        com.bytedance.sdk.openadsdk.core.video.nativevideo.g gVar4 = this.h;
                                        if (gVar4 != null) {
                                            gVar4.j();
                                            break;
                                        }
                                        break;
                                    default:
                                        return;
                                }
                            } else {
                                try {
                                    ((Boolean) message.obj).booleanValue();
                                } catch (Throwable unused) {
                                }
                                this.e = SystemClock.elapsedRealtime();
                                return;
                            }
                        }
                        G();
                        return;
                    }
                    a(308, 0);
                } else if (message.obj instanceof Long) {
                    long longValue = ((Long) message.obj).longValue();
                    this.o = longValue;
                    long j2 = this.p;
                    if (j2 > longValue) {
                        longValue = j2;
                    }
                    this.p = longValue;
                    a(this.o, this.c);
                }
            } else if ((message.obj instanceof Long) && ((Long) message.obj).longValue() > 0) {
                this.c = ((Long) message.obj).longValue();
            }
        }
    }

    private void F() {
        if (this.b != null) {
            h.a(j.a());
            j.d().a(com.bytedance.sdk.openadsdk.f.d.a(this.b.n(), true, this.b));
        }
    }

    private void G() {
        try {
            if (this.a != null && this.a.get() != null && I() != null && this.m != null) {
                if (this.m.a() != null) {
                    boolean z2 = true;
                    if (this.a.get().getResources().getConfiguration().orientation != 1) {
                        z2 = false;
                    }
                    float b2 = (float) u.b(this.a.get());
                    MediaPlayer a2 = this.m.a();
                    float videoWidth = (float) a2.getVideoWidth();
                    float videoHeight = (float) a2.getVideoHeight();
                    l.b("BaseVideoController", "videoHeight=" + videoHeight + ",videoWidth=" + videoWidth);
                    l.b("BaseVideoController", "screenWidth=" + b2 + ",screenHeight=" + ((float) u.c(this.a.get())));
                    if (videoWidth >= videoHeight) {
                        float f2 = 0.0f;
                        if (videoHeight <= 0.0f) {
                            return;
                        }
                        if (videoWidth > 0.0f) {
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
                                    if (I() instanceof TextureView) {
                                        ((TextureView) I()).setLayoutParams(layoutParams);
                                    } else if (I() instanceof SurfaceView) {
                                        ((SurfaceView) I()).setLayoutParams(layoutParams);
                                    }
                                    l.b("BaseVideoController", "changeSize=end");
                                }
                            }
                        }
                    }
                }
            }
        } catch (Throwable th) {
            l.a("BaseVideoController", "changeSize error", th);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.a
    public void a(b bVar, View view) {
        if (this.m != null && D()) {
            if (this.m.g()) {
                b();
                this.h.a(true, false);
                this.h.d();
            } else if (!this.m.i()) {
                com.bytedance.sdk.openadsdk.core.video.nativevideo.g gVar = this.h;
                if (gVar != null) {
                    gVar.a(this.i);
                }
                d(this.o);
                com.bytedance.sdk.openadsdk.core.video.nativevideo.g gVar2 = this.h;
                if (gVar2 != null) {
                    gVar2.a(false, false);
                }
            } else {
                d();
                com.bytedance.sdk.openadsdk.core.video.nativevideo.g gVar3 = this.h;
                if (gVar3 != null) {
                    gVar3.a(false, false);
                }
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.a
    public void a(b bVar, int i2) {
        if (this.m != null) {
            B();
            a(this.G, c(i2));
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.a
    public void b(b bVar, int i2) {
        if (this.m != null) {
            C();
        }
        com.bytedance.sdk.openadsdk.core.video.nativevideo.g gVar = this.h;
        if (gVar != null) {
            gVar.d();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.a
    public void a(b bVar, int i2, boolean z2) {
        if (D()) {
            long l2 = (long) ((((float) (((long) i2) * this.c)) * 1.0f) / ((float) o.l(this.a.get(), "tt_video_progress_max")));
            if (this.c > 0) {
                this.G = (long) ((int) l2);
            } else {
                this.G = 0;
            }
            com.bytedance.sdk.openadsdk.core.video.nativevideo.g gVar = this.h;
            if (gVar != null) {
                gVar.a(this.G);
            }
        }
    }

    private void a(long j2, long j3) {
        this.o = j2;
        this.c = j3;
        this.h.a(j2, j3);
        this.h.b(com.bytedance.sdk.openadsdk.core.video.d.a.a(j2, j3));
        try {
            if (this.n != null) {
                this.n.a(j2, j3);
            }
        } catch (Throwable th) {
            l.b("BaseVideoController", "onProgressUpdate error: ", th);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.a
    public void b(b bVar, View view) {
        b(bVar, view, false, false);
    }

    public void b(b bVar, View view, boolean z2, boolean z3) {
        if (D()) {
            e(!this.F);
            if (!(this.a.get() instanceof Activity)) {
                l.b("BaseVideoController", "context is not activity, not support this function.");
                return;
            }
            if (this.F) {
                a(z2 ? 8 : 0);
                com.bytedance.sdk.openadsdk.core.video.nativevideo.g gVar = this.h;
                if (gVar != null) {
                    gVar.b(this.i);
                    this.h.c(false);
                }
            } else {
                a(1);
                com.bytedance.sdk.openadsdk.core.video.nativevideo.g gVar2 = this.h;
                if (gVar2 != null) {
                    gVar2.c(this.i);
                    this.h.c(false);
                }
            }
            WeakReference<e> weakReference = this.B;
            e eVar = weakReference != null ? weakReference.get() : null;
            if (eVar != null) {
                eVar.a(this.F);
            }
        }
    }

    public void a(int i2) {
        if (D()) {
            boolean z2 = i2 == 0 || i2 == 8;
            Context context = this.a.get();
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
        com.bytedance.sdk.openadsdk.core.video.nativevideo.g gVar = this.h;
        if (gVar != null) {
            gVar.l();
        }
        a(true);
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.a
    public void a(b bVar, View view, boolean z2, boolean z3) {
        if (this.v) {
            b();
        }
        if (z2 && !this.v && !r()) {
            this.h.a(!s(), false);
            this.h.a(z3, true, false);
        }
        com.bytedance.sdk.openadsdk.core.video.c.d dVar = this.m;
        if (dVar == null || !dVar.g()) {
            this.h.d();
            return;
        }
        this.h.d();
        this.h.c();
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.a
    public void d(b bVar, View view) {
        if (this.F) {
            e(false);
            com.bytedance.sdk.openadsdk.core.video.nativevideo.g gVar = this.h;
            if (gVar != null) {
                gVar.c(this.i);
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
        H();
    }

    private void H() {
        if (D()) {
            e(!this.F);
            if (!(this.a.get() instanceof Activity)) {
                l.b("BaseVideoController", "context is not activity, not support this function.");
                return;
            }
            com.bytedance.sdk.openadsdk.core.video.nativevideo.g gVar = this.h;
            if (gVar != null) {
                gVar.c(this.i);
                this.h.c(false);
            }
            a(1);
            WeakReference<e> weakReference = this.B;
            e eVar = weakReference != null ? weakReference.get() : null;
            if (eVar != null) {
                eVar.a(this.F);
            }
        }
    }

    private void e(boolean z2) {
        this.F = z2;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.a
    public void a(b bVar, SurfaceHolder surfaceHolder) {
        this.r = true;
        com.bytedance.sdk.openadsdk.core.video.c.d dVar = this.m;
        if (dVar != null) {
            dVar.a(surfaceHolder);
            E();
        }
    }

    private com.bytedance.sdk.openadsdk.core.video.renderview.b I() {
        com.bytedance.sdk.openadsdk.core.video.nativevideo.g gVar;
        WeakReference<Context> weakReference = this.a;
        if (weakReference == null || weakReference.get() == null || this.a.get().getResources().getConfiguration().orientation != 1 || (gVar = this.h) == null) {
            return null;
        }
        return gVar.a();
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.a
    public void b(b bVar, SurfaceHolder surfaceHolder) {
        this.r = false;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.a
    public void a(b bVar, SurfaceTexture surfaceTexture) {
        this.r = true;
        com.bytedance.sdk.openadsdk.core.video.c.d dVar = this.m;
        if (dVar != null) {
            dVar.a(surfaceTexture);
            E();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.a
    public void b(b bVar, SurfaceTexture surfaceTexture) {
        this.r = false;
    }

    public boolean r() {
        return this.m.l();
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.a
    public void a() {
        com.bytedance.sdk.openadsdk.core.video.nativevideo.g gVar = this.h;
        if (gVar != null) {
            gVar.c();
            this.h.h();
        }
        com.bytedance.sdk.openadsdk.core.video.nativevideo.g gVar2 = this.h;
        if (gVar2 != null) {
            gVar2.i();
        }
        d(-1L);
        com.bytedance.sdk.openadsdk.core.video.c.d dVar = this.m;
        if (dVar != null) {
            dVar.n();
        }
    }

    public boolean s() {
        com.bytedance.sdk.openadsdk.core.video.c.d dVar = this.m;
        return dVar != null && dVar.g();
    }

    private void a(long j2, boolean z2) {
        if (this.m != null) {
            if (z2) {
                J();
            }
            this.m.a(j2);
        }
    }

    private boolean c(int i2) {
        return this.h.c(i2);
    }

    private void J() {
        com.bytedance.sdk.openadsdk.core.video.nativevideo.g gVar = this.h;
        if (gVar != null) {
            gVar.d(0);
            this.h.b(false, false);
            this.h.c(false);
            this.h.c();
            this.h.f();
        }
    }

    /* renamed from: com.bytedance.sdk.openadsdk.core.video.b.a$6  reason: invalid class name */
    /* compiled from: BaseVideoController */
    static /* synthetic */ class AnonymousClass6 {
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
                com.bytedance.sdk.openadsdk.core.video.b.a.AnonymousClass6.a = r0
                com.bytedance.sdk.openadsdk.core.widget.c$a r1 = com.bytedance.sdk.openadsdk.core.widget.c.a.PAUSE_VIDEO     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = com.bytedance.sdk.openadsdk.core.video.b.a.AnonymousClass6.a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.bytedance.sdk.openadsdk.core.widget.c$a r1 = com.bytedance.sdk.openadsdk.core.widget.c.a.RELEASE_VIDEO     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = com.bytedance.sdk.openadsdk.core.video.b.a.AnonymousClass6.a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.bytedance.sdk.openadsdk.core.widget.c$a r1 = com.bytedance.sdk.openadsdk.core.widget.c.a.START_VIDEO     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.video.b.a.AnonymousClass6.<clinit>():void");
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.d
    public void a(c.a aVar, String str) {
        int i2 = AnonymousClass6.a[aVar.ordinal()];
        if (i2 == 1) {
            b();
        } else if (i2 == 2) {
            a(true);
        } else if (i2 == 3) {
            d();
            this.y = false;
            this.z = true;
        }
    }

    private boolean d(int i2) {
        g gVar;
        int c2 = m.c(j.a());
        if (c2 != 4 && c2 != 0) {
            b();
            this.y = true;
            this.z = false;
            com.bytedance.sdk.openadsdk.core.video.nativevideo.g gVar2 = this.h;
            if (!(gVar2 == null || (gVar = this.b) == null)) {
                return gVar2.a(i2, gVar.e());
            }
        } else if (c2 == 4) {
            this.y = false;
            com.bytedance.sdk.openadsdk.core.video.nativevideo.g gVar3 = this.h;
            if (gVar3 != null) {
                gVar3.b();
            }
        }
        return true;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void b(Context context) {
        int c2;
        if (D() && this.I != (c2 = m.c(context))) {
            if (!this.z) {
                d(2);
            }
            this.I = c2;
        }
    }

    private void K() {
        if (!this.J) {
            Context applicationContext = j.a().getApplicationContext();
            this.J = true;
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            try {
                applicationContext.registerReceiver(this.H, intentFilter);
            } catch (Exception unused) {
            }
        }
    }

    private void L() {
        if (this.J) {
            Context applicationContext = j.a().getApplicationContext();
            this.J = false;
            try {
                applicationContext.unregisterReceiver(this.H);
            } catch (Exception unused) {
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public void c() {
        com.bytedance.sdk.openadsdk.core.video.c.d dVar = this.m;
        if (dVar != null) {
            dVar.d();
        }
    }

    /* access modifiers changed from: protected */
    public Map<String, Object> t() {
        HashMap hashMap = new HashMap();
        Map<String, Object> map = this.d;
        if (map != null) {
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                hashMap.put(entry.getKey(), entry.getValue());
            }
        }
        Map<String, Object> a2 = t.a(this.f, this.b, n());
        if (a2 != null) {
            for (Map.Entry<String, Object> entry2 : a2.entrySet()) {
                hashMap.put(entry2.getKey(), entry2.getValue());
            }
        }
        return hashMap;
    }

    /* access modifiers changed from: protected */
    public Map<String, Object> u() {
        HashMap hashMap = new HashMap();
        Map<String, Object> a2 = t.a(this.b, h(), n());
        if (a2 != null) {
            for (Map.Entry<String, Object> entry : a2.entrySet()) {
                hashMap.put(entry.getKey(), entry.getValue());
            }
        }
        Map<String, Object> map = this.d;
        if (map != null) {
            for (Map.Entry<String, Object> entry2 : map.entrySet()) {
                hashMap.put(entry2.getKey(), entry2.getValue());
            }
        }
        return hashMap;
    }
}
