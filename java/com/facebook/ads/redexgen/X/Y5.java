package com.facebook.ads.redexgen.X;

import java.util.Arrays;

public class Y5 extends AbstractRunnableC0510Kc {
    public static byte[] A02;
    public static String[] A03;
    public final /* synthetic */ int A00;
    public final /* synthetic */ C02569o A01;

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
            if (strArr[4].charAt(31) != strArr[0].charAt(31)) {
                String[] strArr2 = A03;
                strArr2[6] = "O62aedMh2uH8SX7kKpV0hPKbmKu3dRtH";
                strArr2[6] = "O62aedMh2uH8SX7kKpV0hPKbmKu3dRtH";
                if (i4 >= length) {
                    return new String(copyOfRange);
                }
                copyOfRange[i4] = (byte) ((copyOfRange[i4] - i3) - 49);
                i4++;
            } else {
                throw new RuntimeException();
            }
        }
    }

    public static void A01() {
        A02 = new byte[]{-61, -10, -25, -25, -26, -13, -22, -17, -24, -95, -22, -17, -27, -26, -25, -22, -17, -22, -11, -26, -19, -6};
    }

    public static void A03() {
        A03 = new String[]{"YT1PK3WBVS3kniXpybROmIhjWhGVClPh", "6j", "onQoUfiZJSuD3rguNgGkdAHpHQ2hvx1c", "dO9MTkytiNOu4TIl66WPEIPq7WYt5YTT", "LwW2ju5RHwfXyh7prhFW5VX2Thqdh31m", "wb6oMsMYcKN", "2GYadBc1t2oUSCNIAMCw1GAaJcdxmHnE", "MoTE5VLcrtX4ZcmexG"};
    }

    public Y5(C02569o r1, int i) {
        this.A01 = r1;
        this.A00 = i;
    }

    @Override // com.facebook.ads.redexgen.X.AbstractRunnableC0510Kc
    public final void A07() {
        if (this.A01.A00.A09 != null) {
            EnumC0638Pe state = this.A01.A00.A09.getState();
            EnumC0638Pe pe = EnumC0638Pe.A02;
            if (A03[5].length() != 24) {
                String[] strArr = A03;
                strArr[5] = "Lqx2qyHvy7GSucr2a";
                strArr[5] = "Lqx2qyHvy7GSucr2a";
                if (state == pe && this.A01.A00.A09.getCurrentPositionInMillis() == this.A00) {
                    this.A01.A00.A0M.removeCallbacksAndMessages(null);
                    this.A01.A00.A0e(A00(0, 22, 80));
                    return;
                }
                return;
            }
            throw new RuntimeException();
        }
    }
}
