package com.facebook.ads.redexgen.X;

/* renamed from: com.facebook.ads.redexgen.X.a5  reason: case insensitive filesystem */
public class C0918a5 implements LL {
    public final LK A00;
    public final LL A01;

    public C0918a5(LL ll, int i, int i2) {
        this.A01 = ll;
        this.A00 = new LK(i, i2);
    }

    @Override // com.facebook.ads.redexgen.X.LL
    public final void ABm(String str) {
        this.A00.A05(str);
        if (this.A00.A03() != null && (LN.A08(this.A00))) {
            this.A01.ABm(this.A00.A03());
        }
    }

    @Override // com.facebook.ads.redexgen.X.LL
    public final void flush() {
        this.A00.A04();
        while (this.A00.A03() != null) {
            if (LN.A08(this.A00)) {
                this.A01.ABm(this.A00.A03());
            }
            this.A00.A04();
        }
    }
}
