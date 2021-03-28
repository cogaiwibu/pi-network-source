package com.facebook.ads.redexgen.X;

import android.os.Build;

/* renamed from: com.facebook.ads.redexgen.X.Vg  reason: case insensitive filesystem */
public class C0793Vg implements AbstractC01816i {
    public static String[] A01;
    public final /* synthetic */ C0797Vk A00;

    static {
        A00();
    }

    public static void A00() {
        A01 = new String[]{"zJajY9dZZxYFsLRzsvnBiwQWt0HnizLC", "gzFaheVOcPUMbI38nwUIVYmc91b5uR", "ce0KJPPQByTAaQ9ATxZk2kwW24DeaJ9j", "R6Wiv8wmYaZdmPdgU3hXsutSf", "job2ys34errF3to", "kwK9VFGEGX8wPEd", "j3AidPNHk3dBWfN6HPyZ7", "rfM1O6R1RyyEf1DP"};
    }

    public C0793Vg(C0797Vk vk) {
        this.A00 = vk;
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC01816i
    public final AbstractC01966x A50() {
        if (this.A00.A01 == null || Build.VERSION.SDK_INT < 22) {
            return this.A00.A08(EnumC01926t.A07);
        }
        C0797Vk vk = this.A00;
        if (A01[1].length() != 30) {
            throw new RuntimeException();
        }
        String[] strArr = A01;
        strArr[6] = "SsABSdrOWb5CHUfmSefeH";
        strArr[6] = "SsABSdrOWb5CHUfmSefeH";
        return vk.A05(vk.A01.baseRevisionCode);
    }
}
