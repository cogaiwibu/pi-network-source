package com.tapjoy.internal;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import com.tapjoy.TapjoyLog;
import com.tapjoy.internal.gf;
import java.util.HashMap;
import java.util.Map;

public abstract class fq {
    private static final String c = fq.class.getSimpleName();
    public final Map a = new HashMap();
    public final Map b = new HashMap();

    protected fq(String str, String str2, String str3) {
        this.a.put(IronSourceConstants.EVENTS_PLACEMENT_NAME, str);
        this.a.put("placement_type", str2);
        this.a.put(FirebaseAnalytics.Param.CONTENT_TYPE, str3);
    }

    /* access modifiers changed from: protected */
    public final gf.a a(String str, Map map, Map map2) {
        gf.a b2 = gf.e(str).a().a(this.a).a(map).b(map2);
        this.b.put(str, b2);
        return b2;
    }

    public final void a(String str, Object obj) {
        this.a.put(str, obj);
    }

    /* access modifiers changed from: protected */
    public final gf.a b(String str, Map map, Map map2) {
        gf.a aVar = !al.a(str) ? (gf.a) this.b.remove(str) : null;
        if (aVar == null) {
            String str2 = c;
            TapjoyLog.e(str2, "Error when calling endTrackingEvent -- " + str + " tracking has not been started.");
        } else {
            aVar.a(this.a).a(map).b(map2).b().c();
        }
        return aVar;
    }

    public final gf.a a() {
        return a("Content.rendered", null, null);
    }

    public final gf.a b() {
        return b("Content.rendered", null, null);
    }
}
