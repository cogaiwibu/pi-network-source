package com.facebook.ads.redexgen.X;

import android.util.Log;
import com.facebook.ads.AdError;
import com.facebook.ads.AdSettings;
import com.facebook.ads.internal.protocol.AdErrorType;
import java.util.Arrays;
import java.util.Locale;
import kotlin.jvm.internal.ByteCompanionObject;

/* renamed from: com.facebook.ads.redexgen.X.Rn  reason: case insensitive filesystem */
public final class C0699Rn implements AbstractC00621p {
    public static byte[] A04;
    public static String[] A05;
    public EnumC00611o A00 = EnumC00611o.A03;
    public EnumC00611o A01 = EnumC00611o.A03;
    public final AbstractC0702Rq A02;
    public final C0820Wh A03;

    static {
        A02();
        A01();
    }

    public static String A00(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A04, i, i + i2);
        int i4 = 0;
        while (true) {
            int length = copyOfRange.length;
            String[] strArr = A05;
            if (strArr[7].charAt(1) != strArr[5].charAt(1)) {
                throw new RuntimeException();
            }
            String[] strArr2 = A05;
            strArr2[0] = "d2XCtNqKB2PlkmIVLWNasBjUSsZJOiBr";
            strArr2[0] = "d2XCtNqKB2PlkmIVLWNasBjUSsZJOiBr";
            if (i4 >= length) {
                return new String(copyOfRange);
            }
            copyOfRange[i4] = (byte) ((copyOfRange[i4] - i3) - 29);
            i4++;
        }
    }

    public static void A01() {
        A04 = new byte[]{-73, 11, 6, -73, 118, 104, -95, -73, -67, 104, -85, -87, -74, 104, -85, -80, -87, -74, -81, -83, 104, -111, -74, -68, -83, -81, -70, -87, -68, -79, -73, -74, 104, -115, -70, -70, -73, -70, 104, -75, -73, -84, -83, 104, -86, -63, 104, -69, -83, -68, -68, -79, -74, -81, 104, -119, -84, -101, -83, -68, -68, -79, -74, -81, -69, 118, -69, -83, -68, -111, -74, -68, -83, -81, -70, -87, -68, -79, -73, -74, -115, -70, -70, -73, -70, -107, -73, -84, -83, 112, 113, 112, 108, 107, -97, -114, -109, -113, -104, -115, -113, 120, -113, -98, -95, -103, -100, -107, -103, -59, -62, -64, 115, -41, -14, -17, -18, -25, -96, -23, -18, -12, -27, -14, -18, -31, -20, -96, -12, -14, -31, -18, -13, -23, -12, -23, -17, -18, -82, -15, 0, -7, -67, -64, -78, -75, 121, 122, -63, -74, -67, -59, 118, 119, 15, 3, -4, 15, -69, 4, 14, -69, -4, 7, 13, 0, -4, -1, 20, -69, -25, -22, -36, -33, -28, -23, -30, -57, -69, -25, -22, -36, -33, -32, -33, -69, 10, 13, -69, -18, -29, -22, -14, -28, -23, -30, -45, -57, -64, -45, ByteCompanionObject.MAX_VALUE, -56, -46, ByteCompanionObject.MAX_VALUE, -64, -53, -47, -60, -64, -61, -40, ByteCompanionObject.MAX_VALUE, -78, -89, -82, -74, -88, -83, -90, -14, -26, -33, -14, -98, -25, -15, -98, -20, -19, -14, -98, -54, -51, -65, -62, -61, -62};
    }

    public static void A02() {
        A05 = new String[]{"iEaWyjzULIZCFnp1nESlU5XZjwcvRjHd", "KbGYZiX8Pduw0KfpYwrRe1NWFWC1OMxy", "fhu9engps4P6WEn4zln6smGq5lQXex4h", "tbT6PfDqIL055", "rKa5gX4b0", "TAsNWcfBygYGmj6nueBPL3we7Mc4FYi0", "mn5595Nd0", "gAb4cPpeQcskkpTdmUE6rt9G8rZq3FNo"};
    }

    public C0699Rn(C0820Wh wh, AbstractC0702Rq rq) {
        this.A03 = wh;
        this.A02 = rq;
    }

    private void A03(EnumC00611o r9, EnumC00611o r10) {
        String A002 = A00(113, 26, 99);
        String str = A00(108, 5, 54) + r9 + A00(0, 4, 122) + r10;
        this.A03.A04().A82(A00(139, 3, 115), C02248i.A0T, new C02258j(A002, str));
        this.A03.A0A().ADz(A002 + ' ' + str);
    }

    private void A04(String str, String str2, boolean z) {
        AdSettings.IntegrationErrorMode A002 = C00581l.A00(this.A03);
        String format = String.format(Locale.US, AdErrorType.INCORRECT_API_CALL_ERROR.getDefaultErrorMessage(), str, str2);
        String A003 = A00(139, 3, 115);
        String A004 = A00(91, 17, 13);
        if (!z) {
            Log.e(A004, format);
            this.A03.A04().A82(A003, C02248i.A0R, new C02258j(format));
            this.A03.A0A().ADy(format);
            return;
        }
        int i = C00601n.A00[A002.ordinal()];
        if (i != 1) {
            if (i == 2) {
                this.A02.A05();
                this.A02.A06(10, AdErrorType.INCORRECT_STATE_ERROR, format);
                this.A03.A0A().ADy(format);
                Log.e(A004, format);
                this.A03.A04().A82(A003, C02248i.A0R, new C02258j(format));
            }
            Log.e(A004, format);
            return;
        }
        throw new C00631q(format + A00(4, 87, 43));
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC00621p
    public final boolean A51() {
        boolean z;
        if ((this.A00 == EnumC00611o.A03 || this.A00 == EnumC00611o.A05) && this.A01 != EnumC00611o.A08) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            this.A00 = EnumC00611o.A07;
        } else {
            A04(A00(142, 6, 52), A00(154, 42, 126), false);
        }
        if (!z) {
            return true;
        }
        return false;
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC00621p
    public final boolean A52() {
        boolean z;
        if (this.A00 != EnumC00611o.A06 || (this.A01 == EnumC00611o.A08 && !J8.A0d(this.A03))) {
            z = false;
        } else {
            z = true;
        }
        if (z) {
            this.A00 = EnumC00611o.A03;
            this.A01 = EnumC00611o.A08;
        } else {
            EnumC00611o r5 = this.A00;
            EnumC00611o r4 = EnumC00611o.A06;
            String A002 = A00(148, 6, 49);
            if (r5 != r4) {
                A04(A002, A00(219, 18, 97), true);
            } else {
                A04(A002, A00(196, 23, 66), false);
            }
        }
        if (!z) {
            return true;
        }
        return false;
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC00621p
    public final EnumC00611o A5I() {
        return this.A00;
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC00621p
    public final void ACt(EnumC00611o r1) {
        this.A00 = r1;
        this.A01 = r1;
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC00621p
    public final void ACw(AdError adError) {
        this.A00 = EnumC00611o.A05;
        this.A01 = EnumC00611o.A05;
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC00621p
    public final void AD0() {
        if (this.A00 != EnumC00611o.A07) {
            A03(this.A00, EnumC00611o.A06);
        }
        this.A00 = EnumC00611o.A06;
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC00621p
    public final void AD6() {
        if (this.A01 != EnumC00611o.A08) {
            A03(this.A00, EnumC00611o.A09);
        }
        this.A01 = EnumC00611o.A09;
    }
}
