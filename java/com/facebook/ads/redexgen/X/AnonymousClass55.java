package com.facebook.ads.redexgen.X;

import android.view.View;

/* renamed from: com.facebook.ads.redexgen.X.55  reason: invalid class name */
public class AnonymousClass55 implements View.OnLongClickListener {
    public final /* synthetic */ C0731Sw A00;
    public final /* synthetic */ NS A01;

    public AnonymousClass55(C0731Sw sw, NS ns) {
        this.A00 = sw;
        this.A01 = ns;
    }

    public final boolean onLongClick(View view) {
        if (this.A00.A00 != null) {
            this.A01.setBounds(0, 0, this.A00.A00.getWidth(), this.A00.A00.getHeight());
            NS ns = this.A01;
            ns.A0E(!ns.A0F());
        }
        return true;
    }
}
