package com.facebook.ads.redexgen.X;

import android.content.pm.ActivityInfo;

/* renamed from: com.facebook.ads.redexgen.X.Vi  reason: case insensitive filesystem */
public class C0795Vi implements AbstractC01816i {
    public static String[] A01;
    public final /* synthetic */ C0797Vk A00;

    static {
        A00();
    }

    public static void A00() {
        A01 = new String[]{"BjEOBj6HSQS8i4DRK2qoJX27hoC0R4DA", "kauKwe7CVPrqe4cOgSIwGmxqelbhToEk", "XZC7QZo7Jtp8ceyvJGPCObnucv7Agiw", "JUan8YMmX5ogxlB6aq0dkHVlKOHTqFeF", "IuTolVrjy7qRtOK6QcTLTodgNQuY61bU", "4L2hIP4Kb6m", "Yg6y90VIZ7Ah3ybSxqXW6wOi2HMwnGfT", "hl8KcVIJUlPiTEXEjbalUYczznSZgz62"};
    }

    public C0795Vi(C0797Vk vk) {
        this.A00 = vk;
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC01816i
    public final AbstractC01966x A50() {
        if (this.A00.A04 == null) {
            return this.A00.A08(EnumC01926t.A07);
        }
        C0797Vk vk = this.A00;
        ActivityInfo[] activityInfoArr = vk.A04;
        if (A01[3].charAt(20) != 'k') {
            throw new RuntimeException();
        }
        String[] strArr = A01;
        strArr[4] = "ZFJR0DMAu8l3jjK6mMcKAcH3eLfgQnHb";
        strArr[4] = "ZFJR0DMAu8l3jjK6mMcKAcH3eLfgQnHb";
        return vk.A05(activityInfoArr.length);
    }
}
