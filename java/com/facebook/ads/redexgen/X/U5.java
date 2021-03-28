package com.facebook.ads.redexgen.X;

public class U5 implements AbstractC01816i {
    public final /* synthetic */ U7 A00;

    public U5(U7 u7) {
        this.A00 = u7;
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC01816i
    public final AbstractC01966x A50() {
        if (this.A00.A01 == null) {
            return this.A00.A08(EnumC01926t.A07);
        }
        U7 u7 = this.A00;
        return u7.A09(u7.A01.processName);
    }
}
