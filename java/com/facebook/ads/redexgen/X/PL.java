package com.facebook.ads.redexgen.X;

import android.animation.Animator;

public class PL implements Animator.AnimatorListener {
    public final /* synthetic */ C0414Gg A00;

    public PL(C0414Gg gg) {
        this.A00 = gg;
    }

    public final void onAnimationCancel(Animator animator) {
        this.A00.A09(false);
        this.A00.A04();
    }

    public final void onAnimationEnd(Animator animator) {
        this.A00.A00 = null;
        this.A00.A01 = PD.A03;
        this.A00.A04();
    }

    public final void onAnimationRepeat(Animator animator) {
    }

    public final void onAnimationStart(Animator animator) {
    }
}
