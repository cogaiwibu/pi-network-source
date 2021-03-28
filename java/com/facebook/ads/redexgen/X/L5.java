package com.facebook.ads.redexgen.X;

import java.util.Arrays;

public enum L5 {
    A05(0),
    A06(1),
    A04(2);
    
    public static byte[] A01;
    public static String[] A02;
    public final int A00;

    public static String A00(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A01, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] ^ i3) ^ 85);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        if (A02[2].length() != 27) {
            String[] strArr = A02;
            strArr[1] = "i";
            strArr[0] = "v";
            A01 = new byte[]{117, 104, 104, 115, 98, 99, 122, 97, 100, 97, 96, 120, 97, 68, 95, 67, 94, 94, 69, 84, 85};
            return;
        }
        throw new RuntimeException();
    }

    public static void A02() {
        A02 = new String[]{"D", "C", "8vWlkexf09f1piT", "bgKjpA4PjvHZdywoorD", "7PPvca8DkKgRdh14PD5p9M98ffpM", "UMv18", "Efwwh", "kVnW00famwT2UvCG2iLw1Nw0GuoWmmQs"};
    }

    /* access modifiers changed from: public */
    static {
        A02();
        A01();
    }

    /* access modifiers changed from: public */
    L5(int i) {
        this.A00 = i;
    }
}
