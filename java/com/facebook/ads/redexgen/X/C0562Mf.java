package com.facebook.ads.redexgen.X;

import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

/* renamed from: com.facebook.ads.redexgen.X.Mf  reason: case insensitive filesystem */
public final class C0562Mf extends RelativeLayout {
    public static final int A05 = ((int) (C0535Le.A01 * 16.0f));
    public static final int A06 = (A08 - A07);
    public static final int A07 = ((int) (C0535Le.A01 * 10.0f));
    public static final int A08 = ((int) (C0535Le.A01 * 16.0f));
    public static final int A09 = ((int) (C0535Le.A01 * 8.0f));
    public static final int A0A = ((int) (C0535Le.A01 * 25.0f));
    public static final int A0B = ((int) (C0535Le.A01 * 15.0f));
    public static final int A0C = ((int) (C0535Le.A01 * 44.0f));
    public static final int A0D = ((int) (C0535Le.A01 * 75.0f));
    public static final int A0E = ((int) (C0535Le.A01 * 45.0f));
    public final int A00;
    public final int A01;
    public final C0820Wh A02;
    public final AbstractC0565Mi A03;
    public final boolean A04;

    public C0562Mf(C0561Me me) {
        super(C0561Me.A01(me));
        int i;
        int i2;
        this.A02 = C0561Me.A01(me);
        this.A03 = C0561Me.A03(me);
        if (C0561Me.A09(me)) {
            i = A0D;
        } else {
            i = A0E;
        }
        this.A01 = i;
        if (C0561Me.A09(me)) {
            i2 = A0A;
        } else {
            i2 = A0B;
        }
        this.A00 = i2;
        this.A04 = C0561Me.A0A(me);
        setClickable(true);
        View A012 = A01(me);
        View A002 = A00(me);
        View footerView = getFooterView();
        C0535Le.A0N(A012);
        C0535Le.A0N(A002);
        C0535Le.A0N(footerView);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(10);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams2.addRule(13);
        layoutParams2.addRule(3, A012.getId());
        layoutParams2.addRule(2, footerView.getId());
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams3.addRule(12);
        int i3 = A08;
        int i4 = 0;
        layoutParams3.setMargins(i3, 0, i3, i3);
        addView(A012, layoutParams);
        addView(A002, layoutParams2);
        addView(footerView, layoutParams3);
        footerView.setVisibility(!C0561Me.A0B(me) ? 8 : i4);
    }

    public /* synthetic */ C0562Mf(C0561Me me, View$OnClickListenerC0559Mc mc) {
        this(me);
    }

    /* JADX INFO: Multiple debug info for r0v24 android.widget.LinearLayout$LayoutParams: [D('selectedOptionParams' android.widget.LinearLayout$LayoutParams), D('selectedOptionView' com.facebook.ads.redexgen.X.Mk)] */
    private View A00(C0561Me me) {
        ImageView imageView = new ImageView(getContext());
        int i = this.A00;
        imageView.setPadding(i, i, i, i);
        imageView.setImageBitmap(C0544Ln.A00(C0561Me.A02(me)));
        imageView.setColorFilter(-1);
        int i2 = this.A01;
        LinearLayout.LayoutParams titleParams = new LinearLayout.LayoutParams(i2, i2);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(1);
        gradientDrawable.setColor(C0561Me.A00(me));
        C0535Le.A0W(imageView, gradientDrawable);
        titleParams.gravity = 17;
        int i3 = A08;
        titleParams.setMargins(i3, 0, i3, i3);
        TextView textView = new TextView(getContext());
        C0535Le.A0b(textView, true, 20);
        textView.setTextColor(-14934495);
        textView.setText(C0561Me.A04(me));
        textView.setGravity(17);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        int i4 = A08;
        layoutParams.setMargins(i4, 0, i4, i4);
        TextView textView2 = new TextView(getContext());
        C0535Le.A0b(textView2, false, 16);
        textView2.setTextColor(-10459280);
        textView2.setText(C0561Me.A05(me));
        textView2.setGravity(17);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
        int i5 = A08;
        layoutParams2.setMargins(i5, 0, i5, i5);
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setOrientation(1);
        linearLayout.setGravity(17);
        linearLayout.addView(imageView, titleParams);
        linearLayout.addView(textView, layoutParams);
        linearLayout.addView(textView2, layoutParams2);
        if (C0561Me.A08(me)) {
            LinearLayout linearLayout2 = new LinearLayout(getContext());
            linearLayout2.setOrientation(0);
            linearLayout2.setGravity(17);
            if (!TextUtils.isEmpty(C0561Me.A06(me))) {
                C0587Nf nf = new C0587Nf(this.A02);
                int i6 = A0E;
                LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(i6, i6);
                layoutParams3.setMargins(0, 0, A09, 0);
                nf.setFullCircleCorners(true);
                AsyncTaskC0831Ws ws = new AsyncTaskC0831Ws(nf, this.A02);
                int i7 = A0E;
                ws.A06(i7, i7).A08(C0561Me.A06(me));
                linearLayout2.addView(nf, layoutParams3);
            }
            C0567Mk mk = new C0567Mk(this.A02);
            mk.setData(C0561Me.A07(me), EnumC0543Lm.CHECKMARK);
            mk.setSelected(true);
            linearLayout2.addView(mk, new LinearLayout.LayoutParams(-2, -2));
            linearLayout.addView(linearLayout2);
        }
        return linearLayout;
    }

    private View A01(C0561Me me) {
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setOrientation(0);
        if (C0561Me.A0C(me)) {
            ImageView imageView = new ImageView(getContext());
            int i = A07;
            imageView.setPadding(i, i, i, i);
            imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
            imageView.setImageBitmap(C0544Ln.A00(EnumC0543Lm.CROSS));
            imageView.setOnClickListener(new View$OnClickListenerC0559Mc(this));
            int i2 = A0C;
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i2, i2);
            int i3 = A06;
            layoutParams.setMargins(i3, i3, i3, i3);
            linearLayout.addView(imageView, layoutParams);
        }
        return linearLayout;
    }

    private View getFooterView() {
        ImageView imageView = new ImageView(getContext());
        imageView.setImageBitmap(C0544Ln.A00(EnumC0543Lm.SETTINGS));
        imageView.setColorFilter(-13272859);
        int i = A05;
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i, i);
        layoutParams.gravity = 17;
        TextView textView = new TextView(getContext());
        C0535Le.A0b(textView, false, 16);
        textView.setTextColor(-13272859);
        int i2 = A09;
        textView.setPadding(i2, i2, i2, i2);
        textView.setText(AnonymousClass23.A0D(this.A02.A00()));
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 17;
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setOrientation(0);
        linearLayout.setGravity(17);
        linearLayout.setOnClickListener(new View$OnClickListenerC0560Md(this));
        linearLayout.addView(imageView, layoutParams);
        linearLayout.addView(textView, layoutParams2);
        return linearLayout;
    }
}
