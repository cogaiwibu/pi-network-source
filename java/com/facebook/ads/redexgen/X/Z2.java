package com.facebook.ads.redexgen.X;

import android.util.Log;
import com.facebook.ads.internal.exoplayer2.Format;
import java.util.Arrays;

public final class Z2 implements DQ {
    public static byte[] A06;
    public int A00;
    public int A01;
    public long A02;
    public CW A03;
    public boolean A04;
    public final IQ A05 = new IQ(10);

    static {
        A01();
    }

    public static String A00(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A06, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] - i3) - 123);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A06 = new byte[]{25, 62, 72, 56, 54, 71, 57, 62, 67, 60, -11, 62, 67, 75, 54, 65, 62, 57, -11, 30, 25, 8, -11, 73, 54, 60, -16, 11, -38, -7, 12, 8, 11, 12, 25, 89, 104, 104, 100, 97, 91, 89, 108, 97, 103, 102, 39, 97, 92, 43};
    }

    /* JADX INFO: Multiple debug info for r8v0 com.facebook.ads.redexgen.X.IQ: [D('headerBytesAvailable' int), D('bytesToWrite' int)] */
    @Override // com.facebook.ads.redexgen.X.DQ
    public final void A48(IQ iq) {
        if (this.A04) {
            int A052 = iq.A05();
            int i = this.A00;
            if (i < 10) {
                int min = Math.min(A052, 10 - i);
                System.arraycopy(iq.A00, iq.A07(), this.A05.A00, this.A00, min);
                if (this.A00 + min == 10) {
                    this.A05.A0Z(0);
                    if (73 == this.A05.A0F() && 68 == this.A05.A0F() && 51 == this.A05.A0F()) {
                        this.A05.A0a(3);
                        this.A01 = this.A05.A0E() + 10;
                    } else {
                        Log.w(A00(26, 9, 44), A00(0, 26, 90));
                        this.A04 = false;
                        return;
                    }
                }
            }
            int min2 = Math.min(A052, this.A01 - this.A00);
            this.A03.ACe(iq, min2);
            this.A00 += min2;
        }
    }

    @Override // com.facebook.ads.redexgen.X.DQ
    public final void A4U(CM cm, C0340De de) {
        de.A06();
        this.A03 = cm.ADY(de.A04(), 4);
        this.A03.A5A(Format.A0B(de.A05(), A00(35, 15, 125), null, -1, null));
    }

    @Override // com.facebook.ads.redexgen.X.DQ
    public final void ABV() {
        int i;
        if (this.A04 && (i = this.A01) != 0 && this.A00 == i) {
            this.A03.ACf(this.A02, 1, i, 0, null);
            this.A04 = false;
        }
    }

    @Override // com.facebook.ads.redexgen.X.DQ
    public final void ABW(long j, boolean z) {
        if (z) {
            this.A04 = true;
            this.A02 = j;
            this.A01 = 0;
            this.A00 = 0;
        }
    }

    @Override // com.facebook.ads.redexgen.X.DQ
    public final void ACi() {
        this.A04 = false;
    }
}
