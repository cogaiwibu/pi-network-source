package com.facebook.ads.redexgen.X;

import android.os.Build;
import android.telephony.TelephonyManager;

public class W6 implements AbstractC01816i {
    public static String[] A01;
    public final /* synthetic */ WE A00;

    static {
        A00();
    }

    public static void A00() {
        A01 = new String[]{"YvgwWocx1FADdeAzbpsmJqKucTKVrLw8", "IN5yo6alVzQxSBDS0LSAMVLc9G2MRZFn", "HAZTu6IPNZsD1qj0M1i9utr9DJx5S0QZ", "N5cGJfQ0ESKW2WKzc5hPaTPWXOaKWBwf", "tNMXMhxZjOCLmtsXwerOChNpJkA4NIz8", "qe3nCZLHllYVPimtyVQbZz0eRg0vYsPF", "hksQgw", "nUQ4NN4k5WyfvhfMBfttwidjpDAXB5K7"};
    }

    public W6(WE we) {
        this.A00 = we;
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC01816i
    public final AbstractC01966x A50() {
        if (this.A00.A00 == null) {
            return this.A00.A08(EnumC01926t.A07);
        }
        if (Build.VERSION.SDK_INT >= 24) {
            WE we = this.A00;
            return we.A05(we.A00.getVoiceNetworkType());
        }
        WE we2 = this.A00;
        TelephonyManager telephonyManager = we2.A00;
        if (A01[2].charAt(0) != 'L') {
            String[] strArr = A01;
            strArr[1] = "ynGeEoYIomGmDWEGPoJ89qRpE67tUZnz";
            strArr[1] = "ynGeEoYIomGmDWEGPoJ89qRpE67tUZnz";
            return we2.A05(telephonyManager.getNetworkType());
        }
        throw new RuntimeException();
    }
}
