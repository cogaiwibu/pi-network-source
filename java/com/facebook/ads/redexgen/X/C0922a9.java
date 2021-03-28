package com.facebook.ads.redexgen.X;

/* renamed from: com.facebook.ads.redexgen.X.a9  reason: case insensitive filesystem */
public class C0922a9 implements LL {
    public int A00;
    public final LL A01;
    public final LL A02;

    public C0922a9(LL ll, int i, LL ll2) {
        this.A01 = ll;
        this.A00 = i;
        this.A02 = ll2;
    }

    @Override // com.facebook.ads.redexgen.X.LL
    public final void ABm(String str) {
        if (this.A00 > 0) {
            this.A01.ABm(str);
            this.A01.flush();
            this.A00--;
            return;
        }
        this.A02.ABm(str);
    }

    @Override // com.facebook.ads.redexgen.X.LL
    public final void flush() {
        this.A02.flush();
    }
}
