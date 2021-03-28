package com.bytedance.sdk.openadsdk.core;

import android.text.TextUtils;
import com.anythink.reactnativejs.utils.Const;
import com.bytedance.sdk.openadsdk.FilterWord;
import com.bytedance.sdk.openadsdk.core.c.a;
import com.bytedance.sdk.openadsdk.core.c.b;
import com.bytedance.sdk.openadsdk.core.c.d;
import com.bytedance.sdk.openadsdk.core.c.e;
import com.bytedance.sdk.openadsdk.core.c.f;
import com.bytedance.sdk.openadsdk.core.c.g;
import com.bytedance.sdk.openadsdk.core.c.j;
import com.facebook.internal.NativeProtocol;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tapjoy.TapjoyConstants;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: AdInfoFactory */
public class c {
    public static a a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        try {
            a aVar = new a();
            aVar.a(jSONObject.optString("request_id"));
            aVar.a(jSONObject.optInt("ret"));
            aVar.b(jSONObject.optString("message"));
            if (aVar.b() != 0) {
                return null;
            }
            JSONArray optJSONArray = jSONObject.optJSONArray("creatives");
            if (optJSONArray != null) {
                for (int i = 0; i < optJSONArray.length(); i++) {
                    g b = b(optJSONArray.optJSONObject(i));
                    if (b != null) {
                        aVar.a(b);
                    }
                }
            }
            return aVar;
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public static g b(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        g gVar = new g();
        gVar.c(jSONObject.optInt("interaction_type"));
        gVar.b(jSONObject.optString("target_url"));
        gVar.g(jSONObject.optString("ad_id"));
        gVar.a(jSONObject.optString("source"));
        gVar.a(jSONObject.optInt("play_bar_show_time", -200));
        JSONObject optJSONObject = jSONObject.optJSONObject(Const.icon);
        gVar.a(jSONObject.optBoolean("screenshot", false));
        if (optJSONObject != null) {
            f fVar = new f();
            fVar.a(optJSONObject.optString("url"));
            fVar.b(optJSONObject.optInt("height"));
            fVar.a(optJSONObject.optInt("width"));
            gVar.a(fVar);
        }
        JSONArray optJSONArray = jSONObject.optJSONArray(MessengerShareContentUtility.MEDIA_IMAGE);
        if (optJSONArray != null) {
            for (int i = 0; i < optJSONArray.length(); i++) {
                f fVar2 = new f();
                JSONObject optJSONObject2 = optJSONArray.optJSONObject(i);
                fVar2.a(optJSONObject2.optString("url"));
                fVar2.b(optJSONObject2.optInt("height"));
                fVar2.a(optJSONObject2.optInt("width"));
                gVar.b(fVar2);
            }
        }
        JSONArray optJSONArray2 = jSONObject.optJSONArray("show_url");
        if (optJSONArray2 != null) {
            for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                gVar.l().add(optJSONArray2.optString(i2));
            }
        }
        JSONArray optJSONArray3 = jSONObject.optJSONArray(TapjoyConstants.TJC_CLICK_URL);
        if (optJSONArray3 != null) {
            for (int i3 = 0; i3 < optJSONArray3.length(); i3++) {
                gVar.m().add(optJSONArray3.optString(i3));
            }
        }
        JSONArray optJSONArray4 = jSONObject.optJSONArray("play_start");
        if (optJSONArray4 != null) {
            for (int i4 = 0; i4 < optJSONArray4.length(); i4++) {
                gVar.n().add(optJSONArray4.optString(i4));
            }
        }
        gVar.c(jSONObject.optString("phone_num"));
        gVar.d(jSONObject.optString("title"));
        gVar.e(jSONObject.optString("description"));
        gVar.f(jSONObject.optString("button_text"));
        gVar.h(jSONObject.optString("ext"));
        gVar.d(jSONObject.optInt("image_mode"));
        JSONObject optJSONObject3 = jSONObject.optJSONObject(TapjoyConstants.TJC_APP_PLACEMENT);
        JSONObject optJSONObject4 = jSONObject.optJSONObject("deep_link");
        gVar.a(d(optJSONObject3));
        gVar.a(f(optJSONObject4));
        JSONArray optJSONArray5 = jSONObject.optJSONArray("filter_words");
        if (optJSONArray5 != null) {
            for (int i5 = 0; i5 < optJSONArray5.length(); i5++) {
                FilterWord c = c(optJSONArray5.optJSONObject(i5));
                if (c != null && c.isValid()) {
                    gVar.a(c);
                }
            }
        }
        gVar.e(jSONObject.optInt("count_down"));
        gVar.a(jSONObject.optLong("expiration_time"));
        JSONObject optJSONObject5 = jSONObject.optJSONObject("video");
        if (optJSONObject5 != null) {
            gVar.a(g(optJSONObject5));
        }
        JSONObject optJSONObject6 = jSONObject.optJSONObject("download_conf");
        if (optJSONObject6 != null) {
            gVar.a(e(optJSONObject6));
        }
        gVar.a(h(jSONObject.optJSONObject(Const.USER_DATA)));
        gVar.b(jSONObject.optInt("ua_policy"));
        return gVar;
    }

