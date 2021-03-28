package com.facebook.ads.redexgen.X;

/* renamed from: com.facebook.ads.redexgen.X.Qc  reason: case insensitive filesystem */
public class C0662Qc implements L3 {
    public final /* synthetic */ int A00;
    public final /* synthetic */ AbstractRunnableC0510Kc A01;
    public final /* synthetic */ QZ A02;

    public C0662Qc(QZ qz, int i, AbstractRunnableC0510Kc kc) {
        this.A02 = qz;
        this.A00 = i;
        this.A01 = kc;
    }

    @Override // com.facebook.ads.redexgen.X.L3
    public final void A9D() {
        this.A01.run();
    }

    @Override // com.facebook.ads.redexgen.X.L3
    public final void AAc(float f) {
        this.A02.A07.setProgress(100.0f * (1.0f - (f / ((float) this.A00))));
    }
}
