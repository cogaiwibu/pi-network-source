package com.facebook.ads.redexgen.X;

import android.net.Uri;
import android.text.TextUtils;
import java.util.Arrays;

/* renamed from: com.facebook.ads.redexgen.X.Xb  reason: case insensitive filesystem */
public class C0840Xb implements AbstractC0565Mi {
    public static byte[] A01;
    public static String[] A02;
    public final /* synthetic */ AbstractC0563Mg A00;

    static {
        A02();
        A01();
    }

    public static String A00(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A01, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] - i3) - 111);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A01 = new byte[]{-29, -17, -19, -82, -26, -31, -29, -27, -30, -17, -17, -21, -82, -31, -28, -13, -82, -31, -28, -14, -27, -16, -17, -14, -12, -23, -18, -25, -82, -58, -55, -50, -55, -45, -56, -33, -63, -60, -33, -46, -59, -48, -49, -46, -44, -55, -50, -57, -33, -58, -52, -49, -41};
        String[] strArr = A02;
        if (strArr[4].length() != strArr[1].length()) {
            String[] strArr2 = A02;
            strArr2[7] = "41BFLxMtpa8zSeOoPh8lyezFWRN0z1Os";
            strArr2[7] = "41BFLxMtpa8zSeOoPh8lyezFWRN0z1Os";
            return;
        }
        throw new RuntimeException();
    }

    public static void A02() {
        A02 = new String[]{"nV", "0i4Wqrqqd8V", "SjjlSsHq4luZ", "UY2G1G5tdkkQRCLDawUW8PMELrtkam", "x8YzSsjyce", "sMLSYBAewXVAxhh2DbXf8YHA5QSbjC", "Z41BjwW", "WlPnbv1jMaDivlCQdRIz8mOz1GWjjHLQ"};
    }

    public C0840Xb(AbstractC0563Mg mg) {
        this.A00 = mg;
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC0565Mi
    public final void A42() {
        if (this.A00.A06 != null) {
            this.A00.A06.A3s(A00(0, 53, 17));
        }
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC0565Mi
    public final void A43() {
        this.A00.A0L();
        if (this.A00.A07 != null) {
            this.A00.A07.AAl(true);
        }
        this.A00.A0A();
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC0565Mi
    public final void A7D() {
        if (this.A00.A03 == null) {
            A43();
            return;
        }
        AbstractC0563Mg.A01(this.A00);
        if (this.A00.A03.A02() == null) {
            AbstractC0563Mg mg = this.A00;
            if (A02[6].length() != 7) {
                throw new RuntimeException();
            }
            String[] strArr = A02;
            strArr[7] = "M7aB9yPR9altU9X1FYnvgfaKEANBwcUB";
            strArr[7] = "M7aB9yPR9altU9X1FYnvgfaKEANBwcUB";
            mg.A0B();
            return;
        }
        AbstractC0563Mg mg2 = this.A00;
        mg2.A0D(mg2.A03.A02());
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC0565Mi
    public final void A7o() {
        if (!TextUtils.isEmpty(AnonymousClass23.A0C(this.A00.A04.A00()))) {
            Kw.A09(new Kw(), this.A00.A04, Uri.parse(AnonymousClass23.A0C(this.A00.A04.A00())), this.A00.A08);
        }
        this.A00.A02.A05();
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC0565Mi
    public final void A7p() {
        this.A00.A0L();
        if (this.A00.A07 != null) {
            this.A00.A07.AAl(true);
        }
        if (!TextUtils.isEmpty(AnonymousClass23.A06(this.A00.A04.A00()))) {
            Kw.A09(new Kw(), this.A00.A04, Uri.parse(AnonymousClass23.A06(this.A00.A04.A00())), this.A00.A08);
        }
        this.A00.A02.A07();
        this.A00.A0A();
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC0565Mi
    public final void AAC(AnonymousClass24 r3) {
        AnonymousClass26 A04;
        AbstractC0563Mg.A00(this.A00);
        this.A00.A01 = r3;
        if (this.A00.A01 == AnonymousClass24.A03) {
            A04 = AnonymousClass23.A03(this.A00.A04.A00());
        } else {
            A04 = AnonymousClass23.A04(this.A00.A04.A00());
        }
        this.A00.A0D(A04);
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC0565Mi
    public final void AAK(AnonymousClass26 r3) {
        AbstractC0563Mg.A00(this.A00);
        this.A00.A02.A08(r3.A01());
        if (r3.A05().isEmpty()) {
            this.A00.A0C(r3);
        } else {
            this.A00.A0D(r3);
        }
    }
}
