package com.bytedance.sdk.openadsdk.core.b;

import android.content.Context;
import com.bytedance.sdk.adnet.a.h;
import com.bytedance.sdk.openadsdk.e.b;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: FrequentCallEventHelper */
public class c {
    public static void a(Context context, String str, long j) {
        new h(1, "https://i.snssdk.com/api/ad/union/sdk/stats/", a(str, j), null).setRetryPolicy(b.b().a(10000)).build(b.a(context).c());
    }

    private static JSONObject a(String str, long j) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("type", "over_freq");
            jSONObject.put("rit", str);
            jSONObject.put("ad_sdk_version", "2.1.5.0");
            jSONObject.put("timestamp", j);
        } catch (JSONException unused) {
        }
        return jSONObject;
    }
}
