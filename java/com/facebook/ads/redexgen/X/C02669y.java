package com.facebook.ads.redexgen.X;

import java.util.UUID;

/* renamed from: com.facebook.ads.redexgen.X.9y  reason: invalid class name and case insensitive filesystem */
public final class C02669y {
    public static final int A00;
    public static final UUID A01 = new UUID(-2129748144642739255L, 8654423357094679310L);
    public static final UUID A02 = new UUID(1186680826959645954L, -5988876978535335093L);
    public static final UUID A03 = new UUID(-7348484286925749626L, -6083546864340672619L);
    public static final UUID A04 = new UUID(0, 0);
    public static final UUID A05 = new UUID(-1301668207276963122L, -6645017420763422227L);

    static {
        int i;
        if (C0466Ig.A02 < 23) {
            i = 1020;
        } else {
            i = 6396;
        }
        A00 = i;
    }

    public static long A00(long j) {
        return (j == -9223372036854775807L || j == Long.MIN_VALUE) ? j : j * 1000;
    }

    public static long A01(long j) {
        return (j == -9223372036854775807L || j == Long.MIN_VALUE) ? j : j / 1000;
    }
}
