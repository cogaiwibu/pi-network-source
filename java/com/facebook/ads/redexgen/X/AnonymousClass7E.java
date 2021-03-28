package com.facebook.ads.redexgen.X;

import androidx.annotation.Nullable;
import java.util.Arrays;

/* renamed from: com.facebook.ads.redexgen.X.7E  reason: invalid class name */
public class AnonymousClass7E {
    public static byte[] A08;
    public static String[] A09;
    @Nullable
    public AnonymousClass7M A00;
    public String A01 = A00(0, 4, 69);
    public boolean A02;
    public final int A03;
    public final int A04;
    public final String A05;
    public final String A06;
    public final String A07;

    static {
        A02();
        A01();
    }

    public static String A00(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A08, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] ^ i3) ^ 34);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        String[] strArr = A09;
        if (strArr[1].charAt(7) != strArr[2].charAt(7)) {
            String[] strArr2 = A09;
            strArr2[0] = "MYUg0L4zDuLwpF69sKnSAkLFZGAyisTY";
            strArr2[3] = "z6mwSfGh97";
            A08 = new byte[]{11, 8, 6, 3};
            return;
        }
        throw new RuntimeException();
    }

    public static void A02() {
        A09 = new String[]{"XfFEJYzZGPN2q5HAGj6MgKNVfzLwmSZX", "IEOpES1QDH9OfLZ6kJp7GuGkL18XBoIG", "WALKiAt1LYWQmYrQVF547JQW7ZyvBxoS", "camCesiVcQ", "gegEJgEL8kfxybdRvZS3nVx2Pjrjbaxz", "VPdzUQ79XvyfUeAOXKMfgbC8CxalnODj", "j10tNg164Uuijv40qzFG2IFbsKPXtge5", "FPgW5aqA35oZNLthCad5U5lgXJ4OAu7U"};
    }

    public AnonymousClass7E(String str, int i, int i2, String str2, String str3) {
        this.A07 = str;
        this.A03 = i;
        this.A04 = i2;
        this.A06 = str2;
        this.A05 = str3;
        this.A02 = false;
    }
}
