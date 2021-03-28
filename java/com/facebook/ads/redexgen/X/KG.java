package com.facebook.ads.redexgen.X;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import java.util.Arrays;
import kotlin.jvm.internal.ByteCompanionObject;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class KG {
    public static KG A00 = new KG();
    public static byte[] A01;

    public static String A04(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A01, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] ^ i3) ^ 119);
        }
        return new String(copyOfRange);
    }

    public static void A05() {
        A01 = new byte[]{116, 113, 74, 103, 112, 101, 122, 103, 97, 124, 123, 114, 74, 118, 122, 123, 115, 124, 114, 49, 52, 49, 32, 36, 53, 34, 47, 42, 61, 23, 24, 41, 0, 23, 26, 31, 18, 23, 2, 31, 25, 24, 41, 3, 3, 31, 18, 96, 108, 103, 102, 16, 21, 0, 21, 103, 98, 119, 98, 92, 110, 108, 103, 102, 111, 92, 119, 122, 115, 102, 65, 64, 67, 76, 75, 76, 81, 76, 74, 75, 45, 58, 58, 39, 58, 70, 69, 65, 84, 85, 82, 69, ByteCompanionObject.MAX_VALUE, 67, 79, 78, 70, 73, 71, 92, 84, 66, 66, 80, 86, 84, 95, 67, 78, 76, 74, 66, 74, 65, 91, 92, 17, 23, 4, 6, 14, 0, 23, 22, 22, 27, 18, 7};
    }

    static {
        A05();
    }

    public static synchronized KG A00() {
        KG kg;
        synchronized (KG.class) {
            kg = A00;
        }
        return kg;
    }

    /* JADX INFO: Multiple debug info for r4v0 com.facebook.ads.redexgen.X.90: [D('placementDefinition' com.facebook.ads.redexgen.X.91), D('adCandidate' com.facebook.ads.redexgen.X.8y)] */
    private C0944aV A01(C0820Wh wh, JSONObject jSONObject, long j, @Nullable String featureConfig) throws JSONException {
        JSONObject jSONObject2 = jSONObject.getJSONArray(A04(106, 10, 88)).getJSONObject(0);
        AnonymousClass90 r4 = new AnonymousClass90(AnonymousClass91.A00(jSONObject2.getJSONObject(A04(70, 10, 82))), jSONObject2.optString(A04(85, 14, 87)), jSONObject2.optString(A04(0, 19, 98)));
        String A04 = A04(26, 3, 57);
        if (jSONObject2.has(A04)) {
            JSONArray jSONArray = jSONObject2.getJSONArray(A04);
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject jSONObject3 = jSONArray.getJSONObject(i);
                JN.A06(wh, jSONObject3, j, featureConfig);
                r4.A09(new C02408y(jSONObject3.optString(A04(19, 7, 39)), jSONObject3.optString(A04(55, 15, 116)), jSONObject3.optJSONObject(A04(51, 4, 3)), jSONObject3.optJSONArray(A04(116, 8, 18))));
            }
        }
        return new C0944aV(r4, jSONObject.optString(A04(29, 18, 1)));
    }

    private C0943aU A02(JSONObject jSONObject) {
        return new C0943aU(jSONObject.optString(A04(99, 7, 70), A04(0, 0, 87)), jSONObject.optInt(A04(47, 4, 116), 0), null);
    }

    private C0943aU A03(JSONObject jSONObject) {
        try {
            JSONObject jSONObject2 = jSONObject.getJSONArray(A04(106, 10, 88)).getJSONObject(0);
            return new C0943aU(jSONObject.optString(A04(99, 7, 70), A04(0, 0, 87)), jSONObject.optInt(A04(47, 4, 116), 0), new AnonymousClass90(AnonymousClass91.A00(jSONObject2.getJSONObject(A04(70, 10, 82))), jSONObject2.optString(A04(85, 14, 87)), jSONObject2.optString(A04(0, 19, 98))));
        } catch (JSONException unused) {
            return A02(jSONObject);
        }
    }

    public final KI A06(C0820Wh wh, String str, long j, @Nullable String str2) throws JSONException {
        if (!TextUtils.isEmpty(str)) {
            JSONObject jSONObject = new JSONObject(str);
            String optString = jSONObject.optString(A04(124, 4, 21));
            char c = 65535;
            int hashCode = optString.hashCode();
            String A04 = A04(80, 5, 63);
            if (hashCode != 96432) {
                if (hashCode == 96784904 && optString.equals(A04)) {
                    c = 1;
                }
            } else if (optString.equals(A04(26, 3, 57))) {
                c = 0;
            }
            if (c == 0) {
                return A01(wh, jSONObject, j, str2);
            }
            if (c == 1) {
                return A03(jSONObject);
            }
            JSONObject optJSONObject = jSONObject.optJSONObject(A04);
            if (optJSONObject != null) {
                return A02(optJSONObject);
            }
        }
        return new KI(KH.A04);
    }
}
