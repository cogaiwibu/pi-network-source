package com.facebook.ads.redexgen.X;

import android.text.TextUtils;
import java.util.Arrays;

/* renamed from: com.facebook.ads.redexgen.X.Ol  reason: case insensitive filesystem */
public class C0619Ol extends AbstractC0640Pg {
    public static byte[] A01;
    public final /* synthetic */ AnonymousClass83 A00;

    static {
        A01();
    }

    public static String A00(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A01, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] ^ i3) ^ 21);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A01 = new byte[]{2, 14, 12, 79, 7, 0, 2, 4, 3, 14, 14, 10, 79, 0, 5, 18, 79, 8, 15, 21, 4, 19, 18, 21, 8, 21, 8, 0, 13, 79, 8, 12, 17, 19, 4, 18, 18, 8, 14, 15, 79, 13, 14, 6, 6, 4, 5};
    }

    public C0619Ol(AnonymousClass83 r1) {
        this.A00 = r1;
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC0640Pg
    public final void A04() {
        if (!this.A00.A0D.A08()) {
            this.A00.A0D.A06();
            if (this.A00.getAudienceNetworkListener() != null) {
                this.A00.getAudienceNetworkListener().A3s(A00(0, 47, 116));
            }
            if (!TextUtils.isEmpty(this.A00.A0A)) {
                ((ZY) this.A00).A0A.A86(this.A00.A0A, new NU().A04(this.A00.A09).A03(this.A00.A0D).A05(((ZY) this.A00).A08.A0S()).A06());
                this.A00.A0C.A0A().A2a();
            }
        }
    }
}
