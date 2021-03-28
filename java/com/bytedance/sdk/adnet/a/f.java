package com.bytedance.sdk.adnet.a;

import com.bytedance.sdk.adnet.b.b;
import com.bytedance.sdk.adnet.core.j;
import com.bytedance.sdk.adnet.core.m;
import com.bytedance.sdk.adnet.err.e;
import com.ironsource.sdk.constants.Events;
import java.io.UnsupportedEncodingException;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: JsonObjectRequest */
public class f extends g<JSONObject> {
    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public f(int i, String str, JSONObject jSONObject, m.a<JSONObject> aVar) {
        this(i, str, jSONObject == null ? null : jSONObject.toString(), aVar);
    }

    public f(int i, String str, String str2, m.a<JSONObject> aVar) {
        super(i, str, str2, aVar);
    }

    /* access modifiers changed from: protected */
    @Override // com.bytedance.sdk.adnet.core.Request, com.bytedance.sdk.adnet.a.g
    public m<JSONObject> a(j jVar) {
        try {
            return m.a(new JSONObject(new String(jVar.b, b.a(jVar.c, Events.CHARSET_FORMAT))), b.a(jVar));
        } catch (UnsupportedEncodingException e) {
            return m.a(new e(e));
        } catch (JSONException e2) {
            return m.a(new e(e2));
        }
    }
}
