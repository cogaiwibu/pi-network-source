package com.facebook.ads.redexgen.X;

import android.view.View;

public class MK implements View.OnClickListener {
    public final /* synthetic */ MF A00;
    public final /* synthetic */ C0858Xt A01;

    public MK(C0858Xt xt, MF mf) {
        this.A01 = xt;
        this.A00 = mf;
    }

    public final void onClick(View view) {
        if (!KU.A02(this)) {
            try {
                C0535Le.A0M(this.A00);
                C0535Le.A0O(this.A01.A0N);
                C0535Le.A0O(this.A01.A04);
                this.A01.A0L();
            } catch (Throwable th) {
                KU.A00(th, this);
            }
        }
    }
}
