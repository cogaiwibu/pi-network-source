package com.facebook.ads.redexgen.X;

import android.view.View;

public class N6 implements View.OnClickListener {
    public final /* synthetic */ N9 A00;

    public N6(N9 n9) {
        this.A00 = n9;
    }

    public final void onClick(View view) {
        if (!KU.A02(this)) {
            try {
                if (this.A00.A02 != null) {
                    this.A00.A02.A9A();
                }
            } catch (Throwable th) {
                KU.A00(th, this);
            }
        }
    }
}
