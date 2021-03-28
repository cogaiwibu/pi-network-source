package com.facebook.ads.redexgen.X;

import java.util.Arrays;

/* renamed from: com.facebook.ads.redexgen.X.1j  reason: invalid class name and case insensitive filesystem */
public final class C00561j {
    public static byte[] A00;

    static {
        A01();
    }

    public static String A00(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A00, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] ^ i3) ^ 18);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A00 = new byte[]{69, 82, 64, 86, 69, 83, 82, 83, 104, 65, 94, 83, 82, 88};
    }

    public static void A02(AnonymousClass7H r10, RR rr) {
        r10.A0S(new AnonymousClass7E(rr.A0O().A01(), OP.A04, OP.A04, rr.A0U(), A00(0, 14, 37)));
        r10.A0W(new AnonymousClass7G(rr.A0M().A0E().A08(), rr.A0U(), A00(0, 14, 37), rr.A0M().A0E().A05()));
        r10.A0S(new AnonymousClass7E(rr.A0M().A0E().A07(), C00511e.A00(rr.A0M().A0E()), C00511e.A01(rr.A0M().A0E()), rr.A0U(), A00(0, 14, 37)));
        for (String str : rr.A0M().A0H().A00()) {
            r10.A0S(new AnonymousClass7E(str, -1, -1, rr.A0U(), A00(0, 14, 37)));
        }
    }
}
