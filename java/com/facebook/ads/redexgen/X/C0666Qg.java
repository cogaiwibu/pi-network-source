package com.facebook.ads.redexgen.X;

import java.util.Arrays;
import java.util.Locale;

/* renamed from: com.facebook.ads.redexgen.X.Qg  reason: case insensitive filesystem */
public class C0666Qg implements OG {
    public static byte[] A01;
    public final /* synthetic */ C0664Qe A00;

    static {
        A01();
    }

    public static String A00(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A01, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] - i3) - 23);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A01 = new byte[]{-43, -56, -60, -42, -79, -60, -64, -61, -40, -77, -50, -78, -57, -50, -42, -121, -122, -124, -46, -122, -120, -102};
    }

    public C0666Qg(C0664Qe qe) {
        this.A00 = qe;
    }

    @Override // com.facebook.ads.redexgen.X.OG
    public final void A9t() {
        this.A00.A09.A03(JK.A0M, null);
        this.A00.A0J(String.format(Locale.US, A00(0, 22, 72), this.A00.A0I));
    }
}
