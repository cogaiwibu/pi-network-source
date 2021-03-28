package com.facebook.ads.redexgen.X;

import java.util.Arrays;

public final class IG {
    public static byte[] A02;
    public int A00;
    public long[] A01;

    static {
        A01();
    }

    public static String A00(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A02, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] ^ i3) ^ 45);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A02 = new byte[]{61, 49, 98, 120, 107, 116, 49, 120, 98, 49, 89, 126, 102, 113, 124, 121, 116, 48, 121, 126, 116, 117, 104, 48};
    }

    public IG() {
        this(32);
    }

    public IG(int i) {
        this.A01 = new long[i];
    }

    public final int A02() {
        return this.A00;
    }

    public final long A03(int i) {
        if (i >= 0 && i < this.A00) {
            return this.A01[i];
        }
        throw new IndexOutOfBoundsException(A00(10, 14, 61) + i + A00(0, 10, 60) + this.A00);
    }

    public final void A04(long j) {
        int i = this.A00;
        long[] jArr = this.A01;
        if (i == jArr.length) {
            this.A01 = Arrays.copyOf(jArr, i * 2);
        }
        long[] jArr2 = this.A01;
        int i2 = this.A00;
        this.A00 = i2 + 1;
        jArr2[i2] = j;
    }

    public final long[] A05() {
        return Arrays.copyOf(this.A01, this.A00);
    }
}
