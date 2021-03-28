package com.facebook.ads.redexgen.X;

import com.facebook.ads.NativeAd;
import java.util.List;

public class T9 implements AnonymousClass79 {
    public final List<RG> A00;
    public final /* synthetic */ TA A01;

    public T9(TA ta, List<RG> list) {
        this.A01 = ta;
        this.A00 = list;
    }

    private void A00() {
        this.A01.A00.A07(true);
        this.A01.A00.A04();
        this.A01.A00.A05(0);
        for (RG rg : this.A00) {
            this.A01.A00.A06(new NativeAd(this.A01.A01, new C1007bZ(this.A01.A01, rg, null, C1007bZ.A0I(), this.A01.A00.A03())));
        }
        KT.A00(new T8(this));
    }

    @Override // com.facebook.ads.redexgen.X.AnonymousClass79
    public final void A97() {
        A00();
    }

    @Override // com.facebook.ads.redexgen.X.AnonymousClass79
    public final void A9E() {
        A00();
    }
}
