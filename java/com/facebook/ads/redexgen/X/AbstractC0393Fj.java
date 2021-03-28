package com.facebook.ads.redexgen.X;

import java.util.Map;

/* renamed from: com.facebook.ads.redexgen.X.Fj  reason: case insensitive filesystem */
public abstract class AbstractC0393Fj implements QQ {
    public final C0402Fu A00;
    public final QV A01;

    public AbstractC0393Fj(C0402Fu fu, QV qv) {
        this.A00 = fu;
        this.A01 = qv;
    }

    @Override // com.facebook.ads.redexgen.X.QQ
    public void A3P(Map<QB, QV> map, Map<AbstractC0401Ft, QI> map2) {
        map.put(this.A00, this.A01);
    }
}
