package com.facebook.ads.redexgen.X;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import androidx.annotation.Nullable;
import com.facebook.ads.MediaView;
import com.facebook.ads.internal.api.NativeAdBaseApi;
import com.facebook.ads.internal.api.NativeBannerAdApi;
import com.facebook.ads.internal.protocol.AdErrorType;
import java.util.Arrays;
import java.util.List;

/* renamed from: com.facebook.ads.redexgen.X.5L  reason: invalid class name */
public final class AnonymousClass5L implements NativeBannerAdApi {
    public static byte[] A01;
    public static String[] A02;
    public final C1007bZ A00;

    static {
        A02();
        A01();
    }

    public static String A00(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A01, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] ^ i3) ^ 40);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A01 = new byte[]{43, 47, 44, 24, 9, 4, 8, 3, 14, 8, 35, 8, 25, 26, 2, 31, 6};
        String[] strArr = A02;
        if (strArr[3].length() != strArr[4].length()) {
            String[] strArr2 = A02;
            strArr2[1] = "g9VMJ7KVDiHxjzY4mov6XPU8OVFxG";
            strArr2[1] = "g9VMJ7KVDiHxjzY4mov6XPU8OVFxG";
            return;
        }
        throw new RuntimeException();
    }

    public static void A02() {
        A02 = new String[]{"GHtEJsCBxF6ZG8G1CCL5RBmKmDCxDlHG", "8TFtHG5", "ovYsObbmHQ4MgJZYSDt7UbSE4I8Jd3xL", "OStrwIklzSQSoVp6y3SnTe0L", "CizBuXx6tKQSK5P8xVf5ORSYZ1", "CxGaKpsxgS6bhWDX5B71lG4aeRzyf4w9", "ZUquOnXGk9BCY4cqa0yz5KxW6oH5Pvvn", "wvrH4lpYI8UyLhNBrrW8XGK9bs66R2Pk"};
    }

    public AnonymousClass5L(NativeAdBaseApi nativeAdBaseApi) {
        this.A00 = C1007bZ.A0J(nativeAdBaseApi);
        this.A00.A1Q(EnumC0500Js.A05);
    }

    /* JADX INFO: Multiple debug info for r7v0 com.facebook.ads.redexgen.X.bZ: [D('preloadedBitmap' android.graphics.Bitmap), D('adListener' com.facebook.ads.redexgen.X.ba)] */
    private void A03(ImageView imageView, NativeAdBaseApi nativeAdBaseApi) {
        C1007bZ A0J = C1007bZ.A0J(nativeAdBaseApi);
        TB tb = new TB(this, imageView, A0J);
        JZ A10 = A0J.getAdIcon();
        if (A10 != null) {
            Bitmap A0I = A0J.A0w().A0I(A10.getUrl());
            C0820Wh A022 = AnonymousClass57.A02(imageView.getContext());
            if (A0I != null) {
                Drawable A05 = C1007bZ.A05(A022, A0I, A0J.A1V(), A0J.A16());
                C1007bZ.A0Z(A05, imageView);
                imageView.post(new TC(this, A0J, A05));
                return;
            }
            new AnonymousClass5I(A022, tb, A0J.A1V(), null).execute(new AnonymousClass5K(A10.getUrl(), A0J.A16(), null));
            return;
        }
        AbstractC1008ba A11 = A0J.A11();
        AdErrorType adErrorType = AdErrorType.NATIVE_AD_IS_NOT_LOADED;
        A0J.A0x().A0A().A2d(-1, adErrorType.getErrorCode(), adErrorType.getDefaultErrorMessage());
        if (A11 != null) {
            A11.A9X(C0495Jm.A01(adErrorType));
        }
        Log.e(A00(0, 17, 69), adErrorType.getDefaultErrorMessage());
    }

    @Override // com.facebook.ads.internal.api.NativeBannerAdApi
    public final void registerViewForInteraction(View view, ImageView imageView) {
        registerViewForInteraction(view, imageView, (List<View>) null);
    }

    @Override // com.facebook.ads.internal.api.NativeBannerAdApi
    public final void registerViewForInteraction(View view, ImageView imageView, @Nullable List<View> list) {
        if (imageView != null) {
            A03(imageView, this.A00);
        }
        if (list != null) {
            this.A00.A1G(view, imageView, list);
        } else {
            this.A00.A1F(view, imageView);
        }
    }

    @Override // com.facebook.ads.internal.api.NativeBannerAdApi
    public final void registerViewForInteraction(View view, MediaView mediaView) {
        registerViewForInteraction(view, mediaView, (List<View>) null);
    }

    @Override // com.facebook.ads.internal.api.NativeBannerAdApi
    public final void registerViewForInteraction(View view, MediaView mediaView, @Nullable List<View> list) {
        if (mediaView != null) {
            T3 t3 = (T3) mediaView.getMediaViewApi();
            C1007bZ bZVar = this.A00;
            String[] strArr = A02;
            if (strArr[3].length() != strArr[4].length()) {
                String[] strArr2 = A02;
                strArr2[2] = "js1TYeoyNOBe6miaJaLofzAsC6CsUfwk";
                strArr2[0] = "W1hafLFlhK2580scubVHArACmFSZlS1F";
                t3.A0J(bZVar, true);
            } else {
                throw new RuntimeException();
            }
        }
        if (list != null) {
            this.A00.A1I(view, mediaView, list);
        } else {
            this.A00.A1H(view, mediaView);
        }
    }
}
