package com.facebook.ads.redexgen.X;

import android.view.View;
import android.view.WindowInsets;

/* renamed from: com.facebook.ads.redexgen.X.2s  reason: invalid class name and case insensitive filesystem */
public class View$OnApplyWindowInsetsListenerC00912s implements View.OnApplyWindowInsetsListener {
    public final /* synthetic */ AbstractC00772e A00;
    public final /* synthetic */ C00220b A01;

    public View$OnApplyWindowInsetsListenerC00912s(C00220b r1, AbstractC00772e r2) {
        this.A01 = r1;
        this.A00 = r2;
    }

    public final WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
        return (WindowInsets) AnonymousClass3B.A01(this.A00.A8s(view, AnonymousClass3B.A00(windowInsets)));
    }
}
