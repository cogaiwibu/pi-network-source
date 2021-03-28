package com.bytedance.sdk.openadsdk.b;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.FilterWord;
import com.bytedance.sdk.openadsdk.core.c.c;
import com.bytedance.sdk.openadsdk.core.c.g;
import com.bytedance.sdk.openadsdk.core.h;
import com.bytedance.sdk.openadsdk.core.j;
import com.bytedance.sdk.openadsdk.dislike.a;
import com.bytedance.sdk.openadsdk.g.f;
import com.bytedance.sdk.openadsdk.g.l;
import com.bytedance.sdk.openadsdk.g.t;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import com.tapjoy.TJAdUnitConstants;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: AdEventManager */
public class d {
    public static void a(g gVar) {
    }

    public static void a(Context context, g gVar, String str, Map<String, Object> map) {
        Context a = j.a();
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("device", f.e(a).toString());
            jSONObject2.put("is_cache", gVar.A() ? 1 : 0);
            if (map != null) {
                for (Map.Entry<String, Object> entry : map.entrySet()) {
                    jSONObject2.put(entry.getKey(), entry.getValue());
                }
            }
            jSONObject.put("ad_extra_data", jSONObject2.toString());
            jSONObject.putOpt("log_extra", gVar.u());
            double currentTimeMillis = (double) (System.currentTimeMillis() / 1000);
            double f = t.f(gVar.u());
            Double.isNaN(currentTimeMillis);
            float f2 = (float) (currentTimeMillis - f);
            if (f2 <= 0.0f) {
                f2 = 0.0f;
            }
            jSONObject.putOpt("show_time", Float.valueOf(f2));
            jSONObject.putOpt("ua_policy", Integer.valueOf(gVar.b()));
        } catch (JSONException unused) {
        }
        a a2 = a.a(a, str, "show", gVar.r(), jSONObject);
        l.b("ReportEvent", "show event" + gVar.r());
        j.b().a(a2);
        if (!TextUtils.isEmpty(h.a(j.a()))) {
            j.d().a(com.bytedance.sdk.openadsdk.f.d.a(gVar.l(), true));
        }
        if (l.c()) {
            l.c("AdEvent", "show " + gVar.r());
        }
    }

    public static void a(Context context, g gVar, String str, String str2, Map<String, Object> map) {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        if (map != null) {
            try {
                for (Map.Entry<String, Object> entry : map.entrySet()) {
                    jSONObject.put(entry.getKey(), entry.getValue());
                }
            } catch (Throwable th) {
                l.b(th.toString());
            }
        }
        jSONObject2.put("ad_extra_data", jSONObject.toString());
        c(context, gVar, str, str2, jSONObject2);
    }

    public static void a(Context context, String str, g gVar, c cVar, String str2, boolean z, Map<String, Object> map) {
        Context a = j.a();
        JSONObject jSONObject = new JSONObject();
        if (cVar != null) {
            try {
                JSONObject a2 = cVar.a();
                a2.put("device", f.e(a).toString());
                a2.put("is_valid", z);
                if (map != null) {
                    for (Map.Entry<String, Object> entry : map.entrySet()) {
                        a2.put(entry.getKey(), entry.getValue());
                    }
                }
                jSONObject.put("ad_extra_data", a2.toString());
            } catch (JSONException unused) {
            }
        }
        jSONObject.putOpt("log_extra", gVar.u());
        double currentTimeMillis = (double) (System.currentTimeMillis() / 1000);
        double f = t.f(gVar.u());
        Double.isNaN(currentTimeMillis);
        float f2 = (float) (currentTimeMillis - f);
        if (f2 <= 0.0f) {
            f2 = 0.0f;
        }
        jSONObject.putOpt("show_time", Float.valueOf(f2));
        jSONObject.putOpt("ua_policy", Integer.valueOf(gVar.b()));
        a a3 = a.a(a, str2, str, gVar.r(), jSONObject);
        l.b("ReportEvent", "click event" + gVar.r());
        j.b().a(a3);
        if (!TextUtils.isEmpty(h.a(j.a())) && TJAdUnitConstants.String.CLICK.equals(str)) {
            j.d().a(com.bytedance.sdk.openadsdk.f.d.a(gVar.m(), true));
        }
        if (l.c()) {
            l.c("AdEvent", str + " " + gVar.r());
        }
    }

    public static void a(Context context, g gVar, String str, String str2, JSONObject jSONObject) {
        if (jSONObject != null) {
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("ad_extra_data", jSONObject);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            c(context, gVar, str, str2, jSONObject2);
            return;
        }
        d(context, gVar, str, str2);
    }

    public static void a(g gVar, List<FilterWord> list) {
        a.a().a(gVar, list);
        if (l.c()) {
            l.c("AdEvent", "tt_dislike_icon " + gVar.r());
        }
    }

    public static void b(Context context, g gVar, String str, String str2, Map<String, Object> map) {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        if (map != null) {
            try {
                for (Map.Entry<String, Object> entry : map.entrySet()) {
                    jSONObject.put(entry.getKey(), entry.getValue());
                }
            } catch (Throwable th) {
                l.b(th.toString());
            }
        }
        jSONObject2.put("ad_extra_data", jSONObject.toString());
        c(context, gVar, str, str2, jSONObject2);
    }

    public static void c(Context context, g gVar, String str, String str2, Map<String, Object> map) {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        if (map != null) {
            try {
                for (Map.Entry<String, Object> entry : map.entrySet()) {
                    jSONObject.put(entry.getKey(), entry.getValue());
                }
            } catch (Throwable th) {
                l.b(th.toString());
            }
        }
        jSONObject2.put("ad_extra_data", jSONObject.toString());
        c(context, gVar, str, str2, jSONObject2);
    }

    public static void a(Context context, g gVar, String str, String str2, long j, int i) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(IronSourceConstants.EVENTS_DURATION, j);
            jSONObject.put("percent", i);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        c(context, gVar, str, str2, jSONObject);
    }

    public static void a(Context context, g gVar, String str, String str2, long j, int i, Map<String, Object> map) {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject.put(IronSourceConstants.EVENTS_DURATION, j);
            jSONObject.put("percent", i);
            if (map != null) {
                for (Map.Entry<String, Object> entry : map.entrySet()) {
                    jSONObject2.put(entry.getKey(), entry.getValue());
                }
            }
            jSONObject.put("ad_extra_data", jSONObject2.toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        c(context, gVar, str, str2, jSONObject);
    }

    public static void a(Context context, g gVar, String str, String str2) {
        d(context, gVar, str, str2);
    }

    public static void b(Context context, g gVar, String str, String str2) {
        d(context, gVar, str, str2);
    }

    private static void d(Context context, g gVar, String str, String str2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("log_extra", gVar.u());
            jSONObject.putOpt("ua_policy", Integer.valueOf(gVar.b()));
        } catch (JSONException unused) {
        }
        j.b().a(a.a(context, str, str2, gVar.r(), jSONObject));
        if (l.c()) {
            l.c("AdEvent", "tag: " + str + "label: " + str2 + " " + gVar.r());
        }
    }

    public static void c(Context context, g gVar, String str, String str2) {
        d(context, gVar, str, str2);
    }

    private static void c(Context context, g gVar, String str, String str2, JSONObject jSONObject) {
        if (gVar != null) {
            if (jSONObject != null) {
                try {
                    jSONObject.putOpt("log_extra", gVar.u());
                    jSONObject.putOpt("ua_policy", Integer.valueOf(gVar.b()));
                } catch (JSONException unused) {
                }
            }
            j.b().a(a.a(context, str, str2, gVar.r(), jSONObject));
            if (l.c()) {
                l.c("AdEvent", "tag: " + str + "label: " + str2 + " " + gVar.r());
            }
        }
    }

    public static void a(Context context, String str, long j) {
        com.bytedance.sdk.openadsdk.core.b.c.a(context, str, j);
    }

    public static void a(g gVar, String str, String str2, String str3, long j, long j2, JSONObject jSONObject) {
        if (jSONObject != null) {
            JSONObject jSONObject2 = new JSONObject();
            try {
                String optString = jSONObject.optString("ad_extra_data", null);
                if (optString != null) {
                    jSONObject2 = new JSONObject(optString);
                }
                jSONObject2.put("device", f.e(j.a()).toString());
                jSONObject.put("ad_extra_data", jSONObject2.toString());
                jSONObject.put(ViewHierarchyConstants.TAG_KEY, str2);
                if (TJAdUnitConstants.String.CLICK.equals(str3)) {
                    String optString2 = jSONObject.optString("log_extra");
                    double currentTimeMillis = (double) (System.currentTimeMillis() / 1000);
                    double f = t.f(optString2);
                    Double.isNaN(currentTimeMillis);
                    float f2 = (float) (currentTimeMillis - f);
                    if (f2 <= 0.0f) {
                        f2 = 0.0f;
                    }
                    jSONObject.putOpt("show_time", Float.valueOf(f2));
                    if (!TextUtils.isEmpty(h.a(j.a())) && gVar != null) {
                        j.d().a(com.bytedance.sdk.openadsdk.f.d.a(gVar.m(), true));
                    }
                }
            } catch (JSONException unused) {
            }
        }
        j.b().a(a.a(str, str2, str3, j, j2, jSONObject));
        if (l.c()) {
            l.c("AdEvent", "sendJsAdEvent");
        }
    }

    public static void b(Context context, g gVar, String str, String str2, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        c(context, gVar, str, str2, jSONObject);
    }
}
