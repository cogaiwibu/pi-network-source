package com.facebook.ads.redexgen.X;

public class W7 implements AbstractC01816i {
    public final /* synthetic */ WE A00;

    public W7(WE we) {
        this.A00 = we;
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC01816i
    public final AbstractC01966x A50() {
        if (this.A00.A00 == null) {
            return this.A00.A08(EnumC01926t.A07);
        }
        WE we = this.A00;
        return we.A05(we.A00.getPhoneType());
    }
}
