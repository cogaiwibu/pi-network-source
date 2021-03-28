package com.facebook.ads.redexgen.X;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.RelativeLayout;
import androidx.annotation.Nullable;
import com.facebook.ads.MediaViewVideoRenderer;
import com.facebook.ads.internal.api.DefaultMediaViewVideoRendererApi;
import com.facebook.ads.internal.api.MediaViewVideoRendererApi;
import com.facebook.ads.internal.settings.AdInternalSettings;
import com.facebook.proguard.annotations.DoNotStrip;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicBoolean;

/* renamed from: com.facebook.ads.redexgen.X.bP  reason: case insensitive filesystem */
public final class C0998bP extends AnonymousClass56 implements DefaultMediaViewVideoRendererApi {
    public static byte[] A0F;
    public static String[] A0G;
    public static final String A0H = C0998bP.class.getSimpleName();
    public MediaViewVideoRenderer A00;
    public C0820Wh A01;
    @Nullable
    public JT A02;
    public EnumC0488Je A03 = EnumC0488Je.A03;
    @Nullable
    public C02619t A04;
    public C01997a A05;
    public AnonymousClass7S A06;
    @DoNotStrip
    public AbstractC0640Pg A07;
    public C0641Ph A08;
    public boolean A09;
    public boolean A0A;
    public boolean A0B;
    public final AbstractC0623Op A0C = new C0992bJ(this);
    public final AtomicBoolean A0D = new AtomicBoolean(false);
    public final AtomicBoolean A0E = new AtomicBoolean(false);

