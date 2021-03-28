package com.facebook.ads.redexgen.X;

import java.util.Arrays;

public class P8 extends AbstractRunnableC0510Kc {
    public static byte[] A02;
    public final /* synthetic */ AnonymousClass85 A00;
    public final /* synthetic */ C02137s A01;

    static {
        A01();
    }

    public static String A00(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A02, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] - i3) - 53);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A02 = new byte[]{-126, -75, -90, -90, -91, -78, -87, -82, -89, 96, -87, -82, -92, -91, -90, -87, -82, -87, -76, -91, -84, -71};
    }

    public P8(AnonymousClass85 r1, C02137s r2) {
        this.A00 = r1;
        this.A01 = r2;
    }

    @Override // com.facebook.ads.redexgen.X.AbstractRunnableC0510Kc
    public final void A07() {
        if (this.A00.A0A.getState() == EnumC0638Pe.A02 && this.A00.A0A.getCurrentPositionInMillis() == this.A01.A00()) {
            this.A00.A0H(A00(0, 22, 11));
        }
    }
}
