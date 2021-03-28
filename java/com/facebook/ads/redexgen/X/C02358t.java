package com.facebook.ads.redexgen.X;

import android.graphics.drawable.ColorDrawable;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

/* renamed from: com.facebook.ads.redexgen.X.8t  reason: invalid class name and case insensitive filesystem */
public final class C02358t extends AbstractC0670Qk {
    public static final int A00 = ((int) (C0535Le.A01 * 20.0f));
    public static final int A01 = ((int) (C0535Le.A01 * 16.0f));

    public C02358t(C0600Ns ns, String str, C0630Ow ow) {
        super(ns, false, str, ow);
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC0596No
    public final boolean A0O() {
        return false;
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC0670Qk
    public final void A0h(C0820Wh wh) {
        C0593Nl titleDescContainer = getTitleDescContainer();
        titleDescContainer.setAlignment(3);
        titleDescContainer.setLayoutParams(new RelativeLayout.LayoutParams(-1, -2));
        titleDescContainer.setPadding(0, 0, 0, A00);
        getCtaButton().setLayoutParams(new RelativeLayout.LayoutParams(-1, -2));
        LinearLayout linearLayout = new LinearLayout(wh);
        C0535Le.A0W(linearLayout, new ColorDrawable(-1));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(3, getMediaContainer().getId());
        linearLayout.setLayoutParams(layoutParams);
        linearLayout.setOrientation(1);
        int i = A01;
        linearLayout.setPadding(i, i, i, i);
        linearLayout.addView(titleDescContainer);
        linearLayout.addView(getCtaButton());
        addView(getMediaContainer());
        addView(linearLayout);
    }
}
