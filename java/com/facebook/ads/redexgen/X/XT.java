package com.facebook.ads.redexgen.X;

import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;

public final class XT extends AbstractC0563Mg {
    public static final int A04 = ((int) (C0535Le.A01 * 44.0f));
    public static final int A05 = ((int) (C0535Le.A01 * 10.0f));
    public static final int A06 = ((int) (C0535Le.A01 * 8.0f));
    public final ImageView A00 = new ImageView(getContext());
    public final LinearLayout A01;
    public final ScrollView A02;
    public final C0820Wh A03;

    public XT(C0820Wh wh, JE je, String str) {
        super(wh, je, str);
        this.A03 = wh;
        ImageView imageView = this.A00;
        int i = A05;
        imageView.setPadding(i, i, i, i);
        this.A00.setColorFilter(-10459280);
        int i2 = A04;
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i2, i2);
        layoutParams.gravity = 3;
        this.A00.setLayoutParams(layoutParams);
        this.A02 = new ScrollView(getContext());
        this.A02.setFillViewport(true);
        C0535Le.A0P(this.A02, -218103809);
        this.A01 = new LinearLayout(getContext());
        this.A01.setOrientation(1);
        LinearLayout linearLayout = this.A01;
        int i3 = A06;
        linearLayout.setPadding(i3, i3, i3, i3);
        this.A02.addView(this.A01, new FrameLayout.LayoutParams(-1, -2));
        addView(this.A02, new FrameLayout.LayoutParams(-1, -1));
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC0563Mg
    public final void A0K() {
        this.A00.setImageBitmap(C0544Ln.A00(EnumC0543Lm.CROSS));
        this.A00.setOnClickListener(new View$OnClickListenerC0581Mz(this));
        C0567Mk mk = new C0567Mk(this.A03);
        mk.setData(AnonymousClass23.A0B(this.A03.A00()), EnumC0543Lm.HIDE_AD);
        mk.setOnClickListener(new N0(this, mk));
        C0567Mk mk2 = new C0567Mk(this.A03);
        mk2.setData(AnonymousClass23.A0F(this.A03.A00()), EnumC0543Lm.REPORT_AD);
        mk2.setOnClickListener(new N1(this, mk2));
        C0567Mk mk3 = new C0567Mk(this.A03);
        mk3.setData(AnonymousClass23.A0G(this.A03.A00()), EnumC0543Lm.AD_CHOICES_ICON);
        mk3.setOnClickListener(new N2(this, mk3));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        int i = A06;
        layoutParams.setMargins(i, i, i, i);
        layoutParams.gravity = 17;
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setOrientation(1);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, 0);
        layoutParams2.gravity = 17;
        layoutParams2.weight = 1.0f;
        C0535Le.A0X(this.A01);
        this.A01.removeAllViews();
        this.A01.addView(this.A00);
        this.A01.addView(linearLayout, layoutParams2);
        linearLayout.addView(mk, layoutParams);
        linearLayout.addView(mk2, layoutParams);
        linearLayout.addView(mk3, layoutParams);
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC0563Mg
    public final void A0L() {
        C0535Le.A0L(this);
        C0535Le.A0M(this);
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC0563Mg
    public final void A0M(AnonymousClass26 r7, AnonymousClass24 r8) {
        String A0B;
        EnumC0543Lm lm;
        int i;
        this.A00.setOnClickListener(null);
        if (r8 == AnonymousClass24.A05) {
            A0B = AnonymousClass23.A09(this.A03.A00());
            lm = EnumC0543Lm.REPORT_AD;
            i = -552389;
        } else {
            A0B = AnonymousClass23.A0B(this.A03.A00());
            lm = EnumC0543Lm.HIDE_AD;
            i = -13272859;
        }
        C0562Mf A0M = new C0561Me(this.A03, this.A0A).A0I(A0B).A0H(AnonymousClass23.A07(this.A03.A00())).A0F(r7.A04()).A0K(false).A0E(lm).A0D(i).A0L(false).A0J(false).A0M();
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, 0);
        layoutParams.gravity = 17;
        layoutParams.weight = 1.0f;
        C0535Le.A0X(this.A01);
        this.A02.fullScroll(33);
        this.A01.removeAllViews();
        this.A01.addView(A0M, layoutParams);
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC0563Mg
    public final void A0N(AnonymousClass26 r6, AnonymousClass24 r7) {
        boolean z;
        EnumC0543Lm lm;
        if (r7 == AnonymousClass24.A05) {
            z = true;
        } else {
            z = false;
        }
        C0820Wh wh = this.A03;
        AbstractC0565Mi mi = this.A0A;
        if (z) {
            lm = EnumC0543Lm.REPORT_AD;
        } else {
            lm = EnumC0543Lm.HIDE_AD;
        }
        C0580My my = new C0580My(wh, r6, mi, lm);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, 0);
        layoutParams.gravity = 17;
        layoutParams.weight = 1.0f;
        this.A00.setImageBitmap(C0544Ln.A00(EnumC0543Lm.BACK_ARROW));
        this.A00.setOnClickListener(new N3(this));
        C0535Le.A0X(this.A01);
        this.A02.fullScroll(33);
        this.A01.removeAllViews();
        this.A01.addView(this.A00);
        this.A01.addView(my, layoutParams);
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC0563Mg
    public final boolean A0O() {
        return true;
    }
}
