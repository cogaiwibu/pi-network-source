package com.facebook.ads.redexgen.X;

import java.util.Arrays;

/* renamed from: com.facebook.ads.redexgen.X.Gr  reason: case insensitive filesystem */
public final class C0425Gr {
    public static byte[] A04;
    public static String[] A05;
    public static final String[] A06 = new String[0];
    public final int A00;
    public final String A01;
    public final String A02;
    public final String[] A03;

    public static String A02(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A04, i, i + i2);
        int i4 = 0;
        while (true) {
            int length = copyOfRange.length;
            if (A05[5].charAt(16) != 'R') {
                throw new RuntimeException();
            }
            String[] strArr = A05;
            strArr[1] = "hhyK";
            strArr[4] = "wZqiL";
            if (i4 >= length) {
                return new String(copyOfRange);
            }
            copyOfRange[i4] = (byte) ((copyOfRange[i4] ^ i3) ^ 6);
            i4++;
        }
    }

    public static void A03() {
        A04 = new byte[]{36, 114, 0};
    }

    public static void A04() {
        A05 = new String[]{"zFpRfifZkCIQawK1FUSg1K3EtGdV6Nz", "WEmq", "TVYpI9shQgf8MMEfvFWnKjXtFk1mYiaB", "WCXJZ", "VBPbo", "2erUCN4YfMxeKpPmRmxhBeZiE0shrr6A", "I2AaOQprvAMyyOLMUfVLbbt0mFwKyNVO", "ZVSAIqFm1ddnxSH"};
    }

    static {
        A04();
        A03();
    }

    public C0425Gr(String str, int i, String str2, String[] strArr) {
        this.A00 = i;
        this.A01 = str;
        this.A02 = str2;
        this.A03 = strArr;
    }

    public static C0425Gr A00() {
        String A022 = A02(0, 0, 1);
        return new C0425Gr(A022, 0, A022, new String[0]);
    }

    public static C0425Gr A01(String str, int i) {
        String trim;
        String[] strArr;
        String name = str.trim();
        if (name.isEmpty()) {
            return null;
        }
        int indexOf = name.indexOf(A02(0, 1, 2));
        if (indexOf == -1) {
            trim = A02(0, 0, 1);
        } else {
            trim = name.substring(indexOf).trim();
            String[] strArr2 = A05;
            if (strArr2[1].length() != strArr2[4].length()) {
                String[] strArr3 = A05;
                strArr3[5] = "Nr5OesO8C9sIOUHXRuAUw2kYPHmeguzx";
                strArr3[5] = "Nr5OesO8C9sIOUHXRuAUw2kYPHmeguzx";
                name = name.substring(0, indexOf);
            } else {
                throw new RuntimeException();
            }
        }
        String[] A0m = C0466Ig.A0m(name, A02(1, 2, 40));
        String str2 = A0m[0];
        if (A0m.length > 1) {
            strArr = (String[]) Arrays.copyOfRange(A0m, 1, A0m.length);
        } else {
            strArr = A06;
        }
        return new C0425Gr(str2, i, trim, strArr);
    }
}
