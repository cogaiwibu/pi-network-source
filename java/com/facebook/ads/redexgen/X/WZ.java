package com.facebook.ads.redexgen.X;

import javax.annotation.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

public final class WZ extends AbstractC01966x<AnonymousClass6R> {
    public WZ(long j, @Nullable C01946v r9, AnonymousClass6R r10) {
        super(j, r9, r10, EnumC01956w.A0B);
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC01966x
    public final int A07() {
        return ((AnonymousClass6R) A08()).A04();
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC01966x
    public final JSONObject A09(JSONObject jSONObject) throws JSONException {
        return ((AnonymousClass6R) A08()).A05(jSONObject);
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC01966x
    public final boolean A0B(AbstractC01966x<AnonymousClass6R> r3) {
        return ((AnonymousClass6R) A08()).A06(r3.A08());
    }
}
