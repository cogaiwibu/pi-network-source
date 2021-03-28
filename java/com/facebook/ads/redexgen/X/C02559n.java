package com.facebook.ads.redexgen.X;

import android.view.View;

/* renamed from: com.facebook.ads.redexgen.X.9n  reason: invalid class name and case insensitive filesystem */
public final class C02559n extends C0532Lb {
    public C02559n(C0820Wh wh) {
        super(wh);
    }

    public final void onMeasure(int newHeightSpec, int i) {
        if (View.MeasureSpec.getMode(newHeightSpec) == 1073741824) {
            i = newHeightSpec;
        } else if (View.MeasureSpec.getMode(i) == 1073741824) {
            newHeightSpec = i;
        }
        super.onMeasure(newHeightSpec, i);
    }
}
