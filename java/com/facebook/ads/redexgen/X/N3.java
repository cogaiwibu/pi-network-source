package com.facebook.ads.redexgen.X;

import android.view.View;

public class N3 implements View.OnClickListener {
    public final /* synthetic */ XT A00;

    public N3(XT xt) {
        this.A00 = xt;
    }

    public final void onClick(View view) {
        if (!KU.A02(this)) {
            try {
                this.A00.A0A.A7D();
            } catch (Throwable th) {
                KU.A00(th, this);
            }
        }
    }
}
