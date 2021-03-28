package com.tapjoy.internal;

import android.graphics.Point;
import android.os.SystemClock;
import com.google.firebase.messaging.Constants;
import com.tapjoy.TapjoyConstants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import javax.annotation.Nullable;

public final class hu extends hq {
    public static final bi n = new bi() {
        /* class com.tapjoy.internal.hu.AnonymousClass1 */

        @Override // com.tapjoy.internal.bi
        public final /* synthetic */ Object a(bn bnVar) {
            return new hu(bnVar);
        }
    };
    @Nullable
    public hx a;
    @Nullable
    public hx b;
    public hx c;
    @Nullable
    public Point d;
    @Nullable
    public hx e;
    @Nullable
    public hx f;
    public String g;
    @Nullable
    public gl h;
    public ArrayList i = new ArrayList();
    public ArrayList j = new ArrayList();
    public Map k;
    public long l;
    @Nullable
    public hv m;

    public hu() {
    }

    hu(bn bnVar) {
        bnVar.h();
        String str = null;
        String str2 = null;
        while (bnVar.j()) {
            String l2 = bnVar.l();
            if ("frame".equals(l2)) {
                bnVar.h();
                while (bnVar.j()) {
                    String l3 = bnVar.l();
                    if ("portrait".equals(l3)) {
                        this.a = (hx) hx.e.a(bnVar);
                    } else if ("landscape".equals(l3)) {
                        this.b = (hx) hx.e.a(bnVar);
                    } else if ("close_button".equals(l3)) {
                        this.c = (hx) hx.e.a(bnVar);
                    } else if ("close_button_offset".equals(l3)) {
                        this.d = (Point) bj.a.a(bnVar);
                    } else {
                        bnVar.s();
                    }
                }
                bnVar.i();
            } else if ("creative".equals(l2)) {
                bnVar.h();
                while (bnVar.j()) {
                    String l4 = bnVar.l();
                    if ("portrait".equals(l4)) {
                        this.e = (hx) hx.e.a(bnVar);
                    } else if ("landscape".equals(l4)) {
                        this.f = (hx) hx.e.a(bnVar);
                    } else {
                        bnVar.s();
                    }
                }
                bnVar.i();
            } else if ("url".equals(l2)) {
                this.g = bnVar.b();
            } else if (ho.a(l2)) {
                this.h = ho.a(l2, bnVar);
            } else if ("mappings".equals(l2)) {
                bnVar.h();
                while (bnVar.j()) {
                    String l5 = bnVar.l();
                    if ("portrait".equals(l5)) {
                        bnVar.a(this.i, hs.h);
                    } else if ("landscape".equals(l5)) {
                        bnVar.a(this.j, hs.h);
                    } else {
                        bnVar.s();
                    }
                }
                bnVar.i();
            } else if ("meta".equals(l2)) {
                this.k = bnVar.d();
            } else if (Constants.FirelogAnalytics.PARAM_TTL.equals(l2)) {
                this.l = SystemClock.elapsedRealtime() + ((long) (bnVar.p() * 1000.0d));
            } else if ("no_more_today".equals(l2)) {
                this.m = (hv) hv.d.a(bnVar);
            } else if ("ad_content".equals(l2)) {
                str = bnVar.b();
            } else if (TapjoyConstants.TJC_REDIRECT_URL.equals(l2)) {
                str2 = bnVar.b();
            } else {
                bnVar.s();
            }
        }
        bnVar.i();
        if (this.g == null) {
            this.g = "";
        }
        ArrayList arrayList = this.i;
        if (arrayList != null) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                hs hsVar = (hs) it.next();
                if (hsVar.f == null) {
                    hsVar.f = str;
                }
                if (hsVar.e == null) {
                    hsVar.e = str2;
                }
            }
        }
        ArrayList arrayList2 = this.j;
        if (arrayList2 != null) {
            Iterator it2 = arrayList2.iterator();
            while (it2.hasNext()) {
                hs hsVar2 = (hs) it2.next();
                if (hsVar2.f == null) {
                    hsVar2.f = str;
                }
                if (hsVar2.e == null) {
                    hsVar2.e = str2;
                }
            }
        }
    }

    public final boolean a() {
        return (this.c == null || this.a == null || this.e == null) ? false : true;
    }

    public final boolean b() {
        return (this.c == null || this.b == null || this.f == null) ? false : true;
    }
}
