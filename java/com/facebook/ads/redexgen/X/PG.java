package com.facebook.ads.redexgen.X;

import android.animation.Animator;

public class PG implements Animator.AnimatorListener {
    public final /* synthetic */ C0419Gl A00;

    public PG(C0419Gl gl) {
        this.A00 = gl;
    }

    public final void onAnimationCancel(Animator animator) {
        C0419Gl.A06(this.A00, false);
        if (C0419Gl.A01(this.A00) != null) {
            C0419Gl.A01(this.A00).removeAllListeners();
            C0419Gl.A02(this.A00, null);
        }
    }

    public final void onAnimationEnd(Animator animator) {
        C0419Gl.A04(this.A00, PD.A05);
        C0535Le.A0K(C0419Gl.A03(this.A00));
        if (C0419Gl.A01(this.A00) != null) {
            C0419Gl.A01(this.A00).removeAllListeners();
            C0419Gl.A02(this.A00, null);
        }
    }

    public final void onAnimationRepeat(Animator animator) {
    }

    public final void onAnimationStart(Animator animator) {
    }
}
