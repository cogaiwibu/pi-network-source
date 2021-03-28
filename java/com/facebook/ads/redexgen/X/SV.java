package com.facebook.ads.redexgen.X;

import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.annotation.Nullable;

public final class SV extends AbstractC0596No {
    public SV(C0600Ns ns, boolean z) {
        super(ns, true);
        int i;
        int i2;
        int i3;
        int i4;
        RelativeLayout relativeLayout = new RelativeLayout(ns.A05());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(12);
        C0535Le.A0V(relativeLayout, getAdContextWrapper());
        LinearLayout linearLayout = new LinearLayout(ns.A05());
        linearLayout.setOrientation(!z ? 1 : 0);
        linearLayout.setGravity(80);
        C0535Le.A0N(linearLayout);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams2.setMargins(AbstractC0596No.A09, 0, AbstractC0596No.A09, AbstractC0596No.A09);
        if (z) {
            i = -2;
        } else {
            i = -1;
        }
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(i, -2);
        if (z) {
            i2 = AbstractC0596No.A09;
        } else {
            i2 = 0;
        }
        if (z) {
            i3 = 0;
        } else {
            i3 = AbstractC0596No.A09;
        }
        layoutParams3.setMargins(i2, i3, 0, 0);
        if (z) {
            i4 = 0;
        } else {
            i4 = -1;
        }
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(i4, -2);
        layoutParams4.setMargins(0, 0, 0, 0);
        layoutParams4.weight = 1.0f;
        linearLayout.addView(getTitleDescContainer(), layoutParams4);
        linearLayout.addView(getCtaButton(), layoutParams3);
        relativeLayout.addView(linearLayout, layoutParams2);
        addView(ns.A02(), new RelativeLayout.LayoutParams(-1, -1));
        addView(relativeLayout, layoutParams);
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC0596No
    public final void A0b(AnonymousClass19 r1, String str, double d, @Nullable Bundle bundle) {
        super.A0b(r1, str, d, bundle);
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC0596No
    public final boolean A0c() {
        return true;
    }
}
