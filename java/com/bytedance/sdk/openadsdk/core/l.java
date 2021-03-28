package com.bytedance.sdk.openadsdk.core;

import android.content.Context;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.anythink.reactnativejs.utils.Const;
import com.bytedance.sdk.adnet.a.f;
import com.bytedance.sdk.adnet.a.i;
import com.bytedance.sdk.adnet.core.m;
import com.bytedance.sdk.adnet.err.VAdError;
import com.bytedance.sdk.adnet.err.e;
import com.bytedance.sdk.adnet.face.a;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.FilterWord;
import com.bytedance.sdk.openadsdk.b.d;
import com.bytedance.sdk.openadsdk.core.c.g;
import com.bytedance.sdk.openadsdk.core.c.h;
import com.bytedance.sdk.openadsdk.core.e.c;
import com.bytedance.sdk.openadsdk.core.k;
import com.bytedance.sdk.openadsdk.g.p;
import com.bytedance.sdk.openadsdk.g.t;
import com.bytedance.sdk.openadsdk.g.u;
import com.facebook.common.util.UriUtil;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.ServerProtocol;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.ironsource.environment.TokenConstants;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import com.ironsource.sdk.constants.Constants;
import com.ironsource.sdk.constants.Events;
import com.tapjoy.TapjoyConstants;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: NetApiImpl */
public class l implements k<com.bytedance.sdk.openadsdk.b.a> {
    private static boolean g = true;
    private final Context a;
    private final boolean b;
    private final ExecutorService c = Executors.newFixedThreadPool(1);
    private final String d;
    private long e;
    private int f;

    private int a(int i) {
        return (i == 3 || i == 4) ? 2000 : 10000;
    }

    private static String b(int i) {
        return i != 120 ? i != 160 ? i != 240 ? i != 320 ? i != 480 ? i != 640 ? "mdpi" : "xxxhdpi" : "xxhdpi" : "xhdpi" : "hdpi" : "mdpi" : "ldpi";
    }

    l(Context context) {
        this.a = context;
        this.b = f();
        this.d = i();
    }

