package com.bytedance.sdk.openadsdk.core.video.c;

import android.graphics.SurfaceTexture;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.SystemClock;
import android.util.SparseIntArray;
import android.view.SurfaceHolder;
import com.bytedance.sdk.openadsdk.core.j;
import com.bytedance.sdk.openadsdk.core.video.a.a;
import com.bytedance.sdk.openadsdk.core.video.c.c;
import com.bytedance.sdk.openadsdk.g.l;
import com.bytedance.sdk.openadsdk.g.v;
import com.facebook.appevents.AppEventsConstants;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: SSMediaPlayerWrapper */
public class d implements c.a, c.b, c.AbstractC0005c, c.d, c.e, c.f, c.g, v.a {
    private static boolean m = false;
    private static final SparseIntArray o = new SparseIntArray();
    private c a;
    private boolean b;
    private boolean c;
    private boolean d;
    private boolean e;
    private int f;
    private long g;
    private final Handler h;
    private Handler i;
    private ArrayList<Runnable> j;
    private int k;
    private int l;
    private String n;
    private boolean p;
    private final Object q;
    private StringBuilder r;
    private boolean s;
    private long t;
    private long u;
    private long v;
    private long w;
    private boolean x;

    public d(Handler handler) {
        this(handler, -1);
    }

    public d(Handler handler, int i2) {
        this.a = null;
        boolean z = false;
        this.b = false;
        this.c = false;
        this.f = 201;
        this.g = -1;
        this.k = 0;
        this.n = AppEventsConstants.EVENT_PARAM_VALUE_NO;
        this.q = new Object();
        this.r = null;
        this.s = false;
        this.t = 0;
        this.u = 0;
        this.v = 0;
        this.w = 0;
        this.x = false;
        this.k = 0;
        this.i = handler;
        HandlerThread handlerThread = new HandlerThread("VideoManager");
        handlerThread.start();
        this.h = new v(handlerThread.getLooper(), this);
        this.x = Build.VERSION.SDK_INT >= 17 ? true : z;
        r();
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void r() {
        if (this.a == null) {
            l.b("SSMediaPlayeWrapper", "SSMediaPlayerWrapper use System Mediaplayer");
            b bVar = new b();
            this.a = bVar;
            this.n = AppEventsConstants.EVENT_PARAM_VALUE_NO;
            bVar.a((c.e) this);
            this.a.a((c.b) this);
            this.a.a((c.AbstractC0005c) this);
            this.a.a((c.a) this);
            this.a.a((c.f) this);
            this.a.a((c.d) this);
            this.a.a((c.g) this);
            try {
                this.a.b(this.b);
            } catch (Throwable th) {
                l.a("SSMediaPlayeWrapper", "setLooping error: ", th);
            }
            this.c = false;
        }
    }

    public MediaPlayer a() throws Throwable {
        c cVar = this.a;
        if (cVar != null) {
            return ((b) cVar).e();
        }
        return null;
    }

    public void a(boolean z, long j2, boolean z2) {
        this.p = false;
        if (!z2) {
            if (this.a != null) {
                a(true);
            }
        } else if (this.a != null) {
            a(false);
        }
        if (z) {
            s();
            this.g = j2;
            return;
        }
        D();
        c cVar = this.a;
        if (cVar != null) {
            try {
                if (j2 <= cVar.i()) {
                    j2 = this.a.i();
                }
                this.g = j2;
            } catch (Throwable th) {
                l.a("SSMediaPlayeWrapper", " error: getCurrentPosition", th);
            }
        }
        b(new Runnable() {
            /* class com.bytedance.sdk.openadsdk.core.video.c.d.AnonymousClass1 */

            public void run() {
                d.this.h.sendEmptyMessageDelayed(100, 0);
            }
        });
    }

    public void b() {
        this.h.removeMessages(100);
        this.p = true;
        this.h.sendEmptyMessage(101);
        E();
    }

    public void c() {
        this.f = 203;
        E();
        A();
        if (this.h != null) {
            try {
                b("release");
                this.h.removeCallbacksAndMessages(null);
                if (this.a != null) {
                    this.e = true;
                    this.h.sendEmptyMessage(103);
                }
            } catch (Throwable th) {
                u();
                l.a("SSMediaPlayeWrapper", "release error: ", th);
            }
        }
    }

    private void s() {
        b(new Runnable() {
            /* class com.bytedance.sdk.openadsdk.core.video.c.d.AnonymousClass2 */

            public void run() {
                if (d.this.h != null) {
                    d.this.h.sendEmptyMessage(104);
                }
            }
        });
    }

    public void d() {
        b(new Runnable() {
            /* class com.bytedance.sdk.openadsdk.core.video.c.d.AnonymousClass3 */

            public void run() {
                if (d.this.h != null) {
                    d.this.h.sendEmptyMessage(105);
                }
            }
        });
    }

    public void a(final long j2) {
        E();
        int i2 = this.f;
        if (i2 == 207 || i2 == 206 || i2 == 209) {
            b(new Runnable() {
                /* class com.bytedance.sdk.openadsdk.core.video.c.d.AnonymousClass4 */

                public void run() {
                    if (d.this.h != null) {
                        d.this.h.obtainMessage(106, Long.valueOf(j2)).sendToTarget();
                    }
                }
            });
        }
    }

    public void a(final SurfaceTexture surfaceTexture) {
        b(new Runnable() {
            /* class com.bytedance.sdk.openadsdk.core.video.c.d.AnonymousClass5 */

            public void run() {
                d.this.r();
                if (d.this.h != null) {
                    d.this.h.obtainMessage(111, surfaceTexture).sendToTarget();
                }
            }
        });
    }

    public void a(final SurfaceHolder surfaceHolder) {
        b(new Runnable() {
            /* class com.bytedance.sdk.openadsdk.core.video.c.d.AnonymousClass6 */

            public void run() {
                d.this.r();
                if (d.this.h != null) {
                    d.this.h.obtainMessage(110, surfaceHolder).sendToTarget();
                }
            }
        });
    }

    public void e() {
        Handler handler = this.h;
        if (handler != null) {
            handler.obtainMessage(108).sendToTarget();
        }
    }

    public void f() {
        Handler handler = this.h;
        if (handler != null) {
            handler.obtainMessage(109).sendToTarget();
        }
    }

    public void a(final a aVar) {
        b(new Runnable() {
            /* class com.bytedance.sdk.openadsdk.core.video.c.d.AnonymousClass7 */

            public void run() {
                d.this.r();
                if (d.this.h != null) {
                    d.this.h.obtainMessage(107, aVar).sendToTarget();
                }
            }
        });
    }

    public boolean g() {
        return (this.f == 206 || this.h.hasMessages(100)) && !this.p;
    }

    public boolean h() {
        return k() || g() || i();
    }

    public boolean i() {
        return (this.f == 207 || this.p) && !this.h.hasMessages(100);
    }

    public boolean j() {
        return this.f == 203;
    }

    public boolean k() {
        return this.f == 205;
    }

    public boolean l() {
        return this.f == 209;
    }

    public boolean m() {
        return this.f == 202;
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARNING: Removed duplicated region for block: B:149:0x027a  */
    /* JADX WARNING: Removed duplicated region for block: B:153:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0093  */
    @Override // com.bytedance.sdk.openadsdk.g.v.a
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(android.os.Message r17) {
        /*
        // Method dump skipped, instructions count: 682
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.video.c.d.a(android.os.Message):void");
    }

    private void a(String str) throws Throwable {
        FileInputStream fileInputStream = new FileInputStream(str);
        this.a.a(fileInputStream.getFD());
        fileInputStream.close();
    }

    private void t() {
        c cVar = this.a;
        if (cVar != null) {
            try {
                cVar.l();
            } catch (Throwable th) {
                l.a("SSMediaPlayeWrapper", "releaseMediaplayer error1: ", th);
            }
            this.a.a((c.b) null);
            this.a.a((c.g) null);
            this.a.a((c.a) null);
            this.a.a((c.d) null);
            this.a.a((c.AbstractC0005c) null);
            this.a.a((c.e) null);
            this.a.a((c.f) null);
            try {
                this.a.k();
            } catch (Throwable th2) {
                l.a("SSMediaPlayeWrapper", "releaseMediaplayer error2: ", th2);
            }
        }
    }

    private void u() {
        Handler handler = this.h;
        if (handler != null && handler.getLooper() != null) {
            try {
                l.b("SSMediaPlayeWrapper", "onDestory............");
                this.h.getLooper().quit();
            } catch (Throwable th) {
                l.a("SSMediaPlayeWrapper", "onDestroy error: ", th);
            }
        }
    }

    private void a(int i2, Object obj) {
        if (i2 == 309) {
            C();
        }
        Handler handler = this.i;
        if (handler != null) {
            handler.obtainMessage(i2, obj).sendToTarget();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.c.c.a
    public void a(c cVar, int i2) {
        Handler handler;
        if (this.a == cVar && (handler = this.i) != null) {
            handler.obtainMessage(301, Integer.valueOf(i2)).sendToTarget();
        }
    }

    private void v() {
        Integer valueOf = Integer.valueOf(o.get(this.k));
        if (valueOf == null) {
            o.put(this.k, 1);
        } else {
            o.put(this.k, Integer.valueOf(valueOf.intValue() + 1).intValue());
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.c.c.b
    public void a(c cVar) {
        this.f = !this.b ? 209 : 206;
        o.delete(this.k);
        Handler handler = this.i;
        if (handler != null) {
            handler.obtainMessage(IronSourceConstants.OFFERWALL_AVAILABLE).sendToTarget();
        }
        b("completion");
        E();
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.c.c.AbstractC0005c
    public boolean a(c cVar, int i2, int i3) {
        l.e("SSMediaPlayeWrapper", "what=" + i2 + "extra=" + i3);
        v();
        this.f = 200;
        Handler handler = this.i;
        if (handler != null) {
            handler.obtainMessage(303, i2, i3).sendToTarget();
        }
        Handler handler2 = this.h;
        if (handler2 != null) {
            handler2.removeMessages(108);
            this.h.removeMessages(109);
        }
        if (!this.c) {
            a(308, Integer.valueOf(i2));
            this.c = true;
        }
        if (a(i2, i3)) {
            u();
        }
        return true;
    }

    private boolean a(int i2, int i3) {
        l.b("SSMediaPlayeWrapper", "OnError - Error code: " + i2 + " Extra code: " + i3);
        boolean z = i2 == -1010 || i2 == -1007 || i2 == -1004 || i2 == -110 || i2 == 100 || i2 == 200;
        if (i3 == 1 || i3 == 700 || i3 == 800) {
            return true;
        }
        return z;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.c.c.d
    public boolean b(c cVar, int i2, int i3) {
        l.e("SSMediaPlayeWrapper", "what,extra:" + i2 + "," + i3);
        if (this.a != cVar) {
            return false;
        }
        Handler handler = this.i;
        if (handler != null) {
            handler.obtainMessage(304, i2, i3).sendToTarget();
            if (i3 == -1004) {
                this.i.obtainMessage(303, i2, i3).sendToTarget();
            }
        }
        b(i2, i3);
        return false;
    }

    private void b(int i2, int i3) {
        if (i2 == 701) {
            E();
            this.v = SystemClock.elapsedRealtime();
        } else if (i2 == 702) {
            if (this.u <= 0) {
                this.u = System.currentTimeMillis();
            }
            if (this.v > 0) {
                this.w += SystemClock.elapsedRealtime() - this.v;
                this.v = 0;
            }
        } else if (this.x && i2 == 3 && this.u <= 0) {
            this.u = System.currentTimeMillis();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.c.c.e
    public void b(c cVar) {
        this.f = 205;
        if (this.p) {
            this.h.post(new Runnable() {
                /* class com.bytedance.sdk.openadsdk.core.video.c.d.AnonymousClass8 */

                public void run() {
                    try {
                        d.this.a.h();
                        d.this.f = 207;
                        d.this.p = false;
                    } catch (Throwable th) {
                        l.a("SSMediaPlayeWrapper", "onPrepared error: ", th);
                    }
                }
            });
        } else {
            Handler handler = this.h;
            handler.sendMessage(handler.obtainMessage(100, -1, -1));
        }
        o.delete(this.k);
        Handler handler2 = this.i;
        if (handler2 != null) {
            handler2.sendEmptyMessage(IronSourceConstants.OFFERWALL_OPENED);
        }
        w();
    }

    private void w() {
        if (!this.x && this.u <= 0) {
            this.u = System.currentTimeMillis();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.c.c.f
    public void c(c cVar) {
        Handler handler = this.i;
        if (handler != null) {
            handler.sendEmptyMessage(306);
        }
    }

    private void a(Runnable runnable) {
        if (this.j == null) {
            this.j = new ArrayList<>();
        }
        this.j.add(runnable);
    }

    private void x() {
        if (!this.d) {
            this.d = true;
            Iterator it = new ArrayList(this.j).iterator();
            while (it.hasNext()) {
                ((Runnable) it.next()).run();
            }
            this.j.clear();
            this.d = false;
        }
    }

    private void y() {
        ArrayList<Runnable> arrayList = this.j;
        if (arrayList != null && !arrayList.isEmpty()) {
            x();
        }
    }

    private void z() {
        ArrayList<Runnable> arrayList = this.j;
        if (arrayList == null || arrayList.isEmpty()) {
            u();
        } else {
            x();
        }
    }

    private void A() {
        ArrayList<Runnable> arrayList = this.j;
        if (arrayList != null && !arrayList.isEmpty()) {
            this.j.clear();
        }
    }

    private void b(Runnable runnable) {
        if (runnable != null) {
            if (!this.e) {
                runnable.run();
            } else {
                a(runnable);
            }
        }
    }

    private void a(int i2, boolean z) {
        int B;
        if (z && (B = B()) != i2) {
            m = true;
            this.l = B;
        }
        AudioManager audioManager = (AudioManager) j.a().getSystemService("audio");
        if (audioManager != null) {
            audioManager.setStreamVolume(3, i2, 0);
        }
    }

    private int B() {
        AudioManager audioManager = (AudioManager) j.a().getSystemService("audio");
        if (audioManager != null) {
            return audioManager.getStreamVolume(3);
        }
        return -1;
    }

    private void C() {
        if (m) {
            a(this.l, false);
            m = false;
        }
    }

    public void a(boolean z) {
        if (z) {
            try {
                this.a.a(0.0f, 0.0f);
            } catch (Throwable th) {
                l.a("SSMediaPlayeWrapper", "setQuietPlay error: ", th);
            }
        } else {
            this.a.a(1.0f, 1.0f);
        }
    }

    private void b(String str) {
        Handler handler = this.h;
        if (handler != null) {
            handler.removeMessages(201);
        }
        synchronized (this.q) {
            if (this.r != null) {
                this.r = null;
            }
        }
    }

    private void D() {
        if (this.u <= 0) {
            this.u = System.currentTimeMillis();
        }
    }

    public void n() {
        this.t = 0;
        this.u = System.currentTimeMillis();
    }

    private void E() {
        if (this.u > 0) {
            this.t += System.currentTimeMillis() - this.u;
            this.u = 0;
        }
    }

    public long o() {
        return this.w;
    }

    public long p() {
        E();
        return this.t;
    }

    public long q() {
        if (this.u > 0) {
            this.t += System.currentTimeMillis() - this.u;
            this.u = System.currentTimeMillis();
        }
        return this.t;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.c.c.g
    public void a(c cVar, int i2, int i3, int i4, int i5) {
        Handler handler = this.i;
        if (handler != null) {
            handler.obtainMessage(311, i2, i3).sendToTarget();
        }
    }
}
