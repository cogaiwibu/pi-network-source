package com.facebook.ads.redexgen.X;

import android.view.View;

public class M3 implements View.OnClickListener {
    public final /* synthetic */ C0902Zn A00;

    public M3(C0902Zn zn) {
        this.A00 = zn;
    }

    public final void onClick(View view) {
        if (!KU.A02(this)) {
            try {
                if (this.A00.A00 != null && this.A00.A04.A03()) {
                    this.A00.A00.A9A();
                }
            } catch (Throwable th) {
                KU.A00(th, this);
            }
        }
    }
}
