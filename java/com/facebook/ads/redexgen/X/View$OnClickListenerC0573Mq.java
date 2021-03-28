package com.facebook.ads.redexgen.X;

import android.view.View;

/* renamed from: com.facebook.ads.redexgen.X.Mq  reason: case insensitive filesystem */
public class View$OnClickListenerC0573Mq implements View.OnClickListener {
    public final /* synthetic */ C0567Mk A00;
    public final /* synthetic */ XU A01;

    public View$OnClickListenerC0573Mq(XU xu, C0567Mk mk) {
        this.A01 = xu;
        this.A00 = mk;
    }

    public final void onClick(View view) {
        if (!KU.A02(this)) {
            try {
                this.A00.A01();
                this.A01.A0A.AAC(AnonymousClass24.A03);
            } catch (Throwable th) {
                KU.A00(th, this);
            }
        }
    }
}
