package com.facebook.ads.redexgen.X;

import android.text.TextUtils;
import java.util.Arrays;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class OE {
    public static byte[] A00;
    public static String[] A01;

    static {
        A03();
        A02();
    }

    public static String A00(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A00, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] ^ i3) ^ 79);
        }
        return new String(copyOfRange);
    }

    public static void A02() {
        A00 = new byte[]{69, 114, 114, 111, 114, 32, 116, 114, 97, 110, 115, 102, 111, 114, 109, 105, 110, 103, 32, 74, 83, 79, 78, 32, 105, 110, 32, 117, 112, 100, 97, 116, 101, 67, 97, 99, 104, 101, 100, 85, 114, 108, 115, 54, 52, 39, 58, 32, 38, 48, 57, 123, 102, 113, 126, 114, 118, 124, 64, 108, 123, 116, 64, 115, 126, 102, 122, 109, 64, 119, 107, 114, 115, 64, 106, 109, 115, 84, 95, 85, 110, 82, 80, 67, 85, 110, 88, 92, 80, 86, 84, 66, 39, 45, 33, 32, 2, 6, 10, 12, 14, 80, 87, 73, 107, 116, 121, 120, 114, 66, 104, 111, 113};
    }

    public static void A03() {
        A01 = new String[]{"xPMOoUfbkmQ5kvnU3jbgLL47OcFEjU7z", "1dodMLotzUEJucQn2MWgY64F", "Ei0kY7ZOP", "czo3jP2JN", "", "hHdeWCinA2EaAz86iaUgwk6OrkZVXmHI", "CkfkaUvdCRi5J5AIUl6JSr62iIVQ3RiE", "AT3hLPm3hPYjZ73rxoY4ER"};
    }

    public static JSONObject A01(C0820Wh wh, JSONObject iconObject, AnonymousClass7H r6, JL jl, O7 o7) {
        String A002 = A00(101, 3, 106);
        if (!r6.A0Y(iconObject.optString(A00(51, 26, 80)))) {
            return iconObject;
        }
        jl.A03(JK.A0P, null);
        try {
            JSONObject optJSONObject = iconObject.optJSONObject(A00(92, 4, 1));
            if (!(optJSONObject == null || optJSONObject.optString(A002) == null)) {
                optJSONObject.put(A002, r6.A0K(optJSONObject.optString(A002)));
            }
            JSONArray optJSONArray = iconObject.optJSONArray(A00(77, 15, 126));
            if (optJSONArray != null) {
                for (int i = 0; i < optJSONArray.length(); i++) {
                    optJSONArray.put(i, r6.A0K(optJSONArray.optString(i)));
                }
            }
            JSONArray optJSONArray2 = iconObject.optJSONArray(A00(43, 8, 26));
            if (optJSONArray2 != null) {
                for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                    A04(optJSONArray2.optJSONObject(i2), r6);
                }
            } else {
                A04(iconObject, r6);
            }
        } catch (JSONException unused) {
            int i3 = C02248i.A0r;
            String A003 = A00(0, 43, 79);
            if (A01[7].length() != 18) {
                String[] strArr = A01;
                strArr[7] = "LxewRmCzOSDY9SAQbVbh0hKQ4ZXqC";
                strArr[7] = "LxewRmCzOSDY9SAQbVbh0hKQ4ZXqC";
                o7.A05(i3, A003);
            } else {
                throw new RuntimeException();
            }
        }
        return iconObject;
    }

    public static void A04(JSONObject imageObject, AnonymousClass7H r6) throws JSONException {
        JSONObject optJSONObject = imageObject.optJSONObject(A00(96, 5, 36));
        if (optJSONObject != null) {
            String A002 = A00(101, 3, 106);
            if (optJSONObject.optString(A002) != null) {
                optJSONObject.put(A002, r6.A0K(optJSONObject.optString(A002)));
            }
        }
        String A003 = A00(104, 9, 82);
        if (!TextUtils.isEmpty(imageObject.optString(A003))) {
            String A0M = r6.A0M(imageObject.optString(A003));
            String[] strArr = A01;
            if (strArr[0].charAt(11) != strArr[6].charAt(11)) {
                throw new RuntimeException();
            }
            String[] strArr2 = A01;
            strArr2[5] = "hKzn1bJnFsf9yN7H5QHOi1sHDJIqnVRW";
            strArr2[5] = "hKzn1bJnFsf9yN7H5QHOi1sHDJIqnVRW";
            imageObject.put(A003, A0M);
        }
    }
}
