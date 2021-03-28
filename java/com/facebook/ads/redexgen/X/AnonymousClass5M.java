package com.facebook.ads.redexgen.X;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import com.facebook.ads.NativeAdLayout;
import com.facebook.ads.NativeAdViewAttributes;
import com.facebook.ads.NativeBannerAd;
import com.facebook.ads.NativeBannerAdView;
import com.facebook.ads.internal.api.NativeBannerAdViewApi;

/* renamed from: com.facebook.ads.redexgen.X.5M  reason: invalid class name */
public final class AnonymousClass5M implements NativeBannerAdViewApi {
    public static View A00(C0820Wh wh, NativeBannerAd nativeBannerAd, NativeBannerAdView.Type type, @Nullable NativeAdViewAttributes nativeAdViewAttributes) {
        if (nativeAdViewAttributes == null) {
            nativeAdViewAttributes = new NativeAdViewAttributes();
        }
        C1007bZ.A0J(nativeBannerAd.getInternalNativeAd()).A1P(EnumC0486Jc.A00(type.getEnumCode()));
        C0348Dm dm = new C0348Dm();
        NativeAdLayout nativeAdLayout = new NativeAdLayout(wh, dm);
        dm.A05(wh, nativeBannerAd, (C0485Jb) nativeAdViewAttributes.getInternalAttributes(), nativeAdLayout);
        nativeAdLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, (int) (C0535Le.A01 * ((float) type.getHeight()))));
        return nativeAdLayout;
    }

    @Override // com.facebook.ads.internal.api.NativeBannerAdViewApi
    public final View render(Context context, NativeBannerAd nativeBannerAd, NativeBannerAdView.Type type) {
        return render(context, nativeBannerAd, type, null);
    }

    @Override // com.facebook.ads.internal.api.NativeBannerAdViewApi
    @SuppressLint({"CatchGeneralException"})
    public final View render(Context context, NativeBannerAd nativeBannerAd, NativeBannerAdView.Type type, @Nullable NativeAdViewAttributes nativeAdViewAttributes) {
        try {
            return A00(AnonymousClass57.A02(context), nativeBannerAd, type, nativeAdViewAttributes);
        } catch (Throwable th) {
            return MG.A00(AnonymousClass57.A02(context), th);
        }
    }
}
