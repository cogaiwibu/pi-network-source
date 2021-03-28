package com.facebook.ads.redexgen.X;

import java.util.Arrays;

/* renamed from: com.facebook.ads.redexgen.X.Rc  reason: case insensitive filesystem */
public class C0688Rc extends AbstractRunnableC0510Kc {
    public static byte[] A01;
    public final /* synthetic */ AbstractC0690Re A00;

    static {
        A01();
    }

    public static String A00(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A01, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] - i3) - 34);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A01 = new byte[]{-113, -98, -105};
    }

    public C0688Rc(AbstractC0690Re re) {
        this.A00 = re;
    }

    @Override // com.facebook.ads.redexgen.X.AbstractRunnableC0510Kc
    public final void A07() {
        try {
            this.A00.A09();
        } catch (Exception e) {
            this.A00.A0C.A04().A82(A00(0, 3, 12), C02248i.A0I, new C02258j(e));
        }
    }
}
