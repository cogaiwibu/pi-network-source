package com.bytedance.sdk.openadsdk.core.e;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.core.g;
import com.bytedance.sdk.openadsdk.core.j;
import com.bytedance.sdk.openadsdk.g.l;
import com.bytedance.sdk.openadsdk.multipro.b;
import com.bytedance.sdk.openadsdk.multipro.d.a;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import com.tapjoy.TapjoyConstants;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: TTSdkSettings */
public class d implements b {
    private static final String c = null;
    private Map<String, a> a = new HashMap();
    private Set<String> b = new HashSet();
    private String d;
    private int e = 1;
    private int f = 0;
    private long g = TapjoyConstants.TIMER_INCREMENT;
    private int h = 50;
    private int i = 30;
    private int j = 5;
    private String k;
    private String l;
    private int m;
    private int n;
    private String o;
    private String p;

    @Override // com.bytedance.sdk.openadsdk.core.e.b
    public void a() {
        if (b.b()) {
            this.d = a.b("tt_sdk_settings", "xpath", "");
            this.g = a.a("tt_sdk_settings", IronSourceConstants.EVENTS_DURATION, (long) TapjoyConstants.TIMER_INCREMENT);
            this.h = a.a("tt_sdk_settings", "max", 50);
            this.e = a.a("tt_sdk_settings", "download_config_back_dialog", 1);
            this.i = a.a("tt_sdk_settings", "pos_cache_time", 30);
            this.f = a.a("tt_sdk_settings", "download_config_progressbar", 0);
            this.j = a.a("tt_sdk_settings", "vbtt", 5);
            this.k = a.b("tt_sdk_settings", "ads_url", "pangolin16.sgsnssdk.com");
            this.l = a.b("tt_sdk_settings", "app_log_url", "log.sgsnssdk.com/service/2/app_log/");
            this.o = a.b("tt_sdk_settings", "policy_url", c);
            this.p = a.b("tt_sdk_settings", "consent_url", "http://sf1-ttcdn-tos.pstatp.com/obj/union-platform/union_platform_gdpr_607_en.html");
            this.m = a.a("tt_sdk_settings", "coppa", -99);
            g.b().c(this.m);
            this.n = a.a("tt_sdk_settings", "isGdprUser", -1);
            String b2 = a.b("tt_sdk_settings", "ad_slot_conf", null);
            if (!TextUtils.isEmpty(b2)) {
                try {
                    JSONArray jSONArray = new JSONArray(b2);
                    int length = jSONArray.length();
                    if (length > 0) {
                        this.a.clear();
                        for (int i2 = 0; i2 < length; i2++) {
                            a b3 = b(jSONArray.optJSONObject(i2));
                            if (b3 != null) {
                                this.a.put(b3.a, b3);
                            }
                        }
                    }
                } catch (Exception unused) {
                }
            }
        } else {
            SharedPreferences k2 = k();
            this.d = k2.getString("xpath", "");
            this.g = k2.getLong(IronSourceConstants.EVENTS_DURATION, TapjoyConstants.TIMER_INCREMENT);
            this.h = k2.getInt("max", 50);
            this.e = k2.getInt("download_config_back_dialog", 1);
            this.i = k2.getInt("pos_cache_time", 30);
            this.f = k2.getInt("download_config_progressbar", 0);
            this.j = k2.getInt("vbtt", 5);
            this.k = k2.getString("ads_url", "pangolin16.sgsnssdk.com");
            this.l = k2.getString("app_log_url", "log.sgsnssdk.com/service/2/app_log/");
            this.o = k2.getString("policy_url", c);
            this.p = k2.getString("consent_url", "http://sf1-ttcdn-tos.pstatp.com/obj/union-platform/union_platform_gdpr_607_en.html");
            this.m = k2.getInt("coppa", -99);
            this.n = k2.getInt("isGdprUser", -1);
            g.b().c(this.m);
            String string = k2.getString("ad_slot_conf", null);
            if (!TextUtils.isEmpty(string)) {
                try {
                    JSONArray jSONArray2 = new JSONArray(string);
                    int length2 = jSONArray2.length();
                    if (length2 > 0) {
                        this.a.clear();
                        for (int i3 = 0; i3 < length2; i3++) {
                            a b4 = b(jSONArray2.optJSONObject(i3));
                            if (b4 != null) {
                                this.a.put(b4.a, b4);
                            }
                        }
                    }
                } catch (Exception unused2) {
                }
            }
        }
    }

    private static a b(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        String optString = jSONObject.optString("code_id");
        int optInt = jSONObject.optInt("auto_play", 1);
        int optInt2 = jSONObject.optInt("voice_control", 1);
        int optInt3 = jSONObject.optInt("rv_preload", 2);
        int optInt4 = jSONObject.optInt("nv_preload", 1);
        int optInt5 = jSONObject.optInt("read_video_from_cache", 1);
        int optInt6 = jSONObject.optInt("proportion_watching", 100);
        int optInt7 = jSONObject.optInt("skip_time_displayed", 0);
        int optInt8 = jSONObject.optInt("video_skip_result", 2);
        int optInt9 = jSONObject.optInt("reg_creative_control", 1);
        return a.a().a(optString).c(optInt).d(optInt2).e(optInt3).f(optInt4).g(optInt5).h(optInt6).i(optInt7).j(optInt8).k(optInt9).a(jSONObject.optInt("voice_control", 2)).b(jSONObject.optInt("play_bar_show_time", 3));
    }

