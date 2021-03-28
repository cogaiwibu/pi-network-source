package com.facebook.ads.redexgen.X;

import android.view.View;

/* renamed from: com.facebook.ads.redexgen.X.Mp  reason: case insensitive filesystem */
public class View$OnClickListenerC0572Mp implements View.OnClickListener {
    public final /* synthetic */ XU A00;

    public View$OnClickListenerC0572Mp(XU xu) {
        this.A00 = xu;
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
