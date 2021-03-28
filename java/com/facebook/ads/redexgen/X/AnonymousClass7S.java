package com.facebook.ads.redexgen.X;

import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.RelativeLayout;
import androidx.annotation.Nullable;

/* renamed from: com.facebook.ads.redexgen.X.7S  reason: invalid class name */
public final class AnonymousClass7S extends K6 implements View.OnClickListener {
    public static String[] A05;
    public final K4 A00;
    public final AbstractC0506Jy A01;
    public final AbstractC0494Jk A02;
    public final JH A03;
    public final PC A04;

    static {
        A01();
    }

    public static void A01() {
        A05 = new String[]{"dj2bca5KMhic7lU7SNdjndSTQwmssf52", "TPlcacN2BRfqpmqqou3eGj4ypEirHC", "lK1i5T", "LDnNwGMA5Xj1Rc4RK", "9vPtQslMJEvaRYxyY6ZiMi1q6kn3NQTo", "pbwCeIFhJ07zfEQSECI2TdcOW", "Wj7W52", "ztBFgo3EeJBil6N8wes8zN"};
    }

    public AnonymousClass7S(C0820Wh wh) {
        this(wh, null);
    }

    public AnonymousClass7S(C0820Wh wh, AttributeSet attributeSet) {
        this(wh, attributeSet, 0);
    }

    public AnonymousClass7S(C0820Wh wh, AttributeSet attributeSet, int i) {
        super(wh, attributeSet, i);
        this.A03 = new AnonymousClass7Z(this);
        this.A01 = new AnonymousClass7Y(this);
        this.A02 = new AnonymousClass7X(this);
        this.A00 = new AnonymousClass7T(this);
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        this.A04 = new PC(wh);
        this.A04.setChecked(true);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams((int) (displayMetrics.density * 25.0f), (int) (displayMetrics.density * 25.0f));
        setVisibility(8);
        addView(this.A04, layoutParams);
        setClickable(true);
        setFocusable(true);
    }

    @Override // com.facebook.ads.redexgen.X.K6
    public final void A07() {
        super.A07();
        setOnClickListener(this);
        this.A04.setOnClickListener(this);
        if (getVideoView() != null) {
            getVideoView().getEventBus().A04(this.A03, this.A00, this.A01, this.A02);
        }
    }

    @Override // com.facebook.ads.redexgen.X.K6
    public final void A08() {
        if (getVideoView() != null) {
            getVideoView().getEventBus().A05(this.A02, this.A01, this.A00, this.A03);
        }
        setOnClickListener(null);
        this.A04.setOnClickListener(null);
        super.A08();
    }

    public final void onClick(View view) {
        if (!KU.A02(this)) {
            try {
                C0532Lb videoView = getVideoView();
                if (videoView != null) {
                    if (videoView.getState() == EnumC0638Pe.A07 || videoView.getState() == EnumC0638Pe.A05 || videoView.getState() == EnumC0638Pe.A06) {
                        videoView.A0Y(EnumC0626Os.A05, 11);
                    } else if (videoView.getState() == EnumC0638Pe.A0A) {
                        videoView.A0b(true, 7);
                    }
                }
            } catch (Throwable th) {
                if (A05[5].length() != 25) {
                    throw new RuntimeException();
                }
                String[] strArr = A05;
                strArr[7] = "YsoDkb8mAWGLBYzRGBa3i8";
                strArr[7] = "YsoDkb8mAWGLBYzRGBa3i8";
                KU.A00(th, this);
            }
        }
    }

    public void setPauseAccessibilityLabel(@Nullable String str) {
        this.A04.setPauseAccessibilityLabel(str);
    }

    public void setPlayAccessibilityLabel(@Nullable String str) {
        this.A04.setPlayAccessibilityLabel(str);
    }
}
