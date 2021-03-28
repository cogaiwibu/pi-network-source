package com.facebook.ads.redexgen.X;

import android.util.AttributeSet;
import android.widget.RelativeLayout;
import androidx.annotation.Nullable;

public abstract class K6 extends RelativeLayout implements AbstractC0627Ot {
    @Nullable
    public C0532Lb A00;

    public K6(C0820Wh wh) {
        super(wh);
    }

    public K6(C0820Wh wh, AttributeSet attributeSet, int i) {
        super(wh, attributeSet, i);
        setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
    }

    public void A07() {
    }

    public void A08() {
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC0627Ot
    public final void A7s(C0532Lb lb) {
        this.A00 = lb;
        A07();
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC0627Ot
    public final void ADa(C0532Lb lb) {
        A08();
        this.A00 = null;
    }

    @Nullable
    public C0532Lb getVideoView() {
        return this.A00;
    }
}
