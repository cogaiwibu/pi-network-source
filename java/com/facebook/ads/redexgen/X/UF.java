package com.facebook.ads.redexgen.X;

import java.util.HashMap;

public class UF implements AbstractC01816i {
    public final /* synthetic */ US A00;
    public final /* synthetic */ HashMap A01;

    public UF(US us, HashMap hashMap) {
        this.A00 = us;
        this.A01 = hashMap;
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC01816i
    public final AbstractC01966x A50() {
        return this.A00.A06(Integer.MIN_VALUE, this.A01);
    }
}
