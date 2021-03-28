package com.facebook.ads.redexgen.X;

import android.os.Build;

/* renamed from: com.facebook.ads.redexgen.X.Tz  reason: case insensitive filesystem */
public class C0760Tz implements AbstractC01816i {
    public static String[] A01;
    public final /* synthetic */ U7 A00;

    static {
        A00();
    }

    public static void A00() {
        A01 = new String[]{"pBrDaZa5X5LjOgDS06qrKfvSDyGe8efw", "mQEhYUIy596kL", "EIforD6eBYb22Ex4JOKq", "k4SBaaSc1moa84J0CFgFz3nqLP2HVqmu", "u8nSh4T3SaBZfkGp86pLE93qaiXMklcf", "jMwuEx2OfYupc0", "IfOhRtB8SPti74hSuqBgnsqawc0MdhYN", "25E6wEyieKrSwG"};
    }

    public C0760Tz(U7 u7) {
        this.A00 = u7;
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC01816i
    public final AbstractC01966x A50() {
        if (Build.VERSION.SDK_INT < 4) {
            U7 u7 = this.A00;
            String[] strArr = A01;
            if (strArr[7].length() != strArr[5].length()) {
                throw new RuntimeException();
            }
            String[] strArr2 = A01;
            strArr2[7] = "5uTBAcIF1H8x94";
            strArr2[5] = "w8sP31VUPTTap4";
            return u7.A08(EnumC01926t.A05);
        } else if (this.A00.A01 == null) {
            return this.A00.A08(EnumC01926t.A07);
        } else {
            U7 u72 = this.A00;
            String[] strArr3 = A01;
            if (strArr3[3].charAt(9) != strArr3[6].charAt(9)) {
                String[] strArr4 = A01;
                strArr4[7] = "fRLqK3UXRIvALx";
                strArr4[5] = "beY33YfNkspfTw";
                return u72.A05(u72.A01.targetSdkVersion);
            }
            String[] strArr5 = A01;
            strArr5[4] = "qWUfrjWL8adA9tG6bFG21ciodwCrSrmB";
            strArr5[4] = "qWUfrjWL8adA9tG6bFG21ciodwCrSrmB";
            return u72.A05(u72.A01.targetSdkVersion);
        }
    }
}
