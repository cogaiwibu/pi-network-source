package com.facebook.ads.redexgen.X;

import android.view.View;

/* renamed from: com.facebook.ads.redexgen.X.Sf  reason: case insensitive filesystem */
public class C0716Sf implements AbstractC01224a {
    public final /* synthetic */ AnonymousClass4F A00;

    public C0716Sf(AnonymousClass4F r1) {
        this.A00 = r1;
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC01224a
    public final View A5d(int i) {
        return this.A00.A0u(i);
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC01224a
    public final int A5f(View view) {
        return this.A00.A0k(view) + ((AnonymousClass4G) view.getLayoutParams()).bottomMargin;
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC01224a
    public final int A5g(View view) {
        return this.A00.A0p(view) - ((AnonymousClass4G) view.getLayoutParams()).topMargin;
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC01224a
    public final int A6e() {
        return this.A00.A0Y() - this.A00.A0e();
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC01224a
    public final int A6f() {
        return this.A00.A0h();
    }
}
