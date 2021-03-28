package com.facebook.ads.redexgen.X;

/* renamed from: com.facebook.ads.redexgen.X.Rw  reason: case insensitive filesystem */
public class C0708Rw extends AbstractC00350o {
    public final /* synthetic */ C0710Ry A00;

    public C0708Rw(C0710Ry ry) {
        this.A00 = ry;
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC00350o
    public final void A05() {
        this.A00.A05.onRewardServerFailed();
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC00350o
    public final void A06() {
        this.A00.A05.onRewardServerSuccess();
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC00350o
    public final void A07() {
        this.A00.A05.onRewardedVideoCompleted();
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC00350o
    public final void A08() {
        this.A00.A05.onRewardedVideoActivityDestroyed();
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC00350o
    public final void A09() {
        this.A00.A05.onRewardedVideoClosed();
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC00350o
    public final void A0B() {
        this.A00.A05.onAdClicked(this.A00.A06.A01());
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC00350o
    public final void A0C() {
        this.A00.A05.onLoggingImpression(this.A00.A06.A01());
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC00350o
    public final void A0E(AbstractC00340n r3) {
        C0710Ry ry = this.A00;
        ry.A03 = ry.A02.A0I();
        RM rm = (RM) r3;
        if (this.A00.A06.A03 != null) {
            rm.A01(this.A00.A06.A03);
        }
        this.A00.A06.A00 = rm.A0B();
        this.A00.A04 = true;
        this.A00.A05.onAdLoaded(this.A00.A06.A01());
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC00350o
    public final void A0F(C0495Jm jm) {
        this.A00.A0A(true);
        this.A00.A06.A0B.A0A().A2d(LW.A01(this.A00.A01), jm.A04().getErrorCode(), jm.A05());
        this.A00.A05.onError(this.A00.A06.A01(), C0495Jm.A00(jm));
    }
}
