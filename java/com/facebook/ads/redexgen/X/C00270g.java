package com.facebook.ads.redexgen.X;

import android.net.Uri;
import androidx.annotation.Nullable;
import java.util.Arrays;
import java.util.Map;

/* renamed from: com.facebook.ads.redexgen.X.0g  reason: invalid class name and case insensitive filesystem */
public final class C00270g {
    public static byte[] A00;
    public static final String A01 = C00270g.class.getSimpleName();

    public static String A02(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A00, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] ^ i3) ^ 33);
        }
        return new String(copyOfRange);
    }

    public static void A03() {
        A00 = new byte[]{111, 84, 91, 88, 86, 95, 26, 78, 85, 26, 74, 91, 72, 73, 95, 26, 80, 73, 85, 84, 26, 94, 91, 78, 91, 26, 83, 84, 26, 123, 94, 123, 89, 78, 83, 85, 84, 124, 91, 89, 78, 85, 72, 67, 20, 19, 22, 3, 22, 82, 77, 88, 83, 98, 81, 84, 83, 86, 94, 79, 92, 93, 71, 64, 73, 98, 115, 97, 97, 102, 122, 96, 125, 103, 117, 122, 24, 31, 4, 25, 14, 34, 61, 48, 49, 59, 11, 33, 38, 56};
    }

    static {
        A03();
    }

    @Nullable
    public static AbstractC00260f A00(C0820Wh wh, JE je, String str, Uri uri, Map<String, String> extraData) {
        return A01(wh, je, str, uri, extraData, true, false);
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x0092  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x00a2  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00cf  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00f5  */
    @androidx.annotation.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.facebook.ads.redexgen.X.AbstractC00260f A01(com.facebook.ads.redexgen.X.C0820Wh r14, com.facebook.ads.redexgen.X.JE r15, java.lang.String r16, android.net.Uri r17, java.util.Map<java.lang.String, java.lang.String> r18, boolean r19, boolean r20) {
        /*
        // Method dump skipped, instructions count: 254
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C00270g.A01(com.facebook.ads.redexgen.X.Wh, com.facebook.ads.redexgen.X.JE, java.lang.String, android.net.Uri, java.util.Map, boolean, boolean):com.facebook.ads.redexgen.X.0f");
    }

    public static boolean A04(String str) {
        return A02(76, 5, 74).equalsIgnoreCase(str) || A02(49, 9, 28).equalsIgnoreCase(str);
    }
}
