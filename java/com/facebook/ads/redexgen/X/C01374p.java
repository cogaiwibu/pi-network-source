package com.facebook.ads.redexgen.X;

import android.view.animation.Animation;
import android.view.animation.Transformation;

/* renamed from: com.facebook.ads.redexgen.X.4p  reason: invalid class name and case insensitive filesystem */
public class C01374p extends Animation {
    public final /* synthetic */ int A00;
    public final /* synthetic */ int A01;
    public final /* synthetic */ C01414t A02;

    public C01374p(C01414t r1, int i, int i2) {
        this.A02 = r1;
        this.A00 = i;
        this.A01 = i2;
    }

    public final void applyTransformation(float f, Transformation transformation) {
        int i = this.A00;
        int i2 = (int) (((float) i) + (((float) (this.A01 - i)) * f));
        this.A02.A04.getLayoutParams().width = i2;
        this.A02.A04.requestLayout();
        this.A02.A00.getLayoutParams().width = i2 - this.A00;
        this.A02.A00.requestLayout();
    }

    public final boolean willChangeBounds() {
        return true;
    }
}
