package com.facebook.ads.redexgen.X;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.util.Pair;
import com.facebook.ads.internal.exoplayer2.Format;
import com.facebook.ads.internal.exoplayer2.source.TrackGroupArray;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import kotlin.jvm.internal.ByteCompanionObject;

public final class CX implements Handler.Callback, AbstractC0906Zt, HA, FH, A1, AY {
    public static byte[] A0V;
    public static String[] A0W;
    public int A00;
    public int A01;
    public int A02;
    public long A03;
    public AD A04;
    public AO A05;
    public C0273Af A06;
    public FI A07;
    public boolean A08;
    public boolean A09;
    public boolean A0A;
    public boolean A0B;
    public AbstractC0844Xf[] A0C;
    public final long A0D;
    public final Handler A0E;
    public final HandlerThread A0F;
    public final XZ A0G;
    public final AbstractC0842Xd A0H;
    public final AC A0I;
    public final AJ A0J;
    public final AM A0K = new AM();
    public final C0274Ah A0L;
    public final C0275Ai A0M;
    public final HB A0N;
    public final HC A0O;
    public final I4 A0P;
    public final IE A0Q;
    public final ArrayList<AB> A0R;
    public final boolean A0S;
    public final AbstractC0844Xf[] A0T;
    public final AbstractC0270Ac[] A0U;

    static {
        A0L();
        A0K();
    }

