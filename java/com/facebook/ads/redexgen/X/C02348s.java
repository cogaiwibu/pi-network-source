package com.facebook.ads.redexgen.X;

import android.annotation.SuppressLint;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import java.util.Arrays;

/* renamed from: com.facebook.ads.redexgen.X.8s  reason: invalid class name and case insensitive filesystem */
public final class C02348s {
    public static byte[] A01;
    public static String[] A02;
    public static final String A03 = Build.VERSION.RELEASE;
    public final AnonymousClass8H A00;

    public static String A00(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A01, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] - i3) - 84);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A01 = new byte[]{-17, -4, -14, 0, -3, -9, -14, -68, -2, -13, 0, -5, -9, 1, 1, -9, -3, -4, -68, -48, -41, -36, -46, -19, -49, -47, -47, -45, -31, -31, -41, -48, -41, -38, -41, -30, -25, -19, -31, -45, -32, -28, -41, -47, -45, -47, -49, -40, -49, -36, -45, -51, -13, -21, -14, -15, -24};
    }

    public static void A02() {
        A02 = new String[]{"4UXivJ9bWzVmUKEORuimcsc25E9yHKjM", "eA36e27H2SQKTgfHA43cU1z3ajsDp04A", "C0QLMKXu1JepGMQqxbYq5t6gzwkqhJGP", "Vxu4w1TEkVm1YGegZeLuyUzWRGhVVehU", "9DWEeZJi13noDyT5Fh2XUwX4KzxcmXKd", "eTzqs10iSeQQ2KrnCOv26Mt4rNMbsJLV", "s8UczS0FAxqS0Axd9J", "JShALZiYLlnObKc6igiSgdntorMevFdl"};
    }

    static {
        A02();
        A01();
    }

    public C02348s(AnonymousClass8H r1) {
        this.A00 = r1;
    }

    public final int A03() {
        return L1.A01(this.A00);
    }

    @SuppressLint({"CatchGeneralException"})
    public final int A04() {
        try {
            return this.A00.getPackageManager().getPackageInfo(A07(), 0).versionCode;
        } catch (Throwable th) {
            this.A00.A04().A82(A00(45, 7, 22), C02248i.A14, new C02258j(th));
            return 0;
        }
    }

    /* JADX INFO: Multiple debug info for r6v0 'this'  com.facebook.ads.redexgen.X.8s: [D('t' java.lang.Throwable), D('ai' android.content.pm.ApplicationInfo)] */
    @SuppressLint({"CatchGeneralException"})
    public final String A05() {
        try {
            CharSequence applicationLabel = this.A00.getPackageManager().getApplicationLabel(this.A00.getPackageManager().getApplicationInfo(A07(), 0));
            if (applicationLabel != null && applicationLabel.length() > 0) {
                return applicationLabel.toString();
            }
        } catch (Throwable th) {
            this.A00.A04().A82(A00(45, 7, 22), C02248i.A14, new C02258j(th));
        }
        if (A02[6].length() != 18) {
            throw new RuntimeException();
        }
        String[] strArr = A02;
        strArr[6] = "1fZ6UIp0jk3A9Vyxip";
        strArr[6] = "1fZ6UIp0jk3A9Vyxip";
        return A00(0, 0, 80);
    }

    @SuppressLint({"CatchGeneralException"})
    public final String A06() {
        String str = null;
        try {
            str = this.A00.getPackageManager().getPackageInfo(A07(), 0).versionName;
        } catch (Throwable th) {
            this.A00.A04().A8G(A00(45, 7, 22), C02248i.A14, new C02258j(th));
        }
        return !TextUtils.isEmpty(str) ? str : A00(0, 0, 80);
    }

    public final String A07() {
        PendingIntent activity = PendingIntent.getActivity(this.A00, 0, new Intent(), 0);
        if (activity == null) {
            return A00(0, 0, 80);
        }
        if (Build.VERSION.SDK_INT >= 17) {
            return activity.getCreatorPackage();
        }
        return activity.getTargetPackage();
    }

    public final String A08() {
        String networkOperatorName;
        TelephonyManager telephonyManager = (TelephonyManager) this.A00.getSystemService(A00(52, 5, 47));
        if (telephonyManager != null && (networkOperatorName = telephonyManager.getNetworkOperatorName()) != null && networkOperatorName.length() > 0) {
            return networkOperatorName;
        }
        String[] strArr = A02;
        if (strArr[5].charAt(29) != strArr[2].charAt(29)) {
            throw new RuntimeException();
        }
        String[] strArr2 = A02;
        strArr2[0] = "4uAFXpJjJNyMuVCL4IR188dhDRybrTml";
        strArr2[0] = "4uAFXpJjJNyMuVCL4IR188dhDRybrTml";
        return A00(0, 0, 80);
    }

    public final String A09() {
        if (Build.MANUFACTURER != null) {
            int length = Build.MANUFACTURER.length();
            String[] strArr = A02;
            if (strArr[5].charAt(29) != strArr[2].charAt(29)) {
                throw new RuntimeException();
            }
            String[] strArr2 = A02;
            strArr2[0] = "4KWcrXNI2CiMu5mhxtQIP5VVZPBJmlLQ";
            strArr2[0] = "4KWcrXNI2CiMu5mhxtQIP5VVZPBJmlLQ";
            if (length > 0) {
                return Build.MANUFACTURER;
            }
        }
        return A00(0, 0, 80);
    }

    public final String A0A() {
        return (Build.MODEL == null || Build.MODEL.length() <= 0) ? A00(0, 0, 80) : Build.MODEL;
    }

    /* JADX INFO: Multiple debug info for r6v0 'this'  com.facebook.ads.redexgen.X.8s: [D('t' java.lang.Throwable), D('pkgName' java.lang.String)] */
    @SuppressLint({"CatchGeneralException"})
    public final String A0B() {
        String installer_name;
        try {
            String A07 = A07();
            if (A07 != null && A07.length() >= 0 && (installer_name = this.A00.getPackageManager().getInstallerPackageName(A07)) != null && installer_name.length() > 0) {
                return installer_name;
            }
        } catch (Throwable th) {
            this.A00.A04().A8G(A00(45, 7, 22), C02248i.A14, new C02258j(th));
        }
        return A00(0, 0, 80);
    }

    public final boolean A0C() {
        return this.A00.checkCallingOrSelfPermission(A00(0, 45, 58)) == 0;
    }
}
