package com.facebook.ads.redexgen.X;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import androidx.annotation.Nullable;

/* renamed from: com.facebook.ads.redexgen.X.9h  reason: invalid class name and case insensitive filesystem */
public final class C02499h extends Si {
    public static final int A02 = Resources.getSystem().getDisplayMetrics().widthPixels;
    public final View A00;
    public final boolean A01;

    public C02499h(C0600Ns ns, boolean z) {
        super(ns, true);
        this.A01 = z;
        this.A00 = ns.A02();
        A0f();
        if (this.A01) {
            addView(ns.A02(), new RelativeLayout.LayoutParams(-1, -1));
        } else {
            FrameLayout frameLayout = new FrameLayout(ns.A05());
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            layoutParams.addRule(2, getAdDetailsView().getId());
            frameLayout.setLayoutParams(layoutParams);
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -2);
            layoutParams2.gravity = 17;
            layoutParams2.setMargins(AbstractC0596No.A09, 0, AbstractC0596No.A09, 0);
            frameLayout.addView(this.A00, layoutParams2);
            addView(frameLayout);
        }
        getAdDetailsView().bringToFront();
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC0596No
    public final boolean A0M() {
        return this.A01 && super.A0P();
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC0596No
    public final boolean A0P() {
        return this.A01 && super.A0P();
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC0596No, com.facebook.ads.redexgen.X.Si
    public final void A0b(AnonymousClass19 r5, String str, double d, @Nullable Bundle bundle) {
        super.A0b(r5, str, d, bundle);
        if (!this.A01 && d > 0.0d) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, (int) (((double) (A02 - (AbstractC0596No.A09 * 2))) / d));
            layoutParams.gravity = 17;
            layoutParams.setMargins(AbstractC0596No.A09, 0, AbstractC0596No.A09, 0);
            this.A00.setLayoutParams(layoutParams);
        }
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC0596No
    public final boolean A0c() {
        return this.A01;
    }
}
