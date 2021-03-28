package com.facebook.ads.redexgen.X;

import java.util.Arrays;

public final class B2 extends Exception {
    public static byte[] A00;

    static {
        A01();
    }

    public static String A00(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A00, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] ^ i3) ^ 24);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A00 = new byte[]{95, 55, 5, 83, 95, 111, 44, 39, 46, 33, 33, 42, 35, 60, 111, 38, 33, 111, 42, 33, 44, 32, 43, 38, 33, 40, 111, 65, 122, 124, 117, 122, 112, 120, 113, 112, 52, 114, 123, 102, 121, 117, 96, 46, 52};
    }

    public B2(int i, int i2, int i3) {
        super(A00(27, 18, 12) + i + A00(0, 5, 103) + i2 + A00(5, 22, 87) + i3);
    }
}
