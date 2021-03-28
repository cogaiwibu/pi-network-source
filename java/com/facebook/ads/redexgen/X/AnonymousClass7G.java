package com.facebook.ads.redexgen.X;

import androidx.annotation.Nullable;
import java.util.Arrays;

/* renamed from: com.facebook.ads.redexgen.X.7G  reason: invalid class name */
public class AnonymousClass7G {
    public static byte[] A09;
    public long A00 = -1;
    @Nullable
    public Integer A01;
    public String A02 = A00(0, 4, 123);
    public String A03 = A00(0, 0, 9);
    public boolean A04;
    public boolean A05;
    public final String A06;
    public final String A07;
    public final String A08;

    static {
        A01();
    }

    public static String A00(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A09, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] ^ i3) ^ 79);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A09 = new byte[]{88, 91, 85, 80};
    }

    public AnonymousClass7G(String str, String str2, String str3) {
        this.A08 = str;
        this.A07 = str2;
        this.A06 = str3;
        this.A01 = null;
    }

    public AnonymousClass7G(String str, String str2, String str3, long j) {
        this.A08 = str;
        this.A07 = str2;
        this.A06 = str3;
        this.A01 = null;
        this.A00 = j;
    }
}
