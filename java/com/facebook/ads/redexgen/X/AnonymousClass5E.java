package com.facebook.ads.redexgen.X;

import android.content.Context;
import androidx.annotation.Nullable;
import com.facebook.ads.NativeAdScrollView;
import com.facebook.ads.NativeAdView;
import com.facebook.ads.NativeAdViewAttributes;
import com.facebook.ads.NativeAdsManager;
import com.facebook.ads.internal.api.NativeAdScrollViewApi;
import java.util.Arrays;

/* renamed from: com.facebook.ads.redexgen.X.5E  reason: invalid class name */
public final class AnonymousClass5E implements NativeAdScrollViewApi {
    public static byte[] A07;
    public final int A00;
    @Nullable
    public final NativeAdScrollView.AdViewProvider A01;
    @Nullable
    public final NativeAdView.Type A02;
    public final NativeAdViewAttributes A03;
    public final NativeAdsManager A04;
    public final T6 A05;
    public final C0820Wh A06;

    static {
        A07();
    }

    public static String A06(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A07, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] - i3) - 33);
        }
        return new String(copyOfRange);
    }

    public static void A07() {
        A07 = new byte[]{-61, -21, -23, -22, -106, -26, -24, -27, -20, -33, -38, -37, -106, -41, -106, -60, -41, -22, -33, -20, -37, -73, -38, -52, -33, -37, -19, -92, -54, -17, -26, -37, -94, -106, -73, -38, -52, -33, -37, -19, -58, -24, -27, -20, -33, -38, -37, -24, -106, -27, -24, -106, -41, -106, -28, -41, -22, -33, -20, -37, -73, -38, -52, -33, -37, -19, -66, -37, -33, -35, -34, -22, -70, -26, -106, -87, -68, -79, -66, -83, -119, -84, -69, -107, -87, -74, -87, -81, -83, -70, 104, -74, -73, -68, 104, -76, -73, -87, -84, -83, -84};
    }

    public AnonymousClass5E(NativeAdScrollView nativeAdScrollView, Context context, NativeAdsManager nativeAdsManager, @Nullable NativeAdScrollView.AdViewProvider adViewProvider, int i, @Nullable NativeAdView.Type type, NativeAdViewAttributes nativeAdViewAttributes, int i2) {
        if (!nativeAdsManager.isLoaded()) {
            throw new IllegalStateException(A06(74, 27, 39));
        } else if (type == null && adViewProvider == null && i <= 0) {
            throw new IllegalArgumentException(A06(0, 74, 85));
        } else {
            this.A06 = AnonymousClass57.A02(context);
            this.A04 = nativeAdsManager;
            this.A03 = nativeAdViewAttributes;
            this.A01 = adViewProvider;
            this.A02 = type;
            this.A00 = i2;
            T5 t5 = new T5(this);
            this.A05 = new T6(context);
            if (this.A02 != null) {
                T6.A02(this.A05, (int) (C0535Le.A01 * ((float) this.A02.getHeight())));
            } else if (i > 0) {
                T6.A02(this.A05, ((int) C0535Le.A01) * i);
            }
            this.A05.setAdapter(t5);
            setInset(20);
            t5.A0D();
            nativeAdScrollView.addView(this.A05);
        }
    }

    @Override // com.facebook.ads.internal.api.NativeAdScrollViewApi
    public final void setInset(int insetDp) {
        if (insetDp > 0) {
            float f = C0535Le.A01;
            int round = Math.round(((float) insetDp) * f);
            this.A05.setPadding(round, 0, round, 0);
            this.A05.setPageMargin(Math.round(((float) (insetDp / 2)) * f));
            this.A05.setClipToPadding(false);
        }
    }
}
