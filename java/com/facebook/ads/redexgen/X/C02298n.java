package com.facebook.ads.redexgen.X;

import androidx.annotation.Nullable;
import java.util.Arrays;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.facebook.ads.redexgen.X.8n  reason: invalid class name and case insensitive filesystem */
public final class C02298n {
    public static byte[] A00;
    public static String[] A01;

    static {
        A03();
        A02();
    }

    public static String A00(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A00, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            int i5 = copyOfRange[i4] - i3;
            if (A01[1].charAt(1) != 'a') {
                String[] strArr = A01;
                strArr[4] = "1M2Y98BwTvEPUGLlCwxj254fliWahs1n";
                strArr[0] = "azYACSqPfJkxfvivKERNz1YXvsYHtm8K";
                copyOfRange[i4] = (byte) (i5 - 68);
            } else {
                throw new RuntimeException();
            }
        }
        return new String(copyOfRange);
    }

    public static void A02() {
        A00 = new byte[]{-47, -12, -20, -20, -18, -13, -20, -91, -45, -22, -7, -4, -12, -9, -16, -91, -54, -5, -22, -13, -7, -52, -35, -38, -55, -36, -47, -41, -42, 28, 41, 41, 38, 41, -9, 3, 3, -1, -18, 2, 3, -16, 3, 4, 2, -18, -14, -2, -13, -12, 22, 13, 28, 31, 23, 26, 19, -38, -53, -29, -42, -39, -53, -50, -55, -35, -45, -28, -49, 15, 16, -3, 14, 16, -5, 16, 5, 9, 1, -40, -45, -49, -46, -60, -57, -62, -42, -52, -35, -56};
    }

    public static void A03() {
        A01 = new String[]{"a6IxlCkVmcf1QOD6ZYjDV7INHBfwC5pE", "pjHGmgbtiOqji60ouNqSwKm8iDwdL2il", "jT1wBn6CKnjHaXeX1", "64rNhN6ZFhDWGxpIQ", "ze8vByysvbBiliYVuotBM6Di85tpEUzv", "oRRmyqjSmqskFAvbDRZ10d57ZrKFDjEI", "44vbl6FfanMIMy7ytQNCDD1eXfOrnFTF", "rkbwsxy0OcV7GrP7ELmdkRDeQR2uGuGh"};
    }

    public static JSONObject A01(AnonymousClass8H r6, long j, long j2, long j3, long j4, int i, @Nullable Exception exc) {
        JSONException e;
        JSONObject jSONObject = new JSONObject();
        try {
            try {
                jSONObject.put(A00(69, 10, 88), j);
            } catch (JSONException e2) {
                e = e2;
                r6.A04().A3S(e);
                return jSONObject;
            }
            try {
                jSONObject.put(A00(21, 8, 36), ((double) j2) / 1000.0d);
            } catch (JSONException e3) {
                e = e3;
                r6.A04().A3S(e);
                return jSONObject;
            }
            try {
                jSONObject.put(A00(57, 12, 38), j3);
                try {
                    jSONObject.put(A00(79, 11, 31), j4);
                } catch (JSONException e4) {
                    e = e4;
                    r6.A04().A3S(e);
                    return jSONObject;
                }
                try {
                    jSONObject.put(A00(34, 16, 75), i);
                    if (exc != null) {
                        jSONObject.put(A00(29, 5, 115), exc.getMessage());
                    }
                } catch (JSONException e5) {
                    e = e5;
                    r6.A04().A3S(e);
                    return jSONObject;
                }
            } catch (JSONException e6) {
                e = e6;
                r6.A04().A3S(e);
                return jSONObject;
            }
        } catch (JSONException e7) {
            e = e7;
            r6.A04().A3S(e);
            return jSONObject;
        }
        return jSONObject;
    }

    public static void A04(AnonymousClass8H r6, long j, long j2, long j3, long j4, int i, @Nullable Exception exc) {
        C02258j r5 = new C02258j(A00(0, 21, 65));
        r5.A03(1);
        r5.A05(A01(r6, j, j2, j3, j4, i, exc));
        r6.A04().A8O(A00(50, 7, 100), C02248i.A1f, r5);
    }
}
