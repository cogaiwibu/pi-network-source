package com.facebook.ads.redexgen.X;

import java.util.Arrays;

public class RJ extends AbstractRunnableC0510Kc {
    public static byte[] A01;
    public final /* synthetic */ RK A00;

    static {
        A01();
    }

    public static String A00(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A01, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] - i3) - 95);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A01 = new byte[]{-20, -29, -8, -29, -11, -27, -12, -21, -14, -10, -68};
    }

    public RJ(RK rk) {
        this.A00 = rk;
    }

    @Override // com.facebook.ads.redexgen.X.AbstractRunnableC0510Kc
    public final void A07() {
        this.A00.A02.A0A().ADm();
        NK nk = this.A00.A04;
        nk.loadUrl(A00(0, 11, 35) + this.A00.A00.A04());
    }
}
