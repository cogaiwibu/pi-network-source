package com.facebook.ads.redexgen.X;

import androidx.annotation.Nullable;
import java.util.Arrays;
import org.json.JSONObject;

public final class TM implements AbstractC01485a {
    public static byte[] A02;
    public static String[] A03;
    public final EnumC01495b A00;
    public final String A01;

    static {
        A03();
        A02();
    }

    public static String A01(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A02, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] - i3) - 124);
        }
        return new String(copyOfRange);
    }

    public static void A02() {
        A02 = new byte[]{5, 10, 1, -10, 78, 75, 69};
    }

    public static void A03() {
        A03 = new String[]{"TFthAsyh9DXeOXmOSrI", "6fWFj2GuIp8edYChPrJEmZ0EGdAH52zr", "1W8BLXCecsGswLg5J6ItB4TJ0IeP92", "LJOYl73w1qtKK7uJcnV", "z6IkqPokH6efARGWKazebLzdy8d5mCY", "2wZEZTk79zqBVt75gMVieTbdYLiT7Zir", "bDoQVkMDKn3JHFmlXSVDRiBYbpx4sGCA", "L28Z4g4sdLlGf5SKMowSfgQKz11TtxJ4"};
    }

    public TM(EnumC01495b r1, String str) {
        this.A00 = r1;
        this.A01 = str;
    }

    @Nullable
    public static TM A00(JSONObject jSONObject) {
        EnumC01495b A002 = EnumC01495b.A00(jSONObject.optString(A01(0, 4, 21)));
        String optString = jSONObject.optString(A01(4, 3, 93));
        if (A002 != null && optString != null) {
            return new TM(A002, optString);
        }
        String[] strArr = A03;
        if (strArr[7].charAt(27) != strArr[5].charAt(27)) {
            throw new RuntimeException();
        }
        String[] strArr2 = A03;
        strArr2[2] = "YX1kth4";
        strArr2[2] = "YX1kth4";
        return null;
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC01485a
    public final EnumC01495b A7B() {
        return this.A00;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x006d, code lost:
        if (r4 != r3) goto L_0x006f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0070, code lost:
        if (r4 != r3) goto L_0x006f;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean equals(java.lang.Object r7) {
        /*
        // Method dump skipped, instructions count: 133
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.TM.equals(java.lang.Object):boolean");
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC01485a
    public final String getUrl() {
        return this.A01;
    }

    public final int hashCode() {
        return (this.A00.hashCode() * 31) + this.A01.hashCode();
    }
}
