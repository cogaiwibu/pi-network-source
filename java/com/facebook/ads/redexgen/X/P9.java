package com.facebook.ads.redexgen.X;

import android.view.View;

public class P9 implements View.OnClickListener {
    public final /* synthetic */ AnonymousClass7B A00;

    public P9(AnonymousClass7B r1) {
        this.A00 = r1;
    }

    public final void onClick(View view) {
        if (!KU.A02(this)) {
            try {
                if (AnonymousClass7B.A02(this.A00) != null) {
                    if (AnonymousClass7B.A01(this.A00) != null) {
                        AnonymousClass7B.A01(this.A00).A03(JK.A0l, null);
                    }
                    AnonymousClass7B.A00(this.A00).A0A().A2x();
                    int i = PA.A00[AnonymousClass7B.A03(this.A00).getState().ordinal()];
                    if (i == 1 || i == 2 || i == 3 || i == 4) {
                        AnonymousClass7B.A04(this.A00).A0Y(EnumC0626Os.A05, 12);
                    } else if (i == 5) {
                        AnonymousClass7B.A05(this.A00).A0b(true, 8);
                    }
                }
            } catch (Throwable th) {
                KU.A00(th, this);
            }
        }
    }
}
