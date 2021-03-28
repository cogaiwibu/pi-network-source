package com.facebook.ads.redexgen.X;

import java.util.HashMap;
import java.util.List;

/* renamed from: com.facebook.ads.redexgen.X.Vy  reason: case insensitive filesystem */
public class C0811Vy implements AbstractC01816i {
    public final /* synthetic */ W0 A00;
    public final /* synthetic */ List A01;

    public C0811Vy(W0 w0, List list) {
        this.A00 = w0;
        this.A01 = list;
    }

    /* JADX INFO: Multiple debug info for r0v5 com.facebook.ads.redexgen.X.Vz: [D('bundledSignalMetadata' com.facebook.ads.redexgen.X.6h), D('systemProperty' com.facebook.ads.redexgen.X.Vz)] */
    @Override // com.facebook.ads.redexgen.X.AbstractC01816i
    public final AbstractC01966x A50() {
        HashMap hashMap = new HashMap();
        for (C01806h r1 : this.A01) {
            if (r1.A02()) {
                String str = (String) r1.A01();
                hashMap.put(str, new C0812Vz(str));
            }
        }
        return this.A00.A02(hashMap);
    }
}
