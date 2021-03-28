package com.facebook.ads.redexgen.X;

import android.widget.FrameLayout;
import com.facebook.ads.AdOptionsView;
import com.facebook.ads.MediaView;
import com.facebook.ads.NativeAdLayout;
import com.facebook.ads.NativeBannerAd;

/* renamed from: com.facebook.ads.redexgen.X.Dm  reason: case insensitive filesystem */
public final class C0348Dm extends T4 {
    public AbstractC0616Oi A00;

    /* JADX INFO: Multiple debug info for r9v0 com.facebook.ads.AdOptionsView: [D('adOptionsView' com.facebook.ads.AdOptionsView), D('internalNativeAd' com.facebook.ads.redexgen.X.bZ)] */
    public final void A05(C0820Wh wh, NativeBannerAd nativeBannerAd, C0485Jb jb, NativeAdLayout nativeAdLayout) {
        MediaView adIconView = new MediaView(nativeAdLayout.getContext());
        AdOptionsView adOptionsView = new AdOptionsView(nativeAdLayout.getContext(), nativeBannerAd, nativeAdLayout);
        jb.A09(adOptionsView, 20);
        this.A00 = new MX(wh, nativeBannerAd, jb, C1007bZ.A0J(nativeBannerAd.getInternalNativeAd()).A13(), adIconView, adOptionsView);
        C0535Le.A0P(nativeAdLayout, jb.A00());
        nativeBannerAd.registerViewForInteraction(nativeAdLayout, adIconView, this.A00.getViewsForInteraction());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        nativeAdLayout.addView(this.A00.getView(), layoutParams);
    }

    @Override // com.facebook.ads.redexgen.X.AnonymousClass56, com.facebook.ads.internal.api.AdComponentViewParentApi
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.A00.unregisterView();
    }
}
