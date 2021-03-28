package com.facebook.ads.redexgen.X;

import java.util.Arrays;

public enum JF {
    A05(0),
    A04(1);
    
    public static byte[] A01;
    public static String[] A02;
    public final int A00;

    public static String A00(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A01, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            int i5 = (copyOfRange[i4] - i3) - 117;
            String[] strArr = A02;
            if (strArr[0].charAt(4) != strArr[4].charAt(4)) {
                throw new RuntimeException();
            }
            String[] strArr2 = A02;
            strArr2[3] = "h3cU3OwhzzGY5RqiQjzUPbB5XZb13N8z";
            strArr2[3] = "h3cU3OwhzzGY5RqiQjzUPbB5XZb13N8z";
            copyOfRange[i4] = (byte) i5;
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A01 = new byte[]{-62, -61, -60, -61, -48, -48, -61, -62, -7, -3, -3, -11, -12, -7, -15, 4, -11};
    }

    public static void A02() {
        A02 = new String[]{"oiwcgQDD2Kh2jNi2Ca2cNMgwHOvPe1SO", "yCbh3JWABSPWXJzi8IqNfGSw4JUwRc1Z", "TDKikcySDZ1IILIigFVmatsXCwa", "mxQFgn0FH0MMkOxHpkkDQyVpPhA2Zhda", "dru3glT9ekJ0g4QSSusKvICYyzfTBGaa", "dAZiojPQaZCECwqg1LvdEmP9Ue6", "ejQSO991EpDhDVu4zMofsruN7P1", "5bejy9B"};
    }

    /* access modifiers changed from: public */
    static {
        A02();
        A01();
    }

    /* access modifiers changed from: public */
    JF(int i) {
        this.A00 = i;
    }
}
