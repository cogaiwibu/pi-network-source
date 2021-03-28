package com.facebook.ads.redexgen.X;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import com.facebook.ads.NativeAd;
import com.facebook.ads.NativeAdLayout;
import com.facebook.ads.NativeAdView;
import com.facebook.ads.NativeAdViewAttributes;
import com.facebook.ads.internal.api.NativeAdViewApi;

/* renamed from: com.facebook.ads.redexgen.X.5F  reason: invalid class name */
public final class AnonymousClass5F implements NativeAdViewApi {
    public static String[] A00;

    static {
        A02();
    }

    public static void A02() {
        A00 = new String[]{"4lhDSJeQx8ImoxNIMYyIsOpW4XJuQDgf", "lqCKp7vrLkXGNxXrvc6I3m7c", "zCZ5ygsfQGVhB3Y237HbJ1q9o76yX", "bq9vw23WcXUY1kk1BWsR1Wz1yPOY5uBm", "", "Hv6Nwq3QZSzEF0Nb8JqXMZqCHWYzLqUn", "tYYpfGiIizklMQ8", "46C5bVFnHWUcfGRcMiONp8ja9wt0MV54"};
    }

    public static View A00(C0820Wh wh, NativeAd nativeAd, NativeAdView.Type type, @Nullable NativeAdViewAttributes nativeAdViewAttributes) {
        if (nativeAdViewAttributes == null) {
            nativeAdViewAttributes = new NativeAdViewAttributes();
        }
        C0485Jb jb = (C0485Jb) nativeAdViewAttributes.getInternalAttributes();
        C1007bZ A0J = C1007bZ.A0J(nativeAd.getInternalNativeAd());
        A0J.A1P(EnumC0486Jc.A00(type.getEnumCode()));
        A0J.A1O(jb);
        C0335Cz cz = new C0335Cz();
        NativeAdLayout nativeAdLayout = new NativeAdLayout(wh, cz);
        cz.A05(nativeAdLayout, wh, nativeAd, jb);
        nativeAdLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, (int) (C0535Le.A01 * ((float) type.getHeight()))));
        return nativeAdLayout;
    }

    public static View A01(C0820Wh wh, NativeAd nativeAd, @Nullable NativeAdViewAttributes nativeAdViewAttributes) {
        if (nativeAdViewAttributes == null) {
            nativeAdViewAttributes = new NativeAdViewAttributes();
        }
        C1007bZ A0J = C1007bZ.A0J(nativeAd.getInternalNativeAd());
        C0485Jb jb = (C0485Jb) nativeAdViewAttributes.getInternalAttributes();
        A0J.A1P(EnumC0486Jc.A0B);
        A0J.A1O(jb);
        C0335Cz cz = new C0335Cz();
        NativeAdLayout nativeAdLayout = new NativeAdLayout(wh, cz);
        cz.A05(nativeAdLayout, wh, nativeAd, jb);
        return nativeAdLayout;
    }

    @Override // com.facebook.ads.internal.api.NativeAdViewApi
    public final View render(Context context, NativeAd nativeAd) {
        return render(context, nativeAd, (NativeAdViewAttributes) null);
    }

    @Override // com.facebook.ads.internal.api.NativeAdViewApi
    public final View render(Context context, NativeAd nativeAd, NativeAdView.Type type) {
        return render(context, nativeAd, type, null);
    }

    @Override // com.facebook.ads.internal.api.NativeAdViewApi
    @SuppressLint({"CatchGeneralException"})
    public final View render(Context context, NativeAd nativeAd, NativeAdView.Type type, @Nullable NativeAdViewAttributes nativeAdViewAttributes) {
        try {
            return A00(AnonymousClass57.A02(context), nativeAd, type, nativeAdViewAttributes);
        } catch (Throwable th) {
            C0820Wh A02 = AnonymousClass57.A02(context);
            if (A00[1].length() != 17) {
                String[] strArr = A00;
                strArr[0] = "2CJ6YuIajjVObDWBrmgwGQhi0qiA6kO3";
                strArr[3] = "BzZMljeHsN6l5z4UR6G3olqVRWzg5ScF";
                return MG.A00(A02, th);
            }
            throw new RuntimeException();
        }
    }

    @Override // com.facebook.ads.internal.api.NativeAdViewApi
    @SuppressLint({"CatchGeneralException"})
    public final View render(Context context, NativeAd nativeAd, @Nullable NativeAdViewAttributes nativeAdViewAttributes) {
        try {
            return A01(AnonymousClass57.A02(context), nativeAd, nativeAdViewAttributes);
        } catch (Throwable th) {
            return MG.A00(AnonymousClass57.A02(context), th);
        }
    }
}
