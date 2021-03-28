package com.facebook.ads.redexgen.X;

import android.view.View;

/* renamed from: com.facebook.ads.redexgen.X.Nu  reason: case insensitive filesystem */
public class View$OnClickListenerC0602Nu implements View.OnClickListener {
    public static String[] A01;
    public final /* synthetic */ C02429a A00;

    static {
        A00();
    }

    public static void A00() {
        A01 = new String[]{"c2PEJ6DOqpui9EPvmckbHNLd48C", "0LubsyKGJKKePfKATMceGef14XY86Ri5", "M6oVByKNfKe8LZIrCewzhyGONHgeYcNo", "g1oo9eCM7RcmOvTxZ1VejNMrbdbCR0G4", "3al8rHdAj04D", "Lmo63BJo3ocNRJpk0", "u0Zxd4kfnWeayuGPbNnNq6ZbpiAglx3D", "JRUzdnx3lrNIQCskW6e2Avl8V"};
    }

    public View$OnClickListenerC0602Nu(C02429a r1) {
        this.A00 = r1;
    }

    public final void onClick(View view) {
        if (!KU.A02(this)) {
            try {
                C02429a.A0H(this.A00, false);
                C02429a.A0G(this.A00);
            } catch (Throwable th) {
                if (A01[3].charAt(5) != 'e') {
                    throw new RuntimeException();
                }
                String[] strArr = A01;
                strArr[2] = "oQ6hKoRa6K50vxrlE5lU8mLQHveYoJVv";
                strArr[1] = "5HqmMGmqvKeUZ55y8iy1lLJbe1y4dd8I";
                KU.A00(th, this);
            }
        }
    }
}
