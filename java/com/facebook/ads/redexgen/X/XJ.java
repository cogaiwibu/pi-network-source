package com.facebook.ads.redexgen.X;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Base64OutputStream;
import androidx.annotation.Nullable;
import com.facebook.ads.internal.settings.AdSharedPreferences;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.zip.DeflaterOutputStream;
import kotlin.jvm.internal.ByteCompanionObject;
import org.json.JSONObject;

public final class XJ implements AnonymousClass9B {
    @Nullable
    public static String A03 = null;
    public static byte[] A04;
    public static String[] A05;
    public static final L5 A06 = L6.A00();
    public static final AtomicBoolean A07 = new AtomicBoolean();
    public static final AtomicInteger A08 = new AtomicInteger(0);
    public final C01665t A00;
    public final AnonymousClass8H A01;
    public final C02348s A02;

    public static String A01(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A04, i, i + i2);
        int i4 = 0;
        while (true) {
            int length = copyOfRange.length;
            if (A05[6].length() != 9) {
                String[] strArr = A05;
                strArr[1] = "AJGqtkftO03LFXDJsHlFXR4ujVWNfKsn";
                strArr[7] = "0weTThgY8dzMPuXGgH30KJvXs1017h9U";
                if (i4 >= length) {
                    return new String(copyOfRange);
                }
                copyOfRange[i4] = (byte) ((copyOfRange[i4] ^ i3) ^ 73);
                i4++;
            } else {
                throw new RuntimeException();
            }
        }
    }

    public static void A06() {
        A04 = new byte[]{40, 96, 98, 98, 100, 114, 114, 104, 99, 104, 109, 104, 117, 120, 126, 100, 111, 96, 99, 109, 100, 101, 21, 18, 4, 41, 46, 56, 83, 45, 34, 45, 32, 35, 43, 98, 115, 115, 124, 110, 106, 109, 124, 112, 103, 104, 124, 117, 102, 113, 112, 106, 108, 109, 85, 71, 92, 85, 71, 78, 92, 70, 75, 44, 57, 57, 63, 36, 47, 56, 57, 36, 34, 35, 50, 36, 41, 85, 94, 83, 83, 82, 69, 72, 67, 88, 92, 82, 89, 72, 82, 79, 67, 69, 86, 68, 106, 125, 102, 108, 100, 109, 63, 61, 44, 44, 57, 56, 35, 53, 56, 47, 79, 77, 94, 94, 69, 73, 94, 18, 23, 2, 23, 9, 6, 4, 25, 21, 19, 5, 5, 31, 24, 17, 9, 25, 6, 2, 31, 25, 24, 5, 67, 70, 83, 70, 88, 87, 85, 72, 68, 66, 84, 84, 78, 73, 64, 88, 72, 87, 83, 78, 72, 73, 84, 88, 68, 72, 82, 73, 83, 85, 94, 92, 89, 76, 89, 71, 72, 74, 87, 91, 93, 75, 75, 81, 86, 95, 71, 87, 72, 76, 81, 87, 86, 75, 71, 75, 76, 89, 76, 93, 111, 110, 101, 120, 98, ByteCompanionObject.MAX_VALUE, 114, 30, 57, 49, 52, 61, 60, 120, 44, 55, 120, 58, 45, 49, 52, 60, 120, 45, 43, 61, 42, 120, 44, 55, 51, 61, 54, 3, 10, 24, 20, 14, 19, 4, 27, 7, 10, 18, 14, 25, 63, 50, 48, 55, 17, 28, 7, 27, 25, 27, 16, 29, 7, 12, 11, 7, 21, 11, 94, 83, 72, 68, 88, 66, 69, 84, 82, 52, 51, 46, 41, 60, 49, 49, 56, 47, 53, 54, 58, 56, 53, 60, 33, 45, 39, 41, 43, 35, 34, 47, 39, 50, 47, 41, 40, 57, 53, 35, 52, 48, 47, 37, 35, 73, 66, 83, 80, 72, 85, 76, 88, 83, 94, 87, 66, 114, 111, 111, 116, 101, 100, 27, 11, 26, 13, 13, 6, 23, 0, 13, 1, 15, 0, 28, 85, 69, 84, 67, 67, 72, 89, 81, 79, 66, 82, 78, 92, 75, 68, 80, 76, 78, 95, 78, 77, 70, 67, 70, 91, 86, 14, 24, 14, 14, 20, 18, 19, 2, 9, 20, 16, 24, 103, 124, 123, 102, 107, 103, 97, 119, 96, 109, 115, 117, 119, 124, 102, 58, 45, 32, 60, 45, 62, 45, 33, 63, 75, 73, 66, 73, 94, 69, 79, 8, 19, 10, 10};
    }

    public static void A07() {
        A05 = new String[]{"rjWu3o3XUIKJimpXtRLH", "N3hUjd9gC1zTrolrzHWDwio6K0KaeF7v", "V8BOZxTrBek9nlJry76rEN1tEiA1lgnf", "2kaCuDD1e44XjFqxj97oS3bW7Y4jUXps", "VcJxC1jbHxk7XwGyeCWvHwY9E4qRcx1x", "dO6RHNbAuKw0kDbwpnJR", "8jPNINbp0cYAxxIn", "ugIdyp1aSJPFHYCiUHctz2XPYC5YD6Ud"};
    }

    static {
        A07();
        A06();
    }

    public XJ(AnonymousClass8H r2, boolean z, C01665t r4) {
        this.A01 = r2;
        this.A02 = new C02348s(r2);
        this.A00 = r4;
        A08(r2, z);
    }

    @Nullable
    @SuppressLint({"CatchGeneralException"})
    public static String A02(AnonymousClass8H r4, String str) {
        try {
            return LB.A02(r4.getPackageManager().getApplicationInfo(str, 0).sourceDir);
        } catch (Exception e) {
            if (!A07.compareAndSet(false, true)) {
                return null;
            }
            r4.A04().A82(A01(404, 7, 101), C02248i.A17, new C02258j(e));
            return null;
        }
    }

    @SuppressLint({"CatchGeneralException"})
    public static void A08(AnonymousClass8H r7, boolean z) {
        if (A08.compareAndSet(0, 1)) {
            try {
                SharedPreferences sharedPreferences = AdSharedPreferences.getSharedPreferences(r7);
                C02348s r5 = new C02348s(r7);
                String str = A01(25, 4, 33) + r5.A06();
                A03 = sharedPreferences.getString(str, null);
                FutureTask futureTask = new FutureTask(new AnonymousClass9D(r7, sharedPreferences, str));
                Executors.newSingleThreadExecutor().submit(futureTask);
                if (z) {
                    futureTask.get();
                }
            } catch (Exception unused) {
                AtomicInteger atomicInteger = A08;
                if (A05[2].charAt(4) != '1') {
                    String[] strArr = A05;
                    strArr[0] = "BG3uZRuA0Chr9fB7D4fD";
                    strArr[5] = "ED3rHXlImwDD4lq5TiwH";
                    atomicInteger.set(0);
                    return;
                }
                throw new RuntimeException();
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:34:0x030f, code lost:
        if (r3 != null) goto L_0x01b6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x01b4, code lost:
        if (r3 != null) goto L_0x01b6;
     */
    @Override // com.facebook.ads.redexgen.X.AnonymousClass9B
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.Map<java.lang.String, java.lang.String> A69() {
        /*
        // Method dump skipped, instructions count: 787
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.XJ.A69():java.util.Map");
    }

    @Override // com.facebook.ads.redexgen.X.AnonymousClass9B
    public final String A72() {
        return A73(AnonymousClass9A.A00());
    }

    @Override // com.facebook.ads.redexgen.X.AnonymousClass9B
    public final String A73(AnonymousClass99 r9) {
        A08(this.A01, true);
        ByteArrayOutputStream byteArrayOutputStream = null;
        Base64OutputStream base64OutputStream = null;
        DeflaterOutputStream deflaterOutputStream = null;
        try {
            ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
            Base64OutputStream base64OutputStream2 = new Base64OutputStream(byteArrayOutputStream2, 0);
            DeflaterOutputStream deflaterOutputStream2 = new DeflaterOutputStream(base64OutputStream2);
            Map<String, String> A69 = A69();
            if (TextUtils.isEmpty(C01535f.A00().A03())) {
                C01535f.A08(this.A01);
            }
            A69.put(A01(248, 4, 63), C01535f.A00().A03());
            A69.put(A01(385, 10, 123), AnonymousClass9G.A06(this.A02, this.A01, false));
            Iterator<Map.Entry<String, String>> it = A69.entrySet().iterator();
            while (it.hasNext()) {
                if (!r9.A2O(it.next().getKey())) {
                    it.remove();
                }
            }
            deflaterOutputStream2.write(new JSONObject(A69).toString().getBytes());
            deflaterOutputStream2.close();
            String replaceAll = byteArrayOutputStream2.toString().replaceAll(A01(0, 1, 107), A01(0, 0, 37));
            try {
                deflaterOutputStream2.close();
                base64OutputStream2.close();
                byteArrayOutputStream2.close();
            } catch (IOException unused) {
            }
            return replaceAll;
        } catch (IOException e) {
            throw new RuntimeException(A01(209, 26, 17), e);
        } catch (Throwable e2) {
            if (0 != 0) {
                try {
                    deflaterOutputStream.close();
                } catch (IOException unused2) {
                    throw e2;
                }
            }
            if (0 != 0) {
                base64OutputStream.close();
            }
            if (0 != 0) {
                byteArrayOutputStream.close();
            }
            throw e2;
        }
    }
}
