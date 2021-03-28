package com.facebook.ads.redexgen.X;

/* renamed from: com.facebook.ads.redexgen.X.bA  reason: case insensitive filesystem */
public class C0984bA extends AbstractRunnableC0510Kc {
    public final /* synthetic */ C0985bB A00;

    public C0984bA(C0985bB bBVar) {
        this.A00 = bBVar;
    }

    @Override // com.facebook.ads.redexgen.X.AbstractRunnableC0510Kc
    public final void A07() {
        this.A00.A0C = false;
        if (this.A00.A0B.getQueue().isEmpty()) {
            this.A00.A0B.execute(this.A00.A0A);
        }
    }
}
