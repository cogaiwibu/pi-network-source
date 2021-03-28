package com.facebook.ads.redexgen.X;

import android.widget.FrameLayout;
import com.facebook.ads.AdOptionsView;
import com.facebook.ads.MediaView;
import com.facebook.ads.NativeAd;
import com.facebook.ads.NativeAdLayout;

/* renamed from: com.facebook.ads.redexgen.X.Cz  reason: case insensitive filesystem */
public final class C0335Cz extends T4 {
    public AbstractC0616Oi A00;

    /* JADX INFO: Multiple debug info for r10v0 com.facebook.ads.AdOptionsView: [D('adOptionsView' com.facebook.ads.AdOptionsView), D('mediaView' com.facebook.ads.MediaView)] */
    public final void A05(NativeAdLayout nativeAdLayout, C0820Wh wh, NativeAd nativeAd, C0485Jb jb) {
        C0587Nf nf = new C0587Nf(wh);
        MediaView mediaView = new MediaView(wh);
        AdOptionsView adOptionsView = new AdOptionsView(wh, nativeAd, nativeAdLayout);
        jb.A09(adOptionsView, 28);
        this.A00 = new MP(wh, nativeAd, jb, C1007bZ.A0J(nativeAd.getInternalNativeAd()).A13(), nf, mediaView, adOptionsView);
        C0535Le.A0P(nativeAdLayout, jb.A00());
        nativeAd.registerViewForInteraction(nativeAdLayout, mediaView, nf, this.A00.getViewsForInteraction());
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
