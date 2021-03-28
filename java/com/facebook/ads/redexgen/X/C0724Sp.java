package com.facebook.ads.redexgen.X;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.annotation.Nullable;
import com.facebook.ads.AdOptionsView;
import com.facebook.ads.NativeAdBase;
import com.facebook.ads.NativeAdLayout;
import com.facebook.ads.internal.api.AdComponentViewApi;
import com.facebook.ads.internal.api.AdOptionsViewApi;
import java.util.Arrays;

/* renamed from: com.facebook.ads.redexgen.X.Sp  reason: case insensitive filesystem */
public final class C0724Sp extends AnonymousClass56 implements AdOptionsViewApi {
    public static byte[] A03;
    public static final int A04 = ((int) (C0535Le.A01 * 23.0f));
    public static final int A05 = ((int) (C0535Le.A01 * 4.0f));
    public final ImageView A00;
    public final ImageView A01;
    public final AdOptionsView A02;

    public static String A01(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A03, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] ^ i3) ^ 125);
        }
        return new String(copyOfRange);
    }

    public static void A02() {
        A03 = new byte[]{91, 108, 121, 102, 123, 125, 41, 72, 109};
    }

    static {
        A02();
    }

    public C0724Sp(Context context, NativeAdBase nativeAdBase, @Nullable NativeAdLayout nativeAdLayout, AdOptionsView.Orientation orientation, int i, AdOptionsView adOptionsView) {
        int i2;
        this.A02 = adOptionsView;
        LinearLayout linearLayout = new LinearLayout(context);
        this.A02.addView(linearLayout);
        if (orientation == AdOptionsView.Orientation.HORIZONTAL) {
            i2 = 0;
        } else {
            i2 = 1;
        }
        linearLayout.setOrientation(i2);
        this.A01 = A00(EnumC0543Lm.DEFAULT_INFO_ICON);
        this.A00 = A00(EnumC0543Lm.AD_CHOICES_ICON);
        this.A00.setContentDescription(A01(0, 9, 116));
        linearLayout.addView(this.A01);
        linearLayout.addView(this.A00);
        setIconSizeDp(i);
        setIconColor(-10459280);
        C1007bZ A0J = C1007bZ.A0J(nativeAdBase.getInternalNativeAd());
        A0J.A1L(nativeAdLayout);
        A0J.A1M(this);
        RG A0v = A0J.A0v();
        if (A0v == null || !A0v.A0g() || A0v.A0e()) {
            linearLayout.setOnClickListener(new View$OnClickListenerC01424u(this, A0J));
            LC.A04(this.A02, LC.A0B);
            return;
        }
        linearLayout.setVisibility(8);
    }

    public C0724Sp(Context context, NativeAdBase nativeAdBase, @Nullable NativeAdLayout nativeAdLayout, AdOptionsView adOptionsView) {
        this(context, nativeAdBase, nativeAdLayout, AdOptionsView.Orientation.HORIZONTAL, 23, adOptionsView);
    }

    private ImageView A00(EnumC0543Lm lm) {
        ImageView imageView = new ImageView(this.A02.getContext());
        imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        int i = A05;
        imageView.setPadding(i, i, i, i);
        imageView.setImageBitmap(C0544Ln.A00(lm));
        return imageView;
    }

    public final void A03(EnumC0543Lm lm) {
        this.A01.setImageBitmap(C0544Ln.A00(lm));
    }

    @Override // com.facebook.ads.internal.api.AdComponentViewApiProvider
    public final AdComponentViewApi getAdComponentViewApi() {
        return this;
    }

    @Override // com.facebook.ads.internal.api.AdOptionsViewApi
    public final void setIconColor(int i) {
        this.A01.setColorFilter(i);
        this.A00.setColorFilter(i);
    }

    @Override // com.facebook.ads.internal.api.AdOptionsViewApi
    public final void setIconSizeDp(int i) {
        int max = Math.max(A04, (int) (C0535Le.A01 * ((float) i)));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(max, max);
        this.A01.setLayoutParams(layoutParams);
        this.A00.setLayoutParams(layoutParams);
    }

    @Override // com.facebook.ads.redexgen.X.AnonymousClass56, com.facebook.ads.internal.api.AdComponentView
    public final void setLayoutParams(ViewGroup.LayoutParams layoutParams) {
        layoutParams.width = -2;
        layoutParams.height = -2;
        super.setLayoutParams(layoutParams);
    }

    @Override // com.facebook.ads.internal.api.AdOptionsViewApi
    public final void setSingleIcon(boolean z) {
        int i;
        ImageView imageView = this.A01;
        if (z) {
            i = 8;
        } else {
            i = 0;
        }
        C0535Le.A0Q(imageView, i);
    }
}
