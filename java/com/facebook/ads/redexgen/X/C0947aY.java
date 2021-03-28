package com.facebook.ads.redexgen.X;

import com.facebook.appevents.AppEventsConstants;
import com.ironsource.sdk.analytics.omid.OMIDManager;
import java.util.Arrays;

/* renamed from: com.facebook.ads.redexgen.X.aY  reason: case insensitive filesystem */
public final class C0947aY implements HE {
    public static byte[] A08;
    public static String[] A09;
    public int A00;
    public int A01;
    public int A02;
    public HD[] A03;
    public final int A04;
    public final boolean A05;
    public final byte[] A06;
    public final HD[] A07;

    static {
        A02();
        A01();
    }

    public static String A00(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A08, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] - i3) - 123);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A08 = new byte[]{-69, -81, -2, 23, 14, 33, 25, 14, 12, 29, 14, 13, -55, 10, 21, 21, 24, 12, 10, 29, 18, 24, 23, -29, -55};
    }

    public static void A02() {
        A09 = new String[]{"4ve0RWyhYyl9xCQBcFEHHb6J5", AppEventsConstants.EVENT_PARAM_VALUE_NO, "sHlJnKRUCXWWG8DJxhYmJcdBG87KccAz", "Y1hOWn5yAZG8wtugOKE5SlkzB9Lmm", "ccLKzhNJONN8hN3GMkJFYY9R9j4tosDy", "kB2MLz2Qt2VhBov62BdjLbPbFvH", "HEcEuygojM8kHr", "TVH0enYaQUtbllarZb7wcHSuDyXsicXL"};
    }

    public C0947aY(boolean z, int i) {
        this(z, i, 0);
    }

    public C0947aY(boolean z, int i, int i2) {
        boolean z2;
        boolean z3 = false;
        if (i > 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        I1.A03(z2);
        I1.A03(i2 >= 0 ? true : z3);
        this.A05 = z;
        this.A04 = i;
        this.A01 = i2;
        this.A03 = new HD[(i2 + 100)];
        if (i2 > 0) {
            this.A06 = new byte[(i2 * i)];
            for (int i3 = 0; i3 < i2; i3++) {
                this.A03[i3] = new HD(this.A06, i3 * i);
            }
        } else {
            this.A06 = null;
        }
        this.A07 = new HD[1];
    }

    public final synchronized int A03() {
        int i;
        i = this.A00 * this.A04;
        String[] strArr = A09;
        if (strArr[3].length() != strArr[5].length()) {
            String[] strArr2 = A09;
            strArr2[0] = "5S97W7P0mYMCYwMDzMcet6TY3";
            strArr2[1] = OMIDManager.OMID_PARTNER_VERSION;
        } else {
            throw new RuntimeException();
        }
        return i;
    }

    public final synchronized void A04() {
        if (this.A05) {
            A05(0);
        }
    }

    public final synchronized void A05(int i) {
        boolean z = i < this.A02;
        this.A02 = i;
        if (z) {
            ADZ();
        }
    }

    @Override // com.facebook.ads.redexgen.X.HE
    public final synchronized HD A3N() {
        HD hd;
        this.A00++;
        if (this.A01 > 0) {
            HD[] hdArr = this.A03;
            int i = this.A01 - 1;
            this.A01 = i;
            hd = hdArr[i];
            this.A03[this.A01] = null;
        } else {
            hd = new HD(new byte[this.A04], 0);
        }
        return hd;
    }

    @Override // com.facebook.ads.redexgen.X.HE
    public final int A6P() {
        return this.A04;
    }

    @Override // com.facebook.ads.redexgen.X.HE
    public final synchronized void ACE(HD hd) {
        this.A07[0] = hd;
        ACF(this.A07);
        String[] strArr = A09;
        if (strArr[0].length() != strArr[1].length()) {
            String[] strArr2 = A09;
            strArr2[2] = "vTQnHDwqIVvtvGKS6QPwZVkZoK1Lgm5f";
            strArr2[2] = "vTQnHDwqIVvtvGKS6QPwZVkZoK1Lgm5f";
            return;
        }
        throw new RuntimeException();
    }

    @Override // com.facebook.ads.redexgen.X.HE
    public final synchronized void ACF(HD[] hdArr) {
        if (this.A01 + hdArr.length >= this.A03.length) {
            this.A03 = (HD[]) Arrays.copyOf(this.A03, Math.max(this.A03.length * 2, this.A01 + hdArr.length));
        }
        for (HD hd : hdArr) {
            if (hd.A01 == this.A06 || hd.A01.length == this.A04) {
                HD[] hdArr2 = this.A03;
                int i = this.A01;
                this.A01 = i + 1;
                hdArr2[i] = hd;
            } else {
                throw new IllegalArgumentException(A00(2, 23, 46) + System.identityHashCode(hd.A01) + A00(0, 2, 20) + System.identityHashCode(this.A06) + A00(0, 2, 20) + hd.A01.length + A00(0, 2, 20) + this.A04);
            }
        }
        this.A00 -= hdArr.length;
        notifyAll();
    }

    @Override // com.facebook.ads.redexgen.X.HE
    public final synchronized void ADZ() {
        int lowIndex = Math.max(0, C0466Ig.A04(this.A02, this.A04) - this.A00);
        if (lowIndex < this.A01) {
            if (this.A06 != null) {
                int i = 0;
                int i2 = this.A01 - 1;
                while (i <= i2) {
                    HD hd = this.A03[i];
                    if (hd.A01 == this.A06) {
                        i++;
                    } else {
                        HD hd2 = this.A03[i2];
                        if (hd2.A01 != this.A06) {
                            i2--;
                        } else {
                            this.A03[i] = hd2;
                            this.A03[i2] = hd;
                            i2--;
                            i++;
                        }
                    }
                }
                lowIndex = Math.max(lowIndex, i);
                if (lowIndex >= this.A01) {
                    return;
                }
            }
            Arrays.fill(this.A03, lowIndex, this.A01, (Object) null);
            this.A01 = lowIndex;
        }
    }
}
