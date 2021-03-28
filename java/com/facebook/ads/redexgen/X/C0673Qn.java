package com.facebook.ads.redexgen.X;

/* renamed from: com.facebook.ads.redexgen.X.Qn  reason: case insensitive filesystem */
public class C0673Qn extends AbstractRunnableC0510Kc {
    public final /* synthetic */ C0672Qm A00;
    public final /* synthetic */ boolean A01;

    public C0673Qn(C0672Qm qm, boolean z) {
        this.A00 = qm;
        this.A01 = z;
    }

    @Override // com.facebook.ads.redexgen.X.AbstractRunnableC0510Kc
    public final void A07() {
        boolean z;
        M1 A08 = this.A00.A0E.A08();
        if (A08 != null) {
            if (this.A01 || A08.A07()) {
                z = false;
            } else {
                z = true;
            }
            A08.setPageDetailsVisible(z);
            A08.setToolbarActionMode(this.A00.getCloseButtonStyle());
        }
    }
}
