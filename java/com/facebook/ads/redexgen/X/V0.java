package com.facebook.ads.redexgen.X;

import org.json.JSONException;
import org.json.JSONObject;

public class V0 implements AbstractC01886p<String> {
    public final String A00;
    public final boolean A01;

    public V0(String str) {
        this.A00 = str;
        this.A01 = V1.A01().hasSystemFeature(str);
    }

    /* access modifiers changed from: private */
    /* renamed from: A00 */
    public final JSONObject ADW(String str, JSONObject jSONObject) throws JSONException {
        jSONObject.put(this.A00, this.A01);
        return jSONObject;
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC01886p
    public final boolean A7a(Object obj) {
        V0 v0 = (V0) obj;
        return this.A00.equals(v0.A00) && this.A01 == v0.A01;
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC01886p
    public final int ADC() {
        return this.A00.getBytes().length + 8;
    }
}
