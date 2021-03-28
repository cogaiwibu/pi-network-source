package com.facebook.ads.redexgen.X;

import android.animation.ObjectAnimator;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.ScaleDrawable;
import android.view.animation.LinearInterpolator;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import androidx.annotation.Nullable;
import androidx.core.view.GravityCompat;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import java.util.Arrays;

public final class H2 extends RelativeLayout implements AbstractC0627Ot {
    public static byte[] A08;
    public static final int A09 = ((int) (C0535Le.A01 * 6.0f));
    public int A00;
    public ObjectAnimator A01;
    public ProgressBar A02;
    public AnonymousClass9K A03;
    public AnonymousClass9K A04;
    public AnonymousClass9K A05;
    public AnonymousClass9K A06;
    @Nullable
    public C0532Lb A07;

    public static String A01(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A08, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] - i3) - 20);
        }
        return new String(copyOfRange);
    }

    public static void A05() {
        A08 = new byte[]{-71, -69, -72, -80, -69, -82, -68, -68};
    }

    static {
        A05();
    }

    public H2(C0820Wh wh) {
        this(wh, A09, -12549889, 0);
    }

    public H2(C0820Wh wh, int i, int i2, int i3) {
        super(wh);
        this.A00 = -1;
        this.A06 = new C01756c(this);
        this.A04 = new C01645r(this);
        this.A05 = new C01234b(this);
        this.A03 = new AnonymousClass4T(this);
        this.A02 = new ProgressBar(wh, null, 16842872);
        A0A(i2, i3);
        this.A02.setMax(10000);
        addView(this.A02, new RelativeLayout.LayoutParams(-1, i));
    }

    /* access modifiers changed from: private */
    public void A02() {
        A03();
        this.A01 = ObjectAnimator.ofInt(this.A02, A01(0, 8, 53), 0, 0);
        this.A01.setDuration(0L);
        this.A01.setInterpolator(new LinearInterpolator());
        this.A01.start();
        this.A00 = -1;
    }

    /* access modifiers changed from: private */
    public void A03() {
        ObjectAnimator objectAnimator = this.A01;
        if (objectAnimator != null) {
            objectAnimator.cancel();
            this.A01.setTarget(null);
            this.A01 = null;
            this.A02.clearAnimation();
        }
    }

    /* access modifiers changed from: private */
    public void A04() {
        int i;
        if (this.A07 != null) {
            A03();
            int progress = this.A07.getCurrentPositionInMillis();
            int duration = this.A07.getDuration();
            if (duration > 0) {
                i = (progress * 10000) / duration;
            } else {
                i = 0;
            }
            int i2 = this.A00;
            if (i2 < i && duration > progress) {
                this.A01 = ObjectAnimator.ofInt(this.A02, A01(0, 8, 53), i2, i);
                this.A01.setDuration((long) Math.min((int) IronSourceConstants.INTERSTITIAL_DAILY_CAPPED, duration - progress));
                this.A01.setInterpolator(new LinearInterpolator());
                this.A01.start();
                this.A00 = i;
            }
        }
    }

    public final void A09() {
        A03();
        this.A02 = null;
        this.A07 = null;
    }

    public final void A0A(int i, int i2) {
        LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{new ColorDrawable(i2), new ColorDrawable(i2), new ScaleDrawable(new ColorDrawable(i), GravityCompat.START, 1.0f, -1.0f)});
        layerDrawable.setId(0, 16908288);
        layerDrawable.setId(1, 16908303);
        layerDrawable.setId(2, 16908301);
        this.A02.setProgressDrawable(layerDrawable);
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC0627Ot
    public final void A7s(C0532Lb lb) {
        this.A07 = lb;
        lb.getEventBus().A04(this.A04, this.A05, this.A06, this.A03);
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC0627Ot
    public final void ADa(C0532Lb lb) {
        lb.getEventBus().A05(this.A06, this.A05, this.A04, this.A03);
        this.A07 = null;
    }
}
