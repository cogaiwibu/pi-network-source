package com.facebook.ads.redexgen.X;

import android.view.View;

/* renamed from: com.facebook.ads.redexgen.X.4Y  reason: invalid class name */
public final class AnonymousClass4Y {
    public static String[] A00;

    static {
        A03();
    }

    public static void A03() {
        A00 = new String[]{"UqypfisWbLbbWLDfIVvpiaUsz0iS", "wEiCJDeLGzLJebV", "cX", "dRMEhdR7kDOm9Ob", "SmhGT229bW5LAFpAZzaxeRYqKvMDeGhX", "QcSoUKFtoryhyFMFYIfDI81ChPsDlMu7", "SBvSWfqovIH0ljTVzoffsyrdWCNw", "n"};
    }

    public static int A00(AnonymousClass4U r4, AbstractC01213z r5, View view, View view2, AnonymousClass4F r8, boolean z) {
        if (r8.A0X() == 0 || r4.A03() == 0 || view == null || view2 == null) {
            return 0;
        }
        if (!z) {
            return Math.abs(r8.A0q(view) - r8.A0q(view2)) + 1;
        }
        int A0C = r5.A0C(view2);
        int A0F = r5.A0F(view);
        String[] strArr = A00;
        if (strArr[4].charAt(28) != strArr[5].charAt(28)) {
            String[] strArr2 = A00;
            strArr2[3] = "xd2oZUwi45Npmqe";
            strArr2[1] = "1k2xoHfklbXXQiR";
            return Math.min(r5.A0B(), A0C - A0F);
        }
        throw new RuntimeException();
    }

    public static int A01(AnonymousClass4U r3, AbstractC01213z r4, View view, View view2, AnonymousClass4F r7, boolean z) {
        if (r7.A0X() == 0 || r3.A03() == 0 || view == null || view2 == null) {
            return 0;
        }
        if (!z) {
            return r3.A03();
        }
        return (int) ((((float) (r4.A0C(view2) - r4.A0F(view))) / ((float) (Math.abs(r7.A0q(view) - r7.A0q(view2)) + 1))) * ((float) r3.A03()));
    }

    public static int A02(AnonymousClass4U r5, AbstractC01213z r6, View view, View view2, AnonymousClass4F r9, boolean z, boolean z2) {
        int max;
        if (r9.A0X() != 0) {
            int A03 = r5.A03();
            String[] strArr = A00;
            if (strArr[3].length() != strArr[1].length()) {
                throw new RuntimeException();
            }
            String[] strArr2 = A00;
            strArr2[6] = "xSzU3PMpL9LC7k2G9V08vNIV3nIP";
            strArr2[0] = "UsrmTbcEPDcBULmsiiLKltF5MwgK";
            if (!(A03 == 0 || view == null || view2 == null)) {
                int min = Math.min(r9.A0q(view), r9.A0q(view2));
                int max2 = Math.max(r9.A0q(view), r9.A0q(view2));
                if (z2) {
                    max = Math.max(0, (r5.A03() - max2) - 1);
                } else {
                    max = Math.max(0, min);
                }
                if (!z) {
                    return max;
                }
                return Math.round((((float) max) * (((float) Math.abs(r6.A0C(view2) - r6.A0F(view))) / ((float) (Math.abs(r9.A0q(view) - r9.A0q(view2)) + 1)))) + ((float) (r6.A0A() - r6.A0F(view))));
            }
        }
        return 0;
    }
}
