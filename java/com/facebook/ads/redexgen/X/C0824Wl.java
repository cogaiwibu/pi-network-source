package com.facebook.ads.redexgen.X;

import androidx.annotation.RequiresApi;

/* renamed from: com.facebook.ads.redexgen.X.Wl  reason: case insensitive filesystem */
public class C0824Wl extends AbstractRunnableC0510Kc {
    public final /* synthetic */ C0585Nd A00;

    public C0824Wl(C0585Nd nd) {
        this.A00 = nd;
    }

    @Override // com.facebook.ads.redexgen.X.AbstractRunnableC0510Kc
    @RequiresApi(api = 16)
    public final void A07() {
        this.A00.setPressed(false);
        C0585Nd nd = this.A00;
        nd.postOnAnimationDelayed(C0585Nd.A03(nd), (long) C0585Nd.A01(this.A00));
    }
}
