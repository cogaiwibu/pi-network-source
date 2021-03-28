package com.facebook.ads.redexgen.X;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

public class RF extends AbstractRunnableC0510Kc {
    public final /* synthetic */ RG A00;
    public final /* synthetic */ Map A01;
    public final /* synthetic */ Map A02;

    public RF(RG rg, Map map, Map map2) {
        this.A00 = rg;
        this.A02 = map;
        this.A01 = map2;
    }

    @Override // com.facebook.ads.redexgen.X.AbstractRunnableC0510Kc
    public final void A07() {
        if (!TextUtils.isEmpty(this.A00.A0L)) {
            HashMap hashMap = new HashMap();
            hashMap.putAll(this.A02);
            hashMap.putAll(this.A01);
            if (this.A00.A0D != null) {
                this.A00.A0D.A8J(this.A00.A0L, hashMap);
            }
        }
    }
}
