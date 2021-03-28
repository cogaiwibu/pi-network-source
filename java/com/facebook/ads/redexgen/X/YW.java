package com.facebook.ads.redexgen.X;

import com.facebook.ads.internal.exoplayer2.Format;
import com.facebook.ads.internal.exoplayer2.metadata.Metadata;
import java.io.EOFException;
import java.io.IOException;
import java.util.Arrays;

public final class YW implements CK {
    public static byte[] A0E;
    public static String[] A0F;
    public static final CN A0G = new YU();
    public static final int A0H = C0466Ig.A08(A04(0, 4, 32));
    public static final int A0I = C0466Ig.A08(A04(28, 4, 74));
    public static final int A0J = C0466Ig.A08(A04(32, 4, 79));
    public int A00;
    public int A01;
    public long A02;
    public long A03;
    public CM A04;
    public CW A05;
    public YV A06;
    public Metadata A07;
    public final int A08;
    public final long A09;
    public final CO A0A;
    public final CP A0B;
    public final CQ A0C;
    public final IQ A0D;

    public static String A04(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A0E, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] ^ i3) ^ 28);
        }
        return new String(copyOfRange);
    }

    public static void A05() {
        A0E = new byte[]{117, 82, 90, 83, 97, 87, 83, 64, 81, 90, 87, 86, 18, 70, 93, 93, 18, 95, 83, 92, 75, 18, 80, 75, 70, 87, 65, 28, 0, 20, 4, 31, 11, 58, 61, 52};
    }

    public static void A06() {
        A0F = new String[]{"ydp2W5xsf3wxxmCItZRtLRLpaCcQN61V", "ZzeQ67WJ6", "MfxT7BiZm", "QAZkmCdKFAHfN7ilsO4NsWCm7AIOdsAB", "uXA2W", "sq6CLgUZZ", "GhmTF3RrY3ydpwpSZCJZy8aIHeXkOr61", "710SvX7FP4z"};
    }

    static {
        A06();
        A05();
    }

    public YW() {
        this(0);
    }

    public YW(int i) {
        this(i, -9223372036854775807L);
    }

    public YW(int i, long j) {
        this.A08 = i;
        this.A09 = j;
        this.A0D = new IQ(10);
        this.A0C = new CQ();
        this.A0A = new CO();
        this.A02 = -9223372036854775807L;
        this.A0B = new CP();
    }

    /* JADX INFO: Multiple debug info for r12v0 'this'  com.facebook.ads.redexgen.X.YW: [D('sampleHeaderData' int), D('bytesAppended' int)] */
    private int A00(CL cl) throws IOException, InterruptedException {
        if (this.A00 == 0) {
            cl.ACa();
            String[] strArr = A0F;
            if (strArr[1].length() != strArr[4].length()) {
                String[] strArr2 = A0F;
                strArr2[0] = "k6Z5PTGWNQqxWVGEWp2g14fMjsllqw2H";
                strArr2[6] = "hJNgcdrxKvM79jF48EqDHnrsGOClnbxU";
                if (!cl.ABa(this.A0D.A00, 0, 4, true)) {
                    return -1;
                }
                this.A0D.A0Z(0);
                int A092 = this.A0D.A09();
                if (!A07(A092, (long) this.A01) || CQ.A00(A092) == -1) {
                    cl.ADG(1);
                    this.A01 = 0;
                    return 0;
                }
                CQ.A05(A092, this.A0C);
                if (this.A02 == -9223372036854775807L) {
                    this.A02 = this.A06.A76(cl.A6m());
                    if (this.A09 != -9223372036854775807L) {
                        this.A02 += this.A09 - this.A06.A76(0);
                    }
                }
                this.A00 = this.A0C.A02;
            } else {
                throw new RuntimeException();
            }
        }
        int ACd = this.A05.ACd(cl, this.A00, true);
        if (ACd == -1) {
            return -1;
        }
        this.A00 -= ACd;
        if (this.A00 > 0) {
            return 0;
        }
        this.A05.ACf(this.A02 + ((this.A03 * 1000000) / ((long) this.A0C.A03)), 1, this.A0C.A02, 0, null);
        this.A03 += (long) this.A0C.A04;
        this.A00 = 0;
        return 0;
    }

    public static int A01(IQ iq, int i) {
        if (iq.A08() >= i + 4) {
            iq.A0Z(i);
            int A092 = iq.A09();
            if (A092 == A0J || A092 == A0H) {
                return A092;
            }
        }
        if (iq.A08() < 40) {
            return 0;
        }
        iq.A0Z(36);
        int A093 = iq.A09();
        int i2 = A0I;
        if (A093 == i2) {
            return i2;
        }
        return 0;
    }

    private YV A02(CL cl) throws IOException, InterruptedException {
        cl.ABZ(this.A0D.A00, 0, 4);
        this.A0D.A0Z(0);
        CQ.A05(this.A0D.A09(), this.A0C);
        return new CH(cl.A6T(), cl.A6m(), this.A0C);
    }

    private YV A03(CL cl) throws IOException, InterruptedException {
        IQ iq = new IQ(this.A0C.A02);
        cl.ABZ(iq.A00, 0, this.A0C.A02);
        int i = 21;
        if ((this.A0C.A05 & 1) != 0) {
            if (this.A0C.A01 != 1) {
                i = 36;
            }
        } else if (this.A0C.A01 == 1) {
            i = 13;
        }
        int A012 = A01(iq, i);
        if (A012 == A0J || A012 == A0H) {
            CD A013 = CD.A01(cl.A6T(), cl.A6m(), this.A0C, iq);
            if (A013 != null && !this.A0A.A04()) {
                cl.ACa();
                cl.A3M(i + 141);
                cl.ABZ(this.A0D.A00, 0, 3);
                this.A0D.A0Z(0);
                this.A0A.A05(this.A0D.A0H());
            }
            cl.ADG(this.A0C.A02);
            if (A013 == null || A013.A7m() || A012 != A0H) {
                return A013;
            }
            return A02(cl);
        } else if (A012 == A0I) {
            CG A002 = CG.A00(cl.A6T(), cl.A6m(), this.A0C, iq);
            cl.ADG(this.A0C.A02);
            return A002;
        } else {
            cl.ACa();
            return null;
        }
    }

    public static boolean A07(int i, long j) {
        return ((long) (-128000 & i)) == (-128000 & j);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x004b, code lost:
        if (r15 == false) goto L_0x0054;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x004d, code lost:
        r14.ADG(r5 + r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0051, code lost:
        r13.A01 = r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0053, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0054, code lost:
        r14.ACa();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x008e, code lost:
        if (r12 != false) goto L_0x0090;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean A08(com.facebook.ads.redexgen.X.CL r14, boolean r15) throws java.io.IOException, java.lang.InterruptedException {
        /*
        // Method dump skipped, instructions count: 256
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.YW.A08(com.facebook.ads.redexgen.X.CL, boolean):boolean");
    }

    @Override // com.facebook.ads.redexgen.X.CK
    public final void A7Q(CM cm) {
        this.A04 = cm;
        this.A05 = this.A04.ADY(0, 1);
        this.A04.A4w();
    }

    @Override // com.facebook.ads.redexgen.X.CK
    public final int ABx(CL cl, CR cr) throws IOException, InterruptedException {
        Metadata metadata;
        if (this.A01 == 0) {
            try {
                A08(cl, false);
            } catch (EOFException unused) {
                return -1;
            }
        }
        if (this.A06 == null) {
            this.A06 = A03(cl);
            YV yv = this.A06;
            if (yv == null || (!yv.A7m() && (this.A08 & 1) != 0)) {
                YV A022 = A02(cl);
                String[] strArr = A0F;
                if (strArr[2].length() != strArr[5].length()) {
                    throw new RuntimeException();
                }
                String[] strArr2 = A0F;
                strArr2[3] = "vRoDRHRtSRtNnEEJ64K4r5ogXxosELXw";
                strArr2[3] = "vRoDRHRtSRtNnEEJ64K4r5ogXxosELXw";
                this.A06 = A022;
            }
            this.A04.ACk(this.A06);
            CW cw = this.A05;
            String str = this.A0C.A06;
            int i = this.A0C.A01;
            int i2 = this.A0C.A03;
            int i3 = this.A0A.A00;
            int i4 = this.A0A.A01;
            if ((this.A08 & 2) != 0) {
                metadata = null;
            } else {
                metadata = this.A07;
            }
            cw.A5A(Format.A05(null, str, null, -1, 4096, i, i2, -1, i3, i4, null, null, 0, null, metadata));
        }
        return A00(cl);
    }

    @Override // com.facebook.ads.redexgen.X.CK
    public final void ACj(long j, long j2) {
        this.A01 = 0;
        this.A02 = -9223372036854775807L;
        this.A03 = 0;
        this.A00 = 0;
    }

    @Override // com.facebook.ads.redexgen.X.CK
    public final boolean ADH(CL cl) throws IOException, InterruptedException {
        return A08(cl, true);
    }
}
