package com.facebook.ads.redexgen.X;

import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.facebook.ads.AdOptionsView;
import com.facebook.ads.NativeBannerAd;

/* renamed from: com.facebook.ads.redexgen.X.Of  reason: case insensitive filesystem */
public final class C0613Of extends LinearLayout {
    public C0613Of(C0820Wh wh, NativeBannerAd nativeBannerAd, EnumC0486Jc jc, C0485Jb jb, AdOptionsView adOptionsView) {
        super(wh);
        int i;
        TextView textView = new TextView(getContext());
        jb.A08(textView);
        textView.setText(nativeBannerAd.getAdvertiserName());
        textView.setEllipsize(TextUtils.TruncateAt.END);
        textView.setMaxLines(1);
        TextView textView2 = new TextView(getContext());
        jb.A06(textView2);
        textView2.setText(nativeBannerAd.getAdUntrimmedBodyText());
        if (jc == EnumC0486Jc.A07) {
            i = 2;
        } else {
            i = 1;
        }
        textView2.setLines(i);
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setOrientation(0);
        linearLayout.setGravity(16);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2);
        layoutParams.weight = 1.0f;
        linearLayout.addView(textView, layoutParams);
        linearLayout.addView(adOptionsView, new LinearLayout.LayoutParams(-2, -2));
        setOrientation(1);
        ViewGroup.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
        addView(linearLayout, layoutParams2);
        addView(textView2, layoutParams2);
    }
}
