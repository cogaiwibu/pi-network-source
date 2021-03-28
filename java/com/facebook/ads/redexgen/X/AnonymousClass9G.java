package com.facebook.ads.redexgen.X;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.SystemClock;
import android.text.TextUtils;
import android.webkit.WebSettings;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.facebook.ads.internal.api.BuildConfigApi;
import com.facebook.ads.internal.util.process.ProcessUtils;
import java.util.Arrays;
import java.util.Locale;
import java.util.concurrent.FutureTask;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* renamed from: com.facebook.ads.redexgen.X.9G  reason: invalid class name */
public final class AnonymousClass9G {
    public static String A00 = A00(83, 7, 65);
    public static byte[] A01;
    public static String[] A02;
    public static final AtomicBoolean A03 = new AtomicBoolean();
    public static final AtomicReference<String> A04 = new AtomicReference<>();

    public static String A00(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A01, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] ^ i3) ^ 19);
        }
        return new String(copyOfRange);
    }

    public static void A08() {
        A01 = new byte[]{76, 55, 71, 45, 2, 8, 30, 3, 5, 8, 44, 40, 43, 40, 69, 24, 28, 31, 16, 113, 31, 43, 58, 55, 59, 48, 61, 59, 16, 59, 42, 41, 49, 44, 53, 24, 49, 44, 31, 48, 58, 44, 49, 55, 58, 101, 99, 103, 100, 115, 10, 32, 36, 36, 48, 73, 16, 20, 26, 21, 121, 72, 76, 93, 64, 33, 7, 3, 18, 23, 110, 26, 30, 10, 15, 115, 43, 50, 36, 53, 46, 55, 55, 7, 60, 57, 60, 61, 37, 60, 4, 48, 60, 62, 125, 53, 50, 48, 54, 49, 60, 60, 56, 125, 50, 55, 32, 125, 58, 61, 39, 54, 33, 61, 50, 63, 125, 38, 50, 46, 44, 39, 44, 59, 32, 42, 47, 51, 51, 55, 105, 38, 32, 34, 41, 51, 87, 81, 71, 80, 125, 67, 69, 71, 76, 86, 106, 108, 122, 109, 64, 126, 120, 122, 113, 107, 64, 115, 126, 108, 107, 64, 109, 122, 121, 109, 122, 108, 119, 120, 106, 109, 80, 121, 102, 106, 120};
    }

    public static void A09() {
        A02 = new String[]{"Qr1EFu0kx1tI01867m6ODqfSZ9SwtWDI", "3TYgkAWbIjP9kMvunjr7VwfmqgOZ7ZQ4", "kyx9q1x7DLL5BxK3faNs604Sw4dxbCMr", "cJW9lkVABx2P1Kp63XktrUnlRFV2zQAL", "nhxLXaLaMxGTsXNVJcvnwyCHZZV2RS3H", "y9xLyKazRl3zNBUnfIZmAOMjGK0AXhl4", "DTEqb4TbXnNBCaxA5atVnYK0pSb9DMUi", "fZvghiN"};
    }

    static {
        A09();
        A08();
    }

    @TargetApi(17)
    @VisibleForTesting
    public static String A01(AnonymousClass8H r0) {
        return WebSettings.getDefaultUserAgent(r0);
    }

    @Nullable
    @SuppressLint({"CatchGeneralException"})
    public static String A02(AnonymousClass8H r4) {
        FutureTask futureTask = new FutureTask(new AnonymousClass9F(r4));
        for (int i = 0; i < 3; i++) {
            LZ.A00(futureTask);
            try {
                return (String) futureTask.get();
            } catch (Throwable t) {
                A0A(r4, t);
                SystemClock.sleep(500);
            }
        }
        return null;
    }

    public static String A03(AnonymousClass8H r5, C02348s r6) {
        String A07 = r6.A07();
        if (TextUtils.isEmpty(A07)) {
            boolean andSet = A03.getAndSet(true);
            String[] strArr = A02;
            if (strArr[4].charAt(26) != strArr[3].charAt(26)) {
                throw new RuntimeException();
            }
            String[] strArr2 = A02;
            strArr2[1] = "SlGltdwaGCQXXY2U2bjZ1NfeES9SOW6r";
            strArr2[0] = "AnJMWH4pc3dV3Xqon1tLsffrk7nZCcYt";
            if (!andSet) {
                r5.A04().A82(A00(119, 7, 90), C02248i.A1G, new C02258j(A00(76, 7, 104)));
            }
        }
        return A07;
    }

    /* JADX INFO: Multiple debug info for r14v0 com.facebook.ads.redexgen.X.8H: [D('t' java.lang.Throwable), D('browserUserAgent' java.lang.String)] */
    @Nullable
    @SuppressLint({"CatchGeneralException"})
    public static String A04(AnonymousClass8H r14, boolean z) {
        if (r14 == null) {
            return A00;
        }
        if (z) {
            return System.getProperty(A00(126, 10, 84));
        }
        String str = A04.get();
        if (str != null) {
            return str;
        }
        long A012 = J7.A01(r14);
        String A002 = A00(146, 23, 12);
        String A003 = A00(136, 10, 49);
        String A004 = A00(91, 28, 64);
        if (A012 > 0) {
            SharedPreferences sharedPreferences = r14.getSharedPreferences(ProcessUtils.getProcessSpecificName(A004, r14), 0);
            String string = sharedPreferences.getString(A003, null);
            long j = sharedPreferences.getLong(A002, 0);
            if (!TextUtils.isEmpty(string) && System.currentTimeMillis() - j < A012) {
                A04.set(string);
                return string;
            }
        }
        String str2 = null;
        if (Build.VERSION.SDK_INT >= 17) {
            try {
                str2 = A01(r14);
                A04.set(str2);
            } catch (Throwable th) {
                A0A(r14, th);
            }
        }
        if (str2 == null) {
            str2 = A02(r14);
        }
        if (str2 == null) {
            return A00;
        }
        int i = (A012 > 0 ? 1 : (A012 == 0 ? 0 : -1));
        String[] strArr = A02;
        if (strArr[4].charAt(26) != strArr[3].charAt(26)) {
            throw new RuntimeException();
        }
        String[] strArr2 = A02;
        strArr2[7] = "Kvz6zSF";
        strArr2[7] = "Kvz6zSF";
        if (i > 0) {
            SharedPreferences sharedPreferences2 = r14.getSharedPreferences(ProcessUtils.getProcessSpecificName(A004, r14), 0);
            sharedPreferences2.edit().putString(A003, A04.get()).apply();
            sharedPreferences2.edit().putLong(A002, System.currentTimeMillis()).apply();
        }
        return str2;
    }

    public static String A05(C02348s r5, AnonymousClass8H r6) {
        if (!J7.A05(r6)) {
            return A00(0, 0, 40);
        }
        StringBuilder sb = new StringBuilder();
        sb.append(A00(10, 5, 121));
        sb.append(A03(r6, r5));
        String A002 = A00(2, 1, 111);
        sb.append(A002);
        sb.append(A00(46, 5, 54));
        sb.append(r5.A06());
        sb.append(A002);
        sb.append(A00(51, 5, 117));
        sb.append(r5.A04());
        sb.append(A002);
        return sb.toString();
    }

    public static String A06(C02348s r5, AnonymousClass8H r6, boolean z) {
        StringBuilder sb = new StringBuilder();
        sb.append(A04(r6, z));
        sb.append(A00(0, 2, 127));
        sb.append(A00(15, 31, 77));
        sb.append(A00(61, 5, 29));
        sb.append(A00(3, 7, 127));
        String A002 = A00(2, 1, 111);
        sb.append(A002);
        sb.append(A00(66, 5, 82));
        sb.append(C02348s.A03);
        sb.append(A002);
        sb.append(A05(r5, r6));
        sb.append(A00(71, 5, 79));
        sb.append(BuildConfigApi.getVersionName(r6));
        sb.append(A002);
        sb.append(A00(56, 5, 69));
        sb.append(Locale.getDefault().toString());
        sb.append(A00(90, 1, 74));
        return sb.toString();
    }

    public static void A0A(AnonymousClass8H r5, Throwable th) {
        r5.A04().A82(A00(169, 8, 28), C02248i.A2E, new C02258j(th));
    }
}
