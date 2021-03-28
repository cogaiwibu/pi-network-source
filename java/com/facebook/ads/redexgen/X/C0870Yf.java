package com.facebook.ads.redexgen.X;

import android.support.v4.media.session.PlaybackStateCompat;
import com.facebook.ads.internal.exoplayer2.Format;
import com.facebook.ads.internal.exoplayer2.metadata.Metadata;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;

/* renamed from: com.facebook.ads.redexgen.X.Yf  reason: case insensitive filesystem */
public final class C0870Yf implements CK, CT {
    public static byte[] A0J;
    public static String[] A0K;
    public static final CN A0L = new C0869Ye();
    public static final int A0M = C0466Ig.A08(A04(48, 4, 105));
    public int A00;
    public int A01;
    public int A02;
    public int A03;
    public int A04;
    public int A05;
    public int A06;
    public long A07;
    public long A08;
    public CM A09;
    public IQ A0A;
    public boolean A0B;
    public D0[] A0C;
    public long[][] A0D;
    public final int A0E;
    public final IQ A0F;
    public final IQ A0G;
    public final IQ A0H;
    public final ArrayDeque<YX> A0I;

    public static String A04(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A0J, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] ^ i3) ^ 28);
        }
        return new String(copyOfRange);
    }

    public static void A07() {
        A0J = new byte[]{57, 12, 23, 21, 88, 11, 17, 2, 29, 88, 20, 29, 11, 11, 88, 12, 16, 25, 22, 88, 16, 29, 25, 28, 29, 10, 88, 20, 29, 22, 31, 12, 16, 88, 80, 13, 22, 11, 13, 8, 8, 23, 10, 12, 29, 28, 81, 86, 4, 1, 85, 85};
    }

    public static void A08() {
        A0K = new String[]{"0jSfxoXEMfCjtmnyDugkNcQJRjSOySMa", "bnCyjA5DcUmWUqivzOXdDI", "awYt8cnKxKdhDKIItvFTiUYUED9yM0q1", "Luabopmg5NHaS5SoCXeHIbwAQFsLRvJ0", "odfzLqPoxtdmNhQ8QVXSS2", "Wo8IxRBaFRXe4oQbEdt7BomqryNllMGC", "1wQy", "sEQm6Nsu4XqoPKwwi3EdYrJfunZcOKFC"};
    }

    static {
        A08();
        A07();
    }

    public C0870Yf() {
        this(0);
    }

    public C0870Yf(int i) {
        this.A0E = i;
        this.A0F = new IQ(16);
        this.A0I = new ArrayDeque<>();
        this.A0H = new IQ(IM.A03);
        this.A0G = new IQ(4);
        this.A06 = -1;
    }

    /* JADX INFO: Multiple debug info for r5v1 int: [D('preferredAccumulatedBytes' long), D('requiresReload' boolean)] */
    private int A00(long preferredSkipAmount) {
        int i;
        long j = Long.MAX_VALUE;
        int i2 = 1;
        int i3 = -1;
        long j2 = Long.MAX_VALUE;
        long j3 = Long.MAX_VALUE;
        int trackIndex = 1;
        int sampleIndex = -1;
        int i4 = 0;
        while (true) {
            D0[] d0Arr = this.A0C;
            if (i4 >= d0Arr.length) {
                break;
            }
            D0 d0 = d0Arr[i4];
            int i5 = d0.A00;
            if (i5 != d0.A03.A01) {
                long j4 = d0.A03.A06[i5];
                long j5 = this.A0D[i4][i5];
                long j6 = j4 - preferredSkipAmount;
                if (j6 < 0 || j6 >= PlaybackStateCompat.ACTION_SET_REPEAT_MODE) {
                    i = 1;
                } else {
                    i = 0;
                }
                if ((i == 0 && i2 != 0) || (i == i2 && j6 < j)) {
                    i2 = i;
                    j = j6;
                    i3 = i4;
                    j2 = j5;
                }
                if (j5 < j3) {
                    j3 = j5;
                    trackIndex = i;
                    sampleIndex = i4;
                }
            }
            i4++;
        }
        int i6 = (j3 > Long.MAX_VALUE ? 1 : (j3 == Long.MAX_VALUE ? 0 : -1));
        if (A0K[5].charAt(28) != 'l') {
            throw new RuntimeException();
        }
        String[] strArr = A0K;
        strArr[7] = "2rf3IkD44HipF2iEZWYVpECLVHr0uALb";
        strArr[0] = "2zlrhAiZVnIklu1FhIrlCsqVaSaq97eM";
        return (i6 == 0 || trackIndex == 0 || j2 < 10485760 + j3) ? i3 : sampleIndex;
    }

    /* JADX INFO: Multiple debug info for r0v7 long: [D('inputPosition' long), D('skipAmount' long), D('position' long)] */
    private int A01(CL cl, CR cr) throws IOException, InterruptedException {
        int i;
        long A6m = cl.A6m();
        if (this.A06 == -1) {
            this.A06 = A00(A6m);
            if (this.A06 == -1) {
                return -1;
            }
        }
        D0 d0 = this.A0C[this.A06];
        CW cw = d0.A01;
        int i2 = d0.A00;
        long j = d0.A03.A06[i2];
        int i3 = d0.A03.A05[i2];
        long position = (j - A6m) + ((long) this.A04);
        if (position < 0 || position >= PlaybackStateCompat.ACTION_SET_REPEAT_MODE) {
            cr.A00 = j;
            return 1;
        }
        if (d0.A02.A02 == 1) {
            position += 8;
            i3 -= 8;
        }
        cl.ADG((int) position);
        if (d0.A02.A01 != 0) {
            byte[] bArr = this.A0G.A00;
            bArr[0] = 0;
            bArr[1] = 0;
            bArr[2] = 0;
            int i4 = d0.A02.A01;
            int i5 = 4 - d0.A02.A01;
            while (this.A04 < i3) {
                int i6 = this.A05;
                if (i6 == 0) {
                    cl.readFully(this.A0G.A00, i5, i4);
                    this.A0G.A0Z(0);
                    this.A05 = this.A0G.A0I();
                    this.A0H.A0Z(0);
                    cw.ACe(this.A0H, 4);
                    this.A04 += 4;
                    i3 += i5;
                } else {
                    int writtenBytes = cw.ACd(cl, i6, false);
                    this.A04 += writtenBytes;
                    this.A05 -= writtenBytes;
                }
            }
            i = 0;
        } else {
            while (true) {
                int i7 = this.A04;
                if (i7 >= i3) {
                    break;
                }
                int ACd = cw.ACd(cl, i3 - i7, false);
                this.A04 += ACd;
                this.A05 -= ACd;
            }
            i = 0;
        }
        cw.ACf(d0.A03.A07[i2], d0.A03.A04[i2], i3, 0, null);
        d0.A00++;
        this.A06 = -1;
        this.A04 = i;
        this.A05 = i;
        return i;
    }

    public static int A02(D9 d9, long j) {
        int A002 = d9.A00(j);
        if (A002 == -1) {
            return d9.A01(j);
        }
        return A002;
    }

    public static long A03(D9 d9, long j, long j2) {
        int A022 = A02(d9, j);
        if (A022 == -1) {
            return j2;
        }
        return Math.min(d9.A06[A022], j2);
    }

    private ArrayList<D9> A05(YX yx, CO co2, boolean z) throws AN {
        D6 A0C2;
        ArrayList<D9> arrayList = new ArrayList<>();
        int i = 0;
        while (true) {
            int size = yx.A01.size();
            String[] strArr = A0K;
            if (strArr[2].length() != strArr[3].length()) {
                throw new RuntimeException();
            }
            String[] strArr2 = A0K;
            strArr2[7] = "cCqXKTxpaVHnB5xhxhubewm2proDizNi";
            strArr2[0] = "XNMFZPcuybbaYtAFLaJvO7GLnY5oO3YZ";
            if (i >= size) {
                return arrayList;
            }
            YX yx2 = yx.A01.get(i);
            if (((AbstractC0321Cl) yx2).A00 == AbstractC0321Cl.A1L && (A0C2 = C0326Cq.A0C(yx2, yx.A07(AbstractC0321Cl.A0n), -9223372036854775807L, null, z, this.A0B)) != null) {
                D9 A0E2 = C0326Cq.A0E(A0C2, yx2.A06(AbstractC0321Cl.A0d).A06(AbstractC0321Cl.A0h).A06(AbstractC0321Cl.A16), co2);
                if (A0E2.A01 != 0) {
                    arrayList.add(A0E2);
                }
            }
            i++;
        }
    }

    private void A06() {
        this.A03 = 0;
        this.A00 = 0;
    }

    private void A09(long j) throws AN {
        while (!this.A0I.isEmpty() && this.A0I.peek().A00 == j) {
            YX pop = this.A0I.pop();
            if (((AbstractC0321Cl) pop).A00 == AbstractC0321Cl.A0j) {
                A0B(pop);
                this.A0I.clear();
                this.A03 = 2;
            } else if (!this.A0I.isEmpty()) {
                this.A0I.peek().A08(pop);
            }
        }
        if (this.A03 != 2) {
            A06();
        }
    }

    private void A0A(long j) {
        D0[] d0Arr = this.A0C;
        for (D0 d0 : d0Arr) {
            D9 d9 = d0.A03;
            int A002 = d9.A00(j);
            if (A002 == -1) {
                A002 = d9.A01(j);
            }
            d0.A00 = A002;
        }
    }

    /* JADX INFO: Multiple debug info for r1v4 com.facebook.ads.internal.exoplayer2.Format: [D('trackCount' int), D('maxInputSize' int)] */
    private void A0B(YX yx) throws AN {
        ArrayList<D9> arrayList;
        long j;
        int i = -1;
        long j2 = -9223372036854775807L;
        ArrayList arrayList2 = new ArrayList();
        Metadata metadata = null;
        CO co2 = new CO();
        YY A072 = yx.A07(AbstractC0321Cl.A1P);
        if (!(A072 == null || (metadata = C0326Cq.A0F(A072, this.A0B)) == null)) {
            co2.A06(metadata);
        }
        try {
            arrayList = A05(yx, co2, (this.A0E & 1) != 0);
        } catch (C0866Yb unused) {
            co2 = new CO();
            arrayList = A05(yx, co2, true);
        }
        int size = arrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            D9 d9 = arrayList.get(i2);
            D6 d6 = d9.A03;
            D0 d0 = new D0(d6, d9, this.A09.ADY(i2, d6.A03));
            Format A0G2 = d6.A07.A0G(d9.A00 + 30);
            if (d6.A03 == 1) {
                if (co2.A04()) {
                    A0G2 = A0G2.A0H(co2.A00, co2.A01);
                }
                if (metadata != null) {
                    A0G2 = A0G2.A0K(metadata);
                }
            }
            d0.A01.A5A(A0G2);
            if (d6.A04 != -9223372036854775807L) {
                j = d6.A04;
            } else {
                j = d9.A02;
            }
            j2 = Math.max(j2, j);
            if (d6.A03 == 2 && i == -1) {
                i = arrayList2.size();
            }
            arrayList2.add(d0);
        }
        this.A02 = i;
        this.A08 = j2;
        this.A0C = (D0[]) arrayList2.toArray(new D0[arrayList2.size()]);
        this.A0D = A0H(this.A0C);
        this.A09.A4w();
        this.A09.ACk(this);
    }

    public static boolean A0C(int i) {
        if (i != AbstractC0321Cl.A0j) {
            int i2 = AbstractC0321Cl.A1L;
            String[] strArr = A0K;
            if (strArr[4].length() != strArr[6].length()) {
                String[] strArr2 = A0K;
                strArr2[2] = "xHWkCkmm9lwx55Xb6ilKRbCBaMi3tx91";
                strArr2[3] = "ufwmFaOIh4ETn2yFiF4b2v05oMaexVS8";
                return i == i2 || i == AbstractC0321Cl.A0d || i == AbstractC0321Cl.A0h || i == AbstractC0321Cl.A16 || i == AbstractC0321Cl.A0N;
            }
            throw new RuntimeException();
        }
    }

    public static boolean A0D(int i) {
        if (!(i == AbstractC0321Cl.A0c || i == AbstractC0321Cl.A0n || i == AbstractC0321Cl.A0V || i == AbstractC0321Cl.A1A || i == AbstractC0321Cl.A1D || i == AbstractC0321Cl.A1B)) {
            int i2 = AbstractC0321Cl.A0C;
            if (A0K[1].length() != 22) {
                throw new RuntimeException();
            }
            String[] strArr = A0K;
            strArr[1] = "WjfYMB7jPbcUwDvfNOpuH1";
            strArr[1] = "WjfYMB7jPbcUwDvfNOpuH1";
            return i == i2 || i == AbstractC0321Cl.A0O || i == AbstractC0321Cl.A19 || i == AbstractC0321Cl.A1C || i == AbstractC0321Cl.A1E || i == AbstractC0321Cl.A17 || i == AbstractC0321Cl.A0B || i == AbstractC0321Cl.A1J || i == AbstractC0321Cl.A0U || i == AbstractC0321Cl.A1P;
        }
    }

    /* JADX INFO: Multiple debug info for r9v0 'this'  com.facebook.ads.redexgen.X.Yf: [D('headerBytesRemaining' int), D('endPosition' long)] */
    private boolean A0E(CL cl) throws IOException, InterruptedException {
        boolean z;
        boolean z2;
        if (this.A00 == 0) {
            if (!cl.AC2(this.A0F.A00, 0, 8, true)) {
                return false;
            }
            this.A00 = 8;
            this.A0F.A0Z(0);
            this.A07 = this.A0F.A0N();
            this.A01 = this.A0F.A09();
        }
        long j = this.A07;
        if (j == 1) {
            cl.readFully(this.A0F.A00, 8, 8);
            this.A00 += 8;
            this.A07 = this.A0F.A0O();
        } else if (j == 0) {
            long A6T = cl.A6T();
            if (A6T == -1 && !this.A0I.isEmpty()) {
                A6T = this.A0I.peek().A00;
            }
            if (A6T != -1) {
                this.A07 = (A6T - cl.A6m()) + ((long) this.A00);
            }
        }
        if (this.A07 >= ((long) this.A00)) {
            if (A0C(this.A01)) {
                long A6m = (cl.A6m() + this.A07) - ((long) this.A00);
                this.A0I.push(new YX(this.A01, A6m));
                if (this.A07 == ((long) this.A00)) {
                    A09(A6m);
                } else {
                    A06();
                }
            } else if (A0D(this.A01)) {
                if (this.A00 == 8) {
                    z = true;
                } else {
                    z = false;
                }
                I1.A04(z);
                if (this.A07 <= 2147483647L) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                I1.A04(z2);
                this.A0A = new IQ((int) this.A07);
                System.arraycopy(this.A0F.A00, 0, this.A0A.A00, 0, 8);
                this.A03 = 1;
            } else {
                this.A0A = null;
                this.A03 = 1;
            }
            return true;
        }
        throw new AN(A04(0, 48, 100));
    }

    private boolean A0F(CL cl, CR cr) throws IOException, InterruptedException {
        long j = this.A07 - ((long) this.A00);
        long A6m = cl.A6m() + j;
        boolean z = false;
        IQ iq = this.A0A;
        if (iq != null) {
            cl.readFully(iq.A00, this.A00, (int) j);
            if (this.A01 == AbstractC0321Cl.A0U) {
                this.A0B = A0G(this.A0A);
            } else if (!this.A0I.isEmpty()) {
                this.A0I.peek().A09(new YY(this.A01, this.A0A));
            }
        } else if (j < PlaybackStateCompat.ACTION_SET_REPEAT_MODE) {
            cl.ADG((int) j);
        } else {
            cr.A00 = cl.A6m() + j;
            z = true;
        }
        A09(A6m);
        return z && this.A03 != 2;
    }

    public static boolean A0G(IQ iq) {
        iq.A0Z(8);
        if (iq.A09() == A0M) {
            return true;
        }
        iq.A0a(4);
        while (iq.A05() > 0) {
            if (iq.A09() == A0M) {
                return true;
            }
        }
        return false;
    }

    public static long[][] A0H(D0[] d0Arr) {
        long[][] jArr = new long[d0Arr.length][];
        int[] iArr = new int[d0Arr.length];
        long[] jArr2 = new long[d0Arr.length];
        boolean[] zArr = new boolean[d0Arr.length];
        for (int i = 0; i < d0Arr.length; i++) {
            jArr[i] = new long[d0Arr[i].A03.A01];
            jArr2[i] = d0Arr[i].A03.A07[0];
        }
        long j = 0;
        int minTimeTrackIndex = 0;
        while (minTimeTrackIndex < d0Arr.length) {
            long j2 = Long.MAX_VALUE;
            int i2 = -1;
            for (int i3 = 0; i3 < d0Arr.length; i3++) {
                if (!zArr[i3] && jArr2[i3] <= j2) {
                    i2 = i3;
                    j2 = jArr2[i3];
                }
            }
            int i4 = iArr[i2];
            jArr[i2][i4] = j;
            j += (long) d0Arr[i2].A03.A05[i4];
            int i5 = i4 + 1;
            iArr[i2] = i5;
            if (i5 < jArr[i2].length) {
                jArr2[i2] = d0Arr[i2].A03.A07[i5];
            } else {
                zArr[i2] = true;
                minTimeTrackIndex++;
            }
        }
        return jArr;
    }

    @Override // com.facebook.ads.redexgen.X.CT
    public final long A65() {
        return this.A08;
    }

    @Override // com.facebook.ads.redexgen.X.CT
    public final CS A6s(long secondTimeUs) {
        long j;
        long j2;
        int A012;
        D0[] d0Arr = this.A0C;
        if (d0Arr.length == 0) {
            return new CS(CU.A04);
        }
        long j3 = -9223372036854775807L;
        long j4 = -1;
        int i = this.A02;
        if (i != -1) {
            D9 d9 = d0Arr[i].A03;
            int A022 = A02(d9, secondTimeUs);
            if (A022 == -1) {
                return new CS(CU.A04);
            }
            j2 = d9.A07[A022];
            j = d9.A06[A022];
            if (j2 < secondTimeUs) {
                int i2 = d9.A01 - 1;
                if (A0K[5].charAt(28) == 'l') {
                    String[] strArr = A0K;
                    strArr[4] = "wZC6PUUkwbL39FGS7qgHi4";
                    strArr[6] = "ISWp";
                    if (!(A022 >= i2 || (A012 = d9.A01(secondTimeUs)) == -1 || A012 == A022)) {
                        j3 = d9.A07[A012];
                        j4 = d9.A06[A012];
                    }
                }
                throw new RuntimeException();
            }
        } else {
            j2 = secondTimeUs;
            j = Long.MAX_VALUE;
        }
        int i3 = 0;
        while (true) {
            D0[] d0Arr2 = this.A0C;
            if (A0K[5].charAt(28) != 'l') {
                break;
            }
            String[] strArr2 = A0K;
            strArr2[2] = "HuKpkwhwNffVsg1qOYm34WvQGcpzf7CA";
            strArr2[3] = "OpSxQ7AB5KpfVVm82hohcPrOWAs1xSas";
            if (i3 < d0Arr2.length) {
                if (i3 != this.A02) {
                    D9 d92 = d0Arr2[i3].A03;
                    j = A03(d92, j2, j);
                    if (j3 != -9223372036854775807L) {
                        j4 = A03(d92, j3, j4);
                    }
                }
                i3++;
            } else {
                CU cu = new CU(j2, j);
                if (j3 == -9223372036854775807L) {
                    return new CS(cu);
                }
                return new CS(cu, new CU(j3, j4));
            }
        }
        throw new RuntimeException();
    }

    @Override // com.facebook.ads.redexgen.X.CK
    public final void A7Q(CM cm) {
        this.A09 = cm;
    }

    @Override // com.facebook.ads.redexgen.X.CT
    public final boolean A7m() {
        return true;
    }

    @Override // com.facebook.ads.redexgen.X.CK
    public final int ABx(CL cl, CR cr) throws IOException, InterruptedException {
        while (true) {
            int i = this.A03;
            String[] strArr = A0K;
            if (strArr[2].length() != strArr[3].length()) {
                throw new RuntimeException();
            }
            String[] strArr2 = A0K;
            strArr2[7] = "qJxbwGisfZf9YKIw0pjhTsx78598m8MK";
            strArr2[0] = "kX2rligkfJBBB9teOSCW5LaSmFhGBJWo";
            if (i != 0) {
                if (i != 1) {
                    if (i == 2) {
                        return A01(cl, cr);
                    }
                    throw new IllegalStateException();
                } else if (A0F(cl, cr)) {
                    return 1;
                }
            } else if (!A0E(cl)) {
                return -1;
            }
        }
    }

    @Override // com.facebook.ads.redexgen.X.CK
    public final void ACj(long j, long j2) {
        this.A0I.clear();
        this.A00 = 0;
        this.A06 = -1;
        this.A04 = 0;
        this.A05 = 0;
        if (j == 0) {
            A06();
        } else if (this.A0C != null) {
            A0A(j2);
        }
    }

    @Override // com.facebook.ads.redexgen.X.CK
    public final boolean ADH(CL cl) throws IOException, InterruptedException {
        return D4.A05(cl);
    }
}
