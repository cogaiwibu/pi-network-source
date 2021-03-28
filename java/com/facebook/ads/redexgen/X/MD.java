package com.facebook.ads.redexgen.X;

import android.os.Handler;
import android.view.animation.Animation;

public class MD implements Animation.AnimationListener {
    public final /* synthetic */ AnonymousClass51 A00;
    public final /* synthetic */ ZY A01;
    public final /* synthetic */ ZY A02;

    public MD(ZY zy, ZY zy2, AnonymousClass51 r3) {
        this.A01 = zy;
        this.A02 = zy2;
        this.A00 = r3;
    }

    public final void onAnimationEnd(Animation animation) {
        this.A01.A04 = false;
        C0535Le.A0K(this.A02);
        new Handler().postDelayed(new C0893Zc(this), 200);
    }

    public final void onAnimationRepeat(Animation animation) {
    }

    public final void onAnimationStart(Animation animation) {
    }
}
