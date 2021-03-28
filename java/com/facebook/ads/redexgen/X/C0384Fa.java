package com.facebook.ads.redexgen.X;

import com.facebook.ads.internal.exoplayer2.Format;

/* renamed from: com.facebook.ads.redexgen.X.Fa  reason: case insensitive filesystem */
public final class C0384Fa {
    public static String[] A0I;
    public int A00;
    public int A01 = 1000;
    public int A02;
    public int A03;
    public int A04;
    public int A05;
    public long A06;
    public long A07;
    public Format A08;
    public boolean A09;
    public boolean A0A;
    public int[] A0B;
    public int[] A0C;
    public int[] A0D;
    public long[] A0E;
    public long[] A0F;
    public Format[] A0G;
    public CV[] A0H;

    static {
        A04();
    }

    public static void A04() {
        A0I = new String[]{"CqT0KuE1AFfImBFy4ik", "hGcHjrCi226kocD9vKzS9HyQAF0ZqssA", "ZD81yrpYsqeXe4L", "XJx", "nsm5GlP1XQIMmswL2BtDEyl4JYnPccJt", "OHNFP06lkToQsW2YsoX4lx0", "UGSwurzNNOniPMx0TIQOqAAX3osRvTJh", "YaODE33QO8vEeLZGxHQ5TNBfWhqIAS5S"};
    }

    public C0384Fa() {
        int i = this.A01;
        this.A0D = new int[i];
        this.A0E = new long[i];
        this.A0F = new long[i];
        this.A0B = new int[i];
        this.A0C = new int[i];
        this.A0H = new CV[i];
        this.A0G = new Format[i];
        this.A06 = Long.MIN_VALUE;
        this.A07 = Long.MIN_VALUE;
        this.A09 = true;
        this.A0A = true;
    }

    private int A00(int i) {
        int i2 = this.A04 + i;
        int i3 = this.A01;
        return i2 < i3 ? i2 : i2 - i3;
    }

    private int A01(int searchIndex, int i, long j, boolean z) {
        int i2 = -1;
        for (int i3 = 0; i3 < i; i3++) {
            long j2 = this.A0F[searchIndex];
            String[] strArr = A0I;
            if (strArr[3].length() != strArr[5].length()) {
                String[] strArr2 = A0I;
                strArr2[3] = "JFV";
                strArr2[5] = "8A9T2ZHBGF6P3L1HGcqfomX";
                if (j2 > j) {
                    break;
                }
                if (!z || (this.A0B[searchIndex] & 1) != 0) {
                    i2 = i3;
                }
                searchIndex++;
                if (searchIndex == this.A01) {
                    searchIndex = 0;
                }
            } else {
                throw new RuntimeException();
            }
        }
        return i2;
    }

    private long A02(int i) {
        this.A06 = Math.max(this.A06, A03(i));
        this.A02 -= i;
        this.A00 += i;
        this.A04 += i;
        int i2 = this.A04;
        int i3 = this.A01;
        if (i2 >= i3) {
            int i4 = i2 - i3;
            String[] strArr = A0I;
            if (strArr[7].charAt(18) != strArr[6].charAt(18)) {
                throw new RuntimeException();
            }
            String[] strArr2 = A0I;
            strArr2[2] = "rmPQqkiHfMf";
            strArr2[2] = "rmPQqkiHfMf";
            this.A04 = i4;
        }
        this.A03 -= i;
        if (this.A03 < 0) {
            if (A0I[2].length() != 8) {
                String[] strArr3 = A0I;
                strArr3[4] = "rGNm6jdFTVK86xam60qdwwsNjuy3SfLS";
                strArr3[1] = "zCUBtEUnOSv2Jph2uhLKbu226T4aXBY5";
                this.A03 = 0;
            } else {
                throw new RuntimeException();
            }
        }
        if (this.A02 != 0) {
            return this.A0E[this.A04];
        }
        int i5 = this.A04;
        if (i5 == 0) {
            i5 = this.A01;
        }
        int i6 = i5 - 1;
        return this.A0E[i6] + ((long) this.A0C[i6]);
    }

