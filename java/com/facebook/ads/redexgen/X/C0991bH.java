package com.facebook.ads.redexgen.X;

import android.util.Log;
import com.facebook.ads.internal.api.BuildConfigApi;
import java.util.Arrays;

/* renamed from: com.facebook.ads.redexgen.X.bH  reason: case insensitive filesystem */
public class C0991bH implements AbstractC0647Pn {
    public static byte[] A00;
    public static String[] A01;

    static {
        A02();
        A01();
    }

    public static String A00(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A00, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            int i5 = (copyOfRange[i4] - i3) - 117;
            String[] strArr = A01;
            if (strArr[3].charAt(0) != strArr[6].charAt(0)) {
                String[] strArr2 = A01;
                strArr2[3] = "sKECfnlovjgTE3hUnC6hiyxfwSx6iZYU";
                strArr2[6] = "FWGh7KUlNSgjRKrBTTVWdRGVuB2lw617";
                copyOfRange[i4] = (byte) i5;
            } else {
                throw new RuntimeException();
            }
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A00 = new byte[]{-12, 18, 31, -40, 37, -47, 21, 26, 36, 33, 18, 37, 20, 25, -47, 20, 32, 38, 31, 37, 22, 35, 36, -33, 1, 38, 48, 45, 30, 49, 32, 37, 34, 33, -35, 32, 44, 50, 43, 49, 34, 47, 48, -21, -35, 15, 34, 48, 45, 44, 43, 48, 34, -9, -35};
    }

    public static void A02() {
        A01 = new String[]{"XEdsDf1ZbmPdObC9OTEW2z8", "P58GYLlTlw8ULSmid4", "Mge4MDnEmweXwYPX4YofvB", "Ml9Qgu3DLJEhAVMYvCD1k2vZQtwOfhBB", "E1ltw8QxIeAvk6pflmFLXm8YnaEq6i", "JKuYCHjaj2TXENBLxEiyXLq9QhlooG47", "FRLGU9mx00WiiljPewQioxO6UtPhxOrA", "0cr7cMD0TGsotYn7hqiGPP2awzQMRhBn"};
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC0647Pn
    public final void A9C(AbstractC0645Pl pl) {
        if (BuildConfigApi.isDebug() && pl != null) {
            String str = A00(24, 31, 72) + pl.A5U();
        }
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC0647Pn
    public final void A9Y(Exception exc) {
        if (BuildConfigApi.isDebug()) {
            Log.e(JO.A01, A00(0, 24, 60), exc);
        }
    }
}
