package com.facebook.ads.redexgen.X;

import android.net.Uri;
import androidx.annotation.Nullable;
import java.util.Arrays;

/* renamed from: com.facebook.ads.redexgen.X.Hw  reason: case insensitive filesystem */
public final class C0456Hw {
    public static byte[] A00;

    static {
        A03();
    }

    public static String A02(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A00, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] - i3) - 88);
        }
        return new String(copyOfRange);
    }

    public static void A03() {
        A00 = new byte[]{-40, -21, -30, -46, -33, -40, -31, -10, 9, 0, -16, 3, -10, -11, -6, 3};
    }

    public static long A00(AbstractC0455Hv hv) {
        return hv.A5D(A02(0, 7, 27), -1);
    }

    @Nullable
    public static Uri A01(AbstractC0455Hv hv) {
        String A5E = hv.A5E(A02(7, 9, 57), null);
        if (A5E == null) {
            return null;
        }
        return Uri.parse(A5E);
    }

    public static void A04(C0457Hx hx) {
        hx.A02(A02(7, 9, 57));
    }

    public static void A05(C0457Hx hx, long j) {
        hx.A03(A02(0, 7, 27), j);
    }

    public static void A06(C0457Hx hx, Uri uri) {
        hx.A04(A02(7, 9, 57), uri.toString());
    }
}
