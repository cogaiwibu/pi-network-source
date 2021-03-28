package com.facebook.ads.redexgen.X;

import java.util.Locale;

public class VK implements AbstractC01816i {
    public final /* synthetic */ VN A00;

    public VK(VN vn) {
        this.A00 = vn;
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC01816i
    public final AbstractC01966x A50() {
        return this.A00.A09(Locale.getDefault().getCountry());
    }
}
