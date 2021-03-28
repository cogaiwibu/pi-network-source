package com.facebook.ads.redexgen.X;

import android.util.SparseArray;
import android.util.SparseBooleanArray;
import android.util.SparseIntArray;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public final class ZD implements CK {
    public static byte[] A0C;
    public static String[] A0D;
    public static final CN A0E = new ZA();
    public static final long A0F = ((long) C0466Ig.A08(A0D(0, 4, 26)));
    public static final long A0G = ((long) C0466Ig.A08(A0D(62, 4, 14)));
    public static final long A0H = ((long) C0466Ig.A08(A0D(66, 4, 48)));
    public int A00;
    public int A01;
    public CM A02;
    public AbstractC0341Df A03;
    public boolean A04;
    public final int A05;
    public final SparseArray<AbstractC0341Df> A06;
    public final SparseBooleanArray A07;
    public final SparseIntArray A08;
    public final AbstractC0339Dd A09;
    public final IQ A0A;
    public final List<C0462Ic> A0B;

    public static String A0D(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A0C, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] - i3) - 75);
        }
        return new String(copyOfRange);
    }

    public static void A0G() {
        A0C = new byte[]{-90, -88, -110, -104, -12, 18, 31, 31, 32, 37, -47, 23, 26, 31, 21, -47, 36, 42, 31, 20, -47, 19, 42, 37, 22, -33, -47, -2, 32, 36, 37, -47, 29, 26, 28, 22, 29, 42, -47, 31, 32, 37, -47, 18, -47, 5, 35, 18, 31, 36, 33, 32, 35, 37, -47, 4, 37, 35, 22, 18, 30, -33, -98, -102, -100, -116, -61, -64, -47, -66};
    }

    public static void A0H() {
        A0D = new String[]{"1wQJeguTcmzEzlcqQISF6uciTtBYCHEI", "1z5HoD8RnfRsH4NGqOJrgtDb3AvWKmRf", "OZb5z3fyn7DmUcX5PD2FSiUNDYO3SJGv", "xysXnf11fptxvGLEVlqKxNXP96VBbPb9", "B9gj7Y4phCIGiISa5KNqUW4wq7x20Uai", "0XWjmjuElj7dnGBGcTqheWJCaJtkSIxV", "xem2h", "3rpnxRNe64JCaC2IexlmS1y9p5GeiPOv"};
    }

    static {
        A0H();
        A0G();
    }

    public ZD() {
        this(0);
    }

    public ZD(int i) {
        this(1, i);
    }

    public ZD(int i, int i2) {
        this(i, new C0462Ic(0), new C0887Yw(i2));
    }

    public ZD(int i, C0462Ic ic, AbstractC0339Dd dd) {
        this.A09 = (AbstractC0339Dd) I1.A01(dd);
        this.A05 = i;
        if (i == 1 || i == 2) {
            this.A0B = Collections.singletonList(ic);
        } else {
            this.A0B = new ArrayList();
            this.A0B.add(ic);
        }
        this.A0A = new IQ(new byte[9400], 0);
        this.A07 = new SparseBooleanArray();
        this.A06 = new SparseArray<>();
        this.A08 = new SparseIntArray();
        A0F();
    }

    public static /* synthetic */ int A01(ZD zd) {
        int i = zd.A01;
        zd.A01 = i + 1;
        return i;
    }

    private void A0F() {
        this.A07.clear();
        this.A06.clear();
        SparseArray<AbstractC0341Df> A4J = this.A09.A4J();
        int size = A4J.size();
        for (int i = 0; i < size; i++) {
            this.A06.put(A4J.keyAt(i), A4J.valueAt(i));
        }
        this.A06.put(0, new Z8(new ZB(this)));
        this.A03 = null;
    }

    @Override // com.facebook.ads.redexgen.X.CK
    public final void A7Q(CM cm) {
        this.A02 = cm;
        cm.ACk(new YH(-9223372036854775807L));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:56:0x0117, code lost:
        if (r8 == r9) goto L_0x0119;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x0125, code lost:
        if (r8 == r9) goto L_0x0119;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x0128, code lost:
        r8 = (r8 + 1) & 15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x0138, code lost:
        if (com.facebook.ads.redexgen.X.ZD.A0D[1].charAt(3) == 72) goto L_0x0140;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x013f, code lost:
        throw new java.lang.RuntimeException();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x0140, code lost:
        r2 = com.facebook.ads.redexgen.X.ZD.A0D;
        r2[3] = "dSZ0cSzoMmmORQANAKDw4NsHeD3mI6Jb";
        r2[3] = "dSZ0cSzoMmmORQANAKDw4NsHeD3mI6Jb";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x014c, code lost:
        if (r9 == r8) goto L_0x0151;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x014e, code lost:
        r3.ACi();
     */
    @Override // com.facebook.ads.redexgen.X.CK
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int ABx(com.facebook.ads.redexgen.X.CL r14, com.facebook.ads.redexgen.X.CR r15) throws java.io.IOException, java.lang.InterruptedException {
        /*
        // Method dump skipped, instructions count: 372
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.ZD.ABx(com.facebook.ads.redexgen.X.CL, com.facebook.ads.redexgen.X.CR):int");
    }

    @Override // com.facebook.ads.redexgen.X.CK
    public final void ACj(long j, long j2) {
        int size = this.A0B.size();
        for (int i = 0; i < size; i++) {
            this.A0B.get(i).A09();
        }
        this.A0A.A0W();
        this.A08.clear();
        A0F();
        this.A00 = 0;
    }

    @Override // com.facebook.ads.redexgen.X.CK
    public final boolean ADH(CL cl) throws IOException, InterruptedException {
        byte[] bArr = this.A0A.A00;
        cl.ABZ(bArr, 0, 940);
        int i = 0;
        while (A0D[1].charAt(3) == 'H') {
            String[] strArr = A0D;
            strArr[1] = "vUfHgSsJvwNFwwToyev4j8iiTP0xmLzC";
            strArr[1] = "vUfHgSsJvwNFwwToyev4j8iiTP0xmLzC";
            if (i >= 188) {
                return false;
            }
            for (int i2 = 0; i2 != 5; i2++) {
                if (bArr[(i2 * 188) + i] != 71) {
                    i++;
                }
            }
            cl.ADG(i);
            return true;
        }
        throw new RuntimeException();
    }
}
