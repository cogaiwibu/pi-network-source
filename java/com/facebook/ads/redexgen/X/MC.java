package com.facebook.ads.redexgen.X;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.facebook.ads.internal.api.AdNativeComponentView;

public final class MC extends AdNativeComponentView {
    public static final int A01 = ((int) (C0535Le.A01 * 1.0f));
    public final ImageView A00;

    public MC(C0820Wh wh) {
        super(wh);
        this.A00 = new MR(wh);
        this.A00.setScaleType(ImageView.ScaleType.CENTER_CROP);
        LC.A04(this.A00, LC.A0A);
        addView(this.A00, new ViewGroup.LayoutParams(-1, -1));
        C0535Le.A0P(this.A00, -2130706433);
        int i = A01;
        setPadding(i, i, i, i);
    }

    @Override // com.facebook.ads.internal.api.AdNativeComponentView
    public View getAdContentsView() {
        return this.A00;
    }

    public ImageView getImageCardView() {
        return this.A00;
    }
}
