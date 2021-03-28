package com.facebook.ads.redexgen.X;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicReference;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.facebook.ads.redexgen.X.0t  reason: invalid class name and case insensitive filesystem */
public final class C00400t {
    public static byte[] A03;
    public static String[] A04;
    public AtomicReference<String> A00 = new AtomicReference<>(A00(0, 2, 25));
    public JSONObject A01 = new JSONObject();
    public final HashSet<String> A02 = new HashSet<>();

    static {
        A02();
        A01();
    }

    public static String A00(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A03, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] ^ i3) ^ 79);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A03 = new byte[]{13, 11, 56, 58, 43, 74, 65, 76, 93, 86, 95, 91, 74, 75, 112, 70, 75, 84, 88, 88, 78, 73, 73, 94, 85, 88, 94, 72, 111, 122, 109, 118, 112, 123, 27, 12, 22, 23, 60, 12, 0, 0, 22, 17, 17, 6, 13, 0, 6, 60, 16, 6, 0, 16, 22, 1, 27, 26, 49, 30, 11, 28, 7, 1, 10};
    }

    public static void A02() {
        A04 = new String[]{"Nqgg", "8wGIqWp", "y92csH8tMmRGnIZZsga62xjDucPy6znH", "NuhdC57WslsG6uEsDnOxbiezpeKaNBmF", "EG4F575TP", "HLT5liagTN6y0JvSt92F6CLrVRU5nCH8", "PjujBbxPTNTRaLXrj7yD38jvaiKi7YAc", "GRbHVCF"};
    }

    public final String A03() {
        String str = this.A00.get();
        return str == null ? A00(0, 2, 25) : str;
    }

    public final JSONObject A04() {
        return this.A01;
    }

    public final synchronized void A05() {
        JSONArray jSONArray = new JSONArray();
        Iterator<String> it = this.A02.iterator();
        while (it.hasNext()) {
            jSONArray.put(it.next());
        }
        this.A00.set(jSONArray.toString());
    }

    public final void A06(String str) throws JSONException {
        if (str != null && !str.trim().isEmpty()) {
            this.A01 = new JSONObject(str);
            Iterator<String> keys = this.A01.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                if (this.A01.get(next) instanceof String) {
                    A0A(new JSONObject((String) this.A01.get(next)));
                }
            }
        }
    }

    public final synchronized void A07(String str) {
        this.A02.add(str);
    }

    public final synchronized void A08(String str) throws JSONException {
        if (str != null) {
            if (!str.trim().isEmpty()) {
                JSONArray jSONArray = new JSONArray(str);
                for (int i = 0; i < jSONArray.length(); i++) {
                    this.A02.add(jSONArray.getString(i));
                }
            }
        }
    }

    public final synchronized void A09(String str) {
        this.A02.remove(str);
    }

    public final void A0A(JSONObject jSONObject) throws JSONException {
        String optString = jSONObject.optString(A00(5, 12, 96), null);
        int optInt = jSONObject.optInt(A00(28, 6, 80));
        int optInt2 = jSONObject.optInt(A00(54, 11, 33));
        long optLong = jSONObject.optLong(A00(2, 3, 20));
        AnonymousClass1K r5 = new AnonymousClass1K(optString);
        if (optString != null && this.A01.has(optString) && (this.A01.get(optString) instanceof AnonymousClass1K)) {
            r5 = (AnonymousClass1K) this.A01.get(optString);
        }
        String A002 = A00(17, 11, 116);
        if (jSONObject.has(A002)) {
            r5.A06((JSONArray) jSONObject.get(A002));
        }
        String A003 = A00(34, 20, 44);
        if (jSONObject.has(A003)) {
            r5.A04(jSONObject.optInt(A003));
        }
        r5.A05(optInt, optInt2, optLong);
        this.A01.put(optString, r5);
        String[] strArr = A04;
        if (strArr[3].charAt(11) != strArr[2].charAt(11)) {
            throw new RuntimeException();
        }
        String[] strArr2 = A04;
        strArr2[3] = "tpg9MOL30KnGen5hdACKzszPCJWxtgkM";
        strArr2[2] = "0kRc9hG2BxRGhE0oYKlFhIYiMAEEJmAF";
    }
}
