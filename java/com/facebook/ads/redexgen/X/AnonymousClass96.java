package com.facebook.ads.redexgen.X;

import android.content.Context;
import android.os.Build;
import android.util.Log;
import com.facebook.ads.internal.api.BuildConfigApi;
import com.facebook.imagepipeline.common.RotationOptions;
import java.io.File;
import java.util.Arrays;
import java.util.TimeZone;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.facebook.ads.redexgen.X.96  reason: invalid class name */
public final class AnonymousClass96 {
    public static byte[] A00;
    public static String[] A01;
    public static final String A02 = AnonymousClass96.class.getSimpleName();
    public static final AtomicBoolean A03 = new AtomicBoolean();

    public static String A02(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A00, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] - i3) - 105);
        }
        return new String(copyOfRange);
    }

    public static void A06() {
        A00 = new byte[]{19, 39, 90, 78, 81, 73, 40, 84, 83, 75, 78, 76, 40, 85, 75, 89, 86, 80, 75, 7, 58, 43, 50, 7, 73, 92, 80, 83, 91, 7, 77, 86, 89, 7, 95, 31, 29, 14, 33, 21, 24, 16, 43, 32, 37, 28, 17, -34, 10, 16, 7, -1, -69, 9, 10, 15, -69, -4, -1, -1, -69, 11, -4, 13, -4, 8, 0, 15, 0, 13, -43, -82, -81, -84, -65, -79, 41, 81, 89, 80, 69, 88, 83, 86, -3, 27, 36, 47, 35, 37, 42, 31, 37, 36, 7, -24, -6, -2, 13, 8, -4, 16, 6, 23, 2, 59, 74, 74, 57, 77, 78, 59, 76, 78, 63, 62, 57, 76, 63, 59, 77, 73, 72, 43, 62, 50, 53, 45, 40, 61, 66, 57, 46, 10, 11, 8, 27, 13, 5, 28, 7, 18, 27, 11, 69, 67, 76, 67, 80, 71, 65, 52, 60, 60, 52, 57, 50, 44, 64, 49, 56, 65, 75, 55, 60, 61, 58, 77, 63, 63, 57, 58, 68, 61, 81, 91, 71, 77, 85, 93, 38, 27, 31, 23, 44, 33, 32, 23, 17, 33, 24, 24, 37, 23, 38, 59, 52, 49, 52, 53, 61, 52};
    }

    public static void A07() {
        A01 = new String[]{"Zl9Gy", "71kQi3IibsstuH4HIc9NqplK3KKhyeB5", "mg3crekamZV3aPoxR2E4kv0bqU3kjrTA", "tDWcsuqYwEAdFujtzhVkOh2ka7NI4A0", "PNHzgcYnRnalJ1JX3eWvzB80MfZWvl", "qlQSSPcQAlkQmsVxSKI5q3x7hOoP3mTT", "zrCnzE5ZwKYUMsAQc774FEfNlTnoEqKy", "Bh9hDulTgnsRRUxUYqeR6BXC7"};
    }

    static {
        A07();
        A06();
    }

    public static int A00() {
        return TimeZone.getDefault().getRawOffset();
    }

    public static long A01(AnonymousClass8H r5) {
        try {
            return new File(r5.getPackageManager().getApplicationInfo(r5.getPackageName(), 0).publicSourceDir).length();
        } catch (Exception e) {
            if (!A03.compareAndSet(false, true)) {
                return -1;
            }
            r5.A04().A82(A02(144, 7, 117), C02248i.A0z, new C02258j(e));
            return -1;
        }
    }

    public static String A03(Context context) {
        try {
            return (String) Class.forName(context.getPackageName() + A02(0, 12, 124)).getDeclaredField(A02(37, 10, 99)).get(null);
        } catch (Exception unused) {
            return A02(94, 3, 80);
        }
    }

    public static String A04(Context context) {
        try {
            return String.valueOf(Class.forName(context.getPackageName() + A02(0, 12, 124)).getDeclaredField(A02(71, 5, 1)).getBoolean(null));
        } catch (Exception unused) {
            return A02(94, 3, 80);
        }
    }

    public static String A05(AnonymousClass8H r5) {
        JSONObject jSONObject = new JSONObject();
        A08(jSONObject, A02(174, 6, 127), String.valueOf(A09()));
        A08(jSONObject, A02(97, 8, 52), String.valueOf(A01(r5)));
        A08(jSONObject, A02(RotationOptions.ROTATE_180, 15, 73), String.valueOf(A00()));
        A08(jSONObject, A02(105, 18, 113), String.valueOf(C0520Km.A01(r5)));
        A08(jSONObject, A02(161, 13, 111), String.valueOf(A0A(r5)));
        A08(jSONObject, A02(133, 11, 61), A04(r5));
        A08(jSONObject, A02(123, 10, 96), A03(r5));
        return jSONObject.toString();
    }

    public static void A08(JSONObject jSONObject, String str, String str2) {
        try {
            jSONObject.put(str, str2);
        } catch (JSONException e) {
            if (BuildConfigApi.isDebug()) {
                Log.e(A02, A02(47, 24, 50), e);
            }
        }
    }

    public static boolean A09() {
        String str = Build.FINGERPRINT;
        String A022 = A02(144, 7, 117);
        if (!str.contains(A022) && !Build.FINGERPRINT.startsWith(A02(195, 7, 93))) {
            String str2 = Build.MODEL;
            String A023 = A02(151, 10, 100);
            boolean contains = str2.contains(A023);
            String[] strArr = A01;
            if (strArr[2].charAt(18) != strArr[1].charAt(18)) {
                String[] strArr2 = A01;
                strArr2[2] = "pyp5tHHiNqtWEHhOUDcaxWXpzbT8klnO";
                strArr2[1] = "oLUMgMxReJrH8Y2AxnJ9tXY49GWGMSpB";
                if (!contains) {
                    String str3 = Build.MODEL;
                    if (A01[3].length() == 31) {
                        String[] strArr3 = A01;
                        strArr3[3] = "kPRAmUopJCVKL3kgnj9rN6E7NTwJXhY";
                        strArr3[3] = "kPRAmUopJCVKL3kgnj9rN6E7NTwJXhY";
                        return str3.contains(A02(76, 8, 123)) || Build.MODEL.contains(A02(12, 25, 126)) || Build.MANUFACTURER.contains(A02(84, 10, 77)) || (Build.BRAND.startsWith(A022) && Build.DEVICE.startsWith(A022)) || A023.equals(Build.PRODUCT);
                    }
                }
            }
            throw new RuntimeException();
        }
    }

    public static boolean A0A(Context context) {
        return (context.getApplicationInfo().flags & 2) != 0;
    }
}
