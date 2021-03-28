package com.facebook.ads.redexgen.X;

import android.annotation.SuppressLint;
import java.lang.reflect.Field;
import java.util.Arrays;
import javax.annotation.Nullable;
import kotlin.jvm.internal.ByteCompanionObject;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.facebook.ads.redexgen.X.Ux  reason: case insensitive filesystem */
public class C0784Ux implements AbstractC01876o {
    public static byte[] A07;
    public static String[] A08;
    @Nullable
    public final Boolean A00 = A00();
    @Nullable
    public final Class A01;
    @Nullable
    public final Integer A02 = A01();
    @Nullable
    public final String A03 = ((String) A02(A03(0, 14, 1)));
    @Nullable
    public final String A04 = ((String) A02(A03(14, 10, 40)));
    @Nullable
    public final String A05 = ((String) A02(A03(29, 6, 108)));
    @Nullable
    public final String A06 = ((String) A02(A03(47, 12, 95)));

    static {
        A05();
        A04();
    }

    public static String A03(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A07, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] - i3) - 3);
        }
        return new String(copyOfRange);
    }

    public static void A04() {
        A07 = new byte[]{69, 84, 84, 80, 77, 71, 69, 88, 77, 83, 82, 99, 77, 72, 109, ByteCompanionObject.MIN_VALUE, 116, 119, 111, -118, ByteCompanionObject.MAX_VALUE, -124, 123, 112, -64, -63, -66, -47, -61, -75, -69, -80, -59, -66, -63, 111, 94, 107, 108, 98, 104, 103, 120, 92, 104, 93, 94, -72, -89, -76, -75, -85, -79, -80, -63, -80, -93, -81, -89, -75, -67, -72, -126, -108, -71, 118, -35, -54, -55, -63};
    }

    public static void A05() {
        A08 = new String[]{"zADoCz7CvaAXCWGxIkLMA", "2K9Tl656qkZLtu", "tA5GWw487qRnfnLR8ZUKtFfZ", "8guEXZpZHmWlQufm4UgBospnJN08RLPS", "reqYVU9na7rP88BTCXg8my3jxoKE4TRG", "MzyMe4eMojZOEHVqOT5gIPpA5hojcKAH", "7FMMtqZgbhamEAamoQeZvH6n", "zBoYgH9ApIW8fufW6Vp76"};
    }

    public C0784Ux(@Nullable Class cls) {
        this.A01 = cls;
    }

    @Nullable
    private Boolean A00() {
        Object A022 = A02(A03(24, 5, 121));
        if (A022 != null && (A022 instanceof Boolean)) {
            return (Boolean) A022;
        }
        String[] strArr = A08;
        if (strArr[4].charAt(18) != strArr[3].charAt(18)) {
            throw new RuntimeException();
        }
        String[] strArr2 = A08;
        strArr2[5] = "5rAhOQ4yCQtmZH2DOI09MtNNwfO3P8Pu";
        strArr2[5] = "5rAhOQ4yCQtmZH2DOI09MtNNwfO3P8Pu";
        return null;
    }

    @Nullable
    private Integer A01() {
        Object A022 = A02(A03(35, 12, 22));
        if (A022 == null || !(A022 instanceof Integer)) {
            return null;
        }
        return (Integer) A022;
    }

    @Nullable
    @SuppressLint({"CatchGeneralException"})
    private Object A02(String str) {
        Class cls = this.A01;
        if (cls == null) {
            return null;
        }
        try {
            Field declaredField = cls.getDeclaredField(str);
            declaredField.setAccessible(true);
            return declaredField.get(null);
        } catch (Throwable unused) {
            return null;
        }
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC01876o
    public final boolean A7a(Object obj) {
        String str;
        Boolean bool;
        String str2;
        Integer num;
        String str3;
        C0784Ux ux = (C0784Ux) obj;
        String str4 = this.A03;
        return str4 != null && str4.equals(ux.A03) && (str = this.A04) != null && str.equals(ux.A04) && (bool = this.A00) != null && bool.equals(ux.A00) && (str2 = this.A05) != null && str2.equals(ux.A05) && (num = this.A02) != null && num.equals(ux.A02) && (str3 = this.A06) != null && str3.equals(ux.A06);
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC01876o
    @SuppressLint({"BadMethodUse-java.lang.String.length"})
    public final int ADC() {
        int i;
        int i2;
        int i3;
        int length = A03(59, 3, 81).length() + A03(62, 2, 29).length() + A03(64, 1, 82).length() + A03(65, 1, 13).length() + A03(66, 2, 100).length() + A03(68, 2, 80).length() + 4 + 8;
        String str = this.A03;
        int i4 = 0;
        if (str != null) {
            i = str.length();
        } else {
            i = 0;
        }
        int i5 = length + i;
        String str2 = this.A04;
        if (str2 != null) {
            i2 = str2.length();
        } else {
            i2 = 0;
        }
        int i6 = i5 + i2;
        String str3 = this.A05;
        if (str3 != null) {
            i3 = str3.length();
        } else {
            i3 = 0;
        }
        int i7 = i6 + i3;
        String str4 = this.A06;
        if (str4 != null) {
            i4 = str4.length();
        }
        int i8 = i7 + i4;
        String[] strArr = A08;
        if (strArr[4].charAt(18) != strArr[3].charAt(18)) {
            throw new RuntimeException();
        }
        String[] strArr2 = A08;
        strArr2[4] = "fJLk3OPl80DEMs1cbmgpYGaX1xXfMNis";
        strArr2[3] = "sJFPBoXBMcAwH7zCTBg0tDpz8XLZJTWR";
        return i8;
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC01876o
    public final JSONObject ADV() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(A03(59, 3, 81), this.A03);
        jSONObject.put(A03(62, 2, 29), this.A04);
        jSONObject.put(A03(64, 1, 82), this.A00);
        jSONObject.put(A03(65, 1, 13), this.A05);
        jSONObject.put(A03(66, 2, 100), this.A02);
        jSONObject.put(A03(68, 2, 80), this.A06);
        return jSONObject;
    }
}
