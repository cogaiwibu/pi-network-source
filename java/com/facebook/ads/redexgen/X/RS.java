package com.facebook.ads.redexgen.X;

import com.facebook.ads.AdError;

public class RS implements AnonymousClass79 {
    public final /* synthetic */ RU A00;

    public RS(RU ru) {
        this.A00 = ru;
    }

    private void A00(boolean z) {
        if (z) {
            this.A00.A03.A8m();
        } else {
            this.A00.A03.A8l(AdError.CACHE_ERROR);
        }
    }

    @Override // com.facebook.ads.redexgen.X.AnonymousClass79
    public final void A97() {
        A00(false);
    }

    @Override // com.facebook.ads.redexgen.X.AnonymousClass79
    public final void A9E() {
        A00(true);
    }
}
