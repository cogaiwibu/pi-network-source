package com.facebook.ads.redexgen.X;

import com.facebook.ads.internal.exoplayer2.Format;
import java.io.EOFException;
import java.io.IOException;
import java.nio.ByteBuffer;

/* renamed from: com.facebook.ads.redexgen.X.Zv  reason: case insensitive filesystem */
public final class C0908Zv implements CW {
    public static String[] A0F;
    public long A00;
    public long A01;
    public Format A02;
    public Format A03;
    public C0385Fb A04 = new C0385Fb(0, this.A0A);
    public C0385Fb A05;
    public C0385Fb A06;
    public AbstractC0386Fc A07;
    public boolean A08;
    public boolean A09;
    public final int A0A;
    public final FZ A0B = new FZ();
    public final C0384Fa A0C = new C0384Fa();
    public final HE A0D;
    public final IQ A0E = new IQ(32);

    static {
        A02();
    }

    public static void A02() {
        A0F = new String[]{"I0oQBEUbvXwmLkE4WWtRMgz", "xnniIxRr7DxSpuMWabRYn3WDpy4qBN9b", "Y7uRaXgz80uNyvcPATB9r3b0PwOkuM1V", "hSCUvOutOZqOqVGgCzlnUKxaNOAoeOWK", "Xz3O4WRIuCzLKbQHyaIDpuywePn7", "cSGy8Fn9cMgpPa", "oA7ibzMCvoxqvUcH1m6Eely4XW9nrCN1", "6CG0cGfKidBjxaDlKmMoUzgrmHvkLCHY"};
    }

    public C0908Zv(HE he) {
        this.A0D = he;
        this.A0A = he.A6P();
        C0385Fb fb = this.A04;
        this.A05 = fb;
        this.A06 = fb;
    }

    private int A00(int i) {
        if (!this.A06.A02) {
            this.A06.A02(this.A0D.A3N(), new C0385Fb(this.A06.A03, this.A0A));
        }
        return Math.min(i, (int) (this.A06.A03 - this.A01));
    }

    public static Format A01(Format format, long j) {
        if (format == null) {
            return null;
        }
        if (j == 0 || format.A0G == Long.MAX_VALUE) {
            return format;
        }
        return format.A0I(format.A0G + j);
    }

    private void A03(int i) {
        this.A01 += (long) i;
        if (this.A01 == this.A06.A03) {
            this.A06 = this.A06.A00;
        }
    }

    private void A04(long j) {
        while (j >= this.A05.A03) {
            this.A05 = this.A05.A00;
        }
    }

    private void A05(long j) {
        if (j != -1) {
            while (j >= this.A04.A03) {
                HE he = this.A0D;
                HD hd = this.A04.A01;
                if (A0F[7].charAt(20) != 'U') {
                    throw new RuntimeException();
                }
                String[] strArr = A0F;
                strArr[3] = "uyKFH8oWQ0ou8mdxvkWufQ8fbIwtl6Z0";
                strArr[1] = "5GODjm0a5UxNqoFNrNo0AvXndV19DDx4";
                he.ACE(hd);
                this.A04 = this.A04.A01();
            }
            if (this.A05.A04 < this.A04.A04) {
                this.A05 = this.A04;
            }
        }
    }

    private void A06(long j, ByteBuffer byteBuffer, int i) {
        A04(j);
        while (i > 0) {
            int min = Math.min(i, (int) (this.A05.A03 - j));
            byteBuffer.put(this.A05.A01.A01, this.A05.A00(j), min);
            i -= min;
            j += (long) min;
            if (j == this.A05.A03) {
                this.A05 = this.A05.A00;
            }
        }
    }

