package com.facebook.ads.redexgen.X;

import android.net.Uri;
import android.os.Handler;
import androidx.annotation.Nullable;
import com.facebook.ads.internal.exoplayer2.Format;
import com.facebook.ads.internal.exoplayer2.source.TrackGroup;
import com.facebook.ads.internal.exoplayer2.source.TrackGroupArray;
import com.tapjoy.TapjoyConstants;
import java.io.IOException;
import java.util.Arrays;

/* renamed from: com.facebook.ads.redexgen.X.Az  reason: case insensitive filesystem */
public final class C0292Az implements AbstractC0907Zu, CM, HX<C0904Zp>, AbstractC0434Ha, AbstractC0386Fc {
    public static byte[] A0c;
    public static String[] A0d;
    public int A00;
    public int A01;
    public int A02;
    public long A03;
    public long A04;
    public long A05;
    public long A06;
    public CT A07;
    @Nullable
    public AbstractC0906Zt A08;
    public TrackGroupArray A09;
    public boolean A0A;
    public boolean A0B;
    public boolean A0C;
    public boolean A0D;
    public boolean A0E;
    public boolean A0F;
    public boolean A0G;
    public boolean A0H;
    public boolean A0I;
    public int[] A0J;
    public C0908Zv[] A0K;
    public boolean[] A0L;
    public boolean[] A0M;
    public boolean[] A0N;
    public final int A0O;
    public final long A0P;
    public final Uri A0Q;
    public final Handler A0R;
    public final FC A0S;
    public final FD A0T;
    public final FT A0U;
    public final HE A0V;
    public final HM A0W;
    public final C0960al A0X = new C0960al(A07(0, 27, 82));
    public final I7 A0Y;
    public final Runnable A0Z;
    public final Runnable A0a;
    @Nullable
    public final String A0b;

    static {
        A0C();
        A0B();
    }

