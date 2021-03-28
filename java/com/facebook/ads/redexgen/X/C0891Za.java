package com.facebook.ads.redexgen.X;

/* renamed from: com.facebook.ads.redexgen.X.Za  reason: case insensitive filesystem */
public class C0891Za implements L3 {
    public final /* synthetic */ int A00;
    public final /* synthetic */ ZY A01;

    public C0891Za(ZY zy, int i) {
        this.A01 = zy;
        this.A00 = i;
    }

    @Override // com.facebook.ads.redexgen.X.L3
    public final void A9D() {
        this.A01.A03 = false;
        this.A01.A0P();
        this.A01.A0C.setToolbarActionMode(this.A01.getCloseButtonStyle());
    }

    @Override // com.facebook.ads.redexgen.X.L3
    public final void AAc(float f) {
        this.A01.A0C.setProgress(100.0f * (1.0f - (f / ((float) this.A00))));
    }
}
