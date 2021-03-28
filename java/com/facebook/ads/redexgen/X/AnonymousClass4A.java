package com.facebook.ads.redexgen.X;

import android.view.View;

/* renamed from: com.facebook.ads.redexgen.X.4A  reason: invalid class name */
public class AnonymousClass4A {
    public int A00;
    public int A01;
    public int A02;
    public int A03;

    private final AnonymousClass4A A00(AnonymousClass4X r3, int i) {
        View view = r3.A0H;
        this.A01 = view.getLeft();
        this.A03 = view.getTop();
        this.A02 = view.getRight();
        this.A00 = view.getBottom();
        return this;
    }

    public final AnonymousClass4A A01(AnonymousClass4X r2) {
        return A00(r2, 0);
    }
}
