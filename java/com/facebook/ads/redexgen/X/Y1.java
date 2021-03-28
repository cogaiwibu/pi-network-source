package com.facebook.ads.redexgen.X;

import java.util.Arrays;

public class Y1 extends AbstractRunnableC0510Kc {
    public static byte[] A01;
    public final /* synthetic */ C0858Xt A00;

    static {
        A01();
    }

    public static String A00(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A01, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] - i3) - 77);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A01 = new byte[]{-29, -10, -15, -14, -4, -83, 4, -18, 0, -83, -5, -14, 3, -14, -1, -83, -3, -1, -14, -3, -18, -1, -14, -15};
    }

    public Y1(C0858Xt xt) {
        this.A00 = xt;
    }

    @Override // com.facebook.ads.redexgen.X.AbstractRunnableC0510Kc
    public final void A07() {
        if (!(this.A00.A0G)) {
            this.A00.A0e(A00(0, 24, 64));
        }
    }
}
