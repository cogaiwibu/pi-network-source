package com.facebook.ads.redexgen.X;

import android.content.Context;
import android.view.View;

public class X5 implements KS {
    @Override // com.facebook.ads.redexgen.X.KS
    public final void ACR(Throwable th, Object obj) {
        if (obj instanceof AnonymousClass8F) {
            C0820Wh A5G = ((AnonymousClass8F) obj).A5G();
            if (A5G != null) {
                A5G.A0E(th);
            }
        } else if (obj instanceof View) {
            Context context = ((View) obj).getContext();
            if (context instanceof C0820Wh) {
                ((C0820Wh) context).A0E(th);
            }
        }
    }
}
