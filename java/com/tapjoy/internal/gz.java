package com.tapjoy.internal;

import android.content.Context;
import android.content.Intent;
import android.opengl.GLSurfaceView;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.util.Base64;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.tapjoy.TJAdUnitConstants;
import com.tapjoy.TapjoyConstants;
import com.tapjoy.internal.ev;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Executors;
import javax.annotation.Nullable;

public final class gz {
    private static final gz q;
    private static gz r;
    private static Handler w;
    private static File x;
    public final hh a = new hh(this);
    public hi b;
    public boolean c = false;
    public String d = null;
    public Context e;
    public hc f;
    public gy g;
    public hm h;
    public gx i;
    public String j;
    public boolean k;
    public String l;
    public String m;
    public boolean n = false;
    public String o;
    public ha p = ha.a((go) null);
    private boolean s = false;
    private boolean t = false;
    private String u;
    private String v;

    static {
        gz gzVar = new gz();
        q = gzVar;
        r = gzVar;
    }

    public static gz a() {
        return r;
    }

    private gz() {
    }

    public final synchronized void b(Context context) {
        if (this.e == null) {
            Context applicationContext = context.getApplicationContext();
            this.e = applicationContext;
            ga.a().a(applicationContext);
            this.f = hc.a(applicationContext);
            File file = new File(c(applicationContext), "events2");
            if (this.i == null) {
                this.i = new gx(file);
            }
            gy gyVar = new gy(this.f, this.i);
            this.g = gyVar;
            this.h = new hm(gyVar);
            this.b = new hi(applicationContext);
            gf.a(new gh(new File(c(applicationContext), "usages"), this.g));
            ht htVar = ht.a;
            htVar.b = applicationContext.getApplicationContext();
            htVar.c = applicationContext.getSharedPreferences("tapjoyCacheDataMMF2E", 0);
            htVar.d = applicationContext.getSharedPreferences("tapjoyCacheDataMMF2U", 0);
            htVar.a();
        }
    }

    public final fb a(boolean z) {
        if (z) {
            this.f.a();
        }
        return this.f.b();
    }

    public final synchronized void b() {
        if (this.k) {
            hb.b(this.e).e(this.d);
            a((String) null);
        }
    }

    public final synchronized void a(@Nullable final String str) {
        if (this.k) {
            if (str == null && this.o != null) {
                str = this.o;
            }
            this.o = null;
            if (str != null) {
                fb b2 = this.f.b();
                gw.a("GCM registration id of device {} updated for sender {}: {}", b2.d.h, this.d, str);
                new il(b2, str).a(new cf() {
                    /* class com.tapjoy.internal.gz.AnonymousClass1 */

                    @Override // com.tapjoy.internal.cf
                    public final void a(ca caVar) {
                    }

                    @Override // com.tapjoy.internal.cf
                    public final /* synthetic */ void a(ca caVar, Object obj) {
                        hb b2 = hb.b(gz.this.e);
                        if (str.equals(b2.b.b(b2.a))) {
                            b2.b.b(b2.a, true);
                            b2.b.a(b2.a, 0L);
                        }
                    }
                }, ca.a);
            }
        } else if (str != null) {
            this.o = str;
        }
    }

    public final void b(String str) {
        gy gyVar = this.g;
        ev.a a2 = gyVar.a(ey.APP, "push_ignore");
        a2.s = new fc(null, null, str);
        gyVar.a(a2);
    }

    public final boolean a(Context context, String str, boolean z) {
        long currentTimeMillis = System.currentTimeMillis();
        b(context);
        if (!this.f.a(str, currentTimeMillis, z)) {
            return false;
        }
        gy gyVar = this.g;
        ev.a a2 = gyVar.a(ey.APP, "push_show");
        a2.s = new fc(null, null, str);
        gyVar.a(a2);
        return true;
    }

    public static void a(GLSurfaceView gLSurfaceView) {
        if (gw.a(gLSurfaceView, "setGLSurfaceView: The given GLSurfaceView was null")) {
            gr.a(gLSurfaceView);
        }
    }

    public final Set c() {
        if (!d("getUserTags")) {
            return new HashSet();
        }
        return this.f.e();
    }

    public final void a(Set set) {
        if (d("setUserTags")) {
            if (set != null && !set.isEmpty()) {
                HashSet hashSet = new HashSet();
                Iterator it = set.iterator();
                while (it.hasNext()) {
                    String str = (String) it.next();
                    if (str != null) {
                        String trim = str.trim();
                        if (!trim.isEmpty() && trim.length() <= 200) {
                            hashSet.add(trim);
                            if (hashSet.size() >= 200) {
                                break;
                            }
                        }
                    }
                }
                set = hashSet;
            }
            hc hcVar = this.f;
            synchronized (hcVar) {
                if (set != null) {
                    if (!set.isEmpty()) {
                        hcVar.c.z.a(Base64.encodeToString(fg.c.b(new fg(new ArrayList(set))), 2));
                        hcVar.b.A.clear();
                        hcVar.b.A.addAll(set);
                    }
                }
                hcVar.c.z.c();
                hcVar.b.A.clear();
            }
        }
    }

