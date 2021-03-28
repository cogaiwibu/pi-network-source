package com.facebook.ads.redexgen.X;

public class RC extends AbstractC00370q {
    public final /* synthetic */ RD A00;

    public RC(RD rd) {
        this.A00 = rd;
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC00370q
    public final void A01() {
        boolean z;
        AbstractC0685Qz A0F = this.A00.A02.A0A();
        if (this.A00.A00 != null) {
            z = true;
        } else {
            z = false;
        }
        A0F.A3b(z);
        if (this.A00.A00 != null) {
            this.A00.A00.A94(this.A00);
        }
    }
}
