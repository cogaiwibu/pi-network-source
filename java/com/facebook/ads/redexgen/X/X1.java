package com.facebook.ads.redexgen.X;

import java.lang.ref.WeakReference;

public class X1 extends AbstractRunnableC0510Kc {
    public final WeakReference<C0641Ph> A00;

    public X1(C0641Ph ph) {
        this.A00 = new WeakReference<>(ph);
    }

    public X1(WeakReference<C0641Ph> weakReference) {
        this.A00 = weakReference;
    }

    @Override // com.facebook.ads.redexgen.X.AbstractRunnableC0510Kc
    public final void A07() {
        C0641Ph ph = this.A00.get();
        if (ph != null) {
            ph.A0W();
        }
    }
}
