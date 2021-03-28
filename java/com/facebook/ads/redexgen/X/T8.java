package com.facebook.ads.redexgen.X;

public class T8 extends KP {
    public final /* synthetic */ T9 A00;

    public T8(T9 t9) {
        this.A00 = t9;
    }

    @Override // com.facebook.ads.redexgen.X.KP
    public final void A04() {
        if (this.A00.A01.A00.A02() != null) {
            this.A00.A01.A00.A02().onAdsLoaded();
        }
    }
}