    public static String A06(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A0V, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] ^ i3) ^ 98);
        }
        return new String(copyOfRange);
    }

    public static void A0K() {
        A0V = new byte[]{40, 21, 2, 61, 1, 12, 20, 8, 31, 36, 0, 29, 1, 36, 3, 25, 8, 31, 3, 12, 1, 40, 21, 2, 61, 1, 12, 20, 8, 31, 36, 0, 29, 1, 36, 3, 25, 8, 31, 3, 12, 1, 87, 37, 12, 3, 9, 1, 8, 31, 25, 55, 62, 63, 34, 57, 62, 55, 112, 61, 53, 35, 35, 49, 55, 53, 35, 112, 35, 53, 62, 36, 112, 49, 54, 36, 53, 34, 112, 34, 53, 60, 53, 49, 35, 53, 126, 71, 96, 122, 107, 124, 96, 111, 98, 46, 124, 123, 96, 122, 103, 99, 107, 46, 107, 124, 124, 97, 124, 32, 50, 14, 3, 27, 0, 3, 1, 9, 66, 7, 16, 16, 13, 16, 76, 102, 90, 64, 71, 86, 80, 21, 80, 71, 71, 90, 71, 27, 74, 109, 118, 105, 57, ByteCompanionObject.MAX_VALUE, 120, 112, 117, 124, 125, 55, 119, 124, 64, 124, 126, 118, 68, 124, 97, 120};
    }

    public static void A0L() {
        A0W = new String[]{"86glHvEVsTHsOarjgO3yrK", "TuAJpp7uzbfmMtpdLTRiZnKK78MiZtWb", "2J1ujHTPZohQZteX1j6kCS7zhajZ8mZI", "eCxkC7v7XtRVNueTNXvbthBaIEqCwNNl", "l3Yyub2xLFiYeWCCac", "TG0XkoHYQCfebcNj4J", "6SVWI1Jvh0Z3jrcRBB9hLc8AjjQAtTry", "lVbeqNrXIfO7zu9EZv7JtI"};
    }

    public CX(AbstractC0844Xf[] xfArr, HB hb, HC hc, AJ aj, boolean z, int i, boolean z2, Handler handler, AbstractC0842Xd xd, I4 i4) {
        this.A0T = xfArr;
        this.A0N = hb;
        this.A0O = hc;
        this.A0J = aj;
        this.A08 = z;
        this.A02 = i;
        this.A0B = z2;
        this.A0E = handler;
        this.A0H = xd;
        this.A0P = i4;
        this.A0D = aj.A5R();
        this.A0S = aj.ACc();
        this.A06 = C0273Af.A03;
        this.A05 = new AO(AbstractC0276Aj.A01, -9223372036854775807L, TrackGroupArray.A04, hc);
        this.A0I = new AC(null);
        this.A0U = new AbstractC0270Ac[xfArr.length];
        for (int i2 = 0; i2 < xfArr.length; i2++) {
            xfArr[i2].ACx(i2);
            this.A0U[i2] = xfArr[i2].A5c();
        }
        this.A0G = new XZ(this, i4);
        this.A0R = new ArrayList<>();
        this.A0C = new AbstractC0844Xf[0];
        this.A0M = new C0275Ai();
        this.A0L = new C0274Ah();
        hb.A00(this);
        this.A0F = new HandlerThread(A06(21, 29, 15), -16);
        this.A0F.start();
        this.A0Q = i4.A4I(this.A0F.getLooper(), this);
    }

    private int A00() {
        AbstractC0276Aj aj = this.A05.A03;
        if (aj.A0F()) {
            return 0;
        }
        return aj.A0C(aj.A06(this.A0B), this.A0M).A00;
    }

    private int A01(int i, AbstractC0276Aj aj, AbstractC0276Aj aj2) {
        int maxIterations = i;
        int i2 = -1;
        int A012 = aj.A01();
        for (int i3 = 0; i3 < A012 && i2 == -1; i3++) {
            maxIterations = aj.A04(maxIterations, this.A0L, this.A0M, this.A02, this.A0B);
            if (maxIterations == -1) {
                break;
            }
            i2 = aj2.A05(aj.A0B(maxIterations, this.A0L, true).A03);
        }
        return i2;
    }

    private long A02(FG fg, long j) {
        boolean z;
        if (this.A0K.A0H() != this.A0K.A0I()) {
            z = true;
        } else {
            z = false;
        }
        return A03(fg, j, z);
    }

    private long A03(FG fg, long j, boolean z) {
        A0H();
        this.A09 = false;
        A0O(2);
        AK A0H2 = this.A0K.A0H();
        AK newPlayingPeriodHolder = A0H2;
        while (true) {
            if (newPlayingPeriodHolder == null) {
                break;
            } else if (A0u(fg, j, newPlayingPeriodHolder)) {
                this.A0K.A0T(newPlayingPeriodHolder);
                break;
            } else {
                newPlayingPeriodHolder = this.A0K.A0D();
            }
        }
        if (A0H2 != newPlayingPeriodHolder || z) {
            AbstractC0844Xf[] xfArr = this.A0C;
            int length = xfArr.length;
            if (A0W[5].length() == 18) {
                String[] strArr = A0W;
                strArr[4] = "MfZ5b0v7S5HL";
                strArr[4] = "MfZ5b0v7S5HL";
                int i = 0;
                while (true) {
                    if (i >= length) {
                        this.A0C = new AbstractC0844Xf[0];
                        A0H2 = null;
                        break;
                    }
                    AbstractC0844Xf xf = xfArr[i];
                    if (A0W[6].charAt(23) == 'j') {
                        break;
                    }
                    String[] strArr2 = A0W;
                    strArr2[4] = "gre2iAEzIfwakAGQE6Y0w4gvRDGAgj";
                    strArr2[4] = "gre2iAEzIfwakAGQE6Y0w4gvRDGAgj";
                    A0c(xf);
                    i++;
                }
            }
            throw new RuntimeException();
        }
        if (newPlayingPeriodHolder != null) {
            A0W(A0H2);
            boolean z2 = newPlayingPeriodHolder.A05;
            String[] strArr3 = A0W;
            if (strArr3[1].charAt(27) != strArr3[2].charAt(27)) {
                String[] strArr4 = A0W;
                strArr4[5] = "xpv6IUpjcorvZnU437";
                strArr4[5] = "xpv6IUpjcorvZnU437";
                if (z2) {
                    j = newPlayingPeriodHolder.A08.ACn(j);
                    newPlayingPeriodHolder.A08.A4m(j - this.A0D, this.A0S);
                }
                A0Q(j);
                A09();
            }
            throw new RuntimeException();
        }
        this.A0K.A0P(true);
        A0Q(j);
        this.A0Q.ACp(2);
        return j;
    }

    private Pair<Integer, Long> A04(AD ad, boolean z) {
        int A012;
        AbstractC0276Aj aj = this.A05.A03;
        AbstractC0276Aj aj2 = ad.A02;
        if (aj.A0F()) {
            return null;
        }
        if (aj2.A0F()) {
            aj2 = aj;
        }
        try {
            Pair<Integer, Long> A082 = aj2.A08(this.A0M, this.A0L, ad.A00, ad.A01);
            if (aj == aj2) {
                return A082;
            }
            int A052 = aj.A05(aj2.A0B(((Integer) A082.first).intValue(), this.A0L, true).A03);
            if (A052 != -1) {
                Integer valueOf = Integer.valueOf(A052);
                Object obj = A082.second;
                if (A0W[5].length() != 18) {
                    throw new RuntimeException();
                }
                String[] strArr = A0W;
                strArr[4] = "NzmvKaw5D7qN";
                strArr[4] = "NzmvKaw5D7qN";
                return Pair.create(valueOf, obj);
            } else if (!z || (A012 = A01(((Integer) A082.first).intValue(), aj2, aj)) == -1) {
                return null;
            } else {
                int i = aj.A0A(A012, this.A0L).A00;
                String[] strArr2 = A0W;
                if (strArr2[1].charAt(27) == strArr2[2].charAt(27)) {
                    return A05(aj, i, -9223372036854775807L);
                }
                String[] strArr3 = A0W;
                strArr3[4] = "Yw40DLhiFndXC7wfBusX4OUMnHZHVu";
                strArr3[4] = "Yw40DLhiFndXC7wfBusX4OUMnHZHVu";
                return A05(aj, i, -9223372036854775807L);
            }
        } catch (IndexOutOfBoundsException unused) {
            throw new AI(aj, ad.A00, ad.A01);
        }
    }

    private Pair<Integer, Long> A05(AbstractC0276Aj aj, int i, long j) {
        return aj.A08(this.A0M, this.A0L, i, j);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:73:0x01a6, code lost:
        if (r8 != false) goto L_0x01a8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:75:0x01ac, code lost:
        if (r16.A05.A00 != 3) goto L_0x01ae;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:77:0x01b2, code lost:
        if (r16.A05.A00 != 2) goto L_0x01bd;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:78:0x01b4, code lost:
        A0S(r2, 10);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:79:0x01b9, code lost:
        com.facebook.ads.redexgen.X.C0463Id.A00();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:80:0x01bc, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:82:0x01c0, code lost:
        if (r16.A0C.length == 0) goto L_0x01ce;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:84:0x01c6, code lost:
        if (r16.A05.A00 == 4) goto L_0x01ce;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:85:0x01c8, code lost:
        A0S(r2, 1000);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:86:0x01ce, code lost:
        r16.A0Q.ACN(2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:88:0x01e0, code lost:
        if (r8 != false) goto L_0x01a8;
     */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0099  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x0124  */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x01e3  */
    /* JADX WARNING: Removed duplicated region for block: B:94:0x0093 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void A07() {
        /*
        // Method dump skipped, instructions count: 495
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.CX.A07():void");
    }

    private void A08() {
        A0O(4);
        A0p(false, true, false);
    }

    private void A09() {
        AK A0G2 = this.A0K.A0G();
        long A072 = A0G2.A07();
        if (A072 == Long.MIN_VALUE) {
            A0l(false);
            return;
        }
        boolean AD8 = this.A0J.AD8(A072 - A0G2.A09(this.A03), this.A0G.A6l().A01);
        A0l(AD8);
        if (AD8) {
            A0G2.A0G(this.A03);
        }
    }

    private void A0A() {
        int i;
        if (this.A0I.A06(this.A05)) {
            Handler handler = this.A0E;
            int i2 = this.A0I.A01;
            if (this.A0I.A03) {
                i = this.A0I.A00;
            } else {
                i = -1;
            }
            handler.obtainMessage(0, i2, i, this.A05).sendToTarget();
            this.A0I.A05(this.A05);
        }
    }

    /* JADX INFO: Multiple debug info for r0v4 com.facebook.ads.redexgen.X.Xf: [D('renderer' com.facebook.ads.redexgen.X.Xf), D('readingPeriodHolder' com.facebook.ads.redexgen.X.AK)] */
    private void A0B() {
        AK A0G2 = this.A0K.A0G();
        AK A0I2 = this.A0K.A0I();
        if (!(A0G2 == null || A0G2.A06)) {
            if (A0I2 == null || A0I2.A01 == A0G2) {
                for (AbstractC0844Xf renderer : this.A0C) {
                    if (!renderer.A7K()) {
                        return;
                    }
                }
                A0G2.A08.A8V();
            }
        }
    }

    private void A0C() {
        this.A0K.A0N(this.A03);
        if (this.A0K.A0R()) {
            AL A0J2 = this.A0K.A0J(this.A03, this.A05);
            if (A0J2 == null) {
                this.A07.A8W();
                return;
            }
            this.A0K.A0L(this.A0U, this.A0N, this.A0J.A5M(), this.A07, this.A05.A03.A0B(A0J2.A04.A02, this.A0L, true).A03, A0J2).ABi(this, A0J2.A03);
            A0l(true);
        }
    }

    private void A0D() {
        A0p(true, true, true);
        this.A0J.AAj();
        A0O(1);
        this.A0F.quit();
        synchronized (this) {
            this.A0A = true;
            notifyAll();
        }
    }

    private void A0E() {
        boolean z;
        if (this.A0K.A0Q()) {
            float f = this.A0G.A6l().A01;
            AK A0H2 = this.A0K.A0H();
            AK A0I2 = this.A0K.A0I();
            boolean z2 = true;
            while (A0H2 != null && A0H2.A06) {
                if (A0H2.A0J(f)) {
                    if (z2) {
                        AK A0H3 = this.A0K.A0H();
                        boolean A0T2 = this.A0K.A0T(A0H3);
                        boolean[] zArr = new boolean[this.A0T.length];
                        long A0C2 = A0H3.A0C(this.A05.A0A, A0T2, zArr);
                        A0j(A0H3.A03, A0H3.A04);
                        if (!(this.A05.A00 == 4 || A0C2 == this.A05.A0A)) {
                            AO ao = this.A05;
                            this.A05 = ao.A04(ao.A04, A0C2, this.A05.A01);
                            this.A0I.A04(4);
                            A0Q(A0C2);
                        }
                        int i = 0;
                        boolean[] zArr2 = new boolean[this.A0T.length];
                        int i2 = 0;
                        while (true) {
                            AbstractC0844Xf[] xfArr = this.A0T;
                            if (i2 >= xfArr.length) {
                                this.A05 = this.A05.A05(A0H3.A03, A0H3.A04);
                                A0q(zArr2, i);
                                break;
                            }
                            AbstractC0844Xf xf = xfArr[i2];
                            if (xf.A70() != 0) {
                                z = true;
                            } else {
                                z = false;
                            }
                            zArr2[i2] = z;
                            AbstractC0387Fd fd = A0H3.A0A[i2];
                            if (fd != null) {
                                i++;
                            }
                            if (zArr2[i2]) {
                                AbstractC0387Fd A75 = xf.A75();
                                if (A0W[4].length() != 29) {
                                    String[] strArr = A0W;
                                    strArr[4] = "CIOLNyaJNw";
                                    strArr[4] = "CIOLNyaJNw";
                                    if (fd != A75) {
                                        A0c(xf);
                                    } else if (zArr[i2]) {
                                        xf.ACb(this.A03);
                                    }
                                } else {
                                    throw new RuntimeException();
                                }
                            }
                            i2++;
                        }
                    } else {
                        this.A0K.A0T(A0H2);
                        if (A0H2.A06) {
                            A0H2.A0B(Math.max(A0H2.A02.A03, A0H2.A09(this.A03)), false);
                            A0j(A0H2.A03, A0H2.A04);
                        }
                    }
                    if (this.A05.A00 != 4) {
                        A09();
                        A0J();
                        this.A0Q.ACp(2);
                        return;
                    }
                    return;
                }
                if (A0H2 == A0I2) {
                    z2 = false;
                }
                A0H2 = A0H2.A01;
            }
        }
    }

    private void A0F() {
        for (int size = this.A0R.size() - 1; size >= 0; size--) {
            if (!A0s(this.A0R.get(size))) {
                this.A0R.get(size).A03.A0A(false);
                this.A0R.remove(size);
            }
        }
        Collections.sort(this.A0R);
    }

    private void A0G() {
        this.A09 = false;
        this.A0G.A05();
        for (AbstractC0844Xf xf : this.A0C) {
            xf.start();
        }
    }

    private void A0H() {
        this.A0G.A06();
        for (AbstractC0844Xf xf : this.A0C) {
            A0d(xf);
        }
    }

    /* JADX INFO: Multiple debug info for r0v28 boolean: [D('renderer' com.facebook.ads.redexgen.X.Xf), D('rendererWasEnabled' boolean)] */
    /* JADX INFO: Multiple debug info for r0v42 com.facebook.ads.redexgen.X.Ad: [D('newConfig' com.facebook.ads.redexgen.X.Ad), D('newRendererEnabled' boolean)] */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x0152, code lost:
        if (r4 != 0) goto L_0x0154;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:94:0x01ed, code lost:
        if (r4 != 0) goto L_0x0154;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:95:0x01f1, code lost:
        r13 = false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void A0I() {
        /*
        // Method dump skipped, instructions count: 519
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.CX.A0I():void");
    }

    private void A0J() {
        long A0D2;
        if (this.A0K.A0Q()) {
            AK A0H2 = this.A0K.A0H();
            long AC1 = A0H2.A08.AC1();
            if (AC1 != -9223372036854775807L) {
                A0Q(AC1);
                if (AC1 != this.A05.A0A) {
                    AO ao = this.A05;
                    this.A05 = ao.A04(ao.A04, AC1, this.A05.A01);
                    this.A0I.A04(4);
                }
            } else {
                this.A03 = this.A0G.A04();
                long A092 = A0H2.A09(this.A03);
                A0R(this.A05.A0A, A092);
                this.A05.A0A = A092;
            }
            AO ao2 = this.A05;
            if (this.A0C.length == 0) {
                A0D2 = A0H2.A02.A01;
            } else {
                A0D2 = A0H2.A0D(true);
            }
            ao2.A09 = A0D2;
        }
    }

    private void A0M(float f) {
        for (AK A0F2 = this.A0K.A0F(); A0F2 != null; A0F2 = A0F2.A01) {
            if (A0F2.A04 != null) {
                H8[] A022 = A0F2.A04.A01.A02();
                for (H8 trackSelection : A022) {
                    if (trackSelection != null) {
                        trackSelection.AAU(f);
                    }
                }
            }
        }
    }

    private void A0N(int i) {
        this.A02 = i;
        if (!this.A0K.A0S(i)) {
            A0k(true);
        }
    }

    private void A0O(int i) {
        if (this.A05.A00 != i) {
            this.A05 = this.A05.A02(i);
        }
    }

    private void A0P(int i, boolean z, int i2) {
        boolean z2;
        boolean z3;
        AK A0H2 = this.A0K.A0H();
        AbstractC0844Xf xf = this.A0T[i];
        this.A0C[i2] = xf;
        if (xf.A70() == 0) {
            C0271Ad ad = A0H2.A04.A03[i];
            Format[] A0w = A0w(A0H2.A04.A01.A01(i));
            if (!this.A08 || this.A05.A00 != 3) {
                z2 = false;
            } else {
                z2 = true;
            }
            if (z || !z2) {
                z3 = false;
            } else {
                z3 = true;
            }
            xf.A4t(ad, A0w, A0H2.A0A[i], this.A03, z3, A0H2.A08());
            this.A0G.A09(xf);
            if (z2) {
                xf.start();
            }
        }
    }

    private void A0Q(long j) {
        if (this.A0K.A0Q()) {
            AK A0H2 = this.A0K.A0H();
            if (A0W[4].length() != 29) {
                String[] strArr = A0W;
                strArr[0] = "3Dp2X759xi1gKy2gc8ykMJ";
                strArr[7] = "GcHSrS1OF4oxjH6XmPjhKR";
                j = A0H2.A0A(j);
            } else {
                throw new RuntimeException();
            }
        }
        this.A03 = j;
        this.A0G.A07(this.A03);
        for (AbstractC0844Xf xf : this.A0C) {
            xf.ACb(this.A03);
        }
    }

    private void A0R(long j, long j2) {
        AB ab;
        AB ab2;
        if (!this.A0R.isEmpty() && !this.A05.A04.A02()) {
            if (this.A05.A02 == j) {
                j--;
            }
            int i = this.A05.A04.A02;
            int i2 = this.A00;
            if (i2 > 0) {
                ab = this.A0R.get(i2 - 1);
            } else {
                ab = null;
            }
            while (ab != null) {
                if (ab.A00 <= i) {
                    int i3 = ab.A00;
                    if (A0W[3].charAt(0) != 'c') {
                        String[] strArr = A0W;
                        strArr[0] = "ZbbXGQ7fBHqOH9bFx5EieA";
                        strArr[7] = "wqQaVgv9yDX8FIaCovLxd4";
                        if (i3 == i) {
                            if (ab.A01 <= j) {
                                break;
                            }
                        } else {
                            break;
                        }
                    } else {
                        throw new RuntimeException();
                    }
                }
                this.A00--;
                int i4 = this.A00;
                ab = i4 > 0 ? this.A0R.get(i4 - 1) : null;
            }
            if (this.A00 < this.A0R.size()) {
                ab2 = this.A0R.get(this.A00);
            } else {
                ab2 = null;
            }
            while (ab2 != null && ab2.A02 != null && (ab2.A00 < i || (ab2.A00 == i && ab2.A01 <= j))) {
                this.A00++;
                ab2 = this.A00 < this.A0R.size() ? this.A0R.get(this.A00) : null;
            }
            while (ab2 != null && ab2.A02 != null && ab2.A00 == i && ab2.A01 > j && ab2.A01 <= j2) {
                A0a(ab2.A03);
                if (ab2.A03.A0B() || ab2.A03.A0D()) {
                    this.A0R.remove(this.A00);
                } else {
                    this.A00++;
                }
                ab2 = this.A00 < this.A0R.size() ? this.A0R.get(this.A00) : null;
            }
        }
    }

    private void A0S(long j, long j2) {
        this.A0Q.ACN(2);
        this.A0Q.ACq(2, j + j2);
    }

    /* JADX INFO: Multiple debug info for r10v2 com.facebook.ads.redexgen.X.FG: [D('startPositionUs' long), D('contentPositionUs' long)] */
    private void A0T(AA aa) {
        Object playingPeriodUid;
        long j;
        long j2;
        long j3;
        long j4;
        long j5;
        if (aa.A01 == this.A07) {
            AbstractC0276Aj aj = this.A05.A03;
            AbstractC0276Aj aj2 = aa.A00;
            Object manifest = aa.A02;
            this.A0K.A0O(aj2);
            this.A05 = this.A05.A03(aj2, manifest);
            A0F();
            int i = this.A01;
            if (i > 0) {
                this.A0I.A03(i);
                this.A01 = 0;
                AD ad = this.A04;
                if (ad != null) {
                    Pair<Integer, Long> A042 = A04(ad, true);
                    this.A04 = null;
                    if (A042 == null) {
                        A08();
                        return;
                    }
                    int intValue = ((Integer) A042.first).intValue();
                    long longValue = ((Long) A042.second).longValue();
                    FG A0M2 = this.A0K.A0M(intValue, longValue);
                    AO ao = this.A05;
                    if (A0M2.A02()) {
                        j5 = 0;
                    } else {
                        j5 = longValue;
                    }
                    this.A05 = ao.A04(A0M2, j5, longValue);
                } else if (this.A05.A02 == -9223372036854775807L) {
                    boolean A0F2 = aj2.A0F();
                    String[] strArr = A0W;
                    if (strArr[1].charAt(27) != strArr[2].charAt(27)) {
                        String[] strArr2 = A0W;
                        strArr2[4] = "lH2oXw2RUPBHBuRA0";
                        strArr2[4] = "lH2oXw2RUPBHBuRA0";
                        if (A0F2) {
                            A08();
                            return;
                        }
                        Pair<Integer, Long> A052 = A05(aj2, aj2.A06(this.A0B), -9223372036854775807L);
                        int intValue2 = ((Integer) A052.first).intValue();
                        long longValue2 = ((Long) A052.second).longValue();
                        FG A0M3 = this.A0K.A0M(intValue2, longValue2);
                        AO ao2 = this.A05;
                        if (A0M3.A02()) {
                            j4 = 0;
                        } else {
                            j4 = longValue2;
                        }
                        this.A05 = ao2.A04(A0M3, j4, longValue2);
                        return;
                    }
                    throw new RuntimeException();
                }
            } else {
                int i2 = this.A05.A04.A02;
                long j6 = this.A05.A01;
                if (!aj.A0F()) {
                    AK A0F3 = this.A0K.A0F();
                    if (A0F3 == null) {
                        C0274Ah ah = this.A0L;
                        if (A0W[3].charAt(0) != 'c') {
                            String[] strArr3 = A0W;
                            strArr3[0] = "AIgzGczszMkheYOO0l2WDA";
                            strArr3[7] = "AQm6fITMTu1q9a2hy8bL0W";
                            playingPeriodUid = aj.A0B(i2, ah, true).A03;
                        } else {
                            String[] strArr4 = A0W;
                            strArr4[6] = "kxPd1uECtZJZCmNWUxsBgkB7loYAAl3C";
                            strArr4[6] = "kxPd1uECtZJZCmNWUxsBgkB7loYAAl3C";
                            playingPeriodUid = aj.A0B(i2, ah, true).A03;
                        }
                    } else {
                        playingPeriodUid = A0F3.A09;
                    }
                    int A053 = aj2.A05(playingPeriodUid);
                    if (A053 == -1) {
                        int A012 = A01(i2, aj, aj2);
                        if (A012 == -1) {
                            A08();
                            return;
                        }
                        Pair<Integer, Long> A054 = A05(aj2, aj2.A0A(A012, this.A0L).A00, -9223372036854775807L);
                        int intValue3 = ((Integer) A054.first).intValue();
                        long longValue3 = ((Long) A054.second).longValue();
                        FG A0M4 = this.A0K.A0M(intValue3, longValue3);
                        aj2.A0B(intValue3, this.A0L, true);
                        if (A0F3 != null) {
                            Object obj = this.A0L.A03;
                            A0F3.A02 = A0F3.A02.A00(-1);
                            while (A0F3.A01 != null) {
                                A0F3 = A0F3.A01;
                                if (A0F3.A09.equals(obj)) {
                                    A0F3.A02 = this.A0K.A0K(A0F3.A02, intValue3);
                                } else {
                                    A0F3.A02 = A0F3.A02.A00(-1);
                                }
                            }
                        }
                        if (A0M4.A02()) {
                            j2 = 0;
                        } else {
                            j2 = longValue3;
                        }
                        this.A05 = this.A05.A04(A0M4, A02(A0M4, j2), longValue3);
                        return;
                    }
                    if (A053 != i2) {
                        AO A013 = this.A05.A01(A053);
                        if (A0W[4].length() != 29) {
                            String[] strArr5 = A0W;
                            strArr5[4] = "bxSLNYRWzgoGTszax8Z4I";
                            strArr5[4] = "bxSLNYRWzgoGTszax8Z4I";
                            this.A05 = A013;
                        } else {
                            throw new RuntimeException();
                        }
                    }
                    FG fg = this.A05.A04;
                    if (fg.A02()) {
                        FG A0M5 = this.A0K.A0M(A053, j6);
                        if (!A0M5.equals(fg)) {
                            if (A0M5.A02()) {
                                j = 0;
                            } else {
                                j = j6;
                            }
                            this.A05 = this.A05.A04(A0M5, A02(A0M5, j), j6);
                            return;
                        }
                    }
                    if (!this.A0K.A0V(fg, this.A03)) {
                        A0k(false);
                    }
                } else if (!aj2.A0F()) {
                    FG A0M6 = this.A0K.A0M(i2, j6);
                    AO ao3 = this.A05;
                    if (A0M6.A02()) {
                        j3 = 0;
                    } else {
                        j3 = j6;
                    }
                    this.A05 = ao3.A04(A0M6, j3, j6);
                }
            }
        }
    }

    /* JADX INFO: Multiple debug info for r10v1 com.facebook.ads.redexgen.X.AK: [D('seekPositionAdjusted' boolean), D('periodIndex' int)] */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x011d  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x0134  */
    /* JADX WARNING: Removed duplicated region for block: B:63:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void A0U(com.facebook.ads.redexgen.X.AD r20) {
        /*
        // Method dump skipped, instructions count: 314
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.CX.A0U(com.facebook.ads.redexgen.X.AD):void");
    }

    private void A0W(AK ak) {
        boolean z;
        AK A0H2 = this.A0K.A0H();
        if (A0H2 != null && ak != A0H2) {
            int i = 0;
            boolean[] zArr = new boolean[this.A0T.length];
            int i2 = 0;
            while (true) {
                AbstractC0844Xf[] xfArr = this.A0T;
                if (i2 >= xfArr.length) {
                    break;
                }
                AbstractC0844Xf xf = xfArr[i2];
                if (xf.A70() != 0) {
                    z = true;
                } else {
                    z = false;
                }
                zArr[i2] = z;
                if (A0H2.A04.A00(i2)) {
                    i++;
                }
                if (zArr[i2] && (!A0H2.A04.A00(i2) || (xf.A7W() && xf.A75() == ak.A0A[i2]))) {
                    A0c(xf);
                }
                i2++;
            }
            AO ao = this.A05;
            if (A0W[6].charAt(23) != 'j') {
                String[] strArr = A0W;
                strArr[0] = "YeyTuc4hJN2cviDoFTSuVw";
                strArr[7] = "y3cCzPpceybwtUTWhAu8hu";
                this.A05 = ao.A05(A0H2.A03, A0H2.A04);
                A0q(zArr, i);
                return;
            }
            throw new RuntimeException();
        }
    }

    private void A0X(AP ap) {
        this.A0G.AD3(ap);
    }

    /* access modifiers changed from: public */
    private void A0Y(C0268Aa aa) {
        if (!aa.A0D()) {
            try {
                aa.A04().A7H(aa.A00(), aa.A09());
            } finally {
                aa.A0A(true);
            }
        }
    }

    private void A0Z(C0268Aa aa) {
        if (aa.A02() == -9223372036854775807L) {
            A0a(aa);
        } else if (this.A07 == null || this.A01 > 0) {
            this.A0R.add(new AB(aa));
        } else {
            AB ab = new AB(aa);
            if (A0s(ab)) {
                ArrayList<AB> arrayList = this.A0R;
                String[] strArr = A0W;
                if (strArr[0].length() != strArr[7].length()) {
                    throw new RuntimeException();
                }
                String[] strArr2 = A0W;
                strArr2[6] = "bdowkwDe22b4JBVUMCxt2Emm6YTTpUJh";
                strArr2[6] = "bdowkwDe22b4JBVUMCxt2Emm6YTTpUJh";
                arrayList.add(ab);
                Collections.sort(this.A0R);
                return;
            }
            aa.A0A(false);
        }
    }

    private void A0a(C0268Aa aa) {
        if (aa.A03().getLooper() == this.A0Q.A6U()) {
            A0Y(aa);
            if (this.A05.A00 == 3 || this.A05.A00 == 2) {
                this.A0Q.ACp(2);
                return;
            }
            return;
        }
        this.A0Q.A8e(15, aa).sendToTarget();
    }

    private void A0b(C0268Aa aa) {
        aa.A03().post(new A9(this, aa));
    }

    private void A0c(AbstractC0844Xf xf) {
        this.A0G.A08(xf);
        A0d(xf);
        xf.A4k();
    }

    private void A0d(AbstractC0844Xf xf) {
        if (xf.A70() == 2) {
            xf.stop();
        }
    }

    private void A0e(C0273Af af) {
        this.A06 = af;
    }

    private void A0f(AbstractC0907Zu zu) {
        if (this.A0K.A0U(zu)) {
            this.A0K.A0N(this.A03);
            A09();
        }
    }

    private void A0g(AbstractC0907Zu zu) {
        if (this.A0K.A0U(zu)) {
            AK A0G2 = this.A0K.A0G();
            A0G2.A0F(this.A0G.A6l().A01);
            A0j(A0G2.A03, A0G2.A04);
            if (!this.A0K.A0Q()) {
                A0Q(this.A0K.A0D().A02.A03);
                A0W(null);
            }
            A09();
        }
    }

    /* access modifiers changed from: public */
    /* access modifiers changed from: private */
    /* renamed from: A0h */
    public final void A9F(AbstractC0907Zu zu) {
        this.A0Q.A8e(10, zu).sendToTarget();
    }

    private void A0i(FI fi, boolean z, boolean z2) {
        this.A01++;
        A0p(true, z, z2);
        this.A0J.onPrepared();
        this.A07 = fi;
        A0O(2);
        fi.ABl(this.A0H, true, this);
        this.A0Q.ACp(2);
    }

    private void A0j(TrackGroupArray trackGroupArray, HC hc) {
        this.A0J.AB8(this.A0T, trackGroupArray, hc.A01);
    }

    private void A0k(boolean z) {
        FG fg = this.A0K.A0H().A02.A04;
        long A032 = A03(fg, this.A05.A0A, true);
        if (A032 != this.A05.A0A) {
            AO ao = this.A05;
            this.A05 = ao.A04(fg, A032, ao.A01);
            if (z) {
                this.A0I.A04(4);
            }
        }
    }

    private void A0l(boolean z) {
        if (this.A05.A08 != z) {
            this.A05 = this.A05.A06(z);
        }
    }

    private void A0m(boolean z) {
        this.A09 = false;
        this.A08 = z;
        if (!z) {
            A0H();
            A0J();
        } else if (this.A05.A00 == 3) {
            A0G();
            if (A0W[4].length() != 29) {
                String[] strArr = A0W;
                strArr[6] = "X2QfJ1e23pCpGilE5nvaFXYxLnWx3Vax";
                strArr[6] = "X2QfJ1e23pCpGilE5nvaFXYxLnWx3Vax";
                this.A0Q.ACp(2);
                return;
            }
            throw new RuntimeException();
        } else if (this.A05.A00 == 2) {
            this.A0Q.ACp(2);
        }
    }

    private void A0n(boolean z) {
        this.A0B = z;
        if (!this.A0K.A0W(z)) {
            A0k(true);
        }
    }

    private void A0o(boolean z, boolean z2) {
        A0p(true, z, z);
        this.A0I.A03(this.A01 + (z2 ? 1 : 0));
        this.A01 = 0;
        this.A0J.AB2();
        A0O(1);
    }

    private void A0p(boolean z, boolean z2, boolean z3) {
        AbstractC0276Aj aj;
        FG fg;
        TrackGroupArray trackGroupArray;
        HC hc;
        FI fi;
        this.A0Q.ACN(2);
        this.A09 = false;
        this.A0G.A06();
        this.A03 = 0;
        for (AbstractC0844Xf renderer : this.A0C) {
            try {
                A0c(renderer);
            } catch (A4 | RuntimeException e) {
                Log.e(A06(0, 21, 15), A06(138, 12, 123), e);
            }
        }
        this.A0C = new AbstractC0844Xf[0];
        AM am = this.A0K;
        String[] strArr = A0W;
        if (strArr[1].charAt(27) != strArr[2].charAt(27)) {
            String[] strArr2 = A0W;
            strArr2[0] = "2WNzaDjkqcOaPFAy0QOPwI";
            strArr2[7] = "unAKX8spYNQMyMddShLfR5";
            am.A0P(!z2);
            A0l(false);
            if (z2) {
                this.A04 = null;
            }
            if (z3) {
                this.A0K.A0O(AbstractC0276Aj.A01);
                Iterator<AB> it = this.A0R.iterator();
                while (it.hasNext()) {
                    AB next = it.next();
                    if (A0W[5].length() != 18) {
                        throw new RuntimeException();
                    }
                    String[] strArr3 = A0W;
                    strArr3[6] = "oYGfQB8mGDj6jmVX6XAe4nZE0DoRm7Og";
                    strArr3[6] = "oYGfQB8mGDj6jmVX6XAe4nZE0DoRm7Og";
                    next.A03.A0A(false);
                }
                this.A0R.clear();
                this.A00 = 0;
            }
            if (z3) {
                aj = AbstractC0276Aj.A01;
            } else {
                aj = this.A05.A03;
            }
            Object obj = z3 ? null : this.A05.A07;
            if (z2) {
                fg = new FG(A00());
            } else {
                fg = this.A05.A04;
            }
            long j = -9223372036854775807L;
            long j2 = z2 ? -9223372036854775807L : this.A05.A0A;
            if (!z2) {
                j = this.A05.A01;
            }
            int i = this.A05.A00;
            if (z3) {
                trackGroupArray = TrackGroupArray.A04;
            } else {
                AO ao = this.A05;
                if (A0W[5].length() != 18) {
                    trackGroupArray = ao.A05;
                } else {
                    String[] strArr4 = A0W;
                    strArr4[1] = "udHBd6VluCWpjwypGpbQkm44C5lEXr7W";
                    strArr4[2] = "ikIjUWR3chEMULYYaopllYxVSgtPleKx";
                    trackGroupArray = ao.A05;
                }
            }
            if (z3) {
                hc = this.A0O;
            } else {
                hc = this.A05.A06;
            }
            this.A05 = new AO(aj, obj, fg, j2, j, i, false, trackGroupArray, hc);
            if (z && (fi = this.A07) != null) {
                fi.ACK(this);
                this.A07 = null;
                return;
            }
            return;
        }
        throw new RuntimeException();
    }

    private void A0q(boolean[] zArr, int i) {
        this.A0C = new AbstractC0844Xf[i];
        int enabledRendererCount = 0;
        AK A0H2 = this.A0K.A0H();
        for (int i2 = 0; i2 < this.A0T.length; i2++) {
            if (A0H2.A04.A00(i2)) {
                A0P(i2, zArr[i2], enabledRendererCount);
                enabledRendererCount++;
            }
        }
    }

    private boolean A0r() {
        AK A0H2 = this.A0K.A0H();
        long j = A0H2.A02.A01;
        return j == -9223372036854775807L || this.A05.A0A < j || (A0H2.A01 != null && (A0H2.A01.A06 || A0H2.A01.A02.A04.A02()));
    }

    /* JADX INFO: Multiple debug info for r7v0 'this'  com.facebook.ads.redexgen.X.CX: [D('periodPosition' android.util.Pair<java.lang.Integer, java.lang.Long>), D('index' int)] */
    private boolean A0s(AB ab) {
        if (ab.A02 == null) {
            Pair<Integer, Long> A042 = A04(new AD(ab.A03.A08(), ab.A03.A01(), C02669y.A00(ab.A03.A02())), false);
            if (A042 == null) {
                return false;
            }
            ab.A01(((Integer) A042.first).intValue(), ((Long) A042.second).longValue(), this.A05.A03.A0B(((Integer) A042.first).intValue(), this.A0L, true).A03);
        } else {
            int A052 = this.A05.A03.A05(ab.A02);
            if (A052 == -1) {
                return false;
            }
            ab.A00 = A052;
        }
        return true;
    }

    private boolean A0t(AbstractC0844Xf xf) {
        AK A0I2 = this.A0K.A0I();
        return A0I2.A01 != null && A0I2.A01.A06 && xf.A7K();
    }

    private boolean A0u(FG fg, long j, AK ak) {
        if (!fg.equals(ak.A02.A04) || !ak.A06) {
            return false;
        }
        this.A05.A03.A0A(ak.A02.A04.A02, this.A0L);
        int A042 = this.A0L.A04(j);
        if (A042 == -1 || this.A0L.A09(A042) == ak.A02.A02) {
            return true;
        }
        return false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x006d, code lost:
        if (r3 != Long.MIN_VALUE) goto L_0x006f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x00a3, code lost:
        if (r3 != Long.MIN_VALUE) goto L_0x006f;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean A0v(boolean r8) {
        /*
        // Method dump skipped, instructions count: 166
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.CX.A0v(boolean):boolean");
    }

    public static Format[] A0w(H8 h8) {
        int i;
        if (h8 != null) {
            i = h8.length();
        } else {
            i = 0;
        }
        Format[] formatArr = new Format[i];
        for (int i2 = 0; i2 < i; i2++) {
            formatArr[i2] = h8.A6J(i2);
            if (A0W[3].charAt(0) != 'c') {
                String[] strArr = A0W;
                strArr[1] = "cHoAaTwhCyKnC5gIlgOheFkD17ImOLE4";
                strArr[2] = "NdVO49IoL7wvUQC4on3mokgCd3AJvc50";
            } else {
                throw new RuntimeException();
            }
        }
        return formatArr;
    }

    public final Looper A0x() {
        return this.A0F.getLooper();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x002e, code lost:
        if (com.facebook.ads.redexgen.X.CX.A0W[3].charAt(0) == 'c') goto L_0x003d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0030, code lost:
        r2 = com.facebook.ads.redexgen.X.CX.A0W;
        r2[5] = "ci8xVCbgf6WZorAiSg";
        r2[5] = "ci8xVCbgf6WZorAiSg";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x003c, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0042, code lost:
        throw new java.lang.RuntimeException();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void A0y() {
        /*
            r3 = this;
            monitor-enter(r3)
            boolean r0 = r3.A0A     // Catch:{ all -> 0x0043 }
            if (r0 == 0) goto L_0x0007
            monitor-exit(r3)
            return
        L_0x0007:
            com.facebook.ads.redexgen.X.IE r1 = r3.A0Q
            r0 = 7
            r1.ACp(r0)
            r1 = 0
        L_0x000e:
            boolean r0 = r3.A0A
            if (r0 != 0) goto L_0x0018
            r3.wait()     // Catch:{ InterruptedException -> 0x0016 }
            goto L_0x000e
        L_0x0016:
            r1 = 1
            goto L_0x000e
        L_0x0018:
            if (r1 == 0) goto L_0x0021
            java.lang.Thread r0 = java.lang.Thread.currentThread()
            r0.interrupt()
        L_0x0021:
            monitor-exit(r3)
            java.lang.String[] r1 = com.facebook.ads.redexgen.X.CX.A0W
            r0 = 3
            r1 = r1[r0]
            r0 = 0
            char r1 = r1.charAt(r0)
            r0 = 99
            if (r1 == r0) goto L_0x003d
            java.lang.String[] r2 = com.facebook.ads.redexgen.X.CX.A0W
            java.lang.String r1 = "ci8xVCbgf6WZorAiSg"
            r0 = 5
            r2[r0] = r1
            java.lang.String r1 = "ci8xVCbgf6WZorAiSg"
            r0 = 5
            r2[r0] = r1
            return
        L_0x003d:
            java.lang.RuntimeException r0 = new java.lang.RuntimeException
            r0.<init>()
            throw r0
        L_0x0043:
            r0 = move-exception
            monitor-exit(r3)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.CX.A0y():void");
    }

    public final void A0z(AbstractC0276Aj aj, int i, long j) {
        this.A0Q.A8e(3, new AD(aj, i, j)).sendToTarget();
    }

    public final void A10(FI fi, boolean z, boolean z2) {
        this.A0Q.A8d(0, z ? 1 : 0, z2 ? 1 : 0, fi).sendToTarget();
    }

    public final void A11(boolean z) {
        this.A0Q.A8c(1, z ? 1 : 0, 0).sendToTarget();
    }

    public final void A12(boolean z) {
        this.A0Q.A8c(6, z ? 1 : 0, 0).sendToTarget();
    }

    @Override // com.facebook.ads.redexgen.X.A1
    public final void AAT(AP ap) {
        this.A0E.obtainMessage(1, ap).sendToTarget();
        A0M(ap.A01);
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC0906Zt
    public final void AAb(AbstractC0907Zu zu) {
        this.A0Q.A8e(9, zu).sendToTarget();
    }

    @Override // com.facebook.ads.redexgen.X.FH
    public final void AAx(FI fi, AbstractC0276Aj aj, Object obj) {
        this.A0Q.A8e(8, new AA(fi, aj, obj)).sendToTarget();
    }

    @Override // com.facebook.ads.redexgen.X.AY
    public final synchronized void ACr(C0268Aa aa) {
        if (this.A0A) {
            Log.w(A06(0, 21, 15), A06(50, 37, 50));
            aa.A0A(false);
            return;
        }
        this.A0Q.A8e(14, aa).sendToTarget();
    }

    public final boolean handleMessage(Message message) {
        String A062 = A06(0, 21, 15);
        try {
            switch (message.what) {
                case 0:
                    A0i((FI) message.obj, message.arg1 != 0, message.arg2 != 0);
                    break;
                case 1:
                    A0m(message.arg1 != 0);
                    break;
                case 2:
                    A07();
                    break;
                case 3:
                    A0U((AD) message.obj);
                    break;
                case 4:
                    A0X((AP) message.obj);
                    break;
                case 5:
                    A0e((C0273Af) message.obj);
                    break;
                case 6:
                    A0o(message.arg1 != 0, true);
                    break;
                case 7:
                    A0D();
                    return true;
                case 8:
                    A0T((AA) message.obj);
                    break;
                case 9:
                    A0g((AbstractC0907Zu) message.obj);
                    break;
                case 10:
                    A0f((AbstractC0907Zu) message.obj);
                    break;
                case 11:
                    A0E();
                    break;
                case 12:
                    A0N(message.arg1);
                    break;
                case 13:
                    A0n(message.arg1 != 0);
                    break;
                case 14:
                    A0Z((C0268Aa) message.obj);
                    break;
                case 15:
                    A0b((C0268Aa) message.obj);
                    break;
                default:
                    return false;
            }
            A0A();
        } catch (A4 e) {
            Log.e(A062, A06(110, 15, 0), e);
            A0o(false, false);
            this.A0E.obtainMessage(2, e).sendToTarget();
            A0A();
        } catch (IOException e2) {
            Log.e(A062, A06(125, 13, 87), e2);
            A0o(false, false);
            this.A0E.obtainMessage(2, A4.A00(e2)).sendToTarget();
            A0A();
        } catch (RuntimeException e3) {
            Log.e(A062, A06(87, 23, 108), e3);
            A0o(false, false);
            this.A0E.obtainMessage(2, A4.A02(e3)).sendToTarget();
            if (A0W[6].charAt(23) != 'j') {
                String[] strArr = A0W;
                strArr[5] = "BLVAUEtDSJNWXrvjpr";
                strArr[5] = "BLVAUEtDSJNWXrvjpr";
                A0A();
            } else {
                throw new RuntimeException();
            }
        }
        return true;
    }
}
