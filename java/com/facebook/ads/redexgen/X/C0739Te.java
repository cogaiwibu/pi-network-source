package com.facebook.ads.redexgen.X;

/* renamed from: com.facebook.ads.redexgen.X.Te  reason: case insensitive filesystem */
public class C0739Te implements AbstractC01816i {
    public final /* synthetic */ C0747Tm A00;

    public C0739Te(C0747Tm tm) {
        this.A00 = tm;
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC01816i
    public final AbstractC01966x A50() {
        if (this.A00.A00 == null) {
            return this.A00.A08(EnumC01926t.A07);
        }
        C0747Tm tm = this.A00;
        return tm.A09(tm.A00.getGlEsVersion());
    }
}
