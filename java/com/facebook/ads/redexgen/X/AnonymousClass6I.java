package com.facebook.ads.redexgen.X;

import java.util.Arrays;

/* renamed from: com.facebook.ads.redexgen.X.6I  reason: invalid class name */
public enum AnonymousClass6I {
    A0E,
    A03,
    A07,
    A09,
    A06,
    A0A,
    A0B,
    A0D,
    A08,
    A05,
    A04,
    A0C;
    
    public static byte[] A00;
    public static String[] A01;

    public static String A00(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A00, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] - i3) - 65);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        byte[] bArr = {-22, -19, -19, 8, -22, -20, -20, -18, -11, -18, -5, -8, -10, -18, -3, -18, -5, 8, -4, -18, -9, -4, -8, -5, 8, -1, -22, -11, -2, -18, -1, 2, 2, 29, -1, 11, 0, 7, 3, 12, 18, 29, 18, 3, 11, 14, 3, 16, -1, 18, 19, 16, 3, 29, 17, 3, 12, 17, 13, 16, 29, 20, -1, 10, 19, 3, -47, -44, -44, -17, -46, -47, -30, -33, -35, -43, -28, -43, -30, -17, -29, -43, -34, -29, -33, -30, -17, -26, -47, -36, -27, -43, -53, -50, -50, -23, -47, -49, -39, -41, -53, -47, -40, -49, -34, -45, -51, -23, -36, -39, -34, -53, -34, -45, -39, -40, -23, -35, -49, -40, -35, -39, -36, -23, -32, -53, -42, -33, -49, -35, -32, -32, -5, -29, -11, -18, -21, -17, -33, -21, -20, -31, -5, -17, -31, -22, -17, -21, -18, -5, -14, -35, -24, -15, -31, -21, -18, -18, 9, -10, -13, -15, -14, -2, 9, -3, -17, -8, -3, -7, -4, 9, 0, -21, -10, -1, -17, -15, -12, -12, 15, -3, -15, -9, -2, -11, 4, -1, -3, -11, 4, -11, 2, 15, 3, -11, -2, 3, -1, 2, 15, 6, -15, -4, 5, -11, -100, -97, -97, -70, -86, -83, -92, -96, -87, -81, -100, -81, -92, -86, -87, -70, -82, -96, -87, -82, -86, -83, -70, -79, -100, -89, -80, -96, -51, -48, -48, -21, -36, -34, -37, -28, -43, -39, -43, -32, -27, -21, -33, -47, -38, -33, -37, -34, -21, -30, -51, -40, -31, -47, -82, -79, -79, -52, -65, -78, -71, -82, -63, -74, -61, -78, -52, -75, -62, -70, -74, -79, -74, -63, -58, -52, -64, -78, -69, -64, -68, -65, -52, -61, -82, -71, -62, -78, -101, -98, -98, -71, -83, -82, -97, -86, -71, -98, -97, -82, -97, -99, -82, -87, -84, -71, -83, -97, -88, -83, -87, -84, -71, -80, -101, -90, -81, -97, -62, -59, -59, -32, -43, -48, -42, -60, -55, -32, -44, -54, -56, -49, -62, -51};
        if (A01[7].length() != 17) {
            String[] strArr = A01;
            strArr[6] = "6PvDAVd0u5ZQ";
            strArr[1] = "QdwzfFmoIIjPkAhzJwek8CbGrSLNUAg5";
            A00 = bArr;
            return;
        }
        throw new RuntimeException();
    }

    public static void A02() {
        A01 = new String[]{"Hs12mGKVT9cGMSCRKoT3r35VsLlFJngq", "vrs8dXMHiXGodZZR4QlLWUxaGUalJKSj", "xtu9Dfa1i9ezHSrMe9DQ6ZezHrr3oDZc", "9dyiqx9lrEz1jnwAULweoyg4vUAzKyc7", "EjpOJg3XytBiyqa9xlkDMYbHzsrKCWwv", "QN25BDiQgi1CAPlrfw8ErWZwyWeMFWEw", "lmKaipradHs3", "IbpqLNO4BesQtGUTHELjyRq"};
    }

    /* access modifiers changed from: public */
    static {
        A02();
        A01();
    }
}
