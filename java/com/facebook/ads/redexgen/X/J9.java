package com.facebook.ads.redexgen.X;

import android.content.Context;
import android.text.TextUtils;
import com.facebook.internal.FacebookRequestErrorClassification;
import java.util.Arrays;
import java.util.HashMap;
import kotlin.jvm.internal.ByteCompanionObject;
import org.json.JSONArray;
import org.json.JSONException;

public final class J9 {
    public static byte[] A00;
    public static String[] A01;

    static {
        A0O();
        A0N();
    }

    public static String A0L(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A00, i, i + i2);
        int i4 = 0;
        while (true) {
            int length = copyOfRange.length;
            if (A01[2].length() != 18) {
                String[] strArr = A01;
                strArr[0] = "coY8s09zVAK7eBnMiZlV9B8LCQZOBRZX";
                strArr[0] = "coY8s09zVAK7eBnMiZlV9B8LCQZOBRZX";
                if (i4 >= length) {
                    return new String(copyOfRange);
                }
                copyOfRange[i4] = (byte) ((copyOfRange[i4] ^ i3) ^ 10);
                i4++;
            } else {
                throw new RuntimeException();
            }
        }
    }

    public static void A0N() {
        A00 = new byte[]{113, 48, 18, 29, 84, 7, 83, 3, 18, 1, 0, 22, 83, 0, 18, 30, 3, 31, 26, 29, 20, 93, 60, 58, 16, 21, 21, 24, 5, 24, 30, 31, 16, 29, 46, 21, 20, 19, 4, 22, 46, 29, 30, 22, 22, 24, 31, 22, 46, 19, 29, 16, 18, 26, 46, 29, 24, 2, 5, 55, 50, 50, 63, 34, 63, 57, 56, 55, 58, 9, 50, 51, 52, 35, 49, 9, 58, 57, 49, 49, 63, 56, 49, 9, 52, 58, 55, 53, 61, 9, 58, 63, 37, 34, 9, 38, 51, 36, 53, 51, 56, 34, 55, 49, 51, 70, 67, 67, 78, 83, 78, 72, 73, 70, 75, 120, 67, 66, 69, 82, 64, 120, 75, 72, 64, 64, 78, 73, 64, 120, 84, 70, 74, 87, 75, 78, 73, 64, 120, 87, 66, 85, 68, 66, 73, 83, 70, 64, 66, 48, 53, 63, 38, 14, 48, 53, 53, 56, 37, 56, 62, 63, 48, 61, 14, 61, 62, 54, 54, 56, 63, 54, 14, 35, 52, 37, 35, 40, 14, 61, 56, 60, 56, 37, 9, 12, 6, 31, 55, 9, 12, 12, 1, 28, 1, 7, 6, 9, 4, 55, 4, 7, 15, 15, 1, 6, 15, 55, 29, 27, 13, 55, 28, 13, 5, 24, 55, 14, 1, 4, 13, 55, 14, 7, 26, 55, 26, 13, 31, 26, 1, 28, 13, 80, 85, 95, 70, 110, 80, 95, 85, 67, 94, 88, 85, 110, 82, 80, 82, 89, 84, 110, 85, 84, 83, 68, 86, 110, 84, 71, 84, 95, 69, 66, 110, 66, 80, 92, 65, 93, 88, 95, 86, 110, 67, 80, 69, 84, 28, 25, 19, 10, 34, 28, 19, 25, 15, 18, 20, 25, 34, 25, 20, 14, 13, 28, 9, 30, 21, 24, 15, 34, 20, 19, 20, 9, 20, 28, 17, 34, 15, 24, 9, 15, 4, 34, 25, 24, 17, 28, 4, 34, 16, 14, 17, 20, 30, 7, 47, 17, 30, 20, 2, 31, 25, 20, 47, 20, 25, 3, 0, 17, 4, 19, 24, 21, 2, 47, 29, 17, 8, 47, 2, 21, 4, 2, 9, 47, 19, 31, 5, 30, 4, 113, 116, 126, 103, 79, 113, 126, 116, 98, ByteCompanionObject.MAX_VALUE, 121, 116, 79, 118, 101, 126, 126, 117, 124, 79, 116, 117, 114, 101, 119, 79, 117, 102, 117, 126, 100, 99, 79, 99, 113, 125, 96, 124, 121, 126, 119, 79, 98, 113, 100, 117, 8, 13, 7, 30, 54, 8, 7, 13, 27, 6, 0, 13, 54, 0, 25, 10, 54, 13, 12, 11, 28, 14, 54, 12, 31, 12, 7, 29, 26, 54, 26, 8, 4, 25, 5, 0, 7, 14, 54, 27, 8, 29, 12, 16, 21, 31, 6, 46, 16, 31, 21, 3, 30, 24, 21, 46, 29, 30, 18, 16, 29, 46, 18, 30, 4, 31, 5, 20, 3, 2, 46, 2, 16, 28, 1, 29, 24, 31, 22, 46, 3, 16, 5, 20, 114, 119, 125, 100, 76, 114, 125, 119, 97, 124, 122, 119, 76, 125, 114, 103, 122, 101, 118, 76, 101, 122, 118, 100, 114, 113, 122, ByteCompanionObject.MAX_VALUE, 122, 103, 106, 76, 123, 122, 96, 103, 124, 97, 106, 76, 96, 114, 126, 99, ByteCompanionObject.MAX_VALUE, 122, 125, 116, 76, 97, 114, 103, 118, 96, 101, 111, 118, 94, 96, 111, 101, 115, 110, 104, 101, 94, 111, 100, 117, 118, 110, 115, 106, 94, 101, 100, 99, 116, 102, 94, 100, 119, 100, 111, 117, 114, 94, 114, 96, 108, 113, 109, 104, 111, 102, 94, 115, 96, 117, 100, 66, 71, 77, 84, 124, 66, 77, 71, 81, 76, 74, 71, 124, 86, 80, 70, 124, 79, 76, 64, 66, 79, 124, 64, 76, 86, 77, 87, 70, 81, 80, 51, 54, 60, 37, 13, 54, 55, 48, 39, 53, 13, 62, 61, 53, 13, 52, 59, 62, 55, 13, 33, 59, 40, 55, 13, 62, 59, 63, 59, 38, 13, 48, 43, 38, 55, 33, 74, 79, 69, 92, 116, 79, 78, 73, 94, 76, 116, 71, 68, 76, 76, 66, 69, 76, 94, 91, 81, 72, 96, 91, 90, 93, 74, 88, 96, 83, 80, 88, 88, 86, 81, 88, 96, 90, 73, 90, 81, 75, 96, 83, 86, 82, 86, 75, 44, 41, 35, 58, 18, 33, 34, 42, 18, 44, 41, 41, 36, 57, 36, 34, 35, 44, 33, 18, 33, 34, 42, 42, 36, 35, 42, 18, 40, 59, 40, 35, 57, 62, 18, 33, 36, 32, 36, 57, 15, 10, 0, 25, 49, 2, 1, 9, 49, 15, 10, 10, 7, 26, 7, 1, 0, 15, 2, 49, 2, 1, 9, 9, 7, 0, 9, 49, 7, 0, 49, 3, 11, 3, 1, 28, 23, 49, 11, 24, 11, 0, 26, 29, 49, 2, 7, 3, 7, 26, 100, 97, 107, 114, 90, 105, 106, 98, 90, 100, 97, 97, 108, 113, 108, 106, 107, 100, 105, 90, 105, 106, 98, 98, 108, 107, 98, 90, 118, 96, 118, 118, 108, 106, 107, 90, 96, 115, 96, 107, 113, 118, 90, 100, 105, 114, 100, 124, 118, 66, 71, 77, 84, 124, 80, 70, 77, 71, 124, 66, 71, 71, 74, 87, 74, 76, 77, 66, 79, 124, 71, 70, 65, 86, 68, 124, 79, 76, 68, 68, 74, 77, 68, 124, 80, 87, 66, 64, 72, 87, 81, 66, 64, 70, 99, 102, 108, 117, 93, 113, 106, 109, 119, 110, 102, 93, 119, 113, 103, 93, 100, 107, 110, 103, 93, 96, 99, 113, 103, 102, 93, 112, 103, 97, 109, 112, 102, 93, 102, 99, 118, 99, 96, 99, 113, 103, 123, 126, 116, 109, 69, 111, 105, ByteCompanionObject.MAX_VALUE, 69, 105, 114, 117, 104, 110, 69, ByteCompanionObject.MAX_VALUE, 116, 108, 69, 126, 123, 110, 123, 69, 124, 117, 104, 69, 123, 126, 126, 115, 110, 115, 117, 116, 123, 118, 69, 118, 117, 125, 125, 115, 116, 125, 32, 38, 29, 38, 35, 54, 35, 29, 46, 45, 37, 37, 43, 44, 37, 29, 46, 43, 47, 43, 54, 108, 119, 112, ByteCompanionObject.MAX_VALUE, 112, 124, 125, 70, 117, 118, 126, 126, 112, 119, 126, 70, 125, 112, 106, 105, 120, 109, 122, 113, 70, 112, 119, 109, 124, 107, 111, 120, 117, 70, 106, 124, 122, 118, 119, 125, 106, 61, 38, 33, 46, 33, 45, 44, 23, 36, 39, 47, 47, 33, 38, 47, 23, 45, 62, 45, 38, 60, 23, 36, 33, 37, 33, 60, 114, 105, 110, 97, 110, 98, 99, 88, 107, 104, 96, 96, 110, 105, 96, 88, 110, 106, 106, 98, 99, 110, 102, 115, 98, 88, 99, 98, 107, 102, 126, 88, 106, 116, 25, 2, 5, 10, 5, 9, 8, 51, 0, 3, 11, 11, 5, 2, 11, 51, 30, 9, 24, 30, 21, 51, 0, 5, 1, 5, 24};
    }

    public static void A0O() {
        A01 = new String[]{"UmMlfAJJysNoFzDVq3Qadmy32zpeb1XF", "HllnJbGbN3", "8LLGh47zYIGz9mlPEtFaTcZuh", "UxHymo9qL", "LEtC8FtnVg5ihxRCphfXt4mvpUeUrdN6", "uWIYhcHXlNvGJXs3GUOJ1PEuERlV4x7", "VZrIuYan0GxbimTZrmDwvEADARuUOj", "38Z9W6n0Eu6i9ylO2bMusVthcISfAJzl"};
    }

    public static int A00(Context context) {
        return J8.A0M(context).A1j(A0L(708, 40, 71), 10);
    }

    public static int A01(Context context) {
        return J8.A0M(context).A1j(A0L(748, 50, 100), 50);
    }

    public static int A02(Context context) {
        return J8.A0M(context).A1j(A0L(149, 35, 91), 1);
    }

    public static int A03(Context context) {
        return A0H(context, A0L(59, 46, 92), 0);
    }

    public static int A04(Context context) {
        return A0H(context, A0L(105, 44, 45), 0);
    }

    public static int A05(Context context) {
        return J8.A0M(context).A1j(A0L(980, 21, 72), 10);
    }

    public static int A06(Context context) {
        return J8.A0M(context).A1j(A0L(233, 45, 59), 0);
    }

    public static int A07(Context context) {
        return J8.A0M(context).A1j(A0L(624, 36, 88), 10485760);
    }

    public static int A08(Context context) {
        return J8.A0M(context).A1j(A0L(678, 30, 53), 30);
    }

    public static int A09(Context context) {
        return J8.A0M(context).A1j(A0L(324, 39, 122), 5);
    }

    public static int A0A(Context context) {
        return J8.A0M(context).A1j(A0L(363, 46, 26), 0);
    }

    public static int A0B(Context context) {
        return J8.A0M(context).A1j(A0L(409, 43, 99), 0);
    }

    public static int A0C(Context context) {
        return J8.A0M(context).A1j(A0L(452, 41, 123), 0);
    }

    public static int A0D(Context context) {
        return J8.A0M(context).A1j(A0L(FacebookRequestErrorClassification.ESC_APP_INACTIVE, 53, 25), 0);
    }

    public static int A0E(Context context) {
        return J8.A0M(context).A1j(A0L(546, 47, 11), 0);
    }

    public static int A0F(Context context) {
        return J8.A0M(context).A1j(A0L(1042, 27, 66), 30);
    }

    public static int A0G(Context context) {
        return J8.A0M(context).A1j(A0L(1103, 27, 102), 20);
    }

    public static int A0H(Context context, String str, int i) {
        int A1j = J8.A0M(context).A1j(str, i);
        if (A1j < 0 || A1j >= 101) {
            return i;
        }
        return A1j;
    }

    public static long A0I(Context context) {
        return J8.A0M(context).A1k(A0L(278, 46, 119), 2000);
    }

    public static long A0J(Context context) {
        return ((long) J8.A0M(context).A1j(A0L(1001, 41, 19), 300)) * 1000;
    }

    public static long A0K(Context context) {
        return J8.A0M(context).A1k(A0L(1069, 34, 13), 500);
    }

    /* JADX INFO: Multiple debug info for r1v4 java.lang.String[]: [D('i' int), D('samplingInt' int)] */
    public static HashMap<String, Integer> A0M(Context context) throws JSONException {
        String A1l = J8.A0M(context).A1l(A0L(24, 35, 123), A0L(22, 2, 109));
        HashMap<String, Integer> hashMap = new HashMap<>();
        JSONArray jSONArray = new JSONArray(A1l);
        for (int i = 0; i < jSONArray.length(); i++) {
            String blackListString = jSONArray.optString(i);
            if (!TextUtils.isEmpty(blackListString)) {
                String A0L = A0L(0, 1, 69);
                if (blackListString.contains(A0L)) {
                    String[] split = blackListString.split(A0L);
                    try {
                        hashMap.put(split[0], Integer.valueOf(Integer.parseInt(split[1])));
                    } catch (NumberFormatException unused) {
                        throw new JSONException(A0L(1, 21, 121));
                    }
                } else {
                    hashMap.put(blackListString, -1);
                }
            }
        }
        return hashMap;
    }

    public static boolean A0P(Context context) {
        return J8.A0M(context).A1n(A0L(184, 49, 98), true);
    }

    public static boolean A0Q(Context context) {
        return J8.A0M(context).A1n(A0L(660, 18, 33), false);
    }

    public static boolean A0R(Context context) {
        return J8.A0M(context).A1n(A0L(798, 49, 15), true);
    }

    public static boolean A0S(Context context) {
        return J8.A0M(context).A1n(A0L(847, 45, 41), false);
    }

    public static boolean A0T(Context context) {
        return J8.A0M(context).A1n(A0L(892, 42, 8), false);
    }

    public static boolean A0U(Context context) {
        return J8.A0M(context).A1n(A0L(593, 31, 41), false);
    }

    public static boolean A0V(Context context) {
        return J8.A0M(context).A1n(A0L(934, 46, 16), true);
    }
}
