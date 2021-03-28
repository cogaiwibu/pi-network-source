package com.facebook.ads.redexgen.X;

import java.io.Serializable;
import java.util.Arrays;

/* renamed from: com.facebook.ads.redexgen.X.1N  reason: invalid class name */
public final class AnonymousClass1N implements Serializable {
    public static byte[] A04 = null;
    public static String[] A05 = null;
    public static final long serialVersionUID = 351643298236575729L;
    public final String A00;
    public final String A01;
    public final String A02;
    public final String A03;

    static {
        A03();
        A02();
    }

    public static String A00(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A04, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] - i3) - 77);
        }
        return new String(copyOfRange);
    }

    public static void A02() {
        A04 = new byte[]{121, -7, -31, -13, -16, -16, -29, -20, -31, -9, -5, -23, -33, -29, -49, -36, -30, -41, -30, -25, -21};
    }

    public static void A03() {
        A05 = new String[]{"fMgCBjwnSPLlGmCQgsSLupdT7pqDzyp4", "yUS8gRlB2MWxUDhPAJrAYtkWaSt8qz4B", "dBasyOwTmlOZTCbIWWmvB1g7E", "RqaXhgYUvoqEq", "F0nm8JPdbdm", "Y401XUNRFDrr9SfWxNZZjZ9oz", "LA5HjnpgcUFB3", "MK9sfwjFqBk"};
    }

    public AnonymousClass1N(AnonymousClass1M r2) {
        this.A02 = AnonymousClass1M.A00(r2);
        this.A03 = AnonymousClass1M.A01(r2);
        this.A00 = AnonymousClass1M.A02(r2);
        this.A01 = AnonymousClass1M.A03(r2);
    }

    public static String A01(String str, String str2, int i) {
        String quantityString = str.replace(A00(1, 10, 49), str2);
        String updatedString = A00(0, 0, 15);
        if (i > 0) {
            updatedString = i + A00(0, 1, 12);
        }
        String updatedString2 = quantityString.replace(A00(11, 10, 33), updatedString);
        if (A05[7].length() != 29) {
            String[] strArr = A05;
            strArr[4] = "HwfJGa76I4tQ";
            strArr[4] = "HwfJGa76I4tQ";
            return updatedString2;
        }
        throw new RuntimeException();
    }

    public final String A04() {
        return this.A00;
    }

    public final String A05() {
        return this.A01;
    }

    public final String A06() {
        return this.A02;
    }

    public final String A07(String str, int i) {
        return A01(this.A03, str, i);
    }
}
