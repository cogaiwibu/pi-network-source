package com.facebook.ads.redexgen.X;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewPropertyAnimator;

/* renamed from: com.facebook.ads.redexgen.X.3h  reason: invalid class name and case insensitive filesystem */
public class C01043h extends AnimatorListenerAdapter {
    public final /* synthetic */ View A00;
    public final /* synthetic */ ViewPropertyAnimator A01;
    public final /* synthetic */ EV A02;
    public final /* synthetic */ AnonymousClass4X A03;

    public C01043h(EV ev, AnonymousClass4X r2, ViewPropertyAnimator viewPropertyAnimator, View view) {
        this.A02 = ev;
        this.A03 = r2;
        this.A01 = viewPropertyAnimator;
        this.A00 = view;
    }

    public final void onAnimationEnd(Animator animator) {
        this.A01.setListener(null);
        this.A00.setAlpha(1.0f);
        this.A02.A0Q(this.A03);
        this.A02.A06.remove(this.A03);
        this.A02.A0Y();
    }

    public final void onAnimationStart(Animator animator) {
        this.A02.A0R(this.A03);
    }
}
