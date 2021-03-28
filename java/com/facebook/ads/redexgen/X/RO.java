package com.facebook.ads.redexgen.X;

public class RO implements NT {
    public final /* synthetic */ int A00;
    public final /* synthetic */ RP A01;
    public final /* synthetic */ C1007bZ A02;

    public RO(RP rp, int i, C1007bZ bZVar) {
        this.A01 = rp;
        this.A00 = i;
        this.A02 = bZVar;
    }

    @Override // com.facebook.ads.redexgen.X.NT
    public final void A9g(boolean z) {
        if (this.A00 == 0) {
            this.A02.A1R(this.A01.A04);
        }
        this.A02.A1U(z, true);
    }
}
