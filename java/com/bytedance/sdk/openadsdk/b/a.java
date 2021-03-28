package com.bytedance.sdk.openadsdk.b;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.g.m;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import java.util.Iterator;
import java.util.UUID;
import org.json.JSONObject;

/* compiled from: AdEvent */
public class a {
    public final String a;
    public final JSONObject b;

    a(String str, JSONObject jSONObject) {
        this.a = str;
        this.b = jSONObject;
    }

    static a a(Context context, String str, String str2, String str3, JSONObject jSONObject) {
        return new a(UUID.randomUUID().toString(), b(context, str, str2, str3, jSONObject));
    }

    static a a(String str, String str2, String str3, long j, long j2, JSONObject jSONObject) {
        return new a(UUID.randomUUID().toString(), b(str, str2, str3, j, j2, jSONObject));
    }

    private static JSONObject b(Context context, String str, String str2, String str3, JSONObject jSONObject) {
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("event_ts", System.currentTimeMillis());
            jSONObject2.putOpt(ViewHierarchyConstants.TAG_KEY, str);
            jSONObject2.putOpt("label", str2);
            jSONObject2.putOpt("category", "app_union");
            try {
                jSONObject2.putOpt("value", Long.valueOf(Long.parseLong(str3)));
            } catch (NumberFormatException unused) {
                jSONObject2.putOpt("value", 0L);
            }
            jSONObject2.putOpt("is_ad_event", "1");
            jSONObject2.putOpt("nt", Integer.valueOf(m.c(context)));
            if (jSONObject != null) {
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    jSONObject2.putOpt(next, jSONObject.opt(next));
                }
            }
        } catch (Exception unused2) {
        }
        return jSONObject2;
    }

    private static JSONObject b(String str, String str2, String str3, long j, long j2, JSONObject jSONObject) {
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("event_ts", System.currentTimeMillis());
            jSONObject2.putOpt(ViewHierarchyConstants.TAG_KEY, str2);
            jSONObject2.putOpt("label", str3);
            jSONObject2.putOpt("category", str);
            jSONObject2.putOpt("value", Long.valueOf(j));
            jSONObject2.putOpt("is_ad_event", "1");
            jSONObject2.putOpt("ext_value", Long.valueOf(j2));
            if (jSONObject != null) {
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    jSONObject2.putOpt(next, jSONObject.opt(next));
                }
            }
        } catch (Exception unused) {
        }
        return jSONObject2;
    }

    public static a a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            String optString = jSONObject.optString("localId", null);
            JSONObject optJSONObject = jSONObject.optJSONObject("event");
            if (!TextUtils.isEmpty(optString) && optJSONObject != null) {
                return new a(optString, optJSONObject);
            }
        } catch (Throwable unused) {
        }
        return null;
    }

    public String a() {
        if (TextUtils.isEmpty(this.a) || this.b == null) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("localId", this.a);
            jSONObject.put("event", this.b);
        } catch (Throwable unused) {
        }
        return jSONObject.toString();
    }
}
