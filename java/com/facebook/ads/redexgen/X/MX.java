package com.facebook.ads.redexgen.X;

import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.facebook.ads.AdOptionsView;
import com.facebook.ads.MediaView;
import com.facebook.ads.NativeBannerAd;
import java.util.ArrayList;

public final class MX extends LinearLayout implements AbstractC0616Oi {
    public static final int A03 = ((int) (C0535Le.A01 * 48.0f));
    public static final int A04 = ((int) (C0535Le.A01 * 42.0f));
    public static final int A05 = ((int) (C0535Le.A01 * 54.0f));
    public static final int A06 = ((int) (C0535Le.A01 * 8.0f));
    public static final int A07 = ((int) (C0535Le.A01 * 4.0f));
    public final NativeBannerAd A00;
    public final C0820Wh A01;
    public final ArrayList<View> A02 = new ArrayList<>();

    public MX(C0820Wh wh, NativeBannerAd nativeBannerAd, C0485Jb jb, EnumC0486Jc jc, MediaView mediaView, AdOptionsView adOptionsView) {
        super(wh);
        LinearLayout.LayoutParams layoutParams;
        ViewGroup.LayoutParams layoutParams2;
        this.A00 = nativeBannerAd;
        this.A01 = wh;
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setOrientation(0);
        int A002 = A00(jc);
        C0588Ng ng = new C0588Ng(this.A01);
        ng.setFullCircleCorners(true);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(A002, A002);
        layoutParams3.gravity = 16;
        ng.addView(mediaView, new LinearLayout.LayoutParams(-1, -1));
        linearLayout.addView(ng, layoutParams3);
        C0613Of of = new C0613Of(wh, this.A00, jc, jb, adOptionsView);
        of.setPadding(A06, 0, 0, 0);
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(0, -2);
        layoutParams4.weight = 1.0f;
        layoutParams4.gravity = 16;
        linearLayout.addView(of, layoutParams4);
        if (jc == EnumC0486Jc.A0A) {
            int i = A07;
            setPadding(i, i, i, i);
            setOrientation(0);
            layoutParams = new LinearLayout.LayoutParams(0, -1);
            layoutParams2 = new LinearLayout.LayoutParams(-2, -1);
            linearLayout.setPadding(0, 0, A07, 0);
        } else {
            int i2 = A06;
            setPadding(i2, i2, i2, i2);
            setOrientation(1);
            layoutParams = new LinearLayout.LayoutParams(-1, 0);
            layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
            linearLayout.setPadding(0, 0, 0, A06);
        }
        layoutParams.weight = 1.0f;
        addView(linearLayout, layoutParams);
        TextView textView = new TextView(getContext());
        int iconSize = A06;
        int i3 = A07;
        textView.setPadding(iconSize, i3, iconSize, i3);
        jb.A05(textView);
        textView.setText(this.A00.getAdCallToAction());
        addView(textView, layoutParams2);
        this.A02.add(mediaView);
        this.A02.add(textView);
    }

    public static int A00(EnumC0486Jc jc) {
        int i = C0614Og.A00[jc.ordinal()];
        if (i == 1) {
            return A04;
        }
        if (i != 2) {
            return A05;
        }
        return A03;
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC0616Oi
    public View getView() {
        return this;
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC0616Oi
    public ArrayList<View> getViewsForInteraction() {
        return this.A02;
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC0616Oi
    public final void unregisterView() {
        this.A00.unregisterView();
    }
}
