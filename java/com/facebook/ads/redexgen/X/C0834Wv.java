package com.facebook.ads.redexgen.X;

/* renamed from: com.facebook.ads.redexgen.X.Wv  reason: case insensitive filesystem */
public class C0834Wv extends AbstractRunnableC0510Kc {
    public final /* synthetic */ C0821Wi A00;

    public C0834Wv(C0821Wi wi) {
        this.A00 = wi;
    }

    @Override // com.facebook.ads.redexgen.X.AbstractRunnableC0510Kc
    public final void A07() {
        for (C02208d event : C02198c.A02()) {
            C02198c.A0C(this.A00, event.A02(), event.A00(), event.A01(), false);
        }
        C02198c.A02().clear();
    }
}