    private static FilterWord c(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        try {
            FilterWord filterWord = new FilterWord();
            filterWord.setId(jSONObject.optString("id"));
            filterWord.setName(jSONObject.optString("name"));
            filterWord.setIsSelected(jSONObject.optBoolean("is_selected"));
            JSONArray optJSONArray = jSONObject.optJSONArray("options");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                for (int i = 0; i < optJSONArray.length(); i++) {
                    FilterWord c = c(optJSONArray.optJSONObject(i));
                    if (c != null && c.isValid()) {
                        filterWord.addOption(c);
                    }
                }
            }
            return filterWord;
        } catch (Throwable unused) {
            return null;
        }
    }

    private static b d(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        b bVar = new b();
        bVar.b(jSONObject.optString(NativeProtocol.BRIDGE_ARG_APP_NAME_STRING));
        bVar.c(jSONObject.optString("package_name"));
        bVar.a(jSONObject.optString("download_url"));
        bVar.a(jSONObject.optInt(FirebaseAnalytics.Param.SCORE, 4));
        bVar.b(jSONObject.optInt("comment_num", 6870));
        bVar.c(jSONObject.optInt("app_size", 0));
        return bVar;
    }

    private static e e(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        e eVar = new e();
        eVar.b(jSONObject.optInt("auto_open", 1));
        eVar.c(jSONObject.optInt("download_mode", 0));
        eVar.a(jSONObject.optInt("support_multiple", 0));
        return eVar;
    }

    private static d f(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        d dVar = new d();
        dVar.a(jSONObject.optString("deeplink_url"));
        dVar.b(jSONObject.optString(MessengerShareContentUtility.FALLBACK_URL));
        dVar.a(jSONObject.optInt("fallback_type"));
        return dVar;
    }

    private static j g(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        j jVar = new j();
        jVar.a(jSONObject.optInt("cover_height"));
        jVar.b(jSONObject.optInt("cover_width"));
        jVar.a(jSONObject.optString("resolution"));
        jVar.a(jSONObject.optLong("size"));
        jVar.a(jSONObject.optDouble("video_duration"));
        jVar.b(jSONObject.optString("cover_url"));
        jVar.c(jSONObject.optString(TapjoyConstants.TJC_VIDEO_URL));
        jVar.d(jSONObject.optString("endcard"));
        return jVar;
    }

    private static Map<String, Object> h(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        HashMap hashMap = new HashMap();
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            if (!TextUtils.isEmpty(next)) {
                hashMap.put(next, jSONObject.opt(next));
            }
        }
        return hashMap;
    }
}
