package com.facebook.ads.redexgen.X;

import java.util.Arrays;

/* renamed from: com.facebook.ads.redexgen.X.3b  reason: invalid class name and case insensitive filesystem */
public class C00983b {
    public static byte[] A02;
    public static String[] A03;
    public long A00 = 0;
    public C00983b A01;

    static {
        A03();
        A02();
    }

    public static String A00(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A02, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] - i3) - 5);
        }
        return new String(copyOfRange);
    }

    public static void A02() {
        A02 = new byte[]{-34, -34};
    }

    public static void A03() {
        A03 = new String[]{"bULQ32o9JJN83aCucFVWf9xMaMFfdsau", "BEVDZxUetTHXZyMQk8onv0fPj1ZBZ1Qa", "0vYpub5LBkfCpAgXclsnPo1", "vVWBcEJQjEsfNalmzVe1r7miASaPIW1B", "LFkzDQh", "g5RhG8eWHWtWI7ENz9qYtKd", "50dEOoYhOQRa91fvkd77j3svvS12NHRj", "eQbNRdF"};
    }

    private void A01() {
        if (this.A01 == null) {
            this.A01 = new C00983b();
        }
    }

    public final int A04(int i) {
        C00983b r1 = this.A01;
        if (r1 == null) {
            if (i >= 64) {
                return Long.bitCount(this.A00);
            }
            return Long.bitCount(this.A00 & ((1 << i) - 1));
        } else if (i < 64) {
            return Long.bitCount(this.A00 & ((1 << i) - 1));
        } else {
            return r1.A04(i - 64) + Long.bitCount(this.A00);
        }
    }

    public final void A05() {
        this.A00 = 0;
        C00983b r0 = this.A01;
        if (r0 != null) {
            r0.A05();
        }
    }

    public final void A06(int i) {
        if (i >= 64) {
            C00983b r1 = this.A01;
            if (r1 != null) {
                r1.A06(i - 64);
                return;
            }
            return;
        }
        long j = this.A00 & ((1 << i) ^ -1);
        if (A03[1].charAt(31) != 'a') {
            throw new RuntimeException();
        }
        String[] strArr = A03;
        strArr[6] = "FQtQPqX5zshXn4VmNwTVsnzPJS3Krcw4";
        strArr[3] = "mEVd87EgPvtBoIzzDeJnjIPIOSUL2jIs";
        this.A00 = j;
    }

    public final void A07(int i) {
        if (i >= 64) {
            A01();
            this.A01.A07(i - 64);
            return;
        }
        this.A00 |= 1 << i;
    }

    public final void A08(int i, boolean z) {
        boolean z2;
        if (i >= 64) {
            A01();
            this.A01.A08(i - 64, z);
            return;
        }
        if ((this.A00 & Long.MIN_VALUE) != 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        long j = (1 << i) - 1;
        long j2 = this.A00;
        this.A00 = (j2 & j) | ((j2 & (-1 ^ j)) << 1);
        if (z) {
            A07(i);
        } else {
            A06(i);
        }
        if (z2 || this.A01 != null) {
            A01();
            this.A01.A08(0, z2);
        }
    }

    public final boolean A09(int i) {
        if (i < 64) {
            return (this.A00 & (1 << i)) != 0;
        }
        A01();
        return this.A01.A09(i - 64);
    }

    /* JADX INFO: Multiple debug info for r0v3 long: [D('before' long), D('value' boolean)] */
    public final boolean A0A(int i) {
        boolean z;
        if (i >= 64) {
            A01();
            return this.A01.A0A(i - 64);
        }
        long j = 1 << i;
        if ((this.A00 & j) != 0) {
            z = true;
        } else {
            z = false;
        }
        this.A00 &= j ^ -1;
        long j2 = j - 1;
        long before = this.A00;
        this.A00 = (before & j2) | Long.rotateRight(before & (-1 ^ j2), 1);
        C00983b r0 = this.A01;
        if (r0 != null) {
            if (r0.A09(0)) {
                A07(63);
            }
            this.A01.A0A(0);
        }
        return z;
    }

    public final String toString() {
        if (this.A01 == null) {
            long j = this.A00;
            if (A03[1].charAt(31) != 'a') {
                throw new RuntimeException();
            }
            String[] strArr = A03;
            strArr[2] = "hJ9KUEYMHtIt6rT1Ez0KfdL";
            strArr[5] = "B6CHA8tZa8vt0H5l4hWvu9Y";
            return Long.toBinaryString(j);
        }
        return this.A01.toString() + A00(0, 2, 97) + Long.toBinaryString(this.A00);
    }
}
