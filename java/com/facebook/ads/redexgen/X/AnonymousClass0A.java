package com.facebook.ads.redexgen.X;

import android.text.TextUtils;
import java.util.Arrays;

/* renamed from: com.facebook.ads.redexgen.X.0A  reason: invalid class name */
public final class AnonymousClass0A {
    public static byte[] A00;

    static {
        A02();
    }

    public static String A00(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A00, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] ^ i3) ^ 64);
        }
        return new String(copyOfRange);
    }

    public static void A02() {
        A00 = new byte[]{71};
    }

    private String A01(String str) {
        int lastIndexOf = str.lastIndexOf(46);
        return (lastIndexOf == -1 || lastIndexOf <= str.lastIndexOf(47) || (lastIndexOf + 2) + 4 <= str.length()) ? A00(0, 0, 13) : str.substring(lastIndexOf + 1, str.length());
    }

    public final String A03(String str) {
        String A01 = A01(str);
        String A02 = AnonymousClass0J.A02(str);
        if (TextUtils.isEmpty(A01)) {
            return A02;
        }
        return A02 + A00(0, 1, 41) + A01;
    }
}
