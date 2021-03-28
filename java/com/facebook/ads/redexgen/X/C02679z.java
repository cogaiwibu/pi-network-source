package com.facebook.ads.redexgen.X;

import android.graphics.PointF;
import android.util.DisplayMetrics;
import android.view.View;

/* renamed from: com.facebook.ads.redexgen.X.9z  reason: invalid class name and case insensitive filesystem */
public class C02679z extends SX {
    public final /* synthetic */ C02659x A00;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public C02679z(C02659x r1, C0820Wh wh) {
        super(wh);
        this.A00 = r1;
    }

    @Override // com.facebook.ads.redexgen.X.SX
    public final float A0K(DisplayMetrics displayMetrics) {
        return this.A00.A00 / ((float) displayMetrics.densityDpi);
    }

    @Override // com.facebook.ads.redexgen.X.SX
    public final int A0L() {
        return -1;
    }

    @Override // com.facebook.ads.redexgen.X.SX
    public final int A0P(View view, int left) {
        AnonymousClass4F A09 = A09();
        if (!A09.A25()) {
            return 0;
        }
        AnonymousClass4G r1 = (AnonymousClass4G) view.getLayoutParams();
        return A0O(A09.A0l(view) - r1.leftMargin, A09.A0o(view) + r1.rightMargin, A09.A0f(), A09.A0i() - A09.A0g(), left) + this.A00.A02;
    }

    @Override // com.facebook.ads.redexgen.X.SX
    public final PointF A0Q(int i) {
        return this.A00.A45(i);
    }
}
