package com.facebook.ads.redexgen.X;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.facebook.ads.redexgen.X.8W  reason: invalid class name */
public final class AnonymousClass8W {
    public static byte[] A03;
    public final String A00;
    public final String A01;
    public final Map<String, String> A02;

    static {
        A01();
    }

    public static String A00(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A03, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] - i3) - 80);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A03 = new byte[]{-119, -77, -55, -57, -37, -51, -50, -38, -59, -53, -34, -55, -53, -42, -38, -49, -43, -44, 59, 60, 41, 43, 51, 60, 58, 41, 43, 45};
    }

    public AnonymousClass8W(String str, Map<String, String> map) {
        this(str, map, false);
    }

    public AnonymousClass8W(String str, Map<String, String> map, boolean z) {
        String A002;
        this.A01 = str;
        this.A02 = map;
        if (z) {
            A002 = A00(1, 1, 50);
        } else {
            A002 = A00(0, 1, 9);
        }
        this.A00 = A002;
    }

    public final Map<String, String> A02() {
        HashMap hashMap = new HashMap();
        hashMap.put(A00(18, 10, 120), this.A01);
        hashMap.put(A00(2, 16, 22), this.A00);
        hashMap.putAll(this.A02);
        return hashMap;
    }
}
