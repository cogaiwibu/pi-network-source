package com.facebook.ads.redexgen.X;

import android.animation.Animator;

public class PF implements Animator.AnimatorListener {
    public final /* synthetic */ C0419Gl A00;

    public PF(C0419Gl gl) {
        this.A00 = gl;
    }

    public final void onAnimationCancel(Animator animator) {
        C0419Gl.A05(this.A00, false);
    }

    public final void onAnimationEnd(Animator animator) {
        C0419Gl.A02(this.A00, null);
        C0419Gl.A04(this.A00, PD.A03);
    }

    public final void onAnimationRepeat(Animator animator) {
    }

    public final void onAnimationStart(Animator animator) {
    }
}
