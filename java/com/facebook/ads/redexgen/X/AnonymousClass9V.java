package com.facebook.ads.redexgen.X;

import android.widget.RelativeLayout;

/* renamed from: com.facebook.ads.redexgen.X.9V  reason: invalid class name */
public final class AnonymousClass9V extends AbstractC0670Qk {
    public static final int A00 = ((int) (C0535Le.A01 * 12.0f));

    public AnonymousClass9V(C0600Ns ns, String str, C0630Ow ow) {
        super(ns, true, str, ow);
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC0596No, com.facebook.ads.redexgen.X.AbstractC0670Qk
    public final boolean A0M() {
        return false;
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC0596No
    public final boolean A0N() {
        return false;
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC0670Qk
    public final void A0h(C0820Wh wh) {
        C0593Nl titleDescContainer = getTitleDescContainer();
        titleDescContainer.setAlignment(3);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(8, getMediaContainer().getId());
        titleDescContainer.setLayoutParams(layoutParams);
        int i = A00;
        titleDescContainer.setPadding(i, i, i, i);
        C0535Le.A0V(titleDescContainer, getAdContextWrapper());
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams2.addRule(3, getMediaContainer().getId());
        getCtaButton().setLayoutParams(layoutParams2);
        addView(getMediaContainer());
        addView(titleDescContainer);
        addView(getCtaButton());
    }
}
