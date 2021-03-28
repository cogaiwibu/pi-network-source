package com.facebook.ads.redexgen.X;

/* renamed from: com.facebook.ads.redexgen.X.aC  reason: case insensitive filesystem */
public class C0925aC extends AbstractRunnableC0510Kc {
    public final /* synthetic */ L4 A00;

    public C0925aC(L4 l4) {
        this.A00 = l4;
    }

    @Override // com.facebook.ads.redexgen.X.AbstractRunnableC0510Kc
    public final void A07() {
        if (this.A00.A06()) {
            L4.A03(this.A00);
            L4.A00(this.A00).postDelayed(this, 250);
        }
    }
}
