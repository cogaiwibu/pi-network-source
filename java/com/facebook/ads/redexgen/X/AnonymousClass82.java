package com.facebook.ads.redexgen.X;

import androidx.annotation.Nullable;

/* renamed from: com.facebook.ads.redexgen.X.82  reason: invalid class name */
public class AnonymousClass82 extends XQ {
    public final /* synthetic */ OY A00;

    public AnonymousClass82(OY oy) {
        this.A00 = oy;
    }

    @Override // com.facebook.ads.redexgen.X.NN
    public final void A8t() {
    }

    @Override // com.facebook.ads.redexgen.X.XQ, com.facebook.ads.redexgen.X.NN
    public final void A9b(int i, @Nullable String str) {
        this.A00.A0B.set(true);
        this.A00.A09.AA2();
    }

    @Override // com.facebook.ads.redexgen.X.XQ, com.facebook.ads.redexgen.X.NN
    public final void A9i() {
        if (!this.A00.A0B.get() && this.A00.A0A.compareAndSet(false, true)) {
            this.A00.A09.A9i();
        }
    }
}
