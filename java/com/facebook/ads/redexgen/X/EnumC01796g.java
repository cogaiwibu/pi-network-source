package com.facebook.ads.redexgen.X;

import java.util.Arrays;

/* renamed from: com.facebook.ads.redexgen.X.6g  reason: invalid class name and case insensitive filesystem */
public enum EnumC01796g {
    A03,
    A04;
    
    public static byte[] A00;
    public static String[] A01;

    public static String A00(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A00, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] - i3) - 121);
            String[] strArr = A01;
            if (strArr[5].charAt(29) != strArr[6].charAt(29)) {
                String[] strArr2 = A01;
                strArr2[1] = "FPFgBqqJeEkyPdeC";
                strArr2[0] = "lf6fPO1AOsDcBdk1";
            } else {
                throw new RuntimeException();
            }
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A00 = new byte[]{65, 70, 76, 61, 63, 61, 74, 22, 23, 21, 12, 17, 10};
    }

    public static void A02() {
        A01 = new String[]{"k9YgwMNoBobey2P3", "e6gY2KwdCyhxzyJg", "XekGxBcgkm9Piqw4gBfizkkV5P8", "1GcTjvefwXiEODDnEjfMRtb0cPUGlX75", "ZdzTHxr5JGj0Sa8aqJDa45W8xDvcUiPL", "P27kcHiKxsYV8bH7Xsbi006fslBpGCcl", "HgqSjgTeAT7xF2FFP9WgcaMTZUlmKzh3", "gTwzg4IRAV6UOuzo00Z4w5gIHW3"};
    }

    /* access modifiers changed from: public */
    static {
        A02();
        A01();
    }
}
