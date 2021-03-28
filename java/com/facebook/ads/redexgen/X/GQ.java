package com.facebook.ads.redexgen.X;

import android.util.Log;
import java.util.Arrays;

public final class GQ {
    public static byte[] A00;
    public static String[] A01;
    public static final int A02 = C0466Ig.A08(A01(7, 4, 33));
    public static final int A03 = C0466Ig.A08(A01(11, 4, 102));

    public static String A01(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A00, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] - i3) - 12);
        }
        return new String(copyOfRange);
    }

    public static void A02() {
        A00 = new byte[]{-52, -18, -22, -34, -3, -14, -11, 113, -127, 116, 94, -71, -77, -85, -90, -99, -75, -77, -70, -70, -77, -72, -79, 106, -68, -81, -73, -85, -77, -72, -82, -81, -68, 106, -71, -80, 106, -73, -85, -74, -80, -71, -68, -73, -81, -82, 106, -99, -113, -109, 106, -104, -117, -106, 106, -65, -72, -77, -66, 120};
    }

    public static void A03() {
        A01 = new String[]{"ijZd2SvY", "Ph5fJqf6OowbUT2cqzgcB298kDhnW2OX", "wB5WDB4JU6krUWdN", "eBmlwoifn7sQacvwvpCdDN7mM49lFTV9", "8TaUd8AxspPDe4hMAHd3njvqxnnZalZZ", "my8xvAbSAhbAvtjE", "sCujs14tvAISPjVlxjJqhwIZMpV4htIn", "ZuHVfppKLGIB3c7uxsgIg35bH7izaigq"};
    }

    static {
        A03();
        A02();
    }

    public static int A00(IQ iq) {
        int b = 0;
        while (iq.A05() != 0) {
            int A0F = iq.A0F();
            String[] strArr = A01;
            if (strArr[2].length() != strArr[5].length()) {
                throw new RuntimeException();
            }
            String[] strArr2 = A01;
            strArr2[2] = "2iVFcVRayhlXICIL";
            strArr2[5] = "cB88SmkuRLYvydLN";
            b += A0F;
            if (A0F != 255) {
                return b;
            }
        }
        return -1;
    }

    public static void A04(long j, IQ iq, CW[] cwArr) {
        int ccCount;
        int countryCode;
        while (iq.A05() > 1) {
            int A002 = A00(iq);
            int A003 = A00(iq);
            int A07 = iq.A07() + A003;
            if (A003 == -1 || A003 > iq.A05()) {
                Log.w(A01(0, 7, 125), A01(15, 45, 62));
                A07 = iq.A08();
            } else if (A002 == 4 && A003 >= 8) {
                int A0F = iq.A0F();
                int A0J = iq.A0J();
                int i = 0;
                if (A0J == 49) {
                    i = iq.A09();
                }
                int A0F2 = iq.A0F();
                if (A0J == 47) {
                    iq.A0a(1);
                }
                if (A0F == 181 && ((A0J == 49 || A0J == 47) && A0F2 == 3)) {
                    ccCount = 1;
                } else {
                    ccCount = 0;
                }
                if (A0J == 49) {
                    if (i == A03 || i == A02) {
                        countryCode = 1;
                    } else {
                        countryCode = 0;
                    }
                    ccCount &= countryCode;
                }
                if (ccCount != 0) {
                    iq.A0a(1);
                    int A0F3 = (iq.A0F() & 31) * 3;
                    int ccCount2 = iq.A07();
                    for (CW cw : cwArr) {
                        iq.A0Z(ccCount2);
                        cw.ACe(iq, A0F3);
                        cw.ACf(j, 1, A0F3, 0, null);
                    }
                }
            }
            iq.A0Z(A07);
        }
    }
}
