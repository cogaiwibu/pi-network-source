package com.facebook.ads.redexgen.X;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.facebook.ads.redexgen.X.8z  reason: invalid class name and case insensitive filesystem */
public final class C02418z {
    public static byte[] A05;
    public static String[] A06;
    public String A00;
    public String A01;
    public String A02;
    public Date A03;
    public boolean A04;

    static {
        A03();
        A02();
    }

    public static String A00(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A05, i, i + i2);
        int i4 = 0;
        while (true) {
            int length = copyOfRange.length;
            if (A06[1].charAt(20) != '3') {
                throw new RuntimeException();
            }
            String[] strArr = A06;
            strArr[2] = "ePAfBYViEZliNGymx7m0adyDMPlGHrpQ";
            strArr[2] = "ePAfBYViEZliNGymx7m0adyDMPlGHrpQ";
            if (i4 >= length) {
                return new String(copyOfRange);
            }
            copyOfRange[i4] = (byte) ((copyOfRange[i4] ^ i3) ^ 82);
            i4++;
        }
    }

    public static void A02() {
        A05 = new byte[]{96, 96, 96, 9, 5, 65, 65, 8, 104, 104, 104, 8, 92, 92, 92, 92, 5, 109, 109, 31, 72, 72, 31, 86, 86, 5, 95, 95, 95, 95, 85, 76, 21, 8, 0, 25, 2, 17, 4, 25, 31, 30, 19, 29, 1, 126, 121, 103, 43, 60, 49, 40, 56};
    }

    public static void A03() {
        A06 = new String[]{"eUnDvYC27elWl0OIYD", "wrMh9NtoanrD8h1augOH3NVqQQ0tAgF4", "3vDVqZB4rWVKvgx5b3OF0nUGahQCrcY0", "6DD0LSomG9znTW4FMaj4ZQ8CLI18bTcT", "m4OyWRD3KmqD5PEshfLk2St9BNh2LjNQ", "DUnTMJffq4UJY2Y02e5xG0xwhTP4jnlH", "V", "fiQ9VXnw7bAvrgjS7V4rUJQz4dMTS6ql"};
    }

    public C02418z(String str, String str2, String str3, Date date) {
        boolean z;
        this.A01 = str;
        this.A00 = str2;
        this.A02 = str3;
        this.A03 = date;
        if (str2 == null || str3 == null) {
            z = false;
        } else {
            z = true;
        }
        this.A04 = z;
    }

    public C02418z(JSONObject jSONObject) {
        this(jSONObject.optString(A00(45, 3, 89)), jSONObject.optString(A00(42, 3, 42)), jSONObject.optString(A00(48, 5, 15)), new Date(jSONObject.optLong(A00(32, 10, 34)) * 1000));
    }

    public static List<C02418z> A01(String str) {
        if (str == null) {
            return null;
        }
        JSONArray jSONArray = null;
        try {
            jSONArray = new JSONArray(str);
        } catch (JSONException unused) {
        }
        if (jSONArray == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject jSONObject = null;
            try {
                jSONObject = jSONArray.getJSONObject(i);
            } catch (JSONException unused2) {
            }
            if (jSONObject != null) {
                arrayList.add(new C02418z(jSONObject));
            }
        }
        return arrayList;
    }

    public final String A04() {
        Date date = this.A03;
        if (date == null) {
            date = new Date();
            date.setTime(date.getTime() + 3600000);
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(A00(0, 29, 119));
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone(A00(29, 3, 74)));
        return simpleDateFormat.format(date);
    }

    public final boolean A05() {
        return (this.A00 == null || this.A02 == null || this.A01 == null) ? false : true;
    }
}