    public final synchronized void a(Context context, String str, String str2, String str3, String str4, String str5) {
        boolean z;
        boolean z2;
        if (!this.k) {
            b(context);
            boolean z3 = true;
            if (gw.a(this.e != null, "The given context was null")) {
                if (str4 == null || str4.length() != 24 || !str4.matches("[0-9a-f]{24}")) {
                    gw.b("Invalid App ID: {}", str4);
                    z = false;
                } else {
                    z = true;
                }
                if (z) {
                    if (str5 == null || str5.length() != 20 || !str5.matches("[0-9A-Za-z\\-_]{20}")) {
                        gw.b("Invalid App Key: {}", str5);
                        z2 = false;
                    } else {
                        z2 = true;
                    }
                    if (z2) {
                        this.l = str;
                        this.m = str2;
                        this.u = str4;
                        this.v = str5;
                        try {
                            URL url = new URL(str3);
                            ce ceVar = new ce("TapjoySDK" + " " + str2 + " (" + Build.MODEL + "; Android " + Build.VERSION.RELEASE + "; " + Locale.getDefault() + ")", url);
                            ca.b = ceVar;
                            ca.a = Executors.newCachedThreadPool();
                            gx gxVar = this.i;
                            gxVar.b = ceVar;
                            gxVar.a();
                            this.k = true;
                            hd hdVar = new hd(d(this.e));
                            if (hdVar.b() == null) {
                                z3 = false;
                            }
                            if (!z3 && hdVar.a()) {
                                gy gyVar = this.g;
                                gyVar.a(gyVar.a(ey.APP, "install"));
                            }
                            hc hcVar = this.f;
                            if (!jq.c(str4) && !str4.equals(hcVar.c.D.a())) {
                                hcVar.c.D.a(str4);
                                hcVar.c.a(false);
                            }
                            b();
                        } catch (MalformedURLException e2) {
                            throw new IllegalArgumentException(e2);
                        }
                    }
                }
            }
        }
    }

    public final boolean c(String str) {
        if ((this.k || this.j != null) && this.e != null) {
            return true;
        }
        if (!gw.a) {
            return false;
        }
        gw.b(str + ": Should be called after initializing the SDK");
        return false;
    }

    public final boolean d(String str) {
        if (this.e != null) {
            return true;
        }
        if (!gw.a) {
            return false;
        }
        gw.b(str + ": Should be called after initializing the SDK");
        return false;
    }

    public final boolean d() {
        hm hmVar = this.h;
        return hmVar != null && hmVar.b.get();
    }

    public final boolean e() {
        boolean z;
        hm hmVar = this.h;
        if (hmVar.c != null) {
            hmVar.c.cancel(false);
            hmVar.c = null;
        }
        if (hmVar.b.compareAndSet(false, true)) {
            gw.a("New session started");
            gy gyVar = hmVar.a;
            fc d2 = gyVar.a.d();
            hc hcVar = gyVar.a;
            synchronized (hcVar) {
                int b2 = hcVar.c.h.b() + 1;
                hcVar.c.h.a(b2);
                hcVar.b.h = Integer.valueOf(b2);
            }
            ev.a a2 = gyVar.a(ey.APP, "bootup");
            gyVar.c = SystemClock.elapsedRealtime();
            if (d2 != null) {
                a2.s = d2;
            }
            gyVar.a(a2);
            fs.c.notifyObservers();
            z = true;
        } else {
            z = false;
        }
        if (!z) {
            return false;
        }
        hh hhVar = this.a;
        synchronized (hhVar) {
            hhVar.b = null;
        }
        ht.a.a();
        return true;
    }

    /* access modifiers changed from: package-private */
    public final void a(Map map) {
        gy gyVar = this.g;
        ev.a a2 = gyVar.a(ey.CAMPAIGN, "impression");
        if (map != null) {
            a2.r = bh.a((Object) map);
        }
        gyVar.a(a2);
    }

    /* access modifiers changed from: package-private */
    public final void a(Map map, long j2) {
        gy gyVar = this.g;
        ev.a a2 = gyVar.a(ey.CAMPAIGN, ViewHierarchyConstants.VIEW_KEY);
        a2.i = Long.valueOf(j2);
        if (map != null) {
            a2.r = bh.a((Object) map);
        }
        gyVar.a(a2);
    }

    /* access modifiers changed from: package-private */
    public final void a(Map map, String str) {
        gy gyVar = this.g;
        ev.a a2 = gyVar.a(ey.CAMPAIGN, TJAdUnitConstants.String.CLICK);
        LinkedHashMap linkedHashMap = new LinkedHashMap(map);
        linkedHashMap.put("region", str);
        a2.r = bh.a((Object) linkedHashMap);
        gyVar.a(a2);
    }

    public static synchronized void a(Runnable runnable) {
        synchronized (gz.class) {
            if (w == null) {
                w = new Handler(Looper.getMainLooper());
            }
            w.post(runnable);
        }
    }

    public static synchronized File c(Context context) {
        File file;
        synchronized (gz.class) {
            if (x == null) {
                x = context.getDir("fiverocks", 0);
            }
            file = x;
        }
        return file;
    }

    static File d(Context context) {
        return new File(c(context), "install");
    }

    public static String a(Context context, Intent intent) {
        String a2 = d.a(intent);
        if (a2 != null) {
            gz gzVar = r;
            gzVar.b(context);
            if (jq.c(gzVar.f.c()) || intent.getBooleanExtra("fiverocks:force", false)) {
                hc hcVar = gzVar.f;
                synchronized (hcVar) {
                    hcVar.c.d.a(a2);
                    hcVar.b.d = a2;
                }
                if (a2.length() > 0) {
                    gy gyVar = gzVar.g;
                    gyVar.a(gyVar.a(ey.APP, TapjoyConstants.TJC_REFERRER));
                }
            }
        }
        return a2;
    }

    public static gz a(Context context) {
        gz gzVar = r;
        gzVar.b(context);
        return gzVar;
    }
}
