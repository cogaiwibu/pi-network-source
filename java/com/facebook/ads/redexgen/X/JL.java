package com.facebook.ads.redexgen.X;

import androidx.annotation.Nullable;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public final class JL {
    public static byte[] A02;
    public static String[] A03;
    public final JE A00;
    public final String A01;

    static {
        A02();
        A01();
    }

    public static String A00(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A02, i, i + i2);
        int i4 = 0;
        while (true) {
            int length = copyOfRange.length;
            if (A03[4].charAt(5) != 'b') {
                throw new RuntimeException();
            }
            String[] strArr = A03;
            strArr[4] = "OpSsMbmoyiuJLyOxEkBMoj5ebplLMUgU";
            strArr[4] = "OpSsMbmoyiuJLyOxEkBMoj5ebplLMUgU";
            if (i4 >= length) {
                return new String(copyOfRange);
            }
            copyOfRange[i4] = (byte) ((copyOfRange[i4] ^ i3) ^ 40);
            i4++;
        }
    }

    public static void A01() {
        A02 = new byte[]{24, 30, 9, 31, 18, 27, 14};
    }

    public static void A02() {
        A03 = new String[]{"0EK1zjbC0rvKFRySirHuNeKu7O6M1c2K", "EZ3WTNSY5ayWns4cE", "iOTwBXJJn2mTXQ1MI7WizzznsNyhmcwj", "DnXRTJeCR1MDANpnyW3y9Xegmk", "0BaBrbX1x0DXsftKwoONmcZPElrNX48m", "JdhHjDAP4IE4TNrXk8Fag99Jau", "kO1FJ5pbtA78NTGKnINecVB8MAIDEUuG", "0uD1E8KeZOnBJibGqVh9DEewsO4i87jr"};
    }

    public JL(String str, JE je) {
        this.A01 = str;
        this.A00 = je;
    }

    public final void A03(JK jk, @Nullable Map<String, String> map) {
        A04(jk.A03(), map);
    }

    public final void A04(String str, @Nullable Map<String, String> map) {
        if (JN.A0B(this.A01, str)) {
            if (map == null) {
                map = new HashMap<>();
            }
            map.put(A00(0, 7, 67), str);
            JE je = this.A00;
            String str2 = this.A01;
            if (A03[4].charAt(5) != 'b') {
                throw new RuntimeException();
            }
            String[] strArr = A03;
            strArr[0] = "vT3nRtW3uRS5jX4JEmaR2PdDFOqNzjtW";
            strArr[7] = "IECj1aNSpXIXDwy92hzTd369PO3PVRtC";
            je.A84(str2, map);
        }
    }
}
