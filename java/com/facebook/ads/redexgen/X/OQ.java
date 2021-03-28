package com.facebook.ads.redexgen.X;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public final class OQ {
    public static byte[] A03;
    public final int A00;
    public final int A01;
    public final AnonymousClass19 A02;

    static {
        A01();
    }

    public static String A00(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A03, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] - i3) - 75);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A03 = new byte[]{-27, -29, -12, -26, -27, -16, -10, 12, 10, 27, 13, 18, 23, 13};
    }

    public OQ(int i, int i2, AnonymousClass19 r3) {
        this.A01 = i;
        this.A00 = i2;
        this.A02 = r3;
    }

    public final int A02() {
        return this.A01;
    }

    public final AnonymousClass19 A03() {
        return this.A02;
    }

    public final Map<String, String> A04() {
        HashMap hashMap = new HashMap();
        StringBuilder sb = new StringBuilder();
        sb.append(this.A01);
        String A002 = A00(0, 0, 12);
        sb.append(A002);
        hashMap.put(A00(7, 7, 94), sb.toString());
        hashMap.put(A00(0, 7, 55), this.A00 + A002);
        return hashMap;
    }
}
