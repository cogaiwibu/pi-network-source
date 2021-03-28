package com.facebook.ads.redexgen.X;

/* renamed from: com.facebook.ads.redexgen.X.Ic  reason: case insensitive filesystem */
public final class C0462Ic {
    public static String[] A03;
    public long A00;
    public long A01;
    public volatile long A02 = -9223372036854775807L;

    static {
        A02();
    }

    public static void A02() {
        A03 = new String[]{"65cMlekakVUIMLtYd2qVn8RcZ0adnk1M", "UjyIGuEYWfjJHNBaVK1tpUnDezxozlQO", "8TtcshNmMrpBHoTy3Jx7PSsI4WaoiE", "opOgbEamfowehMTo5e", "TsJIn0", "EhVZCkSBDk6mMyTg5zdzmerfhGbFv5ld", "Eri8EAzeqOX6dLYscfL5OJU1HmdTNDem", "nefT9Ttk6cyPRqOW12bbBLbtHnReAUgq"};
    }

    public C0462Ic(long j) {
        A03(j);
    }

    public static long A00(long j) {
        return (1000000 * j) / 90000;
    }

    public static long A01(long j) {
        return (90000 * j) / 1000000;
    }

    private final synchronized void A03(long j) {
        int i = (this.A02 > -9223372036854775807L ? 1 : (this.A02 == -9223372036854775807L ? 0 : -1));
        if (A03[4].length() != 6) {
            throw new RuntimeException();
        }
        String[] strArr = A03;
        strArr[4] = "LzgDaR";
        strArr[4] = "LzgDaR";
        I1.A04(i == 0);
        this.A00 = j;
    }

    public final long A04() {
        return this.A00;
    }

    public final long A05() {
        if (this.A02 != -9223372036854775807L) {
            long j = this.A02;
            String[] strArr = A03;
            if (strArr[1].charAt(3) != strArr[7].charAt(3)) {
                String[] strArr2 = A03;
                strArr2[1] = "a2e4BTQtBTIbtdID7RtsbeiIoOOOiE5j";
                strArr2[7] = "T6brmwdtMhRZgX81oiPgAK3x7yaW2pG8";
                return this.A01 + j;
            }
            throw new RuntimeException();
        }
        long j2 = this.A00;
        String[] strArr3 = A03;
        if (strArr3[6].charAt(9) != strArr3[0].charAt(9)) {
            String[] strArr4 = A03;
            strArr4[4] = "vWaoyi";
            strArr4[4] = "vWaoyi";
            if (j2 != Long.MAX_VALUE) {
                return j2;
            }
            return -9223372036854775807L;
        }
        throw new RuntimeException();
    }

    public final long A06() {
        if (this.A00 == Long.MAX_VALUE) {
            return 0;
        }
        long j = this.A02;
        if (A03[4].length() != 6) {
            throw new RuntimeException();
        }
        String[] strArr = A03;
        strArr[1] = "iob8LfiWSdIXeaYrhNgyOnbM2i0L2mJ3";
        strArr[7] = "rhCREaYiIoksCalrOiAV4Z6SpW6PjrFh";
        if (j == -9223372036854775807L) {
            return -9223372036854775807L;
        }
        return this.A01;
    }

    public final long A07(long j) {
        if (j == -9223372036854775807L) {
            return -9223372036854775807L;
        }
        if (this.A02 != -9223372036854775807L) {
            this.A02 = j;
        } else {
            long j2 = this.A00;
            if (j2 != Long.MAX_VALUE) {
                this.A01 = j2 - j;
            }
            synchronized (this) {
                this.A02 = j;
                notifyAll();
            }
        }
        return this.A01 + j;
    }

    public final long A08(long j) {
        if (j == -9223372036854775807L) {
            return -9223372036854775807L;
        }
        if (this.A02 != -9223372036854775807L) {
            long A012 = A01(this.A02);
            long closestWrapCount = (4294967296L + A012) / 8589934592L;
            long j2 = ((closestWrapCount - 1) * 8589934592L) + j;
            long j3 = (8589934592L * closestWrapCount) + j;
            if (Math.abs(j2 - A012) >= Math.abs(j3 - A012)) {
                j2 = j3;
            }
            j = j2;
        }
        return A07(A00(j));
    }

    public final void A09() {
        this.A02 = -9223372036854775807L;
    }
}
