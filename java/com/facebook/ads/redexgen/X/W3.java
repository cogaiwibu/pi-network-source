package com.facebook.ads.redexgen.X;

import android.annotation.SuppressLint;
import android.os.Build;

public class W3 implements AbstractC01816i {
    public static String[] A01;
    public final /* synthetic */ WE A00;

    static {
        A00();
    }

    public static void A00() {
        A01 = new String[]{"Zr9pMbCXDOnIQia1rxNbs", "xgHdKmUla89dgoNlEUmYBSdthljERTVN", "t0eJ9CzsilrQTJZ3mBY5uHdLOToWpPD0", "xn7Df6Bsn6N8b", "nuXOesuXOGqaff6jWjDzzwB48Mr7m9Ru", "HD4PNhpjIErL9f7FhF1L2XB0w8jmfy8z", "GFJMAbd7JtPv78Iw3eZ5GKABpr6j7C", "a6D5eDw1EZzTAa7WvhZLV0FGc6KUpGTS"};
    }

    public W3(WE we) {
        this.A00 = we;
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC01816i
    @SuppressLint({"MissingPermission"})
    public final AbstractC01966x A50() {
        if (Build.VERSION.SDK_INT < 17) {
            return this.A00.A08(EnumC01926t.A05);
        }
        boolean A0E = AnonymousClass76.A0E();
        if (A01[2].charAt(7) != 's') {
            throw new RuntimeException();
        }
        String[] strArr = A01;
        strArr[4] = "7cAAgCcjwnswSonydGODzEoLsKghCJb5";
        strArr[4] = "7cAAgCcjwnswSonydGODzEoLsKghCJb5";
        if (A0E) {
            boolean A0D = AnonymousClass76.A0D();
            if (A01[1].charAt(23) != 'I') {
                String[] strArr2 = A01;
                strArr2[7] = "A1O8dvsw8NjieGbBncMIJ1M47KAaXmaM";
                strArr2[7] = "A1O8dvsw8NjieGbBncMIJ1M47KAaXmaM";
                if (A0D) {
                    return this.A00.A08(EnumC01926t.A07);
                }
            } else {
                throw new RuntimeException();
            }
        }
        if (this.A00.A00 != null) {
            WE we = this.A00;
            return we.A05(WE.A01(we.A00.getAllCellInfo().get(0)));
        }
        WE we2 = this.A00;
        EnumC01926t r3 = EnumC01926t.A07;
        String[] strArr3 = A01;
        if (strArr3[3].length() == strArr3[6].length()) {
            return we2.A08(r3);
        }
        String[] strArr4 = A01;
        strArr4[3] = "coCM9MFponCPc";
        strArr4[6] = "NV1iD8UH9ErBba9OnjbAeyrfSpL8qw";
        return we2.A08(r3);
    }
}
