package com.facebook.ads.redexgen.X;

import androidx.annotation.RequiresApi;

/* renamed from: com.facebook.ads.redexgen.X.Wm  reason: case insensitive filesystem */
public class C0825Wm extends AbstractRunnableC0510Kc {
    public final /* synthetic */ C0585Nd A00;

    public C0825Wm(C0585Nd nd) {
        this.A00 = nd;
    }

    @Override // com.facebook.ads.redexgen.X.AbstractRunnableC0510Kc
    @RequiresApi(api = 16)
    public final void A07() {
        if (this.A00.isPressed()) {
            C0585Nd nd = this.A00;
            nd.postDelayed(this, (long) C0585Nd.A01(nd));
            return;
        }
        this.A00.setPressed(true);
        C0585Nd nd2 = this.A00;
        nd2.postOnAnimationDelayed(C0585Nd.A02(nd2), 250);
    }
}
