package com.facebook.ads.redexgen.X;

/* renamed from: com.facebook.ads.redexgen.X.Nn  reason: case insensitive filesystem */
public final class C0595Nn {
    public static final int A00 = C0535Le.A02.heightPixels;
    public static final int A01 = C0535Le.A02.widthPixels;

    public static float A00(AnonymousClass19 r2) {
        int A012 = r2.A0E().A01();
        int height = r2.A0E().A00();
        if (height > 0) {
            return ((float) A012) / ((float) height);
        }
        return -1.0f;
    }

    public static int A01(double d) {
        return (int) (((double) (A01 - (AbstractC0596No.A09 * 2))) / d);
    }

    public static int A02(int ctaTextHeight) {
        return (A00 - ctaTextHeight) - ((C0535Le.A01(16) + (C0585Nd.A0B * 2)) + (AbstractC0596No.A09 * 2));
    }

    public static boolean A03(double d) {
        return d < 0.9d;
    }

    public static boolean A04(double d, int i) {
        return A02(i) < A01(d);
    }

    public static boolean A05(int i, int i2, double d) {
        return i == 2 || A04(d, i2);
    }
}
