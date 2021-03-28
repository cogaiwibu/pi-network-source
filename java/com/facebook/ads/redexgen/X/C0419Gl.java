package com.facebook.ads.redexgen.X;

import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Nullable;

/* renamed from: com.facebook.ads.redexgen.X.Gl  reason: case insensitive filesystem */
public final class C0419Gl implements PE {
    public int A00;
    @Nullable
    public ValueAnimator A01;
    public PD A02 = PD.A05;
    public final int A03;
    public final int A04;
    public final View A05;

    public C0419Gl(View view, int i, int i2, int i3) {
        this.A05 = view;
        this.A03 = i;
        this.A00 = i2;
        this.A04 = i3;
    }

    private ValueAnimator A00(int i, int i2, View view) {
        ValueAnimator ofInt = ValueAnimator.ofInt(i, i2);
        ofInt.setDuration((long) this.A03);
        ofInt.addUpdateListener(new PH(this, view));
        return ofInt;
    }

    /* access modifiers changed from: private */
    public void A07(boolean z) {
        if (z) {
            this.A02 = PD.A06;
            this.A01 = A00(this.A00, this.A04, this.A05);
            this.A01.addListener(new PG(this));
            this.A01.start();
            return;
        }
        ViewGroup.LayoutParams layoutParams = this.A05.getLayoutParams();
        layoutParams.height = this.A04;
        this.A05.setLayoutParams(layoutParams);
        C0535Le.A0K(this.A05);
        this.A02 = PD.A05;
    }

    /* access modifiers changed from: private */
    public void A08(boolean z) {
        C0535Le.A0O(this.A05);
        if (z) {
            this.A02 = PD.A04;
            this.A01 = A00(this.A04, this.A00, this.A05);
            this.A01.addListener(new PF(this));
            this.A01.start();
            return;
        }
        ViewGroup.LayoutParams layoutParams = this.A05.getLayoutParams();
        layoutParams.height = this.A00;
        this.A05.setLayoutParams(layoutParams);
        this.A02 = PD.A03;
    }

    public final void A09(int i) {
        this.A00 = i;
    }

    @Override // com.facebook.ads.redexgen.X.PE
    public final void A3O(boolean z, boolean z2) {
        if (z2) {
            A07(z);
        } else {
            A08(z);
        }
    }

    @Override // com.facebook.ads.redexgen.X.PE
    public final PD A71() {
        return this.A02;
    }

    @Override // com.facebook.ads.redexgen.X.PE
    public final void cancel() {
        ValueAnimator valueAnimator = this.A01;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
    }
}
