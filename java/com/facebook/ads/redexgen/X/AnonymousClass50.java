package com.facebook.ads.redexgen.X;

import android.view.View;

/* renamed from: com.facebook.ads.redexgen.X.50  reason: invalid class name */
public class AnonymousClass50 implements View.OnLongClickListener {
    public final /* synthetic */ AnonymousClass51 A00;

    public AnonymousClass50(AnonymousClass51 r1) {
        this.A00 = r1;
    }

    public /* synthetic */ AnonymousClass50(AnonymousClass51 r1, C01454x r2) {
        this(r1);
    }

    public final boolean onLongClick(View view) {
        if (!(this.A00.A0B == null || this.A00.A06 == null)) {
            this.A00.A0B.setBounds(0, 0, this.A00.A06.getWidth(), this.A00.A06.getHeight());
            this.A00.A0B.A0E(!this.A00.A0B.A0F());
        }
        return true;
    }
}
