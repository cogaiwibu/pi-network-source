package com.facebook.ads.redexgen.X;

import android.os.Build;

public class VG implements AbstractC01816i {
    public static String[] A01;
    public final /* synthetic */ VI A00;

    static {
        A00();
    }

    public static void A00() {
        A01 = new String[]{"wdcki9TayB0epgOAqgPZ60vGLzXQskFg", "eaUsA8pmkvwqM9uF8kH4nQuKK9Zu7ymc", "2dfJX", "k6tMd5tlxlmCEJMQTJf7pwLJqfV91j3Q", "YVwPmyUK2b9QSHLRAwsi84oHRZQXtzOF", "hpSXL0XJUd77PKoaf1", "iaFmBfogLFf9YiLH80pKK2KW3oFuZo4T", "28ANuaZ3OB7zLgtTtX"};
    }

    public VG(VI vi) {
        this.A00 = vi;
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC01816i
    public final AbstractC01966x A50() {
        if (Build.VERSION.SDK_INT < 16) {
            return this.A00.A08(EnumC01926t.A05);
        }
        if (this.A00.A00 == null) {
            VI vi = this.A00;
            String[] strArr = A01;
            if (strArr[7].length() != strArr[5].length()) {
                throw new RuntimeException();
            }
            String[] strArr2 = A01;
            strArr2[0] = "xEd7j65KlJaDHlrOXF5qOqVEOzAiF9i5";
            strArr2[0] = "xEd7j65KlJaDHlrOXF5qOqVEOzAiF9i5";
            return vi.A08(EnumC01926t.A07);
        }
        VI vi2 = this.A00;
        return vi2.A0G(vi2.A00.isKeyguardLocked());
    }
}
