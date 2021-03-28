package com.facebook.ads.redexgen.X;

import android.app.ActivityManager;

/* renamed from: com.facebook.ads.redexgen.X.Tb  reason: case insensitive filesystem */
public class C0736Tb implements AbstractC01816i {
    public static String[] A01;
    public final /* synthetic */ C0747Tm A00;

    static {
        A00();
    }

    public static void A00() {
        A01 = new String[]{"ks6FgoJovve7iHM2pZkl", "wha53u", "49wSJ7V8XkDKZTUcjMDnpoSn", "1JQ5I5ad77Yrp3ewkirQ0oRutiEmvr6i", "jAt3ZHaaMbDXz0fIQiir7V", "EKdcAjdCbYFTR4bnYqi4SV", "MwtlcC", "w1RouBmka6J1zGDRhikmrfItH78owLWg"};
    }

    public C0736Tb(C0747Tm tm) {
        this.A00 = tm;
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC01816i
    public final AbstractC01966x A50() {
        if (this.A00.A02 != null) {
            return this.A00.A0G(ActivityManager.isUserAMonkey());
        }
        C0747Tm tm = this.A00;
        EnumC01926t r3 = EnumC01926t.A07;
        if (A01[2].length() != 23) {
            String[] strArr = A01;
            strArr[3] = "MHidzBjnmsHNQkooJipxy3AaWgleVPOv";
            strArr[7] = "EW2Ra62KpqEXQLSIkiFDqiivYFqdEGvM";
            return tm.A08(r3);
        }
        throw new RuntimeException();
    }
}
