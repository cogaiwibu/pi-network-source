package com.facebook.ads.redexgen.X;

import java.util.Arrays;

/* renamed from: com.facebook.ads.redexgen.X.av  reason: case insensitive filesystem */
public class C0970av extends AbstractRunnableC0510Kc {
    public static byte[] A02;
    public static String[] A03;
    public final /* synthetic */ KC A00;
    public final /* synthetic */ KF A01;

    static {
        A03();
        A01();
    }

    public static String A00(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A02, i, i + i2);
        int i4 = 0;
        while (true) {
            int length = copyOfRange.length;
            String[] strArr = A03;
            if (strArr[2].charAt(31) != strArr[3].charAt(31)) {
                String[] strArr2 = A03;
                strArr2[7] = "vKWhPjbFalI70MxhKihYQQhrE25QXeUX";
                strArr2[7] = "vKWhPjbFalI70MxhKihYQQhrE25QXeUX";
                if (i4 >= length) {
                    return new String(copyOfRange);
                }
                copyOfRange[i4] = (byte) ((copyOfRange[i4] - i3) - 89);
                i4++;
            } else {
                throw new RuntimeException();
            }
        }
    }

    public static void A01() {
        A02 = new byte[]{-51, -85, -67, -96, -97, -84, -84, -93, -80, -67, -87, -93, -73};
    }

    public static void A03() {
        A03 = new String[]{"HdBP5Xz", "1x1Spdd4leaR6rMyIqz7jDuVALPBafGP", "axXL5TnL0HBMXsVKsrA9GDOWQxSG9OY6", "1dEgnVHIT0m43fI6JYH9hpNhfyiBWS6N", "iEi5yE", "UjLwzpYsoJIrFySVWBkKISpV5tCrd9dB", "Qbq65yz", "qKKFep347IAmJ8sue1lLg6VgEBnKG6W3"};
    }

    public C0970av(KF kf, KC kc) {
        this.A01 = kf;
        this.A00 = kc;
    }

    /* JADX INFO: Multiple debug info for r11v0 'this'  com.facebook.ads.redexgen.X.av: [D('e' java.lang.Exception), D('shouldCheckSystemHttpAgent' boolean)] */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x008b */
    @Override // com.facebook.ads.redexgen.X.AbstractRunnableC0510Kc
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void A07() {
        /*
        // Method dump skipped, instructions count: 307
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C0970av.A07():void");
    }
}
