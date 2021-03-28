package com.facebook.ads.redexgen.X;

public final class AC {
    public int A00;
    public int A01;
    public AO A02;
    public boolean A03;

    public AC() {
    }

    public /* synthetic */ AC(A9 a9) {
        this();
    }

    public final void A03(int i) {
        this.A01 += i;
    }

    public final void A04(int i) {
        boolean z = true;
        if (!this.A03 || this.A00 == 4) {
            this.A03 = true;
            this.A00 = i;
            return;
        }
        if (i != 4) {
            z = false;
        }
        I1.A03(z);
    }

    public final void A05(AO ao) {
        this.A02 = ao;
        this.A01 = 0;
        this.A03 = false;
    }

    public final boolean A06(AO ao) {
        return ao != this.A02 || this.A01 > 0 || this.A03;
    }
}
