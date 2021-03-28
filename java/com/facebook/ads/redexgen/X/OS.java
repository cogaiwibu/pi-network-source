package com.facebook.ads.redexgen.X;

import android.view.View;

public class OS implements View.OnClickListener {
    public final /* synthetic */ OT A00;

    public OS(OT ot) {
        this.A00 = ot;
    }

    public final void onClick(View view) {
        if (!KU.A02(this)) {
            try {
                this.A00.A04.performClick();
            } catch (Throwable th) {
                KU.A00(th, this);
            }
        }
    }
}
