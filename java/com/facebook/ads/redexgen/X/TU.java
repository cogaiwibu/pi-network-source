package com.facebook.ads.redexgen.X;

import android.annotation.SuppressLint;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.HashMap;

public final class TU implements AnonymousClass6A {
    public static String[] A02;
    public final TW A00;
    public final C0821Wi A01;

    static {
        A00();
    }

    public static void A00() {
        A02 = new String[]{"iWDBF2OKl3jtj3mE0UZLtkhUaVvUxXqs", "ms2LCEwCyzsqM8QDDj0PRev1P1CSm3w7", "hMtVrOKQMF9h", "gi6PEiuAAOhVuZEccjIoIAk9XYc1uF", "R32JKWcbl7Qu2cyp2LhmQehQDOktlipk", "kBJUlLOX6LAUVPMDIzawXbz3hNZwTKWy", "5r9f7V6KCkM3IvysTdnytDlDBRDUQAcw", "vGzO7SO4CN32udhBb2qyIGFDHHv1hOkX"};
    }

    public TU(C0821Wi wi) {
        this.A01 = wi;
        this.A00 = new TW(wi);
    }

    public final TW A01() {
        return this.A00;
    }

    @Override // com.facebook.ads.redexgen.X.AnonymousClass6A
    @SuppressLint({"BadMethodUse-java.lang.String.length"})
    public final void ACU(Throwable th) {
        if (th != null && C01695w.A00(this.A01) < Math.random()) {
            StringWriter stringWriter = new StringWriter();
            th.printStackTrace(new PrintWriter(stringWriter));
            String stringWriter2 = stringWriter.toString();
            TW tw = this.A00;
            String A03 = AnonymousClass65.A04.A03();
            String A022 = AnonymousClass66.A06.A02();
            HashMap hashMap = new HashMap();
            String message = th.getMessage();
            if (stringWriter2 != null) {
                int length = stringWriter2.length();
                if (A02[1].charAt(16) != 'D') {
                    throw new RuntimeException();
                }
                String[] strArr = A02;
                strArr[5] = "Ct83iaSYEVOHUGfDQtOJkAbKybUxEBTx";
                strArr[5] = "Ct83iaSYEVOHUGfDQtOJkAbKybUxEBTx";
                if (length > 500) {
                    stringWriter2 = stringWriter2.substring(0, 500);
                }
            }
            tw.A8B(A03, A022, hashMap, null, message, stringWriter2, th.getClass().getSimpleName());
        }
    }
}