    private long A03(int i) {
        if (i == 0) {
            return Long.MIN_VALUE;
        }
        long j = Long.MIN_VALUE;
        int relativeSampleIndex = A00(i - 1);
        for (int i2 = 0; i2 < i; i2++) {
            j = Math.max(j, this.A0F[relativeSampleIndex]);
            if ((this.A0B[relativeSampleIndex] & 1) != 0) {
                break;
            }
            relativeSampleIndex--;
            if (relativeSampleIndex == -1) {
                int i3 = this.A01;
                String[] strArr = A0I;
                if (strArr[4].charAt(25) != strArr[1].charAt(25)) {
                    String[] strArr2 = A0I;
                    strArr2[3] = "3tp";
                    strArr2[5] = "Z0W9OfGRhIfCW820bOQ6uFB";
                    relativeSampleIndex = i3 - 1;
                } else {
                    throw new RuntimeException();
                }
            }
        }
        return j;
    }

    private final synchronized void A05(long j) {
        this.A07 = Math.max(this.A07, j);
    }

    public final int A06() {
        return this.A00 + this.A03;
    }

    public final int A07() {
        return this.A00 + this.A02;
    }

    public final synchronized int A08() {
        int i;
        i = this.A02 - this.A03;
        this.A03 = this.A02;
        if (A0I[2].length() != 8) {
            String[] strArr = A0I;
            strArr[2] = "bxSWiBZCbHOohSqaWh";
            strArr[2] = "bxSWiBZCbHOohSqaWh";
            return i;
        }
        throw new RuntimeException();
    }

    public final synchronized int A09(long j, boolean z, boolean z2) {
        int A002 = A00(this.A03);
        if (!A0J() || j < this.A0F[A002] || (j > this.A07 && !z2)) {
            return -1;
        }
        int A012 = A01(A002, this.A02 - this.A03, j, z);
        if (A012 == -1) {
            return -1;
        }
        this.A03 += A012;
        return A012;
    }

    public final synchronized int A0A(AH ah, C0861Xw xw, boolean z, boolean z2, Format format, FZ fz) {
        if (A0J()) {
            int A002 = A00(this.A03);
            if (z || this.A0G[A002] != format) {
                ah.A00 = this.A0G[A002];
                return -5;
            } else if (xw.A0B()) {
                return -3;
            } else {
                xw.A00 = this.A0F[A002];
                xw.A02(this.A0B[A002]);
                fz.A00 = this.A0C[A002];
                fz.A01 = this.A0E[A002];
                fz.A02 = this.A0H[A002];
                this.A03++;
                return -4;
            }
        } else if (z2) {
            xw.A02(4);
            return -4;
        } else if (this.A08 == null || (!z && this.A08 == format)) {
            return -3;
        } else {
            ah.A00 = this.A08;
            return -5;
        }
    }

    public final synchronized long A0B() {
        if (this.A02 == 0) {
            return -1;
        }
        return A02(this.A02);
    }

    public final synchronized long A0C() {
        return this.A07;
    }

    public final long A0D(int i) {
        boolean z;
        int A072 = A07() - i;
        if (A072 < 0 || A072 > this.A02 - this.A03) {
            z = false;
        } else {
            z = true;
        }
        I1.A03(z);
        this.A02 -= A072;
        this.A07 = Math.max(this.A06, A03(this.A02));
        int i2 = this.A02;
        if (i2 == 0) {
            return 0;
        }
        int A002 = A00(i2 - 1);
        return this.A0E[A002] + ((long) this.A0C[A002]);
    }

    public final synchronized long A0E(long j, boolean z, boolean z2) {
        if (this.A02 != 0) {
            if (j >= this.A0F[this.A04]) {
                int A012 = A01(this.A04, (!z2 || this.A03 == this.A02) ? this.A02 : this.A03 + 1, j, z);
                if (A012 == -1) {
                    return -1;
                }
                return A02(A012);
            }
        }
        return -1;
    }

    public final synchronized Format A0F() {
        return this.A09 ? null : this.A08;
    }

