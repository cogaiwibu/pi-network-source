package com.facebook.ads.redexgen.X;

import java.util.Arrays;

public final class Z0 implements DQ {
    public static byte[] A0E;
    public static String[] A0F;
    public long A00;
    public long A01;
    public CW A02;
    public DU A03;
    public String A04;
    public boolean A05;
    public final DW A06 = new DW(8, 128);
    public final DW A07 = new DW(6, 128);
    public final DW A08 = new DW(7, 128);
    public final DZ A09;
    public final IQ A0A = new IQ();
    public final boolean A0B;
    public final boolean A0C;
    public final boolean[] A0D = new boolean[3];

    static {
        A02();
        A01();
    }

    public static String A00(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A0E, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] ^ i3) ^ 52);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A0E = new byte[]{37, 58, 55, 54, 60, 124, 50, 37, 48};
    }

    public static void A02() {
        A0F = new String[]{"OaAtDjibDffMS", "aj2yyuicdEn8dhTDbWTrD1WtuleVGPEx", "a3NvGU2CXdpQvxvcysdReyA6yUgKGJjf", "4BBSavRiCGZis8TiCNo6nDJqjRzxnCkr", "3Isw3BGBXoN1VbjlJcagr5xDVNXHwLpI", "HfhncQp7sGaDAl", "zNtUp", "pzzsrx2QpEHePoyNV"};
    }

    public Z0(DZ dz, boolean z, boolean z2) {
        this.A09 = dz;
        this.A0B = z;
        this.A0C = z2;
    }

    /* JADX INFO: Multiple debug info for r2v9 com.facebook.ads.redexgen.X.CW: [D('initializationData' java.util.List<byte[]>), D('spsData' com.facebook.ads.redexgen.X.IL)] */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x017a, code lost:
        if (r4.A04() != false) goto L_0x017c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x01a4, code lost:
        if (r4.A04() != false) goto L_0x017c;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void A03(long r25, int r27, int r28, long r29) {
        /*
        // Method dump skipped, instructions count: 429
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.Z0.A03(long, int, int, long):void");
    }

    private void A04(long j, int i, long j2) {
        if (!this.A05 || this.A03.A08()) {
            this.A08.A02(i);
            this.A06.A02(i);
        }
        this.A07.A02(i);
        String[] strArr = A0F;
        if (strArr[4].charAt(8) != strArr[2].charAt(8)) {
            throw new RuntimeException();
        }
        String[] strArr2 = A0F;
        strArr2[5] = "7DOfm1dA88ob89";
        strArr2[0] = "yqrgSqZS2XcB9";
        this.A03.A04(j, i, j2);
    }

    private void A05(byte[] bArr, int i, int i2) {
        if (!this.A05 || this.A03.A08()) {
            this.A08.A03(bArr, i, i2);
            this.A06.A03(bArr, i, i2);
        }
        this.A07.A03(bArr, i, i2);
        this.A03.A07(bArr, i, i2);
    }

    @Override // com.facebook.ads.redexgen.X.DQ
    public final void A48(IQ iq) {
        int offset;
        int A072 = iq.A07();
        int A082 = iq.A08();
        byte[] bArr = iq.A00;
        this.A01 += (long) iq.A05();
        this.A02.ACe(iq, iq.A05());
        while (true) {
            int A042 = IM.A04(bArr, A072, A082, this.A0D);
            if (A042 == A082) {
                A05(bArr, A072, A082);
                return;
            }
            int A012 = IM.A01(bArr, A042);
            int nalUnitOffset = A042 - A072;
            if (nalUnitOffset > 0) {
                A05(bArr, A072, A042);
            }
            int i = A082 - A042;
            long j = this.A01 - ((long) i);
            if (nalUnitOffset < 0) {
                offset = -nalUnitOffset;
            } else {
                offset = 0;
            }
            A03(j, i, offset, this.A00);
            A04(j, A012, this.A00);
            A072 = A042 + 3;
        }
    }

    @Override // com.facebook.ads.redexgen.X.DQ
    public final void A4U(CM cm, C0340De de) {
        de.A06();
        this.A04 = de.A05();
        this.A02 = cm.ADY(de.A04(), 2);
        this.A03 = new DU(this.A02, this.A0B, this.A0C);
        this.A09.A03(cm, de);
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
        this.A08.A01();
        this.A06.A01();
        this.A07.A01();
        this.A03.A02();
        this.A01 = 0;
    }
}
