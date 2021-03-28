package com.facebook.ads.redexgen.X;

import java.io.IOException;

public class FO implements Runnable {
    public static String[] A06;
    public final /* synthetic */ FT A00;
    public final /* synthetic */ FU A01;
    public final /* synthetic */ FV A02;
    public final /* synthetic */ FW A03;
    public final /* synthetic */ IOException A04;
    public final /* synthetic */ boolean A05;

    static {
        A00();
    }

    public static void A00() {
        A06 = new String[]{"MFzmm2XpKtQDQZ1nrLFzIVLfypAdXqn0", "St6NP3oa8jPcs9ySqX58Qb7cq6M0Lslj", "FY6GSV0T1DmbxtheDZWAefy5bW4XMUrK", "e7zVVEHUrXPHmOTr9XrOqtCewhDOezV9", "rRe4XoYawEGGgKvf4FFgivRzu7z94IPy", "2sUcpRkbdiQEA9XQnsePPVJ2ZVsexJIi", "YygzZHUIY4dTUEusYM1qdSBaSuhDwAUc", "5Y8Iu0wedn9Jl3yvaaWMiUkpwoVz8Vqp"};
    }

    public FO(FT ft, FW fw, FU fu, FV fv, IOException iOException, boolean z) {
        this.A00 = ft;
        this.A03 = fw;
        this.A01 = fu;
        this.A02 = fv;
        this.A04 = iOException;
        this.A05 = z;
    }

    public final void run() {
        if (!KU.A02(this)) {
            try {
                this.A03.AA1(this.A00.A00, this.A00.A01, this.A01, this.A02, this.A04, this.A05);
            } catch (Throwable th) {
                String[] strArr = A06;
                if (strArr[7].charAt(1) != strArr[2].charAt(1)) {
                    throw new RuntimeException();
                }
                String[] strArr2 = A06;
                strArr2[7] = "5YuzUPqIN2qUpgzcgBPCGBub3XZtkUQJ";
                strArr2[2] = "DYAXZKj6jF9OEHVnXiKZJEzpdMmcnACr";
                KU.A00(th, this);
            }
        }
    }
}
