package com.facebook.ads.redexgen.X;

import androidx.annotation.Nullable;
import java.util.Arrays;

/* renamed from: com.facebook.ads.redexgen.X.06  reason: invalid class name */
public final class AnonymousClass06 {
    public static byte[] A0B;
    public int A00 = -1;
    public int A01 = -1;
    @Nullable
    public Integer A02;
    public String A03;
    public String A04 = A00(0, 0, 45);
    public boolean A05;
    public final String A06;
    public final String A07;
    public final String A08;
    public final String A09;
    public final boolean A0A;

    static {
        A01();
    }

    public static String A00(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A0B, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] - i3) - 111);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A0B = new byte[]{4, -3, -6, -3, -2, 6, -3};
    }

    public AnonymousClass06(AnonymousClass06 r4) {
        this.A09 = r4.A09;
        this.A08 = r4.A08;
        this.A06 = r4.A06;
        this.A07 = r4.A07;
        this.A02 = r4.A02;
        this.A03 = r4.A03;
        this.A0A = r4.A0A;
    }

    public AnonymousClass06(String str) {
        this.A09 = str;
        String A002 = A00(0, 7, 32);
        this.A08 = A002;
        this.A06 = A002;
        this.A07 = A002;
        this.A02 = null;
        this.A03 = A002;
        this.A0A = false;
    }

    public AnonymousClass06(String str, String str2, String str3, String str4, String str5, boolean z) {
        this.A09 = str;
        this.A08 = str2;
        this.A06 = str3;
        this.A07 = str4;
        this.A02 = null;
        this.A03 = str5;
        this.A0A = z;
    }
}
