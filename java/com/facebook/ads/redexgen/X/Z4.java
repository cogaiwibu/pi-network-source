package com.facebook.ads.redexgen.X;

import com.facebook.ads.internal.exoplayer2.Format;

public final class Z4 implements DQ {
    public static String[] A0C;
    public int A00;
    public int A01;
    public int A02;
    public long A03;
    public long A04;
    public CW A05;
    public String A06;
    public boolean A07;
    public boolean A08;
    public final CQ A09;
    public final IQ A0A;
    public final String A0B;

    static {
        A00();
    }

    public static void A00() {
        A0C = new String[]{"KDszHDzXfqF59CRVRWftd3HVsRnCigSQ", "mt1wJ32vNuSPyEC341LvOqJuOPF0PUkp", "WrM", "XaAyFYRGYfBBBZw7eK", "eDOzUgm8HT4q1AQmalgqs20fTFsFJUGd", "BoW68Cbgp4ULkXl8fLSwM62hHrGuEs23", "bWE7L7mx05VAedoWHIxzCG4hfzqVFa", "OpD2t2SPaq7VaFKSNzknI6aN9MYETC"};
    }

    public Z4() {
        this(null);
    }

    public Z4(String str) {
        this.A02 = 0;
        this.A0A = new IQ(4);
        this.A0A.A00[0] = -1;
        this.A09 = new CQ();
        this.A0B = str;
    }

    /* JADX INFO: Multiple debug info for r4v1 'i'  int: [D('i' int), D('found' boolean)] */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x005e  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0075  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void A01(com.facebook.ads.redexgen.X.IQ r11) {
        /*
        // Method dump skipped, instructions count: 141
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.Z4.A01(com.facebook.ads.redexgen.X.IQ):void");
    }

    private void A02(IQ iq) {
        int min = Math.min(iq.A05(), this.A01 - this.A00);
        this.A05.ACe(iq, min);
        this.A00 += min;
        int i = this.A00;
        int i2 = this.A01;
        if (i >= i2) {
            this.A05.ACf(this.A04, 1, i2, 0, null);
            this.A04 += this.A03;
            this.A00 = 0;
            String[] strArr = A0C;
            if (strArr[5].charAt(10) != strArr[0].charAt(10)) {
                String[] strArr2 = A0C;
                strArr2[1] = "ScjCWzDsMvlE6C4iVMEuFqkFuKCicUAb";
                strArr2[4] = "udpHDrUjrNQxaJr25pS4UodeWrrvfUFS";
                this.A02 = 0;
                return;
            }
            throw new RuntimeException();
        }
    }

    private void A03(IQ iq) {
        int min = Math.min(iq.A05(), 4 - this.A00);
        iq.A0d(this.A0A.A00, this.A00, min);
        this.A00 += min;
        if (this.A00 >= 4) {
            this.A0A.A0Z(0);
            if (!CQ.A05(this.A0A.A09(), this.A09)) {
                this.A00 = 0;
                this.A02 = 1;
                return;
            }
            this.A01 = this.A09.A02;
            if (!this.A07) {
                this.A03 = (((long) this.A09.A04) * 1000000) / ((long) this.A09.A03);
                this.A05.A5A(Format.A07(this.A06, this.A09.A06, null, -1, 4096, this.A09.A01, this.A09.A03, null, null, 0, this.A0B));
                this.A07 = true;
            }
            this.A0A.A0Z(0);
            this.A05.ACe(this.A0A, 4);
            this.A02 = 2;
        }
    }

    @Override // com.facebook.ads.redexgen.X.DQ
    public final void A48(IQ iq) {
        while (iq.A05() > 0) {
            int i = this.A02;
            if (i == 0) {
                A01(iq);
            } else if (i != 1) {
                String[] strArr = A0C;
                if (strArr[1].charAt(29) != strArr[4].charAt(29)) {
                    throw new RuntimeException();
                }
                String[] strArr2 = A0C;
                strArr2[1] = "DlgSkZ7kUmj97mVCMXW7YS18xBC70U7G";
                strArr2[4] = "tybkSaN9ICkxBJ48s31m7V5Ixzqz2U6M";
                if (i == 2) {
                    A02(iq);
                }
            } else {
                A03(iq);
            }
        }
    }

    @Override // com.facebook.ads.redexgen.X.DQ
    public final void A4U(CM cm, C0340De de) {
        de.A06();
        this.A06 = de.A05();
        this.A05 = cm.ADY(de.A04(), 1);
    }

    @Override // com.facebook.ads.redexgen.X.DQ
    public final void ABV() {
    }

    @Override // com.facebook.ads.redexgen.X.DQ
    public final void ABW(long j, boolean z) {
        this.A04 = j;
    }

    @Override // com.facebook.ads.redexgen.X.DQ
    public final void ACi() {
        this.A02 = 0;
        this.A00 = 0;
        this.A08 = false;
    }
}
