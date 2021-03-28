package com.facebook.ads.redexgen.X;

public final class YZ implements AbstractC0323Cn {
    public final int A00 = this.A02.A0I();
    public final int A01 = this.A02.A0I();
    public final IQ A02;

    public YZ(YY yy) {
        this.A02 = yy.A00;
        this.A02.A0Z(12);
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC0323Cn
    public final int A6q() {
        return this.A01;
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC0323Cn
    public final boolean A7c() {
        return this.A00 != 0;
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC0323Cn
    public final int AC3() {
        int i = this.A00;
        return i == 0 ? this.A02.A0I() : i;
    }
}
