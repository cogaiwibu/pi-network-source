package com.facebook.ads.redexgen.X;

import java.util.ArrayList;
import java.util.Collections;

public class VR implements AbstractC01816i {
    public final /* synthetic */ C0797Vk A00;

    public VR(C0797Vk vk) {
        this.A00 = vk;
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC01816i
    public final AbstractC01966x A50() {
        if (this.A00.A05 == null) {
            return this.A00.A08(EnumC01926t.A07);
        }
        ArrayList arrayList = new ArrayList();
        int min = Math.min(this.A00.A05.length, this.A00.A03.A0U());
        for (int i = 0; i < min; i++) {
            arrayList.add(this.A00.A05[i].name);
        }
        Collections.sort(arrayList);
        return this.A00.A0F(arrayList);
    }
}
