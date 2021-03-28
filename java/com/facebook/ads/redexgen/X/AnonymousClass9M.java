package com.facebook.ads.redexgen.X;

import java.io.IOException;
import java.util.Arrays;

/* renamed from: com.facebook.ads.redexgen.X.9M  reason: invalid class name */
public final class AnonymousClass9M {
    public static byte[] A00;
    public static final String A01 = AnonymousClass9M.class.getSimpleName();

    public static String A02(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A00, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] - i3) - 51);
        }
        return new String(copyOfRange);
    }

    public static void A03() {
        A00 = new byte[]{-2, -15, -17, -5, -2, -16, -21, -16, -19, 0, -19, -18, -19, -1, -15};
    }

    static {
        A03();
    }

    public static AnonymousClass9O A00(C0821Wi wi) {
        try {
            return new XO(wi);
        } catch (IOException e) {
            wi.A04().A82(A02(0, 15, 89), C02248i.A1w, new C02258j(e));
            return new XL();
        }
    }

    public static C0315Cf A01(C0821Wi wi) {
        return new C0315Cf(wi);
    }
}
