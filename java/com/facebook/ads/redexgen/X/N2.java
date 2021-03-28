package com.facebook.ads.redexgen.X;

import android.view.View;

public class N2 implements View.OnClickListener {
    public static String[] A02;
    public final /* synthetic */ C0567Mk A00;
    public final /* synthetic */ XT A01;

    static {
        A00();
    }

    public static void A00() {
        A02 = new String[]{"9sVCZE1JzKyNlgcXamStOEuF7vpp11q7", "2ezkH3kSqCf8dvr0XQnySHd1TgVVvlpb", "j6uQAgvGWfRMr40VSzlVsWkcoISldlVB", "dNEMzbO6BFzdIEcJ0MNYA8UShcXW2fNX", "CiFQ7cnsU8a2IY039", "of093nELJxDtvmpwlx40Sj96vTqfYWfZ", "89mnR6KKQKsitukE0pK0FSEAWYYgI9MC", "iqJuIXwOIBXLoaWKOF5L6veUHjclhPcL"};
    }

    public N2(XT xt, C0567Mk mk) {
        this.A01 = xt;
        this.A00 = mk;
    }

    public final void onClick(View view) {
        if (!KU.A02(this)) {
            try {
                this.A00.A01();
                this.A01.A0A.A7p();
            } catch (Throwable th) {
                KU.A00(th, this);
                String[] strArr = A02;
                if (strArr[7].charAt(23) != strArr[1].charAt(23)) {
                    String[] strArr2 = A02;
                    strArr2[3] = "erh4HILEwUj6GeiKdMF57q4cd8pDAg7o";
                    strArr2[3] = "erh4HILEwUj6GeiKdMF57q4cd8pDAg7o";
                    return;
                }
                throw new RuntimeException();
            }
        }
    }
}
