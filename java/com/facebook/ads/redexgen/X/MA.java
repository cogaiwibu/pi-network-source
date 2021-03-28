package com.facebook.ads.redexgen.X;

import android.view.View;
import com.facebook.ads.internal.view.FullScreenAdToolbar;

public class MA implements View.OnClickListener {
    public final /* synthetic */ FullScreenAdToolbar A00;

    public MA(FullScreenAdToolbar fullScreenAdToolbar) {
        this.A00 = fullScreenAdToolbar;
    }

    public final void onClick(View view) {
        if (!KU.A02(this)) {
            try {
                if (FullScreenAdToolbar.A00(this.A00) != null && FullScreenAdToolbar.A01(this.A00).A03()) {
                    FullScreenAdToolbar.A00(this.A00).A9A();
                }
            } catch (Throwable th) {
                KU.A00(th, this);
            }
        }
    }
}
