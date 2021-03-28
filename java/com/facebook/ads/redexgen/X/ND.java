package com.facebook.ads.redexgen.X;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public final class ND {
    public static byte[] A08;
    public final long A00;
    public final long A01;
    public final long A02;
    public final long A03;
    public final long A04;
    public final long A05;
    public final long A06;
    public final String A07;

    static {
        A01();
    }

    public static String A00(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A08, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] ^ i3) ^ 17);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A08 = new byte[]{5, 14, 12, 62, 2, 14, 15, 21, 4, 15, 21, 62, 13, 14, 0, 5, 4, 5, 62, 12, 18, 56, 49, 62, 52, 60, 53, 34, 15, 36, 57, 61, 53, 15, 61, 35, 24, 31, 24, 5, 24, 16, 29, 46, 4, 3, 29, 71, 68, 74, 79, 116, 77, 66, 69, 66, 88, 67, 116, 70, 88, 16, 19, 29, 24, 35, 15, 8, 29, 14, 8, 35, 17, 15, 66, 85, 67, 64, 95, 94, 67, 85, 111, 85, 94, 84, 111, 93, 67, 59, 43, 58, 39, 36, 36, 23, 58, 45, 41, 44, 49, 23, 37, 59, 40, 62, 40, 40, 50, 52, 53, 4, 61, 50, 53, 50, 40, 51, 4, 54, 40};
    }

    public ND(String str, long j, long j2, long j3, long j4, long j5, long j6, long j7) {
        this.A07 = str;
        this.A01 = j;
        this.A03 = j2;
        this.A04 = j3;
        this.A00 = j4;
        this.A05 = j5;
        this.A02 = j6;
        this.A06 = j7;
    }

    public final Map<String, String> A02() {
        HashMap hashMap = new HashMap(7);
        hashMap.put(A00(36, 11, 96), this.A07);
        hashMap.put(A00(21, 15, 65), String.valueOf(this.A01));
        hashMap.put(A00(61, 13, 109), String.valueOf(this.A03));
        hashMap.put(A00(74, 15, 33), String.valueOf(this.A04));
        hashMap.put(A00(0, 21, 112), String.valueOf(this.A00));
        hashMap.put(A00(89, 15, 89), String.valueOf(this.A05));
        hashMap.put(A00(47, 14, 58), String.valueOf(this.A02));
        hashMap.put(A00(104, 17, 74), String.valueOf(this.A06));
        return hashMap;
    }
}
