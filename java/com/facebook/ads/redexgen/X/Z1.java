package com.facebook.ads.redexgen.X;

import com.onesignal.NotificationBundleProcessor;
import java.util.Arrays;

public final class Z1 implements DQ {
    public static byte[] A0E;
    public static String[] A0F;
    public long A00;
    public long A01;
    public CW A02;
    public DV A03;
    public String A04;
    public boolean A05;
    public final DW A06 = new DW(34, 128);
    public final DW A07 = new DW(39, 128);
    public final DW A08 = new DW(33, 128);
    public final DW A09 = new DW(40, 128);
    public final DW A0A = new DW(32, 128);
    public final DZ A0B;
    public final IQ A0C = new IQ();
    public final boolean[] A0D = new boolean[3];

    static {
        A03();
        A02();
    }

    public static String A01(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A0E, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] - i3) - 87);
        }
        return new String(copyOfRange);
    }

    public static void A02() {
        A0E = new byte[]{-65, -87, -83, -84, -55, -36, -40, -37, -36, -23, -20, 5, -4, 15, 7, -4, -6, 11, -4, -5, -73, -8, 10, 7, -4, -6, 11, -10, 9, -8, 11, 0, 6, -10, 0, -5, -6, -73, 13, -8, 3, 12, -4, -47, -73, 49, 36, 31, 32, 42, -22, 35, 32, 49, 30};
    }

    public static void A03() {
        A0F = new String[]{NotificationBundleProcessor.PUSH_ADDITIONAL_DATA_KEY, "PSzfdfjRZC0XN6VxjsgcztfFaZhzgWb7", "1Gl4YGiW2C7ithS", "fAa", "AJgx", "lYVk", "kBtUfz7weItcbZk1MBk54uJpUuqD7Dj9", "de5NTYCoeu4fZv0TXl8jvZIWd"};
    }

    public Z1(DZ dz) {
        this.A0B = dz;
    }

    /* JADX INFO: Multiple debug info for r3v1 com.facebook.ads.redexgen.X.IR: [D('log2MaxPicOrderCntLsbMinus4' int), D('csd' byte[]), D('subHeightC' int)] */
    /* JADX INFO: Multiple debug info for r0v43 int: [D('aspectRatioIdc' int), D('sarHeight' int)] */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x01e1, code lost:
        if (r6 == 255) goto L_0x01e3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:0x0214, code lost:
        if (r6 == 255) goto L_0x01e3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:0x021a, code lost:
        if (r6 >= com.facebook.ads.redexgen.X.IM.A04.length) goto L_0x0221;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x021c, code lost:
        r4 = com.facebook.ads.redexgen.X.IM.A04[r6];
     */
    /* JADX WARNING: Code restructure failed: missing block: B:75:0x0221, code lost:
        android.util.Log.w(A01(0, 10, 32), A01(10, 35, 64) + r6);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.facebook.ads.internal.exoplayer2.Format A00(java.lang.String r17, com.facebook.ads.redexgen.X.DW r18, com.facebook.ads.redexgen.X.DW r19, com.facebook.ads.redexgen.X.DW r20) {
        /*
        // Method dump skipped, instructions count: 601
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.Z1.A00(java.lang.String, com.facebook.ads.redexgen.X.DW, com.facebook.ads.redexgen.X.DW, com.facebook.ads.redexgen.X.DW):com.facebook.ads.internal.exoplayer2.Format");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x00ae, code lost:
        if (r3.A04() != false) goto L_0x00b0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x00e9, code lost:
        if (r3.A04() != false) goto L_0x00b0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void A04(long r6, int r8, int r9, long r10) {
        /*
        // Method dump skipped, instructions count: 253
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.Z1.A04(long, int, int, long):void");
    }

    private void A05(long j, int i, int i2, long j2) {
        if (this.A05) {
            this.A03.A04(j, i, i2, j2);
        } else {
            this.A0A.A02(i2);
            this.A08.A02(i2);
            this.A06.A02(i2);
        }
        this.A07.A02(i2);
        this.A09.A02(i2);
    }

    public static void A06(IR ir) {
        for (int i = 0; i < 4; i++) {
            int i2 = 0;
            while (i2 < 6) {
                if (!ir.A0B()) {
                    ir.A05();
                } else {
                    int min = Math.min(64, 1 << ((i << 1) + 4));
                    if (i > 1) {
                        ir.A04();
                    }
                    for (int i3 = 0; i3 < min; i3++) {
                        ir.A04();
                    }
                }
                int i4 = 3;
                if (i != 3) {
                    i4 = 1;
                }
                i2 += i4;
            }
        }
    }

    public static void A07(IR ir) {
        int A052 = ir.A05();
        boolean z = false;
        int stRpsIdx = 0;
        for (int numNegativePics = 0; numNegativePics < A052; numNegativePics++) {
            if (numNegativePics != 0) {
                z = ir.A0B();
            }
            if (z) {
                ir.A07();
                ir.A05();
                for (int i = 0; i <= stRpsIdx; i++) {
                    if (ir.A0B()) {
                        ir.A07();
                    }
                }
            } else {
                int numPositivePics = ir.A05();
                int A053 = ir.A05();
                stRpsIdx = numPositivePics + A053;
                for (int i2 = 0; i2 < numPositivePics; i2++) {
                    ir.A05();
                    ir.A07();
                }
                for (int i3 = 0; i3 < A053; i3++) {
                    ir.A05();
                    if (A0F[2].length() != 15) {
                        throw new RuntimeException();
                    }
                    String[] strArr = A0F;
                    strArr[7] = "29HJBmKLkgSGGX3jFY36NCeZA";
                    strArr[7] = "29HJBmKLkgSGGX3jFY36NCeZA";
                    ir.A07();
                }
                continue;
            }
        }
    }

    private void A08(byte[] bArr, int i, int i2) {
        if (this.A05) {
            this.A03.A05(bArr, i, i2);
        } else {
            this.A0A.A03(bArr, i, i2);
            this.A08.A03(bArr, i, i2);
            this.A06.A03(bArr, i, i2);
        }
        this.A07.A03(bArr, i, i2);
        this.A09.A03(bArr, i, i2);
    }

    @Override // com.facebook.ads.redexgen.X.DQ
    public final void A48(IQ iq) {
        int i;
        while (iq.A05() > 0) {
            int A072 = iq.A07();
            int A082 = iq.A08();
            byte[] bArr = iq.A00;
            this.A01 += (long) iq.A05();
            this.A02.ACe(iq, iq.A05());
            while (true) {
                if (A072 < A082) {
                    int A042 = IM.A04(bArr, A072, A082, this.A0D);
                    if (A042 == A082) {
                        A08(bArr, A072, A082);
                        return;
                    }
                    int A002 = IM.A00(bArr, A042);
                    int nalUnitType = A042 - A072;
                    if (nalUnitType > 0) {
                        A08(bArr, A072, A042);
                    }
                    int lengthToNalUnit = A082 - A042;
                    long j = this.A01 - ((long) lengthToNalUnit);
                    if (nalUnitType < 0) {
                        i = -nalUnitType;
                    } else {
                        i = 0;
                    }
                    A04(j, lengthToNalUnit, i, this.A00);
                    A05(j, lengthToNalUnit, A002, this.A00);
                    A072 = A042 + 3;
                }
            }
        }
    }

    @Override // com.facebook.ads.redexgen.X.DQ
    public final void A4U(CM cm, C0340De de) {
        de.A06();
        this.A04 = de.A05();
        this.A02 = cm.ADY(de.A04(), 2);
        this.A03 = new DV(this.A02);
        this.A0B.A03(cm, de);
    }

    @Override // com.facebook.ads.redexgen.X.DQ
    public final void ABV() {
    }

    @Override // com.facebook.ads.redexgen.X.DQ
    public final void ABW(long j, boolean z) {
        this.A00 = j;
    }

    @Override // com.facebook.ads.redexgen.X.DQ
    public final void ACi() {
        IM.A0C(this.A0D);
        this.A0A.A01();
        this.A08.A01();
        this.A06.A01();
        this.A07.A01();
        this.A09.A01();
        this.A03.A02();
        this.A01 = 0;
    }
}
