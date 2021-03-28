package com.facebook.ads.redexgen.X;

public class ZB implements DY {
    public final IP A00 = new IP(new byte[4]);
    public final /* synthetic */ ZD A01;

    public ZB(ZD zd) {
        this.A01 = zd;
    }

    @Override // com.facebook.ads.redexgen.X.DY
    public final void A48(IQ iq) {
        if (iq.A0F() == 0) {
            iq.A0a(7);
            int A05 = iq.A05() / 4;
            for (int i = 0; i < A05; i++) {
                iq.A0b(this.A00, 4);
                int A052 = this.A00.A05(16);
                this.A00.A09(3);
                if (A052 == 0) {
                    this.A00.A09(13);
                } else {
                    int A053 = this.A00.A05(13);
                    this.A01.A06.put(A053, new Z8(new ZC(this.A01, A053)));
                    ZD.A01(this.A01);
                }
            }
            if (this.A01.A05 != 2) {
                this.A01.A06.remove(0);
            }
        }
    }

    @Override // com.facebook.ads.redexgen.X.DY
    public final void A7S(C0462Ic ic, CM cm, C0340De de) {
    }
}