    public static String A06(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A0F, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] ^ i3) ^ 127);
        }
        return new String(copyOfRange);
    }

    public static void A0E() {
        A0F = new byte[]{7, 32, 56, 47, 34, 39, 42, 110, 60, 43, 32, 42, 43, 60, 43, 60, 110, 45, 38, 39, 34, 42, 110, 45, 33, 32, 40, 39, 41, 96, 14, 38, 39, 42, 34, 21, 42, 38, 52, 21, 42, 39, 38, 44, 99, 42, 48, 99, 45, 54, 47, 47, 120, 99, 54, 45, 34, 33, 47, 38, 99, 55, 44, 99, 37, 42, 45, 39, 99, 42, 55, 109, 16, 43, 36, 39, 41, 32, 101, 49, 42, 101, 35, 44, 43, 33, 101, 8, 32, 33, 44, 36, 19, 44, 32, 50, 19, 44, 33, 32, 42, 101, 38, 45, 44, 41, 33, 107};
    }

    public static void A0F() {
        A0G = new String[]{"mcYgxpLQMmIwsDd5yEmcOVEUvqtoI", "GHoJM0N9xHnxy27wJlEicj6316JJBG", "sAgmez8xlBVRjdgohc9cPNZKpCHjl", "UXd4O0RMEZeMz8rPKuZc9Jx8", "lkMSGOb1N9f2znZPpxO7v43dGPgWn", "ZJq7h5cFUWj9FCmvTSQNl6xA6rnC8", "yifDfgH7QVrqMR4w0vNHSMY9h4Ewh", "QZpfE8IVFABXRQwraZ"};
    }

    static {
        A0F();
        A0E();
    }

    private JV A01(MediaViewVideoRendererApi mediaViewVideoRendererApi) {
        return new C0993bK(this, mediaViewVideoRendererApi);
    }

    private JV A02(MediaViewVideoRendererApi mediaViewVideoRendererApi) {
        return new C0994bL(this, mediaViewVideoRendererApi);
    }

    private AbstractC0640Pg A04() {
        return new C0996bN(this);
    }

    private C0641Ph A05() {
        return new C0641Ph(this.A00, 50, true, new WeakReference(this.A07), this.A01);
    }

    private void A09() {
        C02619t r0 = this.A04;
        if (r0 != null) {
            C0624Oq oq = (C0624Oq) r0.getVideoView();
            if (A0G[3].length() != 24) {
                throw new RuntimeException();
            }
            String[] strArr = A0G;
            strArr[2] = "uL1T6UePNJ7Kw1irCYcqiA1GlgiEZ";
            strArr[0] = "2BZHbySyGqLzqR4K5b7TQMpiAd64K";
            oq.setViewImplInflationListener(this.A0C);
        }
    }

    private void A0A() {
        C02619t r0 = this.A04;
        if (r0 != null) {
            r0.getVideoView().setOnTouchListener(new JS(this));
        }
    }

    private void A0B() {
        C02619t r0 = this.A04;
        if (r0 != null) {
            C0624Oq oq = (C0624Oq) r0.getVideoView();
            String[] strArr = A0G;
            if (strArr[4].length() != strArr[1].length()) {
                String[] strArr2 = A0G;
                strArr2[7] = "MUEPyY1MJMWvhU3XHu";
                strArr2[7] = "MUEPyY1MJMWvhU3XHu";
                oq.setViewImplInflationListener(null);
                return;
            }
            throw new RuntimeException();
        }
    }

    private void A0C() {
        if (this.A00.getVisibility() == 0 && this.A09) {
            MediaViewVideoRenderer mediaViewVideoRenderer = this.A00;
            String[] strArr = A0G;
            if (strArr[4].length() != strArr[1].length()) {
                String[] strArr2 = A0G;
                strArr2[4] = "vtumVYeB8x7vkBeCNzRl37Vgwgf5m";
                strArr2[1] = "l5c2Nb35iHyego1JNAmcVzJY15xyfp";
                if (mediaViewVideoRenderer.hasWindowFocus()) {
                    this.A08.A0W();
                    return;
                }
            } else {
                throw new RuntimeException();
            }
        }
        C02619t r0 = this.A04;
        if (r0 != null && r0.getState() == EnumC0638Pe.A05) {
            this.A0B = true;
        }
        this.A08.A0X();
    }

    /* access modifiers changed from: private */
    public void A0D() {
        this.A03 = EnumC0488Je.A03;
        A0B();
    }

    /* access modifiers changed from: private */
    public void A0J(C1007bZ bZVar, @Nullable JT jt) {
        String str;
        this.A0A = false;
        this.A0B = false;
        this.A02 = jt;
        A09();
        C01997a r3 = this.A05;
        if (bZVar != null) {
            JZ A0z = bZVar.getAdCoverImage();
            String[] strArr = A0G;
            if (strArr[2].length() != strArr[0].length()) {
                throw new RuntimeException();
            }
            String[] strArr2 = A0G;
            strArr2[3] = "zpp3cHPhluFOPvL30kkcY8af";
            strArr2[3] = "zpp3cHPhluFOPvL30kkcY8af";
            if (A0z != null) {
                str = bZVar.getAdCoverImage().getUrl();
                r3.setImage(str, new C0995bM(this));
                this.A03 = bZVar.A14();
                this.A06.setPlayAccessibilityLabel(bZVar.A18());
                this.A06.setPauseAccessibilityLabel(bZVar.A17());
                this.A08.A0W();
            }
        }
        str = null;
        r3.setImage(str, new C0995bM(this));
        this.A03 = bZVar.A14();
        this.A06.setPlayAccessibilityLabel(bZVar.A18());
        this.A06.setPauseAccessibilityLabel(bZVar.A17());
        this.A08.A0W();
    }

    /* access modifiers changed from: private */
    public void A0K(EnumC0626Os os) {
        C02619t r1 = this.A04;
        if (r1 != null) {
            r1.A0Y(os, 24);
        } else if (AdInternalSettings.isDebugBuild()) {
            Log.e(A0H, A06(30, 42, 60));
        }
    }

    /* access modifiers changed from: private */
    public boolean A0L() {
        C02619t r0 = this.A04;
        if (r0 == null || r0.getState() == EnumC0638Pe.A06) {
            return false;
        }
        if (this.A03 == EnumC0488Je.A05 || this.A03 == EnumC0488Je.A03) {
            return true;
        }
        return false;
    }

    @Override // com.facebook.ads.internal.api.DefaultMediaViewVideoRendererApi
    public final void initialize(Context context, MediaViewVideoRenderer mediaViewVideoRenderer, MediaViewVideoRendererApi mediaViewVideoRendererApi, int i) {
        JV A022;
        ((AnonymousClass56) mediaViewVideoRendererApi.getAdComponentViewApi()).A01(this);
        if (i == 0) {
            A022 = A02(mediaViewVideoRendererApi);
        } else if (i == 1) {
            A022 = A01(mediaViewVideoRendererApi);
        } else {
            throw new IllegalArgumentException(A06(0, 30, 49));
        }
        ((AnonymousClass5C) mediaViewVideoRendererApi).A07(A022);
        this.A01 = AnonymousClass57.A02(context);
        this.A00 = mediaViewVideoRenderer;
        this.A05 = new C01997a(this.A01);
        this.A07 = A04();
        this.A08 = A05();
        float f = C0535Le.A01;
        int i2 = (int) (2.0f * f);
        int i3 = (int) (25.0f * f);
        this.A06 = new AnonymousClass7S(this.A01);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(9);
        layoutParams.addRule(12);
        this.A06.setPadding(i2, i3, i3, i2);
        this.A06.setLayoutParams(layoutParams);
        int i4 = 0;
        while (true) {
            int childCount = this.A00.getChildCount();
            if (A0G[3].length() == 24) {
                String[] strArr = A0G;
                strArr[2] = "oEzbzrDqpY4LpZuK9aeaZZijHYv0V";
                strArr[0] = "65U2aK7TrzSKlLOXQMMYyslcv3rZK";
                if (i4 >= childCount) {
                    break;
                }
                View childAt = this.A00.getChildAt(0);
                if (childAt instanceof C02619t) {
                    this.A04 = (C02619t) childAt;
                    break;
                }
                i4++;
            } else {
                throw new RuntimeException();
            }
        }
        C02619t r1 = this.A04;
        if (r1 != null) {
            r1.A0Z(this.A05);
            this.A04.A0Z(this.A06);
        } else if (AdInternalSettings.isDebugBuild()) {
            Log.e(A0H, A06(72, 36, 58));
        }
        this.A08.A0Y(0);
        this.A08.A0Z(IronSourceConstants.INTERSTITIAL_DAILY_CAPPED);
        A022.ACy();
        String[] strArr2 = A0G;
        if (strArr2[4].length() != strArr2[1].length()) {
            String[] strArr3 = A0G;
            strArr3[4] = "NjD77g9sbns6FUonJskLzorZMVzfs";
            strArr3[1] = "sF6jyMJNRDvSJleY8k7g51skJQqlgl";
            return;
        }
        String[] strArr4 = A0G;
        strArr4[2] = "irNdkufru0tgAA9z3l7YlJhRv0dZK";
        strArr4[0] = "zN5wNlZvELtjdUjcESL7VUEU7ru13";
    }

    @Override // com.facebook.ads.redexgen.X.AnonymousClass56, com.facebook.ads.internal.api.AdComponentViewParentApi
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.A09 = true;
        A0C();
    }

    @Override // com.facebook.ads.redexgen.X.AnonymousClass56, com.facebook.ads.internal.api.AdComponentViewParentApi
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.A09 = false;
        A0C();
    }

    @Override // com.facebook.ads.internal.api.DefaultMediaViewVideoRendererApi
    public final void onPrepared() {
        this.A00.setOnTouchListener(new JR(this));
        A0A();
    }

    @Override // com.facebook.ads.redexgen.X.AnonymousClass56, com.facebook.ads.internal.api.AdComponentViewParentApi
    public final void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
        A0C();
    }

    @Override // com.facebook.ads.redexgen.X.AnonymousClass56, com.facebook.ads.internal.api.AdComponentView
    public final void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        A0C();
    }
}
