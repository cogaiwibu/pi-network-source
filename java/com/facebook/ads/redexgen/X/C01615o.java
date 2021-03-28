package com.facebook.ads.redexgen.X;

import androidx.annotation.Nullable;
import java.util.Arrays;

/* renamed from: com.facebook.ads.redexgen.X.5o  reason: invalid class name and case insensitive filesystem */
public final class C01615o {
    @Nullable
    public static AbstractC01625p A00 = null;
    public static boolean A01 = false;
    public static byte[] A02;
    public static String[] A03;

    public static String A00(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A02, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] - i3) - 25);
        }
        return new String(copyOfRange);
    }

    public static void A02() {
        A02 = new byte[]{-24, -21, -12, -23, -18, -13, -25, -8, -15};
    }

    public static void A03() {
        A03 = new String[]{"dhICO", "mxKq80OLCiD", "i2W9TrIDW1srZxkJxV7foM0MgZvVXbWR", "HI2hESQONWq4EaTE0poPF0OJaSIxJaLc", "DAl184VBvvXhRHJ82dj3bqQv5TXH8TG3", "HKaWDYwPLWKyKiUqhpuc4RGInXEUU", "cSOfcLeIkAX6sPpwLxmVuA24IrFfyR3p", "KnRyMDjzSPNAoacBq98iQYDM8U9nlYJB"};
    }

    static {
        A03();
        A02();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x001f, code lost:
        r0.A04().A82(A00(0, 9, 109), 3401, r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0031, code lost:
        r3 = com.facebook.ads.redexgen.X.C01615o.A00;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x003e, code lost:
        if (com.facebook.ads.redexgen.X.C01615o.A03[1].length() == 11) goto L_0x0046;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0045, code lost:
        throw new java.lang.RuntimeException();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0046, code lost:
        r2 = com.facebook.ads.redexgen.X.C01615o.A03;
        r2[3] = "kDYng9EYBsgXNgOEIL1h1gMPzmVJxAMa";
        r2[6] = "TYxT1mxIdvKOfg1hbfM6O4XMHE5Nitia";
        r3.reset();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0055, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x000a, code lost:
        r5 = new com.facebook.ads.redexgen.X.C02258j(com.facebook.ads.redexgen.X.C01615o.A00.ACT());
        r5.A03(1);
        r0 = com.facebook.ads.redexgen.X.AnonymousClass8G.A00();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x001d, code lost:
        if (r0 == null) goto L_0x0031;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void A01() {
        /*
            java.lang.Class<com.facebook.ads.redexgen.X.5o> r1 = com.facebook.ads.redexgen.X.C01615o.class
            monitor-enter(r1)
            com.facebook.ads.redexgen.X.5p r0 = com.facebook.ads.redexgen.X.C01615o.A00     // Catch:{ all -> 0x0056 }
            if (r0 != 0) goto L_0x0009
            monitor-exit(r1)     // Catch:{ all -> 0x0056 }
            return
        L_0x0009:
            monitor-exit(r1)     // Catch:{ all -> 0x0056 }
            com.facebook.ads.redexgen.X.8j r5 = new com.facebook.ads.redexgen.X.8j
            com.facebook.ads.redexgen.X.5p r0 = com.facebook.ads.redexgen.X.C01615o.A00
            java.lang.String r0 = r0.ACT()
            r5.<init>(r0)
            r0 = 1
            r5.A03(r0)
            com.facebook.ads.redexgen.X.Wi r0 = com.facebook.ads.redexgen.X.AnonymousClass8G.A00()
            if (r0 == 0) goto L_0x0031
            com.facebook.ads.redexgen.X.8h r4 = r0.A04()
            r3 = 3401(0xd49, float:4.766E-42)
            r2 = 0
            r1 = 9
            r0 = 109(0x6d, float:1.53E-43)
            java.lang.String r0 = A00(r2, r1, r0)
            r4.A82(r0, r3, r5)
        L_0x0031:
            com.facebook.ads.redexgen.X.5p r3 = com.facebook.ads.redexgen.X.C01615o.A00
            java.lang.String[] r1 = com.facebook.ads.redexgen.X.C01615o.A03
            r0 = 1
            r0 = r1[r0]
            int r1 = r0.length()
            r0 = 11
            if (r1 == r0) goto L_0x0046
            java.lang.RuntimeException r0 = new java.lang.RuntimeException
            r0.<init>()
            throw r0
        L_0x0046:
            java.lang.String[] r2 = com.facebook.ads.redexgen.X.C01615o.A03
            java.lang.String r1 = "kDYng9EYBsgXNgOEIL1h1gMPzmVJxAMa"
            r0 = 3
            r2[r0] = r1
            java.lang.String r1 = "TYxT1mxIdvKOfg1hbfM6O4XMHE5Nitia"
            r0 = 6
            r2[r0] = r1
            r3.reset()
            return
        L_0x0056:
            r0 = move-exception
            monitor-exit(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C01615o.A01():void");
    }

    public static void A04(long j) {
        if (j > 0) {
            A00 = new TN();
            new C01635q(j);
        }
    }
}
