package com.facebook.ads.redexgen.X;

/* renamed from: com.facebook.ads.redexgen.X.Tj  reason: case insensitive filesystem */
public class C0744Tj implements AbstractC01816i {
    public final /* synthetic */ C0747Tm A00;

    public C0744Tj(C0747Tm tm) {
        this.A00 = tm;
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC01816i
    public final AbstractC01966x A50() {
        if (this.A00.A01 == null) {
            return this.A00.A08(EnumC01926t.A07);
        }
        C0747Tm tm = this.A00;
        return tm.A05(tm.A01.importance);
    }
}
