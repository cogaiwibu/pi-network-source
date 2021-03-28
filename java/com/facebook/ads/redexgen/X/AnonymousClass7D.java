package com.facebook.ads.redexgen.X;

import android.net.TrafficStats;
import java.util.Arrays;
import java.util.concurrent.Callable;

/* renamed from: com.facebook.ads.redexgen.X.7D  reason: invalid class name */
public class AnonymousClass7D implements Callable<Boolean> {
    public static byte[] A02;
    public static String[] A03;
    public final AnonymousClass7G A00;
    public final /* synthetic */ AnonymousClass7H A01;

    static {
        A03();
        A02();
    }

    public static String A01(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A02, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] ^ i3) ^ 32);
        }
        return new String(copyOfRange);
    }

    public static void A02() {
        A02 = new byte[]{114, 126, 109, 116, 106, 111, 43, 52, 57, 56, 50};
        if (A03[1].length() != 15) {
            throw new RuntimeException();
        }
        String[] strArr = A03;
        strArr[7] = "XFV0lH04tD";
        strArr[5] = "8rdCtS3Igw";
    }

    public static void A03() {
        A03 = new String[]{"4L70rbdc", "PBHhMXx0npnpwTY", "91GJPzFmEyeOW3DYeKz29HPCrWXW0gNC", "umTRidE45okZulrVlJrHIV8", "kRbho3HgdeG0CdJ8rA209tRImftPXEnI", "60YY30c8MY", "ZuHjaYDngPTOcLYvMZdLe8TI8ruUn8GD", "lL0vcWHD5F"};
    }

    public AnonymousClass7D(AnonymousClass7H r1, AnonymousClass7G r2) {
        this.A01 = r1;
        this.A00 = r2;
    }

    private final Boolean A00() {
        String A012;
        if (KU.A02(this)) {
            return null;
        }
        try {
            TrafficStats.setThreadStatsTag(61453);
            if (this.A00.A04) {
                A012 = A01(0, 6, 63);
            } else {
                A012 = A01(6, 5, 125);
            }
            AnonymousClass06 r5 = new AnonymousClass06(this.A00.A08, this.A00.A07, this.A00.A06, A012, this.A00.A02, this.A00.A05);
            r5.A04 = this.A00.A03;
            r5.A02 = this.A00.A01;
            r5.A05 = this.A00.A04;
            if (AnonymousClass7K.A06(this.A01.A04)) {
                AnonymousClass7H.A0E.put(this.A00.A08, r5);
            }
            return Boolean.valueOf(AnonymousClass7H.A02(this.A01.A04.A00()).ACY(r5) != null);
        } catch (Throwable th) {
            KU.A00(th, this);
            return null;
        }
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // java.util.concurrent.Callable
    public final /* bridge */ /* synthetic */ Boolean call() throws Exception {
        if (KU.A02(this)) {
            return null;
        }
        try {
            return A00();
        } catch (Throwable th) {
            KU.A00(th, this);
            return null;
        }
    }
}
