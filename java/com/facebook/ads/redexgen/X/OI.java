package com.facebook.ads.redexgen.X;

import java.util.Arrays;

public class OI implements Runnable {
    public static byte[] A01;
    public static String[] A02;
    public final /* synthetic */ AnonymousClass86 A00;

    static {
        A02();
        A01();
    }

    public static String A00(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A01, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] ^ i3) ^ 18);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        byte[] bArr = {12, 51, 62, 63, 53, 10, 54, 59, 35, 56, 59, 57, 49, 31, 40, 40, 53, 40};
        if (A02[1].charAt(23) != 'K') {
            throw new RuntimeException();
        }
        String[] strArr = A02;
        strArr[7] = "A0q876J4tZs52Ekfd4RAns8rddsLZMZI";
        strArr[0] = "8q1dRMivP5Tdv15zR8IgwT8qhlVYesmy";
        A01 = bArr;
    }

    public static void A02() {
        A02 = new String[]{"8vJSkdftfADdQfAHliFxPF8rPO9WPGls", "GhlXUiQB5e5u02XqNxNWNeCKPeVKjYEZ", "Gph9c0UvmRxipzP0t5nr5UcpcMkZF", "2Hx", "Z7V0Td9h4", "73nZsDchDyg56oZ4XPBfjpsU", "FVxK20XbexvbAX1X2tgr9gQBHO7cWF", "2kskKAMtduGXueKHObaD2J8oFHf05nvp"};
    }

    public OI(AnonymousClass86 r1) {
        this.A00 = r1;
    }

    public final void run() {
        if (!KU.A02(this)) {
            try {
                this.A00.A00.A0H(A00(0, 18, 72));
            } catch (Throwable th) {
                if (A02[1].charAt(23) != 'K') {
                    throw new RuntimeException();
                }
                String[] strArr = A02;
                strArr[4] = "fqamCUNwf";
                strArr[5] = "B5vyeoYMTrLFIeMZvtcbxM1r";
                KU.A00(th, this);
            }
        }
    }
}
