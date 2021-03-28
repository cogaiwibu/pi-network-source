package com.facebook.ads.redexgen.X;

import java.util.Arrays;

/* renamed from: com.facebook.ads.redexgen.X.ai  reason: case insensitive filesystem */
public final class C0957ai extends HV {
    public static byte[] A01;
    public static String[] A02;
    public final String A00;

    static {
        A02();
        A01();
    }

    public static String A00(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A01, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] ^ i3) ^ 63);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A01 = new byte[]{13, 42, 50, 37, 40, 45, 32, 100, 39, 43, 42, 48, 33, 42, 48, 100, 48, 61, 52, 33, 126, 100};
        if (A02[2].charAt(21) != 'I') {
            String[] strArr = A02;
            strArr[4] = "yWaeILMTRyNjMdlGgdEDrDI";
            strArr[0] = "cj1077EILRdS6ZzLpoMmpdb";
            return;
        }
        throw new RuntimeException();
    }

    public static void A02() {
        A02 = new String[]{"ZQ8PuEpoE8gyS3Znd74chKs", "SMR6jCgSs1OLi9k", "9TpefdXfhJ1bgovOujDvo0cycPvHTNeY", "fSCcvv9mQcAxaPQjtTD5J0fX4AU6qoUi", "pC4MzMAjE35JrXvA7GEGwLl", "N4W5wz59KJRM86L2MxAv0qAi54qP6RPf", "ZjburCSFctaP2yxaKgKjejXQTrv5uqRP", "7nU1e349RKnqDnE0EBs6XskGT5MTKO6z"};
    }

    public C0957ai(String str, HQ hq) {
        super(A00(0, 22, 123) + str, hq, 1);
        this.A00 = str;
    }
}
