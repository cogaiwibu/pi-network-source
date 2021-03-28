package com.facebook.ads.redexgen.X;

import java.util.Arrays;
import javax.annotation.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.facebook.ads.redexgen.X.Wa  reason: case insensitive filesystem */
public final class C0813Wa extends AbstractC01966x<String> {
    public static byte[] A00;

    static {
        A01();
    }

    public static String A00(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A00, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] ^ i3) ^ 123);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A00 = new byte[]{55};
    }

    public C0813Wa(long j, @Nullable C01946v r9, String str) {
        super(j, r9, str, EnumC01956w.A0C);
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC01966x
    public final int A07() {
        return ((String) A08()).getBytes().length;
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC01966x
    public final JSONObject A09(JSONObject jSONObject) throws JSONException {
        jSONObject.put(A00(0, 1, 58), A08());
        return jSONObject;
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC01966x
    public final boolean A0B(AbstractC01966x<String> r3) {
        return ((String) A08()).equals(r3.A08());
    }
}
