package com.facebook.ads.redexgen.X;

import java.util.Arrays;

/* renamed from: com.facebook.ads.redexgen.X.Yz  reason: case insensitive filesystem */
public final class C0890Yz implements DQ {
    public static byte[] A0D;
    public static String[] A0E;
    public static final double[] A0F = {23.976023976023978d, 24.0d, 25.0d, 29.97002997002997d, 30.0d, 50.0d, 59.94005994005994d, 60.0d};
    public long A00;
    public long A01;
    public long A02;
    public long A03;
    public long A04;
    public CW A05;
    public String A06;
    public boolean A07;
    public boolean A08;
    public boolean A09;
    public boolean A0A;
    public final DR A0B = new DR(128);
    public final boolean[] A0C = new boolean[4];

    public static String A01(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A0D, i, i + i2);
        int i4 = 0;
        while (true) {
            int length = copyOfRange.length;
            if (A0E[1].length() != 23) {
                throw new RuntimeException();
            }
            String[] strArr = A0E;
            strArr[4] = "Ri5OGo1CF8gLgqNPBzhcn52enWrdUOS9";
            strArr[4] = "Ri5OGo1CF8gLgqNPBzhcn52enWrdUOS9";
            if (i4 >= length) {
                return new String(copyOfRange);
            }
            copyOfRange[i4] = (byte) ((copyOfRange[i4] - i3) - 59);
            i4++;
        }
    }

    public static void A02() {
        A0D = new byte[]{-2, -15, -20, -19, -9, -73, -11, -8, -19, -17, -70};
    }

    public static void A03() {
        A0E = new String[]{"YsqY7Lk0NG7yMwVwuR3aCKQ1vCFnnoD7", "imTBT5eeu9SEESxnKVa9Th5", "O0aT", "zBRiiCG0AgE79WafkQACjpG1QDeKkcp1", "wwjqIDfPN4cSDtn9coCmQZMwbPpUFodD", "uPTa", "JD3sFkMXr2jLKKNxvTNpqQokakbynhd6", "fAZgloKcDeiXibtKpEsUxRbbQwdcutNH"};
    }

    static {
        A03();
        A02();
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0099  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static android.util.Pair<com.facebook.ads.internal.exoplayer2.Format, java.lang.Long> A00(com.facebook.ads.redexgen.X.DR r21, java.lang.String r22) {
        /*
        // Method dump skipped, instructions count: 229
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C0890Yz.A00(com.facebook.ads.redexgen.X.DR, java.lang.String):android.util.Pair");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:30:0x00d7, code lost:
        if (r3 != false) goto L_0x00d9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x0127, code lost:
        if (r2 != -9223372036854775807L) goto L_0x0129;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x0145, code lost:
        if (r2 != -9223372036854775807L) goto L_0x0129;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x014a, code lost:
        if (r21.A0A == false) goto L_0x0152;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x014c, code lost:
        r2 = r21.A03 + r21.A00;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x0152, code lost:
        r2 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x0161, code lost:
        if (r3 != false) goto L_0x00d9;
     */
    @Override // com.facebook.ads.redexgen.X.DQ
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void A48(com.facebook.ads.redexgen.X.IQ r22) {
        /*
        // Method dump skipped, instructions count: 370
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C0890Yz.A48(com.facebook.ads.redexgen.X.IQ):void");
    }

    @Override // com.facebook.ads.redexgen.X.DQ
    public final void A4U(CM cm, C0340De de) {
        de.A06();
        this.A06 = de.A05();
        this.A05 = cm.ADY(de.A04(), 2);
    }

    @Override // com.facebook.ads.redexgen.X.DQ
    public final void ABV() {
    }

    @Override // com.facebook.ads.redexgen.X.DQ
    public final void ABW(long j, boolean z) {
        this.A01 = j;
    }

    @Override // com.facebook.ads.redexgen.X.DQ
    public final void ACi() {
        IM.A0C(this.A0C);
        this.A0B.A01();
        this.A04 = 0;
        this.A0A = false;
    }
}