    private void a(JSONObject jSONObject) throws JSONException {
        int g2 = g.b().g();
        if (j.e().b() == 1 && g2 == 0) {
            jSONObject.put("ip", d());
            return;
        }
        boolean z = false;
        boolean z2 = j.e().b() == 1 && (g2 == 1 || g2 == -1);
        if (j.e().b() == -1 && g2 == 1) {
            z = true;
        }
        if (!z2 && !z && g.b().h() != 1) {
            jSONObject.put("ip", d());
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x004e A[Catch:{ JSONException -> 0x00e9 }] */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x00d4  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x00db  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private org.json.JSONObject a(com.bytedance.sdk.openadsdk.AdSlot r9, com.bytedance.sdk.openadsdk.core.c.h r10, int r11) {
        /*
        // Method dump skipped, instructions count: 234
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.l.a(com.bytedance.sdk.openadsdk.AdSlot, com.bytedance.sdk.openadsdk.core.c.h, int):org.json.JSONObject");
    }

    private boolean a(String str) {
        if (com.bytedance.sdk.openadsdk.core.b.b.a()) {
            return true;
        }
        if (!com.bytedance.sdk.openadsdk.core.b.b.a(str)) {
            return false;
        }
        String b2 = com.bytedance.sdk.openadsdk.core.b.b.b();
        if (!TextUtils.isEmpty(b2)) {
            d.a(this.a, b2, System.currentTimeMillis());
        }
        return true;
    }

    @Override // com.bytedance.sdk.openadsdk.core.k
    public void a(final AdSlot adSlot, h hVar, final int i, final k.a aVar) {
        c.a((com.bytedance.sdk.openadsdk.core.e.b) null).a();
        final boolean z = adSlot.getNativeAdType() == 1 || adSlot.getNativeAdType() == 2 || i == 5 || i == 9;
        if (aVar != null) {
            if (a(adSlot.getCodeId())) {
                aVar.a(-8, ErrorCode.message(-8));
                return;
            }
            JSONObject a2 = a(adSlot, hVar, i);
            if (a2 == null) {
                aVar.a(-9, ErrorCode.message(-9));
            } else {
                new f(1, t.g("/api/ad/union/sdk/get_ads/"), a2, new m.a<JSONObject>() {
                    /* class com.bytedance.sdk.openadsdk.core.l.AnonymousClass1 */

                    @Override // com.bytedance.sdk.adnet.core.m.a
                    public void a(m<JSONObject> mVar) {
                        JSONObject d2 = l.this.d((l) mVar.a);
                        if (d2 == null) {
                            l.this.a((l) aVar);
                            if (z) {
                                l.this.a(mVar.e, adSlot.getCodeId(), i, null, "load_ad_duration_no_ad", -1, "mate parse_fail");
                                return;
                            }
                            return;
                        }
                        try {
                            a a2 = a.a(d2);
                            if (!TextUtils.isEmpty(a2.f) && !a2.f.equals(h.a(l.this.a))) {
                                h.a(l.this.a, a2.f);
                            }
                            if (a2.b != 20000) {
                                aVar.a(a2.b, ErrorCode.message(a2.b));
                                if (z) {
                                    l.this.a(mVar.e, adSlot.getCodeId(), i, a2, "load_ad_duration_no_ad", a2.b, String.valueOf(a2.c));
                                }
                            } else if (a2.e == null) {
                                l.this.a((l) aVar);
                                if (z) {
                                    l.this.a(mVar.e, adSlot.getCodeId(), i, a2, "load_ad_duration_no_ad", -1, "parse_fail");
                                }
                            } else {
                                a2.e.c(d2.toString());
                                aVar.a(a2.e);
                                if (z) {
                                    l.this.a(mVar.e, adSlot.getCodeId(), i, a2, "load_ad_duration", ErrorCode.OK, "");
                                }
                            }
                        } catch (Throwable unused) {
                            l.this.a((l) aVar);
                            if (z) {
                                l.this.a(mVar.e, adSlot.getCodeId(), i, null, "load_ad_duration_no_ad", -1, "parse_fail");
                            }
                        }
                    }

                    @Override // com.bytedance.sdk.adnet.core.m.a
                    public void b(m<JSONObject> mVar) {
                        String str;
                        int i;
                        VAdError vAdError = mVar.c;
                        if (vAdError instanceof e) {
                            l.this.a((l) aVar);
                            if (z) {
                                l.this.a(mVar.e, adSlot.getCodeId(), i, null, "load_ad_duration_no_ad", -1, ErrorCode.message(-1));
                                return;
                            }
                            return;
                        }
                        String message = ErrorCode.message(-2);
                        a.C0003a aVar = mVar.b;
                        if (vAdError == null || aVar == null) {
                            str = message;
                            i = -2;
                        } else {
                            i = aVar.a;
                            str = vAdError.getMessage();
                        }
                        aVar.a(i, str);
                        if (z) {
                            l.this.a(mVar.e, adSlot.getCodeId(), i, null, "load_ad_duration_no_ad", i, str);
                        }
                    }
                }).setRetryPolicy(com.bytedance.sdk.openadsdk.e.b.b().a(a(i))).setUserAgent(n.a).build(com.bytedance.sdk.openadsdk.e.b.a(this.a).c());
            }
        }
    }

    private boolean b(String str) {
        return !TextUtils.isEmpty(str);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void a(long j, String str, int i, a aVar, String str2, int i2, String str3) {
        String str4;
        g gVar;
        boolean equals = "load_ad_duration".equals(str2);
        JSONObject jSONObject = new JSONObject();
        boolean z = false;
        if (equals) {
            if (aVar != null) {
                try {
                    if (aVar.e == null || aVar.e.c() == null || aVar.e.c().size() == 0 || aVar.e.c().get(0) == null) {
                        return;
                    }
                } catch (Throwable th) {
                    com.bytedance.sdk.openadsdk.g.l.b("NetApiImpl", "uploadAdTypeTimeOutEvent throws exception ", th);
                }
            } else {
                return;
            }
        }
        String str5 = "";
        if (aVar == null || aVar.e == null || aVar.e.c() == null || aVar.e.c().size() <= 0) {
            str4 = str5;
            gVar = null;
        } else {
            gVar = aVar.e.c().get(0);
            str4 = gVar.u();
        }
        String a2 = (aVar == null || aVar.e == null) ? str5 : aVar.e.a();
        jSONObject.put("type", str2);
        jSONObject.put("adtype", i);
        jSONObject.put("ad_sdk_version", "2.1.5.0");
        jSONObject.put("req_id", a2);
        if (gVar != null) {
            str5 = gVar.r();
        }
        jSONObject.put("creative_id", str5);
        jSONObject.put("extra", str4);
        jSONObject.put("rit", str);
        jSONObject.put("timestamp", System.currentTimeMillis());
        jSONObject.put("c_process_time", j);
        jSONObject.put("s_process_time", aVar != null ? (long) aVar.a : 0);
        jSONObject.put(MessengerShareContentUtility.IMAGE_URL, (Object) null);
        jSONObject.put(NativeProtocol.BRIDGE_ARG_ERROR_CODE, i2);
        jSONObject.put("error_msg", str3);
        z = true;
        if (z) {
            com.bytedance.sdk.openadsdk.g.l.c("uploadAdTypeTimeOutEvent", "body=" + jSONObject.toString());
            new com.bytedance.sdk.adnet.a.h(1, t.g("/api/ad/union/sdk/stats/"), jSONObject, null).setRetryPolicy(com.bytedance.sdk.openadsdk.e.b.b().a(10000)).build(com.bytedance.sdk.openadsdk.e.b.a(this.a).c());
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.k
    public com.bytedance.sdk.openadsdk.b.h a(List<com.bytedance.sdk.openadsdk.b.a> list) {
        String str;
        JSONObject jSONObject = new JSONObject();
        boolean z = true;
        try {
            a(list.get(0));
            JSONObject e2 = e();
            if (list.size() > 1) {
                e2.put("ua", t.c());
            } else {
                String b2 = list.get(0).b.getInt("ua_policy") == 2 ? t.b() : t.c();
                if ("unKnow".equals(b2)) {
                    b2 = t.c();
                }
                e2.put("ua", b2);
            }
            jSONObject.put("header", e2);
            JSONArray jSONArray = new JSONArray();
            for (com.bytedance.sdk.openadsdk.b.a aVar : list) {
                jSONArray.put(aVar.b);
            }
            jSONObject.put("event", jSONArray);
            jSONObject.put("_gen_time", System.currentTimeMillis());
        } catch (JSONException unused) {
        }
        String a2 = a.a(jSONObject.toString(), b.b());
        if (!b(a2)) {
            a2 = jSONObject.toString();
        }
        final Map<String, String> c2 = c(a2);
        i a3 = i.a();
        new f(1, k(), a2, a3) {
            /* class com.bytedance.sdk.openadsdk.core.l.AnonymousClass2 */

            @Override // com.bytedance.sdk.adnet.core.Request
            public Map<String, String> getHeaders() throws com.bytedance.sdk.adnet.err.a {
                return c2;
            }
        }.setRetryPolicy(com.bytedance.sdk.openadsdk.e.b.b().a(10000)).setUserAgent(n.a).build(com.bytedance.sdk.openadsdk.e.b.a(this.a).c());
        m mVar = null;
        try {
            mVar = a3.get();
        } catch (Throwable unused2) {
        }
        boolean z2 = mVar != null && b(mVar.a);
        com.bytedance.sdk.openadsdk.g.l.b("ReportEvent", "uploadEvent response->" + z2);
        int i = (mVar == null || mVar.b == null) ? 0 : mVar.b.a;
        if (z2 || i != 200) {
            str = (mVar == null || mVar.c == null) ? "error unknown" : mVar.c.getMessage();
            z = false;
        } else {
            str = "server say not success";
        }
        return new com.bytedance.sdk.openadsdk.b.h(z2, i, str, z);
    }

    @Override // com.bytedance.sdk.openadsdk.core.k
    public void a(g gVar, List<FilterWord> list) {
        JSONObject b2 = b(gVar, list);
        if (b2 != null) {
            new com.bytedance.sdk.adnet.a.h(1, t.g("/api/ad/union/dislike_event/"), t.a(b2), null).setRetryPolicy(com.bytedance.sdk.openadsdk.e.b.b().a(10000)).build(com.bytedance.sdk.openadsdk.e.b.a(this.a).c());
        }
    }

    private JSONObject b(g gVar, List<FilterWord> list) {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("action", "dislike");
            jSONObject2.put("timestamp", System.currentTimeMillis());
            jSONObject2.put("ad_sdk_version", "2.1.5.0");
            jSONObject2.put("extra", gVar.u());
            jSONObject2.put("filter_words", b(list));
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(jSONObject2);
            jSONObject.put("actions", jSONArray);
        } catch (JSONException unused) {
        }
        return jSONObject;
    }

    private JSONArray b(List<FilterWord> list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        JSONArray jSONArray = new JSONArray();
        for (FilterWord filterWord : list) {
            jSONArray.put(filterWord.getId());
        }
        return jSONArray;
    }

    private Map<String, String> c(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put(Events.CONTENT_TYPE, "application/json; charset=utf-8");
        if (b(str)) {
            hashMap.put("Content-Encoding", "union_sdk_encode");
        }
        return hashMap;
    }

    private boolean b(JSONObject jSONObject) {
        if (jSONObject == null) {
            return false;
        }
        try {
            return jSONObject.optString("message").equalsIgnoreCase("success");
        } catch (Throwable unused) {
            return false;
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void a(k.a aVar) {
        aVar.a(-1, ErrorCode.message(-1));
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void a(k.b bVar) {
        bVar.a(-1, ErrorCode.message(-1));
    }

    private JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("appid", g.b().d());
            jSONObject.put("name", g.b().e());
            c(jSONObject);
            jSONObject.put("is_paid_app", g.b().i());
            jSONObject.put("apk_sign", com.bytedance.sdk.openadsdk.g.b.a(this.a));
        } catch (JSONException unused) {
        }
        return jSONObject;
    }

    private String b() {
        return com.bytedance.sdk.openadsdk.g.f.a();
    }

    private JSONObject c() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("coppa", g.b().h());
            jSONObject.put("gdpr", g.b().g());
            jSONObject.put("is_gdpr_user", j.e().b());
            a(jSONObject, "keywords", g.b().j());
            a(jSONObject, "data", g.b().k());
        } catch (JSONException unused) {
        }
        return jSONObject;
    }

    private void a(JSONObject jSONObject, String str, String str2) throws JSONException {
        if (!TextUtils.isEmpty(str2)) {
            jSONObject.put(str, str2);
        }
    }

    private void c(JSONObject jSONObject) {
        try {
            jSONObject.put("package_name", t.f());
            jSONObject.put(ServerProtocol.FALLBACK_DIALOG_PARAM_VERSION, t.g());
        } catch (Exception unused) {
        }
    }

    private String d() {
        return com.bytedance.sdk.openadsdk.g.f.a(true);
    }

    private JSONObject a(AdSlot adSlot, int i) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("id", adSlot.getCodeId());
            jSONObject.put("adtype", i);
            jSONObject.put("pos", AdSlot.getPosition(i));
            a(jSONObject, "accepted_size", adSlot.getImgAcceptedWidth(), adSlot.getImgAcceptedHeight());
            jSONObject.put("is_support_dpl", adSlot.isSupportDeepLink());
            int i2 = 1;
            if (adSlot.getNativeAdType() > 0 || i == 9 || i == 5) {
                jSONObject.put("is_origin_ad", true);
            }
            int adCount = adSlot.getAdCount();
            if (adCount < 1) {
                adCount = 1;
            }
            if (adCount > 3) {
                adCount = 3;
            }
            if (i != 7) {
                if (i != 8) {
                    i2 = adCount;
                }
            }
            jSONObject.put("ad_count", i2);
        } catch (JSONException unused) {
        }
        return jSONObject;
    }

    private void a(JSONObject jSONObject, String str, int i, int i2) {
        if (i > 0 && i2 > 0) {
            JSONObject jSONObject2 = new JSONObject();
            JSONArray jSONArray = new JSONArray();
            try {
                jSONObject2.put("width", i);
                jSONObject2.put("height", i2);
                jSONArray.put(jSONObject2);
                jSONObject.put(str, jSONArray);
            } catch (JSONException unused) {
            }
        }
    }

    private void a(com.bytedance.sdk.openadsdk.b.a aVar) {
        if (aVar != null && aVar.b != null) {
            String optString = aVar.b.optString("log_extra", "");
            long d2 = t.d(optString);
            int e2 = t.e(optString);
            if (d2 == 0) {
                d2 = this.e;
            }
            this.e = d2;
            if (e2 == 0) {
                e2 = this.f;
            }
            this.f = e2;
        }
    }

    private JSONObject e() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("openudid", h.c(this.a));
            jSONObject.put("ad_sdk_version", "2.1.5.0");
            jSONObject.put("sim_op", a(this.a));
            jSONObject.put(TokenConstants.MINIMIZED_IS_ROOT_DEVICE, this.b ? 1 : 0);
            jSONObject.put(TapjoyConstants.TJC_DEVICE_TIMEZONE, h());
            jSONObject.put("access", com.bytedance.sdk.openadsdk.g.m.f(this.a));
            jSONObject.put("os", Constants.JAVASCRIPT_INTERFACE_NAME);
            jSONObject.put(TapjoyConstants.TJC_DEVICE_OS_VERSION_NAME, Build.VERSION.RELEASE);
            jSONObject.put("os_api", Build.VERSION.SDK_INT);
            jSONObject.put(TapjoyConstants.TJC_DEVICE_TYPE_NAME, this.d);
            jSONObject.put("device_model", Build.MODEL);
            jSONObject.put("device_brand", Build.BRAND);
            jSONObject.put(TapjoyConstants.TJC_DEVICE_MANUFACTURER, Build.MANUFACTURER);
            jSONObject.put("language", Locale.getDefault().getLanguage());
            jSONObject.put("resolution", u.c(this.a) + Const.X + u.b(this.a));
            jSONObject.put("display_density", b(u.e(this.a)));
            jSONObject.put("density_dpi", u.e(this.a));
            jSONObject.put("mc", b());
            jSONObject.put("device_id", h.a(this.a));
            jSONObject.put("aid", "1371");
            jSONObject.put("rom", g());
            jSONObject.put("cpu_abi", Build.CPU_ABI);
            jSONObject.put("build_serial", h.e(this.a));
            jSONObject.put("ut", this.f);
            jSONObject.put("uid", this.e);
            jSONObject.put("google_aid", com.com.bytedance.overseas.sdk.a.a.a().c());
        } catch (JSONException unused) {
        }
        return jSONObject;
    }

    private static boolean f() {
        try {
            return new File("/system/bin/su").exists() || new File("/system/xbin/su").exists();
        } catch (Exception unused) {
            return false;
        }
    }

    private static String a(Context context) {
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            if (telephonyManager == null) {
                return "";
            }
            return telephonyManager.getSimOperator();
        } catch (Throwable unused) {
            return "";
        }
    }

    private static String g() {
        StringBuilder sb = new StringBuilder();
        try {
            if (p.e()) {
                sb.append("MIUI-");
            } else if (p.b()) {
                sb.append("FLYME-");
            } else {
                String n = p.n();
                if (p.a(n)) {
                    sb.append("EMUI-");
                }
                if (!TextUtils.isEmpty(n)) {
                    sb.append(n);
                    sb.append("-");
                }
            }
            sb.append(Build.VERSION.INCREMENTAL);
        } catch (Throwable unused) {
        }
        return sb.toString();
    }

    private static int h() {
        int rawOffset = TimeZone.getDefault().getRawOffset() / 3600000;
        if (rawOffset < -12) {
            rawOffset = -12;
        }
        if (rawOffset > 12) {
            return 12;
        }
        return rawOffset;
    }

    private String i() {
        if (com.bytedance.sdk.openadsdk.g.f.b(this.a)) {
            return "tv";
        }
        return com.bytedance.sdk.openadsdk.g.f.a(this.a) ? "android_pad" : "android";
    }

    private String j() {
        String a2 = a.a();
        return a2 == null ? b.a() : a2;
    }

    private String d(String str) {
        String a2 = a.a(str);
        if (str != null) {
            return a2;
        }
        String a3 = b.a();
        return a3.concat(a3).substring(8, 24);
    }

    private String k() {
        String h = j.e().h();
        if (TextUtils.isEmpty(h)) {
            return t.i() ? "https://log.sgsnssdk.com/service/2/app_log/" : "https://extlog.snssdk.com/service/2/app_log/";
        }
        if (h.startsWith(UriUtil.HTTP_SCHEME)) {
            return h;
        }
        return "https://" + h;
    }

    /* compiled from: NetApiImpl */
    public static class a {
        final int a;
        final int b;
        final int c;
        final String d;
        public final com.bytedance.sdk.openadsdk.core.c.a e;
        final String f;

        private a(String str, int i, int i2, int i3, String str2, com.bytedance.sdk.openadsdk.core.c.a aVar) {
            this.a = i;
            this.b = i2;
            this.d = str2;
            this.e = aVar;
            this.f = str;
            this.c = i3;
        }

        public static a a(JSONObject jSONObject) {
            String optString = jSONObject.optString("did");
            int optInt = jSONObject.optInt("processing_time_ms");
            int optInt2 = jSONObject.optInt("status_code");
            String optString2 = jSONObject.optString("request_id");
            int optInt3 = jSONObject.optInt(IronSourceConstants.EVENTS_ERROR_REASON);
            com.bytedance.sdk.openadsdk.core.c.a a2 = c.a(jSONObject);
            if (a2 != null) {
                a2.a(jSONObject.optLong("request_after"));
            }
            return new a(optString, optInt, optInt2, optInt3, optString2, a2);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.k
    public void a(JSONObject jSONObject, final k.b bVar) {
        if (jSONObject != null && bVar != null) {
            new f(1, t.g("/api/ad/union/sdk/reward_video/reward/"), t.a(jSONObject), new m.a<JSONObject>() {
                /* class com.bytedance.sdk.openadsdk.core.l.AnonymousClass3 */

                /* JADX WARN: Multi-variable type inference failed */
                /* JADX WARN: Type inference failed for: r0v11, types: [org.json.JSONObject] */
                /* JADX WARNING: Unknown variable types count: 1 */
                @Override // com.bytedance.sdk.adnet.core.m.a
                /* Code decompiled incorrectly, please refer to instructions dump. */
                public void a(com.bytedance.sdk.adnet.core.m<org.json.JSONObject> r5) {
                    /*
                    // Method dump skipped, instructions count: 115
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.l.AnonymousClass3.a(com.bytedance.sdk.adnet.core.m):void");
                }

                @Override // com.bytedance.sdk.adnet.core.m.a
                public void b(m<JSONObject> mVar) {
                    int i = -2;
                    String message = ErrorCode.message(-2);
                    if (!(mVar == null || mVar.b == null)) {
                        i = mVar.b.a;
                        message = mVar.c.getMessage();
                    }
                    bVar.a(i, message);
                }
            }).setRetryPolicy(com.bytedance.sdk.openadsdk.e.b.b().a(10000)).build(com.bytedance.sdk.openadsdk.e.b.a(this.a).c());
        }
    }

    /* compiled from: NetApiImpl */
    public static class b {
        public final int a;
        public final boolean b;
        public final com.bytedance.sdk.openadsdk.core.c.i c;

        private b(int i, boolean z, com.bytedance.sdk.openadsdk.core.c.i iVar) {
            this.a = i;
            this.b = z;
            this.c = iVar;
        }

        public static b a(JSONObject jSONObject) {
            if (jSONObject == null) {
                return null;
            }
            int optInt = jSONObject.optInt("code");
            boolean optBoolean = jSONObject.optBoolean("verify");
            JSONObject optJSONObject = jSONObject.optJSONObject("data");
            com.bytedance.sdk.openadsdk.core.c.i iVar = new com.bytedance.sdk.openadsdk.core.c.i();
            if (optJSONObject != null) {
                try {
                    iVar.a(optJSONObject.optInt(IronSourceConstants.EVENTS_ERROR_REASON));
                    iVar.b(optJSONObject.optInt("corp_type"));
                    iVar.c(optJSONObject.optInt("reward_amount"));
                    iVar.a(optJSONObject.optString("reward_name"));
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
            return new b(optInt, optBoolean, iVar);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.k
    public boolean a(JSONObject jSONObject, int i) {
        boolean z = true;
        if (jSONObject == null || jSONObject.length() <= 0) {
            return true;
        }
        i a2 = i.a();
        new f(1, t.g("/api/ad/union/sdk/stats/"), jSONObject, a2).setRetryPolicy(com.bytedance.sdk.openadsdk.e.b.b().a(10000).b(i)).build(com.bytedance.sdk.openadsdk.e.b.a(this.a).c());
        try {
            m b2 = a2.get();
            if (b2 == null || b2.a == null) {
                return false;
            }
            if (b2.a.optInt("code", -1) != 20000) {
                z = false;
            }
            return z;
        } catch (Throwable unused) {
            return false;
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0053  */
    /* JADX WARNING: Removed duplicated region for block: B:25:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private org.json.JSONObject d(org.json.JSONObject r6) {
        /*
            r5 = this;
            if (r6 != 0) goto L_0x0003
            return r6
        L_0x0003:
            boolean r0 = com.bytedance.sdk.openadsdk.core.l.g     // Catch:{ Exception -> 0x004e }
            if (r0 == 0) goto L_0x004e
            java.lang.String r0 = "cypher"
            r1 = -1
            int r0 = r6.optInt(r0, r1)     // Catch:{ Exception -> 0x004e }
            java.lang.String r1 = "message"
            java.lang.String r1 = r6.optString(r1)     // Catch:{ Exception -> 0x004e }
            r2 = 1
            if (r0 != r2) goto L_0x0020
            java.lang.String r3 = com.bytedance.sdk.openadsdk.core.b.a()     // Catch:{ Exception -> 0x004e }
            java.lang.String r3 = com.bytedance.sdk.openadsdk.core.a.b(r1, r3)     // Catch:{ Exception -> 0x004e }
            goto L_0x0021
        L_0x0020:
            r3 = r1
        L_0x0021:
            r4 = 2
            if (r0 != r4) goto L_0x0042
            boolean r0 = android.text.TextUtils.isEmpty(r1)     // Catch:{ Exception -> 0x004e }
            if (r0 != 0) goto L_0x0042
            int r0 = r1.length()     // Catch:{ Exception -> 0x004e }
            r4 = 17
            if (r0 < r4) goto L_0x0042
            java.lang.String r0 = r1.substring(r2, r4)     // Catch:{ Exception -> 0x004e }
            java.lang.String r0 = r5.d(r0)     // Catch:{ Exception -> 0x004e }
            java.lang.String r1 = r1.substring(r4)     // Catch:{ Exception -> 0x004e }
            java.lang.String r3 = com.bytedance.sdk.openadsdk.core.a.b(r1, r0)     // Catch:{ Exception -> 0x004e }
        L_0x0042:
            boolean r0 = android.text.TextUtils.isEmpty(r3)     // Catch:{ Exception -> 0x004e }
            if (r0 != 0) goto L_0x004e
            org.json.JSONObject r0 = new org.json.JSONObject
            r0.<init>(r3)
            goto L_0x004f
        L_0x004e:
            r0 = r6
        L_0x004f:
            boolean r1 = com.bytedance.sdk.openadsdk.core.l.g
            if (r1 == 0) goto L_0x0054
            r6 = r0
        L_0x0054:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.l.d(org.json.JSONObject):org.json.JSONObject");
    }
}
