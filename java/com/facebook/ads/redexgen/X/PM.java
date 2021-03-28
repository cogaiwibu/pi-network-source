package com.facebook.ads.redexgen.X;

import android.animation.Animator;

public class PM implements Animator.AnimatorListener {
    public final /* synthetic */ C0414Gg A00;

    public PM(C0414Gg gg) {
        this.A00 = gg;
    }

    public final void onAnimationCancel(Animator animator) {
        this.A00.A0A(false);
        this.A00.A04();
    }

    public final void onAnimationEnd(Animator animator) {
        this.A00.A01 = PD.A05;
        C0535Le.A0K(this.A00.A05);
        this.A00.A04();
    }

    public final void onAnimationRepeat(Animator animator) {
    }

    public final void onAnimationStart(Animator animator) {
    }
}
