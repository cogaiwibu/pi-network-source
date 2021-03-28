package com.facebook.ads.redexgen.X;

import java.util.Arrays;

/* renamed from: com.facebook.ads.redexgen.X.0R  reason: invalid class name */
public enum AnonymousClass0R {
    A0M(0),
    A0J(1),
    A08(2),
    A0H(3),
    A0I(4),
    A07(5),
    A0G(6),
    A0B(7),
    A09(8),
    A0D(9),
    A0E(10),
    A0C(11),
    A0L(12),
    A04(13),
    A0F(14),
    A0A(15),
    A05(16),
    A06(17),
    A0K(18),
    A0N(19);
    
    public static byte[] A01;
    public static String[] A02;
    public final int A00;

    public static String A00(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A01, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] - i3) - 111);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A01 = new byte[]{-19, -16, 11, -11, -6, -1, 1, -14, -14, -11, -17, -11, -15, -6, 0, 11, 2, -11, -1, -11, -18, -8, -15, 11, -19, -2, -15, -19, -52, -49, -22, -44, -39, -22, -41, -38, -50, -42, -34, -50, -35, -48, -48, -39, -41, -38, -11, -33, -23, -11, -28, -27, -22, -11, -33, -28, -11, -41, -39, -22, -33, -20, -33, -22, -17, 28, 31, 58, 36, 46, 58, 41, 42, 47, 58, 49, 36, 46, 36, 29, 39, 32, 38, 41, 68, 46, 56, 68, 51, 58, 49, 49, -38, -35, -8, -30, -20, -8, -24, -37, -20, -19, -21, -18, -36, -19, -34, -35, 32, 35, 62, 40, 50, 62, 46, 33, 50, 51, 49, 52, 34, 51, 36, 35, 62, 33, 56, 62, 42, 36, 56, 38, 52, 32, 49, 35, -54, -51, -24, -46, -36, -24, -35, -37, -54, -41, -36, -39, -54, -37, -50, -41, -35, -11, -8, 19, 3, -6, -6, 7, -9, 6, -7, -7, 2, 19, -10, 3, 8, 8, 3, 1, -6, -3, 24, 8, -1, -1, 12, -4, 11, -2, -2, 7, 24, 1, 8, 11, 2, 19, 8, 7, 13, -6, 5, 5, 18, -9, -6, 21, 5, -4, -4, 9, -7, 8, -5, -5, 4, 21, 10, 5, 6, 17, 20, 47, 38, 25, 21, 39, 17, 18, 25, 28, 25, 36, 41, 47, 36, 25, 19, 27, 47, 20, 37, 34, 17, 36, 25, 31, 30, 47, 52, 60, 39, 50, 47, 42, 69, 42, 47, 51, 43, 52, 57, 47, 53, 52, 57, 49, 54, 62, 41, 52, 49, 44, 71, 56, 41, 58, 45, 54, 60, -40, -35, -27, -48, -37, -40, -45, -18, -26, -40, -35, -45, -34, -26, -56, -46, -34, -43, -56, -60, -42, -64, -63, -53, -60, -14, -29, -12, -25, -16, -10, 1, -21, -11, 1, -16, -9, -18, -18, -2, -18, -3, -16, -16, -7, 10, -7, -6, -1, 10, -12, -7, -1, -16, -3, -20, -18, -1, -12, 1, -16, -28, -35, -38, -35, -34, -26, -35, -6, -19, -23, -5, 3, -14, -13, -8, 3, -9, -20, -13, -5, -14};
    }

    public static void A02() {
        A02 = new String[]{"gZn0YqQsyH3LboqGd", "6iEgNNIPZgZDIlTtX4b9VIYTNqcrnf4m", "XAoGi5mGaFQZFqWDdkVsCV3Av2NgJGYo", "KNn7BidFAgrMQUXMp", "TFPIQvVTE4U7hjn2v090srkxUrTQUx3T", "U5RMGFHSAmwAw", "0XKBrb3At6dwoT0wmD89VHK9vq2VdTUa", "idRv"};
    }

    /* access modifiers changed from: public */
    static {
        A02();
        A01();
    }

    /* access modifiers changed from: public */
    AnonymousClass0R(int i) {
        this.A00 = i;
    }

    public final int A03() {
        return this.A00;
    }
}
