package com.facebook.ads.redexgen.X;

import android.os.Handler;
import android.view.animation.Animation;

/* renamed from: com.facebook.ads.redexgen.X.4q  reason: invalid class name and case insensitive filesystem */
public class animation.Animation$AnimationListenerC01384q implements Animation.AnimationListener {
    public final /* synthetic */ C01414t A00;

    public animation.Animation$AnimationListenerC01384q(C01414t r1) {
        this.A00 = r1;
    }

    public final void onAnimationEnd(Animation animation) {
        new Handler().postDelayed(new C0723So(this), 3000);
    }

    public final void onAnimationRepeat(Animation animation) {
    }

    public final void onAnimationStart(Animation animation) {
    }
}
