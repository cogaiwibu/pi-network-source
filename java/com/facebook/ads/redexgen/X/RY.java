package com.facebook.ads.redexgen.X;

public abstract class RY implements AnonymousClass79 {
    public final boolean A00;

    public abstract void A00();

    public abstract void A01(boolean z);

    public RY(boolean z) {
        this.A00 = z;
    }

    @Override // com.facebook.ads.redexgen.X.AnonymousClass79
    public final void A97() {
        if (this.A00) {
            A00();
        } else {
            A01(false);
        }
    }

    @Override // com.facebook.ads.redexgen.X.AnonymousClass79
    public final void A9E() {
        A01(true);
    }
}
