package com.facebook.ads.redexgen.X;

import android.os.Process;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import java.lang.Thread;
import java.util.Arrays;
import java.util.Map;

/* renamed from: com.facebook.ads.redexgen.X.8Y  reason: invalid class name */
public final class AnonymousClass8Y implements Thread.UncaughtExceptionHandler {
    public static byte[] A04;
    public final C0821Wi A00;
    public final AbstractC02218f A01;
    public final Thread.UncaughtExceptionHandler A02;
    public final Map<String, String> A03;

    static {
        A01();
    }

    public static String A00(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A04, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] ^ i3) ^ 65);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A04 = new byte[]{42, 28, 94, 122, 96, 96, 122, 125, 116, 51, 80, 124, 125, 103, 118, 107, 103, 11, 7, 5, 70, 14, 9, 11, 13, 10, 7, 7, 3, 70, 9, 12, 27, 71, 86, 69, 87, 76, 20, 18, 5, 19, 30, 23, 2, 80, 86, 65, 87, 90, 83, 70, 124, 64, 76, 71, 70};
    }

    public AnonymousClass8Y(@Nullable Thread.UncaughtExceptionHandler uncaughtExceptionHandler, C0821Wi wi, AnonymousClass8X r4) {
        this(uncaughtExceptionHandler, wi, r4, C02228g.A00());
    }

    public AnonymousClass8Y(@Nullable Thread.UncaughtExceptionHandler uncaughtExceptionHandler, C0821Wi wi, AnonymousClass8X r7, AbstractC02218f r8) {
        this.A02 = uncaughtExceptionHandler;
        if (wi != null) {
            this.A00 = wi;
            this.A03 = r7.A6y(wi);
            this.A01 = r8;
            return;
        }
        throw new IllegalArgumentException(A00(2, 15, 82));
    }

    public static void A02() {
        try {
            Process.killProcess(Process.myPid());
        } catch (Throwable unused) {
        }
        try {
            System.exit(10);
        } catch (Throwable unused2) {
        }
    }

    private void A03(Thread thread, Throwable th) {
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.A02;
        if (uncaughtExceptionHandler != null) {
            uncaughtExceptionHandler.uncaughtException(thread, th);
        } else {
            A02();
        }
    }

    public final void uncaughtException(Thread thread, Throwable th) {
        try {
            String A032 = LN.A03(this.A00, th);
            if (!TextUtils.isEmpty(A032) && A032.contains(A00(17, 16, 41))) {
                Map<String, String> A022 = new AnonymousClass8W(A032, this.A03).A02();
                A022.put(A00(38, 7, 38), A00(33, 5, 101));
                Throwable A002 = KP.A00();
                String A003 = A00(45, 12, 98);
                if (A002 == th) {
                    A022.put(A003, A00(1, 1, 108));
                } else {
                    A022.put(A003, A00(0, 1, 91));
                }
                this.A01.ADw(new C02288m(this.A00.A05().A01(), this.A00.A05().A02(), A022), this.A00);
                if (J8.A19(this.A00)) {
                    J8.A0a(this.A00);
                }
            }
        } catch (Exception unused) {
        }
        A03(thread, th);
    }
}
