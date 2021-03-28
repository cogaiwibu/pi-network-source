package com.bytedance.sdk.adnet.a;

import com.bytedance.sdk.adnet.b.b;
import com.bytedance.sdk.adnet.core.j;
import com.bytedance.sdk.adnet.core.m;
import com.bytedance.sdk.adnet.err.e;
import com.ironsource.sdk.constants.Events;
import java.io.UnsupportedEncodingException;
import org.json.JSONObject;

/* compiled from: JsonStringRequest */
public class h extends g<String> {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public h(int i, String str, JSONObject jSONObject, m.a<String> aVar) {
        super(i, str, jSONObject == null ? null : jSONObject.toString(), aVar);
    }

    /* access modifiers changed from: protected */
    @Override // com.bytedance.sdk.adnet.core.Request, com.bytedance.sdk.adnet.a.g
    public m<String> a(j jVar) {
        try {
            return m.a(new String(jVar.b, b.a(jVar.c, Events.CHARSET_FORMAT)), b.a(jVar));
        } catch (UnsupportedEncodingException e) {
            return m.a(new e(e));
        }
    }
}
