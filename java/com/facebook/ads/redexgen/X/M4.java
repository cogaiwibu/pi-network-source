package com.facebook.ads.redexgen.X;

import android.view.View;

public class M4 implements View.OnClickListener {
    public final /* synthetic */ DialogC0909Zw A00;
    public final /* synthetic */ C0902Zn A01;
    public final /* synthetic */ MQ A02;

    public M4(C0902Zn zn, MQ mq, DialogC0909Zw zw) {
        this.A01 = zn;
        this.A02 = mq;
        this.A00 = zw;
    }

    public final void onClick(View view) {
        if (!KU.A02(this)) {
            try {
                this.A02.A8p();
                this.A00.hide();
            } catch (Throwable th) {
                KU.A00(th, this);
            }
        }
    }
}