    public static String A07(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A0c, i, i + i2);
        int i4 = 0;
        while (true) {
            int length = copyOfRange.length;
            if (A0d[7].length() != 22) {
                throw new RuntimeException();
            }
            String[] strArr = A0d;
            strArr[2] = "Up";
            strArr[2] = "Up";
            if (i4 >= length) {
                return new String(copyOfRange);
            }
            copyOfRange[i4] = (byte) ((copyOfRange[i4] ^ i3) ^ 120);
            i4++;
        }
    }

    public static void A0B() {
        A0c = new byte[]{102, 69, 75, 78, 79, 88, 16, 111, 82, 94, 88, 75, 73, 94, 69, 88, 103, 79, 78, 67, 75, 122, 79, 88, 67, 69, 78};
    }

    public static void A0C() {
        A0d = new String[]{"iI0ZOGUFhjVKOFZqbUjTJbzZriBk", "wCM5SpVnQk8vEGvx3xuFkFQnwN8gnHkn", "CC", "sZUrtXRAji2vfBWVwphN9cenOJ8FQWpp", "F506DqgxlNyYyNAR0eHuGAxqIBb0RwxX", "mj8nEZtHpBznvwUNQKJPsV2u1H4", "sYtV3FATfn8NsU7nH3", "hZDPske6mXbyt4vhVom9Ng"};
    }

    public C0292Az(Uri uri, HM hm, CK[] ckArr, int i, FT ft, FD fd, HE he, @Nullable String str, int i2) {
        this.A0Q = uri;
        this.A0W = hm;
        this.A0O = i;
        this.A0U = ft;
        this.A0T = fd;
        this.A0V = he;
        this.A0b = str;
        this.A0P = (long) i2;
        this.A0S = new FC(ckArr, this);
        this.A0Y = new I7();
        this.A0Z = new FA(this);
        this.A0a = new FB(this);
        this.A0R = new Handler();
        this.A0J = new int[0];
        this.A0K = new C0908Zv[0];
        this.A06 = -9223372036854775807L;
        this.A05 = -1;
        this.A03 = -9223372036854775807L;
        this.A00 = i == -1 ? 3 : i;
        ft.A04();
    }

    private int A00() {
        int i = 0;
        C0908Zv[] zvArr = this.A0K;
        for (C0908Zv zv : zvArr) {
            String[] strArr = A0d;
            if (strArr[5].length() != strArr[0].length()) {
                String[] strArr2 = A0d;
                strArr2[3] = "qSOUgbz3JlJaX9UdXA1gn9agrJ83m9Y6";
                strArr2[1] = "wkCF1xtIBevCyUX610AjJpYT598Om9ct";
                i += zv.A0D();
            } else {
                throw new RuntimeException();
            }
        }
        return i;
    }

    /* access modifiers changed from: private */
    /* renamed from: A01 */
    public final int AA0(C0904Zp zp, long j, long j2, IOException iOException) {
        boolean z;
        boolean isErrorFatal = A0O(iOException);
        this.A0U.A0I(zp.A03, 1, -1, null, 0, null, zp.A02, this.A03, j, j2, zp.A00, iOException, isErrorFatal);
        A0F(zp);
        if (isErrorFatal) {
            return 3;
        }
        int A002 = A00();
        if (A002 > this.A02) {
            z = true;
        } else {
            z = false;
        }
        if (!A0M(zp, A002)) {
            return 2;
        }
        if (z) {
            return 1;
        }
        return 0;
    }

    private long A02() {
        long j = Long.MIN_VALUE;
        C0908Zv[] zvArr = this.A0K;
        for (C0908Zv zv : zvArr) {
            if (A0d[6].length() != 18) {
                throw new RuntimeException();
            }
            String[] strArr = A0d;
            strArr[6] = "ZyGj31aUIwj7oXhThZ";
            strArr[6] = "ZyGj31aUIwj7oXhThZ";
            j = Math.max(j, zv.A0G());
        }
        return j;
    }

    /* access modifiers changed from: private */
    public void A09() {
        if (!this.A0G && !this.A0F && this.A07 != null && this.A0H) {
            for (C0908Zv sampleQueue : this.A0K) {
                if (sampleQueue.A0H() == null) {
                    return;
                }
            }
            this.A0Y.A02();
            int length = this.A0K.length;
            TrackGroup[] trackGroupArr = new TrackGroup[length];
            this.A0N = new boolean[length];
            this.A0L = new boolean[length];
            this.A0M = new boolean[length];
            this.A03 = this.A07.A65();
            int i = 0;
            while (true) {
                boolean z = true;
                if (i < length) {
                    Format A0H2 = this.A0K[i].A0H();
                    trackGroupArr[i] = new TrackGroup(A0H2);
                    String str = A0H2.A0O;
                    if (!IJ.A0C(str)) {
                        boolean A0A2 = IJ.A0A(str);
                        if (A0d[7].length() != 22) {
                            throw new RuntimeException();
                        }
                        String[] strArr = A0d;
                        strArr[4] = "sORkCePcQUNrHwPTmIu9z8sBJIN6eDJt";
                        strArr[4] = "sORkCePcQUNrHwPTmIu9z8sBJIN6eDJt";
                        if (!A0A2) {
                            z = false;
                        }
                    }
                    this.A0N[i] = z;
                    this.A0A |= z;
                    i++;
                } else {
                    this.A09 = new TrackGroupArray(trackGroupArr);
                    if (this.A0O == -1 && this.A05 == -1 && this.A07.A65() == -9223372036854775807L) {
                        this.A00 = 6;
                    }
                    this.A0F = true;
                    this.A0T.AAw(this.A03, this.A07.A7m());
                    this.A08.AAb(this);
                    return;
                }
            }
        }
    }

    /* JADX INFO: Multiple debug info for r15v0 'this'  com.facebook.ads.redexgen.X.Az: [D('loadable' com.facebook.ads.redexgen.X.Zp), D('elapsedRealtimeMs' long)] */
    private void A0A() {
        C0904Zp zp = new C0904Zp(this, this.A0Q, this.A0W, this.A0S, this.A0Y);
        if (this.A0F) {
            I1.A04(A0J());
            long j = this.A03;
            if (j == -9223372036854775807L || this.A06 < j) {
                zp.A05(this.A07.A6s(this.A06).A00.A00, this.A06);
                this.A06 = -9223372036854775807L;
            } else {
                this.A0B = true;
                this.A06 = -9223372036854775807L;
                return;
            }
        }
        this.A02 = A00();
        this.A0U.A0F(zp.A03, 1, -1, null, 0, null, zp.A02, this.A03, this.A0X.A05(zp, this, this.A00));
    }

    private void A0D(int i) {
        if (!this.A0M[i]) {
            Format A022 = this.A09.A02(i).A02(0);
            this.A0U.A07(IJ.A01(A022.A0O), A022, 0, null, this.A04);
            this.A0M[i] = true;
        }
    }

    private void A0E(int i) {
        if (this.A0E && this.A0N[i] && !this.A0K[i].A0N()) {
            this.A06 = 0;
            this.A0E = false;
            this.A0D = true;
            this.A04 = 0;
            this.A02 = 0;
            for (C0908Zv sampleQueue : this.A0K) {
                sampleQueue.A0J();
            }
            this.A08.A9F(this);
        }
    }

    private void A0F(C0904Zp zp) {
        if (this.A05 == -1) {
            this.A05 = zp.A01;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: A0G */
    public final void A9z(C0904Zp zp, long j, long j2) {
        long largestQueuedTimestampUs;
        if (this.A03 == -9223372036854775807L) {
            long A022 = A02();
            if (A022 == Long.MIN_VALUE) {
                largestQueuedTimestampUs = 0;
            } else {
                largestQueuedTimestampUs = TapjoyConstants.TIMER_INCREMENT + A022;
            }
            this.A03 = largestQueuedTimestampUs;
            this.A0T.AAw(this.A03, this.A07.A7m());
        }
        this.A0U.A0H(zp.A03, 1, -1, null, 0, null, zp.A02, this.A03, j, j2, zp.A00);
        A0F(zp);
        this.A0B = true;
        this.A08.A9F(this);
    }

    /* access modifiers changed from: private */
    /* renamed from: A0H */
    public final void A9x(C0904Zp zp, long j, long j2, boolean z) {
        this.A0U.A0G(zp.A03, 1, -1, null, 0, null, zp.A02, this.A03, j, j2, zp.A00);
        if (!z) {
            A0F(zp);
            for (C0908Zv zv : this.A0K) {
                zv.A0J();
            }
            if (this.A01 > 0) {
                this.A08.A9F(this);
            }
        }
    }

    private boolean A0J() {
        return this.A06 != -9223372036854775807L;
    }

    private boolean A0K() {
        if (!this.A0D) {
            boolean A0J2 = A0J();
            if (A0d[4].charAt(6) != 'Y') {
                String[] strArr = A0d;
                strArr[7] = "wEe5Kid34hKwvsAXbAWEFW";
                strArr[7] = "wEe5Kid34hKwvsAXbAWEFW";
                return A0J2;
            }
            throw new RuntimeException();
        }
    }

    private boolean A0L(long j) {
        int length = this.A0K.length;
        int i = 0;
        while (true) {
            boolean z = true;
            if (i >= length) {
                return true;
            }
            C0908Zv sampleQueue = this.A0K[i];
            sampleQueue.A0K();
            if (sampleQueue.A0E(j, true, false) == -1) {
                z = false;
            }
            if (z || (!this.A0N[i] && this.A0A)) {
                i++;
            }
        }
        return false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0036, code lost:
        if (r7 != -9223372036854775807L) goto L_0x0038;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean A0M(com.facebook.ads.redexgen.X.C0904Zp r10, int r11) {
        /*
        // Method dump skipped, instructions count: 138
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C0292Az.A0M(com.facebook.ads.redexgen.X.Zp, int):boolean");
    }

    public static boolean A0O(IOException iOException) {
        return iOException instanceof C0914a1;
    }

    public final int A0P(int skipCount, long j) {
        int A0E2;
        if (A0K()) {
            return 0;
        }
        C0908Zv zv = this.A0K[skipCount];
        if (!this.A0B || j <= zv.A0G()) {
            A0E2 = zv.A0E(j, true, true);
            if (A0E2 == -1) {
                A0E2 = 0;
            }
        } else {
            A0E2 = zv.A0B();
        }
        if (A0E2 > 0) {
            A0D(skipCount);
        } else {
            A0E(skipCount);
        }
        return A0E2;
    }

    public final int A0Q(int i, AH ah, C0861Xw xw, boolean z) {
        if (A0K()) {
            return -3;
        }
        C0908Zv zv = this.A0K[i];
        boolean z2 = this.A0B;
        long j = this.A04;
        if (A0d[6].length() != 18) {
            throw new RuntimeException();
        }
        String[] strArr = A0d;
        strArr[4] = "BZZhA5HnQ267vlJC28K7sY9wv6QGzHwf";
        strArr[4] = "BZZhA5HnQ267vlJC28K7sY9wv6QGzHwf";
        int A0F2 = zv.A0F(ah, xw, z, z2, j);
        if (A0F2 == -4) {
            A0D(i);
        } else if (A0F2 == -3) {
            A0E(i);
        }
        return A0F2;
    }

    public final void A0R() throws IOException {
        this.A0X.A07(this.A00);
    }

    public final void A0S() {
        if (this.A0F) {
            for (C0908Zv zv : this.A0K) {
                zv.A0I();
            }
        }
        this.A0X.A08(this);
        this.A0R.removeCallbacksAndMessages(null);
        this.A08 = null;
        this.A0G = true;
        this.A0U.A05();
    }

    public final boolean A0T(int i) {
        return !A0K() && (this.A0B || this.A0K[i].A0N());
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC0907Zu
    public final boolean A4A(long j) {
        if (this.A0B || this.A0E) {
            return false;
        }
        if (this.A0F) {
            int i = this.A01;
            if (A0d[4].charAt(6) != 'Y') {
                String[] strArr = A0d;
                strArr[4] = "7rVHsGRdVZCry1KpVG9eopTEFKGRMHdR";
                strArr[4] = "7rVHsGRdVZCry1KpVG9eopTEFKGRMHdR";
                if (i == 0) {
                    return false;
                }
            } else {
                throw new RuntimeException();
            }
        }
        boolean A032 = this.A0Y.A03();
        if (this.A0X.A09()) {
            return A032;
        }
        A0A();
        String[] strArr2 = A0d;
        if (strArr2[5].length() != strArr2[0].length()) {
            String[] strArr3 = A0d;
            strArr3[4] = "GZZ8Yg3MT0LKLUTCQO9quz1OXrB3914Q";
            strArr3[4] = "GZZ8Yg3MT0LKLUTCQO9quz1OXrB3914Q";
            return true;
        }
        String[] strArr4 = A0d;
        strArr4[4] = "KAHjzw5ailzTQNPlHwAo2zZrrjfyTj4F";
        strArr4[4] = "KAHjzw5ailzTQNPlHwAo2zZrrjfyTj4F";
        return false;
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC0907Zu
    public final void A4m(long j, boolean z) {
        int length = this.A0K.length;
        for (int i = 0; i < length; i++) {
            this.A0K[i].A0L(j, z, this.A0L[i]);
        }
    }

    @Override // com.facebook.ads.redexgen.X.CM
    public final void A4w() {
        this.A0H = true;
        this.A0R.post(this.A0Z);
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC0907Zu
    public final long A5J(long j, C0273Af af) {
        if (!this.A07.A7m()) {
            return 0;
        }
        CS A6s = this.A07.A6s(j);
        return C0466Ig.A0I(j, af, A6s.A00.A01, A6s.A01.A01);
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC0907Zu
    public final long A5Y() {
        long j;
        if (this.A0B) {
            return Long.MIN_VALUE;
        }
        if (A0J()) {
            long j2 = this.A06;
            if (A0d[6].length() == 18) {
                String[] strArr = A0d;
                strArr[4] = "v1DtQTmxA3FTsqocwnKPSJWZapJDPMlv";
                strArr[4] = "v1DtQTmxA3FTsqocwnKPSJWZapJDPMlv";
                return j2;
            }
        } else {
            if (this.A0A) {
                j = Long.MAX_VALUE;
                if (A0d[6].length() == 18) {
                    String[] strArr2 = A0d;
                    strArr2[7] = "vaKypmx8P8ApWe5d9yUSyn";
                    strArr2[7] = "vaKypmx8P8ApWe5d9yUSyn";
                    int length = this.A0K.length;
                    for (int i = 0; i < length; i++) {
                        if (this.A0N[i]) {
                            C0908Zv zv = this.A0K[i];
                            String[] strArr3 = A0d;
                            if (strArr3[5].length() != strArr3[0].length()) {
                                String[] strArr4 = A0d;
                                strArr4[7] = "ClOx81htkGLxdwhy5PY2qE";
                                strArr4[7] = "ClOx81htkGLxdwhy5PY2qE";
                                j = Math.min(j, zv.A0G());
                            } else {
                                throw new RuntimeException();
                            }
                        }
                    }
                }
            } else {
                j = A02();
            }
            return j == Long.MIN_VALUE ? this.A04 : j;
        }
        throw new RuntimeException();
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC0907Zu
    public final long A6Z() {
        if (this.A01 == 0) {
            return Long.MIN_VALUE;
        }
        return A5Y();
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC0907Zu
    public final TrackGroupArray A79() {
        return this.A09;
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC0907Zu
    public final void A8V() throws IOException {
        A0R();
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC0434Ha
    public final void AA4() {
        for (C0908Zv zv : this.A0K) {
            zv.A0J();
        }
        this.A0S.A04();
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC0386Fc
    public final void ABD(Format format) {
        this.A0R.post(this.A0Z);
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC0907Zu
    public final void ABi(AbstractC0906Zt zt, long j) {
        this.A08 = zt;
        this.A0Y.A03();
        A0A();
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC0907Zu
    public final long AC1() {
        if (!this.A0C) {
            this.A0U.A06();
            this.A0C = true;
        }
        if (!this.A0D) {
            return -9223372036854775807L;
        }
        if (!this.A0B && A00() <= this.A02) {
            return -9223372036854775807L;
        }
        this.A0D = false;
        return this.A04;
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC0907Zu
    public final void AC9(long j) {
    }

    @Override // com.facebook.ads.redexgen.X.CM
    public final void ACk(CT ct) {
        this.A07 = ct;
        this.A0R.post(this.A0Z);
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC0907Zu
    public final long ACn(long j) {
        if (!this.A07.A7m()) {
            j = 0;
        }
        this.A04 = j;
        this.A0D = false;
        if (!A0J() && A0L(j)) {
            return j;
        }
        this.A0E = false;
        this.A06 = j;
        this.A0B = false;
        if (this.A0X.A09()) {
            this.A0X.A06();
        } else {
            for (C0908Zv sampleQueue : this.A0K) {
                sampleQueue.A0J();
            }
        }
        return j;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:53:0x010e, code lost:
        if (r8.A09() != false) goto L_0x0110;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x012d, code lost:
        if (r8.A09() != false) goto L_0x0110;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x0130, code lost:
        r4 = r12.A0K;
        r3 = r4.length;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x0133, code lost:
        if (r7 >= r3) goto L_0x0173;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x0135, code lost:
        r4[r7].A0J();
        r7 = r7 + 1;
     */
    @Override // com.facebook.ads.redexgen.X.AbstractC0907Zu
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final long ACo(com.facebook.ads.redexgen.X.H8[] r13, boolean[] r14, com.facebook.ads.redexgen.X.AbstractC0387Fd[] r15, boolean[] r16, long r17) {
        /*
        // Method dump skipped, instructions count: 380
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C0292Az.ACo(com.facebook.ads.redexgen.X.H8[], boolean[], com.facebook.ads.redexgen.X.Fd[], boolean[], long):long");
    }

    /* JADX INFO: Multiple debug info for r5v0 int: [D('trackOutput' com.facebook.ads.redexgen.X.Zv), D('i' int)] */
    @Override // com.facebook.ads.redexgen.X.CM
    public final CW ADY(int i, int i2) {
        int length = this.A0K.length;
        for (int i3 = 0; i3 < length; i3++) {
            if (this.A0J[i3] == i) {
                return this.A0K[i3];
            }
        }
        C0908Zv zv = new C0908Zv(this.A0V);
        zv.A0M(this);
        this.A0J = Arrays.copyOf(this.A0J, length + 1);
        this.A0J[length] = i;
        this.A0K = (C0908Zv[]) Arrays.copyOf(this.A0K, length + 1);
        this.A0K[length] = zv;
        return zv;
    }
}
