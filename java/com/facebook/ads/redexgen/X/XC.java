package com.facebook.ads.redexgen.X;

import com.facebook.ads.internal.api.BuildConfigApi;

public class XC implements AnonymousClass8L {
    public final /* synthetic */ AnonymousClass8H A00;
    public final /* synthetic */ XG A01;

    public XC(XG xg, AnonymousClass8H r2) {
        this.A01 = xg;
        this.A00 = r2;
    }

    @Override // com.facebook.ads.redexgen.X.AnonymousClass8L
    public final String A6H() {
        return KJ.A04(this.A00);
    }

    @Override // com.facebook.ads.redexgen.X.AnonymousClass8L
    public final boolean A7X() {
        return BuildConfigApi.isDebug();
    }
}
