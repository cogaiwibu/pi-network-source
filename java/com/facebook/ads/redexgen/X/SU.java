package com.facebook.ads.redexgen.X;

import android.content.res.Resources;
import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import androidx.annotation.Nullable;

public final class SU extends AbstractC0596No {
    public static final int A01 = Resources.getSystem().getDisplayMetrics().widthPixels;
    public final C0607Nz A00;

    public SU(C0600Ns ns, boolean z) {
        super(ns, z);
        this.A00 = new C0607Nz(ns.A05(), ns.A02());
        this.A00.A01(getTitleDescContainer(), z);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(12);
        layoutParams.setMargins(AbstractC0596No.A09, AbstractC0596No.A09, AbstractC0596No.A09, AbstractC0596No.A09);
        getCtaButton().setLayoutParams(layoutParams);
        FrameLayout frameLayout = new FrameLayout(ns.A05());
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams2.addRule(2, getCtaButton().getId());
        frameLayout.setLayoutParams(layoutParams2);
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-1, -2);
        layoutParams3.gravity = 17;
        layoutParams3.setMargins(AbstractC0596No.A09, 0, AbstractC0596No.A09, 0);
        frameLayout.addView(this.A00, layoutParams3);
        addView(frameLayout);
        addView(getCtaButton());
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC0596No
    public final boolean A0M() {
        return false;
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC0596No
    public final boolean A0P() {
        return false;
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC0596No
    public final void A0b(AnonymousClass19 r5, String str, double d, @Nullable Bundle bundle) {
        super.A0b(r5, str, d, bundle);
        if (d > 0.0d) {
            this.A00.A00((int) (((double) (A01 - (AbstractC0596No.A09 * 2))) / d));
        }
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC0596No
    public final boolean A0c() {
        return false;
    }
}
