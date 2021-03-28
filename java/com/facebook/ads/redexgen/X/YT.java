package com.facebook.ads.redexgen.X;

import android.util.SparseArray;
import com.facebook.ads.internal.exoplayer2.drm.DrmInitData;
import com.facebook.imageutils.JfifUtil;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.tapjoy.TapjoyConstants;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Locale;
import java.util.UUID;
import kotlin.jvm.internal.ByteCompanionObject;

public final class YT implements CK {
    public static byte[] A0p;
    public static String[] A0q;
    public static final CN A0r = new YR();
    public static final UUID A0s = new UUID(72057594037932032L, -9223371306706625679L);
    public static final byte[] A0t = C0466Ig.A0j(A03(539, 90, 21));
    public static final byte[] A0u = {68, 105, 97, 108, 111, 103, 117, 101, 58, 32, 48, 58, 48, 48, 58, 48, 48, 58, 48, 48, 44, 48, 58, 48, 48, 58, 48, 48, 58, 48, 48, 44};
    public static final byte[] A0v = {32, 32, 32, 32, 32, 32, 32, 32, 32, 32};
    public static final byte[] A0w = {49, 10, 48, 48, 58, 48, 48, 58, 48, 48, 44, 48, 48, 48, 32, 45, 45, 62, 32, 48, 48, 58, 48, 48, 58, 48, 48, 44, 48, 48, 48, 10};
    public static final byte[] A0x = {32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32};
    public byte A00;
    public int A01;
    public int A02;
    public int A03;
    public int A04;
    public int A05;
    public int A06;
    public int A07;
    public int A08;
    public int A09;
    public int A0A;
    public int A0B;
    public long A0C;
    public long A0D;
    public long A0E;
    public long A0F;
    public long A0G;
    public long A0H;
    public long A0I;
    public long A0J;
    public long A0K;
    public long A0L;
    public long A0M;
    public CM A0N;
    public C0316Cg A0O;
    public IG A0P;
    public IG A0Q;
    public ByteBuffer A0R;
    public boolean A0S;
    public boolean A0T;
    public boolean A0U;
    public boolean A0V;
    public boolean A0W;
    public boolean A0X;
    public boolean A0Y;
    public boolean A0Z;
    public boolean A0a;
    public int[] A0b;
    public final SparseArray<C0316Cg> A0c;
    public final AbstractC0312Cc A0d;
    public final C0319Cj A0e;
    public final IQ A0f;
    public final IQ A0g;
    public final IQ A0h;
    public final IQ A0i;
    public final IQ A0j;
    public final IQ A0k;
    public final IQ A0l;
    public final IQ A0m;
    public final IQ A0n;
    public final boolean A0o;

