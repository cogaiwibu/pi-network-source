package com.facebook.ads.internal.protocol;

import android.text.TextUtils;
import java.util.Arrays;
import java.util.Locale;

public enum AdPlacementType {
    BANNER(A00(66, 6, 17)),
    INSTREAM(A00(72, 8, 77)),
    INTERSTITIAL(A00(80, 12, 15)),
    NATIVE(A00(92, 6, 100)),
    NATIVE_BANNER(A00(98, 13, 15)),
    REWARDED_VIDEO(A00(111, 14, 107)),
    UNKNOWN(A00(125, 7, 57));
    
    public static byte[] A01;
    public String A00;

    public static String A00(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A01, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] - i3) - 99);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A01 = new byte[]{20, 19, 32, 32, 23, 36, 35, 40, 45, 46, 44, 31, 27, 39, 33, 38, 44, 29, 42, 43, 44, 33, 44, 33, 25, 36, 4, -9, 10, -1, 12, -5, -44, -57, -38, -49, -36, -53, -27, -56, -57, -44, -44, -53, -40, 19, 6, 24, 2, 19, 5, 6, 5, 32, 23, 10, 5, 6, 16, -57, -64, -67, -64, -63, -55, -64, -42, -43, -30, -30, -39, -26, 25, 30, 35, 36, 34, 21, 17, 29, -37, -32, -26, -41, -28, -27, -26, -37, -26, -37, -45, -34, 53, 40, 59, 48, 61, 44, -32, -45, -26, -37, -24, -41, -47, -44, -45, -32, -32, -41, -28, 64, 51, 69, 47, 64, 50, 51, 50, 45, 68, 55, 50, 51, 61, 17, 10, 7, 10, 11, 19, 10};
    }

    /* access modifiers changed from: public */
    static {
        A01();
    }

    /* access modifiers changed from: public */
    AdPlacementType(String str) {
        this.A00 = str;
    }

    public static AdPlacementType fromString(String str) {
        if (TextUtils.isEmpty(str)) {
            return UNKNOWN;
        }
        try {
            return valueOf(str.toUpperCase(Locale.US));
        } catch (Exception unused) {
            return UNKNOWN;
        }
    }

    public String toString() {
        return this.A00;
    }
}
