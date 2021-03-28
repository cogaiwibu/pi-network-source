package com.facebook.ads.redexgen.X;

import android.view.View;

public class P6 implements View.OnClickListener {
    public final /* synthetic */ HS A00;

    public P6(HS hs) {
        this.A00 = hs;
    }

    public final void onClick(View view) {
        if (!KU.A02(this)) {
            try {
                this.A00.A03.A03(JK.A0Z, null);
                this.A00.A02.A0A().A33();
                if (this.A00.A00 != null) {
                    if (this.A00.A08()) {
                        this.A00.A00.setVolume(1.0f);
                    } else {
                        this.A00.A00.setVolume(0.0f);
                    }
                    this.A00.A0A();
                }
            } catch (Throwable th) {
                KU.A00(th, this);
            }
        }
    }
}
