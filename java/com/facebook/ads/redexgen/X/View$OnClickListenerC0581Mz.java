package com.facebook.ads.redexgen.X;

import android.view.View;

/* renamed from: com.facebook.ads.redexgen.X.Mz  reason: case insensitive filesystem */
public class View$OnClickListenerC0581Mz implements View.OnClickListener {
    public final /* synthetic */ XT A00;

    public View$OnClickListenerC0581Mz(XT xt) {
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
