package com.facebook.ads.redexgen.X;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

public class P2 extends AnimatorListenerAdapter {
    public final /* synthetic */ C02017c A00;

    public P2(C02017c r1) {
        this.A00 = r1;
    }

    public final void onAnimationEnd(Animator animator) {
        this.A00.A00.A04.postDelayed(new C0436Hc(this), 2000);
    }
}