    public final synchronized void A0G() {
        this.A03 = 0;
    }

    /* JADX INFO: Multiple debug info for r13v0 'this'  com.facebook.ads.redexgen.X.Fa: [D('newSizes' int[]), D('relativeEndIndex' int)] */
    public final synchronized void A0H(long j, int i, long j2, int i2, CV cv) {
        if (this.A0A) {
            if ((i & 1) != 0) {
                this.A0A = false;
            } else {
                return;
            }
        }
        I1.A04(!this.A09);
        A05(j);
        int A002 = A00(this.A02);
        this.A0F[A002] = j;
        this.A0E[A002] = j2;
        this.A0C[A002] = i2;
        this.A0B[A002] = i;
        this.A0H[A002] = cv;
        this.A0G[A002] = this.A08;
        this.A0D[A002] = this.A05;
        this.A02++;
        if (this.A02 == this.A01) {
            int i3 = this.A01 + 1000;
            int[] iArr = new int[i3];
            long[] jArr = new long[i3];
            long[] jArr2 = new long[i3];
            int[] iArr2 = new int[i3];
            int[] iArr3 = new int[i3];
            CV[] cvArr = new CV[i3];
            Format[] formatArr = new Format[i3];
            int i4 = this.A01 - this.A04;
            System.arraycopy(this.A0E, this.A04, jArr, 0, i4);
            System.arraycopy(this.A0F, this.A04, jArr2, 0, i4);
            System.arraycopy(this.A0B, this.A04, iArr2, 0, i4);
            System.arraycopy(this.A0C, this.A04, iArr3, 0, i4);
            System.arraycopy(this.A0H, this.A04, cvArr, 0, i4);
            System.arraycopy(this.A0G, this.A04, formatArr, 0, i4);
            System.arraycopy(this.A0D, this.A04, iArr, 0, i4);
            int i5 = this.A04;
            System.arraycopy(this.A0E, 0, jArr, i4, i5);
            System.arraycopy(this.A0F, 0, jArr2, i4, i5);
            System.arraycopy(this.A0B, 0, iArr2, i4, i5);
            System.arraycopy(this.A0C, 0, iArr3, i4, i5);
            System.arraycopy(this.A0H, 0, cvArr, i4, i5);
            System.arraycopy(this.A0G, 0, formatArr, i4, i5);
            System.arraycopy(this.A0D, 0, iArr, i4, i5);
            this.A0E = jArr;
            this.A0F = jArr2;
            this.A0B = iArr2;
            this.A0C = iArr3;
            this.A0H = cvArr;
            this.A0G = formatArr;
            this.A0D = iArr;
            this.A04 = 0;
            this.A02 = this.A01;
            this.A01 = i3;
        }
    }

    public final void A0I(boolean z) {
        this.A02 = 0;
        this.A00 = 0;
        this.A04 = 0;
        this.A03 = 0;
        this.A0A = true;
        this.A06 = Long.MIN_VALUE;
        this.A07 = Long.MIN_VALUE;
        if (z) {
            this.A08 = null;
            this.A09 = true;
        }
    }

    public final synchronized boolean A0J() {
        return this.A03 != this.A02;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0055, code lost:
        if (com.facebook.ads.redexgen.X.C0384Fa.A0I[0].length() == 29) goto L_0x0064;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0057, code lost:
        r2 = com.facebook.ads.redexgen.X.C0384Fa.A0I;
        r2[3] = "Ebt";
        r2[5] = "bsxl34mHntOvTAOjuXwEPt2";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0063, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0069, code lost:
        throw new java.lang.RuntimeException();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized boolean A0K(long r7) {
        /*
        // Method dump skipped, instructions count: 109
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C0384Fa.A0K(long):boolean");
    }

    public final synchronized boolean A0L(Format format) {
        if (format == null) {
            this.A09 = true;
            return false;
        }
        this.A09 = false;
        if (C0466Ig.A0h(format, this.A08)) {
            return false;
        }
        this.A08 = format;
        return true;
    }
}
