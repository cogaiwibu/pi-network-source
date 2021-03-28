package com.facebook.ads.redexgen.X;

import android.os.Bundle;
import java.util.Arrays;

public final class S7 implements LO<Bundle> {
    public static byte[] A06;
    public static String[] A07;
    public AnonymousClass22 A00;
    public boolean A01 = false;
    public boolean A02 = false;
    public boolean A03 = false;
    public final AnonymousClass20 A04;
    public final AnonymousClass22 A05;

    static {
        A05();
        A04();
    }

    public static String A00(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A06, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] ^ i3) ^ 7);
        }
        return new String(copyOfRange);
    }

    public static void A04() {
        A06 = new byte[]{43, 39, 37, 56, 36, 45, 60, 45, 84, 95, 85, 84, 85, 21, 4, 22, 22, 0, 1, 100, 117, 99, 100, 67, 100, 113, 100, 99, 111, 112, 124, 110, 120, 123, 117, 124, 74, 109, 120, 109, 106};
    }

    public static void A05() {
        A07 = new String[]{"SAMNpPFpITUhS5O2wArhouwTSBZGJm", "j9883o", "ez1Iu7S0g9Y3okmD0rAeLGMZx9C5J", "cx0ufmmqihH41YoN2BIvmgQC03N5OWKz", "xpotzx92kYS", "WaPg1x3uwEHiu", "28liF7Ug1fq7LT93Jkda", "DJaApxMs4P8Fw5vQM3hjBZIJlCayXT4o"};
    }

    public S7(AnonymousClass20 r4) {
        this.A04 = r4;
        this.A05 = new AnonymousClass22(r4.A01);
        this.A00 = new AnonymousClass22(r4.A01);
    }

    public S7(AnonymousClass20 r4, Bundle bundle) {
        this.A04 = r4;
        this.A05 = (AnonymousClass22) LI.A00(bundle.getByteArray(A00(19, 9, 23)));
        this.A00 = (AnonymousClass22) LI.A00(bundle.getByteArray(A00(28, 13, 30)));
        this.A02 = bundle.getBoolean(A00(8, 5, 54));
        this.A03 = bundle.getBoolean(A00(13, 6, 98));
        this.A01 = bundle.getBoolean(A00(0, 8, 79));
    }

    private void A01() {
        this.A01 = true;
        A02();
    }

    private void A02() {
        AnonymousClass22 r3;
        this.A02 = true;
        if (this.A03) {
            r3 = this.A00;
        } else {
            r3 = this.A05;
        }
        this.A04.A00(this.A01, this.A03, r3);
    }

    private void A03() {
        this.A03 = true;
        A01();
    }

    public final Bundle A06() {
        Bundle bundle = new Bundle();
        bundle.putByteArray(A00(28, 13, 30), LI.A01(this.A00));
        bundle.putByteArray(A00(19, 9, 23), LI.A01(this.A05));
        bundle.putBoolean(A00(8, 5, 54), this.A02);
        bundle.putBoolean(A00(13, 6, 98), this.A03);
        bundle.putBoolean(A00(0, 8, 79), this.A01);
        return bundle;
    }

    public final void A07() {
        if (!this.A02) {
            this.A00.A03();
        }
    }

    public final void A08(double d, double d2) {
        double A012;
        if (!this.A02) {
            AnonymousClass22 r3 = this.A05;
            if (A07[5].length() != 13) {
                throw new RuntimeException();
            }
            String[] strArr = A07;
            strArr[4] = "MN6YiANN1x8";
            strArr[4] = "MN6YiANN1x8";
            r3.A04(d, d2);
            this.A00.A04(d, d2);
            if (this.A04.A03) {
                A012 = this.A00.A00().A03();
            } else {
                A012 = this.A00.A00().A01();
            }
            if (this.A04.A00 >= 0.0d && this.A05.A00().A04() > this.A04.A00 && A012 == 0.0d) {
                A01();
            } else if (A012 >= this.A04.A02) {
                A03();
            }
        }
    }
}
