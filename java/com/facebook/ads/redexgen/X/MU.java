package com.facebook.ads.redexgen.X;

import android.view.View;

public class MU implements View.OnClickListener {
    public final /* synthetic */ C0846Xh A00;

    public MU(C0846Xh xh) {
        this.A00 = xh;
    }

    public final void onClick(View view) {
        if (!KU.A02(this)) {
            try {
                this.A00.A05.A9c();
            } catch (Throwable th) {
                KU.A00(th, this);
            }
        }
    }
}
