package com.facebook.ads.redexgen.X;

import android.view.View;

/* renamed from: com.facebook.ads.redexgen.X.4u  reason: invalid class name and case insensitive filesystem */
public class View$OnClickListenerC01424u implements View.OnClickListener {
    public final /* synthetic */ C0724Sp A00;
    public final /* synthetic */ C1007bZ A01;

    public View$OnClickListenerC01424u(C0724Sp sp, C1007bZ bZVar) {
        this.A00 = sp;
        this.A01 = bZVar;
    }

    public final void onClick(View view) {
        if (!KU.A02(this)) {
            try {
                this.A01.A1D();
            } catch (Throwable th) {
                KU.A00(th, this);
            }
        }
    }
}
