package com.facebook.ads.redexgen.X;

import android.net.Uri;
import android.text.TextUtils;
import java.util.Arrays;
import java.util.Map;

public final class R6 extends AbstractC00260f {
    public static byte[] A02;
    public static String[] A03;
    public static final String A04 = R6.class.getSimpleName();
    public final Uri A00;
    public final Map<String, String> A01;

    public static String A00(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A02, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] ^ i3) ^ 96);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        byte[] bArr = {42, 40, 51, 53, 40, 51, 46, 35, 75, 70, 79, 90};
        String[] strArr = A03;
        if (strArr[4].length() != strArr[1].length()) {
            String[] strArr2 = A03;
            strArr2[5] = "wR51MZdRiuTx9tajcMEJR1ABXy";
            strArr2[5] = "wR51MZdRiuTx9tajcMEJR1ABXy";
            A02 = bArr;
            return;
        }
        throw new RuntimeException();
    }

    public static void A02() {
        A03 = new String[]{"jy5CHS8ciK95qvgyZPKNzTZ", "EsJYGwS5VmRo2OpDKfhEPxAAyWa", "TXamSNcIJ7UnME9", "aAqXHcETEDrJIQ0", "iKc7fPJ", "AeuUMR7bsIhvkygvb", "MOi5LCZvXht1yXQHfTxaoFALkw", "2sehTzR2RD89PLQKMZ0CUhyomJdrMDfZ"};
    }

    static {
        A02();
        A01();
    }

    public R6(C0820Wh wh, JE je, String str, Uri uri, Map<String, String> mExtraData) {
        super(wh, je, str);
        this.A00 = uri;
        this.A01 = mExtraData;
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC00260f
    public final void A0D() {
        JF jf = JF.A05;
        String queryParameter = this.A00.getQueryParameter(A00(0, 8, 58));
        if (!TextUtils.isEmpty(queryParameter)) {
            try {
                jf = JF.values()[Integer.valueOf(queryParameter).intValue()];
            } catch (Exception unused) {
            }
        }
        super.A01.A8C(this.A02, this.A01, this.A00.getQueryParameter(A00(8, 4, 95)), jf);
    }
}
