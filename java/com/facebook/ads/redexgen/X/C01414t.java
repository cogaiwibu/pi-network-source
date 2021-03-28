package com.facebook.ads.redexgen.X;

import android.content.Context;
import android.graphics.Paint;
import android.text.TextUtils;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.facebook.ads.AdChoicesView;
import com.facebook.ads.NativeAdBase;
import com.facebook.ads.NativeAdLayout;
import com.facebook.ads.internal.api.AdChoicesViewApi;
import java.util.Arrays;

/* renamed from: com.facebook.ads.redexgen.X.4t  reason: invalid class name and case insensitive filesystem */
public final class C01414t implements AdChoicesViewApi {
    public static byte[] A07;
    public static String[] A08;
    public TextView A00;
    public String A01;
    public boolean A02 = false;
    public final float A03;
    public final AdChoicesView A04;
    public final NativeAdBase A05;
    public final C0820Wh A06;

    static {
        A08();
        A07();
    }

    public static String A04(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A07, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] ^ i3) ^ 108);
        }
        return new String(copyOfRange);
    }

    public static void A07() {
        A07 = new byte[]{56, 29, 58, 17, 22, 16, 26, 28, 10};
    }

    public static void A08() {
        A08 = new String[]{"gvO42MF", "iIdUVCS", "4ayqEVday587OvHv9KTxdb7b7wSBomyU", "oCu", "csOI", "U1PTH9OJfN", "wm8DLeb0fzTxf", "N58zr1rga3p3lU4dt8STYYI"};
    }

    public C01414t(AdChoicesView adChoicesView, Context context, NativeAdBase nativeAdBase) {
        this.A04 = adChoicesView;
        this.A06 = AnonymousClass57.A02(context);
        this.A05 = nativeAdBase;
        this.A03 = C0535Le.A01;
    }

    private ImageView A00(JZ jz) {
        ImageView imageView = new ImageView(this.A04.getContext());
        this.A04.addView(imageView);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(Math.round(((float) jz.getWidth()) * this.A03), Math.round(((float) jz.getHeight()) * this.A03));
        layoutParams.addRule(9);
        layoutParams.addRule(15, -1);
        layoutParams.setMargins(Math.round(this.A03 * 4.0f), Math.round(this.A03 * 2.0f), Math.round(this.A03 * 2.0f), Math.round(this.A03 * 2.0f));
        imageView.setLayoutParams(layoutParams);
        C1007bZ.A0f(jz, imageView, this.A06);
        return imageView;
    }

    /* JADX INFO: Multiple debug info for r0v5 int: [D('startWidth' int), D('targetWidth' int)] */
    /* access modifiers changed from: private */
    public void A05() {
        Paint paint = new Paint();
        paint.setTextSize(this.A00.getTextSize());
        int round = Math.round(paint.measureText(this.A01) + (this.A03 * 4.0f));
        int textWidth = this.A04.getWidth();
        C01394r r2 = new C01394r(this, textWidth, textWidth - round);
        r2.setAnimationListener(new animation.Animation$AnimationListenerC01404s(this));
        r2.setDuration(300);
        r2.setFillAfter(true);
        this.A04.startAnimation(r2);
    }

    /* JADX INFO: Multiple debug info for r0v5 int: [D('startWidth' int), D('targetWidth' int)] */
    /* access modifiers changed from: private */
    public void A06() {
        Paint paint = new Paint();
        paint.setTextSize(this.A00.getTextSize());
        int round = Math.round(paint.measureText(this.A01) + (this.A03 * 4.0f));
        int textWidth = this.A04.getWidth();
        this.A02 = true;
        Animation expandAnimation = new C01374p(this, textWidth, textWidth + round);
        expandAnimation.setAnimationListener(new animation.Animation$AnimationListenerC01384q(this));
        expandAnimation.setDuration(300);
        expandAnimation.setFillAfter(true);
        this.A04.startAnimation(expandAnimation);
    }

    /* JADX INFO: Multiple debug info for r0v27 android.widget.ImageView: [D('adChoicesImageView' android.widget.ImageView), D('adChoicesTextViewLayoutParams' android.widget.RelativeLayout$LayoutParams)] */
    @Override // com.facebook.ads.internal.api.AdChoicesViewApi
    public final void initialize(boolean z, @Nullable NativeAdLayout nativeAdLayout) {
        C1007bZ.A0J(this.A05.getInternalNativeAd()).A1L(nativeAdLayout);
        RG A0v = C1007bZ.A0J(this.A05.getInternalNativeAd()).A0v();
        if (A0v == null || !A0v.A0g() || A0v.A0e()) {
            this.A01 = this.A05.getAdChoicesText();
            if (TextUtils.isEmpty(this.A01)) {
                String[] strArr = A08;
                if (strArr[7].length() != strArr[6].length()) {
                    String[] strArr2 = A08;
                    strArr2[4] = "ttxb";
                    strArr2[3] = "x8K";
                    this.A01 = A04(0, 9, 21);
                } else {
                    throw new RuntimeException();
                }
            }
            JZ A0y = C1007bZ.A0J(this.A05.getInternalNativeAd()).getAdChoicesIcon();
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            this.A04.setOnTouchListener(new View$OnTouchListenerC01364o(this));
            this.A00 = new TextView(this.A04.getContext());
            this.A04.addView(this.A00);
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
            if (!z || A0y == null) {
                this.A02 = true;
            } else {
                layoutParams2.addRule(11, A00(A0y).getId());
                if (A08[2].charAt(8) != 'Y') {
                    String[] strArr3 = A08;
                    strArr3[5] = "acVQqvBAW9";
                    strArr3[5] = "acVQqvBAW9";
                    layoutParams2.width = 0;
                    layoutParams.width = Math.round(((float) (A0y.getWidth() + 4)) * this.A03);
                    layoutParams.height = Math.round(((float) (A0y.getHeight() + 2)) * this.A03);
                    this.A02 = false;
                } else {
                    throw new RuntimeException();
                }
            }
            this.A04.setLayoutParams(layoutParams);
            layoutParams2.addRule(15, -1);
            this.A00.setLayoutParams(layoutParams2);
            this.A00.setSingleLine();
            this.A00.setText(this.A01);
            this.A00.setTextSize(10.0f);
            this.A00.setTextColor(-4341303);
            LC.A04(this.A04, LC.A07);
            LC.A04(this.A00, LC.A07);
            return;
        }
        this.A04.setVisibility(8);
    }
}
