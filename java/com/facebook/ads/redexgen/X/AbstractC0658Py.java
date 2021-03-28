package com.facebook.ads.redexgen.X;

import java.util.Arrays;

/* renamed from: com.facebook.ads.redexgen.X.Py  reason: case insensitive filesystem */
public abstract class AbstractC0658Py {
    public static byte[] A05;
    public C0654Pu A00;
    public EnumC0657Px A01;
    public String A02;
    public String A03 = A00(0, 0, 77);
    public byte[] A04;

    static {
        A01();
    }

    public static String A00(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A05, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] - i3) - 21);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A05 = new byte[]{119};
    }

    public AbstractC0658Py(String str, Q0 q0, C0654Pu pu) {
        if (str != null) {
            this.A03 = str;
        }
        if (q0 != null && !q0.A07().isEmpty()) {
            this.A03 += A00(0, 1, 35) + q0.A07();
        }
        this.A00 = pu;
    }

    public final C0654Pu A02() {
        return this.A00;
    }

    public final EnumC0657Px A03() {
        return this.A01;
    }

    public final String A04() {
        return this.A02;
    }

    public final String A05() {
        return this.A03;
    }

    public final byte[] A06() {
        return this.A04;
    }
}
