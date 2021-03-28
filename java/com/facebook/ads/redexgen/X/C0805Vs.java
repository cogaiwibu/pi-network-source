package com.facebook.ads.redexgen.X;

import java.util.HashMap;
import java.util.List;

/* renamed from: com.facebook.ads.redexgen.X.Vs  reason: case insensitive filesystem */
public class C0805Vs implements AbstractC01816i {
    public final /* synthetic */ EnumC01776e A00;
    public final /* synthetic */ C0807Vu A01;
    public final /* synthetic */ List A02;

    public C0805Vs(C0807Vu vu, List list, EnumC01776e r3) {
        this.A01 = vu;
        this.A02 = list;
        this.A00 = r3;
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC01816i
    public final AbstractC01966x A50() {
        HashMap hashMap = new HashMap();
        for (C01806h r1 : this.A02) {
            if (r1.A02()) {
                String str = (String) r1.A01();
                hashMap.put(str, new C0806Vt(this.A01.A00, str, this.A00));
            }
        }
        return this.A01.A03(hashMap);
    }
}
