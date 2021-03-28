package com.facebook.ads.redexgen.X;

import android.animation.ValueAnimator;
import android.view.View;

public class PN implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ View A00;
    public final /* synthetic */ C0414Gg A01;

    public PN(C0414Gg gg, View view) {
        this.A01 = gg;
        this.A00 = view;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.A00.setTranslationY((float) ((Integer) valueAnimator.getAnimatedValue()).intValue());
    }
}
