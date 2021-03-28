package com.tapjoy.internal;

import com.facebook.AccessToken;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import com.onesignal.OSNotificationFormatHelper;
import com.onesignal.UserState;
import com.onesignal.shortcutbadger.impl.NewHtcHomeBadger;
import com.tapjoy.TJAdUnitConstants;
import com.tapjoy.TapjoyConstants;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public final class hp {
    public static String a(fa faVar) {
        bh b = new bh().c().a("sdk").b(faVar.t).a("os_name").b(faVar.k).a("os_ver").b(faVar.l).a("device_id").b(faVar.h).a("device_maker").b(faVar.i).a("device_model").b(faVar.j).a(TapjoyConstants.TJC_PACKAGE_ID).b(faVar.r).a(TapjoyConstants.TJC_PACKAGE_SIGN).b(faVar.s).a("locale").b(faVar.p).a(TapjoyConstants.TJC_DEVICE_TIMEZONE).b(faVar.q);
        if (faVar.m != null) {
            b.a(TapjoyConstants.TJC_DEVICE_DISPLAY_DENSITY).a((Number) faVar.m);
        }
        if (faVar.n != null) {
            b.a(TapjoyConstants.TJC_DEVICE_DISPLAY_WIDTH).a((Number) faVar.n);
        }
        if (faVar.o != null) {
            b.a(TapjoyConstants.TJC_DEVICE_DISPLAY_HEIGHT).a((Number) faVar.o);
        }
        if (faVar.g != null) {
            b.a("mac").b(faVar.g);
        }
        if (faVar.u != null) {
            b.a(TapjoyConstants.TJC_DEVICE_COUNTRY_SIM).b(faVar.u);
        }
        if (faVar.v != null) {
            b.a("country_net").b(faVar.v);
        }
        if (faVar.w != null) {
            b.a("imei").b(faVar.w);
        }
        if (faVar.x != null) {
            b.a(TapjoyConstants.TJC_ANDROID_ID).b(faVar.x);
        }
        return b.d().toString();
    }

    public static String a(eu euVar) {
        bh c = new bh().c();
        if (euVar.e != null) {
            c.a(TapjoyConstants.TJC_PACKAGE_VERSION).b(euVar.e);
        }
        if (euVar.f != null) {
            c.a(TapjoyConstants.TJC_PACKAGE_REVISION).a((Number) euVar.f);
        }
        if (euVar.g != null) {
            c.a("data_ver").b(euVar.g);
        }
        if (euVar.h != null) {
            c.a(TapjoyConstants.TJC_INSTALLER).b(euVar.h);
        }
        if (euVar.i != null) {
            c.a("store").b(euVar.i);
        }
        return c.d().toString();
    }

    public static String a(fh fhVar) {
        return a(fhVar, null);
    }

    private static String a(fh fhVar, ev evVar) {
        String b;
        bh c = new bh().c();
        if (fhVar.s != null) {
            c.a(TapjoyConstants.TJC_INSTALLED).a((Number) fhVar.s);
        }
        if (fhVar.t != null) {
            c.a(TapjoyConstants.TJC_REFERRER).b(fhVar.t);
        }
        if (fhVar.G != null) {
            c.a("idfa").b(fhVar.G);
            if (fhVar.H != null && fhVar.H.booleanValue()) {
                c.a("idfa_optout").a(1);
            }
        } else if (!(evVar == null || evVar.r == null || !hc.a.equals(evVar.r) || (b = hn.b()) == null)) {
            c.a("idfa").b(b);
            if (hn.c()) {
                c.a("idfa_optout").a(1);
            }
        }
        if (fhVar.u != null) {
            c.a(TapjoyConstants.TJC_USER_WEEKLY_FREQUENCY).a((long) Math.max(fhVar.u.intValue(), 1));
        }
        if (fhVar.v != null) {
            c.a(TapjoyConstants.TJC_USER_MONTHLY_FREQUENCY).a((long) Math.max(fhVar.v.intValue(), 1));
        }
        if (fhVar.w.size() > 0) {
            ArrayList arrayList = new ArrayList(fhVar.w.size());
            for (fe feVar : fhVar.w) {
                if (feVar.h != null) {
                    arrayList.add(feVar.f);
                }
            }
            if (!arrayList.isEmpty()) {
                c.a("push").a();
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    c.b((String) it.next());
                }
                c.b();
            }
        }
        c.a("session").c();
        if (fhVar.x != null) {
            c.a("total_count").a((Number) fhVar.x);
        }
        if (fhVar.y != null) {
            c.a("total_length").a((Number) fhVar.y);
        }
        if (fhVar.z != null) {
            c.a("last_at").a((Number) fhVar.z);
        }
        if (fhVar.A != null) {
            c.a("last_length").a((Number) fhVar.A);
        }
        c.d();
        c.a(FirebaseAnalytics.Event.PURCHASE).c();
        if (fhVar.B != null) {
            c.a(FirebaseAnalytics.Param.CURRENCY).b(fhVar.B);
        }
        if (fhVar.C != null) {
            c.a("total_count").a((Number) fhVar.C);
        }
        if (fhVar.D != null) {
            c.a("total_price").a((Number) fhVar.D);
        }
        if (fhVar.E != null) {
            c.a("last_at").a((Number) fhVar.E);
        }
        if (fhVar.F != null) {
            c.a("last_price").a((Number) fhVar.F);
        }
        c.d();
        if (fhVar.I != null) {
            c.a(AccessToken.USER_ID_KEY).b(fhVar.I);
        }
        if (fhVar.J != null) {
            c.a(TapjoyConstants.TJC_USER_LEVEL).a((Number) fhVar.J);
        }
        if (fhVar.K != null) {
            c.a(TapjoyConstants.TJC_USER_FRIEND_COUNT).a((Number) fhVar.K);
        }
        if (fhVar.L != null) {
            c.a(TapjoyConstants.TJC_USER_VARIABLE_1).b(fhVar.L);
        }
        if (fhVar.M != null) {
            c.a(TapjoyConstants.TJC_USER_VARIABLE_2).b(fhVar.M);
        }
        if (fhVar.N != null) {
            c.a(TapjoyConstants.TJC_USER_VARIABLE_3).b(fhVar.N);
        }
        if (fhVar.O != null) {
            c.a(TapjoyConstants.TJC_USER_VARIABLE_4).b(fhVar.O);
        }
        if (fhVar.P != null) {
            c.a(TapjoyConstants.TJC_USER_VARIABLE_5).b(fhVar.P);
        }
        if (fhVar.Q.size() > 0) {
            c.a(UserState.TAGS).a((Collection) fhVar.Q);
        }
        if (Boolean.TRUE.equals(fhVar.R)) {
            c.a("push_optout").a(1);
        }
        return c.d().toString();
    }

    private static String a(ev evVar, boolean z, boolean z2, boolean z3) {
        bh b = new bh().c().a("type").b(a(evVar.n)).a("name").b(evVar.o);
        b.a("time");
        if (evVar.q != null) {
            b.a((Number) evVar.p);
            b.a("systime").a((Number) evVar.q);
        } else if (!v.c() || evVar.r == null || evVar.s == null || !hc.a.equals(evVar.r)) {
            b.a((Number) evVar.p);
        } else {
            b.a(v.a(evVar.s.longValue()));
            b.a("systime").a((Number) evVar.p);
        }
        if (evVar.t != null) {
            b.a(IronSourceConstants.EVENTS_DURATION).a((Number) evVar.t);
        }
        if (!z && evVar.u != null) {
            b.a(TJAdUnitConstants.String.VIDEO_INFO).a((bl) new bm(a(evVar.u)));
        }
        if (!z2 && evVar.v != null) {
            b.a(TapjoyConstants.TJC_APP_PLACEMENT).a((bl) new bm(a(evVar.v)));
        }
        if (!z3 && evVar.w != null) {
            b.a("user").a((bl) new bm(a(evVar.w, evVar)));
        }
        if (evVar.y != null) {
            b.a("event_seq").a((Number) evVar.y);
        }
        if (evVar.z != null) {
            bh a = b.a("event_prev");
            ex exVar = evVar.z;
            bh b2 = new bh().c().a("type").b(a(exVar.e)).a("name").b(exVar.f);
            if (exVar.g != null) {
                b2.a("category").b(exVar.g);
            }
            a.a((bl) new bm(b2.d().toString()));
        }
        if (evVar.A != null) {
            bh a2 = b.a(FirebaseAnalytics.Event.PURCHASE);
            fd fdVar = evVar.A;
            bh b3 = new bh().c().a("product_id").b(fdVar.h);
            if (fdVar.i != null) {
                b3.a("product_quantity").a((Number) fdVar.i);
            }
            if (fdVar.j != null) {
                b3.a("product_price").a((Number) fdVar.j);
            }
            if (fdVar.k != null) {
                b3.a("product_price_currency").b(fdVar.k);
            }
            if (fdVar.s != null) {
                b3.a("currency_price").b(fdVar.s);
            }
            if (fdVar.l != null) {
                b3.a("product_type").b(fdVar.l);
            }
            if (fdVar.m != null) {
                b3.a("product_title").b(fdVar.m);
            }
            if (fdVar.n != null) {
                b3.a("product_description").b(fdVar.n);
            }
            if (fdVar.o != null) {
                b3.a(FirebaseAnalytics.Param.TRANSACTION_ID).b(fdVar.o);
            }
            if (fdVar.p != null) {
                b3.a("transaction_state").a((Number) fdVar.p);
            }
            if (fdVar.q != null) {
                b3.a("transaction_date").a((Number) fdVar.q);
            }
            if (fdVar.r != null) {
                b3.a("campaign_id").b(fdVar.r);
            }
            if (fdVar.t != null) {
                b3.a("receipt").b(fdVar.t);
            }
            if (fdVar.u != null) {
                b3.a("signature").b(fdVar.u);
            }
            a2.a((bl) new bm(b3.d().toString()));
        }
        if (evVar.B != null) {
            b.a("exception").b(evVar.B);
        }
        try {
            if (evVar.D != null) {
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                if (evVar.C != null) {
                    bn.b(evVar.C).a(linkedHashMap);
                }
                fc fcVar = evVar.D;
                if (fcVar.d != null) {
                    linkedHashMap.put("fq7_change", fcVar.d);
                }
                if (fcVar.e != null) {
                    linkedHashMap.put("fq30_change", fcVar.e);
                }
                if (fcVar.f != null) {
                    linkedHashMap.put(TJAdUnitConstants.PARAM_PUSH_ID, fcVar.f);
                }
                b.a("meta").a((Map) linkedHashMap);
            } else if (evVar.C != null) {
                b.a("meta").a((bl) new bm(evVar.C));
            }
        } catch (IOException unused) {
        }
        if (evVar.I != null) {
            b.a(TJAdUnitConstants.String.USAGE_TRACKER_DIMENSIONS).a((bl) new bm(evVar.I));
        }
        if (evVar.J != null) {
            b.a(NewHtcHomeBadger.COUNT).a((Number) evVar.J);
        }
        if (evVar.K != null) {
            b.a("first_time").a((Number) evVar.K);
        }
        if (evVar.L != null) {
            b.a("last_time").a((Number) evVar.L);
        }
        if (evVar.E != null) {
            b.a("category").b(evVar.E);
        }
        if (evVar.F != null) {
            b.a("p1").b(evVar.F);
        }
        if (evVar.G != null) {
            b.a("p2").b(evVar.G);
        }
        if (evVar.H.size() > 0) {
            b.a(TJAdUnitConstants.String.USAGE_TRACKER_VALUES).c();
            for (ez ezVar : evVar.H) {
                b.a(ezVar.e).a((Number) ezVar.f);
            }
            b.d();
        }
        return b.d().toString();
    }

    public static String a(ew ewVar) {
        boolean z;
        boolean z2;
        bh a = new bh().a();
        fa faVar = null;
        eu euVar = null;
        fh fhVar = null;
        for (ev evVar : ewVar.d) {
            boolean z3 = true;
            if (faVar == null || !faVar.equals(evVar.u)) {
                faVar = evVar.u;
                z = false;
            } else {
                z = true;
            }
            if (euVar == null || !euVar.equals(evVar.v)) {
                euVar = evVar.v;
                z2 = false;
            } else {
                z2 = true;
            }
            if (fhVar == null || !fhVar.equals(evVar.w)) {
                fhVar = evVar.w;
                z3 = false;
            }
            a.a((bl) new bm(a(evVar, z, z2, z3)));
        }
        return a.b().toString();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: com.tapjoy.internal.hp$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] a;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        static {
            /*
                com.tapjoy.internal.ey[] r0 = com.tapjoy.internal.ey.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                com.tapjoy.internal.hp.AnonymousClass1.a = r0
                com.tapjoy.internal.ey r1 = com.tapjoy.internal.ey.APP     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = com.tapjoy.internal.hp.AnonymousClass1.a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.tapjoy.internal.ey r1 = com.tapjoy.internal.ey.CAMPAIGN     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = com.tapjoy.internal.hp.AnonymousClass1.a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.tapjoy.internal.ey r1 = com.tapjoy.internal.ey.CUSTOM     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = com.tapjoy.internal.hp.AnonymousClass1.a     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.tapjoy.internal.ey r1 = com.tapjoy.internal.ey.USAGES     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tapjoy.internal.hp.AnonymousClass1.<clinit>():void");
        }
    }

    private static String a(ey eyVar) {
        int i = AnonymousClass1.a[eyVar.ordinal()];
        if (i == 1) {
            return TapjoyConstants.TJC_APP_PLACEMENT;
        }
        if (i == 2) {
            return "campaign";
        }
        if (i == 3) {
            return OSNotificationFormatHelper.PAYLOAD_OS_ROOT_CUSTOM;
        }
        if (i == 4) {
            return "usages";
        }
        throw new RuntimeException();
    }
}
