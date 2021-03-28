package com.facebook.ads.redexgen.X;

import android.util.Log;
import android.util.Pair;
import com.facebook.ads.internal.api.BuildConfigApi;
import com.facebook.ads.internal.dynamicloading.DynamicLoaderFactory;
import java.util.Arrays;
import kotlin.jvm.internal.ByteCompanionObject;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.facebook.ads.redexgen.X.bF  reason: case insensitive filesystem */
public final class C0989bF implements JC {
    public static byte[] A02;
    public static String[] A03;
    public static final String A04 = C0989bF.class.getSimpleName();
    public C0821Wi A00;
    public XK A01;

    public static String A00(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A02, i, i + i2);
        int i4 = 0;
        while (true) {
            int length = copyOfRange.length;
            String[] strArr = A03;
            if (strArr[0].length() != strArr[4].length()) {
                throw new RuntimeException();
            }
            String[] strArr2 = A03;
            strArr2[5] = "6iaNxoAqzoeupDn53l2Cm";
            strArr2[6] = "N7vye13Dqewush4C3JTfsv4";
            if (i4 >= length) {
                return new String(copyOfRange);
            }
            copyOfRange[i4] = (byte) ((copyOfRange[i4] ^ i3) ^ 104);
            i4++;
        }
    }

    /* JADX WARNING: Error to parse debug info: 20 in method: com.facebook.ads.redexgen.X.bF.A02(org.json.JSONArray, org.json.JSONArray, int):org.json.JSONArray, file: assets/audience_network.dex
    java.lang.ArrayIndexOutOfBoundsException: 20
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.process(DebugInfoParser.java:149)
    	at jadx.plugins.input.dex.sections.DexCodeReader.getDebugInfo(DexCodeReader.java:111)
    	at jadx.core.dex.nodes.MethodNode.getDebugInfo(MethodNode.java:569)
    	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.visit(DebugInfoAttachVisitor.java:44)
     */
    public static JSONArray A02(JSONArray jSONArray, JSONArray jSONArray2, int i) {
        if (jSONArray == null) {
            return jSONArray2;
        }
        if (jSONArray2 == null) {
            return jSONArray;
        }
        int length = jSONArray.length();
        int length2 = jSONArray2.length();
        JSONArray jSONArray3 = new JSONArray();
        int i2 = 0;
        int i3 = 0;
        JSONObject jSONObject = null;
        JSONObject jSONObject2 = null;
        double d = Double.MAX_VALUE;
        double d2 = Double.MAX_VALUE;
        while (true) {
            if ((i2 < length || i3 < length2) && i > 0) {
                String A002 = A00(435, 4, 91);
                if (i2 < length && jSONObject == null) {
                    try {
                        jSONObject = jSONArray.getJSONObject(i2);
                        d = jSONObject.getDouble(A002);
                    } catch (JSONException e) {
                        boolean isDebug = BuildConfigApi.isDebug();
                        String[] strArr = A03;
                        if (strArr[5].length() != strArr[6].length()) {
                            String[] strArr2 = A03;
                            strArr2[7] = "6K";
                            strArr2[3] = "iJ";
                            if (isDebug) {
                                Log.e(A04, A00(273, 33, 107) + i2, e);
                            }
                            jSONObject = null;
                            d = Double.MAX_VALUE;
                        } else {
                            throw new RuntimeException();
                        }
                    }
                    i2++;
                }
                if (i3 < length2 && jSONObject2 == null) {
                    try {
                        jSONObject2 = jSONArray2.getJSONObject(i3);
                        d2 = jSONObject2.getDouble(A002);
                    } catch (JSONException e2) {
                        if (BuildConfigApi.isDebug()) {
                            Log.e(A04, A00(306, 25, 59) + i3, e2);
                        }
                        jSONObject2 = null;
                        d2 = Double.MAX_VALUE;
                    }
                    i3++;
                }
                if (jSONObject != null || jSONObject2 != null) {
                    if (jSONObject == null || d2 < d) {
                        jSONArray3.put(jSONObject2);
                        jSONObject2 = null;
                        d2 = Double.MAX_VALUE;
                    } else {
                        jSONArray3.put(jSONObject);
                        jSONObject = null;
                        d = Double.MAX_VALUE;
                    }
                    i--;
                }
            }
        }
        if (i > 0) {
            if (jSONObject != null) {
                jSONArray3.put(jSONObject);
            } else if (jSONObject2 != null) {
                jSONArray3.put(jSONObject2);
            }
        }
        return jSONArray3;
    }

    public static void A05() {
        A02 = new byte[]{21, 83, 90, 71, 21, 80, 67, 80, 91, 65, 124, 81, 21, 60, 111, 105, ByteCompanionObject.MAX_VALUE, ByteCompanionObject.MAX_VALUE, 121, 111, 111, 122, 105, 112, 112, 101, 50, 110, 101, 68, 77, 68, 85, 68, 69, 1, 68, 87, 68, 79, 85, 82, 1, 68, 89, 66, 68, 68, 69, 68, 69, 1, 83, 68, 85, 83, 88, 1, 77, 72, 76, 72, 85, 15, 1, 98, 78, 84, 79, 85, 27, 1, 72, 123, 104, 99, 121, 45, 121, 116, 125, 104, 45, 125, ByteCompanionObject.MAX_VALUE, 98, 110, 104, 126, 126, 104, 105, 45, 111, 116, 45, 121, 101, 104, 45, 126, 104, ByteCompanionObject.MAX_VALUE, 123, 104, ByteCompanionObject.MAX_VALUE, 55, 45, 84, 115, 123, 126, 119, 118, 50, 102, 125, 50, 98, 115, 96, 97, 119, 50, 115, 124, 50, 119, 100, 119, 124, 102, 50, 123, 124, 50, 119, 100, 119, 124, 102, 97, 50, 115, 96, 96, 115, 107, 50, 116, 125, 96, 50, 118, 123, 97, 98, 115, 102, 113, 122, 50, 116, 115, 123, 126, 103, 96, 119, 60, 65, 119, 96, 100, 119, 96, 50, 98, 96, 125, 113, 119, 97, 97, 119, 118, 50, 119, 100, 119, 124, 102, 91, 118, 50, 50, 4, 19, 23, 4, 19, 65, 19, 4, 21, 20, 19, 15, 4, 5, 65, 15, 14, 15, 76, 19, 4, 21, 19, 24, 0, 3, 13, 4, 65, 4, 19, 19, 14, 19, 65, 2, 14, 5, 4, 65, 42, 28, 11, 15, 28, 11, 89, 11, 28, 13, 12, 11, 23, 28, 29, 89, 11, 28, 13, 11, 0, 24, 27, 21, 28, 89, 28, 11, 11, 22, 11, 89, 26, 22, 29, 28, 89, 86, 109, 98, 97, 111, 102, 35, 119, 108, 35, 115, 98, 113, 112, 102, 35, 103, 102, 97, 118, 100, 79, 108, 100, 70, 117, 102, 109, 119, 35, 98, 119, 35, 6, 61, 50, 49, 63, 54, 115, 39, 60, 115, 35, 50, 33, 32, 54, 115, 54, 37, 54, 61, 39, 115, 50, 39, 115, 111, 84, 91, 88, 86, 95, 26, 78, 85, 26, 74, 91, 72, 73, 95, 26, 73, 95, 72, 76, 95, 72, 26, 72, 95, 73, 74, 85, 84, 73, 95, 26, 91, 78, 26, 74, 85, 73, 83, 78, 83, 85, 84, 26, 80, 92, 87, 86, 104, 109, 120, 109, 110, 109, ByteCompanionObject.MAX_VALUE, 105, 17, 2, 17, 26, 0, 7, 6, 5, 1, 20, 21, 18, 5, 77, 3, 15, 14, 6, 9, 7, 77, 5, 22, 5, 14, 20, 77, 13, 1, 7, 9, 3, 33, 34, 38, 51, 50, 53, 34, 24, 36, 40, 41, 33, 46, 32, 44, 33, 71, 90, 94, 86, 60, 39, 35, 45, 38, 59};
    }

    public static void A06() {
        A03 = new String[]{"4VJF", "NMiFc9mQHDdEdTYDts8ebbMyjIljV2c0", "gJxI4lQggzgG7l1t48TOLBAVsZm4smpW", "RC", "7emK", "VnvWTQ3PSRLSSOUq71E5D", "jZ42e8scbVg896gjqaujwC7", "gj"};
    }

    static {
        A06();
        A05();
    }

    public C0989bF(C0821Wi wi, XK xk) {
        this.A00 = wi;
        this.A01 = xk;
    }

    public static JSONArray A01(JSONArray jSONArray, JSONArray jSONArray2) {
        int i = 0;
        if (jSONArray != null) {
            i = 0 + jSONArray.length();
        }
        if (jSONArray2 != null) {
            i += jSONArray2.length();
        }
        return A02(jSONArray, jSONArray2, i);
    }

    private JSONObject A03() {
        JSONArray A032;
        JSONObject payload = this.A01.A5L();
        JSONArray A5K = this.A01.A5K();
        if (J9.A0Q(this.A00) && (A032 = C02268k.A03(this.A00)) != null && A032.length() > 0) {
            A5K = A01(A032, A5K);
        }
        JSONObject jSONObject = null;
        if (A5K != null) {
            try {
                jSONObject = new JSONObject();
                if (payload != null) {
                    jSONObject.put(A00(439, 6, 32), payload);
                }
                jSONObject.put(A00(387, 6, 28), A5K);
            } catch (JSONException unused) {
                return null;
            }
        }
        return jSONObject;
    }

    private JSONObject A04(int i) {
        int A08;
        JSONArray A042;
        Pair<JSONObject, JSONArray> A77 = this.A01.A77(i);
        JSONObject jSONObject = (JSONObject) A77.first;
        JSONArray jSONArray = (JSONArray) A77.second;
        if (J9.A0Q(this.A00) && (A042 = C02268k.A04(this.A00, (A08 = J9.A08(this.A00)))) != null && A042.length() > 0) {
            jSONArray = A02(A042, jSONArray, i + A08);
        }
        JSONObject jSONObject2 = null;
        if (jSONArray != null) {
            try {
                jSONObject2 = new JSONObject();
                if (jSONObject != null) {
                    jSONObject2.put(A00(439, 6, 32), jSONObject);
                }
                jSONObject2.put(A00(387, 6, 28), jSONArray);
            } catch (JSONException unused) {
                return null;
            }
        }
        return jSONObject2;
    }

    private void A07(String str) {
        if (C02268k.A0J(str)) {
            C02268k.A0E(str);
        } else {
            this.A01.A7O(str);
        }
    }

    @Override // com.facebook.ads.redexgen.X.JC
    public final JSONObject A4G() {
        int A0F = J9.A0F(this.A00);
        return A0F > 0 ? A04(A0F) : A03();
    }

    @Override // com.facebook.ads.redexgen.X.JC
    public final boolean A7g() {
        int A0F = J9.A0F(this.A00);
        if (A0F >= 1 && this.A01.A6D() + C02268k.A00(this.A00) > A0F) {
            return true;
        }
        return false;
    }

    @Override // com.facebook.ads.redexgen.X.JC
    public final void A8q() {
        int A3z = this.A01.A3z(J9.A0G(this.A00));
        if (A3z > 0) {
            AbstractC02238h A042 = this.A00.A04();
            int i = C02248i.A0o;
            A042.A82(A00(379, 8, 100), i, new C02258j(A00(28, 44, 73) + A3z));
        }
        C0821Wi wi = this.A00;
        String[] strArr = A03;
        if (strArr[5].length() != strArr[6].length()) {
            String[] strArr2 = A03;
            strArr2[5] = "bzDkK7DGlCk2AgYUikBmx";
            strArr2[6] = "oAHu9PBino36rPxONmBwiLk";
            C02268k.A0G(wi);
            return;
        }
        throw new RuntimeException();
    }

    @Override // com.facebook.ads.redexgen.X.JC
    public final void A9J(JSONArray jSONArray) {
        int length = jSONArray.length();
        for (int i = 0; i < length; i++) {
            try {
                A07(jSONArray.getJSONObject(i).getString(A00(433, 2, 45)));
            } catch (JSONException e) {
                if (BuildConfigApi.isDebug()) {
                    String str = A04;
                    String[] strArr = A03;
                    if (strArr[5].length() != strArr[6].length()) {
                        String[] strArr2 = A03;
                        strArr2[1] = "UiT9WvgcUGvh4UJIWCcVV8uUv9KhPAuj";
                        strArr2[2] = "iCLGRVxWINjUDSHIa5c9b6YKh720uR79";
                        Log.e(str, A00(108, 62, 122), e);
                    } else {
                        throw new RuntimeException();
                    }
                } else {
                    continue;
                }
            }
        }
    }

    @Override // com.facebook.ads.redexgen.X.JC
    public final boolean A9L(JSONArray jSONArray) {
        String eventId = A00(27, 1, 40);
        boolean z = true;
        boolean A0Q = J9.A0Q(this.A00);
        for (int i = 0; i < jSONArray.length(); i++) {
            try {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                String string = jSONObject.getString(A00(433, 2, 45));
                if (A00(393, 26, 8).equals(string)) {
                    J8.A0M(this.A00).A1m(jSONObject.getString(A00(419, 14, 47)));
                    DynamicLoaderFactory.makeLoader(this.A00).getInitApi().maybeAttachCrashListener(this.A00);
                } else {
                    int i2 = jSONObject.getInt(A00(375, 4, 91));
                    if (i2 == 1) {
                        if (BuildConfigApi.isDebug()) {
                            String str = A00(170, 25, 122) + string + A00(13, 14, 116);
                            String A6G = this.A01.A6G(string);
                            if (A6G != null) {
                                String str2 = A00(72, 36, 101) + A6G;
                            }
                        }
                        if (!this.A01.A4g(string) && A0Q) {
                            C02268k.A0D(string);
                        }
                    } else {
                        String A002 = A00(0, 13, 93);
                        if (i2 >= 1000 && i2 < 2000) {
                            if (BuildConfigApi.isDebug()) {
                                Log.e(A04, A00(236, 37, 17) + i2 + A002 + string + eventId);
                            }
                            A07(string);
                            z = false;
                        } else if (i2 >= 2000 && i2 < 3000) {
                            if (BuildConfigApi.isDebug()) {
                                Log.e(A04, A00(195, 41, 9) + i2 + A002 + string + eventId);
                            }
                            if (!this.A01.A4g(string) && A0Q) {
                                C02268k.A0D(string);
                            }
                        }
                    }
                    this.A00.A01().A7x(this.A00, jSONObject.toString());
                }
            } catch (JSONException e) {
                if (BuildConfigApi.isDebug()) {
                    Log.e(A04, A00(331, 44, 82) + i + eventId, e);
                }
                z = false;
            }
        }
        return z;
    }

    @Override // com.facebook.ads.redexgen.X.JC
    public final void AAg() {
        this.A01.A40();
        C02268k.A08(this.A00);
    }
}
