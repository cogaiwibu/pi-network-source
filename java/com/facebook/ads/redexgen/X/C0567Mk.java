package com.facebook.ads.redexgen.X;

import android.graphics.drawable.GradientDrawable;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;

/* renamed from: com.facebook.ads.redexgen.X.Mk  reason: case insensitive filesystem */
public final class C0567Mk extends LinearLayout {
    public static final int A03 = ((int) (C0535Le.A01 * 16.0f));
    public static final int A04 = ((int) (C0535Le.A01 * 16.0f));
    public static final int A05 = ((int) (C0535Le.A01 * 12.0f));
    public static final int A06 = ((int) (C0535Le.A01 * 12.0f));
    public boolean A00 = false;
    public final ImageView A01;
    public final TextView A02;

    public C0567Mk(C0820Wh wh) {
        super(wh);
        setOrientation(0);
        int i = A04;
        int i2 = A05;
        setPadding(i, i2, i, i2);
        this.A01 = new ImageView(getContext());
        int i3 = A03;
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i3, i3);
        layoutParams.gravity = 17;
        this.A02 = new TextView(getContext());
        ViewGroup.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        addView(this.A01, layoutParams);
        addView(this.A02, layoutParams2);
        A00();
    }

    private void A00() {
        int i;
        int textColor;
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        if (this.A00) {
            i = -13272859;
        } else {
            i = -1315344;
        }
        gradientDrawable.setColor(i);
        gradientDrawable.setCornerRadius(50.0f);
        C0535Le.A0W(this, gradientDrawable);
        C0535Le.A0b(this.A02, false, 14);
        if (this.A00) {
            textColor = -1;
        } else {
            textColor = -10459280;
        }
        this.A02.setTextColor(textColor);
        this.A01.setColorFilter(textColor);
    }

    public final void A01() {
        setSelected(!this.A00);
    }

    public void setData(String str, @Nullable EnumC0543Lm lm) {
        this.A02.setText(str);
        if (lm != null) {
            this.A01.setImageBitmap(C0544Ln.A00(lm));
            this.A01.setVisibility(0);
            this.A02.setPadding(A06, 0, 0, 0);
        } else {
            this.A01.setVisibility(8);
            this.A02.setPadding(0, 0, 0, 0);
        }
        A00();
    }

    public void setSelected(boolean z) {
        this.A00 = z;
        A00();
    }
}
