package com.facebook.ads.redexgen.X;

/* renamed from: com.facebook.ads.redexgen.X.Cu  reason: case insensitive filesystem */
public final class C0330Cu {
    public static String[] A00;

    static {
        A01();
    }

    public static void A01() {
        A00 = new String[]{"5xEbc1UmueoelDSrZ01pbd3BmJNIPp1U", "V2pwOmwpGDtIWtnsLDXNbgXk3OH02STy", "ZygQfCeNfaSOACHLv", "IIEFhzt6S27nqtVGpISchgUV1ko256DH", "7IV1id8R", "S", "X", "3B1kWjUEw7n1jDPOxVE4cJw7NZn0CFn3"};
    }

    public static C0329Ct A00(int i, long[] jArr, int[] iArr, long j) {
        int i2 = 8192 / i;
        int i3 = 0;
        for (int i4 : iArr) {
            i3 += C0466Ig.A04(i4, i2);
        }
        long[] jArr2 = new long[i3];
        String[] strArr = A00;
        if (strArr[5].length() != strArr[6].length()) {
            throw new RuntimeException();
        }
        String[] strArr2 = A00;
        strArr2[4] = "MOnhYedn";
        strArr2[2] = "VzeyWK1Y20Sbegflw";
        int[] iArr2 = new int[i3];
        int i5 = 0;
        long[] jArr3 = new long[i3];
        int[] iArr3 = new int[i3];
        int i6 = 0;
        int i7 = 0;
        for (int chunkIndex = 0; chunkIndex < iArr.length; chunkIndex++) {
            int maximumSize = iArr[chunkIndex];
            long j2 = jArr[chunkIndex];
            while (maximumSize > 0) {
                int min = Math.min(i2, maximumSize);
                jArr2[i7] = j2;
                iArr2[i7] = i * min;
                i5 = Math.max(i5, iArr2[i7]);
                jArr3[i7] = ((long) i6) * j;
                iArr3[i7] = 1;
                j2 += (long) iArr2[i7];
                i6 += min;
                maximumSize -= min;
                i7++;
            }
        }
        return new C0329Ct(jArr2, iArr2, i5, jArr3, iArr3, j * ((long) i6));
    }
}
