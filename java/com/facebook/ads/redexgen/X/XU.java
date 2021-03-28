package com.facebook.ads.redexgen.X;

import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public final class XU extends AbstractC0563Mg {
    public static final int A05 = ((int) (C0535Le.A01 * 44.0f));
    public static final int A06 = ((int) (C0535Le.A01 * 10.0f));
    public static final int A07 = ((int) (C0535Le.A01 * 4.0f));
    public final HorizontalScrollView A00;
    public final ImageView A01 = new ImageView(getContext());
    public final LinearLayout A02;
    public final LinearLayout A03;
    public final C0820Wh A04;

    public XU(C0820Wh wh, JE je, String str) {
        super(wh, je, str);
        this.A04 = wh;
        ImageView imageView = this.A01;
        int i = A06;
        imageView.setPadding(i, i, i, i);
        this.A01.setScaleType(ImageView.ScaleType.FIT_CENTER);
        this.A01.setColorFilter(-10459280);
        int i2 = A05;
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i2, i2);
        layoutParams.gravity = 16;
        this.A02 = new LinearLayout(getContext());
        this.A02.setOrientation(0);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams2.gravity = 17;
        this.A00 = new HorizontalScrollView(getContext());
        this.A00.setHorizontalScrollBarEnabled(false);
        this.A00.setLayoutParams(layoutParams2);
        this.A00.addView(this.A02, layoutParams2);
        this.A03 = new LinearLayout(getContext());
        this.A03.setOrientation(0);
        C0535Le.A0P(this.A03, -218103809);
        this.A03.setMotionEventSplittingEnabled(false);
        this.A03.addView(this.A01, layoutParams);
        this.A03.addView(this.A00, layoutParams2);
        addView(this.A03, new FrameLayout.LayoutParams(-1, -1));
        this.A03.setClickable(true);
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC0563Mg
    public final void A0K() {
        this.A01.setImageBitmap(C0544Ln.A00(EnumC0543Lm.CROSS));
        this.A01.setOnClickListener(new View$OnClickListenerC0572Mp(this));
        C0567Mk mk = new C0567Mk(this.A04);
        mk.setData(AnonymousClass23.A0B(this.A04.A00()), EnumC0543Lm.HIDE_AD);
        mk.setOnClickListener(new View$OnClickListenerC0573Mq(this, mk));
        C0567Mk mk2 = new C0567Mk(this.A04);
        mk2.setData(AnonymousClass23.A0F(this.A04.A00()), EnumC0543Lm.REPORT_AD);
        mk2.setOnClickListener(new View$OnClickListenerC0574Mr(this, mk2));
        C0567Mk mk3 = new C0567Mk(this.A04);
        mk3.setData(AnonymousClass23.A0G(this.A04.A00()), EnumC0543Lm.AD_CHOICES_ICON);
        mk3.setOnClickListener(new Ms(this, mk3));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        int i = A07;
        layoutParams.setMargins(0, i, i, i);
        C0535Le.A0X(this.A03);
        this.A02.removeAllViews();
        this.A02.addView(mk, layoutParams);
        this.A02.addView(mk2, layoutParams);
        this.A02.addView(mk3, layoutParams);
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC0563Mg
    public final void A0L() {
        C0535Le.A0L(this);
        C0535Le.A0M(this);
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC0563Mg
    public final void A0M(AnonymousClass26 r5, AnonymousClass24 r6) {
        this.A01.setOnClickListener(null);
        TextView textView = new TextView(getContext());
        C0535Le.A0b(textView, true, 14);
        textView.setText(AnonymousClass23.A07(this.A04.A00()));
        textView.setGravity(17);
        C0535Le.A0X(this.A03);
        this.A03.removeAllViews();
        this.A03.addView(textView, new LinearLayout.LayoutParams(-1, -1));
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC0563Mg
    public final void A0N(AnonymousClass26 r7, AnonymousClass24 r8) {
        C0535Le.A0X(this.A03);
        this.A01.setImageBitmap(C0544Ln.A00(EnumC0543Lm.BACK_ARROW));
        this.A01.setOnClickListener(new View$OnClickListenerC0575Mt(this));
        this.A02.removeAllViews();
        this.A00.fullScroll(17);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        int i = A07;
        layoutParams.setMargins(0, i, i, i);
        for (AnonymousClass26 r3 : r7.A05()) {
            C0567Mk mk = new C0567Mk(this.A04);
            mk.setData(r3.A04(), null);
            mk.setOnClickListener(new View$OnClickListenerC0576Mu(this, mk, r3));
            this.A02.addView(mk, layoutParams);
        }
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC0563Mg
    public final boolean A0O() {
        return true;
    }
}
