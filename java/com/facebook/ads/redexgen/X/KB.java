package com.facebook.ads.redexgen.X;

import java.util.Arrays;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class KB {
    public static Map<String, Long> A00 = new ConcurrentHashMap();
    public static Map<String, Long> A01 = new ConcurrentHashMap();
    public static Map<String, String> A02 = new ConcurrentHashMap();
    public static byte[] A03;
    public static String[] A04;

    public static String A01(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A03, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] - i3) - 64);
        }
        return new String(copyOfRange);
    }

    public static void A04() {
        A03 = new byte[]{-35, 43, -14, -35, 43, -14, -35, 43, -14, -35, 28, -14, -35, 28, -14, -35, 28, -26, -19, -26, 24, 23, -26, -28, 26, -20, 10, 0, 5, -2, -73, 3, -8, 10, 11, -73, -8, -5, -73, 9, -4, 10, 7, 6, 5, 10, -4, 5, 3, 18, -22, -1, 17, 18, -16, 3, 17, 14, 13, 12, 17, 3};
    }

    public static void A05() {
        A04 = new String[]{"WcKxqk7L6BbuUQ1o7qmtmX6WSmYBceUW", "BgR1wHMut0LLHWxcn1vNnqjOmnDpA7yk", "nofrFHfyJT7pmG0QketyEOeNZ4PDBNqx", "tJ6rTzDc1vJYhzSuFM6hiX1fKi0tAXSV", "zeDIr51bIn8XcOdXOM6dVjfvh9EOKJZZ", "x4ZdmXYSSnH60B6WOaypztUTceO04NF4", "XXJyOaEVU", "eLFDRkAKNxNhqN4Dib4JBju5Hz9f2MYZ"};
    }

    static {
        A05();
        A04();
    }

    public static long A00(String str, EnumC0498Jp jp) {
        if (A01.containsKey(str)) {
            return A01.get(str).longValue();
        }
        int i = KA.A00[jp.ordinal()];
        if (i != 1) {
            return (i == 2 || i == 3) ? -1000 : -1000;
        }
        if (A04[6].length() != 32) {
            String[] strArr = A04;
            strArr[4] = "PcZmlfQcdFNZlzEkEhUxMjsAcGnkg3Oc";
            strArr[7] = "bp21WTLlcRSzBiFixYai9jfTwoum3UGv";
            return 15000;
        }
        throw new RuntimeException();
    }

    public static String A02(KC kc) {
        K0.A05(A01(47, 15, 94), A01(25, 22, 87), A01(17, 8, 116));
        return A02.get(A03(kc));
    }

    public static String A03(KC kc) {
        int A002;
        Locale locale = Locale.US;
        Object[] objArr = new Object[6];
        int i = 0;
        objArr[0] = kc.A08();
        objArr[1] = kc.A05();
        objArr[2] = kc.A06();
        if (kc.A07() == null) {
            A002 = 0;
        } else {
            A002 = kc.A07().A00();
        }
        objArr[3] = Integer.valueOf(A002);
        if (kc.A07() != null) {
            i = kc.A07().A01();
        }
        objArr[4] = Integer.valueOf(i);
        objArr[5] = Integer.valueOf(kc.A04());
        return String.format(locale, A01(0, 17, 120), objArr);
    }

    public static void A06(long j, KC kc) {
        A01.put(A03(kc), Long.valueOf(j));
    }

    public static void A07(KC kc) {
        A00.put(A03(kc), Long.valueOf(System.currentTimeMillis()));
    }

    public static void A08(String str, KC kc) {
        A02.put(A03(kc), str);
    }

    public static boolean A09(KC kc) {
        String A032 = A03(kc);
        if (!A00.containsKey(A032)) {
            return false;
        }
        long longValue = A00.get(A032).longValue();
        if (System.currentTimeMillis() - longValue < A00(A032, kc.A05())) {
            return true;
        }
        return false;
    }
}
