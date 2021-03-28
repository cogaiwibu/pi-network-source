package com.facebook.ads.redexgen.X;

import java.util.Arrays;

/* renamed from: com.facebook.ads.redexgen.X.bb  reason: case insensitive filesystem */
public final class C1009bb {
    public static byte[] A00;
    public static String[] A01;

    static {
        A02();
        A01();
    }

    public static String A00(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A00, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] - i3) - 57);
            String[] strArr = A01;
            if (strArr[1].charAt(18) != strArr[2].charAt(18)) {
                String[] strArr2 = A01;
                strArr2[4] = "X228u0Qr";
                strArr2[4] = "X228u0Qr";
            } else {
                throw new RuntimeException();
            }
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A00 = new byte[]{-69, -67, -50, -61, -48, -61, -50, -45, -71, -55, -68, -60, -65, -67, -50, -71, -61, -66, -43, -40, -45, -32, -35, -25, -24, -39, -30, -39, -26, -45, -25, -39, -24, -26, -23, -28, -8, -18, -1, -22, 4, 2, 13, 13, 0, 10, 8, 15, 16, 19, 6, 5, -52, -39, -39, -42, -39, -58, -54, -42, -53, -52, -25, -12, -12, -15, -12, -31, -17, -25, -11, -11, -29, -23, -25, 22, 15, 33, 13, 16, 23, 18, 16, 9, 27, 7, 11, 23, 22, 28, 26, 23, 20, 20, 13, 26, -70, -77, -59, -79, -66, -69, -59, -58, -73, -64, -73, -60, -88, -95, -77, -97, -73, -91, -94, -74, -87, -91, -73, -24, -29, -50, -40, -60, -50, -45, -37, -58, -47, -50, -55, -58, -39, -54, -55, -68, -58, -78, -61, -56, -75, -65, -68, -74, -26, -23, -37, -34, -39, -18, -29, -25, -33, -39, -25, -19, 10, 13, -1, 2, 7, 12, 5, -3, -1, 2, -1, 14, 18, 3, 16, -66, -74, -75, -70, -78, -59, -70, -64, -65, -80, -64, -57, -74, -61, -67, -78, -54, -80, -60, -74, -59, -58, -66, -52, -52, -70, -64, -66, -40, -44, -55, -53, -51, -43, -51, -42, -36, -57, -47, -52, -85, -89, -100, -98, -96, -88, -96, -87, -81, -102, -81, -76, -85, -96, 8, -5, -9, 9, 5, 4, 37, 24, 36, 40, 24, 38, 39, 18, 28, 23, -83, -94, -87, -79, -103, -84, -97, -83, -81, -90, -82, -71, -79, -81, -74, -91, -72, -85, -89, -71, -75, -76, 1, -54, -67, -71, -53, -77, -56, -51, -60, -71, 35, 22, 32, 22, 15, 22, 25, 22, 33, 38};
    }

    public static void A02() {
        A01 = new String[]{"gK21opX6pdVXzizTr5B569byzifByDT1", "VXUYBRMamhge5PldHXwCUhQsvqUwyGaK", "A9eN1weHgCPL1SkQ3ZXjYtrHuOy08x6Y", "MZbjV39kBt4hAqLFGwVFLXlTEV84r4gZ", "MdBS2JQ6", "f1VlKL6T46QLbXXjKJzzCBeajzTILabi", "uaXBHv2Fpyp6t9CjlnIdC1IJtF0IP5s0", "SVJaljzXeB5Am8n"};
    }
}
