package com.facebook.ads.redexgen.X;

public class T7 extends KP {
    public final /* synthetic */ TA A00;
    public final /* synthetic */ C0495Jm A01;

    public T7(TA ta, C0495Jm jm) {
        this.A00 = ta;
        this.A01 = jm;
    }

    @Override // com.facebook.ads.redexgen.X.KP
    public final void A04() {
        if (this.A00.A00.A02() != null) {
            this.A00.A00.A02().onAdError(C0495Jm.A00(this.A01));
        }
    }
}
