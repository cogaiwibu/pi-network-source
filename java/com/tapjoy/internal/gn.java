package com.tapjoy.internal;

import android.app.Activity;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Locale;

public final class gn {
    public static void a(Activity activity) {
        gz a = gz.a();
        if (gw.a(activity, "onActivityStart: The given activity was null")) {
            gw.c("onActivityStart");
            b.a(activity.getApplication());
            b.b(activity);
            if (a.c("onActivityStart") && a.e()) {
                gt.b(activity);
            }
        }
    }

    public static void b(Activity activity) {
        gz a = gz.a();
        if (gw.a(activity, "onActivityStop: The given activity was null")) {
            gw.c("onActivityStop");
            b.c(activity);
            if (a.c("onActivityStop") && !b.b()) {
                a.h.a();
            }
        }
    }

    public static void a() {
        gz a = gz.a();
        if (a.c("startSession") && a.e()) {
            gt.b(null);
        }
    }

    public static void b() {
        gz a = gz.a();
        if (a.c("endSession")) {
            a.h.a();
        }
    }

    public static void a(String str, String str2, String str3, String str4, long j) {
        gz a = gz.a();
        if (a.d("trackEvent") && gw.a(str2, "trackEvent: name was null")) {
            LinkedHashMap linkedHashMap = null;
            if (j != 0) {
                linkedHashMap = ju.b();
                linkedHashMap.put("value", Long.valueOf(j));
            }
            a.g.a(str, str2, str3, str4, linkedHashMap);
            gw.a("trackEvent category:{}, name:{}, p1:{}, p2:{}, values:{} called", str, str2, str3, str4, linkedHashMap);
        }
    }

    public static void a(String str, String str2, String str3, String str4, String str5, long j, String str6, long j2, String str7, long j3) {
        gz a = gz.a();
        if (a.d("trackEvent") && gw.a(str2, "trackEvent: name was null")) {
            LinkedHashMap b = ju.b();
            if (!(str5 == null || j == 0)) {
                b.put(str5, Long.valueOf(j));
            }
            if (!(str6 == null || j2 == 0)) {
                b.put(str6, Long.valueOf(j2));
            }
            if (!(str7 == null || j3 == 0)) {
                b.put(str7, Long.valueOf(j3));
            }
            if (b.isEmpty()) {
                b = null;
            }
            a.g.a(str, str2, str3, str4, b);
            gw.a("trackEvent category:{}, name:{}, p1:{}, p2:{}, values:{} called", str, str2, str3, str4, b);
        }
    }

    public static void a(String str, String str2, String str3, String str4) {
        gz a = gz.a();
        if (a.c("trackPurchase")) {
            try {
                e eVar = new e(str);
                String b = gu.b(eVar.a);
                String b2 = gu.b(eVar.f);
                if (b == null || b2 == null) {
                    gw.a("trackPurchase", "skuDetails", "insufficient fields");
                } else if (b2.length() != 3) {
                    gw.a("trackPurchase", "skuDetails", "invalid currency code");
                } else {
                    String b3 = gu.b(str2);
                    String b4 = gu.b(str3);
                    if (b3 != null) {
                        if (b4 != null) {
                            try {
                                f fVar = new f(b3);
                                if (jq.c(fVar.a) || jq.c(fVar.b) || jq.c(fVar.c) || fVar.d == 0) {
                                    gw.a("trackPurchase", "purchaseData", "insufficient fields");
                                }
                            } catch (IOException unused) {
                                gw.a("trackPurchase", "purchaseData", "invalid PurchaseData JSON");
                            }
                        } else {
                            gw.a("trackPurchase", "dataSignature", "is null, skipping purchase validation");
                        }
                    } else if (b4 != null) {
                        gw.a("trackPurchase", "purchaseData", "is null. skipping purchase validation");
                    }
                    String upperCase = b2.toUpperCase(Locale.US);
                    String b5 = gu.b(str4);
                    gy gyVar = a.g;
                    double d = (double) eVar.g;
                    Double.isNaN(d);
                    gyVar.a(b, upperCase, d / 1000000.0d, b3, b4, b5);
                    if (b3 == null || b4 == null) {
                        gw.a("trackPurchase without purchaseData called");
                    } else {
                        gw.a("trackPurchase with purchaseData called");
                    }
                }
            } catch (IOException unused2) {
                gw.a("trackPurchase", "skuDetails", "invalid SkuDetails JSON");
            }
        }
    }
}
