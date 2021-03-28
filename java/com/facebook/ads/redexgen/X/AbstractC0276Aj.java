package com.facebook.ads.redexgen.X;

import android.util.Pair;

/* renamed from: com.facebook.ads.redexgen.X.Aj  reason: case insensitive filesystem */
public abstract class AbstractC0276Aj {
    public static String[] A00;
    public static final AbstractC0276Aj A01 = new C0847Xi();

    public static void A00() {
        A00 = new String[]{"jU13W9NSebta1ZmimveRwiImSwvynw8G", "bR9yhpeYgYLfxjGn405sIF1CLUaNKRNv", "y6GS60dgSiOKDJGhj3wt9T6pcdF3KRzS", "kAdv6lw0fV2hZ8Ef8nLl5eDcrpXJ", "gDoO0sRHxUPo6SrSL989dqr7yWBZykVP", "xoqdGlgoaRmw7wZuwViSR5WxyeJjGGpo", "tn8QhSSQsmhaZqBgPW05rXLjjsf9pF2E", "LT5aPkpwV7"};
    }

    public abstract int A01();

    public abstract int A02();

    public abstract int A05(Object obj);

    public abstract C0274Ah A0B(int i, C0274Ah ah, boolean z);

    public abstract C0275Ai A0E(int i, C0275Ai ai, boolean z, long j);

    static {
        A00();
    }

    public int A03(int i, int i2, boolean z) {
        if (i2 != 0) {
            if (i2 == 1) {
                return i;
            }
            if (i2 == 2) {
                return i == A07(z) ? A06(z) : i + 1;
            }
            throw new IllegalStateException();
        } else if (i == A07(z)) {
            return -1;
        } else {
            return i + 1;
        }
    }

    public final int A04(int nextWindowIndex, C0274Ah ah, C0275Ai ai, int i, boolean z) {
        int i2 = A0A(nextWindowIndex, ah).A00;
        if (A0C(i2, ai).A01 != nextWindowIndex) {
            return nextWindowIndex + 1;
        }
        int A03 = A03(i2, i, z);
        if (A03 == -1) {
            return -1;
        }
        return A0C(A03, ai).A00;
    }

    public int A06(boolean z) {
        return A0F() ? -1 : 0;
    }

    public int A07(boolean z) {
        if (A0F()) {
            return -1;
        }
        return A02() - 1;
    }

    public final Pair<Integer, Long> A08(C0275Ai ai, C0274Ah ah, int i, long j) {
        return A09(ai, ah, i, j, 0);
    }

    public final Pair<Integer, Long> A09(C0275Ai ai, C0274Ah ah, int i, long j, long j2) {
        I1.A00(i, 0, A02());
        A0E(i, ai, false, j2);
        if (j == -9223372036854775807L) {
            j = ai.A01();
            if (j == -9223372036854775807L) {
                return null;
            }
        }
        int i2 = ai.A00;
        long A03 = ai.A03() + j;
        long A07 = A0A(i2, ah).A07();
        while (A07 != -9223372036854775807L) {
            int i3 = (A03 > A07 ? 1 : (A03 == A07 ? 0 : -1));
            if (A00[7].length() != 24) {
                String[] strArr = A00;
                strArr[7] = "t4u2YUU8OEdoMFYJ2jQWzxX4wha";
                strArr[7] = "t4u2YUU8OEdoMFYJ2jQWzxX4wha";
                if (i3 < 0 || i2 >= ai.A01) {
                    break;
                }
                A03 -= A07;
                i2++;
                A07 = A0A(i2, ah).A07();
            } else {
                throw new RuntimeException();
            }
        }
        return Pair.create(Integer.valueOf(i2), Long.valueOf(A03));
    }

    public final C0274Ah A0A(int i, C0274Ah ah) {
        return A0B(i, ah, false);
    }

    public final C0275Ai A0C(int i, C0275Ai ai) {
        return A0D(i, ai, false);
    }

    public final C0275Ai A0D(int i, C0275Ai ai, boolean z) {
        return A0E(i, ai, z, 0);
    }

    public final boolean A0F() {
        return A02() == 0;
    }

    public final boolean A0G(int i, C0274Ah ah, C0275Ai ai, int i2, boolean z) {
        return A04(i, ah, ai, i2, z) == -1;
    }
}
