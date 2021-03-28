package com.facebook.ads.redexgen.X;

import com.facebook.ads.AdError;

/* renamed from: com.facebook.ads.redexgen.X.Ey  reason: case insensitive filesystem */
public class C0382Ey extends RY {
    public final /* synthetic */ C0381Ex A00;
    public final /* synthetic */ RM A01;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public C0382Ey(C0381Ex ex, boolean z, RM rm) {
        super(z);
        this.A00 = ex;
        this.A01 = rm;
    }

    @Override // com.facebook.ads.redexgen.X.RY
    public final void A00() {
        this.A00.A01.AAs(this.A01, AdError.CACHE_ERROR);
    }

    @Override // com.facebook.ads.redexgen.X.RY
    public final void A01(boolean z) {
        this.A00.A0B.set(true);
        this.A00.A01.AAp(this.A01);
    }
}
