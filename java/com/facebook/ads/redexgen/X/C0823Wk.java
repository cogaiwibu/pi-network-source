package com.facebook.ads.redexgen.X;

/* renamed from: com.facebook.ads.redexgen.X.Wk  reason: case insensitive filesystem */
public class C0823Wk extends AbstractRunnableC0510Kc {
    public final /* synthetic */ C0585Nd A00;

    public C0823Wk(C0585Nd nd) {
        this.A00 = nd;
    }

    @Override // com.facebook.ads.redexgen.X.AbstractRunnableC0510Kc
    public final void A07() {
        this.A00.clearAnimation();
        C0535Le.A0H(1000, C0585Nd.A00(this.A00), this.A00);
        C0585Nd nd = this.A00;
        nd.postDelayed(this, (long) C0585Nd.A01(nd));
    }
}
