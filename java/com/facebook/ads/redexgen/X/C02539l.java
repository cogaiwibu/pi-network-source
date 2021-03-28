package com.facebook.ads.redexgen.X;

import java.util.Arrays;

/* renamed from: com.facebook.ads.redexgen.X.9l  reason: invalid class name and case insensitive filesystem */
public class C02539l extends AbstractC0506Jy {
    public static byte[] A01;
    public final /* synthetic */ C0846Xh A00;

    static {
        A01();
    }

    public static String A00(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A01, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] ^ i3) ^ 63);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A01 = new byte[]{72, 87, 90, 91, 81, 119, 80, 74, 91, 76, 77, 74, 87, 74, 95, 82, 123, 72, 91, 80, 74};
    }

    public C02539l(C0846Xh xh) {
        this.A00 = xh;
    }

    /* access modifiers changed from: private */
    /* renamed from: A02 */
    public final void A04(C02147t r5) {
        this.A00.A04.A3t(A00(0, 21, 1), r5);
    }
}
