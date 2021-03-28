package com.facebook.ads.redexgen.X;

import java.util.Arrays;
import java.util.StringTokenizer;

public final class LP {
    public static byte[] A00;

    static {
        A02();
    }

    public static String A00(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A00, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] ^ i3) ^ 97);
        }
        return new String(copyOfRange);
    }

    public static void A02() {
        A00 = new byte[]{25, 65, 65, 65};
    }

    public static String A01(String truncatedBody) {
        if (truncatedBody == null) {
            return truncatedBody;
        }
        StringTokenizer tokenizer = new StringTokenizer(truncatedBody, A00(0, 1, 88), true);
        int i = 0;
        if (truncatedBody.length() <= 90) {
            return truncatedBody;
        }
        int length = truncatedBody.length();
        String A002 = A00(1, 3, 14);
        if (length <= 93 && truncatedBody.endsWith(A002)) {
            return truncatedBody;
        }
        while (tokenizer.hasMoreTokens()) {
            int length2 = tokenizer.nextToken().length();
            if (i + length2 < 90) {
                i += length2;
            }
        }
        if (i == 0) {
            return truncatedBody.substring(0, 90) + A002;
        }
        return truncatedBody.substring(0, i) + A002;
    }
}
