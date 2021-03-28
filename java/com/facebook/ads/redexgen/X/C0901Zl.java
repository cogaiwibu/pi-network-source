package com.facebook.ads.redexgen.X;

/* renamed from: com.facebook.ads.redexgen.X.Zl  reason: case insensitive filesystem */
public class C0901Zl implements AbstractC01474z {
    public final /* synthetic */ C0898Zi A00;

    public C0901Zl(C0898Zi zi) {
        this.A00 = zi;
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC01474z
    public final boolean A7U() {
        if (!this.A00.A0B.canGoBack()) {
            return false;
        }
        this.A00.A0B.goBack();
        return true;
    }
}
