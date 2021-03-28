package com.facebook.ads.redexgen.X;

import com.facebook.ads.internal.exoplayer2.Format;

/* renamed from: com.facebook.ads.redexgen.X.Yx  reason: case insensitive filesystem */
public final class C0888Yx implements DQ {
    public static String[] A0B;
    public int A00;
    public int A01;
    public int A02 = 0;
    public int A03;
    public long A04;
    public long A05;
    public Format A06;
    public CW A07;
    public String A08;
    public final IQ A09 = new IQ(new byte[18]);
    public final String A0A;

    static {
        A01();
    }

    public static void A01() {
        A0B = new String[]{"Egp8wbctYg3AnrLoFsY0muWOBg0DV21X", "e5h8xZQ9y742", "HWojDw1vanmhl7F", "V39ipiog0D", "u2piqSS4vuQoaStDwbY0GoBR5fBlfuuM", "rfNh4mzWhxdgTcwc6CqJaoU4clFtHzcH", "1g0ZSxhEfC", "eBXSmpY9RuNSQ1O4XZ5t"};
    }

    public C0888Yx(String str) {
        this.A0A = str;
    }

    private void A00() {
        byte[] bArr = this.A09.A00;
        if (this.A06 == null) {
            this.A06 = BT.A03(bArr, this.A08, this.A0A, null);
            this.A07.A5A(this.A06);
        }
        this.A01 = BT.A01(bArr);
        this.A04 = (long) ((int) ((((long) BT.A02(bArr)) * 1000000) / ((long) this.A06.A0C)));
    }

    private boolean A02(IQ iq) {
        do {
            int A052 = iq.A05();
            String[] strArr = A0B;
            if (strArr[3].length() != strArr[6].length()) {
                throw new RuntimeException();
            }
            String[] strArr2 = A0B;
            strArr2[2] = "u2vG9yItOjfrtL1HZZufPW";
            strArr2[2] = "u2vG9yItOjfrtL1HZZufPW";
            if (A052 <= 0) {
                return false;
            }
            this.A03 <<= 8;
            this.A03 |= iq.A0F();
        } while (!BT.A08(this.A03));
        this.A09.A00[0] = (byte) ((this.A03 >> 24) & 255);
        this.A09.A00[1] = (byte) ((this.A03 >> 16) & 255);
        this.A09.A00[2] = (byte) ((this.A03 >> 8) & 255);
        this.A09.A00[3] = (byte) (this.A03 & 255);
        this.A00 = 4;
        this.A03 = 0;
        return true;
    }

    private boolean A03(IQ iq, byte[] bArr, int i) {
        int min = Math.min(iq.A05(), i - this.A00);
        iq.A0d(bArr, this.A00, min);
        this.A00 += min;
        return this.A00 == i;
    }

    @Override // com.facebook.ads.redexgen.X.DQ
    public final void A48(IQ iq) {
        while (iq.A05() > 0) {
            int i = this.A02;
            if (i != 0) {
                if (i == 1) {
                    byte[] bArr = this.A09.A00;
                    String[] strArr = A0B;
                    if (strArr[5].charAt(14) != strArr[4].charAt(14)) {
                        String[] strArr2 = A0B;
                        strArr2[7] = "fRWG3CzCM1nyuvAzq7jz";
                        strArr2[0] = "3KzD1A3zkNrKwQoZtzGyJPl8BSj940od";
                        if (A03(iq, bArr, 18)) {
                            A00();
                            this.A09.A0Z(0);
                            this.A07.ACe(this.A09, 18);
                            this.A02 = 2;
                        }
                    } else {
                        throw new RuntimeException();
                    }
                } else if (i == 2) {
                    int min = Math.min(iq.A05(), this.A01 - this.A00);
                    this.A07.ACe(iq, min);
                    this.A00 += min;
                    int i2 = this.A00;
                    int i3 = this.A01;
                    if (i2 == i3) {
                        this.A07.ACf(this.A05, 1, i3, 0, null);
                        this.A05 += this.A04;
                        this.A02 = 0;
                    }
                }
            } else if (A02(iq)) {
                this.A02 = 1;
            }
        }
    }

    @Override // com.facebook.ads.redexgen.X.DQ
    public final void A4U(CM cm, C0340De de) {
        de.A06();
        this.A08 = de.A05();
        this.A07 = cm.ADY(de.A04(), 1);
    }

    @Override // com.facebook.ads.redexgen.X.DQ
    public final void ABV() {
    }

    @Override // com.facebook.ads.redexgen.X.DQ
    public final void ABW(long j, boolean z) {
        this.A05 = j;
    }

    @Override // com.facebook.ads.redexgen.X.DQ
    public final void ACi() {
        this.A02 = 0;
        this.A00 = 0;
        this.A03 = 0;
    }
}