    private void A07(long j, byte[] bArr, int i) {
        A04(j);
        int i2 = i;
        while (i2 > 0) {
            int min = Math.min(i2, (int) (this.A05.A03 - j));
            System.arraycopy(this.A05.A01.A01, this.A05.A00(j), bArr, i - i2, min);
            i2 -= min;
            j += (long) min;
            if (j == this.A05.A03) {
                this.A05 = this.A05.A00;
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x00b8, code lost:
        if (r10 < r11) goto L_0x00ba;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void A08(com.facebook.ads.redexgen.X.C0861Xw r20, com.facebook.ads.redexgen.X.FZ r21) {
        /*
        // Method dump skipped, instructions count: 302
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C0908Zv.A08(com.facebook.ads.redexgen.X.Xw, com.facebook.ads.redexgen.X.FZ):void");
    }

    private void A09(C0385Fb fb) {
        if (fb.A02) {
            HD[] hdArr = new HD[((this.A06.A02 ? 1 : 0) + (((int) (this.A06.A04 - fb.A04)) / this.A0A))];
            for (int i = 0; i < hdArr.length; i++) {
                hdArr[i] = fb.A01;
                fb = fb.A01();
            }
            this.A0D.ACF(hdArr);
        }
    }

    private final void A0A(boolean z) {
        this.A0C.A0I(z);
        A09(this.A04);
        this.A04 = new C0385Fb(0, this.A0A);
        C0385Fb fb = this.A04;
        this.A05 = fb;
        this.A06 = fb;
        this.A01 = 0;
        this.A0D.ADZ();
    }

    public final int A0B() {
        return this.A0C.A08();
    }

    public final int A0C() {
        return this.A0C.A06();
    }

    public final int A0D() {
        return this.A0C.A07();
    }

    public final int A0E(long j, boolean z, boolean z2) {
        return this.A0C.A09(j, z, z2);
    }

    public final int A0F(AH ah, C0861Xw xw, boolean z, boolean z2, long j) {
        int A0A2 = this.A0C.A0A(ah, xw, z, z2, this.A02, this.A0B);
        if (A0A2 == -5) {
            this.A02 = ah.A00;
            return -5;
        } else if (A0A2 == -4) {
            if (!xw.A04()) {
                long j2 = xw.A00;
                if (A0F[7].charAt(20) != 'U') {
                    throw new RuntimeException();
                }
                String[] strArr = A0F;
                strArr[2] = "VD6eroQucXdNz3MsoKHIT4kATW1JDfRN";
                strArr[2] = "VD6eroQucXdNz3MsoKHIT4kATW1JDfRN";
                if (j2 < j) {
                    xw.A00(Integer.MIN_VALUE);
                }
                if (xw.A0A()) {
                    A08(xw, this.A0B);
                }
                xw.A09(this.A0B.A00);
                A06(this.A0B.A01, xw.A01, this.A0B.A00);
            }
            return -4;
        } else if (A0A2 == -3) {
            return -3;
        } else {
            throw new IllegalStateException();
        }
    }

    public final long A0G() {
        return this.A0C.A0C();
    }

    public final Format A0H() {
        return this.A0C.A0F();
    }

    public final void A0I() {
        A05(this.A0C.A0B());
    }

    public final void A0J() {
        A0A(false);
    }

    public final void A0K() {
        this.A0C.A0G();
        this.A05 = this.A04;
    }

    public final void A0L(long j, boolean z, boolean z2) {
        A05(this.A0C.A0E(j, z, z2));
    }

    public final void A0M(AbstractC0386Fc fc) {
        this.A07 = fc;
    }

    public final boolean A0N() {
        return this.A0C.A0J();
    }

    @Override // com.facebook.ads.redexgen.X.CW
    public final void A5A(Format format) {
        Format A012 = A01(format, this.A00);
        boolean A0L = this.A0C.A0L(A012);
        this.A03 = format;
        this.A08 = false;
        AbstractC0386Fc fc = this.A07;
        if (fc != null && A0L) {
            fc.ABD(A012);
        }
    }

    @Override // com.facebook.ads.redexgen.X.CW
    public final int ACd(CL cl, int i, boolean z) throws IOException, InterruptedException {
        int read = cl.read(this.A06.A01.A01, this.A06.A00(this.A01), A00(i));
        if (read != -1) {
            A03(read);
            if (A0F[4].length() != 13) {
                String[] strArr = A0F;
                strArr[0] = "gj56WjutkODHGuBsULoCjgk";
                strArr[5] = "cXoHIYif5j6YkS";
                return read;
            }
            throw new RuntimeException();
        } else if (z) {
            return -1;
        } else {
            throw new EOFException();
        }
    }

    @Override // com.facebook.ads.redexgen.X.CW
    public final void ACe(IQ iq, int i) {
        while (i > 0) {
            int A002 = A00(i);
            iq.A0d(this.A06.A01.A01, this.A06.A00(this.A01), A002);
            i -= A002;
            A03(A002);
        }
    }

    @Override // com.facebook.ads.redexgen.X.CW
    public final void ACf(long j, int i, int i2, int i3, CV cv) {
        if (this.A08) {
            A5A(this.A03);
        }
        if (this.A09) {
            if ((i & 1) != 0) {
                C0384Fa fa = this.A0C;
                if (A0F[4].length() != 13) {
                    String[] strArr = A0F;
                    strArr[3] = "x9Xeu0fQ5laTPGHIgNPQILpO6czCAzIw";
                    strArr[1] = "ozcoxAULLkb5oe9KcRf5sNeK93qRoKsz";
                    if (fa.A0K(j)) {
                        String[] strArr2 = A0F;
                        if (strArr2[0].length() != strArr2[5].length()) {
                            String[] strArr3 = A0F;
                            strArr3[7] = "2aF6Rrv8pvM6dW2iEnwFUFag8sTvrLLb";
                            strArr3[7] = "2aF6Rrv8pvM6dW2iEnwFUFag8sTvrLLb";
                            this.A09 = false;
                        } else {
                            throw new RuntimeException();
                        }
                    } else {
                        return;
                    }
                } else {
                    throw new RuntimeException();
                }
            } else {
                return;
            }
        }
        this.A0C.A0H(j + this.A00, i, (this.A01 - ((long) i2)) - ((long) i3), i2, cv);
    }
}
