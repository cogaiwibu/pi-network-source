package com.facebook.ads.redexgen.X;

import java.util.Arrays;

/* renamed from: com.facebook.ads.redexgen.X.bS  reason: case insensitive filesystem */
public class C1001bS extends AbstractC00350o {
    public static byte[] A01;
    public final /* synthetic */ C1007bZ A00;

    static {
        A01();
    }

    public static String A00(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A01, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] - i3) - 109);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A01 = new byte[]{23, 42, 61, 50, 63, 46, -23, 42, 45, 60, -23, 54, 42, 55, 42, 48, 46, 59, -23, 61, 49, 46, 50, 59, -23, 56, 64, 55, -23, 50, 54, 57, 59, 46, 60, 60, 50, 56, 55, 60, -9};
    }

    public C1001bS(C1007bZ bZVar) {
        this.A00 = bZVar;
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC00350o
    public final void A0A(RG rg) {
        this.A00.A0d(rg, true);
        if (!(this.A00.A0F == null || rg.A0V() == null)) {
            C1000bR bRVar = new C1000bR(this);
            for (C1007bZ bZVar : rg.A0V()) {
                bZVar.A0e(bRVar);
            }
        }
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC00350o
    public final void A0B() {
        if (this.A00.A0F != null) {
            this.A00.A0F.A8k();
        }
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC00350o
    public final void A0C() {
        throw new IllegalStateException(A00(0, 41, 92));
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC00350o
    public final void A0E(AbstractC00340n r2) {
        if (this.A00.A09 != null) {
            this.A00.A09.A0K();
        }
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC00350o
    public final void A0F(C0495Jm jm) {
        this.A00.A0x().A0A().A2d(LW.A01(this.A00.A00), jm.A04().getErrorCode(), jm.A05());
        if (this.A00.A0F != null) {
            this.A00.A0F.A9X(jm);
        }
    }
}
