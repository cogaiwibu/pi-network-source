package com.facebook.ads.redexgen.X;

import android.util.Pair;
import java.util.Arrays;
import java.util.Map;

public final class CJ {
    public static byte[] A00;

    static {
        A03();
    }

    public static String A02(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A00, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] ^ i3) ^ 78);
        }
        return new String(copyOfRange);
    }

    public static void A03() {
        A00 = new byte[]{30, 59, 49, 55, 60, 33, 55, 22, 39, 32, 51, 38, 59, 61, 60, 0, 55, 63, 51, 59, 60, 59, 60, 53, 7, 59, 54, 46, 53, 54, 52, 60, 19, 34, 37, 54, 35, 62, 56, 57, 5, 50, 58, 54, 62, 57, 62, 57, 48};
    }

    /* JADX INFO: Multiple debug info for r0v4 java.lang.String: [D('value' java.lang.String), D('keyStatus' java.util.Map<java.lang.String, java.lang.String>)] */
    public static long A00(Map<String, String> keyStatus, String str) {
        if (keyStatus == null) {
            return -9223372036854775807L;
        }
        try {
            String value = keyStatus.get(str);
            if (value != null) {
                return Long.parseLong(value);
            }
            return -9223372036854775807L;
        } catch (NumberFormatException unused) {
            return -9223372036854775807L;
        }
    }

    public static Pair<Long, Long> A01(C3<?> c3) {
        Map<String, String> keyStatus = c3.ABt();
        if (keyStatus == null) {
            return null;
        }
        return new Pair<>(Long.valueOf(A00(keyStatus, A02(0, 24, 28))), Long.valueOf(A00(keyStatus, A02(24, 25, 25))));
    }
}
