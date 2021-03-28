package com.tapjoy.internal;

import android.content.SharedPreferences;
import android.os.SystemClock;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tapjoy.internal.ev;
import com.tapjoy.internal.ex;
import com.tapjoy.internal.fd;
import java.util.Map;
import javax.annotation.Nullable;

public final class gy {
    final hc a;
    final gx b;
    long c;
    private int d = 1;
    private final ex.a e = new ex.a();

    gy(hc hcVar, gx gxVar) {
        this.a = hcVar;
        this.b = gxVar;
    }

    public final void a(String str, String str2, double d2, @Nullable String str3, @Nullable String str4, @Nullable String str5) {
        double d3;
        hc hcVar = this.a;
        synchronized (hcVar) {
            SharedPreferences.Editor a2 = hcVar.c.a();
            int i = 1;
            if (str2.equals(hcVar.c.l.a())) {
                i = 1 + hcVar.c.m.b();
                hcVar.c.m.a(a2, i);
                d3 = hcVar.c.n.a() + d2;
                hcVar.c.n.a(a2, d3);
                a2.apply();
            } else {
                hcVar.c.l.a(a2, str2);
                hcVar.c.m.a(a2, 1);
                hcVar.c.n.a(a2, d2);
                hcVar.c.o.a(a2);
                hcVar.c.p.a(a2);
                a2.apply();
                hcVar.b.l = str2;
                hcVar.b.o = null;
                hcVar.b.p = null;
                d3 = d2;
            }
            hcVar.b.m = Integer.valueOf(i);
            hcVar.b.n = Double.valueOf(d3);
        }
        ev.a a3 = a(ey.APP, FirebaseAnalytics.Event.PURCHASE);
        fd.a aVar = new fd.a();
        aVar.c = str;
        if (str2 != null) {
            aVar.f = str2;
        }
        aVar.e = Double.valueOf(d2);
        if (str5 != null) {
            aVar.m = str5;
        }
        if (str3 != null) {
            aVar.o = str3;
        }
        if (str4 != null) {
            aVar.p = str4;
        }
        a3.p = aVar.b();
        a(a3);
        hc hcVar2 = this.a;
        long longValue = a3.e.longValue();
        synchronized (hcVar2) {
            SharedPreferences.Editor a4 = hcVar2.c.a();
            hcVar2.c.o.a(a4, longValue);
            hcVar2.c.p.a(a4, d2);
            a4.apply();
            hcVar2.b.o = Long.valueOf(longValue);
            hcVar2.b.p = Double.valueOf(d2);
        }
    }

    public final void a(String str, String str2, String str3, String str4, Map map) {
        ev.a a2 = a(ey.CUSTOM, str2);
        a2.t = str;
        a2.u = str3;
        a2.v = str4;
        if (map != null) {
            for (Map.Entry entry : map.entrySet()) {
                a2.w.add(new ez((String) entry.getKey(), (Long) entry.getValue()));
            }
        }
        a(a2);
    }

    public final void a(String str, String str2, int i, long j, long j2, Map map) {
        ev.a a2 = a(ey.USAGES, str);
        a2.x = str2;
        a2.y = Integer.valueOf(i);
        a2.z = Long.valueOf(j);
        a2.A = Long.valueOf(j2);
        if (map != null) {
            for (Map.Entry entry : map.entrySet()) {
                a2.w.add(new ez((String) entry.getKey(), (Long) entry.getValue()));
            }
        }
        a(a2);
    }

    public final ev.a a(ey eyVar, String str) {
        fb b2 = this.a.b();
        ev.a aVar = new ev.a();
        aVar.g = hc.a;
        aVar.c = eyVar;
        aVar.d = str;
        if (v.c()) {
            aVar.e = Long.valueOf(v.b());
            aVar.f = Long.valueOf(System.currentTimeMillis());
        } else {
            aVar.e = Long.valueOf(System.currentTimeMillis());
            aVar.h = Long.valueOf(SystemClock.elapsedRealtime());
        }
        aVar.j = b2.d;
        aVar.k = b2.e;
        aVar.l = b2.f;
        return aVar;
    }

    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0046 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void a(com.tapjoy.internal.ev.a r5) {
        /*
        // Method dump skipped, instructions count: 120
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tapjoy.internal.gy.a(com.tapjoy.internal.ev$a):void");
    }
}
