package com.facebook.ads.redexgen.X;

import android.content.SharedPreferences;
import androidx.annotation.Nullable;
import com.facebook.ads.internal.util.process.ProcessUtils;
import java.util.Arrays;

/* renamed from: com.facebook.ads.redexgen.X.5t  reason: invalid class name and case insensitive filesystem */
public final class C01665t {
    public static byte[] A00;

    static {
        A02();
    }

    public static String A01(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A00, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] ^ i3) ^ 33);
        }
        return new String(copyOfRange);
    }

    public static void A02() {
        A00 = new byte[]{45, 59, 16, 42, 55, 59, 61, 46, 60, 43, 39, 37, 102, 46, 41, 43, 45, 42, 39, 39, 35, 102, 41, 44, 59, 102, 33, 38, 60, 45, 58, 38, 41, 36, 102, 42, 60, 45, 48, 60, 58, 41, 59};
    }

    public static SharedPreferences A00(AnonymousClass8H r3) {
        return r3.getSharedPreferences(ProcessUtils.getProcessSpecificName(A01(9, 34, 105), r3), 0);
    }

    @Nullable
    public final String A03(AnonymousClass8H r5) {
        return A00(r5).getString(A01(0, 9, 110), null);
    }

    public final void A04(AnonymousClass8H r5, String str) {
        A00(r5).edit().putString(A01(0, 9, 110), str).apply();
    }
}
