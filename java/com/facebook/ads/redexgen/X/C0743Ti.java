package com.facebook.ads.redexgen.X;

/* renamed from: com.facebook.ads.redexgen.X.Ti  reason: case insensitive filesystem */
public class C0743Ti implements AbstractC01816i {
    public final /* synthetic */ C0747Tm A00;

    public C0743Ti(C0747Tm tm) {
        this.A00 = tm;
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC01816i
    public final AbstractC01966x A50() {
        if (this.A00.A00 == null) {
            return this.A00.A08(EnumC01926t.A07);
        }
        C0747Tm tm = this.A00;
        return tm.A05(tm.A00.reqTouchScreen);
    }
}
