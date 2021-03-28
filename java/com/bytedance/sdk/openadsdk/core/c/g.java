package com.bytedance.sdk.openadsdk.core.c;

import android.text.TextUtils;
import com.anythink.reactnativejs.utils.Const;
import com.bytedance.sdk.openadsdk.FilterWord;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.internal.NativeProtocol;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tapjoy.TapjoyConstants;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: MaterialMeta */
public class g {
    private int A = -200;
    private int a;
    private f b;
    private String c;
    private List<f> d = new ArrayList();
    private String e;
    private List<String> f = new ArrayList();
    private List<String> g = new ArrayList();
    private List<String> h = new ArrayList();
    private String i;
    private String j;
    private String k;
    private String l = AppEventsConstants.EVENT_PARAM_VALUE_NO;
    private b m;
    private d n;
    private int o;
    private String p;
    private String q;
    private List<FilterWord> r = new ArrayList();
    private long s;
    private int t;
    private j u;
    private boolean v;
    private boolean w;
    private int x;
    private e y;
    private Map<String, Object> z;

    public int a() {
        return this.A;
    }

    public void a(int i2) {
        this.A = i2;
    }

    private int D() {
        e eVar = this.y;
        if (eVar == null) {
            return 0;
        }
        return eVar.a();
    }

    public int b() {
        return this.x;
    }

    public void b(int i2) {
        this.x = i2;
    }

    public int c() {
        e eVar = this.y;
        if (eVar == null) {
            return 1;
        }
        return eVar.b();
    }

    public int d() {
        e eVar = this.y;
        if (eVar == null) {
            return 0;
        }
        return eVar.c();
    }

    public void a(e eVar) {
        this.y = eVar;
    }

    public j e() {
        return this.u;
    }

    public void a(j jVar) {
        this.u = jVar;
    }

    public void a(String str) {
        this.p = str;
    }

    public String f() {
        return this.p;
    }

    public int g() {
        return this.a;
    }

    public void c(int i2) {
        this.a = i2;
    }

    public f h() {
        return this.b;
    }

    public void a(f fVar) {
        this.b = fVar;
    }

    public String i() {
        return this.c;
    }

    public void b(String str) {
        this.c = str;
    }

    public List<f> j() {
        return this.d;
    }

    public void b(f fVar) {
        this.d.add(fVar);
    }

    public String k() {
        return this.e;
    }

    public void c(String str) {
        this.e = str;
    }

    public List<String> l() {
        return this.f;
    }

    public List<String> m() {
        return this.g;
    }

    public List<String> n() {
        return this.h;
    }

    public String o() {
        return this.i;
    }

    public void d(String str) {
        this.i = str;
    }

    public String p() {
        return this.j;
    }

    public void e(String str) {
        this.j = str;
    }

    public String q() {
        return this.k;
    }

    public void f(String str) {
        this.k = str;
    }

    public String r() {
        return this.l;
    }

    public void g(String str) {
        this.l = str;
    }

    public b s() {
        return this.m;
    }

    public void a(b bVar) {
        this.m = bVar;
    }

    public d t() {
        return this.n;
    }

    public void a(d dVar) {
        this.n = dVar;
    }

    public String u() {
        return this.q;
    }

    public void h(String str) {
        this.q = str;
    }

    public int v() {
        return this.o;
    }

    public void d(int i2) {
        this.o = i2;
    }

    public List<FilterWord> w() {
        return this.r;
    }

    public void a(FilterWord filterWord) {
        this.r.add(filterWord);
    }

    public long x() {
        return this.s;
    }

    public void a(long j2) {
        this.s = j2;
    }

    public int y() {
        return this.t;
    }

    public void e(int i2) {
        this.t = i2;
    }

    public boolean z() {
        return this.v;
    }

    public void a(boolean z2) {
        this.v = z2;
    }

    public boolean A() {
        return this.w;
    }

    public void a(Map<String, Object> map) {
        this.z = map;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        g gVar = (g) obj;
        if (!this.l.equals(gVar.l) || !this.q.equals(gVar.q)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return (this.l.hashCode() * 31) + this.q.hashCode();
    }

    public boolean B() {
        if (this.d.isEmpty()) {
            return false;
        }
        if (this.o == 4 && this.d.size() < 3) {
            return false;
        }
        for (f fVar : this.d) {
            if (!fVar.d()) {
                return false;
            }
        }
        return true;
    }

    public void a(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.l = jSONObject.optString("id");
            this.p = jSONObject.optString("source");
            b bVar = new b();
            this.m = bVar;
            bVar.c(jSONObject.optString("pkg_name"));
            this.m.b(jSONObject.optString("name"));
            this.m.a(jSONObject.optString("download_url"));
        }
    }

