package com.facebook.ads.redexgen.X;

import android.os.Build;

public class VZ implements AbstractC01816i {
    public static String[] A01;
    public final /* synthetic */ C0797Vk A00;

    static {
        A00();
    }

    public static void A00() {
        A01 = new String[]{"eOUuWViEzFdpoMILAqmgKfGD", "kQ8zGky5wq3o9AT", "ncGQnuO4sM8XFQVxbr6Mt1Vf36DFujo3", "a4nYvm2BizGaG1Ug1SxTpBLIw0WxQ6vz", "jAlZY9MHNrHTDDv2DRP1sCieuZx8QBhv", "RCRcS7R4oQOTyLjlpIEX5API7Ni0gnf1", "stcG16G11KY1ooFu5mTwbs8KzP9kRkND", "k7goAJY4JhsqFIUQ56a5dCg3eq5QWQcp"};
    }

    public VZ(C0797Vk vk) {
        this.A00 = vk;
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC01816i
    public final AbstractC01966x A50() {
        if (Build.VERSION.SDK_INT < 26) {
            return this.A00.A08(EnumC01926t.A05);
        }
        if (this.A00.A02 == null || this.A00.A02.getPackageInstaller() == null || this.A00.A02.getPackageInstaller().getSessionInfo(0) == null) {
            C0797Vk vk = this.A00;
            EnumC01926t r3 = EnumC01926t.A07;
            if (A01[4].charAt(16) != 'D') {
                throw new RuntimeException();
            }
            String[] strArr = A01;
            strArr[4] = "aumDgxyAyTkwYeibDzhpdrzSDvCJmfPb";
            strArr[4] = "aumDgxyAyTkwYeibDzhpdrzSDvCJmfPb";
            return vk.A08(r3);
        }
        C0797Vk vk2 = this.A00;
        return vk2.A05(vk2.A02.getPackageInstaller().getSessionInfo(0).getInstallReason());
    }
}
