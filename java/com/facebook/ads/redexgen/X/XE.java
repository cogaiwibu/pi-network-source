package com.facebook.ads.redexgen.X;

import com.facebook.ads.internal.api.BuildConfigApi;
import java.util.Arrays;
import org.json.JSONObject;

public class XE implements AnonymousClass0T {
    public static byte[] A02;
    public static String[] A03;
    public final /* synthetic */ AnonymousClass8H A00;
    public final /* synthetic */ XG A01;

    static {
        A02();
        A01();
    }

    public static String A00(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A02, i, i + i2);
        int i4 = 0;
        while (true) {
            int length = copyOfRange.length;
            if (A03[1].length() != 17) {
                String[] strArr = A03;
                strArr[0] = "QX0n3XV94OfUIkrY3aQ1mnz4DOZRMjum";
                strArr[3] = "ub6cBxCWynk8j8mrWTDov9XVsshwREvV";
                if (i4 >= length) {
                    return new String(copyOfRange);
                }
                copyOfRange[i4] = (byte) ((copyOfRange[i4] - i3) - 10);
                i4++;
            } else {
                throw new RuntimeException();
            }
        }
    }

    public static void A01() {
        A02 = new byte[]{104, -81, -64, -90, -105, -58, -65, -65, -74, -67, 115, -94, -101, -101, -110, -103, 103, 77, -85, -70, -77, -77, -86, -79};
    }

    public static void A02() {
        A03 = new String[]{"FR0EinKvOwZW2VlEpgnoVwKXeBc9ct8J", "K05aYFgFk0t0", "VOug37Y7l3ssOOXSbUnGxFzsx4hRn8wv", "z2uzga85Ski18P7nLebJhENF02V63SxL", "vQZIRiGCHJjFTe4gMXvJZpLaPtvEk1p8", "auy2W0sk", "5Z", "2337kXImyPAg9HB"};
    }

    public XE(XG xg, AnonymousClass8H r2) {
        this.A01 = xg;
        this.A00 = r2;
    }

    @Override // com.facebook.ads.redexgen.X.AnonymousClass0T
    public final void A5B(AnonymousClass0U r7, JSONObject jSONObject) {
        C02258j r5 = new C02258j(A00(4, 6, 71));
        r5.A05(jSONObject);
        r5.A03(1);
        this.A00.A04().A82(A00(18, 6, 59), r7.A02() + 4000, r5);
        if (BuildConfigApi.isDebug()) {
            String str = A00(10, 8, 35) + r7 + A00(0, 1, 54) + r7.A02() + A00(1, 3, 124) + jSONObject.toString();
        }
    }
}
