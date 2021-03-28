package com.facebook.ads.redexgen.X;

import java.util.ArrayList;

public class VU implements AbstractC01816i {
    public final /* synthetic */ C0797Vk A00;

    public VU(C0797Vk vk) {
        this.A00 = vk;
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC01816i
    public final AbstractC01966x A50() {
        if (this.A00.A06 == null) {
            return this.A00.A08(EnumC01926t.A07);
        }
        ArrayList arrayList = new ArrayList();
        int min = Math.min(this.A00.A06.length, this.A00.A03.A0U());
        for (int i = 0; i < min; i++) {
            arrayList.add(this.A00.A06[i]);
        }
        return this.A00.A0F(arrayList);
    }
}
