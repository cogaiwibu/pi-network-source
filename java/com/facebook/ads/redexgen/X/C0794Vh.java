package com.facebook.ads.redexgen.X;

import java.util.ArrayList;

/* renamed from: com.facebook.ads.redexgen.X.Vh  reason: case insensitive filesystem */
public class C0794Vh implements AbstractC01816i {
    public final /* synthetic */ C0797Vk A00;

    public C0794Vh(C0797Vk vk) {
        this.A00 = vk;
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC01816i
    public final AbstractC01966x A50() {
        if (this.A00.A04 == null) {
            return this.A00.A08(EnumC01926t.A07);
        }
        ArrayList arrayList = new ArrayList();
        int min = Math.min(this.A00.A04.length, this.A00.A03.A0U());
        for (int i = 0; i < min; i++) {
            arrayList.add(this.A00.A04[i].name);
        }
        return this.A00.A0F(arrayList);
    }
}
