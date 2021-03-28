package com.facebook.ads.redexgen.X;

import android.animation.ValueAnimator;

/* renamed from: com.facebook.ads.redexgen.X.Nx  reason: case insensitive filesystem */
public class C0605Nx implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ C0672Qm A00;

    public C0605Nx(C0672Qm qm) {
        this.A00 = qm;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.A00.A06.getLayoutParams().height = ((Integer) valueAnimator.getAnimatedValue()).intValue();
        this.A00.A06.requestLayout();
    }
}
