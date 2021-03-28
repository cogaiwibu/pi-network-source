package com.facebook.ads.redexgen.X;

public abstract class CY {
    public final CW A00;

    public abstract void A0C(IQ iq, long j) throws AN;

    public abstract boolean A0D(IQ iq) throws AN;

    public CY(CW cw) {
        this.A00 = cw;
    }

    public final void A00(IQ iq, long j) throws AN {
        if (A0D(iq)) {
            A0C(iq, j);
        }
    }
}
