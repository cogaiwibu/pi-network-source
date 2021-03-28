package com.facebook.ads.redexgen.X;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.DisplayMetrics;
import android.widget.RelativeLayout;
import androidx.annotation.Nullable;

/* renamed from: com.facebook.ads.redexgen.X.7B  reason: invalid class name */
public final class AnonymousClass7B extends K6 {
    public final Paint A00;
    public final C0820Wh A01;
    @Nullable
    public final JL A02;
    public final K4 A03 = new AnonymousClass7N(this);
    public final AbstractC0506Jy A04 = new AnonymousClass7P(this);
    public final AbstractC0494Jk A05 = new AnonymousClass7O(this);
    public final PC A06;

    public AnonymousClass7B(C0820Wh wh, boolean z, @Nullable JL jl) {
        super(wh);
        this.A02 = jl;
        this.A01 = wh;
        this.A06 = new PC(wh, z);
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams((int) (((double) displayMetrics.density) * 23.76d), (int) (((double) displayMetrics.density) * 23.76d));
        layoutParams.addRule(13);
        this.A06.setLayoutParams(layoutParams);
        this.A06.setChecked(true);
        this.A06.setClickable(false);
        this.A00 = new Paint();
        this.A00.setStyle(Paint.Style.FILL);
        if (z) {
            this.A00.setColor(-1728053248);
        } else {
            this.A00.setColor(-1);
            this.A00.setAlpha(204);
        }
        C0535Le.A0P(this, 0);
        addView(this.A06);
        setGravity(17);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams((int) (((double) displayMetrics.density) * 72.0d), (int) (((double) displayMetrics.density) * 72.0d));
        layoutParams2.addRule(13);
        setLayoutParams(layoutParams2);
    }

    @Override // com.facebook.ads.redexgen.X.K6
    public final void A07() {
        super.A07();
        if (getVideoView() != null) {
            getVideoView().getEventBus().A04(this.A04, this.A05, this.A03);
        }
        setOnClickListener(new P9(this));
    }

    @Override // com.facebook.ads.redexgen.X.K6
    public final void A08() {
        setOnClickListener(null);
        if (getVideoView() != null) {
            getVideoView().getEventBus().A05(this.A03, this.A05, this.A04);
        }
        super.A08();
    }

    public final void onDraw(Canvas canvas) {
        int centerX = Math.min((getWidth() - getPaddingLeft()) - getPaddingRight(), (getHeight() - getPaddingTop()) - getPaddingBottom());
        int i = centerX / 2;
        canvas.drawCircle((float) (getPaddingLeft() + i), (float) (getPaddingTop() + (centerX / 2)), (float) i, this.A00);
        super.onDraw(canvas);
    }
}
