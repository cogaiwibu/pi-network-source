package com.bytedance.sdk.openadsdk.c;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.activity.TTBaseVideoActivity;
import com.bytedance.sdk.openadsdk.core.c.g;
import com.bytedance.sdk.openadsdk.g.t;
import com.com.bytedance.overseas.sdk.download.b;
import com.com.bytedance.overseas.sdk.download.c;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: JsAppAdDownloadManager */
public class a implements c {
    private static volatile c a;
    private final b b;
    private final Map<String, b> c = new HashMap();

    @Override // com.bytedance.sdk.openadsdk.c.c
    public void a() {
    }

    @Override // com.bytedance.sdk.openadsdk.c.c
    public void b() {
    }

    private a(b bVar) {
        this.b = bVar;
    }

    public static c a(b bVar) {
        if (a == null) {
            synchronized (c.class) {
                if (a == null) {
                    a = new a(bVar);
                }
            }
        }
        return a;
    }

    @Override // com.bytedance.sdk.openadsdk.c.c
    public void c() {
        this.c.clear();
        a = null;
    }

    @Override // com.bytedance.sdk.openadsdk.c.c
    public void a(Context context, JSONObject jSONObject, String str, int i, boolean z) {
        JSONObject optJSONObject;
        if (context != null && jSONObject != null && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
            g gVar = new g();
            gVar.a(optJSONObject);
            gVar.h(str);
            a(context, gVar, optJSONObject, i, z);
        }
    }

    private void a(Context context, g gVar, JSONObject jSONObject, int i, boolean z) {
        if (context != null && gVar != null && gVar.s() != null && jSONObject != null && this.b != null && this.c.get(gVar.s().a()) == null) {
            String a2 = t.a(i);
            if (!TextUtils.isEmpty(a2)) {
                this.c.put(gVar.s().a(), a(context, gVar, jSONObject, a2, z));
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.c.c
    public void a(Context context, JSONObject jSONObject) {
        JSONObject optJSONObject;
        if (context != null && jSONObject != null && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
            g gVar = new g();
            gVar.a(optJSONObject);
            a(context, gVar);
        }
    }

    private void a(Context context, g gVar) {
        if (context != null && gVar != null && gVar.s() != null) {
            b bVar = this.c.get(gVar.s().a());
            if (bVar != null) {
                bVar.a();
            }
            if (context instanceof TTBaseVideoActivity) {
                ((TTBaseVideoActivity) context).k();
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.c.c
    public void a(JSONObject jSONObject) {
        JSONObject optJSONObject;
        if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
            g gVar = new g();
            gVar.a(optJSONObject);
            a(gVar, optJSONObject);
        }
    }

    private void a(g gVar, JSONObject jSONObject) {
        if (this.b != null && gVar != null && gVar.s() != null) {
            String a2 = gVar.s().a();
            if (this.c.containsKey(a2)) {
                this.c.remove(a2);
                try {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("message", "success");
                    jSONObject2.put("status", "unsubscribed");
                    jSONObject2.put("appad", jSONObject);
                    this.b.a("app_ad_event", jSONObject2);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private b a(Context context, g gVar, JSONObject jSONObject, String str, boolean z) {
        b a2 = c.a(context, gVar, str);
        a2.a(true);
        return a2;
    }
}
