package com.tapjoy.internal;

import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewParent;
import com.tapjoy.internal.di;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

public final class dv implements di.a {
    public static Handler a = new Handler(Looper.getMainLooper());
    private static dv c = new dv();
    private static Handler d = null;
    private static final Runnable j = new Runnable() {
        /* class com.tapjoy.internal.dv.AnonymousClass2 */

        public final void run() {
            dv.b(dv.a());
        }
    };
    private static final Runnable k = new Runnable() {
        /* class com.tapjoy.internal.dv.AnonymousClass3 */

        public final void run() {
            if (dv.d != null) {
                dv.d.post(dv.j);
                dv.d.postDelayed(dv.k, 200);
            }
        }
    };
    public List b = new ArrayList();
    private int e;
    private dj f = new dj();
    private dw g = new dw();
    private ed h = new ed(new dz());
    private long i;

    dv() {
    }

    public static dv a() {
        return c;
    }

    private void a(long j2) {
        if (this.b.size() > 0) {
            Iterator it = this.b.iterator();
            while (it.hasNext()) {
                it.next();
                TimeUnit.NANOSECONDS.toMillis(j2);
            }
        }
    }

    private void a(View view, di diVar, JSONObject jSONObject, int i2) {
        diVar.a(view, jSONObject, this, i2 == ee.a);
    }

    public static void b() {
        if (d == null) {
            Handler handler = new Handler(Looper.getMainLooper());
            d = handler;
            handler.post(j);
            d.postDelayed(k, 200);
        }
    }

    public static void c() {
        Handler handler = d;
        if (handler != null) {
            handler.removeCallbacks(k);
            d = null;
        }
    }

    @Override // com.tapjoy.internal.di.a
    public final void a(View view, di diVar, JSONObject jSONObject) {
        String str;
        boolean z = false;
        if (dp.c(view) == null) {
            dw dwVar = this.g;
            int i2 = dwVar.d.contains(view) ? ee.a : dwVar.h ? ee.b : ee.c;
            if (i2 != ee.c) {
                JSONObject a2 = diVar.a(view);
                dm.a(jSONObject, a2);
                dw dwVar2 = this.g;
                ArrayList arrayList = null;
                if (dwVar2.a.size() == 0) {
                    str = null;
                } else {
                    str = (String) dwVar2.a.get(view);
                    if (str != null) {
                        dwVar2.a.remove(view);
                    }
                }
                if (str != null) {
                    dm.a(a2, str);
                    this.g.h = true;
                    z = true;
                }
                if (!z) {
                    dw dwVar3 = this.g;
                    if (!(dwVar3.c.size() == 0 || (arrayList = (ArrayList) dwVar3.c.get(view)) == null)) {
                        dwVar3.c.remove(view);
                        Collections.sort(arrayList);
                    }
                    if (arrayList != null) {
                        dm.a(a2, arrayList);
                    }
                    a(view, diVar, a2, i2);
                }
                this.e++;
            }
        }
    }

    static /* synthetic */ void b(dv dvVar) {
        String str;
        dvVar.e = 0;
        dvVar.i = System.nanoTime();
        dw dwVar = dvVar.g;
        dd a2 = dd.a();
        if (a2 != null) {
            for (cz czVar : Collections.unmodifiableCollection(a2.b)) {
                View c2 = czVar.c();
                if (czVar.d()) {
                    String str2 = czVar.f;
                    if (c2 != null) {
                        if (!c2.hasWindowFocus()) {
                            str = "noWindowFocus";
                        } else {
                            HashSet hashSet = new HashSet();
                            View view = c2;
                            while (true) {
                                if (view == null) {
                                    dwVar.d.addAll(hashSet);
                                    str = null;
                                    break;
                                }
                                String c3 = dp.c(view);
                                if (c3 != null) {
                                    str = c3;
                                    break;
                                }
                                hashSet.add(view);
                                ViewParent parent = view.getParent();
                                view = parent instanceof View ? (View) parent : null;
                            }
                        }
                        if (str == null) {
                            dwVar.e.add(str2);
                            dwVar.a.put(c2, str2);
                            dwVar.a(czVar);
                        } else {
                            dwVar.f.add(str2);
                            dwVar.b.put(str2, c2);
                            dwVar.g.put(str2, str);
                        }
                    } else {
                        dwVar.f.add(str2);
                        dwVar.g.put(str2, "noAdView");
                    }
                }
            }
        }
        long nanoTime = System.nanoTime();
        dk dkVar = dvVar.f.b;
        if (dvVar.g.f.size() > 0) {
            Iterator it = dvVar.g.f.iterator();
            while (it.hasNext()) {
                String str3 = (String) it.next();
                JSONObject a3 = dkVar.a(null);
                View view2 = (View) dvVar.g.b.get(str3);
                dl dlVar = dvVar.f.a;
                String str4 = (String) dvVar.g.g.get(str3);
                if (str4 != null) {
                    JSONObject a4 = dlVar.a(view2);
                    dm.a(a4, str3);
                    dm.b(a4, str4);
                    dm.a(a3, a4);
                }
                dm.a(a3);
                HashSet hashSet2 = new HashSet();
                hashSet2.add(str3);
                ed edVar = dvVar.h;
                edVar.a.a(new eb(edVar, hashSet2, a3, nanoTime));
            }
        }
        if (dvVar.g.e.size() > 0) {
            JSONObject a5 = dkVar.a(null);
            dvVar.a(null, dkVar, a5, ee.a);
            dm.a(a5);
            ed edVar2 = dvVar.h;
            edVar2.a.a(new ec(edVar2, dvVar.g.e, a5, nanoTime));
        } else {
            dvVar.h.b();
        }
        dw dwVar2 = dvVar.g;
        dwVar2.a.clear();
        dwVar2.b.clear();
        dwVar2.c.clear();
        dwVar2.d.clear();
        dwVar2.e.clear();
        dwVar2.f.clear();
        dwVar2.g.clear();
        dwVar2.h = false;
        dvVar.a(System.nanoTime() - dvVar.i);
    }
}
