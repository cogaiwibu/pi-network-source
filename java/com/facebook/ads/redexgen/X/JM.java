package com.facebook.ads.redexgen.X;

import android.view.View;

public class JM implements View.OnAttachStateChangeListener {
    public final /* synthetic */ JK A00;
    public final /* synthetic */ JL A01;

    public JM(JL jl, JK jk) {
        this.A01 = jl;
        this.A00 = jk;
    }

    public final void onViewAttachedToWindow(View view) {
        this.A01.A03(this.A00, null);
    }

    public final void onViewDetachedFromWindow(View view) {
    }
}
