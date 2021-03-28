package com.facebook.ads.redexgen.X;

import java.util.List;

/* renamed from: com.facebook.ads.redexgen.X.Ab  reason: case insensitive filesystem */
public abstract class AbstractC0269Ab extends AbstractC0862Xx implements GG {
    public static String[] A02;
    public long A00;
    public GG A01;

    static {
        A00();
    }

    public static void A00() {
        A02 = new String[]{"", "mui60dwzFhaHNm2Uk6c71g13RzPqoL9o", "B0rzWlns", "IaExOe45iIyqIoKsg3ghGHNojNO5y7aX", "6x0KWKc5lmTcd6rSDKCIntspSHI5N7vM", "fpXFGNqhd64a2XzCiJ5Y2uwqVb67lOfi", "JEeTPk6X6cicZdwnLWr3cLjXKJNjxOw", "om0z9vsHwazWN6uDNjDMJ"};
    }

    public abstract void A08();

    @Override // com.facebook.ads.redexgen.X.BZ
    public final void A07() {
        super.A07();
        this.A01 = null;
    }

    public final void A09(long j, GG gg, long j2) {
        super.A01 = j;
        this.A01 = gg;
        if (j2 == Long.MAX_VALUE) {
            j2 = super.A01;
        }
        this.A00 = j2;
        if (A02[0].length() != 0) {
            throw new RuntimeException();
        }
        String[] strArr = A02;
        strArr[1] = "xukRyz5yFwN1nVXA8Rs2f92E1X9llmA1";
        strArr[1] = "xukRyz5yFwN1nVXA8Rs2f92E1X9llmA1";
    }

    @Override // com.facebook.ads.redexgen.X.GG
    public final List<GF> A5p(long j) {
        return this.A01.A5p(j - this.A00);
    }

    @Override // com.facebook.ads.redexgen.X.GG
    public final long A6E(int i) {
        return this.A01.A6E(i) + this.A00;
    }

    @Override // com.facebook.ads.redexgen.X.GG
    public final int A6F() {
        return this.A01.A6F();
    }

    @Override // com.facebook.ads.redexgen.X.GG
    public final int A6Y(long j) {
        return this.A01.A6Y(j - this.A00);
    }
}
