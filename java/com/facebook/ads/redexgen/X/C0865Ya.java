package com.facebook.ads.redexgen.X;

/* renamed from: com.facebook.ads.redexgen.X.Ya  reason: case insensitive filesystem */
public final class C0865Ya implements AbstractC0323Cn {
    public int A00;
    public int A01;
    public final int A02 = (this.A04.A0I() & 255);
    public final int A03 = this.A04.A0I();
    public final IQ A04;

    public C0865Ya(YY yy) {
        this.A04 = yy.A00;
        this.A04.A0Z(12);
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC0323Cn
    public final int A6q() {
        return this.A03;
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC0323Cn
    public final boolean A7c() {
        return false;
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC0323Cn
    public final int AC3() {
        int i = this.A02;
        if (i == 8) {
            return this.A04.A0F();
        }
        if (i == 16) {
            return this.A04.A0J();
        }
        int i2 = this.A01;
        this.A01 = i2 + 1;
        if (i2 % 2 != 0) {
            return this.A00 & 15;
        }
        this.A00 = this.A04.A0F();
        return (this.A00 & 240) >> 4;
    }
}