    @Override // com.bytedance.sdk.openadsdk.core.e.b
    public void a(JSONObject jSONObject) {
        this.d = jSONObject.optString("xpath");
        this.i = jSONObject.optInt("pos_cache_time", 30);
        JSONObject optJSONObject = jSONObject.optJSONObject("feq_policy");
        if (optJSONObject != null) {
            this.g = optJSONObject.optLong(IronSourceConstants.EVENTS_DURATION) * 1000;
            this.h = optJSONObject.optInt("max");
        }
        this.j = jSONObject.optInt("vbtt", 5);
        this.k = jSONObject.optString("ads_url");
        this.l = jSONObject.optString("app_log_url");
        this.o = jSONObject.optString("privacy_url", c);
        l.e("TTWebsiteActivity", "mPolicyUrl=" + this.o);
        this.p = jSONObject.optString("consent_url", "http://sf1-ttcdn-tos.pstatp.com/obj/union-platform/union_platform_gdpr_607_en.html");
        JSONObject optJSONObject2 = jSONObject.optJSONObject("download_config");
        if (optJSONObject2 != null) {
            this.e = optJSONObject2.optInt("is_enable_back_dialog", 1);
            this.f = optJSONObject2.optInt("landing_page_progressbar_visible", 0);
        }
        this.m = jSONObject.optInt("coppa", -99);
        g.b().c(this.m);
        c(jSONObject);
        String str = null;
        JSONArray optJSONArray = jSONObject.optJSONArray("ad_slot_conf_list");
        if (optJSONArray != null) {
            str = optJSONArray.toString();
            int length = optJSONArray.length();
            if (length > 0) {
                this.a.clear();
                for (int i2 = 0; i2 < length; i2++) {
                    a b2 = b(optJSONArray.optJSONObject(i2));
                    if (b2 != null) {
                        this.a.put(b2.a, b2);
                    }
                }
            }
        }
        g(str);
    }

    private void c(JSONObject jSONObject) {
        int optInt = jSONObject.optInt("is_gdpr_user", -1);
        this.n = optInt;
        if (optInt != -1 && optInt != 1 && optInt != 0) {
            this.n = -1;
        }
    }

    private void g(String str) {
        SharedPreferences.Editor editor;
        if (b.b()) {
            a.a("tt_sdk_settings", "xpath", this.d);
            a.a("tt_sdk_settings", IronSourceConstants.EVENTS_DURATION, Long.valueOf(this.g));
            a.a("tt_sdk_settings", "max", Integer.valueOf(this.h));
            a.a("tt_sdk_settings", "download_config_back_dialog", Integer.valueOf(this.e));
            a.a("tt_sdk_settings", "pos_cache_time", Integer.valueOf(this.i));
            a.a("tt_sdk_settings", "download_config_progressbar", Integer.valueOf(this.f));
            a.a("tt_sdk_settings", "vbtt", Integer.valueOf(this.j));
            a.a("tt_sdk_settings", "ads_url", this.k);
            a.a("tt_sdk_settings", "app_log_url", this.l);
            a.a("tt_sdk_settings", "policy_url", this.o);
            a.a("tt_sdk_settings", "consent_url", this.p);
            a.a("tt_sdk_settings", "coppa", Integer.valueOf(this.m));
            a.a("tt_sdk_settings", "isGdprUser", Integer.valueOf(this.n));
            if (!TextUtils.isEmpty(str)) {
                a.a("tt_sdk_settings", "ad_slot_conf", str);
                return;
            }
            return;
        }
        SharedPreferences.Editor edit = k().edit();
        edit.putString("xpath", this.d);
        edit.putLong(IronSourceConstants.EVENTS_DURATION, this.g);
        edit.putInt("max", this.h);
        edit.putInt("download_config_back_dialog", this.e);
        edit.putInt("pos_cache_time", this.i);
        edit.putInt("download_config_progressbar", this.f);
        edit.putInt("vbtt", this.j);
        edit.putString("ads_url", this.k);
        edit.putString("app_log_url", this.l);
        edit.putString("policy_url", this.o);
        edit.putString("consent_url", this.p);
        edit.putInt("coppa", this.m);
        edit.putInt("isGdprUser", this.n);
        if (!TextUtils.isEmpty(str)) {
            editor = edit;
            editor.putString("ad_slot_conf", str);
        } else {
            editor = edit;
        }
        editor.apply();
    }

    private SharedPreferences k() {
        return j.a().getSharedPreferences("tt_sdk_settings", 0);
    }

    public int b() {
        return this.n;
    }

    public String c() {
        return this.d;
    }

    public long d() {
        return this.g;
    }

    public int e() {
        return this.h;
    }

    public boolean a(int i2) {
        return e(String.valueOf(i2)).c == 1;
    }

    public boolean a(String str) {
        return e(String.valueOf(str)).h == 1;
    }

    public int b(String str) {
        return e(String.valueOf(str)).i;
    }

    public int c(String str) {
        return e(str).k;
    }

    public boolean d(String str) {
        if (str == null || j.e().e(String.valueOf(str)).f == 1) {
            return true;
        }
        return false;
    }

    public boolean b(int i2) {
        if (i2 != 0 && j.e().e(String.valueOf(i2)).l == 1) {
            return true;
        }
        return false;
    }

    public int c(int i2) {
        return e(String.valueOf(i2)).b;
    }

    public int f() {
        return this.j;
    }

    public String g() {
        return this.k;
    }

    public String h() {
        return this.l;
    }

    public String i() {
        return this.o;
    }

    public String j() {
        return this.p;
    }

    public a e(String str) {
        a aVar = this.a.get(str);
        return aVar == null ? h(str) : aVar;
    }

    private a h(String str) {
        return a.a().a(str).c(1).d(!this.b.contains(str) ? 1 : 0).e(2).f(1).g(1).h(100).i(0).k(1).a(2).b(3);
    }

    public void f(String str) {
        this.b.add(str);
    }
}
