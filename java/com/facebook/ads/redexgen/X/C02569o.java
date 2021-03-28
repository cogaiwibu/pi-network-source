package com.facebook.ads.redexgen.X;

import java.util.Arrays;

/* renamed from: com.facebook.ads.redexgen.X.9o  reason: invalid class name and case insensitive filesystem */
public class C02569o extends AbstractC0464Ie {
    public static byte[] A01;
    public static String[] A02;
    public final /* synthetic */ C0858Xt A00;

    static {
        A02();
        A01();
    }

    public static String A00(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A01, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] ^ i3) ^ 59);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A01 = new byte[]{112, 88, 78, 72, 88, 118};
        String[] strArr = A02;
        if (strArr[2].charAt(21) != strArr[1].charAt(21)) {
            String[] strArr2 = A02;
            strArr2[4] = "AaqsZ0kN0wdt4PxPT80lhbaiVomD";
            strArr2[4] = "AaqsZ0kN0wdt4PxPT80lhbaiVomD";
            return;
        }
        throw new RuntimeException();
    }

    public static void A02() {
        A02 = new String[]{"0EtrvwW3MQkzSecFvnBX4JMfeqt66nTs", "31KVsJeKTKhLPCOslR3tmLkuK1Xd7IZW", "ErGHvP3zkyEh4xX1eQlIOsNtLUt9M6Nd", "ktedtIytEv2FRFoF5SCcQiRhp3TIfz9L", "y7SJDh6vytCFGPm3eUSBlWJktjn6", "2Pj8nikJl49sV4F", "Af2d4ar6BC4UZ7hhvi", "JNiO58cgS0ZkwkRgj9Y5ghYAFIamZa37"};
    }

    public C02569o(C0858Xt xt) {
        this.A00 = xt;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x00cf, code lost:
        if (r2 >= 1.0f) goto L_0x00d1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x00f8, code lost:
        if (r2 >= 1.0f) goto L_0x00d1;
     */
    /* renamed from: A03 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void A04(com.facebook.ads.redexgen.X.C02137s r8) {
        /*
        // Method dump skipped, instructions count: 397
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C02569o.A04(com.facebook.ads.redexgen.X.7s):void");
    }
}
