package com.facebook.ads.redexgen.X;

import java.util.Arrays;

/* renamed from: com.facebook.ads.redexgen.X.Oo  reason: case insensitive filesystem */
public enum EnumC0622Oo {
    A04(101),
    A07(102),
    A08(103),
    A05(104),
    A06(105),
    A03(106);
    
    public static byte[] A01;
    public final int A00;

    public static String A00(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A01, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] ^ i3) ^ 79);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A01 = new byte[]{11, 24, 1, 1, 30, 14, 31, 8, 8, 3, 18, 27, 4, 9, 8, 2, 18, 27, 4, 8, 26, 18, 2, 3, 18, 9, 8, 30, 25, 31, 2, 20, 5, 2, 24, 9, 30, 31, 24, 5, 24, 5, 13, 0, 19, 26, 5, 8, 9, 3, 19, 26, 5, 9, 27, 19, 8, 9, 31, 24, 30, 3, 21, 46, 37, 55, 63, 54, 41, 36, 37, 47, 63, 41, 46, 52, 37, 50, 51, 52, 41, 52, 41, 33, 44, 63, 46, 39, 52, 63, 34, 53, 52, 52, 47, 46, 94, 85, 71, 79, 70, 89, 84, 85, 95, 79, 89, 94, 68, 85, 66, 67, 68, 89, 68, 89, 81, 92, 79, 68, 95, 95, 92, 82, 81, 66, 79, 83, 92, 95, 67, 85, 79, 83, 92, 89, 83, 91, 85, 84, 11, 28, 14, 24, 11, 29, 28, 29, 6, 15, 16, 29, 28, 22, 6, 13, 22, 22, 21, 27, 24, 11, 6, 26, 21, 22, 10, 28, 6, 26, 21, 16, 26, 18, 28, 29, 77, 85, 87, 78, 65, 78, 82, 75, 89, 87, 80};
    }

    /* access modifiers changed from: public */
    static {
        A01();
    }

    /* access modifiers changed from: public */
    EnumC0622Oo(int i) {
        this.A00 = i;
    }

    public final int A02() {
        return this.A00;
    }
}