    public JSONObject C() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("interaction_type", g());
            jSONObject.put("target_url", i());
            jSONObject.put("ad_id", r());
            jSONObject.put("source", f());
            jSONObject.put("screenshot", z());
            jSONObject.put("play_bar_show_time", a());
            f h2 = h();
            if (h2 != null && !TextUtils.isEmpty(h2.a())) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("url", h2.a());
                jSONObject2.put("height", h2.c());
                jSONObject2.put("width", h2.b());
                jSONObject.put(Const.icon, jSONObject2);
            }
            List<f> j2 = j();
            if (j2 != null) {
                JSONArray jSONArray = new JSONArray();
                for (f fVar : j2) {
                    JSONObject jSONObject3 = new JSONObject();
                    jSONObject3.put("url", fVar.a());
                    jSONObject3.put("height", fVar.c());
                    jSONObject3.put("width", fVar.b());
                    jSONArray.put(jSONObject3);
                }
                jSONObject.put(MessengerShareContentUtility.MEDIA_IMAGE, jSONArray);
            }
            List<String> l2 = l();
            if (l2 != null) {
                JSONArray jSONArray2 = new JSONArray();
                for (String str : l2) {
                    jSONArray2.put(str);
                }
                jSONObject.put("show_url", jSONArray2);
            }
            List<String> m2 = m();
            if (m2 != null) {
                JSONArray jSONArray3 = new JSONArray();
                for (String str2 : m2) {
                    jSONArray3.put(str2);
                }
                jSONObject.put(TapjoyConstants.TJC_CLICK_URL, jSONArray3);
            }
            List<String> n2 = n();
            if (n2 != null) {
                JSONArray jSONArray4 = new JSONArray();
                for (String str3 : n2) {
                    jSONArray4.put(str3);
                }
                jSONObject.put("play_start", jSONArray4);
            }
            jSONObject.put("phone_num", k());
            jSONObject.put("title", o());
            jSONObject.put("description", p());
            jSONObject.put("ext", u());
            jSONObject.put("image_mode", v());
            b s2 = s();
            if (s2 != null) {
                JSONObject jSONObject4 = new JSONObject();
                jSONObject4.put(NativeProtocol.BRIDGE_ARG_APP_NAME_STRING, s2.b());
                jSONObject4.put("package_name", s2.c());
                jSONObject4.put("download_url", s2.a());
                jSONObject4.put(FirebaseAnalytics.Param.SCORE, s2.d());
                jSONObject4.put("comment_num", s2.e());
                jSONObject.put(TapjoyConstants.TJC_APP_PLACEMENT, jSONObject4);
            }
            d t2 = t();
            if (t2 != null) {
                JSONObject jSONObject5 = new JSONObject();
                jSONObject5.put("deeplink_url", t2.a());
                jSONObject5.put(MessengerShareContentUtility.FALLBACK_URL, t2.b());
                jSONObject5.put("fallback_type", t2.c());
                jSONObject.put("deep_link", jSONObject5);
            }
            List<FilterWord> w2 = w();
            if (w2 != null) {
                JSONArray jSONArray5 = new JSONArray();
                for (FilterWord filterWord : w2) {
                    JSONObject b2 = b(filterWord);
                    if (b2 != null) {
                        jSONArray5.put(b2);
                    }
                }
                jSONObject.put("filter_words", jSONArray5);
            }
            jSONObject.put("count_down", y());
            jSONObject.put("expiration_time", x());
            j e2 = e();
            if (e2 != null) {
                JSONObject jSONObject6 = new JSONObject();
                jSONObject6.put("cover_height", e2.a());
                jSONObject6.put("cover_width", e2.b());
                jSONObject6.put("resolution", e2.e());
                jSONObject6.put("size", e2.c());
                jSONObject6.put("video_duration", e2.d());
                jSONObject6.put("cover_url", e2.f());
                jSONObject6.put(TapjoyConstants.TJC_VIDEO_URL, e2.g());
                jSONObject6.put("endcard", e2.h());
                jSONObject.put("video", jSONObject6);
            }
            JSONObject jSONObject7 = new JSONObject();
            jSONObject7.put("auto_open", c());
            jSONObject7.put("download_mode", d());
            jSONObject7.put("support_multiple", D());
            jSONObject.put("download_conf", jSONObject7);
            jSONObject.put("ua_policy", b());
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    private JSONObject b(FilterWord filterWord) {
        if (filterWord == null) {
            return null;
        }
        try {
            if (filterWord.isValid()) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("id", filterWord.getId());
                jSONObject.put("name", filterWord.getName());
                jSONObject.put("is_selected", filterWord.getIsSelected());
                if (filterWord.hasSecondOptions()) {
                    JSONArray jSONArray = new JSONArray();
                    for (FilterWord filterWord2 : filterWord.getOptions()) {
                        jSONArray.put(b(filterWord2));
                    }
                    if (jSONArray.length() > 0) {
                        jSONObject.put("options", jSONArray);
                    }
                }
                return jSONObject;
            }
        } catch (Throwable unused) {
        }
        return null;
    }
}
