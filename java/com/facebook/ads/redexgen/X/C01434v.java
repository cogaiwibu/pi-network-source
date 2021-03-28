package com.facebook.ads.redexgen.X;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import com.facebook.ads.internal.api.AdSettingsApi;
import com.facebook.ads.internal.settings.AdInternalSettings;
import com.facebook.ads.internal.settings.AdSharedPreferences;
import com.facebook.ads.internal.settings.MultithreadedBundleWrapper;
import com.facebook.imageutils.JfifUtil;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.UUID;
import kotlin.jvm.internal.ByteCompanionObject;

/* renamed from: com.facebook.ads.redexgen.X.4v  reason: invalid class name and case insensitive filesystem */
public final class C01434v implements AdSettingsApi {
    public static byte[] A00;
    public static String[] A01;
    public static final String A02 = AdInternalSettings.class.getSimpleName();
    public static final Collection<String> A03 = new HashSet();
    public static volatile boolean A04 = false;

    public static String A00(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A00, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] ^ i3) ^ 48);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A00 = new byte[]{124, 119, 101, 8, 15, 9, 4, 31, 30, 13, 18, 24, 30, 4, 18, 31, 4, 19, 26, 8, 19, 4, 16, 30, 2, 107, 90, 76, 75, 31, 82, 80, 91, 90, 31, 91, 90, 73, 86, 92, 90, 31, 87, 94, 76, 87, 5, 31, 45, 18, 31, 20, 90, 14, 31, 9, 14, 19, 20, 29, 90, 3, 21, 15, 8, 90, 27, 10, 10, 90, 13, 19, 14, 18, 90, 60, 27, 25, 31, 24, 21, 21, 17, 93, 9, 90, 27, 30, 90, 15, 20, 19, 14, 9, 90, 3, 21, 15, 90, 23, 15, 9, 14, 90, 9, 10, 31, 25, 19, 28, 3, 90, 14, 18, 31, 90, 30, 31, 12, 19, 25, 31, 90, 18, 27, 9, 18, 31, 30, 90, 51, 62, 90, 14, 21, 90, 31, 20, 9, 15, 8, 31, 90, 14, 18, 31, 90, 30, 31, 22, 19, 12, 31, 8, 3, 90, 21, 28, 90, 14, 31, 9, 14, 90, 27, 30, 9, 86, 90, 27, 30, 30, 90, 14, 18, 31, 90, 28, 21, 22, 22, 21, 13, 19, 20, 29, 90, 25, 21, 30, 31, 90, 24, 31, 28, 21, 8, 31, 90, 22, 21, 27, 30, 19, 20, 29, 90, 27, 20, 90, 27, 30, 64, 90, 59, 30, 41, 31, 14, 14, 19, 20, 29, 9, 84, 27, 30, 30, 46, 31, 9, 14, 62, 31, 12, 19, 25, 31, 82, 88, 26, 27, 8, 23, 29, 27, 55, 26, 54, 31, 13, 22, 60, 52, 52, 60, 55, 62, 4, 40, 63, 48, 114, 101, 106, 102, 114, ByteCompanionObject.MAX_VALUE, 104, 40, 38, 96, 41, 61, 48, 39, 103, 105, 43, 47};
    }

    public static void A02() {
        A01 = new String[]{"TFkOB7WAPr6F4oSDAD2lBM3orjMmpCql", "qm70b4Ur0FRBuwfAT3tN36vqG0Nf4UFd", "zPpQ1cnfbXvczPvVr", "8IvLkkrNdMNEKNCoxjkf6IUs19Br2Jri", "GW45NL8mXfcvSmeq7", "yk6fztNbTNbTdYOeWP4a4qU6KiJuVBGT", "Yi7aT5eKgI7tScmdPed7vydq7f2NoqCT", "ldtlhzHQs0POAzCz5K2SoOIZIeNjlq2l"};
    }

    static {
        A02();
        A01();
        A03.add(A00(262, 3, 49));
        A03.add(A00(252, 10, 107));
        A03.add(A00(265, 7, 32));
        A03.add(A00(272, 8, 111));
    }

    public static void A03(String str) {
        if (!A04) {
            A04 = true;
            String str2 = A02;
            Log.i(str2, A00(25, 23, 15) + str);
            String str3 = A02;
            Log.i(str3, A00(48, JfifUtil.MARKER_SOFn, 74) + str + A00(0, 3, 110));
        }
    }

    @Override // com.facebook.ads.internal.api.AdSettingsApi
    public final boolean isTestMode(Context context) {
        if (AdInternalSettings.isDebugBuild() || AdInternalSettings.isExplicitTestMode() || A03.contains(Build.PRODUCT)) {
            return true;
        }
        MultithreadedBundleWrapper multithreadedBundleWrapper = AdInternalSettings.sSettingsBundle;
        String A002 = A00(3, 22, 107);
        String string = multithreadedBundleWrapper.getString(A002, null);
        if (string == null) {
            SharedPreferences sharedPreferences = AdSharedPreferences.getSharedPreferences(context);
            String A003 = A00(240, 12, 78);
            string = sharedPreferences.getString(A003, null);
            if (TextUtils.isEmpty(string)) {
                UUID randomUUID = UUID.randomUUID();
                if (A01[6].charAt(4) != 'r') {
                    String[] strArr = A01;
                    strArr[4] = "ACuTT9OHS44wxpENU";
                    strArr[2] = "rDA9ItLQjR7JTNF9w";
                    string = randomUUID.toString();
                    sharedPreferences.edit().putString(A003, string).apply();
                } else {
                    throw new RuntimeException();
                }
            }
            AdInternalSettings.sSettingsBundle.putString(A002, string);
        }
        if (AdInternalSettings.getTestDevicesList().contains(string)) {
            return true;
        }
        A03(string);
        return false;
    }

    @Override // com.facebook.ads.internal.api.AdSettingsApi
    public final void turnOnDebugger() {
        K0.A02();
    }
}
