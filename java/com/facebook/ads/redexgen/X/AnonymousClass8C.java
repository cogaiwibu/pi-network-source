package com.facebook.ads.redexgen.X;

import java.util.Arrays;
import kotlin.jvm.internal.ByteCompanionObject;

/* renamed from: com.facebook.ads.redexgen.X.8C  reason: invalid class name */
public enum AnonymousClass8C {
    A08,
    A0B,
    A0G,
    A05,
    A0F,
    A0E,
    A0H,
    A04,
    A0C,
    A06,
    A09,
    A0I,
    A07,
    A0A,
    A0D,
    A03;
    
    public static byte[] A00;
    public static String[] A01;

    public static String A00(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A00, i, i + i2);
        int i4 = 0;
        while (true) {
            int length = copyOfRange.length;
            if (A01[1].length() != 7) {
                String[] strArr = A01;
                strArr[5] = "N6xF9rR52YV8YEOBA61RWKACjwLFpOal";
                strArr[0] = "9lI84e7XMJCEHu7uA5OKUKZwzRXjipC4";
                if (i4 >= length) {
                    return new String(copyOfRange);
                }
                copyOfRange[i4] = (byte) ((copyOfRange[i4] - i3) - 41);
                i4++;
            } else {
                throw new RuntimeException();
            }
        }
    }

    public static void A01() {
        A00 = new byte[]{-97, -86, -86, 123, -121, -122, -117, -116, -118, -115, 123, -116, -121, -118, -105, -118, 125, -117, -115, -124, -116, -114, -95, -116, -114, -103, -99, -110, -104, -105, -88, -103, -118, -101, -118, -106, -114, -99, -114, -101, -105, -86, -94, -98, -101, -107, -101, -90, -79, -98, -95, -87, -105, -92, -79, -108, -95, -89, -96, -106, -69, -50, -58, -62, -65, -71, -65, -54, -43, -53, -58, -58, -69, -56, -43, -72, -59, -53, -60, -70, -56, -53, -57, -50, -58, -91, -87, -84, -88, -91, -97, -91, -80, -69, -88, -85, -77, -95, -82, -69, -98, -85, -79, -86, -96, -29, -25, -22, -26, -29, -35, -29, -18, -7, -17, -22, -22, -33, -20, -7, -36, -23, -17, -24, -34, -120, -117, ByteCompanionObject.MAX_VALUE, 125, -120, -101, -110, 125, -114, -123, 125, 126, -120, -127, -67, -64, -56, -74, -61, -48, -77, -64, -58, -65, -75, -125, -120, 124, 121, -122, -117, 125, -121, 121, -79, -94, -77, -94, -82, -90, -75, -90, -77, -104, -117, -119, -117, -113, -100, -117, -104, -54, -67, -53, -57, -51, -54, -69, -67, -41, -50, -71, -54, -63, -71, -70, -60, -67, -44, -57, -42, -41, -44, -48, -65, -70, -70, -81, -68, -55, -84, -71, -65, -72, -82};
    }

    public static void A02() {
        A01 = new String[]{"ErY0P3cLXtwrTQQ8AaevOJsLoOIjf8Vw", "5r0t8dyi", "9auVm36bokeF7hBifK", "Yb4G3rkI5nMioq4UjOOwWhO2qlazISB5", "UwkWzl2MRtUAPiPmZ2pCt01Egbad", "smzz0KdPRXZYPP4XACCeK52FLPVIfRsV", "AKjKXgMsYucWUUC1InTc", "yyhqIOp1fbaB9n9gzG"};
    }

    /* access modifiers changed from: public */
    static {
        A02();
        A01();
    }
}
