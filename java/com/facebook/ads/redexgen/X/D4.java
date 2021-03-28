package com.facebook.ads.redexgen.X;

import java.io.IOException;
import java.util.Arrays;

public final class D4 {
    public static byte[] A00;
    public static String[] A01;
    public static final int[] A02 = {C0466Ig.A08(A00(79, 4, 5)), C0466Ig.A08(A00(59, 4, 48)), C0466Ig.A08(A00(63, 4, 66)), C0466Ig.A08(A00(67, 4, 105)), C0466Ig.A08(A00(71, 4, 38)), C0466Ig.A08(A00(75, 4, 8)), C0466Ig.A08(A00(43, 4, 14)), C0466Ig.A08(A00(55, 4, 15)), C0466Ig.A08(A00(51, 4, 17)), C0466Ig.A08(A00(87, 4, 61)), C0466Ig.A08(A00(91, 4, 64)), C0466Ig.A08(A00(0, 4, 71)), C0466Ig.A08(A00(4, 4, 119)), C0466Ig.A08(A00(19, 4, 22)), C0466Ig.A08(A00(23, 4, 6)), C0466Ig.A08(A00(8, 4, 99)), C0466Ig.A08(A00(12, 4, 29)), C0466Ig.A08(A00(31, 4, 55)), C0466Ig.A08(A00(27, 4, 15)), C0466Ig.A08(A00(47, 4, 45)), C0466Ig.A08(A00(83, 4, 104)), C0466Ig.A08(A00(35, 4, 68)), C0466Ig.A08(A00(95, 4, 62)), C0466Ig.A08(A00(39, 4, 23))};

    public static String A00(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A00, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] ^ i3) ^ 63);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A00 = new byte[]{75, 31, 74, 25, 123, 47, 122, 42, 111, 59, 57, 106, 17, 69, 69, 20, 58, 110, 121, 26, 78, 91, 31, 10, 94, 74, 15, 125, 4, 113, 16, 69, 60, 94, 40, 54, 79, 45, 43, 101, 123, 102, 126, 80, 71, 82, 0, 116, 38, 100, 50, 70, 75, 88, 31, 88, 70, 83, 1, 102, 124, 96, 61, 20, 14, 18, 78, 63, 37, 57, 98, 112, 106, 118, 44, 94, 68, 88, 1, 83, 73, 85, 87, 60, 51, 51, 62, 111, 114, 54, 51, 18, 15, 75, 77, 112, 117, 33, 33};
        if (A01[3].charAt(26) != 'I') {
            throw new RuntimeException();
        }
        String[] strArr = A01;
        strArr[3] = "d1bTlggiE4vYEwLxNU00WUvkcSIuSb2g";
        strArr[3] = "d1bTlggiE4vYEwLxNU00WUvkcSIuSb2g";
    }

    public static void A02() {
        A01 = new String[]{"3vAPqkZTJ1VSon", "QUTM7SdDWyFumvZa4ixbAFeRkcyJbQtu", "xie3JnTyZ8PkMdNBWExCsKsV5Mn", "WzqQT7JP0s6wyXASN6VfDx7AAKIr1zQR", "8xy", "R913nsbqijjrVtiNLSpVoV0rL8armwI", "xGv", "6Jbm"};
    }

    static {
        A02();
        A01();
    }

    public static boolean A03(int i) {
        if ((i >>> 8) == C0466Ig.A08(A00(16, 3, 54))) {
            return true;
        }
        int[] iArr = A02;
        String[] strArr = A01;
        if (strArr[6].length() != strArr[4].length()) {
            throw new RuntimeException();
        }
        String[] strArr2 = A01;
        strArr2[5] = "EPRlEFMBD24k0biyd";
        strArr2[5] = "EPRlEFMBD24k0biyd";
        for (int compatibleBrand : iArr) {
            if (compatibleBrand == i) {
                return true;
            }
        }
        return false;
    }

    public static boolean A04(CL cl) throws IOException, InterruptedException {
        return A06(cl, true);
    }

    public static boolean A05(CL cl) throws IOException, InterruptedException {
        return A06(cl, false);
    }

    /* JADX INFO: Multiple debug info for r6v1 int: [D('atomDataSize' int), D('buffer' com.facebook.ads.redexgen.X.IQ)] */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x009e, code lost:
        if (r13 != r16) goto L_0x00a0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x00b7, code lost:
        if (r13 != r16) goto L_0x00a0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean A06(com.facebook.ads.redexgen.X.CL r17, boolean r18) throws java.io.IOException, java.lang.InterruptedException {
        /*
        // Method dump skipped, instructions count: 295
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.D4.A06(com.facebook.ads.redexgen.X.CL, boolean):boolean");
    }
}
