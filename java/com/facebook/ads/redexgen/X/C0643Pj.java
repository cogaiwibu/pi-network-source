package com.facebook.ads.redexgen.X;

import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;

/* renamed from: com.facebook.ads.redexgen.X.Pj  reason: case insensitive filesystem */
public class C0643Pj extends AbstractRunnableC0510Kc {
    public final /* synthetic */ OG A00;
    public final /* synthetic */ OH A01;

    public C0643Pj(OH oh, OG og) {
        this.A01 = oh;
        this.A00 = og;
    }

    @Override // com.facebook.ads.redexgen.X.AbstractRunnableC0510Kc
    public final void A07() {
        AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
        alphaAnimation.setDuration(300);
        alphaAnimation.setInterpolator(new AccelerateInterpolator());
        alphaAnimation.setAnimationListener(new QS(this));
        this.A01.startAnimation(alphaAnimation);
    }
}
