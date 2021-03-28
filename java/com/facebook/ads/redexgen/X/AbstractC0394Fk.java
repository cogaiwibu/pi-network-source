package com.facebook.ads.redexgen.X;

import java.util.Map;

/* renamed from: com.facebook.ads.redexgen.X.Fk  reason: case insensitive filesystem */
public abstract class AbstractC0394Fk implements QQ {
    public final QI A00;
    public final AnonymousClass48 A01;

    public AbstractC0394Fk(AnonymousClass48 r1, QI qi) {
        this.A01 = r1;
        this.A00 = qi;
    }

    @Override // com.facebook.ads.redexgen.X.QQ
    public void A3P(Map<QB, QV> map, Map<AbstractC0401Ft, QI> map2) {
        map2.put(this.A01, this.A00);
    }
}
