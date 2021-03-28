package com.facebook.ads.redexgen.X;

public final class YH implements CT {
    public final long A00;
    public final CS A01;

    public YH(long j) {
        this(j, 0);
    }

    public YH(long j, long j2) {
        CU cu;
        this.A00 = j;
        if (j2 == 0) {
            cu = CU.A04;
        } else {
            cu = new CU(0, j2);
        }
        this.A01 = new CS(cu);
    }

    @Override // com.facebook.ads.redexgen.X.CT
    public final long A65() {
        return this.A00;
    }

    @Override // com.facebook.ads.redexgen.X.CT
    public final CS A6s(long j) {
        return this.A01;
    }

    @Override // com.facebook.ads.redexgen.X.CT
    public final boolean A7m() {
        return false;
    }
}
