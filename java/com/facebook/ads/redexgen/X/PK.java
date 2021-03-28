package com.facebook.ads.redexgen.X;

import android.animation.Animator;

public class PK implements Animator.AnimatorListener {
    public final /* synthetic */ int A00;
    public final /* synthetic */ int A01;
    public final /* synthetic */ C0415Gh A02;

    public PK(C0415Gh gh, int i, int i2) {
        this.A02 = gh;
        this.A01 = i;
        this.A00 = i2;
    }

    public final void onAnimationCancel(Animator animator) {
        C0415Gh.A09(this.A02, this.A00, this.A01, false);
        if (C0415Gh.A01(this.A02) != null) {
            C0415Gh.A01(this.A02).removeAllListeners();
            C0415Gh.A02(this.A02, null);
        }
    }

    public final void onAnimationEnd(Animator animator) {
        PD pd;
        C0415Gh gh = this.A02;
        if (this.A01 == C0415Gh.A00(gh)) {
            pd = PD.A03;
        } else {
            pd = PD.A05;
        }
        C0415Gh.A03(gh, pd);
        if (C0415Gh.A01(this.A02) != null) {
            C0415Gh.A01(this.A02).removeAllListeners();
            C0415Gh.A02(this.A02, null);
        }
    }

    public final void onAnimationRepeat(Animator animator) {
    }

    public final void onAnimationStart(Animator animator) {
    }
}
