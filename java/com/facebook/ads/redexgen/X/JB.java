package com.facebook.ads.redexgen.X;

import android.text.TextUtils;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public final class JB {
    public static byte[] A07;
    public static String[] A08;
    public final double A00;
    public final double A01 = (((double) System.currentTimeMillis()) / 1000.0d);
    public final JF A02;
    public final JG A03;
    public final String A04;
    public final String A05;
    public final Map<String, String> A06;

    static {
        A03();
        A02();
    }

    public static String A00(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A07, i, i + i2);
        int i4 = 0;
        while (true) {
            int length = copyOfRange.length;
            String[] strArr = A08;
            if (strArr[4].length() != strArr[0].length()) {
                throw new RuntimeException();
            }
            String[] strArr2 = A08;
            strArr2[7] = "vmrJ4a9vgt2Kh5jnKLFXcgPaai5qbtv5";
            strArr2[3] = "Xi4zcaKQ0kTUusAVwfois8CGtwAhjWs7";
            if (i4 >= length) {
                return new String(copyOfRange);
            }
            copyOfRange[i4] = (byte) ((copyOfRange[i4] ^ i3) ^ 63);
            i4++;
        }
    }

    public static void A02() {
        A07 = new byte[]{97, 110, 97, 108, 111, 103, 109, 112, 107, 101, 107, 108, 99, 110, 93, 97, 110, 107, 103, 108, 118, 93, 118, 109, 105, 103, 108, 110, 117, 114, 104, 113, 121, 66, 116, 115, 126, 113, 104, 121, 120, 66, 116, 115, 66, 123, 104, 115, 115, 120, 113};
    }

    public static void A03() {
        A08 = new String[]{"LYvtYpjh3A8vQy5q2R4RxEae0rP", "jA7v2s", "LzEc2Zjd8NVDeWOm9tYj7O2gb", "Qr4hCar3IUJK7IjuLaxeJKR14jvwbtqN", "uluEIDHou1vA3RshZYJ1CVooXlj", "7Mv6zZGpvnHTc", "8W43Le7bwqTNh", "1W0jBamhj3r3Yg4zpKy5fnBuSdv5NYDW"};
    }

    public JB(AnonymousClass8H r6, String str, double d, String str2, Map<String, String> map, JF jf, JG jg, boolean z) {
        this.A05 = str;
        this.A00 = d;
        this.A04 = str2;
        this.A02 = jf;
        this.A03 = jg;
        HashMap hashMap = new HashMap();
        if (map != null && !map.isEmpty()) {
            hashMap.putAll(map);
        }
        if (z) {
            hashMap.put(A00(27, 24, 34), String.valueOf(z));
        }
        String A012 = JN.A01(str);
        if (!TextUtils.isEmpty(A012) && (z || jg == JG.A0C)) {
            hashMap.put(A00(6, 21, 61), A012);
        }
        if (A0C()) {
            hashMap.put(A00(0, 6, 63), LD.A01(r6.A02().A5N()));
        }
        this.A06 = A01(hashMap);
    }

    /* JADX INFO: Multiple debug info for r0v3 java.util.Map$Entry<java.lang.String, java.lang.String>: [D('extraData' java.util.Map<java.lang.String, java.lang.String>), D('entry' java.util.Map$Entry<java.lang.String, java.lang.String>)] */
    /* JADX INFO: Multiple debug info for r0v5 java.lang.String: [D('value' java.lang.String), D('entry' java.util.Map$Entry<java.lang.String, java.lang.String>)] */
    public static Map<String, String> A01(Map<String, String> cleansedMap) {
        HashMap hashMap = new HashMap();
        for (Map.Entry<String, String> entry : cleansedMap.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            if (value != null) {
                hashMap.put(key, value);
            }
        }
        return hashMap;
    }

    public final double A04() {
        return this.A00;
    }

    public final double A05() {
        return this.A01;
    }

    public final JF A06() {
        return this.A02;
    }

    public final JG A07() {
        return this.A03;
    }

    public final String A08() {
        return this.A04;
    }

    public final String A09() {
        return this.A05;
    }

    public final Map<String, String> A0A() {
        return this.A06;
    }

    public final boolean A0B() {
        return !TextUtils.isEmpty(this.A05);
    }

    public final boolean A0C() {
        return this.A02 == JF.A05;
    }
}
