package com.facebook.ads.redexgen.X;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewPropertyAnimator;

/* renamed from: com.facebook.ads.redexgen.X.3k  reason: invalid class name and case insensitive filesystem */
public class C01073k extends AnimatorListenerAdapter {
    public final /* synthetic */ View A00;
    public final /* synthetic */ ViewPropertyAnimator A01;
    public final /* synthetic */ C01093m A02;
    public final /* synthetic */ EV A03;

    public C01073k(EV ev, C01093m r2, ViewPropertyAnimator viewPropertyAnimator, View view) {
        this.A03 = ev;
        this.A02 = r2;
        this.A01 = viewPropertyAnimator;
        this.A00 = view;
    }

    public final void onAnimationEnd(Animator animator) {
        this.A01.setListener(null);
        this.A00.setAlpha(1.0f);
        this.A00.setTranslationX(0.0f);
        this.A00.setTranslationY(0.0f);
        this.A03.A0S(this.A02.A05, true);
        this.A03.A02.remove(this.A02.A05);
        this.A03.A0Y();
    }

    public final void onAnimationStart(Animator animator) {
        this.A03.A0T(this.A02.A05, true);
    }
}
