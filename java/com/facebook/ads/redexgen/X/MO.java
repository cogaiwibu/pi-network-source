package com.facebook.ads.redexgen.X;

public class MO extends AbstractRunnableC0510Kc {
    public final /* synthetic */ C0532Lb A00;

    public MO(C0532Lb lb) {
        this.A00 = lb;
    }

    @Override // com.facebook.ads.redexgen.X.AbstractRunnableC0510Kc
    public final void A07() {
        if (!(this.A00.A03)) {
            this.A00.A0A.A03(new C02137s(this.A00.getCurrentPositionInMillis()));
            this.A00.A06.postDelayed(this, (long) this.A00.A00);
        }
    }
}
