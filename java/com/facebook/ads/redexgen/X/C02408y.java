package com.facebook.ads.redexgen.X;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.facebook.ads.redexgen.X.8y  reason: invalid class name and case insensitive filesystem */
public final class C02408y {
    public static byte[] A04;
    public static String[] A05;
    public final String A00;
    public final String A01;
    public final Map<AnonymousClass92, List<String>> A02 = new HashMap();
    public final JSONObject A03;

    static {
        A02();
        A01();
    }

    public static String A00(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A04, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] - i3) - 9);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        byte[] bArr = {-23, -18, -27, -38, -69, -72, -78};
        String[] strArr = A05;
        if (strArr[2].length() != strArr[5].length()) {
            throw new RuntimeException();
        }
        String[] strArr2 = A05;
        strArr2[4] = "sekG1ort6wl";
        strArr2[7] = "5zf1LSqUL7z";
        A04 = bArr;
    }

    public static void A02() {
        A05 = new String[]{"MRuBx", "tnrUNtkj", "pjyIxrC6Yt5E7Bc8e3CsDS5x0xMg", "2xISKY0hJDtdJSu4Q6JXzE3xpGdbyGij", "ditV1dZQcpc", "LaRPF5Qegj7e827D6k5bX2o3j9w5", "b", "ieJW9hY3GIu"};
    }

    public C02408y(String str, String str2, JSONObject jSONObject, @Nullable JSONArray jSONArray) {
        this.A00 = str;
        this.A01 = str2;
        this.A03 = jSONObject;
        if (!(jSONArray == null || jSONArray.length() == 0)) {
            for (AnonymousClass92 r2 : AnonymousClass92.values()) {
                this.A02.put(r2, new LinkedList());
            }
            for (int i = 0; i < jSONArray.length(); i++) {
                try {
                    JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                    String string = jSONObject2.getString(A00(0, 4, 108));
                    String string2 = jSONObject2.getString(A00(4, 3, 61));
                    AnonymousClass92 valueOf = AnonymousClass92.valueOf(string.toUpperCase(Locale.US));
                    if (valueOf != null && !TextUtils.isEmpty(string2)) {
                        this.A02.get(valueOf).add(string2);
                    }
                } catch (Exception unused) {
                }
            }
        }
    }

    public final String A03() {
        return this.A00;
    }

    public final String A04() {
        return this.A01;
    }

    public final List<String> A05(AnonymousClass92 r2) {
        return this.A02.get(r2);
    }

    public final JSONObject A06() {
        return this.A03;
    }
}
