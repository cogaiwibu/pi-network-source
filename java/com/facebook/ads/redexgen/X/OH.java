package com.facebook.ads.redexgen.X;

import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.facebook.internal.FacebookRequestErrorClassification;
import com.ironsource.mediationsdk.utils.IronSourceConstants;

public final class OH extends LinearLayout {
    public static final int A05 = ((int) (C0535Le.A01 * 72.0f));
    public static final int A06 = ((int) (C0535Le.A01 * 8.0f));
    public static final int A07 = ((int) (C0535Le.A01 * 16.0f));
    public static final int A08 = ((int) (C0535Le.A01 * 16.0f));
    @Nullable
    public LinearLayout A00;
    public final int A01;
    public final C0820Wh A02;
    public final C0587Nf A03;
    public final C0593Nl A04;

    public OH(OF of) {
        super(OF.A04(of));
        this.A02 = OF.A04(of);
        this.A03 = new C0587Nf(this.A02);
        this.A04 = new C0593Nl(this.A02, OF.A02(of), true, false, true);
        this.A01 = OF.A00(of);
        A03(of);
    }

    public /* synthetic */ OH(OF of, C0643Pj pj) {
        this(of);
    }

    private void A00() {
        A01(this.A03, IronSourceConstants.REWARDED_VIDEO_DAILY_CAPPED);
        A01(this.A04, 170);
        LinearLayout linearLayout = this.A00;
        if (linearLayout != null) {
            A01(linearLayout, FacebookRequestErrorClassification.EC_INVALID_TOKEN);
        }
    }

    private void A01(View view, int i) {
        view.setTranslationY((float) i);
        view.setScaleY(0.75f);
        view.setScaleX(0.75f);
        view.animate().translationYBy((float) (-i)).scaleX(1.0f).scaleY(1.0f).setDuration(300).setInterpolator(new DecelerateInterpolator(2.0f));
    }

    private void A02(OF of) {
        if (!TextUtils.isEmpty(OF.A05(of))) {
            this.A00 = new LinearLayout(getContext());
            this.A00.setGravity(17);
            LinearLayout linearLayout = this.A00;
            int i = A08;
            linearLayout.setPadding(i, i / 2, i, i / 2);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.setMargins(0, A08 / 2, 0, 0);
            TextView textView = new TextView(getContext());
            textView.setTextColor(-1);
            C0535Le.A0b(textView, false, 16);
            textView.setText(OF.A05(of));
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
            ImageView imageView = new ImageView(getContext());
            new AsyncTaskC0831Ws(imageView, this.A02).A05().A08(OF.A06(of));
            int i2 = A07;
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(i2, i2);
            layoutParams3.setMargins(0, 0, A08 / 2, 0);
            this.A00.addView(imageView, layoutParams3);
            this.A00.addView(textView, layoutParams2);
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setCornerRadius(100.0f);
            gradientDrawable.setColor(469762047);
            C0535Le.A0W(this.A00, gradientDrawable);
            addView(this.A00, layoutParams);
        }
    }

    private void A03(OF of) {
        C0535Le.A0P(this.A03, 0);
        this.A03.setRadius(50);
        if (OF.A01(of).A00() == AnonymousClass1E.A05) {
            this.A03.setFullCircleCorners(true);
        } else {
            this.A03.setRadius(A06);
        }
        new AsyncTaskC0831Ws(this.A03, this.A02).A05().A08(OF.A03(of).A01());
        this.A04.A02(OF.A01(of).A06(), OF.A03(of).A03(), null, false, true);
        this.A04.getDescriptionTextView().setAlpha(0.8f);
        this.A04.setAlignment(17);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        int i = A08;
        layoutParams.setMargins(0, i, 0, i / 2);
        View view = this.A03;
        int i2 = A05;
        addView(view, new LinearLayout.LayoutParams(i2, i2));
        addView(this.A04, layoutParams);
        A02(of);
        C0535Le.A0P(this, -14473425);
        setGravity(17);
        setOrientation(1);
    }

    public final void A04(OG og) {
        A00();
        postDelayed(new C0643Pj(this, og), (long) this.A01);
    }
}
