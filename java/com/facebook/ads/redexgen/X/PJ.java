package com.facebook.ads.redexgen.X;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

public class PJ extends AnimatorListenerAdapter {
    public final /* synthetic */ C0416Gi A00;

    public PJ(C0416Gi gi) {
        this.A00 = gi;
    }

    public final void onAnimationCancel(Animator animator) {
        if (C0416Gi.A07(this.A00)) {
            C0535Le.A0O(C0416Gi.A00(this.A00));
        }
        C0416Gi.A00(this.A00).setAlpha(1.0f);
        C0416Gi.A03(this.A00, PD.A03);
        if (C0416Gi.A01(this.A00) != null) {
            C0416Gi.A01(this.A00).setListener(null);
            C0416Gi.A02(this.A00, null);
        }
    }

    public final void onAnimationEnd(Animator animator) {
        if (C0416Gi.A07(this.A00)) {
            C0535Le.A0K(C0416Gi.A00(this.A00));
        }
        C0416Gi.A03(this.A00, PD.A05);
        if (C0416Gi.A01(this.A00) != null) {
            C0416Gi.A01(this.A00).setListener(null);
            C0416Gi.A02(this.A00, null);
        }
    }
}
