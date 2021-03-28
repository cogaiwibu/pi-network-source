package com.facebook.ads.redexgen.X;

import java.util.Arrays;
import kotlin.jvm.internal.ByteCompanionObject;

/* renamed from: com.facebook.ads.redexgen.X.Kl  reason: case insensitive filesystem */
public enum EnumC0519Kl {
    A04(0),
    A0C(1),
    A07(2),
    A0A(3),
    A08(4),
    A0B(5),
    A03(6),
    A09(7),
    A05(8),
    A06(9);
    
    public static byte[] A01;
    public int A00;

    public static String A00(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A01, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] ^ i3) ^ 7);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A01 = new byte[]{85, 93, 64, 68, 73, 79, 81, 83, 68, 89, 70, 89, 68, 89, 85, 67, 79, 66, 85, 86, 92, 85, 83, 68, 89, 95, 94, 38, 36, 47, 36, 51, 40, 34, 62, 36, 51, 51, 46, 51, 102, 107, ByteCompanionObject.MAX_VALUE, 100, 105, 98, 111, 120, 117, 108, 101, ByteCompanionObject.MAX_VALUE, 100, 110, 117, 107, 122, 99, 24, 27, 37, 40, 60, 39, 42, 33, 44, 59, 54, 47, 38, 60, 39, 45, 54, 59, 44, 47, 37, 44, 42, 61, 32, 38, 39, 59, 58, 42, 52, 54, 33, 60, 35, 60, 33, 44, 42, 38, 48, 39, 35, 60, 54, 48, 67, 66, 82, 65, 76, 88, 67, 78, 69, 72, 95, 82, 75, 66, 88, 67, 73, 82, 76, 93, 68, 63, 60, 32, 33, 49, 34, 47, 59, 32, 45, 38, 43, 60, 49, 40, 33, 59, 32, 42, 49, 60, 43, 40, 34, 43, 45, 58, 39, 33, 32, 91, 90, 74, 71, 64, 91, 91, 92, 91, 82, 74, 65, 84, 70, 94, 70, 102, 125, 100, 100, 119, 105, 107, 124, 97, 126, 97, 124, 97, 109, 123, 119, 122, 109, 110, 100, 109, 107, 124, 97, 103, 102, 72, 83, 74, 74, 89, 69, 73, 72, 82, 67, 94, 82};
    }

    /* access modifiers changed from: public */
    static {
        A01();
    }

    /* access modifiers changed from: public */
    EnumC0519Kl(int i) {
        this.A00 = i;
    }
}
