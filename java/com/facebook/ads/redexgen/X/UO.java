package com.facebook.ads.redexgen.X;

import java.util.Arrays;

public class UO implements AbstractC01816i {
    public static byte[] A01;
    public final /* synthetic */ US A00;

    static {
        A01();
    }

    public static String A00(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A01, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] - i3) - 38);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A01 = new byte[]{-99, -97, -110, -96, -110, -101, -95};
    }

    public UO(US us) {
        this.A00 = us;
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC01816i
    public final AbstractC01966x A50() {
        return this.A00.A0C(A00(0, 7, 7), false);
    }
}
