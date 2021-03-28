package com.facebook.ads.redexgen.X;

import android.util.Log;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import java.util.Arrays;
import org.json.JSONException;
import org.json.JSONObject;

public final class TV implements AnonymousClass69 {
    public static byte[] A01;
    public static final String A02 = TV.class.getSimpleName();
    public final C0821Wi A00;

    public static String A00(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A01, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] ^ i3) ^ 48);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A01 = new byte[]{73, 116, 111, 105, 124, 120, 101, 99, 98, 44, 110, 121, 101, 96, 104, 101, 98, 107, 44, 74, 77, 66, 44, 96, 99, 107, 107, 101, 98, 107, 44, 70, 95, 67, 66, 69, 87, 77, 64, 71, 65, 122, 65, 68, 81, 68, 122, 73, 74, 66, 66, 76, 75, 66, 72, 67, 78, 121, 110, 65, 71, 32, 54, 39, 9, 16, 30};
    }

    static {
        A01();
    }

    public TV(C0821Wi wi) {
        this.A00 = wi;
    }

    @Override // com.facebook.ads.redexgen.X.AnonymousClass69
    public final void A8I(String str, String str2, int i, int i2, int i3, JSONObject jSONObject, EnumC01866n r12) {
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put(A00(35, 4, 20), str);
            jSONObject2.put(A00(54, 3, 26), str2);
            jSONObject2.put(A00(57, 2, 42), i);
            jSONObject2.put(A00(59, 2, 3), i2);
            jSONObject2.put(A00(61, 3, 99), i3);
            jSONObject2.put(A00(64, 3, 74), AnonymousClass74.A01(jSONObject.toString(), str2));
            C02258j r4 = new C02258j(jSONObject2.toString());
            r4.A03(1);
            this.A00.A04().A83(A00(39, 15, 21), IronSourceConstants.BN_RELOAD_FAILED, r4);
        } catch (JSONException e) {
            Log.e(A02, A00(0, 35, 60), e);
        }
    }
}
