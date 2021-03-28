package com.facebook.ads.redexgen.X;

import android.view.View;

public class MH implements View.OnClickListener {
    public final /* synthetic */ YA A00;

    public MH(YA ya) {
        this.A00 = ya;
    }

    public final void onClick(View view) {
        if (!KU.A02(this)) {
            try {
                this.A00.A0V(false);
            } catch (Throwable th) {
                KU.A00(th, this);
            }
        }
    }
}
