package com.facebook.ads.redexgen.X;

import android.view.View;

/* renamed from: com.facebook.ads.redexgen.X.Se  reason: case insensitive filesystem */
public class C0715Se implements AbstractC01224a {
    public final /* synthetic */ AnonymousClass4F A00;

    public C0715Se(AnonymousClass4F r1) {
        this.A00 = r1;
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC01224a
    public final View A5d(int i) {
        return this.A00.A0u(i);
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC01224a
    public final int A5f(View view) {
        return this.A00.A0o(view) + ((AnonymousClass4G) view.getLayoutParams()).rightMargin;
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC01224a
    public final int A5g(View view) {
        return this.A00.A0l(view) - ((AnonymousClass4G) view.getLayoutParams()).leftMargin;
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC01224a
    public final int A6e() {
        return this.A00.A0i() - this.A00.A0g();
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC01224a
    public final int A6f() {
        return this.A00.A0f();
    }
}
