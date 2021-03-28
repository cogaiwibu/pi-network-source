package com.facebook.ads.redexgen.X;

import java.util.Arrays;

/* renamed from: com.facebook.ads.redexgen.X.67  reason: invalid class name */
public enum AnonymousClass67 {
    A04(A00(173, 14, 110)),
    A0A(A00(330, 19, 119)),
    A06(A00(227, 15, 121)),
    A07(A00(242, 38, 10)),
    A09(A00(293, 37, 70)),
    A05(A00(187, 40, 27)),
    A08(A00(280, 13, 77));
    
    public static byte[] A01;
    public static String[] A02;
    public final String A00;

    public static String A00(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A01, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] - i3) - 70);
            String[] strArr = A02;
            if (strArr[7].length() != strArr[6].length()) {
                throw new RuntimeException();
            }
            String[] strArr2 = A02;
            strArr2[2] = "FdVgf7aW3ZlRvCS3XNogPN0WY7h";
            strArr2[5] = "8zrY";
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A01 = new byte[]{-53, -38, -38, -23, -35, -49, -35, -35, -45, -39, -40, -23, -45, -50, -66, -59, -53, -55, -63, -48, -50, -59, -65, -37, -49, -59, -61, -54, -67, -56, -37, -65, -59, -50, -65, -47, -56, -67, -50, -37, -66, -47, -62, -62, -63, -50, -37, -56, -63, -54, -61, -48, -60, -77, -58, -73, -73, -74, -61, -48, -76, -78, -63, -78, -76, -70, -59, -54, -3, 18, 7, -6, 6, 2, -4, 24, 12, 2, 0, 7, -6, 5, 24, -4, 2, 11, -4, 14, 5, -6, 11, 24, -5, 14, -1, -1, -2, 11, 24, 5, -2, 7, 0, 13, 1, -99, -109, -111, -104, -117, -106, -87, -115, -103, -104, -112, -109, -111, -91, -90, -109, -90, -101, -107, -79, -91, -101, -103, -96, -109, -98, -79, -107, -101, -92, -107, -89, -98, -109, -92, -79, -108, -89, -104, -104, -105, -92, -79, -98, -105, -96, -103, -90, -102, -67, -78, -74, -82, -69, -56, -78, -73, -67, -82, -69, -65, -86, -75, -56, -67, -78, -74, -82, 21, 36, 36, 19, 39, 25, 39, 39, 29, 35, 34, 19, 29, 24, -61, -54, -48, -50, -58, -43, -45, -54, -60, -64, -44, -54, -56, -49, -62, -51, -64, -60, -54, -45, -42, -60, -42, -51, -62, -45, -64, -61, -42, -57, -57, -58, -45, -64, -51, -58, -49, -56, -43, -55, 33, 52, 37, 37, 36, 49, 30, 34, 32, 47, 32, 34, 40, 51, 56, -76, -55, -66, -79, -67, -71, -77, -81, -61, -71, -73, -66, -79, -68, -81, -77, -71, -62, -59, -77, -59, -68, -79, -62, -81, -78, -59, -74, -74, -75, -62, -81, -68, -75, -66, -73, -60, -72, 6, -4, -6, 1, -12, -1, -14, -10, 2, 1, -7, -4, -6, -1, 0, -19, 0, -11, -17, -21, -1, -11, -13, -6, -19, -8, -21, -17, -11, -2, 1, -17, 1, -8, -19, -2, -21, -18, 1, -14, -14, -15, -2, -21, -8, -15, -6, -13, 0, -12, 49, 38, 42, 34, 47, 28, 38, 43, 49, 34, 47, 51, 30, 41, 28, 49, 38, 42, 34};
    }

    public static void A02() {
        A02 = new String[]{"6AF9ex9J9IYy6ctD08UTNgib7H7Sb5YL", "bWp", "BfqzG0uUNLTSdhPvhqeYIgfcyv1", "9QpnniL2o9Xg0ZsyGvnVMHX5AqnMFeyc", "F5C", "719k", "kQcR0M2lCDmzKMsji", "jvn0YiNb3A2SF193Z"};
    }

    /* access modifiers changed from: public */
    static {
        A02();
        A01();
    }

    /* access modifiers changed from: public */
    AnonymousClass67(String str) {
        this.A00 = str;
    }

    public final String A03() {
        return this.A00;
    }
}
