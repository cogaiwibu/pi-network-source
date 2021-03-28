package com.facebook.ads.redexgen.X;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.annotation.Nullable;
import com.facebook.ads.DefaultMediaViewVideoRenderer;
import com.facebook.ads.MediaView;
import com.facebook.ads.MediaViewListener;
import com.facebook.ads.MediaViewVideoRenderer;
import com.facebook.ads.NativeAd;
import com.facebook.ads.internal.api.AdComponentView;
import com.facebook.ads.internal.api.AdComponentViewApi;
import com.facebook.ads.internal.api.AdComponentViewParentApi;
import com.facebook.ads.internal.api.AdViewConstructorParams;
import com.facebook.ads.internal.api.MediaViewApi;
import com.facebook.ads.internal.api.NativeAdBaseApi;
import com.facebook.ads.internal.api.Repairable;
import com.facebook.ads.internal.protocol.AdErrorType;
import com.facebook.imageutils.JfifUtil;
import java.util.Arrays;
import java.util.List;
import kotlin.jvm.internal.ByteCompanionObject;

public final class T3 extends AnonymousClass56 implements MediaViewApi, Repairable, AnonymousClass8F {
    public static byte[] A0D;
    public static String[] A0E;
    public static final String A0F = MediaView.class.getSimpleName();
    public View A00;
    public ImageView A01;
    public MediaView A02;
    @Nullable
    public MediaViewListener A03;
    public MediaViewVideoRenderer A04;
    public ES A05;
    public AdComponentViewParentApi A06;
    public C0820Wh A07;
    public AnonymousClass1U A08;
    public NR A09;
    @Nullable
    public OV A0A;
    public boolean A0B;
    public boolean A0C;

