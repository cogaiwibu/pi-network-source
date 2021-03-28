package com.facebook.ads.redexgen.X;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.ViewGroup;

/* renamed from: com.facebook.ads.redexgen.X.4G  reason: invalid class name */
public class AnonymousClass4G extends ViewGroup.MarginLayoutParams {
    public AnonymousClass4X A00;
    public boolean A01 = true;
    public boolean A02 = false;
    public final Rect A03 = new Rect();

    public AnonymousClass4G(int i, int i2) {
        super(i, i2);
    }

    public AnonymousClass4G(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public AnonymousClass4G(ViewGroup.LayoutParams layoutParams) {
        super(layoutParams);
    }

    public AnonymousClass4G(ViewGroup.MarginLayoutParams marginLayoutParams) {
        super(marginLayoutParams);
    }

    public AnonymousClass4G(AnonymousClass4G r2) {
        super((ViewGroup.LayoutParams) r2);
    }

    public final int A00() {
        return this.A00.A0J();
    }

    public final boolean A01() {
        return this.A00.A0g();
    }

    public final boolean A02() {
        return this.A00.A0d();
    }

    public final boolean A03() {
        return this.A00.A0c();
    }
}