    public static String A03(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A0p, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] ^ i3) ^ 58);
        }
        return new String(copyOfRange);
    }

    public static void A06() {
        A0p = new byte[]{34, 108, 109, 118, 34, 113, 119, 114, 114, 109, 112, 118, 103, 102, 104, 125, 124, 41, 119, 104, 125, ByteCompanionObject.MAX_VALUE, 41, 119, 104, 125, ByteCompanionObject.MAX_VALUE, 41, 119, 104, 125, ByteCompanionObject.MAX_VALUE, 41, 84, 65, 67, 21, 75, 84, 65, 67, 21, 75, 84, 65, 67, 21, 93, 84, 65, 66, 21, 86, 82, 68, 68, 114, 99, 99, 126, 121, 112, 100, 84, 126, 103, ByteCompanionObject.MAX_VALUE, 114, 101, 90, 120, 115, 114, 55, 25, 7, 25, 25, 27, 55, 41, 55, 53, 69, 57, 39, 60, 44, 43, 73, 87, 76, 92, 91, 39, 77, 80, 88, 90, 77, 91, 91, 111, 113, 106, 122, 125, 1, 98, 97, 125, 125, 98, 107, 125, 125, 28, 2, 24, 28, 30, 110, 9, 23, 14, 4, 9, 11, 58, 36, 54, 43, 62, 60, 84, 55, 73, 80, 78, 92, 65, 84, 86, 62, 93, 34, 8, 22, 4, 26, 102, 8, 10, 4, 27, 5, 21, 10, 15, 9, 37, 59, 52, 39, 41, 75, 45, 42, 48, 75, 40, 45, 48, 6, 24, 19, 21, 18, 2, 15, 3, 74, 84, 93, 68, 89, 73, 66, 88, 88, 122, 117, 60, 111, 59, 104, 120, 122, 119, 126, 59, 111, 114, 118, 126, 120, 116, ByteCompanionObject.MAX_VALUE, 126, 59, 107, 105, 114, 116, 105, 59, 111, 116, 59, 111, 114, 118, 126, 120, 116, ByteCompanionObject.MAX_VALUE, 126, 72, 120, 122, 119, 126, 59, 121, 126, 114, 117, 124, 59, 104, 126, 111, 53, 34, 14, 12, 3, 8, 15, 8, 15, 6, 65, 4, 15, 2, 19, 24, 17, 21, 8, 14, 15, 65, 0, 15, 5, 65, 2, 14, 12, 17, 19, 4, 18, 18, 8, 14, 15, 65, 8, 18, 65, 15, 14, 21, 65, 18, 20, 17, 17, 14, 19, 21, 4, 5, 9, 37, 36, 62, 47, 36, 62, 9, 37, 39, 58, 11, 38, 45, 37, 106, 99, 79, 78, 84, 69, 78, 84, 101, 78, 67, 97, 76, 71, 79, 0, 79, 99, 98, 120, 105, 98, 120, 73, 98, 111, 99, 104, 101, 98, 107, 67, 126, 104, 105, 126, 44, 75, 103, 102, 124, 109, 102, 124, 77, 102, 107, 103, 108, 97, 102, 111, 91, 107, 103, 120, 109, 40, 40, 3, 15, 56, 21, 28, 9, 76, 1, 42, 38, 17, 60, 53, 32, 23, 32, 36, 33, 19, 32, 55, 54, 44, 42, 43, 101, 16, 23, 24, 25, 117, 57, 52, 54, 60, 59, 50, 117, 38, 52, 56, 37, 57, 48, 117, 38, 60, 47, 48, 117, 58, 32, 33, 117, 58, 51, 117, 39, 52, 59, 50, 48, 123, 74, 77, 66, 67, 93, 106, 110, 107, 89, 106, 125, 124, 102, 96, 97, 47, 61, 22, 27, 10, 1, 8, 12, 29, 28, 88, 44, 10, 25, 27, 19, 88, 30, 23, 13, 22, 28, 88, 26, 13, 12, 88, 59, 23, 22, 12, 29, 22, 12, 61, 22, 27, 51, 29, 1, 49, 60, 88, 15, 25, 11, 88, 22, 23, 12, 88, 30, 23, 13, 22, 28, 95, 98, 110, ByteCompanionObject.MAX_VALUE, 116, 105, 115, 117, 116, 58, 120, 115, 110, 58, 115, 105, 58, 105, ByteCompanionObject.MAX_VALUE, 110, 58, 115, 116, 58, 105, 115, 125, 116, 123, 118, 58, 120, 99, 110, ByteCompanionObject.MAX_VALUE, 105, 64, 93, 66, 78, 91, 21, 15, 124, 91, 78, 93, 91, 3, 15, 106, 65, 75, 3, 15, 125, 74, 78, 75, 96, 93, 75, 74, 93, 3, 15, 99, 78, 86, 74, 93, 3, 15, 124, 91, 86, 67, 74, 3, 15, 97, 78, 66, 74, 3, 15, 98, 78, 93, 72, 70, 65, 99, 3, 15, 98, 78, 93, 72, 70, 65, 125, 3, 15, 98, 78, 93, 72, 70, 65, 121, 3, 15, 106, 73, 73, 74, 76, 91, 3, 15, 123, 74, 87, 91, 48, 29, 31, 21, 18, 27, 92, 19, 18, 16, 5, 92, 15, 9, 12, 12, 19, 14, 8, 25, 24, 92, 21, 18, 92, 47, 21, 17, 12, 16, 25, 62, 16, 19, 31, 23, 15, 82, 31, 51, 60, 54, 51, 38, 61, 32, 43, 114, 55, 62, 55, 63, 55, 60, 38, 114, 1, 55, 55, 57, 27, 22, 114, 61, 32, 114, 1, 55, 55, 57, 2, 61, 33, 59, 38, 59, 61, 60, 114, 60, 61, 38, 114, 52, 61, 39, 60, 54, 122, 66, 91, 67, 94, 71, 91, 82, 23, 100, 82, 80, 90, 82, 89, 67, 23, 82, 91, 82, 90, 82, 89, 67, 68, 23, 89, 88, 67, 23, 68, 66, 71, 71, 88, 69, 67, 82, 83, 54, 23, 88, 14, 25, 20, 17, 28, 88, 12, 10, 25, 27, 19, 11, 88, 15, 29, 10, 29, 88, 30, 23, 13, 22, 28, 68, 101, 42, 124, 107, 102, 99, 110, 42, 124, 107, 120, 99, 100, 126, 42, 102, 111, 100, 109, 126, 98, 42, 103, 107, 121, 97, 42, 108, 101, ByteCompanionObject.MAX_VALUE, 100, 110, 96, 108, 119, 101, 113, 96, 102, 113, 43, 39, 48, 60, 53, 46, 87, 40, 63, 43, 68, 72, 67, 82, 79, 67, 56, 86, 68, 68, 81, 93, 86, 71, 90, 86, 45, 87, 86, 68, 58, 69, 73, 64, 89, 84, 69, 67, 84, 51, 8, 3, 30, 22, 3, 5, 18, 3, 2, 70, 15, 2, 92, 70, 24, 35, 40, 53, 61, 40, 46, 57, 40, 41, 109, 33, 44, 46, 36, 35, 42, 109, 59, 44, 33, 56, 40, 119, 109, 60, 53, 39, 58, 47, 45, 88, 5, 12, 30, 3, 22, 20, 103, 124, 26, 0, 28, 124, 18, 3, 75, 66, 80, 77, 88, 90, 41, 50, 84, 78, 82, 50, 92, 78, 77, 44, 37, 55, 42, 63, 61, 78, 85, 51, 41, 53, 85, 59, 44, 57, 86, 95, 77, 80, 69, 71, 52, 47, 73, 83, 79, 47, 83, 80, 6, 15, 29, 0, 21, 23, 24, ByteCompanionObject.MAX_VALUE, 25, 3, 31, ByteCompanionObject.MAX_VALUE, 24, 21, 6, 19, 53, 60, 46, 48, 76, 53, 37, 52, 76, 37, 44, 54, 49, 32, 32, 97, 104, 99, ByteCompanionObject.MAX_VALUE, 114, 120, 101, 118, 68, 77, 68, 66, 42, 12, 5, 12, 10, 99, 113, 125, 104, 110, 115, 111, 119, 125, 116, 107, 102, 103, 109, 45, 117, 103, 96, 111, 63, 45, 42, 37};
    }

    public static void A07() {
        A0q = new String[]{"PtjeSixlQpPnp33LbTolurfrF5aBxWMN", "zsPWFAYo6WN4WLRLivc6JVSph6JkIRth", "XheyHWRN6othIFLpaes4AkwCM0c9DMBL", "WLz3vbqVAvFNW8GJMAEq6yPWbMM9CaUw", "Xodlb2gLYburpvZCOlf7Ugos4D", "3NxGJ5nCydCtg30cLxHhJHXlDiPWCbyN", "QrznFntGQRtbXA7cSaAHWbiKbufqFBbd", "iW7nVRcCTDgQKTtcLRaOezFHTOIda"};
    }

    static {
        A07();
        A06();
    }

    public YT() {
        this(0);
    }

    public YT(int i) {
        this(new YQ(), i);
    }

    public YT(AbstractC0312Cc cc, int i) {
        boolean z;
        this.A0K = -1;
        this.A0M = -9223372036854775807L;
        this.A0G = -9223372036854775807L;
        this.A0H = -9223372036854775807L;
        this.A0F = -1;
        this.A0J = -1;
        this.A0E = -9223372036854775807L;
        this.A0d = cc;
        this.A0d.A7R(new YS(this, null));
        if ((i & 1) == 0) {
            z = true;
        } else {
            z = false;
        }
        this.A0o = z;
        this.A0e = new C0319Cj();
        this.A0c = new SparseArray<>();
        this.A0k = new IQ(4);
        this.A0n = new IQ(ByteBuffer.allocate(4).putInt(-1).array());
        this.A0l = new IQ(4);
        this.A0i = new IQ(IM.A03);
        this.A0h = new IQ(4);
        this.A0j = new IQ();
        this.A0m = new IQ();
        this.A0f = new IQ(8);
        this.A0g = new IQ();
    }

    private int A00(CL cl, CW cw, int i) throws IOException, InterruptedException {
        int ACd;
        int A052 = this.A0j.A05();
        if (A052 > 0) {
            ACd = Math.min(i, A052);
            if (A0q[7].length() != 22) {
                String[] strArr = A0q;
                strArr[2] = "aDvj6xsBYLtfkWvKOvjAJhuXcdkZRgYf";
                strArr[6] = "uG0ceA84GetZ2PjOc8Op6VIqDQh3bhN9";
                cw.ACe(this.A0j, ACd);
            } else {
                throw new RuntimeException();
            }
        } else {
            ACd = cw.ACd(cl, i, false);
        }
        this.A07 += ACd;
        this.A08 += ACd;
        return ACd;
    }

    private long A01(long j) throws AN {
        long j2 = this.A0M;
        if (j2 != -9223372036854775807L) {
            return C0466Ig.A0F(j, j2, 1000);
        }
        throw new AN(A03(189, 54, 33));
    }

    private CT A02() {
        IG ig;
        IG ig2;
        if (this.A0K == -1 || this.A0H == -9223372036854775807L || (ig = this.A0Q) == null || ig.A02() == 0 || (ig2 = this.A0P) == null || ig2.A02() != this.A0Q.A02()) {
            this.A0Q = null;
            this.A0P = null;
            return new YH(this.A0H);
        }
        int A022 = this.A0Q.A02();
        int[] iArr = new int[A022];
        long[] jArr = new long[A022];
        long[] timesUs = new long[A022];
        long[] jArr2 = new long[A022];
        for (int i = 0; i < A022; i++) {
            jArr2[i] = this.A0Q.A03(i);
            jArr[i] = this.A0K + this.A0P.A03(i);
        }
        for (int i2 = 0; i2 < A022 - 1; i2++) {
            iArr[i2] = (int) (jArr[i2 + 1] - jArr[i2]);
            timesUs[i2] = jArr2[i2 + 1] - jArr2[i2];
        }
        iArr[A022 - 1] = (int) ((this.A0K + this.A0L) - jArr[A022 - 1]);
        timesUs[A022 - 1] = this.A0H - jArr2[A022 - 1];
        this.A0Q = null;
        this.A0P = null;
        return new YC(iArr, jArr, timesUs, jArr2);
    }

    private void A05() {
        this.A07 = 0;
        this.A08 = 0;
        this.A09 = 0;
        this.A0S = false;
        this.A0X = false;
        this.A0U = false;
        this.A0A = 0;
        this.A00 = 0;
        this.A0T = false;
        this.A0j.A0W();
    }

    private void A08(CL cl, int i) throws IOException, InterruptedException {
        if (this.A0k.A08() < i) {
            if (this.A0k.A06() < i) {
                IQ iq = this.A0k;
                iq.A0c(Arrays.copyOf(iq.A00, Math.max(this.A0k.A00.length * 2, i)), this.A0k.A08());
            }
            cl.readFully(this.A0k.A00, this.A0k.A08(), i - this.A0k.A08());
            this.A0k.A0Y(i);
        }
    }

    /* JADX INFO: Multiple debug info for r11v0 com.facebook.ads.redexgen.X.CL: [D('nalLengthData' byte[]), D('isEncrypted' boolean)] */
    /* JADX WARNING: Removed duplicated region for block: B:102:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x028c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void A09(com.facebook.ads.redexgen.X.CL r11, com.facebook.ads.redexgen.X.C0316Cg r12, int r13) throws java.io.IOException, java.lang.InterruptedException {
        /*
        // Method dump skipped, instructions count: 670
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.YT.A09(com.facebook.ads.redexgen.X.CL, com.facebook.ads.redexgen.X.Cg, int):void");
    }

    private void A0A(CL cl, byte[] bArr, int i) throws IOException, InterruptedException {
        int length = bArr.length + i;
        if (this.A0m.A06() < length) {
            this.A0m.A00 = Arrays.copyOf(bArr, length + i);
        } else {
            System.arraycopy(bArr, 0, this.A0m.A00, 0, bArr.length);
        }
        cl.readFully(this.A0m.A00, bArr.length, i);
        this.A0m.A0X(length);
    }

    private void A0B(CL cl, byte[] bArr, int i, int i2) throws IOException, InterruptedException {
        int min = Math.min(i2, this.A0j.A05());
        cl.readFully(bArr, i + min, i2 - min);
        if (min > 0) {
            this.A0j.A0d(bArr, i, min);
        }
        this.A07 += i2;
    }

    private void A0C(C0316Cg cg, long j) {
        if (cg.A0X != null) {
            cg.A0X.A03(cg, j);
        } else {
            if (A03(843, 11, 56).equals(cg.A0Y)) {
                A0D(cg, A03(33, 19, 75), 19, 1000, A0x);
            } else {
                if (A03(833, 10, 45).equals(cg.A0Y)) {
                    A0D(cg, A03(14, 19, 119), 21, TapjoyConstants.TIMER_INCREMENT, A0v);
                }
            }
            cg.A0W.ACf(j, this.A01, this.A08, 0, cg.A0V);
        }
        this.A0V = true;
        A05();
    }

    private void A0D(C0316Cg cg, String str, int i, long j, byte[] bArr) {
        A0E(this.A0m.A00, this.A0C, str, i, j, bArr);
        CW cw = cg.A0W;
        IQ iq = this.A0m;
        cw.ACe(iq, iq.A08());
        this.A08 += this.A0m.A08();
    }

    public static void A0E(byte[] bArr, long j, String str, int i, long j2, byte[] bArr2) {
        byte[] A0j2;
        if (j == -9223372036854775807L) {
            A0j2 = bArr2;
        } else {
            int i2 = (int) (j / 3600000000L);
            long j3 = j - (((long) (i2 * 3600)) * 1000000);
            int i3 = (int) (j3 / 60000000);
            long j4 = j3 - (((long) (i3 * 60)) * 1000000);
            int lastValue = (int) (j4 / 1000000);
            A0j2 = C0466Ig.A0j(String.format(Locale.US, str, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(lastValue), Integer.valueOf((int) ((j4 - (((long) lastValue) * 1000000)) / j2))));
        }
        System.arraycopy(A0j2, 0, bArr, i, bArr2.length);
    }

    private boolean A0F(CR cr, long j) {
        if (this.A0Y) {
            this.A0J = j;
            cr.A00 = this.A0F;
            this.A0Y = false;
            return true;
        }
        if (this.A0a) {
            long j2 = this.A0J;
            if (j2 != -1) {
                cr.A00 = j2;
                this.A0J = -1;
                return true;
            }
        }
        return false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:49:0x0199, code lost:
        if (r3.equals(r4) == false) goto L_0x019b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x022e, code lost:
        if (r3.equals(r4) == false) goto L_0x019b;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean A0G(java.lang.String r4) {
        /*
        // Method dump skipped, instructions count: 562
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.YT.A0G(java.lang.String):boolean");
    }

    public static int[] A0I(int[] iArr, int i) {
        if (iArr == null) {
            return new int[i];
        }
        if (iArr.length >= i) {
            return iArr;
        }
        return new int[Math.max(iArr.length * 2, i)];
    }

    public final void A0J(int i) throws AN {
        if (i != 160) {
            if (A0q[3].charAt(28) == 'C') {
                String[] strArr = A0q;
                strArr[2] = "rbl1Q01lKztgjfT5AU1HA1uCy8pKF6Jb";
                strArr[6] = "0IgewP00Z0tSvfgvmyCD0no1Nhaiy8Yj";
                if (i == 174) {
                    if (A0G(this.A0O.A0Y)) {
                        C0316Cg cg = this.A0O;
                        cg.A0A(this.A0N, cg.A0N);
                        this.A0c.put(this.A0O.A0N, this.A0O);
                    }
                    this.A0O = null;
                    return;
                } else if (i == 19899) {
                    int i2 = this.A0B;
                    if (i2 != -1) {
                        long j = this.A0I;
                        if (j != -1) {
                            if (i2 == 475249515) {
                                this.A0F = j;
                                return;
                            }
                            return;
                        }
                    }
                    throw new AN(A03(667, 50, 104));
                } else if (i != 25152) {
                    if (A0q[7].length() != 22) {
                        String[] strArr2 = A0q;
                        strArr2[4] = "mvRw2Aey0bC26pGUqGZgnnTCCn";
                        strArr2[4] = "mvRw2Aey0bC26pGUqGZgnnTCCn";
                        if (i != 28032) {
                            if (i == 357149030) {
                                if (this.A0M == -9223372036854775807L) {
                                    this.A0M = 1000000;
                                }
                                long j2 = this.A0G;
                                if (j2 != -9223372036854775807L) {
                                    this.A0H = A01(j2);
                                    return;
                                }
                                return;
                            } else if (i != 374648427) {
                                if (i == 475249515 && !this.A0a) {
                                    this.A0N.ACk(A02());
                                    this.A0a = true;
                                    return;
                                }
                                return;
                            } else if (this.A0c.size() != 0) {
                                this.A0N.A4w();
                                return;
                            } else {
                                throw new AN(A03(756, 26, 66));
                            }
                        } else if (this.A0O.A0c && this.A0O.A0f != null) {
                            throw new AN(A03(243, 53, 91));
                        } else {
                            return;
                        }
                    }
                } else if (!this.A0O.A0c) {
                    return;
                } else {
                    if (this.A0O.A0V != null) {
                        this.A0O.A0U = new DrmInitData(new DrmInitData.SchemeData(C02669y.A04, A03(1024, 10, 56), this.A0O.A0V.A03));
                        return;
                    }
                    throw new AN(A03(449, 55, 66));
                }
            }
            throw new RuntimeException();
        } else if (this.A04 == 2) {
            if (!this.A0W) {
                this.A01 |= 1;
            }
            A0C(this.A0c.get(this.A05), this.A0D);
            this.A04 = 0;
        }
    }

    public final void A0K(int i, double d) {
        if (i == 181) {
            this.A0O.A0O = (int) d;
        } else if (i != 17545) {
            switch (i) {
                case 21969:
                    this.A0O.A06 = (float) d;
                    return;
                case 21970:
                    this.A0O.A07 = (float) d;
                    return;
                case 21971:
                    this.A0O.A04 = (float) d;
                    return;
                case 21972:
                    this.A0O.A05 = (float) d;
                    return;
                case 21973:
                    this.A0O.A02 = (float) d;
                    return;
                case 21974:
                    this.A0O.A03 = (float) d;
                    return;
                case 21975:
                    this.A0O.A08 = (float) d;
                    return;
                case 21976:
                    this.A0O.A09 = (float) d;
                    return;
                case 21977:
                    this.A0O.A00 = (float) d;
                    return;
                case 21978:
                    this.A0O.A01 = (float) d;
                    return;
                default:
                    return;
            }
        } else {
            this.A0G = (long) d;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:37:0x0144, code lost:
        if (r6 == 8) goto L_0x0146;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x01d2, code lost:
        if (r6 == 8) goto L_0x0146;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x01d6, code lost:
        r2 = 0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void A0L(int r19, int r20, com.facebook.ads.redexgen.X.CL r21) throws java.io.IOException, java.lang.InterruptedException {
        /*
        // Method dump skipped, instructions count: 941
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.YT.A0L(int, int, com.facebook.ads.redexgen.X.CL):void");
    }

    public final void A0M(int i, long j) throws AN {
        String A032 = A03(0, 14, 56);
        if (i != 20529) {
            if (i != 20530) {
                boolean z = false;
                switch (i) {
                    case 131:
                        this.A0O.A0Q = (int) j;
                        return;
                    case 136:
                        C0316Cg cg = this.A0O;
                        if (j == 1) {
                            z = true;
                        }
                        cg.A0Z = z;
                        return;
                    case 155:
                        this.A0C = A01(j);
                        return;
                    case 159:
                        this.A0O.A0B = (int) j;
                        return;
                    case 176:
                        this.A0O.A0R = (int) j;
                        return;
                    case 179:
                        this.A0Q.A04(A01(j));
                        return;
                    case 186:
                        this.A0O.A0J = (int) j;
                        return;
                    case JfifUtil.MARKER_RST7 /*{ENCODED_INT: 215}*/:
                        this.A0O.A0N = (int) j;
                        return;
                    case 231:
                        this.A0E = A01(j);
                        return;
                    case 241:
                        if (!this.A0Z) {
                            this.A0P.A04(j);
                            this.A0Z = true;
                            return;
                        }
                        return;
                    case 251:
                        this.A0W = true;
                        return;
                    case 16980:
                        if (j != 3) {
                            throw new AN(A03(296, 16, 112) + j + A032);
                        }
                        return;
                    case 17029:
                        if (j < 1 || j > 2) {
                            throw new AN(A03(377, 19, 127) + j + A032);
                        }
                        return;
                    case 17143:
                        if (j != 1) {
                            throw new AN(A03(433, 16, 53) + j + A032);
                        }
                        return;
                    case 18401:
                        if (j != 5) {
                            throw new AN(A03(312, 15, 26) + j + A032);
                        }
                        return;
                    case 18408:
                        if (j != 1) {
                            throw new AN(A03(52, 22, 45) + j + A032);
                        }
                        return;
                    case 21420:
                        this.A0I = this.A0K + j;
                        return;
                    case 21432:
                        int i2 = (int) j;
                        if (i2 == 0) {
                            this.A0O.A0P = 0;
                            return;
                        } else if (i2 == 1) {
                            this.A0O.A0P = 2;
                            return;
                        } else if (i2 == 3) {
                            this.A0O.A0P = 1;
                            return;
                        } else if (i2 == 15) {
                            this.A0O.A0P = 3;
                            return;
                        } else {
                            return;
                        }
                    case 21680:
                        this.A0O.A0I = (int) j;
                        return;
                    case 21682:
                        this.A0O.A0H = (int) j;
                        return;
                    case 21690:
                        this.A0O.A0G = (int) j;
                        return;
                    case 21930:
                        C0316Cg cg2 = this.A0O;
                        if (j == 1) {
                            z = true;
                        }
                        cg2.A0a = z;
                        return;
                    case 22186:
                        this.A0O.A0S = j;
                        return;
                    case 22203:
                        this.A0O.A0T = j;
                        return;
                    case 25188:
                        this.A0O.A0A = (int) j;
                        return;
                    case 2352003:
                        this.A0O.A0F = (int) j;
                        return;
                    case 2807729:
                        this.A0M = j;
                        return;
                    default:
                        switch (i) {
                            case 21945:
                                int i3 = (int) j;
                                if (i3 == 1) {
                                    this.A0O.A0C = 2;
                                    return;
                                } else if (i3 == 2) {
                                    this.A0O.A0C = 1;
                                    return;
                                } else {
                                    return;
                                }
                            case 21946:
                                int i4 = (int) j;
                                if (i4 != 1) {
                                    if (A0q[4].length() != 26) {
                                        throw new RuntimeException();
                                    }
                                    String[] strArr = A0q;
                                    strArr[7] = "BNY";
                                    strArr[7] = "BNY";
                                    if (i4 == 16) {
                                        C0316Cg cg3 = this.A0O;
                                        String[] strArr2 = A0q;
                                        if (strArr2[2].charAt(10) != strArr2[6].charAt(10)) {
                                            cg3.A0E = 6;
                                            return;
                                        }
                                        String[] strArr3 = A0q;
                                        strArr3[2] = "2BcX3syCXJtWqdpX1qkuhAX2qE5R3ro0";
                                        strArr3[6] = "aMiDNxLEmFtOjuqrXAq5lyKODggVFywu";
                                        cg3.A0E = 6;
                                        return;
                                    } else if (i4 == 18) {
                                        this.A0O.A0E = 7;
                                        return;
                                    } else if (!(i4 == 6 || i4 == 7)) {
                                        return;
                                    }
                                }
                                this.A0O.A0E = 3;
                                return;
                            case 21947:
                                C0316Cg cg4 = this.A0O;
                                cg4.A0b = true;
                                int i5 = (int) j;
                                if (i5 == 1) {
                                    cg4.A0D = 1;
                                    return;
                                } else if (i5 == 9) {
                                    cg4.A0D = 6;
                                    return;
                                } else if (i5 == 4 || i5 == 5 || i5 == 6 || i5 == 7) {
                                    this.A0O.A0D = 2;
                                    return;
                                } else {
                                    return;
                                }
                            case 21948:
                                this.A0O.A0K = (int) j;
                                return;
                            case 21949:
                                this.A0O.A0L = (int) j;
                                return;
                            default:
                                return;
                        }
                }
            } else {
                int i6 = (j > 1 ? 1 : (j == 1 ? 0 : -1));
                if (A0q[7].length() != 22) {
                    String[] strArr4 = A0q;
                    strArr4[1] = "hD31tqXIhnGrFxqSOgo1vvmOI12OLqRQ";
                    strArr4[1] = "hD31tqXIhnGrFxqSOgo1vvmOI12OLqRQ";
                    if (i6 == 0) {
                        return;
                    }
                } else if (i6 == 0) {
                    return;
                }
                throw new AN(A03(348, 21, 50) + j + A032);
            }
        } else if (j != 0) {
            throw new AN(A03(327, 21, 54) + j + A032);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:43:0x00e4, code lost:
        if (r5 != 0) goto L_0x00e6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x0114, code lost:
        if (r5 != 0) goto L_0x00e6;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void A0N(int r8, long r9, long r11) throws com.facebook.ads.redexgen.X.AN {
        /*
        // Method dump skipped, instructions count: 347
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.YT.A0N(int, long, long):void");
    }

    public final void A0O(int i, String str) throws AN {
        if (i == 134) {
            this.A0O.A0Y = str;
        } else if (i != 17026) {
            if (i == 2274716) {
                this.A0O.A0g = str;
            }
        } else if (!A03(IronSourceError.ERROR_RV_LOAD_UNEXPECTED_CALLBACK, 4, 114).equals(str) && !A03(1016, 8, 38).equals(str)) {
            throw new AN(A03(369, 8, 86) + str + A03(0, 14, 56));
        }
    }

    @Override // com.facebook.ads.redexgen.X.CK
    public final void A7Q(CM cm) {
        this.A0N = cm;
    }

    @Override // com.facebook.ads.redexgen.X.CK
    public final int ABx(CL cl, CR cr) throws IOException, InterruptedException {
        this.A0V = false;
        boolean z = true;
        while (z && !this.A0V) {
            z = this.A0d.ABz(cl);
            if (z && A0F(cr, cl.A6m())) {
                return 1;
            }
        }
        if (z) {
            return 0;
        }
        for (int i = 0; i < this.A0c.size(); i++) {
            this.A0c.valueAt(i).A08();
        }
        return -1;
    }

    @Override // com.facebook.ads.redexgen.X.CK
    public final void ACj(long j, long j2) {
        this.A0E = -9223372036854775807L;
        this.A04 = 0;
        this.A0d.reset();
        this.A0e.A06();
        A05();
        for (int i = 0; i < this.A0c.size(); i++) {
            this.A0c.valueAt(i).A09();
        }
    }

    @Override // com.facebook.ads.redexgen.X.CK
    public final boolean ADH(CL cl) throws IOException, InterruptedException {
        return new C0318Ci().A02(cl);
    }
}
