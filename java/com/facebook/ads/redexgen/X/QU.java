package com.facebook.ads.redexgen.X;

import java.util.Arrays;

public enum QU {
    A03(A00(10, 4, 24)),
    A04(A00(14, 6, 108));
    
    public static byte[] A01;
    public String A00;

    public static String A00(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A01, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] - i3) - 95);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A01 = new byte[]{-22, -19, -16, -16, -70, -75, -87, -90, -71, -86, -35, -32, -29, -29, 64, 59, 47, 44, 63, 48};
    }

    /* access modifiers changed from: public */
    static {
        A01();
    }

    /* access modifiers changed from: public */
    QU(String str) {
        this.A00 = str;
    }

    public final String A02() {
        return this.A00;
    }
}
