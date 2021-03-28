package com.facebook.ads.redexgen.X;

import java.util.Arrays;

public enum LR {
    A03,
    A04;
    
    public static byte[] A00;
    public static String[] A01;

    public static String A00(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A00, i, i + i2);
        int i4 = 0;
        while (true) {
            int length = copyOfRange.length;
            String[] strArr = A01;
            if (strArr[1].charAt(25) != strArr[6].charAt(25)) {
                String[] strArr2 = A01;
                strArr2[2] = "hPRl6mewzDLtDRePFgVGGzDpOousDsET";
                strArr2[7] = "1PTlaN9o47ZvO5QWBq3tjVop340dHI6h";
                if (i4 >= length) {
                    return new String(copyOfRange);
                }
                copyOfRange[i4] = (byte) ((copyOfRange[i4] ^ i3) ^ 123);
                i4++;
            } else {
                throw new RuntimeException();
            }
        }
    }

    public static void A01() {
        A00 = new byte[]{81, 80, 83, 84, 64, 89, 65, 20, 7, 30, 30, 13, 1, 17, 0, 23, 23, 28};
    }

    public static void A02() {
        A01 = new String[]{"hc6LTHWh34", "SocWGKvTrb27mU7I6HYZWtCOqe8vN7We", "SUbP7E1EvcCOTKHRfbpGBIuCA1WKWIWl", "9BnvDMswfYYU8yfKe5BUnKeiNTL", "L0vmRAARTPtPdmY", "U1b0Njqb3LWazyJmLiNcKHMDagE8OpYs", "PuJNFUDLlE3IV59JGDcXhgchNVuNoa4b", "exdb2ky9NstGP6elq11NgBzvOAGjRaxw"};
    }

    /* access modifiers changed from: public */
    static {
        A02();
        A01();
    }
}
