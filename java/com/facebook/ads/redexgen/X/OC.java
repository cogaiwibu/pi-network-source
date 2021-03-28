package com.facebook.ads.redexgen.X;

import com.facebook.imagepipeline.common.RotationOptions;
import java.util.Arrays;

public enum OC {
    A08(A01(186, 10, 53)),
    A0A(A01(206, 24, 110)),
    A03(A01(125, 13, 113)),
    A06(A01(162, 18, 53)),
    A05(A01(143, 19, 57)),
    A09(A01(196, 10, 64)),
    A0B(A01(230, 3, 80)),
    A04(A01(138, 5, 66)),
    A07(A01(RotationOptions.ROTATE_180, 6, 61)),
    A0C(A01(233, 15, 6)),
    A0D(A01(0, 0, 107));
    
    public static byte[] A01;
    public final String A00;

    public static String A01(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A01, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] - i3) - 92);
        }
        return new String(copyOfRange);
    }

    public static void A02() {
        A01 = new byte[]{-21, -12, -9, -5, -19, 7, -22, -6, -9, -1, -5, -19, -6, -44, -43, -46, -27, -41, -82, -77, -67, -85, -84, -74, -81, -55, -84, -85, -83, -75, -55, -84, -65, -66, -66, -71, -72, -25, -16, -29, -28, -18, -25, 1, -28, -29, -27, -19, 1, -28, -9, -10, -10, -15, -16, -39, -24, -31, -31, -40, -33, -10, -17, -4, -14, -6, -13, 13, -15, 2, -17, 25, 29, 32, 34, 21, 35, 35, 25, 31, 30, -37, -48, -28, -35, -46, -41, -18, -48, -45, -18, -31, -44, -33, -34, -31, -29, -40, -35, -42, -58, -55, -63, 30, 17, 35, 13, 30, 16, 43, 15, 27, 25, 28, 24, 17, 32, 17, 33, 26, 23, 26, 27, 35, 26, 48, 57, 60, 64, 50, 44, 47, 63, 60, 68, 64, 50, 63, 2, 3, 0, 19, 5, -7, -2, 8, -10, -9, 1, -6, -12, -9, -10, -8, 0, -12, -9, 10, 9, 9, 4, 3, -10, -1, -14, -13, -3, -10, -16, -13, -14, -12, -4, -16, -13, 6, 5, 5, 0, -1, -1, 14, 7, 7, -2, 5, -7, -14, -1, -11, -3, -10, -16, -12, 5, -14, 5, 9, 12, 14, 1, 15, 15, 5, 11, 10, 54, 43, 63, 56, 45, 50, 41, 43, 46, 41, 60, 47, 58, 57, 60, 62, 51, 56, 49, 41, 48, 54, 57, 65, 24, 27, 19, -44, -57, -39, -61, -44, -58, -63, -59, -47, -49, -46, -50, -57, -42, -57};
    }

    /* access modifiers changed from: public */
    static {
        A02();
    }

    /* access modifiers changed from: public */
    OC(String str) {
        this.A00 = str;
    }

    public static OC A00(String str) {
        OC[] values = values();
        for (OC oc : values) {
            if (oc.A00.equalsIgnoreCase(str)) {
                return oc;
            }
        }
        return A0D;
    }
}
