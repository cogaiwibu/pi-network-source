package com.facebook.ads.redexgen.X;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

/* renamed from: com.facebook.ads.redexgen.X.Ny  reason: case insensitive filesystem */
public class C0606Ny extends AnimatorListenerAdapter {
    public final /* synthetic */ C0672Qm A00;
    public final /* synthetic */ boolean A01;

    public C0606Ny(C0672Qm qm, boolean z) {
        this.A00 = qm;
        this.A01 = z;
    }

    public final void onAnimationEnd(Animator animator) {
        super.onAnimationEnd(animator);
        this.A00.A0F.setTranslationY(0.0f);
        this.A00.A0J();
        if (!this.A01 && this.A00.A0D != null) {
            this.A00.A0D.destroy();
        }
    }
}
