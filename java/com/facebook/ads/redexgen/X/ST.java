package com.facebook.ads.redexgen.X;

import java.util.Arrays;

public class ST implements AnonymousClass4D {
    public static byte[] A04;
    public static String[] A05;
    public int A00;
    public int A01;
    public int A02;
    public int[] A03;

    static {
        A02();
        A01();
    }

    public static String A00(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A04, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] - i3) - 83);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A04 = new byte[]{-87, -66, -42, -52, -46, -47, 125, -51, -52, -48, -58, -47, -58, -52, -53, -48, 125, -54, -46, -48, -47, 125, -65, -62, 125, -53, -52, -53, -118, -53, -62, -60, -66, -47, -58, -45, -62, -60, -35, -20, -39, -32, -108, -40, -35, -25, -24, -43, -30, -41, -39, -108, -31, -23, -25, -24, -108, -42, -39, -108, -30, -29, -30, -95, -30, -39, -37, -43, -24, -35, -22, -39};
    }

    public static void A02() {
        A05 = new String[]{"yYJ6SOT3uDFyj2TBTti7WWfRsn28EaA0", "ibfMp1J9gSZsYrxVf4NvaZx8D9JO1QBg", "rjgnGVcZwB7yGoiyculy9B4zYqmoHpCR", "", "BFeMqfRovMahqpkErO60kJAdny9RRdno", "ZwvbtEc0kmFFJCTTqnK3GQ6ySyfI7Whf", "3RaP0tr92GxZHPCEm9", "lHI5DV8"};
    }

    public final void A03() {
        int[] iArr = this.A03;
        if (iArr != null) {
            if (A05[7].length() != 7) {
                throw new RuntimeException();
            }
            String[] strArr = A05;
            strArr[7] = "V5jR13F";
            strArr[7] = "V5jR13F";
            Arrays.fill(iArr, -1);
        }
        this.A00 = 0;
    }

    public final void A04(int i, int i2) {
        this.A01 = i;
        this.A02 = i2;
    }

    public final void A05(ES es, boolean z) {
        this.A00 = 0;
        int[] iArr = this.A03;
        if (iArr != null) {
            Arrays.fill(iArr, -1);
        }
        AnonymousClass4F r3 = es.A06;
        if (es.A04 != null && r3 != null && r3.A1Z()) {
            if (z) {
                boolean A0K = es.A00.A0K();
                String[] strArr = A05;
                if (strArr[0].charAt(30) != strArr[5].charAt(30)) {
                    String[] strArr2 = A05;
                    strArr2[7] = "b5aEeD0";
                    strArr2[7] = "b5aEeD0";
                    if (!A0K) {
                        r3.A1w(es.A04.A0E(), this);
                    }
                }
                throw new RuntimeException();
            } else if (!es.A1u()) {
                r3.A1v(this.A01, this.A02, es.A0s, this);
            }
            int i = this.A00;
            int i2 = r3.A00;
            String[] strArr3 = A05;
            if (strArr3[3].length() != strArr3[6].length()) {
                String[] strArr4 = A05;
                strArr4[7] = "TjVTm35";
                strArr4[7] = "TjVTm35";
                if (i > i2) {
                    r3.A00 = this.A00;
                    r3.A08 = z;
                    es.A0r.A0P();
                    return;
                }
                return;
            }
            throw new RuntimeException();
        }
    }

    public final boolean A06(int i) {
        if (this.A03 == null) {
            return false;
        }
        int i2 = this.A00 * 2;
        for (int i3 = 0; i3 < i2; i3 += 2) {
            if (this.A03[i3] == i) {
                String[] strArr = A05;
                if (strArr[0].charAt(30) != strArr[5].charAt(30)) {
                    String[] strArr2 = A05;
                    strArr2[2] = "SVfMGWcG5IEJEA83X9P3956xbutBXkdM";
                    strArr2[2] = "SVfMGWcG5IEJEA83X9P3956xbutBXkdM";
                    return true;
                }
                throw new RuntimeException();
            }
        }
        return false;
    }

    @Override // com.facebook.ads.redexgen.X.AnonymousClass4D
    public final void A3J(int i, int i2) {
        if (i < 0) {
            throw new IllegalArgumentException(A00(0, 37, 10));
        } else if (i2 >= 0) {
            int i3 = this.A00 * 2;
            int[] iArr = this.A03;
            if (iArr == null) {
                this.A03 = new int[4];
                Arrays.fill(this.A03, -1);
            } else if (i3 >= iArr.length) {
                int[] iArr2 = this.A03;
                this.A03 = new int[(i3 * 2)];
                System.arraycopy(iArr2, 0, this.A03, 0, iArr2.length);
            }
            int[] iArr3 = this.A03;
            iArr3[i3] = i;
            iArr3[i3 + 1] = i2;
            this.A00++;
        } else {
            throw new IllegalArgumentException(A00(37, 35, 33));
        }
    }
}
