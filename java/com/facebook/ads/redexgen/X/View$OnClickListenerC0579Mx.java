package com.facebook.ads.redexgen.X;

import android.view.View;

/* renamed from: com.facebook.ads.redexgen.X.Mx  reason: case insensitive filesystem */
public class View$OnClickListenerC0579Mx implements View.OnClickListener {
    public final /* synthetic */ AnonymousClass26 A00;
    public final /* synthetic */ C0567Mk A01;
    public final /* synthetic */ C0580My A02;

    public View$OnClickListenerC0579Mx(C0580My my, C0567Mk mk, AnonymousClass26 r3) {
        this.A02 = my;
        this.A01 = mk;
        this.A00 = r3;
    }

    public final void onClick(View view) {
        if (!KU.A02(this)) {
            try {
                this.A01.A01();
                this.A02.A02.AAK(this.A00);
            } catch (Throwable th) {
                KU.A00(th, this);
            }
        }
    }
}
