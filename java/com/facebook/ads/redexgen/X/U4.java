package com.facebook.ads.redexgen.X;

import android.os.Build;

public class U4 implements AbstractC01816i {
    public static String[] A01;
    public final /* synthetic */ U7 A00;

    static {
        A00();
    }

    public static void A00() {
        A01 = new String[]{"9CH7FUr60fjSOu0uDtam6QWrW1LAXcO0", "MGZ5NGAJYsXrcQ530Rpa4mq072uYsiXm", "FSEpTqAJrXrPXD8Cb", "YDmM9nsCETgUfJB46tzDOSpydcNxEQ3F", "VGv8Kw1xSq2totQkDwmbaDQvoJVXTwia", "PqLjk4LqC3tC9ytXEM059nB67sHSnsxP", "xjbenFCMrkBs7EfKqhSnYCZ0lRG62qii", "xgMaaa53aLKiV09tKVXK6rj7dvlbsjte"};
    }

    public U4(U7 u7) {
        this.A00 = u7;
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC01816i
    public final AbstractC01966x A50() {
        if (Build.VERSION.SDK_INT < 24) {
            U7 u7 = this.A00;
            EnumC01926t r3 = EnumC01926t.A05;
            String[] strArr = A01;
            if (strArr[4].charAt(20) != strArr[5].charAt(20)) {
                String[] strArr2 = A01;
                strArr2[3] = "fnZh3TS8JAEKtifjP4n7RBztgRvZoar8";
                strArr2[2] = "4XQjD71oxr9tiB6pv";
                return u7.A08(r3);
            }
            throw new RuntimeException();
        } else if (this.A00.A01 == null) {
            return this.A00.A08(EnumC01926t.A07);
        } else {
            U7 u72 = this.A00;
            return u72.A09(u72.A01.deviceProtectedDataDir);
        }
    }
}
