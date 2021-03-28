package com.facebook.ads.redexgen.X;

import androidx.annotation.Nullable;
import java.util.Map;
import org.json.JSONObject;

/* renamed from: com.facebook.ads.redexgen.X.3r  reason: invalid class name and case insensitive filesystem */
public class C01143r extends AbstractC0393Fj {
    public final JSONObject A00;
    @Nullable
    public final JSONObject A01;

    public C01143r(C0402Fu fu, JSONObject jSONObject, @Nullable JSONObject jSONObject2) {
        super(fu, QV.A03);
        this.A00 = jSONObject;
        this.A01 = jSONObject2;
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC0393Fj, com.facebook.ads.redexgen.X.QQ
    public final void A3P(Map<QB, QV> map, Map<AbstractC0401Ft, QI> map2) {
        super.A00.A06(this.A00, this.A01);
        super.A3P(map, map2);
    }
}
