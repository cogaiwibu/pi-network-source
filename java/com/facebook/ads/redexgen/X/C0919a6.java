package com.facebook.ads.redexgen.X;

/* renamed from: com.facebook.ads.redexgen.X.a6  reason: case insensitive filesystem */
public class C0919a6 implements LL {
    public int A00;
    public final LL A01;

    public C0919a6(LL ll, int i) {
        this.A01 = ll;
        this.A00 = i;
    }

    @Override // com.facebook.ads.redexgen.X.LL
    public final void ABm(String str) {
        if (this.A00 > 0) {
            this.A01.ABm(str);
            this.A00--;
        }
    }

    @Override // com.facebook.ads.redexgen.X.LL
    public final void flush() {
        this.A01.flush();
    }
}
