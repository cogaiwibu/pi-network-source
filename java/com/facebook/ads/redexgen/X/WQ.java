package com.facebook.ads.redexgen.X;

import java.util.Arrays;
import javax.annotation.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

public final class WQ extends AbstractC01966x<Boolean> {
    public static byte[] A00;

    static {
        A01();
    }

    public static String A00(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A00, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] - i3) - 23);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A00 = new byte[]{-39};
    }

    public WQ(long j, @Nullable C01946v r9, boolean z) {
        super(j, r9, Boolean.valueOf(z), EnumC01956w.A02);
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC01966x
    public final int A07() {
        return 8;
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC01966x
    public final JSONObject A09(JSONObject jSONObject) throws JSONException {
        jSONObject.put(A00(0, 1, 76), A08());
        return jSONObject;
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC01966x
    public final boolean A0B(AbstractC01966x<Boolean> r3) {
        return ((Boolean) A08()).equals(r3.A08());
    }
}
