package com.facebook.ads.redexgen.X;

import com.facebook.ads.AdError;

public class RH implements AbstractC00531g {
    public final /* synthetic */ C0381Ex A00;
    public final /* synthetic */ RM A01;

    public RH(C0381Ex ex, RM rm) {
        this.A00 = ex;
        this.A01 = rm;
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC00531g
    public final void AAR(AdError adError) {
        this.A00.A01.AAs(this.A01, adError);
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC00531g
    public final void AAS() {
        this.A00.A0B.set(true);
        this.A00.A01.AAp(this.A01);
    }
}
