package com.facebook.ads.redexgen.X;

import java.util.Arrays;
import java.util.regex.Pattern;

/* renamed from: com.facebook.ads.redexgen.X.Gu  reason: case insensitive filesystem */
public final class C0428Gu {
    public static byte[] A00;
    public static String[] A01;
    public static final Pattern A02 = Pattern.compile(A02(52, 16, 39));
    public static final Pattern A03 = Pattern.compile(A02(68, 22, 121));

    public static String A02(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A00, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] - i3) - 94);
        }
        return new String(copyOfRange);
    }

    public static void A03() {
        A00 = new byte[]{-78, -101, -49, 2, -6, -17, -19, -2, -17, -18, -86, -31, -49, -52, -32, -34, -34, -72, -86, -47, -7, -2, -86, -38, -17, -4, -19, -17, -8, -2, -21, -15, -17, -3, -86, -9, -1, -3, -2, -86, -17, -8, -18, -86, 1, -13, -2, -14, -86, -81, 32, -14, -29, -45, -44, -39, -54, -83, -83, -91, 1, -114, -82, -77, -81, -82, -60, -87, 53, -58, -110, -106, 22, 46, 28, 25, 45, 43, 43, -1, -1, -9, 83, -32, 0, 5, 1, 0, 22, -5};
        if (A01[5].charAt(7) != 'A') {
            String[] strArr = A01;
            strArr[1] = "UIXOAUPWxceeOWimYUBL0aqZbFGzFpDD";
            strArr[4] = "y1DZlYDt8XB0NvVsmM2QDxFu33622hlo";
            return;
        }
        throw new RuntimeException();
    }

    public static void A04() {
        A01 = new String[]{"qUSUHG3fl04fppScybkIwiqF9Za6ywqc", "9GxhccWehaY5est6axh3IoJrmeutmSKO", "9QjDmFUhLFBWA", "vndLW2pvMzyIddqlKbZjCiSqXs", "uUaUr8hqhvXPaN7P8w7sIXvdlccOSZG2", "lnJWg1D8BBdeQAPn86A9Flbm9l6gCzpH", "U2icgnLcubCMXREdIQwwFZ9djs5VAYY8", "jjAIDyaXekIZT"};
    }

    static {
        A04();
        A03();
    }

    public static float A00(String str) throws NumberFormatException {
        if (str.endsWith(A02(0, 1, 47))) {
            return Float.parseFloat(str.substring(0, str.length() - 1)) / 100.0f;
        }
        throw new NumberFormatException(A02(23, 27, 44));
    }

    public static long A01(String str) throws NumberFormatException {
        long j = 0;
        String[] A0n = C0466Ig.A0n(str, A02(50, 2, 102));
        for (String subpart : C0466Ig.A0m(A0n[0], A02(1, 1, 3))) {
            j = (60 * j) + Long.parseLong(subpart);
        }
        long j2 = j * 1000;
        if (A0n.length == 2) {
            String str2 = A0n[1];
            if (A01[5].charAt(7) != 'A') {
                String[] parts = A01;
                parts[5] = "EtjYanqu7taAJaVCJ4eq2Fekx5qw52Sf";
                parts[5] = "EtjYanqu7taAJaVCJ4eq2Fekx5qw52Sf";
                j2 += Long.parseLong(str2);
            } else {
                throw new RuntimeException();
            }
        }
        return 1000 * j2;
    }

    public static void A05(IQ iq) throws GH {
        String line = iq.A0Q();
        if (line == null || !A03.matcher(line).matches()) {
            throw new GH(A02(2, 21, 44) + line);
        }
    }
}