    public static String A02(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A0D, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] ^ i3) ^ 47);
        }
        return new String(copyOfRange);
    }

    public static void A05() {
        A0D = new byte[]{56, 26, 9, 20, 14, 8, 30, 23, 91, 9, 30, 21, 31, 30, 9, 30, 9, 91, 22, 14, 8, 15, 91, 25, 30, 91, 8, 30, 15, 91, 25, 30, 29, 20, 9, 30, 91, 21, 26, 15, 18, 13, 30, 58, 31, 85, 26, 30, 29, 41, 56, 53, 57, 50, 63, 57, 18, 57, 40, 43, 51, 46, 55, 64, 100, 104, 110, 108, 41, 123, 108, 103, 109, 108, 123, 108, 123, 41, 100, 124, 122, 125, 41, 107, 108, 41, 122, 108, 125, 41, 107, 108, 111, 102, 123, 108, 41, 103, 104, 125, 96, ByteCompanionObject.MAX_VALUE, 108, 72, 109, 39, 96, 68, 72, 78, 76, 9, 91, 76, 71, 77, 76, 91, 76, 91, 9, 68, 92, 90, 93, 9, 75, 76, 9, 90, 76, 93, 9, 75, 76, 79, 70, 91, 76, 9, 71, 72, 93, 64, 95, 76, 107, 72, 71, 71, 76, 91, 104, 77, 7, 18, 53, 45, 58, 55, 50, 63, 123, 13, 50, 62, 44, 123, 56, 52, 53, 40, 47, 41, 46, 56, 47, 52, 41, 123, 43, 58, 41, 58, 54, 40, 123, 47, 34, 43, 62, 117, 1, 46, 59, 38, 57, 42, 111, 14, 43, 111, 6, 44, 32, 33, 111, 38, 60, 111, 33, 58, 35, 35, 97, 11, 52, 57, 56, 50, 125, 47, 56, 51, 57, 56, 47, 56, 47, 125, 48, 40, 46, 41, 125, 63, 56, 125, 46, 56, 41, 125, 63, 56, 59, 50, 47, 56, 125, 51, 60, 41, 52, 43, 56, 28, 57, 115, 26, 11, 18, 117, 106, 103, 102, 108, 86, 113, 111, 62};
    }

    public static void A06() {
        A0E = new String[]{"5egxRyJvv3hsImr6xVPVZGZzS", "S92E58UIdGCmPOb4LYA51SRur0tU5vPU", "gB2LJBWgacco1yi3dwEv6yCRJyLib4yq", "IRYDxixZynQ1VjnPzR0JfxvjieAE", "Yx6PPUM30uHFy3rHO75LIsUaVykI", "YSQgGTlHzzB", "fqdcFq1cD4m6uZ0nLvDLKOa7nCA9CaYH", "MqJIv4BM2hfR6AMSoGkEEGT8SPZgcE8o"};
    }

    static {
        A06();
        A05();
    }

    private void A03() {
        if (!this.A0C) {
            ES es = this.A05;
            String[] strArr = A0E;
            if (strArr[4].length() != strArr[3].length()) {
                throw new RuntimeException();
            }
            String[] strArr2 = A0E;
            strArr2[5] = "HiqmuX4YAHl";
            strArr2[0] = "JtgDxExoVYEb5OmxUIRsQ7gjV";
            if (es != null) {
                C0535Le.A0M(this.A08);
            }
            float f = C0535Le.A01;
            int round = Math.round(4.0f * f);
            int round2 = Math.round(12.0f * f);
            this.A08.setChildSpacing(round);
            this.A08.setPadding(0, round2, 0, round2);
            this.A08.setVisibility(8);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            layoutParams.addRule(13);
            this.A02.addView(this.A08, layoutParams);
            return;
        }
        throw new IllegalStateException(A02(0, 46, 84));
    }

    private void A04() {
        LC.A04(this.A02, LC.A0A);
        LC.A04(this.A09, LC.A0A);
        LC.A04(this.A04, LC.A0A);
        LC.A04(this.A05, LC.A0A);
    }

    private final void A07(View view, ViewGroup.LayoutParams layoutParams) {
        A02(false);
        this.A02.addView(view, layoutParams);
        A02(true);
    }

    private void A08(View view, C1007bZ bZVar) {
        OV ov = this.A0A;
        if (ov != null) {
            MediaView mediaView = this.A02;
            String[] strArr = A0E;
            if (strArr[5].length() != strArr[0].length()) {
                String[] strArr2 = A0E;
                strArr2[6] = "tYahJlzELN2bWoIKGOvNb4V2q4om3tal";
                strArr2[2] = "knO8IZUpKtredd0Q2IkvjJrJQGpJW1Qq";
                mediaView.removeView(ov);
            } else {
                throw new RuntimeException();
            }
        }
        if (bZVar.A1V()) {
            String A16 = bZVar.A16();
            Context context = this.A02.getContext();
            String[] strArr3 = A0E;
            if (strArr3[5].length() != strArr3[0].length()) {
                String[] strArr4 = A0E;
                strArr4[4] = "LedcnhOkj71a4gNr9a9uwwPVwkpS";
                strArr4[3] = "bOPNktfa058vxRDYU7HJ2aiUk3a2";
                if (context == null) {
                    return;
                }
            } else if (context == null) {
                return;
            }
            OV A012 = OU.A01(this.A07, A16);
            if (A0E[7].charAt(21) != 'L') {
                String[] strArr5 = A0E;
                strArr5[1] = "IBU68ioTGuVBWJ1dkmCJ7UK76Osi7EVF";
                strArr5[1] = "IBU68ioTGuVBWJ1dkmCJ7UK76Osi7EVF";
                this.A0A = A012;
                if (this.A0A == null) {
                    return;
                }
            } else {
                this.A0A = A012;
                if (this.A0A == null) {
                    return;
                }
            }
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            layoutParams.addRule(5, view.getId());
            layoutParams.addRule(7, view.getId());
            layoutParams.addRule(6, view.getId());
            layoutParams.addRule(8, view.getId());
            if (Build.VERSION.SDK_INT >= 17) {
                layoutParams.addRule(16, view.getId());
                layoutParams.addRule(17, view.getId());
            }
            A07(this.A0A, layoutParams);
            this.A06.bringChildToFront(this.A0A);
        }
    }

    private void A09(ImageView imageView) {
        if (!this.A0C) {
            ImageView imageView2 = this.A01;
            String[] strArr = A0E;
            if (strArr[5].length() != strArr[0].length()) {
                String[] strArr2 = A0E;
                strArr2[6] = "9onWrVOda1qlu0pAvyXYf5LKITz29A5r";
                strArr2[2] = "G6pev0JETY7bhqmEZOziJsmCoQM1bBBX";
                if (imageView2 != null) {
                    C0535Le.A0M(imageView2);
                }
                imageView.setVisibility(8);
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
                layoutParams.addRule(13);
                this.A02.addView(imageView, layoutParams);
                imageView.setId(C0535Le.A00());
                this.A01 = imageView;
                return;
            }
            throw new RuntimeException();
        }
        throw new IllegalStateException(A02(106, 49, 6));
    }

    @TargetApi(21)
    private final void A0A(C0820Wh wh, AttributeSet attributeSet, int i, int i2, MediaView mediaView) {
        this.A02 = mediaView;
        A09(new ImageView(wh, attributeSet, i, i2));
        A0F(new NR(wh, attributeSet, i, i2));
        this.A08 = new AnonymousClass1U(wh, attributeSet, i);
        A03();
        setVideoRenderer(new DefaultMediaViewVideoRenderer(wh, attributeSet, i, i2));
        A04();
    }

    private final void A0B(C0820Wh wh, AttributeSet attributeSet, int i, MediaView mediaView) {
        this.A02 = mediaView;
        A09(new ImageView(wh, attributeSet, i));
        A0F(new NR(wh, attributeSet, i));
        this.A08 = new AnonymousClass1U(wh, attributeSet, i);
        A03();
        setVideoRenderer(new DefaultMediaViewVideoRenderer(wh, attributeSet, i));
        A04();
    }

    private final void A0C(C0820Wh wh, AttributeSet attributeSet, MediaView mediaView) {
        this.A02 = mediaView;
        A09(new ImageView(wh, attributeSet));
        A0F(new NR(wh, attributeSet));
        this.A08 = new AnonymousClass1U(wh, attributeSet);
        A03();
        setVideoRenderer(new DefaultMediaViewVideoRenderer(wh, attributeSet));
        A04();
    }

    private final void A0D(C0820Wh wh, MediaView mediaView) {
        this.A02 = mediaView;
        A09(new ImageView(wh));
        A0F(new NR(wh));
        this.A08 = new AnonymousClass1U(wh);
        A03();
        setVideoRenderer(new DefaultMediaViewVideoRenderer(wh));
        A04();
    }

    private void A0E(C1007bZ bZVar, boolean z, JZ jz) {
        AsyncTaskC0831Ws A052 = new AsyncTaskC0831Ws(this.A01, this.A07).A05();
        if (z) {
            A052.A07(new C0733Sy(this, bZVar));
        }
        A052.A08(jz.getUrl());
    }

    private void A0F(NR nr) {
        if (!this.A0C) {
            NR nr2 = this.A09;
            if (nr2 != null) {
                this.A02.removeView(nr2);
            }
            nr.setVisibility(8);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            layoutParams.addRule(13);
            this.A02.addView(nr, layoutParams);
            this.A09 = nr;
            return;
        }
        throw new IllegalStateException(A02(63, 43, 38));
    }

    private boolean A0G(NativeAd nativeAd) {
        List<NativeAd> A042 = ((AnonymousClass5D) nativeAd.getNativeAdApi()).A04();
        if (A042 == null) {
            return false;
        }
        for (NativeAd childNativeAd : A042) {
            if (childNativeAd.getAdCoverImage() == null) {
                return false;
            }
        }
        return true;
    }

    private boolean A0H(NativeAd nativeAd) {
        return Build.VERSION.SDK_INT >= 14 && !TextUtils.isEmpty(((AnonymousClass5D) nativeAd.getNativeAdApi()).A03());
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x010a, code lost:
        if (r7 != false) goto L_0x010c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x01ec, code lost:
        if (r7 != false) goto L_0x010c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x01f4, code lost:
        if (r10.getAdCoverImage() == null) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x01f6, code lost:
        r3.A0x().A0A().AD7(com.facebook.ads.redexgen.X.EnumC00240d.A06);
        r9.A00 = r9.A09.getBodyImageView();
        r9.A04.setVisibility(8);
        r9.A04.unsetNativeAd();
        ((com.facebook.ads.redexgen.X.AnonymousClass5C) r9.A04.getMediaViewVideoRendererApi()).A04();
        r0 = r9.A05;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0222, code lost:
        if (r0 == null) goto L_0x022c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x0224, code lost:
        r0.setVisibility(8);
        r9.A05.setAdapter(null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x022c, code lost:
        bringChildToFront(r9.A09);
        r9.A09.setVisibility(0);
        new com.facebook.ads.redexgen.X.AsyncTaskC0831Ws(r9.A09, r9.A07).A06(r9.A02.getHeight(), r9.A02.getWidth()).A07(new com.facebook.ads.redexgen.X.T1(r9, r3)).A08(r3.getAdCoverImage().getUrl());
        A08(r9.A09, r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:?, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void A0I(com.facebook.ads.NativeAd r10) {
        /*
        // Method dump skipped, instructions count: 630
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.T3.A0I(com.facebook.ads.NativeAd):void");
    }

    public final void A0J(NativeAdBaseApi nativeAdBaseApi, boolean z) {
        C0820Wh A0x = ((C1007bZ) nativeAdBaseApi).A0x();
        this.A07.A0D(A0x);
        A0x.A0C(this);
        this.A0C = true;
        C1007bZ A0J = C1007bZ.A0J(nativeAdBaseApi);
        A0J.A1J(this.A02);
        this.A09.setVisibility(8);
        this.A09.setImage(null, null);
        this.A04.setVisibility(8);
        this.A04.unsetNativeAd();
        ((AnonymousClass5C) this.A04.getMediaViewVideoRendererApi()).A04();
        ES es = this.A05;
        if (es != null) {
            es.setVisibility(8);
            this.A05.setAdapter(null);
        }
        this.A01.setVisibility(0);
        bringChildToFront(this.A01);
        this.A00 = this.A01;
        JZ A10 = A0J.getAdIcon();
        if (A10 != null) {
            Bitmap A0I = A0J.A0w().A0I(A10.getUrl());
            if (A0I != null) {
                this.A01.setImageBitmap(A0I);
                if (z) {
                    this.A02.post(new C0732Sx(this, A0J));
                }
            } else {
                A0E(A0J, z, A10);
            }
        } else {
            AbstractC1008ba A11 = A0J.A11();
            AdErrorType adErrorType = AdErrorType.NATIVE_AD_IS_NOT_LOADED;
            A0x.A0A().A2d(A0J.A0u(), adErrorType.getErrorCode(), adErrorType.getDefaultErrorMessage());
            if (A11 != null) {
                A11.A9X(C0495Jm.A01(adErrorType));
            }
            Log.e(A02(46, 17, 115), adErrorType.getDefaultErrorMessage());
            if (nativeAdBaseApi.isAdLoaded()) {
                this.A07.A04().A82(A02(258, 3, 84), C02248i.A0L, new C02258j(A02(JfifUtil.MARKER_SOFn, 23, 96)));
            }
        }
        A08(this.A01, A0J);
    }

    public final boolean A0K() {
        ES es = this.A05;
        return es != null && es.getVisibility() == 0;
    }

    @Override // com.facebook.ads.redexgen.X.AnonymousClass8F
    public final C0820Wh A5G() {
        return this.A07;
    }

    @Override // com.facebook.ads.redexgen.X.AnonymousClass56, com.facebook.ads.internal.api.AdComponentViewParentApi
    public final void bringChildToFront(View view) {
        if (view == this.A05 || view == this.A04 || view == this.A09 || view == this.A01) {
            this.A06.bringChildToFront(view);
            OV ov = this.A0A;
            if (ov != null) {
                this.A06.bringChildToFront(ov);
            }
        }
    }

    @Override // com.facebook.ads.internal.api.MediaViewApi
    public final void destroy() {
        this.A04.pause(false);
        this.A04.getMediaViewVideoRendererApi().destroy();
    }

    @Override // com.facebook.ads.internal.api.AdComponentViewApiProvider
    public final AdComponentViewApi getAdComponentViewApi() {
        return this;
    }

    @Override // com.facebook.ads.internal.api.MediaViewApi
    public final View getAdContentsView() {
        return this.A00;
    }

    @Override // com.facebook.ads.internal.api.MediaViewApi
    public final int getMediaHeight() {
        if (this.A09.getVisibility() == 0) {
            return this.A09.getImageHeight();
        }
        if (this.A04.getVisibility() == 0) {
            return this.A04.getMediaViewVideoRendererApi().getVideoView().getHeight();
        }
        if (this.A02.getVisibility() == 0) {
            return this.A02.getHeight();
        }
        if (A0E[1].charAt(24) != 't') {
            String[] strArr = A0E;
            strArr[7] = "3C5Zne3gt6SFfa7y1AnuQltffgpI3Oh8";
            strArr[7] = "3C5Zne3gt6SFfa7y1AnuQltffgpI3Oh8";
            return 0;
        }
        throw new RuntimeException();
    }

    @Override // com.facebook.ads.internal.api.MediaViewApi
    public final int getMediaWidth() {
        if (this.A09.getVisibility() == 0) {
            return this.A09.getImageWidth();
        }
        if (this.A04.getVisibility() == 0) {
            return this.A04.getMediaViewVideoRendererApi().getVideoView().getWidth();
        }
        if (this.A02.getVisibility() == 0) {
            return this.A02.getWidth();
        }
        String[] strArr = A0E;
        if (strArr[6].charAt(12) != strArr[2].charAt(12)) {
            String[] strArr2 = A0E;
            strArr2[5] = "pFreRfYdfw1";
            strArr2[0] = "pVUprXCJsnglf8IlGtX2XFBaJ";
            return 0;
        }
        throw new RuntimeException();
    }

    @Override // com.facebook.ads.internal.api.MediaViewApi
    public final void initialize(AdViewConstructorParams adViewConstructorParams, MediaView mediaView) {
        this.A07 = AnonymousClass57.A02(adViewConstructorParams.getContext());
        this.A07.A0C(this);
        int initializationType = adViewConstructorParams.getInitializationType();
        if (initializationType == 0) {
            A0D(this.A07, mediaView);
        } else if (initializationType == 1) {
            A0C(this.A07, adViewConstructorParams.getAttributeSet(), mediaView);
        } else if (initializationType == 2) {
            A0B(this.A07, adViewConstructorParams.getAttributeSet(), adViewConstructorParams.getDefStyleAttr(), mediaView);
        } else if (initializationType == 3) {
            A0A(this.A07, adViewConstructorParams.getAttributeSet(), adViewConstructorParams.getDefStyleAttr(), adViewConstructorParams.getDefStyleRes(), mediaView);
        } else {
            throw new IllegalArgumentException(A02(155, 37, 116));
        }
        A02(true);
    }

    @Override // com.facebook.ads.redexgen.X.AnonymousClass56, com.facebook.ads.internal.api.AdComponentViewApi
    public final void onAttachedToView(AdComponentView adComponentView, AdComponentViewParentApi adComponentViewParentApi) {
        super.onAttachedToView(adComponentView, adComponentViewParentApi);
        this.A06 = adComponentViewParentApi;
    }

    @Override // com.facebook.ads.internal.api.Repairable
    public final void repair(Throwable th) {
        int width = this.A02.getWidth();
        int height = this.A02.getHeight();
        if (width <= 0 || height <= 0) {
            this.A02.repair(th);
            return;
        }
        this.A02.repair(th);
        this.A02.getLayoutParams().width = width;
        MediaView mediaView = this.A02;
        if (A0E[1].charAt(24) != 't') {
            String[] strArr = A0E;
            strArr[5] = "Mgb6bOJjyiN";
            strArr[0] = "MTEeDXbdwkPsq4eW7ABfM3WBi";
            mediaView.getLayoutParams().height = height;
            this.A02.setBackgroundColor(-3355444);
            return;
        }
        throw new RuntimeException();
    }

    @Override // com.facebook.ads.internal.api.MediaViewApi
    public final void setListener(MediaViewListener mediaViewListener) {
        this.A03 = mediaViewListener;
        if (mediaViewListener == null) {
            ((AnonymousClass5C) this.A04.getMediaViewVideoRendererApi()).A08(null);
        } else {
            ((AnonymousClass5C) this.A04.getMediaViewVideoRendererApi()).A08(new T2(this, mediaViewListener));
        }
    }

    @Override // com.facebook.ads.internal.api.MediaViewApi
    public final void setVideoRenderer(MediaViewVideoRenderer mediaViewVideoRenderer) {
        boolean z;
        if (!this.A0C) {
            MediaViewVideoRenderer mediaViewVideoRenderer2 = this.A04;
            if (A0E[7].charAt(21) != 'L') {
                String[] strArr = A0E;
                strArr[6] = "ifAS5bhxfK6Gg4eu5Yemnhg9EBEfp9jT";
                strArr[2] = "R5YDbsM1msNnvJcIFydw3DY2O0brJ9d9";
                if (mediaViewVideoRenderer2 != null) {
                    this.A02.removeView(mediaViewVideoRenderer2);
                    this.A04.getMediaViewVideoRendererApi().destroy();
                }
                ((AnonymousClass5C) mediaViewVideoRenderer.getMediaViewVideoRendererApi()).A06(this.A07.A06());
                mediaViewVideoRenderer.setVisibility(8);
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
                layoutParams.addRule(13);
                ((T3) this.A02.getMediaViewApi()).A07(mediaViewVideoRenderer, layoutParams);
                this.A04 = mediaViewVideoRenderer;
                if (!(this.A04 instanceof DefaultMediaViewVideoRenderer)) {
                    z = true;
                } else {
                    z = false;
                }
                this.A0B = z;
                mediaViewVideoRenderer.setId(C0535Le.A00());
                return;
            }
            throw new RuntimeException();
        }
        throw new IllegalStateException(A02(JfifUtil.MARKER_RST7, 43, 114));
    }
}
