package com.facebook.ads.redexgen.X;

import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.annotation.Nullable;
import androidx.core.view.GravityCompat;

/* renamed from: com.facebook.ads.redexgen.X.Nj  reason: case insensitive filesystem */
public final class C0591Nj extends NX {
    public static final int A04 = ((int) (C0535Le.A01 * 12.0f));
    public static final int A05 = ((int) (C0535Le.A01 * 16.0f));
    public int A00;
    public boolean A01;
    public boolean A02 = false;
    public final C0593Nl A03;

    public C0591Nj(C0820Wh wh, int i, AnonymousClass1H r19, JE je, M6 m6, boolean z, boolean z2, C0641Ph ph, LX lx, boolean z3) {
        super(wh, i, r19, EnumC0628Ou.A04.A02(), je, m6, ph, lx);
        boolean z4;
        boolean z5;
        boolean z6;
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(i, i);
        layoutParams.addRule(9);
        layoutParams.setMargins(0, 0, A04, 0);
        if (z2) {
            this.A04.setVisibility(8);
        }
        this.A00 = C0535Le.A03(wh);
        this.A01 = z3;
        if (this.A00 == 2) {
            z4 = true;
        } else {
            z4 = false;
        }
        if (!z4 || !this.A01) {
            z5 = false;
        } else {
            z5 = true;
        }
        if (z5 || z) {
            z6 = true;
        } else {
            z6 = false;
        }
        this.A03 = new C0593Nl(wh, r19, true, z6, true);
        this.A03.setUseNewLandscapeEndCard(this.A01);
        this.A03.setAlignment(GravityCompat.START);
        if (J8.A1L(super.A02)) {
            this.A03.setDescriptionVisibility(8);
        }
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(1, this.A04.getId());
        if (!this.A01) {
            layoutParams.addRule(15);
            layoutParams2.addRule(15);
        }
        super.A01.addView(this.A04, layoutParams);
        super.A01.addView(this.A03, layoutParams2);
        if (z5) {
            addView(super.A01, new LinearLayout.LayoutParams(-2, -1, 0.7f));
            return;
        }
        addView(super.A01, new LinearLayout.LayoutParams(-2, -2));
        GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{0, -15658735});
        gradientDrawable.setCornerRadius(0.0f);
        C0535Le.A0W(this, gradientDrawable);
    }

    @Override // com.facebook.ads.redexgen.X.NX
    public final void A0D(int i) {
        boolean z;
        int i2;
        LinearLayout.LayoutParams layoutParams;
        C0535Le.A0M(super.A03);
        int i3 = 1;
        if (i == 1) {
            z = true;
        } else {
            z = false;
        }
        int i4 = -1;
        if (this.A01) {
            this.A00 = i;
            setOrientation(1);
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
            if (!this.A02 || z) {
                GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{0, -15658735});
                gradientDrawable.setCornerRadius(0.0f);
                C0535Le.A0W(this, gradientDrawable);
            } else {
                layoutParams2.weight = 0.7f;
                setBackgroundResource(0);
                C0535Le.A0P(this, -447721392);
            }
            super.A01.setLayoutParams(layoutParams2);
            layoutParams = new LinearLayout.LayoutParams(-1, -2);
            layoutParams.setMargins(0, A05, 0, 0);
            bringToFront();
        } else {
            if (!z) {
                i3 = 0;
            }
            setOrientation(i3);
            if (z) {
                i2 = -1;
            } else {
                i2 = 0;
            }
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(i2, -2);
            layoutParams3.weight = 1.0f;
            super.A01.setLayoutParams(layoutParams3);
            if (!z) {
                i4 = -2;
            }
            layoutParams = new LinearLayout.LayoutParams(i4, -2);
            layoutParams.setMargins(z ? 0 : A05, z ? A05 : 0, 0, 0);
        }
        layoutParams.gravity = 80;
        addView(super.A03, layoutParams);
    }

    @Override // com.facebook.ads.redexgen.X.NX
    public final void A0E(boolean z) {
        this.A02 = z;
    }

    @Override // com.facebook.ads.redexgen.X.NX
    public void setInfo(AnonymousClass1G r11, AnonymousClass1I r12, String str, String str2, @Nullable AbstractC0582Na na) {
        super.setInfo(r11, r12, str, str2, na);
        this.A03.A02(r11.A06(), r11.A05(), null, false, false);
        if (TextUtils.isEmpty(r12.A03())) {
            C0535Le.A0K(super.A03);
        }
    }
}
