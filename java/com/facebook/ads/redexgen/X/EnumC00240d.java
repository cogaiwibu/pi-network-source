package com.facebook.ads.redexgen.X;

import java.util.Arrays;
import kotlin.jvm.internal.ByteCompanionObject;

/* renamed from: com.facebook.ads.redexgen.X.0d  reason: invalid class name and case insensitive filesystem */
public enum EnumC00240d {
    A08(A00(83, 5, 74)),
    A06(A00(70, 5, 56)),
    A03(A00(44, 8, 56)),
    A07(A00(75, 8, 102)),
    A05(A00(61, 9, 107)),
    A04(A00(52, 9, 22));
    
    public static byte[] A01;
    public final String A00;

    public static String A00(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A01, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] ^ i3) ^ 50);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A01 = new byte[]{19, 17, 2, 31, 5, 3, 21, 28, 23, 0, 31, 12, 26, 30, 18, 20, 22, 116, 99, 124, 111, 102, 121, 116, 117, ByteCompanionObject.MAX_VALUE, 27, 31, 19, 21, 23, 124, 96, 109, 117, 109, 110, 96, 105, 72, 87, 90, 91, 81, 105, 107, 120, 101, ByteCompanionObject.MAX_VALUE, 121, 111, 102, 64, 87, 72, 123, 77, 73, 69, 67, 65, 61, 42, 53, 6, 47, 48, 61, 60, 54, 99, 103, 107, 109, 111, 36, 56, 53, 45, 53, 54, 56, 49, 14, 17, 28, 29, 23};
    }

    /* access modifiers changed from: public */
    static {
        A01();
    }

    /* access modifiers changed from: public */
    EnumC00240d(String str) {
        this.A00 = str;
    }

    public final String A02() {
        return this.A00;
    }
}
