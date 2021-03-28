package com.facebook.ads.redexgen.X;

import com.facebook.ads.internal.exoplayer2.Format;

/* renamed from: com.facebook.ads.redexgen.X.Ys  reason: case insensitive filesystem */
public final class C0883Ys implements DQ {
    public static String[] A0C;
    public int A00;
    public int A01;
    public int A02;
    public long A03;
    public long A04;
    public Format A05;
    public CW A06;
    public String A07;
    public boolean A08;
    public final IP A09;
    public final IQ A0A;
    public final String A0B;

    static {
        A01();
    }

    public static void A01() {
        A0C = new String[]{"nJiMpwDCR7ZAmhQyp9AOHiC56UVcRx0k", "lCnqxh0y89Em7p481QheNATB6nErTPja", "EOgZonHCFyaPw1rQOdlgFposS9KMweND", "oVFhsCJtzutno5RzvIOwcHRYGNjJYB0M", "4", "S", "C7ZxqwSPJTae6vgKBRSPBAMVUD", "Gg5xSTo0LtnMpcaC7QBiBySoh1"};
    }

    public C0883Ys() {
        this(null);
    }

    public C0883Ys(String str) {
        this.A09 = new IP(new byte[128]);
        this.A0A = new IQ(this.A09.A00);
        this.A02 = 0;
        this.A0B = str;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x004a, code lost:
        if (r1.A05 == r13.A05.A0O) goto L_0x0069;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void A00() {
        /*
        // Method dump skipped, instructions count: 125
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C0883Ys.A00():void");
    }

    private boolean A02(IQ iq) {
        while (true) {
            boolean z = false;
            if (iq.A05() <= 0) {
                return false;
            }
            if (!this.A08) {
                if (iq.A0F() == 11) {
                    z = true;
                }
                this.A08 = z;
            } else {
                int A0F = iq.A0F();
                if (A0F == 119) {
                    this.A08 = false;
                    return true;
                }
                if (A0F == 11) {
                    z = true;
                }
                this.A08 = z;
            }
        }
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
                if (i != 1) {
                    if (i == 2) {
                        int min = Math.min(iq.A05(), this.A01 - this.A00);
                        this.A06.ACe(iq, min);
                        this.A00 += min;
                        int i2 = this.A00;
                        int i3 = this.A01;
                        if (i2 == i3) {
                            this.A06.ACf(this.A04, 1, i3, 0, null);
                            this.A04 += this.A03;
                            this.A02 = 0;
                        }
                    }
                } else if (A03(iq, this.A0A.A00, 128)) {
                    A00();
                    this.A0A.A0Z(0);
                    this.A06.ACe(this.A0A, 128);
                    this.A02 = 2;
                }
            } else if (A02(iq)) {
                this.A02 = 1;
                this.A0A.A00[0] = 11;
                this.A0A.A00[1] = 119;
                this.A00 = 2;
            }
        }
    }

    @Override // com.facebook.ads.redexgen.X.DQ
    public final void A4U(CM cm, C0340De de) {
        de.A06();
        this.A07 = de.A05();
        this.A06 = cm.ADY(de.A04(), 1);
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
