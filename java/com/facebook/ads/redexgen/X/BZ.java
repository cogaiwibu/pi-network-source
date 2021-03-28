package com.facebook.ads.redexgen.X;

public abstract class BZ {
    public int A00;

    public final void A00(int i) {
        this.A00 |= i;
    }

    public final void A01(int i) {
        this.A00 &= i ^ -1;
    }

    public final void A02(int i) {
        this.A00 = i;
    }

    public final boolean A03() {
        return A06(Integer.MIN_VALUE);
    }

    public final boolean A04() {
        return A06(4);
    }

    public final boolean A05() {
        return A06(1);
    }

    public final boolean A06(int i) {
        return (this.A00 & i) == i;
    }

    public void A07() {
        this.A00 = 0;
    }
}
