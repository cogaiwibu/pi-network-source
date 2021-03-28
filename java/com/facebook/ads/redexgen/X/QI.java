package com.facebook.ads.redexgen.X;

import com.anythink.reactnativejs.utils.Const;
import java.util.Arrays;
import java.util.Locale;

public enum QI {
    A04(A01(37, 3, 86)),
    A05(A01(40, 7, 117));
    
    public static byte[] A01;
    public static String[] A02;
    public String A00;

    public static String A01(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A01, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] - i3) - 102);
        }
        return new String(copyOfRange);
    }

    public static void A02() {
        A01 = new byte[]{21, 23, 31, -34, 3, 11, -10, 1, -2, -7, -75, 8, -6, 7, 11, -6, 7, -75, 7, -6, 8, 5, 4, 3, 8, -6, -49, -75, -70, 8, -6, -13, -16, -13, -12, -4, -13, 29, 31, 39, 80, 73, 70, 73, 74, 82, 73};
    }

    public static void A03() {
        A02 = new String[]{"kIaQKGqX2ZTqEjvfJkZOl1WwOBoH9uFY", Const.X, "Fa9eXDyIy4elyWfec912IKE0nqoR5HQV", "", "DfNaQJeOEpNPwVx", "9", "0vF5Kqqkw0y14nBhXHX4F0aBgr7OScbz", ""};
    }

    /* access modifiers changed from: public */
    static {
        A03();
        A02();
    }

    /* access modifiers changed from: public */
    QI(String str) {
        this.A00 = str;
    }

    public static QI A00(String str) {
        QI[] values = values();
        for (QI qi : values) {
            if (qi.A00.equals(str)) {
                return qi;
            }
        }
        throw new IllegalArgumentException(String.format(Locale.US, A01(3, 27, 47), str));
    }
}
