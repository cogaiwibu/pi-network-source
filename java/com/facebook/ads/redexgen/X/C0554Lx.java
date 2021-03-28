package com.facebook.ads.redexgen.X;

import android.app.Activity;
import java.util.Arrays;

/* renamed from: com.facebook.ads.redexgen.X.Lx  reason: case insensitive filesystem */
public final class C0554Lx {
    public static byte[] A00;
    public static String[] A01;

    static {
        A02();
        A01();
    }

    public static String A00(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A00, i, i + i2);
        int i4 = 0;
        while (true) {
            int length = copyOfRange.length;
            if (A01[4].length() != 15) {
                String[] strArr = A01;
                strArr[6] = "rGVas5AoEaq3cBsrCvDeMYMBThCVzhB5";
                strArr[5] = "o0fRmV5yhDY9KCH9v50URkZ7Eg4hKean";
                if (i4 >= length) {
                    return new String(copyOfRange);
                }
                copyOfRange[i4] = (byte) ((copyOfRange[i4] - i3) - 117);
                i4++;
            } else {
                throw new RuntimeException();
            }
        }
    }

    public static void A01() {
        A00 = new byte[]{43, 41, 50, 41, 54, 45, 39};
    }

    public static void A02() {
        A01 = new String[]{"hdV441LwjlNtZv1709qxF0pnny4fVUPp", "ei12BejVo1CHpgyzoQPUfc", "Ngx5CnSLKehr5gInaBo3fbR58cj0cWuD", "KjX1pG4Uk1LfU8Dcrr9VX", "a0G5nH", "Lj0Juqqdj67gjngfjpTqdTQ77lTPdRGa", "RNVdSSMaTLUgDkR28FbRvDpDNW12NXcx", "b5BIPohyMmnUdzrQJ3rYHZFdjlu3USou"};
    }

    public static void A03(Activity activity, int i, C0820Wh wh) {
        try {
            activity.setRequestedOrientation(i);
        } catch (IllegalStateException e) {
            wh.A04().A8G(A00(0, 7, 79), C02248i.A08, new C02258j(e));
        }
    }
}
