package com.facebook.ads.redexgen.X;

import com.facebook.ads.internal.protocol.AdErrorType;
import java.util.Map;

/* renamed from: com.facebook.ads.redexgen.X.Rf  reason: case insensitive filesystem */
public class C0691Rf extends AbstractRunnableC0510Kc {
    public final /* synthetic */ RE A00;
    public final /* synthetic */ C0377Et A01;
    public final /* synthetic */ Map A02;

    public C0691Rf(C0377Et et, Map map, RE re) {
        this.A01 = et;
        this.A02 = map;
        this.A00 = re;
    }

    @Override // com.facebook.ads.redexgen.X.AbstractRunnableC0510Kc
    public final void A07() {
        this.A01.A0V(this.A02);
        this.A01.A0P(this.A00);
        if (J8.A0j(this.A01.A0C)) {
            this.A01.A01 = null;
            C0495Jm jm = new C0495Jm(AdErrorType.INTERSTITIAL_AD_TIMEOUT, "");
            this.A01.A0C.A0A().A4Y(jm.A04().getErrorCode(), jm.A05());
            this.A01.A07.A0F(jm);
            return;
        }
        this.A01.A0O();
    }
}
