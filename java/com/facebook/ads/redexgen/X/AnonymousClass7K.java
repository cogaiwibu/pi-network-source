package com.facebook.ads.redexgen.X;

import android.annotation.SuppressLint;
import androidx.annotation.Nullable;
import java.util.Arrays;
import org.json.JSONObject;

/* renamed from: com.facebook.ads.redexgen.X.7K  reason: invalid class name */
public final class AnonymousClass7K {
    public static int A00 = C02248i.A0X;
    public static int A01 = C02248i.A0Z;
    public static int A02 = C02248i.A0a;
    public static int A03 = C02248i.A0b;
    public static int A04 = C02248i.A0c;
    public static int A05 = C02248i.A0d;
    public static int A06 = C02248i.A0h;
    public static int A07 = C02248i.A0i;
    public static byte[] A08;
    public static final String A09 = AnonymousClass7K.class.getSimpleName();

    public static String A00(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A08, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] - i3) - 62);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A08 = new byte[]{-120, -90, -88, -83, -86, 101, -87, -82, -72, -80, 101, -85, -90, -82, -79, -70, -73, -86, 115, -63, -33, -31, -26, -29, -98, -30, -25, -15, -23, -98, -15, -13, -31, -31, -29, -15, -15, -84, -63, -33, -31, -26, -29, -98, -30, -19, -11, -20, -22, -19, -33, -30, -98, -28, -33, -25, -22, -13, -16, -29, -84, -127, -97, -95, -90, -93, 94, -90, -89, -78, 108, -72, -42, -40, -35, -38, -107, -30, -34, -24, -24, -93, -83, -80, -85, -81, -66, -79, -83, -64, -75, -62, -79, -85, -65, -75, -58, -79, -85, -82, -59, -64, -79, -65, -55, -52, -57, -53, -38, -51, -55, -36, -47, -34, -51, -57, -36, -31, -40, -51, -95, -92, -97, -90, -81, -78, -83, -95, -76, -97, -76, -71, -80, -91, 21, 24, 19, 38, 25, 37, 41, 25, 39, 40, 19, 29, 24, -79, -60, -60, -75, -67, -64, -60, -78, -80, -78, -73, -76, 24, 22, 24, 29, 26, 20, 24, 36, 35, 41, 26, 45, 41, -50, -55, -47, -44, -35, -38, -51, -57, -38, -51, -55, -37, -41, -42, 22, 26, 14, 20, 18, 11, 14, 0, 3, -2, 19, 8, 12, 4, 5, 2, -4};
    }

    static {
        A01();
    }

    /* JADX INFO: Multiple debug info for r6v0 com.facebook.ads.redexgen.X.8H: [D('t' java.lang.Throwable), D('additionalInfo' org.json.JSONObject)] */
    @SuppressLint({"CatchGeneralException"})
    public static void A02(AnonymousClass8H r6, AnonymousClass7A r7, int i, String str, long j) {
        if (A06(r6)) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(A00(120, 14, 2), r7.A00);
                jSONObject.put(A00(134, 13, 118), r7.A01);
                if (j > 0) {
                    jSONObject.put(A00(191, 9, 97), LW.A06(System.currentTimeMillis() - j));
                }
                C02258j r4 = new C02258j(str);
                r4.A05(jSONObject);
                r4.A03(1);
                r6.A04().A83(A00(154, 5, 17), i, r4);
            } catch (Throwable th) {
                r6.A04().A3S(th);
            }
        }
    }

    public static void A03(AnonymousClass8H r12, AnonymousClass7E r13, String str, int i, @Nullable String str2, @Nullable Integer num, @Nullable Long l) {
        if (A06(r12)) {
            A05(r12, r13.A05, r13.A06, r13.A07, A00(186, 5, 111), str, i, str2, num, l, null);
        }
    }

    /* JADX INFO: Multiple debug info for r6v0 com.facebook.ads.redexgen.X.8H: [D('t' java.lang.Throwable), D('additionalInfo' org.json.JSONObject)] */
    @SuppressLint({"CatchGeneralException"})
    public static void A04(AnonymousClass8H r6, AnonymousClass7J r7, boolean z) {
        if (A06(r6)) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(A00(120, 14, 2), r7.A00);
                jSONObject.put(A00(134, 13, 118), r7.A03);
                jSONObject.put(A00(104, 16, 42), r7.A02);
                jSONObject.put(A00(159, 13, 119), r7.A01);
                if (J8.A1I(r6)) {
                    jSONObject.put(A00(200, 3, 82), r7.A04);
                }
                String A002 = z ? A00(61, 10, 0) : A00(71, 11, 55);
                int i = z ? A05 : A06;
                C02258j r4 = new C02258j(A002);
                r4.A05(jSONObject);
                r4.A03(1);
                r6.A04().A83(A00(154, 5, 17), i, r4);
            } catch (Throwable th) {
                r6.A04().A3S(th);
            }
        }
    }

    /* JADX INFO: Multiple debug info for r5v0 com.facebook.ads.redexgen.X.8H: [D('t' java.lang.Throwable), D('additionalInfo' org.json.JSONObject)] */
    @SuppressLint({"CatchGeneralException"})
    public static void A05(AnonymousClass8H r5, String str, String str2, String str3, String str4, String str5, int i, @Nullable String str6, @Nullable Integer num, @Nullable Long l, @Nullable Integer num2) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(A00(120, 14, 2), str);
            jSONObject.put(A00(134, 13, 118), str2);
            jSONObject.put(A00(104, 16, 42), str4);
            if (str6 != null) {
                jSONObject.put(A00(172, 14, 42), str6);
            }
            if (num != null) {
                jSONObject.put(A00(82, 22, 14), String.valueOf(num));
            }
            if (l != null) {
                jSONObject.put(A00(191, 9, 97), String.valueOf(l));
            }
            if (num2 != null) {
                jSONObject.put(A00(147, 7, 18), String.valueOf(num2));
            }
            jSONObject.put(A00(159, 13, 119), str5);
            if (J8.A1I(r5)) {
                jSONObject.put(A00(200, 3, 82), str3);
            }
            String A002 = A00(19, 19, 64);
            if (i == A03) {
                A002 = A00(38, 23, 64);
            } else if (i == A01) {
                A002 = A00(0, 19, 7);
            }
            C02258j r4 = new C02258j(A002);
            r4.A05(jSONObject);
            r4.A03(1);
            r5.A04().A83(A00(154, 5, 17), i, r4);
        } catch (Throwable th) {
            r5.A04().A3S(th);
        }
    }

    public static boolean A06(AnonymousClass8H r7) {
        int A062;
        if (r7.A03().A7X()) {
            A062 = 1;
        } else {
            A062 = J9.A06(r7);
        }
        if (A062 == 0) {
            return false;
        }
        if (A062 <= 0 || r7.A05().A00() <= 1.0d / ((double) A062)) {
            return true;
        }
        return false;
    }
}
