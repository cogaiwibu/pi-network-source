package com.facebook.ads.redexgen.X;

import android.os.Bundle;
import android.view.View;

/* renamed from: com.facebook.ads.redexgen.X.Sj  reason: case insensitive filesystem */
public class C0718Sj extends AnonymousClass2Y {
    public static String[] A01;
    public final C0719Sk A00;

    static {
        A00();
    }

    public static void A00() {
        A01 = new String[]{"Aypyv0FACfsPQTq8B8UFxLSJIGYFzsCC", "O7nTze5knL3NcSr2rovnk7vqxWhLtUKF", "w8KDuB7m9FBYOy6hiJzio9ilRX5MSLSp", "Kqe5H6YPSeJrA9PRZ2BXFN4qonyjjTB9", "VPpNE9vsyh3HxU94PoFE47DnBqUfoC5Y", "VSW3ZMLcugYKNhiURlJ0g5uJ7Smp29SS", "AB", "JpT6Sbfy0irMNtnKFHDBnJ8tZotKHb"};
    }

    public C0718Sj(C0719Sk sk) {
        this.A00 = sk;
    }

    @Override // com.facebook.ads.redexgen.X.AnonymousClass2Y
    public final void A08(View view, AnonymousClass3J r3) {
        super.A08(view, r3);
        if (!this.A00.A0B() && this.A00.A01.getLayoutManager() != null) {
            this.A00.A01.getLayoutManager().A1D(view, r3);
        }
    }

    @Override // com.facebook.ads.redexgen.X.AnonymousClass2Y
    public final boolean A09(View view, int i, Bundle bundle) {
        if (super.A09(view, i, bundle)) {
            if (A01[2].charAt(3) != 'j') {
                String[] strArr = A01;
                strArr[6] = "SRS22nAnXgHfwC2qheyHP9Kgc2YZ";
                strArr[6] = "SRS22nAnXgHfwC2qheyHP9Kgc2YZ";
                return true;
            }
            throw new RuntimeException();
        } else if (this.A00.A0B() || this.A00.A01.getLayoutManager() == null) {
            return false;
        } else {
            return this.A00.A01.getLayoutManager().A1c(view, i, bundle);
        }
    }
}
