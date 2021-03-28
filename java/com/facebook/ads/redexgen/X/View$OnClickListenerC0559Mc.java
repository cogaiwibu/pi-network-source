package com.facebook.ads.redexgen.X;

import android.view.View;

/* renamed from: com.facebook.ads.redexgen.X.Mc  reason: case insensitive filesystem */
public class View$OnClickListenerC0559Mc implements View.OnClickListener {
    public final /* synthetic */ C0562Mf A00;

    public View$OnClickListenerC0559Mc(C0562Mf mf) {
        this.A00 = mf;
    }

    public final void onClick(View view) {
        if (!KU.A02(this)) {
            try {
                if (this.A00.A04) {
                    this.A00.A03.A42();
                } else {
                    this.A00.A03.A43();
                }
            } catch (Throwable th) {
                KU.A00(th, this);
            }
        }
    }
}
