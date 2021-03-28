package com.facebook.ads.redexgen.X;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewPropertyAnimator;

/* renamed from: com.facebook.ads.redexgen.X.3j  reason: invalid class name and case insensitive filesystem */
public class C01063j extends AnimatorListenerAdapter {
    public final /* synthetic */ int A00;
    public final /* synthetic */ int A01;
    public final /* synthetic */ View A02;
    public final /* synthetic */ ViewPropertyAnimator A03;
    public final /* synthetic */ EV A04;
    public final /* synthetic */ AnonymousClass4X A05;

    public C01063j(EV ev, AnonymousClass4X r2, int i, View view, int i2, ViewPropertyAnimator viewPropertyAnimator) {
        this.A04 = ev;
        this.A05 = r2;
        this.A00 = i;
        this.A02 = view;
        this.A01 = i2;
        this.A03 = viewPropertyAnimator;
    }

    public final void onAnimationCancel(Animator animator) {
        if (this.A00 != 0) {
            this.A02.setTranslationX(0.0f);
        }
        if (this.A01 != 0) {
            this.A02.setTranslationY(0.0f);
        }
    }

    public final void onAnimationEnd(Animator animator) {
        this.A03.setListener(null);
        this.A04.A0O(this.A05);
        this.A04.A04.remove(this.A05);
        this.A04.A0Y();
    }

    public final void onAnimationStart(Animator animator) {
        this.A04.A0P(this.A05);
    }
}
