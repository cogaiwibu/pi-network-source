package com.facebook.ads.redexgen.X;

import android.os.Build;

public class W4 implements AbstractC01816i {
    public static String[] A01;
    public final /* synthetic */ WE A00;

    static {
        A00();
    }

    public static void A00() {
        A01 = new String[]{"xn6Y4xiAj5nTE1ZX0fcI9", "IuzZJNTC9Fpz", "Zp9uFgGuFlryeSNHyo4T0p", "eRJH2gjtevDtLFu1wMxFEv", "pTKacr9NdWTXHSX", "3c0ViuxMUKEAC", "2WDSEnCYP4spNEJs", "S3q5Kz3J"};
    }

    public W4(WE we) {
        this.A00 = we;
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC01816i
    public final AbstractC01966x A50() {
        if (Build.VERSION.SDK_INT < 26) {
            WE we = this.A00;
            String[] strArr = A01;
            if (strArr[2].length() != strArr[3].length()) {
                throw new RuntimeException();
            }
            String[] strArr2 = A01;
            strArr2[2] = "x95Rh7kgyGSfBF3YHwpGzi";
            strArr2[3] = "73CHLU13D6YvD39ECjSAyL";
            return we.A08(EnumC01926t.A05);
        } else if (this.A00.A00 == null) {
            return this.A00.A08(EnumC01926t.A07);
        } else {
            WE we2 = this.A00;
            return we2.A0G(we2.A00.isDataEnabled());
        }
    }
}
