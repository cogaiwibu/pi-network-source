package com.facebook.ads.redexgen.X;

import com.facebook.ads.internal.exoplayer2.source.TrackGroupArray;
import java.io.IOException;

public final class B0 implements AbstractC0907Zu, AbstractC0906Zt {
    public static String[] A06;
    public long A00;
    public long A01;
    public long A02;
    public AbstractC0906Zt A03;
    public C0897Zh[] A04 = new C0897Zh[0];
    public final AbstractC0907Zu A05;

    static {
        A01();
    }

    public static void A01() {
        A06 = new String[]{"xZ98n6jXZ", "w0wM6S1AW5kwd8mBaLXb8IJFUPLi1ZSY", "", "5GeP1Ey0MjdLLaKEOlMigJbDmIHcG3Ps", "Q5WYazqpabUa99ZYxsI", "Gm0HQrfOciURdkrLDtJ", "cUS8ttxVNiquYZeS", "9hpvQN9G3pxye3p4YcQpNMMd2GK"};
    }

    public B0(AbstractC0907Zu zu, boolean z, long j, long j2) {
        long j3;
        this.A05 = zu;
        if (z) {
            j3 = j;
        } else {
            j3 = -9223372036854775807L;
        }
        this.A02 = j3;
        this.A01 = j;
        this.A00 = j2;
    }

    private C0273Af A00(long j, C0273Af af) {
        long j2;
        long A0E = C0466Ig.A0E(af.A01, 0, j - this.A01);
        long j3 = af.A00;
        long j4 = this.A00;
        if (j4 == Long.MIN_VALUE) {
            j2 = Long.MAX_VALUE;
        } else {
            j2 = j4 - j;
        }
        long A0E2 = C0466Ig.A0E(j3, 0, j2);
        if (A0E == af.A01 && A0E2 == af.A00) {
            return af;
        }
        return new C0273Af(A0E, A0E2);
    }

    /* access modifiers changed from: private */
    /* renamed from: A02 */
    public final void A9F(AbstractC0907Zu zu) {
        this.A03.A9F(this);
    }

    public static boolean A03(long j, H8[] h8Arr) {
        if (j != 0) {
            for (H8 h8 : h8Arr) {
                if (!(h8 == null || IJ.A0A(h8.A6t().A0O))) {
                    return true;
                }
            }
        }
        return false;
    }

    public final boolean A04() {
        return this.A02 != -9223372036854775807L;
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC0907Zu
    public final boolean A4A(long j) {
        return this.A05.A4A(j);
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC0907Zu
    public final void A4m(long j, boolean z) {
        this.A05.A4m(j, z);
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC0907Zu
    public final long A5J(long j, C0273Af af) {
        long j2 = this.A01;
        if (j == j2) {
            return j2;
        }
        return this.A05.A5J(j, A00(j, af));
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC0907Zu
    public final long A5Y() {
        long A5Y = this.A05.A5Y();
        if (A5Y != Long.MIN_VALUE) {
            long j = this.A00;
            if (j == Long.MIN_VALUE || A5Y < j) {
                return A5Y;
            }
        }
        return Long.MIN_VALUE;
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC0907Zu
    public final long A6Z() {
        long A6Z = this.A05.A6Z();
        if (A6Z != Long.MIN_VALUE) {
            long j = this.A00;
            if (j == Long.MIN_VALUE || A6Z < j) {
                return A6Z;
            }
        }
        return Long.MIN_VALUE;
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC0907Zu
    public final TrackGroupArray A79() {
        return this.A05.A79();
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC0907Zu
    public final void A8V() throws IOException {
        this.A05.A8V();
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC0906Zt
    public final void AAb(AbstractC0907Zu zu) {
        this.A03.AAb(this);
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC0907Zu
    public final void ABi(AbstractC0906Zt zt, long j) {
        this.A03 = zt;
        this.A05.ABi(this, j);
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC0907Zu
    public final long AC1() {
        boolean z;
        if (A04()) {
            long j = this.A02;
            this.A02 = -9223372036854775807L;
            long AC1 = AC1();
            return AC1 != -9223372036854775807L ? AC1 : j;
        }
        long AC12 = this.A05.AC1();
        String[] strArr = A06;
        if (strArr[7].length() != strArr[2].length()) {
            String[] strArr2 = A06;
            strArr2[5] = "JN4lYhgdVtJugUzGLO1";
            strArr2[4] = "V7PIoeFvQi5pkabjQnk";
            if (AC12 == -9223372036854775807L) {
                return -9223372036854775807L;
            }
            boolean z2 = true;
            if (AC12 >= this.A01) {
                z = true;
            } else {
                z = false;
            }
            I1.A04(z);
            long discontinuityUs = this.A00;
            if (discontinuityUs != Long.MIN_VALUE && AC12 > discontinuityUs) {
                z2 = false;
            }
            I1.A04(z2);
            return AC12;
        }
        throw new RuntimeException();
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC0907Zu
    public final void AC9(long j) {
        this.A05.AC9(j);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0032, code lost:
        if (r5 > r3) goto L_0x0035;
     */
    @Override // com.facebook.ads.redexgen.X.AbstractC0907Zu
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final long ACn(long r9) {
        /*
            r8 = this;
            r0 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r8.A02 = r0
            com.facebook.ads.redexgen.X.Zh[] r3 = r8.A04
            int r2 = r3.length
            r7 = 0
            r1 = 0
        L_0x000c:
            if (r1 >= r2) goto L_0x0018
            r0 = r3[r1]
            if (r0 == 0) goto L_0x0015
            r0.A01()
        L_0x0015:
            int r1 = r1 + 1
            goto L_0x000c
        L_0x0018:
            com.facebook.ads.redexgen.X.Zu r0 = r8.A05
            long r5 = r0.ACn(r9)
            int r0 = (r5 > r9 ? 1 : (r5 == r9 ? 0 : -1))
            if (r0 == 0) goto L_0x0034
            long r1 = r8.A01
            int r0 = (r5 > r1 ? 1 : (r5 == r1 ? 0 : -1))
            if (r0 < 0) goto L_0x0035
            long r3 = r8.A00
            r1 = -9223372036854775808
            int r0 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1))
            if (r0 == 0) goto L_0x0034
            int r0 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
            if (r0 > 0) goto L_0x0035
        L_0x0034:
            r7 = 1
        L_0x0035:
            com.facebook.ads.redexgen.X.I1.A04(r7)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.B0.ACn(long):long");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x005b, code lost:
        if (r7 > r1) goto L_0x0090;
     */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x004b  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0065  */
    @Override // com.facebook.ads.redexgen.X.AbstractC0907Zu
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final long ACo(com.facebook.ads.redexgen.X.H8[] r16, boolean[] r17, com.facebook.ads.redexgen.X.AbstractC0387Fd[] r18, boolean[] r19, long r20) {
        /*
        // Method dump skipped, instructions count: 153
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.B0.ACo(com.facebook.ads.redexgen.X.H8[], boolean[], com.facebook.ads.redexgen.X.Fd[], boolean[], long):long");
    }
}
