package com.facebook.ads.redexgen.X;

import android.view.View;

public class MJ implements View.OnClickListener {
    public final /* synthetic */ MF A00;
    public final /* synthetic */ C0858Xt A01;

    public MJ(C0858Xt xt, MF mf) {
        this.A01 = xt;
        this.A00 = mf;
    }

    public final void onClick(View view) {
        if (!KU.A02(this)) {
            try {
                C0535Le.A0M(this.A00);
                C0535Le.A0O(this.A01.A0N);
                C0535Le.A0O(this.A01.A04);
                if (this.A01.A09 != null) {
                    this.A01.A09.A0Y(EnumC0626Os.A03, 15);
                }
            } catch (Throwable th) {
                KU.A00(th, this);
            }
        }
    }
}
