package com.tapjoy.internal;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import com.tapjoy.TJContentActivity;
import com.tapjoy.TapjoyErrorMessage;
import com.tapjoy.TapjoyLog;
import com.tapjoy.internal.io;
import java.util.Iterator;

public class gv extends hg {
    private static final String h = gv.class.getSimpleName();
    private static gv i;
    final String a;
    final hr b;
    private final gz j;
    private boolean k;
    private boolean l;
    private long m;
    private Context n;
    private io o;
    private Activity p;
    private ha q;
    private Handler r;
    private Runnable s;

    public static void a() {
        gv gvVar = i;
        if (gvVar != null) {
            AnonymousClass1 r1 = new Runnable(gvVar) {
                /* class com.tapjoy.internal.gv.AnonymousClass1 */
                final /* synthetic */ gv a;

                {
                    this.a = r1;
                }

                public final void run() {
                    gv.a(this.a);
                }
            };
            Looper mainLooper = Looper.getMainLooper();
            if (mainLooper != null && mainLooper.getThread() == Thread.currentThread()) {
                r1.run();
            } else {
                u.a().post(r1);
            }
        }
    }

    public gv(gz gzVar, String str, hr hrVar, Context context) {
        this.j = gzVar;
        this.a = str;
        this.b = hrVar;
        this.n = context;
    }

    @Override // com.tapjoy.internal.hg
    public final void b() {
        Iterator it = this.b.a.iterator();
        while (it.hasNext()) {
            Iterator it2 = ((ia) it.next()).c.iterator();
            while (it2.hasNext()) {
                hz hzVar = (hz) it2.next();
                if (hzVar.l != null) {
                    hzVar.l.b();
                }
                if (hzVar.m != null) {
                    hzVar.m.b();
                }
            }
        }
    }

    @Override // com.tapjoy.internal.hg
    public final boolean c() {
        Iterator it = this.b.a.iterator();
        boolean z = true;
        while (it.hasNext()) {
            Iterator it2 = ((ia) it.next()).c.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    z = true;
                    continue;
                    break;
                }
                hz hzVar = (hz) it2.next();
                if ((hzVar.l == null || hzVar.l.a()) && (hzVar.m == null || hzVar.m.a())) {
                }
            }
            z = false;
            continue;
            if (!z) {
                return false;
            }
        }
        return z;
    }

    @Override // com.tapjoy.internal.hg
    public final void a(ha haVar, fw fwVar) {
        this.q = haVar;
        Activity a2 = gr.a();
        this.p = a2;
        if (a2 != null && !a2.isFinishing()) {
            try {
                a(this.p, haVar, fwVar);
                return;
            } catch (WindowManager.BadTokenException unused) {
            }
        }
        Activity a3 = a.a(this.n);
        this.p = a3;
        if (a3 != null && !a3.isFinishing()) {
            try {
                a(this.p, haVar, fwVar);
                return;
            } catch (WindowManager.BadTokenException unused2) {
            }
        }
        gw.b("Failed to show the content for \"{}\". No usable activity found.", this.a);
        haVar.a(this.a, this.f, null);
    }

    private void a(final Activity activity, final ha haVar, fw fwVar) {
        if (this.k) {
            TapjoyLog.e(h, new TapjoyErrorMessage(TapjoyErrorMessage.ErrorType.INTEGRATION_ERROR, "Content is already displayed"));
            return;
        }
        this.k = true;
        this.l = true;
        i = this;
        this.g = fwVar.a;
        this.o = new io(activity, this.b, new io.a() {
            /* class com.tapjoy.internal.gv.AnonymousClass2 */

            @Override // com.tapjoy.internal.io.a
            public final void a(hz hzVar) {
                fv fvVar;
                if (!(!(gv.this.g instanceof fv) || (fvVar = (fv) gv.this.g) == null || fvVar.c == null)) {
                    fvVar.c.a();
                }
                gv.this.j.a(gv.this.b.b, hzVar.k);
                if (!jq.c(hzVar.h)) {
                    gv.this.e.a(activity, hzVar.h, jq.b(hzVar.i));
                    gv.this.d = true;
                } else if (!jq.c(hzVar.g)) {
                    hg.a(activity, hzVar.g);
                }
                haVar.a(gv.this.a, null);
                if (hzVar.j) {
                    gv.a(gv.this);
                }
            }

            @Override // com.tapjoy.internal.io.a
            public final void a() {
                gv.a(gv.this);
            }
        });
        Window window = activity.getWindow();
        io ioVar = this.o;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1, 17);
        Window.Callback callback = window.getCallback();
        window.setCallback(null);
        window.addContentView(ioVar, layoutParams);
        window.setCallback(callback);
        this.m = SystemClock.elapsedRealtime();
        this.j.a(this.b.b);
        fwVar.a();
        fq fqVar = this.g;
        if (fqVar != null) {
            fqVar.b();
        }
        haVar.c(this.a);
        if (this.b.c > 0.0f) {
            this.r = new Handler(Looper.getMainLooper());
            AnonymousClass3 r5 = new Runnable() {
                /* class com.tapjoy.internal.gv.AnonymousClass3 */

                public final void run() {
                    gv.a(gv.this);
                }
            };
            this.s = r5;
            this.r.postDelayed(r5, (long) (this.b.c * 1000.0f));
        }
    }

    static /* synthetic */ void a(gv gvVar) {
        ha haVar;
        if (gvVar.l) {
            gvVar.l = false;
            Handler handler = gvVar.r;
            if (handler != null) {
                handler.removeCallbacks(gvVar.s);
                gvVar.s = null;
                gvVar.r = null;
            }
            if (i == gvVar) {
                i = null;
            }
            gvVar.j.a(gvVar.b.b, SystemClock.elapsedRealtime() - gvVar.m);
            if (!gvVar.d && (haVar = gvVar.q) != null) {
                haVar.a(gvVar.a, gvVar.f, null);
                gvVar.q = null;
            }
            ViewGroup viewGroup = (ViewGroup) gvVar.o.getParent();
            if (viewGroup != null) {
                viewGroup.removeView(gvVar.o);
            }
            gvVar.o = null;
            Activity activity = gvVar.p;
            if (activity instanceof TJContentActivity) {
                activity.finish();
            }
            gvVar.p = null;
        }
    }
}
