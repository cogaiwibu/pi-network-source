package com.facebook.ads.redexgen.X;

/* renamed from: com.facebook.ads.redexgen.X.Yg  reason: case insensitive filesystem */
public class C0871Yg implements CT {
    public final /* synthetic */ C0872Yh A00;

    public C0871Yg(C0872Yh yh) {
        this.A00 = yh;
    }

    @Override // com.facebook.ads.redexgen.X.CT
    public final long A65() {
        return this.A00.A0B.A04(this.A00.A07);
    }

    @Override // com.facebook.ads.redexgen.X.CT
    public final CS A6s(long j) {
        if (j == 0) {
            return new CS(new CU(0, this.A00.A09));
        }
        long A05 = this.A00.A0B.A05(j);
        C0872Yh yh = this.A00;
        return new CS(new CU(j, yh.A00(yh.A09, A05, 30000)));
    }

    @Override // com.facebook.ads.redexgen.X.CT
    public final boolean A7m() {
        return true;
    }
}
