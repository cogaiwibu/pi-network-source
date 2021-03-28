package com.facebook.ads.redexgen.X;

import android.annotation.SuppressLint;
import android.database.Cursor;
import android.util.Log;
import androidx.annotation.Nullable;
import com.facebook.ads.internal.api.BuildConfigApi;
import java.util.Arrays;
import kotlin.jvm.internal.ByteCompanionObject;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.facebook.ads.redexgen.X.Cf  reason: case insensitive filesystem */
public final class C0315Cf implements XK {
    public static byte[] A02;
    public static String[] A03;
    public final C0821Wi A00;
    public final AnonymousClass8O A01;

    static {
        A05();
        A04();
    }

    public static String A00(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A02, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] ^ i3) ^ 85);
        }
        return new String(copyOfRange);
    }

    public static void A04() {
        String[] strArr = A03;
        if (strArr[7].length() != strArr[5].length()) {
            String[] strArr2 = A03;
            strArr2[0] = "GUa5RhIL61d4FW3HWW0RBx9i";
            strArr2[1] = "4nKtohmUbY7tHai9z2t8ojCMJbrZv";
            A02 = new byte[]{62, 28, 19, 90, 9, 93, 25, 24, 17, 24, 9, 24, 93, 28, 9, 9, 24, 16, 13, 9, 14, 93, 24, 5, 30, 24, 24, 25, 24, 25, 93, 24, 11, 24, 19, 9, 14, 83, 16, 21, 7, 24, 21, 46, 59, 59, 42, 34, 63, 59, ByteCompanionObject.MAX_VALUE, 122, 111, 122, 16, 29, 50, 36, 50, 50, 40, 46, 47, 30, 40, 37, 32, 54, 32, 32, 58, 60, 61, 12, 39, 58, 62, 54, 76, 81, 85, 93, 20, 15, 11, 5, 14, 63, 9, 4, ByteCompanionObject.MAX_VALUE, 114, 123, 110};
            return;
        }
        throw new RuntimeException();
    }

    public static void A05() {
        A03 = new String[]{"zSqnO64p11LQVC3SPrHTwk7q", "RQQcRArwNRw7pCFobI7zm4AECBhyO", "uX7W3VjoXSZ8mIic8tH9fb17VHeYN2EI", "VdQ4q", "h", "roUcO9bhLUMzgbi0", "6tdL5l5B64y16QievzXwm2hdxMIwTdT2", "M1EyYsdVjnJYnVOvo"};
    }

    public C0315Cf(C0821Wi wi) {
        this.A00 = wi;
        this.A01 = new AnonymousClass8O(wi);
    }

    private JSONArray A01(Cursor cursor) throws JSONException {
        JSONObject jSONObject;
        JSONArray jSONArray = new JSONArray();
        cursor.moveToPosition(-1);
        while (cursor.moveToNext()) {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(A00(54, 2, 44), cursor.getString(C0826Wn.A04.A00));
            jSONObject2.put(A00(82, 8, 53), cursor.getString(C0826Wn.A09.A00));
            jSONObject2.put(A00(90, 4, 94), cursor.getString(C0826Wn.A0A.A00));
            jSONObject2.put(A00(78, 4, 109), LW.A02(cursor.getDouble(C0826Wn.A08.A00)));
            jSONObject2.put(A00(66, 12, 6), LW.A02(cursor.getDouble(C0826Wn.A07.A00)));
            jSONObject2.put(A00(56, 10, 20), cursor.getString(C0826Wn.A06.A00));
            if (cursor.getString(C0826Wn.A03.A00) == null) {
                jSONObject = new JSONObject();
            }
            jSONObject2.put(A00(50, 4, 78), jSONObject);
            jSONObject2.put(A00(43, 7, 26), cursor.getString(C0826Wn.A02.A00));
            jSONObject2.put(A00(38, 5, 36), this.A00.A02().A6S());
            jSONArray.put(jSONObject2);
        }
        return jSONArray;
    }

    private JSONArray A02(Cursor cursor) throws JSONException {
        JSONObject jSONObject;
        JSONArray jSONArray = new JSONArray();
        cursor.moveToPosition(-1);
        while (cursor.moveToNext()) {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(A00(54, 2, 44), cursor.getString(2));
            jSONObject2.put(A00(82, 8, 53), cursor.getString(0));
            jSONObject2.put(A00(90, 4, 94), cursor.getString(4));
            jSONObject2.put(A00(78, 4, 109), LW.A02(cursor.getDouble(5)));
            jSONObject2.put(A00(66, 12, 6), LW.A02(cursor.getDouble(6)));
            jSONObject2.put(A00(56, 10, 20), cursor.getString(7));
            if (cursor.getString(8) == null) {
                jSONObject = new JSONObject();
            }
            jSONObject2.put(A00(50, 4, 78), jSONObject);
            jSONObject2.put(A00(43, 7, 26), cursor.getString(9));
            jSONObject2.put(A00(38, 5, 36), this.A00.A02().A6S());
            jSONArray.put(jSONObject2);
        }
        return jSONArray;
    }

    public static JSONObject A03(Cursor cursor) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        while (cursor.moveToNext()) {
            String string = cursor.getString(C0828Wp.A02.A00);
            String string2 = cursor.getString(C0828Wp.A01.A00);
            String[] strArr = A03;
            if (strArr[6].charAt(14) != strArr[2].charAt(14)) {
                throw new RuntimeException();
            }
            String[] strArr2 = A03;
            strArr2[7] = "IfQdYzKY6vCyBSxPg";
            strArr2[5] = "fxZpsWnZoPKbT5Dt";
            jSONObject.put(string, string2);
        }
        return jSONObject;
    }

    @Override // com.facebook.ads.redexgen.X.AnonymousClass9N
    @SuppressLint({"CatchGeneralException"})
    public final int A3z(int i) {
        int i2 = 0;
        if (i > -1) {
            try {
                i2 = this.A01.A09(i);
            } catch (Exception e) {
                if (BuildConfigApi.isDebug()) {
                    Log.e(XK.A00, A00(0, 38, 40), e);
                }
            }
        }
        this.A01.A0J();
        this.A01.A0K();
        return i2;
    }

    @Override // com.facebook.ads.redexgen.X.AnonymousClass9O
    public final void A40() {
        this.A01.A0I();
    }

    @Override // com.facebook.ads.redexgen.X.AnonymousClass9N
    public final boolean A4g(String str) {
        return this.A01.A0L(str);
    }

    @Override // com.facebook.ads.redexgen.X.AnonymousClass9N
    @Nullable
    public final JSONArray A5K() {
        Cursor cursor = null;
        try {
            Cursor A0B = this.A01.A0B();
            JSONArray jSONArray = null;
            if (A0B.getCount() > 0) {
                jSONArray = A01(A0B);
            }
            A0B.close();
            return jSONArray;
        } catch (JSONException unused) {
            if (0 != 0) {
                cursor.close();
            }
            return null;
        } catch (Throwable th) {
            if (0 != 0) {
                cursor.close();
            }
            throw th;
        }
    }

    @Override // com.facebook.ads.redexgen.X.AnonymousClass9N
    @Nullable
    public final JSONObject A5L() {
        Cursor cursor = null;
        try {
            Cursor A0C = this.A01.A0C();
            JSONObject jSONObject = null;
            if (A0C.getCount() > 0) {
                jSONObject = A03(A0C);
            }
            A0C.close();
            return jSONObject;
        } catch (JSONException unused) {
            String[] strArr = A03;
            if (strArr[3].length() != strArr[4].length()) {
                String[] strArr2 = A03;
                strArr2[0] = "fQ4GsEetTW4Q8M7eeZgpps0V";
                strArr2[1] = "7a4bIAh8lhheYJZGYQIYoy5madi9z";
                if (0 != 0) {
                    cursor.close();
                }
                return null;
            }
            throw new RuntimeException();
        } catch (Throwable th) {
            if (0 != 0) {
                cursor.close();
            }
            throw th;
        }
    }

    @Override // com.facebook.ads.redexgen.X.AnonymousClass9N
    public final int A6D() {
        Cursor cursor = null;
        try {
            Cursor A0A = this.A01.A0A();
            int i = 0;
            if (A0A.moveToFirst()) {
                i = A0A.getInt(0);
            }
            A0A.close();
            return i;
        } catch (Throwable th) {
            if (0 != 0) {
                cursor.close();
            }
            throw th;
        }
    }

    @Override // com.facebook.ads.redexgen.X.AnonymousClass9N
    @Nullable
    public final String A6G(String str) {
        String str2 = null;
        Cursor A0E = this.A01.A0E(str);
        if (A0E != null) {
            if (A0E.moveToNext() && A0E.getCount() > 0) {
                AnonymousClass8M r4 = C0826Wn.A0A;
                String[] strArr = A03;
                if (strArr[7].length() != strArr[5].length()) {
                    String[] strArr2 = A03;
                    strArr2[3] = "VgiME";
                    strArr2[4] = "4";
                    str2 = A0E.getString(A0E.getColumnIndex(r4.A01));
                } else {
                    throw new RuntimeException();
                }
            }
            A0E.close();
        }
        return str2;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(4:8|9|(1:11)|12) */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x002b, code lost:
        return new android.util.Pair<>(null, null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x002c, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x002d, code lost:
        if (0 != 0) goto L_0x002f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x002f, code lost:
        r3.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0032, code lost:
        throw r0;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:8:0x0020 */
    @Override // com.facebook.ads.redexgen.X.AnonymousClass9N
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final android.util.Pair<org.json.JSONObject, org.json.JSONArray> A77(int r5) {
        /*
            r4 = this;
            r3 = 0
            com.facebook.ads.redexgen.X.8O r0 = r4.A01     // Catch:{ JSONException -> 0x0020 }
            android.database.Cursor r3 = r0.A0D(r5)     // Catch:{ JSONException -> 0x0020 }
            r1 = 0
            r2 = 0
            int r0 = r3.getCount()     // Catch:{ JSONException -> 0x0020 }
            if (r0 <= 0) goto L_0x0017
            org.json.JSONObject r2 = A03(r3)     // Catch:{ JSONException -> 0x0020 }
            org.json.JSONArray r1 = r4.A02(r3)     // Catch:{ JSONException -> 0x0020 }
        L_0x0017:
            android.util.Pair r0 = new android.util.Pair     // Catch:{ JSONException -> 0x0020 }
            r0.<init>(r2, r1)     // Catch:{ JSONException -> 0x0020 }
            r3.close()
            return r0
        L_0x0020:
            android.util.Pair r1 = new android.util.Pair     // Catch:{ all -> 0x002c }
            r0 = 0
            r1.<init>(r0, r0)     // Catch:{ all -> 0x002c }
            if (r3 == 0) goto L_0x002b
            r3.close()
        L_0x002b:
            return r1
        L_0x002c:
            r0 = move-exception
            if (r3 == 0) goto L_0x0032
            r3.close()
        L_0x0032:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C0315Cf.A77(int):android.util.Pair");
    }

    @Override // com.facebook.ads.redexgen.X.AnonymousClass9N
    public final boolean A7O(String str) {
        return this.A01.A0M(str);
    }

    @Override // com.facebook.ads.redexgen.X.AnonymousClass9O
    public final void ADv(JB jb, AnonymousClass9L<String> r14) {
        this.A01.A0H(jb.A09(), jb.A06().A00, jb.A07().toString(), jb.A05(), jb.A04(), jb.A08(), jb.A0A(), r14);
    }
}
